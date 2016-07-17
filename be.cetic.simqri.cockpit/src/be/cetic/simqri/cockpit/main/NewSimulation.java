package be.cetic.simqri.cockpit.main;

import java.util.ArrayList;


import javax.swing.JOptionPane;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

import be.cetic.simqri.cockpit.tracer.MonteCarloTracer;
import be.cetic.simqri.cockpit.tracer.OneShotTracer;
import be.cetic.simqri.cockpit.util.JsonFormat;
import be.cetic.simqri.cockpit.views.ResultsWindow;
import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.metamodel.Query;
import be.cetic.simqri.simulator.mapping.SimQRiSirius;
import be.cetic.simqri.simulator.mapping.Tools;
import oscar.des.engine.SimControl;
import oscar.des.logger.SamplingTuple;
import oscar.des.logger.TraceLogger;
import scala.Tuple2;
import scala.collection.Iterator;

/**
 * 
 * @author FK
 * 
 * Entity that manages the simulation progress using the new management cockpit
 */
public class NewSimulation implements Runnable {
	
	private SimQRiSirius simulation;
	private Model model;
	private String type;
	private int timeUnits;
	private int maxIterations;
	private SimControl simControl;
	
	public NewSimulation(String type, int timeUnits, int maxIterations, Model model) {
		super();
		this.type = type;
		this.timeUnits = timeUnits;
		this.maxIterations = maxIterations;
		this.model = model;
		this.simControl = new SimControl();
	}

	public Model getModel() {
		return this.model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTimeUnits() {
		return this.timeUnits;
	}

	public void setTimeUnits(int timeUnits) {
		this.timeUnits = timeUnits;
	}
	
	public int getLoading() {
		if(this.simulation==null) // Le thread qui récupère cette val peut être exec avant que la simulation ne soit init
			return 0;
		else if(this.type.equals("Monte-Carlo"))
			return this.simulation.loading(); // = nombre d'itérations effectuées a cet instant
		else 
			return (int) simControl.curTime(); // return 100;
	}

	public int getMaxIterations() {
		return this.maxIterations;
	}

	public void setMaxIterations(int maxIterations) {
		this.maxIterations = maxIterations;
	}

	public boolean isAborded() {
		if(this.simulation==null) // Le thread qui récupère cette val peut être exec avant que la simulation ne soit init
			return false;
		else if(this.type.equals("Monte-Carlo"))
			return this.simulation.mcAborted();
		else
			return simControl.aborted();
	}

	public void setAborded(boolean aborded) {
		if(this.type.equals("Monte-Carlo"))
			this.simulation.mcAborted_$eq(aborded); // interrompt la boucle de simulation MC
		else
			simControl.aborted_$eq(aborded);
	}
	
	public void setSimulation(SimQRiSirius simulation) {
		this.simulation = simulation;
	}
	
	@Override
	public void run() { // thread d'exécution de la simulation (data mapping + API OscaR)
		TraceLogger sqlogger = new TraceLogger();
		sqlogger.reset();
		Tools t = new Tools();
		if(type.equals("One Shot")) {
			this.setSimulation(new SimQRiSirius(timeUnits, true, sqlogger, false)); 
			ArrayList<String> errQueries = simulation.fillModelWithSiriusData(model);
			if(errQueries.isEmpty()) {
				simulation.simulateOneShot(this.simControl);
				if(!this.isAborded()) {
					// Instance of the object that will store "One Shot" simulation results and transphorm them to strings for the display
					OneShotTracer ost = new OneShotTracer();
					// Passing simulation results to our own tracer
					ost.setEvents(t.eventsToJavaMap(sqlogger));
					ost.setMapInfos(t.mapInfosToJavaMap(sqlogger));
					ost.setProbes(sqlogger.logs().probes());
					ost.setRawInfos(sqlogger.logs().rawInfos());
					
					setQueriesResult(sqlogger, model);

					new ResultsWindow(ost);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "The simulation will not be launchable due to some errors in your queries : \n", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(type.equals("Monte-Carlo")) {
			this.setSimulation(new SimQRiSirius(timeUnits, true, sqlogger, true));
			ArrayList<String> errQueries = simulation.fillModelWithSiriusData(model);
			if(errQueries.isEmpty()) {
				simulation.simulateMonteCarlo(maxIterations, this.simControl); // simControl useless here... For the moment ?
				if(!this.isAborded()) {
					MonteCarloTracer mct = new MonteCarloTracer();
					mct.setElementsSampling(t.elementsSamplingsToJavaMap(sqlogger));
					mct.setRuntimeSampling(sqlogger.logs().mcSamplings().runtimeSampling());
					mct.setProbesSampling(sqlogger.logs().mcSamplings().probesSampling());
					mct.setHistorySampling(sqlogger.logs().mcSamplings().historySampling());
					
					setQueriesSamples(sqlogger, model);
					new ResultsWindow(mct);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "The simulation will not be launchable due to some errors in your queries : \n", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * 
	 * @param sqlogger "One Shot" simulation results
	 * @param model The instance of the SimQRi model
	 * 
	 * This method set simulation results to queries objects of the Sirius Metamodel instance. 
	 */
	private void setQueriesResult(TraceLogger sqlogger, Model model) {
		Iterator<Tuple2<String, String>> itProbes = sqlogger.logs().probes().iterator();
		while(itProbes.hasNext()) {
			Tuple2<String, String> probes = itProbes.next();
			String result = probes._2.toString().replaceAll("[^\\d.]", ""); // On ne garde que les valeurs numÃ©riques du rÃ©sultat
			double value = Double.parseDouble(result);
			for(Query q : model.getQuery()) {
				if(q.getName().equals(probes._1)) {
					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(q);
					domain.getCommandStack().execute(new RecordingCommand(domain) {
					   public void doExecute() {
						   q.setResult(String.format("%.2f", value)); 
						   // q.setMax("");
						   // q.setMin("");
						   // q.setMean("");
					       // q.setVariance("");
					   }
					});
				}
			}
		}
	}
	
	/**
	 * 
	 * @param sqlogger "Monte-Carlo" simulation results
	 * @param model The instance of the SimQRi model
	 * 
	 * This method set simulation results to queries objects of the Sirius Metamodel instance. 
	 */
	private void setQueriesSamples(TraceLogger sqlogger, Model model) {
		Iterator<SamplingTuple> itProbes = sqlogger.logs().mcSamplings().probesSampling().iterator();
		while(itProbes.hasNext()) {
			SamplingTuple probes = itProbes.next();
			for(Query q : model.getQuery()) {
				if(q.getName().equals(probes.name())) {
					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(q);
					domain.getCommandStack().execute(new RecordingCommand(domain) {
					   public void doExecute() {
						  // q.setResult("");
						  q.setMax(String.format("%.2f", JsonFormat.jsonToDouble(probes.samplingStr(), "max")));
						  q.setMin(String.format("%.2f", JsonFormat.jsonToDouble(probes.samplingStr(), "min")));
						  q.setMean(String.format("%.2f", JsonFormat.jsonToDouble(probes.samplingStr(), "mean")));
						  q.setVariance(String.valueOf(JsonFormat.jsonToDouble(probes.samplingStr(), "variance")));
					   }
					});
				}
			}
		}
	}

}

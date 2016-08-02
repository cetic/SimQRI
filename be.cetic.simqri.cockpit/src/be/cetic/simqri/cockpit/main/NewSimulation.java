package be.cetic.simqri.cockpit.main;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

import be.cetic.simqri.cockpit.reporting.ReportManager;
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
	// Mapping parameters
	private Model model;
	private String type;
	private int timeUnits;
	private int maxIterations;
	private SimControl simControl;
	private List<String> extensions; // .pdf, .docx, .html, etc. Retrieved from NewSimulationManagementWindow.java
	private boolean aborted;
	
	public NewSimulation(String type, int timeUnits, int maxIterations, Model model, List<String> extensions) {
		super();
		this.type = type;
		this.timeUnits = timeUnits;
		this.maxIterations = maxIterations;
		this.model = model;
		this.simControl = new SimControl();
		this.extensions = extensions;
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
		if(this.simulation==null) 
			// the thread that retrieve this value can be executed before the beginning of the simulation
			return 0;
		else if(this.type.equals("Monte-Carlo"))
			return this.simulation.loading(); 
			// = number of iterations processed at that time
		else 
			return (int) simControl.curTime();
	}

	public int getMaxIterations() {
		return this.maxIterations;
	}

	public void setMaxIterations(int maxIterations) {
		this.maxIterations = maxIterations;
	}

	public boolean isCanceled() {
		if(this.simulation==null)
			// the thread that retrieve this value can be executed before the beginning of the simulation
			return false;
		else if(this.type.equals("Monte-Carlo"))
			return this.simulation.mcAborted();
		else
			return simControl.aborted();
	}

	public void setCanceled(boolean canceled) {
		if(this.type.equals("Monte-Carlo"))
			this.simulation.mcAborted_$eq(canceled); // interrupt MC loop
		else
			simControl.aborted_$eq(canceled);
	}
	
	public void setSimulation(SimQRiSirius simulation) {
		this.simulation = simulation;
	}
	
	public boolean isAborted() {
		return aborted;
	}

	public void setAborted(boolean aborted) {
		this.aborted = aborted;
	}
	
	@Override
	public void run() { // simulation execution thread (data mapping + API OscaR)
		TraceLogger sqlogger = new TraceLogger();
		sqlogger.reset();
		Tools t = new Tools();
		if(type.equals("One Shot")) {
			this.setSimulation(new SimQRiSirius(timeUnits, true, sqlogger, false)); 
			simulation.fillModelWithSiriusData(model);
			simulation.simulateOneShot(this.simControl);
			int showResults = JOptionPane.YES_OPTION;
			if(this.isCanceled())
				showResults = JOptionPane.showConfirmDialog(null, "Simulation cancelled ! \nDo you wish to retrieve intermediate reports ?");
			if(showResults == JOptionPane.YES_OPTION) {
				Thread thread = new Thread(new Runnable(){
					public void run(){
						int abort = JOptionPane.showConfirmDialog(null,  "Results are being retrieved.\nThis operation may take a while...", "Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("simqri-reports/gifs/loader.gif"));
						if(abort == JOptionPane.CANCEL_OPTION) {
							JOptionPane.showMessageDialog(null,  "Process aborted !", "Warning", JOptionPane.WARNING_MESSAGE);
						    setAborted(true);
						}
					}
				});
				thread.start();
				
				// Instance of the object that will store "One Shot" simulation results
				OneShotTracer ost = new OneShotTracer();
				if(isAborted()) return;
				// Convert simulation results to java structures
				ost.setEvents(t.eventsToJavaMap(sqlogger));
				if(isAborted()) return;
				ost.setMapInfos(t.mapInfosToJavaMap(sqlogger));
				if(isAborted()) return;
				ost.setProbes(sqlogger.logs().probes());
				if(isAborted()) return;
				ost.setRawInfos(sqlogger.logs().rawInfos());
				if(isAborted()) return;
				this.setQueriesResult(sqlogger, model);
				if(isAborted()) return;
					
				new ResultsWindow(ost);
				thread.interrupt();
			}
			
		}
		else if(type.equals("Monte-Carlo")) {
			this.setSimulation(new SimQRiSirius(timeUnits, true, sqlogger, true));
			simulation.fillModelWithSiriusData(model);
			simulation.simulateMonteCarlo(maxIterations, this.simControl); // simControl useless here... For the moment ?
			int showResults = JOptionPane.YES_OPTION;
			if(this.isCanceled())
				showResults = JOptionPane.showConfirmDialog(null, "Simulation cancelled ! \nDo you wish to consult intermediate results ?");
			if(showResults == JOptionPane.YES_OPTION) {
				Thread thread = new Thread(new Runnable(){
					public void run(){
						int abort = JOptionPane.showConfirmDialog(null,  "Results are being retrieved.\nThis operation may take a while...", "Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("simqri-reports/gifs/loader.gif"));
						if(abort == JOptionPane.CANCEL_OPTION) {
							JOptionPane.showMessageDialog(null,  "Process aborted !", "Warning", JOptionPane.WARNING_MESSAGE);
							setAborted(true);
						}
					}
				});
				thread.start();
					
				// Instance of the object that will store "Monte-Carlo" simulation results and manage their XML mutation
				MonteCarloTracer mct = new MonteCarloTracer();
				if(isAborted()) return;
				// Convert simulation results to java structures
				mct.setElementsSampling(t.elementsSamplingsToJavaMap(sqlogger));
				if(isAborted()) return;
				mct.setRuntimeSampling(sqlogger.logs().mcSamplings().runtimeSampling());
				if(isAborted()) return;
				mct.setProbesSampling(sqlogger.logs().mcSamplings().probesSampling());
				if(isAborted()) return;
				mct.setHistorySampling(sqlogger.logs().mcSamplings().historySampling());
				if(isAborted()) return;
				mct.createMonteCarloXMLFile();
				if(isAborted()) return;
				this.setQueriesSamples(sqlogger, model);
				if(isAborted()) return;
				thread.interrupt();
					
				ReportManager reportManager = new ReportManager(extensions);
				try {
					reportManager.executeReport("Monte-Carlo");
				} catch (EngineException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//new ResultsWindow(mct);
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
			String result = probes._2.toString().replaceAll("[^\\d.]", ""); // On ne garde que les valeurs numériques du résultat
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

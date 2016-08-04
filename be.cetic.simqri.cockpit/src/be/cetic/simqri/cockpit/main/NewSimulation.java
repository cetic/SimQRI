package be.cetic.simqri.cockpit.main;

import java.util.List;


import javax.swing.JOptionPane;

import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

import be.cetic.simqri.cockpit.reporting.ReportManager;
import be.cetic.simqri.cockpit.tracer.MonteCarloTracer;
import be.cetic.simqri.cockpit.tracer.OneShotTracer;
import be.cetic.simqri.cockpit.util.JsonFormat;
import be.cetic.simqri.cockpit.views.LoaderWindow;
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
 * @version 2.0
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
	private int retrieveResultsStatus;
	
	// One Shot Constructor
	public NewSimulation(Model model, int timeUnits) {
		this.type = "One Shot";
		this.model = model;
		this.timeUnits = timeUnits;
		this.simControl = new SimControl();
	}
	
	// Monte-Carlo Constructor 
	public NewSimulation(Model model, int timeUnits, int maxIterations, List<String> extensions) {
		this.type = "Monte-Carlo";
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
		Tools tools = new Tools();
		if(type.equals("One Shot")) {
			this.setSimulation(new SimQRiSirius(timeUnits, true, sqlogger, false)); 
			simulation.fillModelWithSiriusData(model);
			simulation.simulateOneShot(this.simControl);
			int showResults = JOptionPane.YES_OPTION;
			if(this.isCanceled())
				showResults = JOptionPane.showConfirmDialog(null, "Simulation cancelled ! \nDo you wish to retrieve intermediate reports ?");
			if(showResults == JOptionPane.YES_OPTION) {
				// Thread that manages the loader window behaviour
				this.setAborted(false); // aborted var re used for the retrieval of simulation results !
				this.retrieveResultsStatus = 0;
				Thread t = new Thread(new Runnable(){
			        public void run(){
			        	LoaderWindow lw = new LoaderWindow(4, "Results retrieval", "This operation may take a while...",
			        			"Operation aborted !");
			        	while(lw.isEnabled()) {
			        		lw.setJpbStatus(retrieveResultsStatus);
			        		if(lw.getJpbStatus() == 4) {
			        			lw.dispose();
			        		}
			        		else if(lw.isAborted()) {
			        			setAborted(true);
			        			lw.dispose();
			        		}
			        	}
			        }
			    });
				t.start();
				
				// Instance of the object that will store "One Shot" simulation results
				OneShotTracer ost = new OneShotTracer();
				// Convert simulation results to java structures
				ost.setEvents(tools.eventsToJavaMap(sqlogger));
				ost.setMapInfos(tools.mapInfosToJavaMap(sqlogger));
				ost.setProbes(sqlogger.logs().probes());
				ost.setRawInfos(sqlogger.logs().rawInfos());
				
				// create and fill the results window
				ResultsWindow rw = new ResultsWindow();
				if(this.isAborted()) return;
				rw.setElements(ost.getStringElements());
				retrieveResultsStatus++;
				if(this.isAborted()) return;
				rw.setQueries(ost.getStringProbes());
				retrieveResultsStatus++;
				if(this.isAborted()) return;
				rw.setEvents(ost.getStringEvents());
				retrieveResultsStatus++;
				if(this.isAborted()) return;
				rw.initComponents();
				retrieveResultsStatus++;
				if(this.isAborted()) return;
				
				this.setQueriesResult(sqlogger, model);
				rw.initWindow();
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
				// Thread that manages the loader window behaviour
				this.setAborted(false); // aborted var re used for the retrieval of simulation results !
				this.retrieveResultsStatus = 0;
				Thread t = new Thread(new Runnable(){
			        public void run(){
			        	LoaderWindow lw = new LoaderWindow(5, "Results retrieval", "This operation may take a while...",
			        			"Operation aborted !");
			        	while(lw.isEnabled()) {
			        		lw.setJpbStatus(retrieveResultsStatus);
			        		if(lw.getJpbStatus() == 5) {
			        			lw.dispose();
			        		}
			        		else if(lw.isAborted()) {
			        			setAborted(true);
			        			lw.dispose();
			        		}
			        	}
			        }
			    });
				t.start();
					
				// Instance of the object that will store "Monte-Carlo" simulation results and manage their XML mutation
				MonteCarloTracer mct = new MonteCarloTracer();
				
				// Convert simulation results to java structures
				mct.setRuntimeSampling(sqlogger.logs().mcSamplings().runtimeSampling());
				retrieveResultsStatus++;
				if(this.isAborted()) return;
				mct.setProbesSampling(sqlogger.logs().mcSamplings().probesSampling());
				retrieveResultsStatus++;
				if(this.isAborted()) return;
				mct.setElementsSampling(tools.elementsSamplingsToJavaMap(sqlogger));
				retrieveResultsStatus++;
				if(this.isAborted()) return;
				mct.setHistorySampling(sqlogger.logs().mcSamplings().historySampling());
				retrieveResultsStatus++;
				if(this.isAborted()) return;
				mct.createMonteCarloXMLFile();
				retrieveResultsStatus++;
				if(this.isAborted()) return;
					
				ReportManager reportManager = new ReportManager(this.extensions);
				try {
					reportManager.executeReport(); // TODO change parameter with template report and modeling project
				} catch (EngineException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.setQueriesSamples(sqlogger, model);
				// mct.getXMLFile().delete();
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

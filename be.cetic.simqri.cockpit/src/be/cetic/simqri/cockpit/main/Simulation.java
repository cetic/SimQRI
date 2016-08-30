package be.cetic.simqri.cockpit.main;

import java.util.List;




import javax.swing.JOptionPane;

import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

import be.cetic.simqri.cockpit.reporting.ReportManager;
import be.cetic.simqri.cockpit.reporting.WorkspaceManager;
import be.cetic.simqri.cockpit.tracer.MonteCarloTracer;
import be.cetic.simqri.cockpit.tracer.OneShotTracer;
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
 * 
 * Main class that handles the execution of the simulation.
 */
public class Simulation implements Runnable {
	
	private SimQRiSirius simulation;
	
	// Mapping parameters for OscaR
	private Model model;
	private String type;
	private int timeUnits;
	private int maxIterations;
	
	private SimControl simControl; // variable used to control the simulation progress in OscaR
	private List<String> extensions; // pdf, docx, html, etc. Retrieved from NewSimulationManagementWindow.java
	private boolean aborted;
	
	private ReportManager reportManager;

	private int retrieveResultsStatus; // used by the thread dedicated to the progress bar in LoadingBarManager.java
	private int showResults; // also used by the thread dedicated to the progress bar in LoadingBarManager.java

	// One Shot Constructor
	public Simulation(Model model, int timeUnits) {
		this.type = "One Shot";
		this.model = model;
		this.timeUnits = timeUnits;
		this.simControl = new SimControl();
		this.showResults = 10; // default value used by the thread dedicated to the progress bar in LoadingBarManager.java
	}
	
	// Monte-Carlo Constructor 
	public Simulation(Model model, int timeUnits, int maxIterations, List<String> extensions) {
		this.type = "Monte-Carlo";
		this.timeUnits = timeUnits;
		this.maxIterations = maxIterations;
		this.model = model;
		this.simControl = new SimControl();
		this.extensions = extensions;
		this.showResults = 10; // default value used by the thread dedicated to the progress bar in LoadingBarManager.java
	}
	
	public int getExtensionsSize() {
		return extensions.size();
	}
	
	public ReportManager getReportManager() {
		return reportManager;
	}
	
	public int getShowResults() {
		return this.showResults;
	}
	
	public int getRetrieveResultsStatus() {
		return retrieveResultsStatus;
	}

	public void setRetrieveResultsStatus(int retrieveResultsStatus) {
		this.retrieveResultsStatus = retrieveResultsStatus;
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
			// the thread that retrieves this value can be executed before the beginning of the simulation
			return 0;
		else if(this.type.equals("Monte-Carlo"))
			return this.simulation.loading(); // = number of iterations processed at that time
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
			// the thread that retrieves this value can be executed before the beginning of the simulation
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
	
	/**
	 * Main simulation thread (data mapping, API OscaR, results retrieval through tracers and reports generation for MC simulations)
	 */
	@Override
	public void run() { 
		TraceLogger sqlogger = new TraceLogger();
		sqlogger.reset();
		Tools tools = new Tools();
		if(type.equals("One Shot")) {
			this.setSimulation(new SimQRiSirius(timeUnits, true, sqlogger, false)); 
			simulation.fillModelWithSiriusData(model);
			simulation.simulateOneShot(this.simControl);
			if(this.isCanceled())
				showResults = JOptionPane.showConfirmDialog(null, "Simulation cancelled ! \nDo you wish to consult intermediate results ?");
			else showResults = JOptionPane.YES_OPTION; // We have to fix the value here because the LoadingBarManager thread will use it
			if(showResults == JOptionPane.YES_OPTION) {

				this.setAborted(false); // aborted var re used for the retrieval of simulation results !
				this.retrieveResultsStatus = 0;
				
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
				rw.setQueries(ost.getStringProbes(false));
				retrieveResultsStatus++;
				if(this.isAborted()) return;
				rw.setHistory(ost.getStringProbes(true));
				retrieveResultsStatus++;
				if(this.isAborted()) return;
				rw.setEvents(ost.getStringEvents());
				retrieveResultsStatus++;
				if(this.isAborted()) return;
				rw.initComponents();
				retrieveResultsStatus++;
				if(this.isAborted()) return;
				
				// this.setQueriesResult(sqlogger, model);
				rw.initWindow();
			}
			
		}
		else if(type.equals("Monte-Carlo")) {
			this.setSimulation(new SimQRiSirius(timeUnits, true, sqlogger, true));
			simulation.fillModelWithSiriusData(model);
			simulation.simulateMonteCarlo(maxIterations, this.simControl);
			if(this.isCanceled())
				showResults = JOptionPane.showConfirmDialog(null, "Simulation cancelled ! \nDo you wish to retrieve intermediate reports ?");
			else showResults = JOptionPane.YES_OPTION; // We have to fix the value here because the LoadingBarManager thread will use it...
			if(showResults == JOptionPane.YES_OPTION) {

				this.setAborted(false); // aborted var re used for the retrieval of simulation results !
				this.retrieveResultsStatus = 0;
				
				// Setting the full used path for the reporting services (reports folder, template path and xml workspace folder)
				WorkspaceManager.setReportFolderPath(WorkspaceManager.SELECTED_PROJECT);
		        WorkspaceManager.setTemplatePath(WorkspaceManager.SELECTED_PROJECT, WorkspaceManager.SELECTED_TEMPLATE);
				WorkspaceManager.setXmlFolderWorkspacePath(WorkspaceManager.SELECTED_PROJECT);
				
				// Instance of the object that will store "Monte-Carlo" simulation results and manage their XML mutation
				MonteCarloTracer mct = new MonteCarloTracer(model);
				
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
				
				mct.createXMLFile();
				retrieveResultsStatus++;
				if(this.isAborted()) return;
					
				this.reportManager = new ReportManager(this.extensions);
				try {
					this.reportManager.executeReport();
				} catch (EngineException e) {
					JOptionPane.showMessageDialog(null,  "An error has occured during reports generation!", "error",  JOptionPane.ERROR_MESSAGE);
				}
				// this.setQueriesSamples(sqlogger, model);
				// mct.getXMLFile().delete();
			}
		}
	}
	
	/**
	 * 
	 * @param sqlogger "One Shot" simulation results
	 * @param model The instance of the SimQRi model
	 * @deprecated
	 * This method set simulation results to queries objects of the Sirius Metamodel instance. 
	 * No longer used due to a too long time for setting results when there are a lot of queries
	 */
	@SuppressWarnings("unused")
	private void setQueriesResult(TraceLogger sqlogger, Model model) {
		Iterator<Tuple2<String, String>> itProbes = sqlogger.logs().probes().iterator();
		while(itProbes.hasNext()) {
			Tuple2<String, String> probes = itProbes.next();
			String result = probes._2.toString().replaceAll("[^\\d.]", ""); // We keep numerical values only
			double value = Double.parseDouble(result);
			for(Query q : model.getQuery()) {
				if(q.getName().equals(probes._1)) {
					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(q);
					domain.getCommandStack().execute(new RecordingCommand(domain) {
					   public void doExecute() {
						   // q.setResult(String.format("%.2f", value)); 
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
	 * @deprecated
	 * This method set simulation results to queries objects of the Sirius Metamodel instance. 
	 * No longer used due to a too long time for setting results when there are a lot of queries
	 */
	@SuppressWarnings("unused")
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
						  // q.setMax(String.format("%.2f", JsonFormat.jsonToDouble(probes.samplingStr(), "max")));
						  // q.setMin(String.format("%.2f", JsonFormat.jsonToDouble(probes.samplingStr(), "min")));
						  // q.setMean(String.format("%.2f", JsonFormat.jsonToDouble(probes.samplingStr(), "mean")));
						  // q.setVariance(String.valueOf(JsonFormat.jsonToDouble(probes.samplingStr(), "variance")));
					   }
					});
				}
			}
		}
	}
}

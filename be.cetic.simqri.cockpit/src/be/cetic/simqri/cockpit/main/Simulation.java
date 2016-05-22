package be.cetic.simqri.cockpit.main;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import org.eclipse.emf.transaction.*;
import org.eclipse.emf.transaction.util.TransactionUtil;

import be.cetic.simqri.cockpit.tracer.MonteCarloTracer;
import be.cetic.simqri.cockpit.tracer.OneShotTracer;
import be.cetic.simqri.cockpit.util.JsonFormat;
import be.cetic.simqri.cockpit.views.ResultsWindow;
import be.cetic.simqri.cockpit.views.SimulationManagementWindow;
import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.metamodel.Query;
import be.cetic.simqri.simulator.mapping.SimQRiSirius;
import be.cetic.simqri.simulator.mapping.Tools;
import oscar.des.logger.SamplingTuple;
import oscar.des.logger.TraceLogger;
import scala.Tuple2;
import scala.collection.Iterator;

/**
 * 
 * @author FK
 * @version 2.0
 * 
 * This class is used to call displays related to simulations 
 * and to launch them with parameters choosen by the user.
 * It also retrieves and manages results...
 */
public class Simulation {
	
	/**
	 * 
	 * @param model The instance drawn in the Sirius diagram
	 * @param errMessages The string of all error messages related to the modeling. Empty if no errors.
	 * 
	 */
	public static void displaySimulationWindow(Model model, String errMessages) {
		if(errMessages.isEmpty())
			new SimulationManagementWindow(model);
		else
			showMessage("The simulation will not be launchable due to some modeling errors in your diagram : \n"
						+ errMessages, true);
	}
	
	/**
	 * 
	 * @param type the type of simulation
	 * @param timeUnits simulation parameter
	 * @param maxIterations simulation parameter
	 * @param model The instance drawn in the Sirius diagram
	 * 
	 * This method launches simulations and retrieves results in a logger, manages them into a tracer 
	 * and then calls a window in which these results will be diplayed.
	 * It also set results of queries as attributes to all "Query" instances of the sirius model 
	 * in order to display them in the queries table view
	 */
	public static void launch(String type, int timeUnits, int maxIterations, Model model) {
		TraceLogger sqlogger = new TraceLogger(); // Object that will contain simulations results
		sqlogger.reset();
		Tools t = new Tools(); // Tools : Scala class of the "simulator" project that provides auxiliary functions
		if(type.equals("One Shot")) {
			SimQRiSirius sim = new SimQRiSirius(timeUnits, true, sqlogger, false);
			String errQueries = sim.fillModelWithSiriusData(model);
			if(errQueries.isEmpty()) {
				sim.simulateOneShot();
				
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
			else {
				showMessage("The simulation will not be launchable due to some errors in your queries : \n"
						+ errQueries, true);
			}
			
		}
		else if(type.equals("Monte-Carlo")) {
			SimQRiSirius sim = new SimQRiSirius(timeUnits, true, sqlogger, true);
			String errQueries = sim.fillModelWithSiriusData(model);
			if(errQueries.isEmpty()) {
				sim.simulateMonteCarlo(maxIterations);
				
				MonteCarloTracer mct = new MonteCarloTracer();
				mct.setElementsSampling(t.elementsSamplingsToJavaMap(sqlogger));
				mct.setRuntimeSampling(sqlogger.logs().mcSamplings().runtimeSampling());
				mct.setProbesSampling(sqlogger.logs().mcSamplings().probesSampling());
				mct.setHistorySampling(sqlogger.logs().mcSamplings().historySampling());
				
				setQueriesSamples(sqlogger, model);
				
				new ResultsWindow(mct);
			}
			else {
				showMessage("The simulation will not be launchable due to some errors in your queries : \n"
						+ errQueries, true);
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
	private static void setQueriesResult(TraceLogger sqlogger, Model model) {
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
	private static void setQueriesSamples(TraceLogger sqlogger, Model model) {
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
	
	private static void showMessage(String message, boolean error) {
	    EventQueue.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	        		if(!error)
	        			JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
	        		else
	        			JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    });
	}
}

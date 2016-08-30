package be.cetic.simqri.cockpit.main;

import java.awt.EventQueue;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.metamodel.Query;
import be.cetic.simqri.simulator.mapping.SimQRiSirius;
import oscar.des.logger.Logger;
import oscar.des.logger.TraceLogger;

/**
 * 
 * @author FK
 * @version 2.0
 * 
 * This class is used to check the 'value' field of a Query situated in the "Model" object and written by the user in the table of queries.
 * 
 */
public class CheckQueries {
	
	/**
	 * 
	 * @param model The instance drawn in the Sirius diagram
	 * @param errMessages The string that contains error messages related to wrong queries. Empty if no errors.
	 */
	public static void check(Model model, String errMessages) {
		if(!errMessages.isEmpty()) {
			showMessage("Your queries can not be checked due to some modeling errors in your diagram : \n"
					+ errMessages, true);
			return;
		}
		Logger<String> logger = new TraceLogger();
		 
		// Check the conversion of the model and the validity of queries
		SimQRiSirius sim = new SimQRiSirius(100, true, logger, true);
		ArrayList<String> errors =  sim.fillModelWithSiriusData(model);
		if(errors.isEmpty()) 
			showMessage("All your queries are valid !", false);
		else {
			String showedMessage = "";
			for(String error : errors) {
				showedMessage += error+"\n";
			}
			showMessage(showedMessage, true);
		}
	}
	
	/**
	 * This method is used by a java extension which is called every time a query value is updated in the queries table
	 * @param model The model instance drawn in the Sirius diagram
	 * @return errors The String of all error messages related to the queries parsing. Empty if no errors.
	 */
	public static ArrayList<String> dynamicCheck(Model model) {
		ArrayList<String> errors;
		Logger<String> logger = new TraceLogger();
		// Check the conversion of the model and the validity of queries
		SimQRiSirius sim = new SimQRiSirius(100, true, logger, true);
		errors =  sim.fillModelWithSiriusData(model);
		// Metamodel transaction in order to set queries error message into the "error" field of "Query" entities.
		boolean hasError;
		for(Query q : model.getQuery()) {
			hasError = false;
			for(String error : errors) {
				if(error.contains(q.getValue())) {
					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(q);
					domain.getCommandStack().execute(new RecordingCommand(domain) {
					   public void doExecute() {
						   String[] errSplit = error.split("]");
						  q.setError(errSplit[1]);
					   }
					});
					hasError = true;
				}
			}
			if(!hasError) q.setError("");
		}
		return errors;
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

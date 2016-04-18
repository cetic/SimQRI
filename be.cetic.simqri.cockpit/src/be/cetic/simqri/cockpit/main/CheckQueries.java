package be.cetic.simqri.cockpit.main;

import java.awt.EventQueue;
import javax.swing.JOptionPane;

import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.simulator.mapping.SimQRiSirius;

/**
 * 
 * @author FK
 * This class is used to check queries kept in the "Model" object and written by the user in the Sirius interface.
 * 
 */
public class CheckQueries {
	
	public static void check(Model model, String errMessages) {
		if(!errMessages.isEmpty()) {
			showMessage("Your queries can not be checked due to some modeling errors in your diagram : \n"
					+ errMessages, true);
			return;
		}
		SimQRiSirius sim = new SimQRiSirius(100, true);
		String errors =  sim.fillModelWithSiriusData(model);
		if(errors.isEmpty() && errMessages.isEmpty()) 
			showMessage("All your queries are valid !", false);
		else 
			showMessage(errors, true);
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

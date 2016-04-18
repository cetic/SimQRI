package be.cetic.simqri.cockpit.main;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import be.cetic.simqri.cockpit.views.SimulationManagementWindow;
import be.cetic.simqri.metamodel.Model;

/**
 * 
 * @author FK
 * @version 2.0
 * 
 * This class is used to call displays related to simulations
 */
public class Simulation {
	
	public static void launch(Model model, String errMessages) {
		if(errMessages.isEmpty())
			new SimulationManagementWindow(model);
		else
			showMessage("The simulation will not be launchable due to some modeling errors in your diagram : \n"
						+ errMessages, true);
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

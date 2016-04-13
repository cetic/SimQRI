package be.cetic.simqri.cockpit.main;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import be.cetic.simqri.cockpit.views.SimulationManagementWindow;
import be.cetic.simqri.metamodel.Model;

/**
 * 
 * @author FK
 * This class is used to call displays related to simulations
 */
public class Simulation {
	
	public static void launch(Model model, boolean valid) {
		if(valid)
			new SimulationManagementWindow(model);
		else
			showMessage("It seems there is at least one modeling error in your diagram. \n "
						+ "Please check its validation before launching a simulation.", true);
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

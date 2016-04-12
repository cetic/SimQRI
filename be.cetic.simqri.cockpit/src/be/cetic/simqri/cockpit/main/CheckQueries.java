package be.cetic.simqri.cockpit.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.simulator.mapping.SimQRiSirius;

public class CheckQueries {
	
	public static void check(Model model) {
		SimQRiSirius sim = new SimQRiSirius(100, true);
		boolean queriesAreValid =  sim.fillModelWithSiriusData(model);
		JFrame frame = new JFrame();
		frame.setSize(300,  150);
		frame.setResizable(false);
		if(queriesAreValid) 
			showMessage("All your queries are valid !", false);
		else 
			showMessage("At least one of your queries is not valid. \n Check Console for more details.", true);
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

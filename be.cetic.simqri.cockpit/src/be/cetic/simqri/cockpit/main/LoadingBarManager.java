package be.cetic.simqri.cockpit.main;

import javax.swing.JOptionPane;
import be.cetic.simqri.cockpit.views.PanelLoader;

/**
 * 
 * @author FK
 * @since 09/08/2016
 * @version 1.0
 * This class contains the main thread that manages the progress bar of the simulation management window.
 * The aim is to manage the same progress bar for 3 successive events (simulation, results retrieval 
 * and reports generation for MC simulations)
 *
 */
public class LoadingBarManager implements Runnable {
	
	private PanelLoader panelLoader; // The panel of the progress bar
	private Simulation simulation;
	private int step;
	private boolean aborted;
	
	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
	
	public LoadingBarManager(PanelLoader panelLoader, Simulation simulation) {
		super();
		this.panelLoader = panelLoader;
		this.simulation = simulation;
		this.aborted = false;
		this.step = 0;
	}
	
	public PanelLoader getPanelLoader() {
		return panelLoader;
	}

	public void setPanelLoader(PanelLoader panelLoader) {
		this.panelLoader = panelLoader;
	}

	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}

	public boolean isAborted() {
		return aborted;
	}

	public void setAborted(boolean aborted) {
		this.aborted = aborted;
	}

	private void waiting() {
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.step = 1;
		// Simulation loop
		while(panelLoader.getJpbStatus().getValue() < panelLoader.getMaximum() && !isAborted()) 
			panelLoader.getJpbStatus().setValue(simulation.getLoading());

		if(isAborted()) {  // STOP button pressed
			// We have to wait the user's choice (retrieve intermediate simulation results or not)
			while(this.simulation.getShowResults() == 10) // 10 = default value until a right one is set by the user
				waiting(); 
			if(this.simulation.getShowResults() != JOptionPane.YES_OPTION) {
				// Next steps will not be executed, we reset the progress bar panel
				panelLoader.reset("status bar", 100);
				return;
			}
			// else, the simulation is not aborted anymore (aborted was set to true after pressing the "stop" button)
			this.setAborted(false);
		}
		// 4 steps for processing results in the one shot results retrieval...
		if(this.simulation.getType().equals("One Shot"))
			panelLoader.reset("Processing results...", 4);
		// ...and 5 in the MC results retrieval
		else
			panelLoader.reset("Processing results...", 5);
		this.step = 2;
		// Results retrieval loop
		while(panelLoader.getJpbStatus().getValue() < panelLoader.getMaximum() && !isAborted()) 
			panelLoader.getJpbStatus().setValue(simulation.getRetrieveResultsStatus());
		
		if(isAborted()) { // STOP button pressed
			panelLoader.reset("status bar", 100);
			JOptionPane.showMessageDialog(null,  "Operation aborted !", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		else {
			// The process is over for One Shot results, we close the simulation management window
			if(this.simulation.getType().equals("One Shot")) {
				panelLoader.disposeWindow();
			}
			else {
				// The process continues for MC results
				// The thread sleeps until the initialization of the report manager by the simulation object in the main thread
				while(simulation.getReportManager() == null) 
					waiting();
				
				panelLoader.reset("Generating reports [0/"+simulation.getExtensionsSize()+"]", simulation.getExtensionsSize());
				this.step = 3;
				int nbPrec = 0;
				// Generating reports loop
				while(panelLoader.getJpbStatus().getValue() < panelLoader.getMaximum() && !isAborted()) {
					int nbReports = simulation.getReportManager().getCreatedReports();
					panelLoader.getJpbStatus().setValue(nbReports);
					if(nbReports >nbPrec) {
						nbPrec = nbReports;
						panelLoader.setMessage("Generating reports ["+nbReports+"/"+simulation.getExtensionsSize()+"]");
					}
				}
				if(isAborted()) { // STOP button pressed
					// We have to warn the report manager that the reports generation has been aborted
					simulation.getReportManager().setAborted(true);
					panelLoader.reset("status bar", 100);
					JOptionPane.showMessageDialog(null,  "Operation aborted !\nHowever, some reports may have already been generated...", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				setAborted(true); // aborted = finished
				// End of the process, we close the simulation management window
				panelLoader.disposeWindow();
			}
		}
	}
}

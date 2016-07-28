package be.cetic.simqri.cockpit.views;

import java.awt.BorderLayout;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import be.cetic.simqri.cockpit.tracer.MonteCarloTracer;
import be.cetic.simqri.cockpit.tracer.OneShotTracer;

/**
 * @author FK
 * @since 19/04/2016
 * @version 1.0
 * 
 * This is the main window in which simulation results will be displayed.
 * 
 */
public class ResultsWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel jlTitle;
	private JPanel jpButtons;
	private JTabbedPane jtpResults;
	private Component panelTrace, panelRuntime, panelElements, panelQueries;
	private JButton jbSave, jbExit;
	private OneShotTracer ost = null;
	private MonteCarloTracer mct = null;
	
	public ResultsWindow(OneShotTracer ost) {
		super("One Shot simulation results");
		this.ost = ost;
		initComponents(false);
		initWindow();
	}
	
	public ResultsWindow(MonteCarloTracer mct) {
		super("Monte-Carlo simulation results");
		this.mct = mct;
		initComponents(true);
		initWindow();
	}
	
	public void initWindow() {
		this.setResizable(false);
		this.setSize(new Dimension(750, 600));
		this.setLayout(new BorderLayout());
		
		this.add(jlTitle, BorderLayout.NORTH);
		this.add(jtpResults, BorderLayout.CENTER);
		this.add(this.jpButtons, BorderLayout.SOUTH);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initComponents(boolean mc) { 
		this.jlTitle = new JLabel();
		this.jlTitle.setText("The simulation is completed. Here are the results :");
		this.jtpResults = new JTabbedPane();
		
		String elements, queries;
		
		if(!mc) {
			this.panelTrace = new PanelResults(ost.getStringEvents());
			this.jtpResults.addTab("Trace", null, panelTrace, "Check the simulation trace");
			elements = ost.getStringElements();
			queries = ost.getStringProbes();
		}
		else {
			this.panelRuntime = new PanelResults(mct.getStringRuntime());
			this.jtpResults.addTab("Runtime", null, panelRuntime, "Check the simulation runtime");
			elements = mct.getStringElements();
			queries = mct.getStringProbes();
		}
		
		this.panelElements = new PanelResults(elements); 
		this.panelQueries = new PanelResults(queries); 
		
		this.jtpResults.addTab("Elements", null, panelElements, "Check the simulation elements");
		this.jtpResults.addTab("Queries", null, panelQueries, "Check the simulation queries results");
		
		this.jbSave = new JButton("Save as");
		this.jbExit = new JButton("Close");
		this.jbSave.addActionListener(this);
		this.jbExit.addActionListener(this);
		
		this.jpButtons = new JPanel();
		this.jpButtons.add(jbSave);
		this.jpButtons.add(jbExit);		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == this.jbSave) {
			String allResults = "";
			if(this.ost != null && this.mct == null) 
				allResults = ost.getStringEvents()+"\n"+ost.getStringElements()+"\n"+ost.getStringProbes()+"\n";
			else if(this.ost == null && this.mct != null)
				allResults = mct.getStringRuntime()+"\n"+mct.getStringElements()+"\n"+mct.getStringProbes()+"\n";
			
			saveInTextFile(allResults);
		}
		if(event.getSource() == this.jbExit) {
			this.dispose();
		}
	} 
	
	private void saveInTextFile(String allResults) {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		fileChooser.setFileFilter(filter);
		fileChooser.setDialogTitle("Specify a text file to save");   
		int userSelection = fileChooser.showSaveDialog(null);
		
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    
		    if(fileToSave.exists()) {
			    JOptionPane.showMessageDialog(null, fileToSave.getName()+" already exists !", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		    else {
		    		if(!fileToSave.getName().toLowerCase().endsWith(".txt"))
		    			fileToSave = new File(fileToSave.getAbsolutePath() + ".txt");
			    BufferedWriter  bf = null;
			    try {
					bf = new BufferedWriter(new FileWriter(fileToSave));
					bf.write(allResults);
					bf.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, "Erreur: " + e.getMessage() + "");
				}
			      JOptionPane.showMessageDialog(null, "Data saved successfully at "+fileToSave.getAbsolutePath(), "Information", JOptionPane.INFORMATION_MESSAGE);
		    }
		}
	}
	
}

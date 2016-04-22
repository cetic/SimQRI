package be.cetic.simqri.cockpit.views;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
	private OneShotTracer ost;
	private MonteCarloTracer mct;
	
	public ResultsWindow(OneShotTracer ost) {
		super("One Shot simulation results");
		this.ost = ost;
		initComponents(false);
		initWindow();
	}
	
	public ResultsWindow(MonteCarloTracer mct) {
		super("One Shot simulation results");
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
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		this.jbExit = new JButton("Exit");
		this.jbSave.addActionListener(this);
		this.jbExit.addActionListener(this);
		
		this.jpButtons = new JPanel();
		this.jpButtons.add(jbSave);
		this.jpButtons.add(jbExit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Implement file saving & exit 
	} 
	
}

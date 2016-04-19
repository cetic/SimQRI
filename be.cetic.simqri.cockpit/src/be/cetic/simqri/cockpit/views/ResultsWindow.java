package be.cetic.simqri.cockpit.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ResultsWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel jlTitle;
	private JPanel jpButtons;
	private JTabbedPane jtpResults;
	private Component panelTrace, panelElements, panelQueries;
	private JButton jbSave, jbExit;
	private Map<String, List<String[]>> mapResults;
	
	public ResultsWindow(Map<String, List<String[]>> mapResults) {
		
		super("Simulation results");
		
		this.setResizable(false);
		this.setSize(new Dimension(750, 600));
		this.setLayout(new BorderLayout());
		
		this.mapResults = mapResults;
		
		initComponents();
		
		this.add(jlTitle, BorderLayout.NORTH);
		this.add(jtpResults, BorderLayout.CENTER);
		this.add(this.jpButtons, BorderLayout.SOUTH);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initComponents() {
		this.jlTitle = new JLabel();
		this.jlTitle.setText("The simulation is completed. Here are the results :");
		
		this.jtpResults = new JTabbedPane();
		
		this.panelTrace = new PanelTrace(); // Param = mapResults.get("trace")
		this.panelElements = new PanelElements(); // Param = ...
		this.panelQueries = new PanelQueries(); // Param = ...
		
		this.jtpResults.addTab("Trace", null, panelTrace, "Check the simulation trace");
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
		// TODO Auto-generated method stub
	} 
	
}

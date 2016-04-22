package be.cetic.simqri.cockpit.views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

import be.cetic.simqri.cockpit.main.Simulation;
import be.cetic.simqri.metamodel.Model;

/**
 * 
 * @author FK
 * This class is the management window of a new simulation.
 * It is displayed after a right-click on the back of the Sirius tool and select "New Simulation".
 * This class also launch simulations in its "actionPerformed" method via an instance of the SimQRiSirius class form the "Simulator" scala project 
 */
public class SimulationManagementWindow extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private Model model;
	
	private JLabel jlTimeUnits;
	private JLabel jlMaxIterations;
	private JTextField jtfTimeUnits;
	private JTextField jtfMaxIterations;
	private JButton jbOneShot;
	private JButton jbMonteCarlo;
	
	public SimulationManagementWindow(Model model) {
		super("New Simulation");
		
		this.model = model;
		
		this.setResizable(false);
		this.setSize(new Dimension(250, 200));
		this.setLayout(new GridLayout(4, 1));
		
		initComponents();
		
		JPanel line1 = new JPanel();
		line1.setLayout(new FlowLayout());
		JPanel line2 = new JPanel();
		line2.setLayout(new FlowLayout());
		JPanel line3 = new JPanel();
		line3.setLayout(new FlowLayout());
		JPanel line4 = new JPanel();
		line4.setLayout(new FlowLayout());
		
		line1.add(jlTimeUnits); line1.add(jtfTimeUnits); 
		line2.add(jbOneShot);
		line3.add(jlMaxIterations); line3.add(jtfMaxIterations); 
		line4.add(jbMonteCarlo);
		
		this.add(line1); this.add(line2);
		this.add(line3); this.add(line4);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initComponents() {
		jlTimeUnits = new JLabel("Time units: ");
		jlMaxIterations = new JLabel("Max iterations: ");
		
		jtfTimeUnits = new JTextField("1000");
		PlainDocument docTimeUnits = (PlainDocument) jtfTimeUnits.getDocument();
	    docTimeUnits.setDocumentFilter(new IntFilter());
	    
	    jtfMaxIterations = new JTextField("100");
	    PlainDocument docMaxIterations = (PlainDocument) jtfMaxIterations.getDocument();
	    docMaxIterations.setDocumentFilter(new IntFilter());
	    
		jtfTimeUnits.setColumns(5);
		jtfMaxIterations.setColumns(5);
		
		jbOneShot = new JButton("Simulate One Shot");
		jbOneShot.addActionListener(this);
		jbMonteCarlo = new JButton("Simulate Monte Carlo");
		jbMonteCarlo.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int timeUnits = Integer.parseInt(this.jtfTimeUnits.getText().toString());
		if(e.getSource() == this.jbOneShot) 
			Simulation.launch("One Shot", timeUnits, 0, this.model);
		else if(e.getSource() == this.jbMonteCarlo) {
			int maxIterations = Integer.parseInt(this.jtfMaxIterations.getText().toString());
			Simulation.launch("Monte-Carlo", timeUnits, maxIterations, this.model);
		}
		this.dispose();
	}

}

package be.cetic.simqri.cockpit.views;

import java.awt.Dimension;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.PlainDocument;

import be.cetic.simqri.cockpit.main.NewSimulation;
import be.cetic.simqri.cockpit.util.IntFilter;
import be.cetic.simqri.metamodel.Model;

/**
 * 
 * @author FK
 * @version 1.0
 * This class is the new management window of a new simulation.
 * It is displayed after a right-click on the back of the Sirius tool and select "New Simulation".
 * This window contains a loading bar that is updated in a thread.
 * This thread is performed in the same time that the simulation tread (see NewSimulation.java)
 */
public class NewSimulationManagementWindow extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private String type;
	private Model model;
	private NewSimulation newSimulation;
	private int timeUnits;
	private int maxIterations;
	
	private JRadioButton jrbOneShot;
	private JRadioButton jrbMonteCarlo;
	ButtonGroup buttonGroup;
	// -----------------------------------
	private JLabel jlTimeUnits;
	private JLabel jlMaxIterations;
	private JTextField jtfTimeUnits;
	private JTextField jtfMaxIterations;
	// -----------------------------------
	private JLabel jlSelectExtensions;
	private JCheckBox jcbPdf;
	private JCheckBox jcbDocx;
	private JCheckBox jcbXlsx;
	private JCheckBox jcbOdt;
	private JCheckBox jcbHtml;
	private JCheckBox jcbPptx;
	// -----------------------------------
	private JButton jbStart;
	private JButton jbStop;
	// -----------------------------------
	private Thread loadingBarThread;
	private Thread simulationThread;
	private JProgressBar loader;
	
	public NewSimulationManagementWindow(Model model) {
		super("New Simulation");
		this.model = model;
		this.setResizable(false);
		this.setSize(new Dimension(400, 350));
		this.setLayout(new GridLayout(11, 1));
		
		initComponents();
		
		JPanel line1 = new JPanel();
		line1.setLayout(new FlowLayout());
		JPanel line2 = new JPanel();
		line2.setLayout(new FlowLayout());
		JPanel line3 = new JPanel();
		line3.setLayout(new FlowLayout());
		JPanel line4 = new JPanel();
		line4.setLayout(new FlowLayout());
		JPanel line5 = new JPanel();
		line5.setLayout(new FlowLayout());
		JPanel line6 = new JPanel();
		line6.setLayout(new FlowLayout());
		JPanel line7 = new JPanel();
		line7.setLayout(new FlowLayout());
		JPanel line8 = new JPanel();
		line8.setLayout(new FlowLayout());
		JPanel line9 = new JPanel();
		line9.setLayout(new FlowLayout());
		JPanel line10 = new JPanel();
		line10.setLayout(new FlowLayout());
		JPanel line11 = new JPanel();
		line11.setLayout(new FlowLayout());
		
		line1.add(jrbOneShot); line1.add(jrbMonteCarlo); 
		line2.add(horizontalSeparator());
		line3.add(jlTimeUnits); line3.add(jtfTimeUnits); 
		line4.add(jlMaxIterations); line4.add(jtfMaxIterations);
		line9.add(horizontalSeparator());
		line11.add(jlSelectExtensions);
		line10.add(jcbPdf); line10.add(jcbDocx); line10.add(jcbXlsx);
		line10.add(jcbPptx); line10.add(jcbOdt); line10.add(jcbHtml);
		line5.add(horizontalSeparator());
		line6.add(jbStart); line6.add(jbStop);
		line7.add(horizontalSeparator());
		line8.add(loader);
		
		this.add(line1); this.add(line2);
		this.add(line3); this.add(line4);
		this.add(line9); this.add(line11);
		this.add(line10);
		this.add(line5); this.add(line6);
		this.add(line7); this.add(line8);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initComponents() {
		jrbOneShot = new JRadioButton("One Shot");
		jrbOneShot.setMnemonic(KeyEvent.VK_O);
		jrbOneShot.setActionCommand("One Shot");
		jrbOneShot.setSelected(true);
		jrbOneShot.addActionListener(this);
		
		jrbMonteCarlo = new JRadioButton("Monte-Carlo");
		jrbMonteCarlo.setMnemonic(KeyEvent.VK_M);
		jrbMonteCarlo.setActionCommand("Monte-Carlo");
		jrbMonteCarlo.addActionListener(this);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(jrbOneShot); buttonGroup.add(jrbMonteCarlo);
		
		jlTimeUnits = new JLabel("Time units: ");
		jlMaxIterations = new JLabel("Max iterations: ");
		
		jlSelectExtensions = new JLabel("Select your report extension(s)");
		jcbDocx = new JCheckBox(".docx");
		jcbHtml = new JCheckBox(".html");
		jcbXlsx = new JCheckBox(".xlsx");
		jcbPdf = new JCheckBox(".pdf");
		jcbPptx = new JCheckBox(".pptx");
		jcbOdt = new JCheckBox(".odt");
		
		jcbPdf.setSelected(true);
		
		jtfTimeUnits = new JTextField("1000");
		PlainDocument docTimeUnits = (PlainDocument) jtfTimeUnits.getDocument();
	    docTimeUnits.setDocumentFilter(new IntFilter());
	    
	    jtfMaxIterations = new JTextField("100");
	    PlainDocument docMaxIterations = (PlainDocument) jtfMaxIterations.getDocument();
	    docMaxIterations.setDocumentFilter(new IntFilter());
		jtfMaxIterations.setEnabled(false); // "One Shot" simulation selected by default
	    
		jtfTimeUnits.setColumns(5);
		jtfMaxIterations.setColumns(5);
		
		jbStart = new JButton("Start");
		jbStart.addActionListener(this);
		jbStop = new JButton("Stop");
		jbStop.addActionListener(this);
		
		loader = new JProgressBar();
		loader.setMaximum(Integer.parseInt(jtfMaxIterations.getText()));
		loader.setMinimum(0);
		loader.setStringPainted(true);
	}
	
	private class LoadingBar implements Runnable { 
		// Internal class dedicated to the simulation management (start, stop, loader)
		@Override
		public void run() {
			jbStart.setEnabled(false);
			while(newSimulation.getLoading() < loader.getMaximum() && !newSimulation.isAborded())
				loader.setValue(newSimulation.getLoading());
				
			if(!newSimulation.isAborded()) {
				loader.setValue(loader.getMaximum());
				if(maxIterations >= 1000) {
					JOptionPane.showMessageDialog(NewSimulationManagementWindow.this, "The simulation is now completed. \n"
							+ "Results are being processed and will be displayed in a few moments. \n", "Completed" ,JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();
			}
		    jbStart.setEnabled(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() != null && e.getActionCommand().equals("One Shot")) {
			this.jtfMaxIterations.setText("100");
			this.jtfMaxIterations.setEnabled(false);
		}
		else if (e.getActionCommand() != null && e.getActionCommand().equals("Monte-Carlo")) {
			this.jtfMaxIterations.setEnabled(true);
		}
		else {
			if(e.getSource() == this.jbStart) {
				if(jtfTimeUnits.getText().isEmpty()) 
					JOptionPane.showMessageDialog(null, "Time Units value is not set!", "Error", JOptionPane.ERROR_MESSAGE);
				else if (this.jrbMonteCarlo.isSelected() && jtfMaxIterations.getText().isEmpty()) 
					JOptionPane.showMessageDialog(null, "Max Iterations value is not set!", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					timeUnits = Integer.parseInt(jtfTimeUnits.getText());
					maxIterations = Integer.parseInt(jtfMaxIterations.getText());
					if(this.jrbMonteCarlo.isSelected()) {
						type = "Monte-Carlo";
						loader.setMaximum(maxIterations);
					}
					else {
						type = "One Shot";
						loader.setMaximum(timeUnits);
					}
					
					// Extensions chosen by the user
					List<String> extensions = new ArrayList<String>();
					if(this.jcbDocx.isSelected()) extensions.add("docx"); if(this.jcbPdf.isSelected()) extensions.add("pdf");
					if(this.jcbPptx.isSelected()) extensions.add("pptx"); if(this.jcbOdt.isSelected()) extensions.add("odt");
					if(this.jcbXlsx.isSelected()) extensions.add("xlsx"); if(this.jcbHtml.isSelected()) extensions.add("html");
					newSimulation = new NewSimulation(type, timeUnits, maxIterations, model, extensions);
					simulationThread = new Thread(newSimulation);
					loadingBarThread = new Thread(new LoadingBar());
					simulationThread.start();
					loadingBarThread.start(); 
				}
			}
			else if(e.getSource() == this.jbStop) {
				if(simulationThread != null && loadingBarThread != null && !simulationThread.isInterrupted() && !loadingBarThread.isInterrupted()) {
					newSimulation.setAborded(true);
					jbStart.setText("Restart");
					loader.setValue(0);
				}
			}
		}
	}
	
	private static JComponent horizontalSeparator() {
        JSeparator x = new JSeparator(SwingConstants.HORIZONTAL);
        x.setPreferredSize(new Dimension(350,3));
        return x;
    }
}

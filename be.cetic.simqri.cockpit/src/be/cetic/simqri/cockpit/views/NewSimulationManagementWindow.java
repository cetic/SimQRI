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
import javax.swing.JComboBox;
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
import be.cetic.simqri.cockpit.reporting.WorkspaceManager;
import be.cetic.simqri.cockpit.util.IntFilter;
import be.cetic.simqri.metamodel.Model;

/**
 * 
 * @author FK
 * @version 1.2
 * This class is the new management window of a new simulation.
 * It is displayed after a right-click on the back of the Sirius tool and select "New Simulation".
 * This window contains a loading bar that is updated in a thread & combo boxes that allow the user
 * to choose the report template that will be used.
 * This thread is performed in the same time that the simulation tread (see NewSimulation.java)
 */
public class NewSimulationManagementWindow extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
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
	private JLabel jlSelectModelingProject;
	private JComboBox<String> jcbModelingProjects;
	// -----------------------------------
	private JLabel jlSelectReportTemplate;
	private JComboBox<String> jcbReportTemplates;
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
		this.setSize(new Dimension(350, 500));
		this.setLayout(new GridLayout(17, 1));
		
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
		line6.setLayout(new GridLayout(1, 2));
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
		JPanel line12 = new JPanel();
		line12.setLayout(new FlowLayout());
		JPanel line13 = new JPanel();
		line13.setLayout(new FlowLayout());
		JPanel line14 = new JPanel();
		line14.setLayout(new FlowLayout());
		JPanel line15 = new JPanel();
		line15.setLayout(new FlowLayout());
		JPanel line16 = new JPanel();
		line16.setLayout(new FlowLayout());
		JPanel line17 = new JPanel();
		line17.setLayout(new FlowLayout());
		
		line1.add(jrbOneShot); line1.add(jrbMonteCarlo); 
		line2.add(horizontalSeparator());
		line3.add(jlTimeUnits); line3.add(jtfTimeUnits); 
		line4.add(jlMaxIterations); line4.add(jtfMaxIterations);
		line9.add(horizontalSeparator());
		line11.add(jlSelectExtensions);
		line10.add(jcbPdf); line10.add(jcbDocx); line10.add(jcbXlsx);
		line10.add(jcbPptx); line10.add(jcbOdt); line10.add(jcbHtml);
		line5.add(horizontalSeparator());
		line12.add(jlSelectModelingProject);
		line13.add(jcbModelingProjects);
		line14.add(horizontalSeparator());
		line15.add(jlSelectReportTemplate);
		line16.add(jcbReportTemplates);
		line17.add(horizontalSeparator());
		line6.add(jbStart); line6.add(jbStop);
		line7.add(horizontalSeparator());
		line8.add(loader);
		
		this.add(line1); this.add(line2);
		this.add(line3); this.add(line4);
		this.add(line9); this.add(line11);
		this.add(line10);this.add(line5); 
		this.add(line12); this.add(line13);
		this.add(line14); this.add(line15);
		this.add(line16);this.add(line17); 
		this.add(line6);
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
		
		this.jcbDocx.setEnabled(false); this.jcbPptx.setEnabled(false);
		this.jcbXlsx.setEnabled(false); this.jcbHtml.setEnabled(false);
		this.jcbPdf.setEnabled(false); this.jcbOdt.setEnabled(false);
		
		this.jlSelectModelingProject = new JLabel("Select your modeling project");
		this.jcbModelingProjects = new JComboBox<String>();
		for(String project : WorkspaceManager.getModelingProjects())
			this.jcbModelingProjects.addItem(project);
		this.jcbModelingProjects.setSelectedIndex(0);
		this.jcbModelingProjects.addActionListener(this);
		this.jcbModelingProjects.setEnabled(false);
		
		this.jlSelectReportTemplate = new JLabel("Select the report template you want to use");
		this.jcbReportTemplates = new JComboBox<String>();
		for(String template : WorkspaceManager.getTemplates(this.jcbModelingProjects.getItemAt(0)))
			this.jcbReportTemplates.addItem(template);
		if(this.jcbReportTemplates.getModel().getSize() == 0)
			this.jcbReportTemplates.addItem("No report templates available !");
		this.jcbReportTemplates.setSelectedIndex(0);
		this.jcbReportTemplates.addActionListener(this);
		this.jcbReportTemplates.setEnabled(false);
		
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
	
	/**
	 * 
	 * @author FK
	 * Internal class dedicated to the simulation management (start, stop, loader)
	 */
	private class LoadingBar implements Runnable { 
		@Override
		public void run() {
			jbStart.setEnabled(false);
			while(newSimulation.getLoading() < loader.getMaximum() && !newSimulation.isCanceled())
				loader.setValue(newSimulation.getLoading());
				
			if(!newSimulation.isCanceled()) {
				loader.setValue(loader.getMaximum());
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
			this.jcbDocx.setEnabled(false); this.jcbPptx.setEnabled(false);
			this.jcbXlsx.setEnabled(false); this.jcbHtml.setEnabled(false);
			this.jcbPdf.setEnabled(false); this.jcbOdt.setEnabled(false);
		}
		else if (e.getActionCommand() != null && e.getActionCommand().equals("Monte-Carlo")) {
			this.jtfMaxIterations.setEnabled(true);
			this.jcbDocx.setEnabled(true); this.jcbPptx.setEnabled(true);
			this.jcbXlsx.setEnabled(true); this.jcbHtml.setEnabled(true);
			this.jcbPdf.setEnabled(true); this.jcbOdt.setEnabled(true);
			this.jcbModelingProjects.setEnabled(true); this.jcbReportTemplates.setEnabled(true);
		}
		else if(e.getSource() == this.jcbModelingProjects) {
			this.jcbReportTemplates.removeAllItems();
			for(String template : WorkspaceManager.getTemplates((String) this.jcbModelingProjects.getSelectedItem()))
				this.jcbReportTemplates.addItem(template);
			if(this.jcbReportTemplates.getModel().getSize() == 0)
				this.jcbReportTemplates.addItem("No report templates available !");
			this.jcbReportTemplates.setSelectedIndex(0);
		}
		else {
			if(e.getSource() == this.jbStart) {
				if(jtfTimeUnits.getText().isEmpty()) 
					JOptionPane.showMessageDialog(null, "Time Units value is not set!", "Error", JOptionPane.ERROR_MESSAGE);
				else if (this.jrbMonteCarlo.isSelected() && (jtfMaxIterations.getText().isEmpty()))
					JOptionPane.showMessageDialog(null, "Max Iterations value is not set!", "Error", JOptionPane.ERROR_MESSAGE);
				else if (this.jrbMonteCarlo.isSelected() && jcbReportTemplates.getItemAt(0).equals("No report templates available !")) {
					JOptionPane.showMessageDialog(null, "Report template is not set!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					timeUnits = Integer.parseInt(jtfTimeUnits.getText());
					maxIterations = Integer.parseInt(jtfMaxIterations.getText()); // Extensions chosen by the user
					List<String> extensions = new ArrayList<String>();
					if(this.jrbMonteCarlo.isSelected()) {
						loader.setMaximum(maxIterations);
						WorkspaceManager.SELECTED_PROJECT = (String) this.jcbModelingProjects.getSelectedItem();
						WorkspaceManager.SELECTED_TEMPLATE = (String) this.jcbReportTemplates.getSelectedItem();
						if(this.jcbDocx.isSelected()) extensions.add("docx"); if(this.jcbPdf.isSelected()) extensions.add("pdf");
						if(this.jcbPptx.isSelected()) extensions.add("pptx"); if(this.jcbOdt.isSelected()) extensions.add("odt");
						if(this.jcbXlsx.isSelected()) extensions.add("xlsx"); if(this.jcbHtml.isSelected()) extensions.add("html");
						this.newSimulation = new NewSimulation(model, timeUnits, maxIterations, extensions);
					}
					else {
						loader.setMaximum(timeUnits);
						this.newSimulation = new NewSimulation(model, timeUnits);
					}
					
					simulationThread = new Thread(newSimulation);
					loadingBarThread = new Thread(new LoadingBar());
					simulationThread.start();
					loadingBarThread.start(); 
				}
			}
			else if(e.getSource() == this.jbStop) {
				if(simulationThread != null && loadingBarThread != null && !simulationThread.isInterrupted() && !loadingBarThread.isInterrupted()) {
					newSimulation.setCanceled(true);
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

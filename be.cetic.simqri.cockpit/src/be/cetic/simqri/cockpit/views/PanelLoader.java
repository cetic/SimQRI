package be.cetic.simqri.cockpit.views;

import java.awt.FlowLayout;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;


/**
 * 
 * @author FK
 * @since 02/08/2016
 * @version 2.0
 * This panel contains a progress bar and a label. It is added in the simulation management window 
 * 
 */
public class PanelLoader extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel jlMessage;
	private JProgressBar jpbStatus;
	private int maximum;
	
	public PanelLoader(String message, int maximum) {
		super();
		this.maximum = maximum;
		this.jlMessage = new JLabel(message);
		initComponents();
	}
	
	public void setMessage(String message) {
		this.jlMessage.setText(message);
	}
	
	public JProgressBar getJpbStatus() {
		return jpbStatus;
	}

	public void setJpbStatus(JProgressBar jpbStatus) {
		this.jpbStatus = jpbStatus;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	private void initComponents() {
		this.setLayout(new GridLayout(1, 2));
		
		this.jpbStatus = new JProgressBar();
		this.jpbStatus.setMaximum(maximum);
		this.jpbStatus.setMinimum(0);
		this.jpbStatus.setStringPainted(true);
		
		JPanel line1 = new JPanel();
		line1.setLayout(new FlowLayout());
		JPanel line2 = new JPanel();
		line2.setLayout(new FlowLayout());
		
		line1.add(jlMessage);
		line2.add(jpbStatus);
		
		this.add(line1); 
		this.add(line2);
	}
	
	/**
	 * 
	 * @param message
	 * @param maximum
	 * Called in order to reset the progress bar
	 */
	public void reset(String message, int maximum) {
		this.setMessage(message);
		this.setMaximum(maximum);
		this.jpbStatus.setMaximum(maximum);
		this.jpbStatus.setMinimum(0);
		this.jpbStatus.setValue(0);
	}
	
	public void disposeWindow() {
		SimulationManagementWindow window = (SimulationManagementWindow) SwingUtilities.getWindowAncestor(this);
		window.dispose();
	}
	
}

package be.cetic.simqri.cockpit.views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * 
 * @author FK
 * @since 02/08/2016
 * @version 1.0
 * This window is displayed during the reports generation process.
 * 
 */
public class ReportLoaderWindow extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel jlMessage;
	private JProgressBar jpbStatus;
	private JButton jbCancel;
	private int nbReports;
	private boolean aborted;
	
	public void setJpbStatus(int status) {
		this.jpbStatus.setValue(status);
	}
	
	public int getJpbStatus() {
		return this.jpbStatus.getValue();
	}
	
	public boolean isAborted() {
		return aborted;
	}

	public void setAborted(boolean aborted) {
		this.aborted = aborted;
	}
	
	public ReportLoaderWindow(int nbReports) {
		super("Creating reports");
		this.setResizable(false);
		this.setSize(new Dimension(300, 150));
		this.setAborted(false);
		this.nbReports = nbReports;
		this.setLayout(new GridLayout(3, 1));
		
		initComponents();
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initComponents() {
		this.jlMessage = new JLabel("Results reports are being generated...");
		this.jpbStatus = new JProgressBar();
		this.jpbStatus.setMaximum(nbReports);
		this.jbCancel = new JButton("Cancel");
		this.jbCancel.addActionListener(this);
		
		JPanel line1 = new JPanel();
		line1.setLayout(new FlowLayout());
		JPanel line2 = new JPanel();
		line2.setLayout(new FlowLayout());
		JPanel line3 = new JPanel();
		line3.setLayout(new FlowLayout());
		
		line1.add(jlMessage);
		line2.add(jpbStatus);
		line3.add(jbCancel);
		
		this.add(line1); 
		this.add(line2);
		this.add(line3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.jbCancel) {
			this.setAborted(true);
        	JOptionPane.showMessageDialog(null,  "Process aborted !\nHowever, some reports may have already been generated.", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}
}

package be.cetic.simqri.cockpit.views;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author FK
 * @since 19/04/2016
 * @version 1.0
 * 
 * This is a generic panel that contains a textarea in which a part of simulation results
 * will be displayed once converted into string format.
 */
public class PanelResults extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextArea jtaTrace;
	private String results;
	
	public PanelResults(String results) {
		super();
		this.results = results;
		this.jtaTrace = new JTextArea(27, 60);
		fillJTextArea();
		this.add(jtaTrace);
				
	}
	
	private void fillJTextArea() {
		this.jtaTrace.setText(results);
		this.jtaTrace.setEditable(false);
	}

}

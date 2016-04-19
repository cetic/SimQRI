package be.cetic.simqri.cockpit.views;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelTrace extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextArea jtaTrace;
	private List<List<String>> trace;
	
	public PanelTrace(List<List<String>> trace) {
		super();
		this.trace = trace;
		this.jtaTrace = new JTextArea(27, 60);
		fillJTextArea(trace);
		this.add(jtaTrace);
				
	}
	
	private void fillJTextArea(List<List<String>> trace) {
		// TODO
	}

}

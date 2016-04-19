package be.cetic.simqri.cockpit.views;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelQueries extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextArea jtaTrace;
	private List<List<String>> queries;
	
	public PanelQueries(List<List<String>> queries) {
		super();
		this.queries = queries;
		this.jtaTrace = new JTextArea(27, 60);
		fillJTextArea(queries);
		this.add(jtaTrace);
				
	}
	
	private void fillJTextArea(List<List<String>> trace) {
		// TODO
	}

}

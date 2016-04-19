package be.cetic.simqri.cockpit.views;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelElements extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextArea jtaTrace;
	private List<List<String>> elements;
	
	public PanelElements(List<List<String>> elements) {
		super();
		this.elements = elements;
		this.jtaTrace = new JTextArea(20, 70);
		fillJTextArea(elements);
		this.add(jtaTrace);
				
	}
	
	private void fillJTextArea(List<List<String>> trace) {
		// TODO
	}

}

package be.cetic.simqri.cockpit.views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	
	private JTextArea jtaResults;
	private JScrollPane jspTextArea;
	private String results;
	
	public PanelResults(String results) {
		super();
		this.results = results;
		fillJTextArea();
		this.add(jspTextArea);
				
	}
	
	public String getResults() {
		return results;
	}
	
	private void fillJTextArea() {
		this.jtaResults = new JTextArea(27, 60);
		this.jtaResults.setText(results);
		this.jtaResults.setEditable(false);
		jspTextArea = new JScrollPane(jtaResults, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
	}

}

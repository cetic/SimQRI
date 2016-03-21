package be.cetic.simqri.menu.views;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SimulationDialog extends TitleAreaDialog {
	
	private Button btnOneShot;
	private Button btnMonteCarlo;
	private Text txtTimeUnits;
	private Text txtMaxIterations;
	private int timeUnits;
	private int maxIterations;
	
	public SimulationDialog(Shell parentShell) {
		super(parentShell);
	}
	
	public int getTimeUnits() {
		return this.timeUnits;
	}
	
	public int getMaxIterations() {
		return this.maxIterations;
	}
	
	@Override
	public void create() {
	   super.create();
	   setTitle("Launch a new simulation");
	   setMessage("This window allows you to set parameters for an upcoming simulation", IMessageProvider.INFORMATION);
	}
	
	@Override
	protected boolean isResizable() {
	  return true;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
	   Composite area = (Composite) super.createDialogArea(parent);
	   Composite container = new Composite(area, SWT.NONE);
	   container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	   GridLayout layout = new GridLayout(2, false);
	   container.setLayout(layout);
	   
	   createTimeUnits(container);
	   createBtnOneShot(container);
	   @SuppressWarnings("unused")
	   Label label = new Label(container, SWT.NONE);
	   createMaxIterations(container);
	   createBtnMonteCarlo(container);

	   return container;
	}
	
	private void createTimeUnits(Composite container) {
		Label lbTimeUnits = new Label(container, SWT.None);
		lbTimeUnits.setText("Time Units");
		GridData dataTimeUnits = new GridData();
	    dataTimeUnits.grabExcessHorizontalSpace = true;
	    dataTimeUnits.horizontalAlignment = GridData.FILL;
	    txtTimeUnits = new Text(container, SWT.BORDER);
	    txtTimeUnits.setLayoutData(dataTimeUnits);	
	    txtTimeUnits.setText("1000");
	    txtTimeUnits.addListener(SWT.Verify,  new Listener() {
	    	public void handleEvent(Event e) {
	            String string = e.text;
	            char[] chars = new char[string.length()];
	            string.getChars(0, chars.length, chars, 0);
	            for (int i = 0; i < chars.length; i++) {
	              if (!('0' <= chars[i] && chars[i] <= '9')) {
	                e.doit = false;
	                return;
	              }
	            }
	          }
	    });
	}
	
	private void createMaxIterations(Composite container) {
		Label lbMaxIterations = new Label(container, SWT.None);
		lbMaxIterations.setText("Max Iterations");
		GridData dataMaxIterations = new GridData();
	    dataMaxIterations.grabExcessHorizontalSpace = true;
	    dataMaxIterations.horizontalAlignment = GridData.FILL;
	    txtMaxIterations = new Text(container, SWT.BORDER);
	    txtMaxIterations.setLayoutData(dataMaxIterations);	
	    txtMaxIterations.setText("100");
	    txtMaxIterations.addListener(SWT.Verify,  new Listener() {
	    	public void handleEvent(Event e) {
	            String string = e.text;
	            char[] chars = new char[string.length()];
	            string.getChars(0, chars.length, chars, 0);
	            for (int i = 0; i < chars.length; i++) {
	              if (!('0' <= chars[i] && chars[i] <= '9')) {
	                e.doit = false;
	                return;
	              }
	            }
	          }
	    });
	}
	
	private void createBtnOneShot(Composite container) {
		btnOneShot = new Button(container, SWT.BUTTON1);
		btnOneShot.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnOneShot.setText("Simulate One Shot");
		btnOneShot.addSelectionListener(new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent e) {
		    oneShotSimulation();
		}});
	}
	
	private void createBtnMonteCarlo(Composite container) {
		btnMonteCarlo = new Button(container, SWT.BUTTON2);
		btnMonteCarlo.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnMonteCarlo.setText("Simulate Monte Carlo");
		btnMonteCarlo.addSelectionListener(new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent e) {
		    monteCarloSimulation();
		}});
	}
	
	private void oneShotSimulation() {
		timeUnits = Integer.parseInt(txtTimeUnits.getText().toString());
		maxIterations = Integer.parseInt(txtMaxIterations.getText().toString());
		System.out.println("One shot simulation launched ("+timeUnits+", "+maxIterations+")");
		// TODO
		this.close();
	}
	
	private void monteCarloSimulation() {
		timeUnits = Integer.parseInt(txtTimeUnits.getText().toString());
		maxIterations = Integer.parseInt(txtMaxIterations.getText().toString());
		System.out.println("Monte-Carlo simulation launched ("+timeUnits+", "+maxIterations+")");
		// TODO
		this.close();
	}

}

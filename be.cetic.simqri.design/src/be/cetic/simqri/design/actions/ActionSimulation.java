package be.cetic.simqri.design.actions;

import java.util.Collection;



import java.util.Map;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import be.cetic.simqri.cockpit.main.CheckQueries;
import be.cetic.simqri.cockpit.views.SimulationManagementWindow;
import be.cetic.simqri.design.templates.CheckFlows;
import be.cetic.simqri.design.templates.CheckOutputs;
import be.cetic.simqri.metamodel.Model;

/**
 * 
 * @author FK
 * @version 2.0
 * 
 * This class is used like a "gateway" between the Sirius modeler and the simulator. 
 * It retrieves the drawn "Model" object and transmit it to the "cockpit" project,
 * which displays GUIs related to simulations and queries management and perform 
 * actions through the simulator scala project, which uses OscaR-DES API.
 *
 */
public class ActionSimulation implements IExternalJavaAction {

	public ActionSimulation() {
	}

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		Model model = (Model) parameters.get("model");
		String errMessages = checkModelValidity(model);
		if(errMessages.isEmpty() && CheckQueries.dynamicCheck(model).isEmpty())
			new SimulationManagementWindow(model);
		else if(!CheckQueries.dynamicCheck(model).isEmpty())
			JOptionPane.showMessageDialog(null, "A new simulation will not be launchable due to some errors in your queries !\n","Error", 
					JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "The simulation will not be launchable due to some modeling errors in your diagram : \n"
					+ errMessages, "Error", JOptionPane.ERROR_MESSAGE);
		// Simulation.displaySimulationWindow(model, errMessages); // Former simulation launch cockpit
	}
	
	private String checkModelValidity(Model model) {
		CheckOutputs co = new CheckOutputs();
		CheckFlows cf = new CheckFlows();
		String errMessages = "";
		// errMessages += cf.isLinkedToFlow(model);
		errMessages += co.hasAtLeastASuccessOutput(model);
		errMessages += cf.hasOneFlowFromThatPort(model);
		errMessages += cf.hasOneFlowFromThatStorage(model);
		errMessages += cf.hasOneFlowFromThatSupplier(model);
		errMessages += cf.isProbabilitySet(model);
		return errMessages;
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

}

package be.cetic.simqri.design.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import be.cetic.simqri.cockpit.main.Simulation;
import be.cetic.simqri.design.templates.CheckFlows;
import be.cetic.simqri.design.templates.CheckOutputs;
import be.cetic.simqri.metamodel.Model;

/**
 * 
 * @author FK
 * This class is used like a "gateway" between the Sirius modeler and the simulator. 
 * It retrieves the drawn "Model" object and transmit it to the "cockpit" project,
 * which displays GUIs related to simulations and queries management and perform 
 * actions through the simulator scala project, which uses OscaR-DES API.
 *
 */
public class ActionSimulation implements IExternalJavaAction {

	public ActionSimulation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		Model model = (Model) parameters.get("model");
		boolean valid = checkModelValidity(model);
		Simulation.launch(model, valid);
	}
	
	private boolean checkModelValidity(Model model) {
		CheckOutputs co = new CheckOutputs();
		CheckFlows cf = new CheckFlows();
		if(!co.hasAnOutputOfSuccessType(model) || !co.hasNotTwoOutputsOfSameType(model) || !cf.haseOneFlowFromThatPort(model)
			|| !cf.hasOneFlowFromThatStorage(model) || !cf.hasOneFlowFromThatSupplier(model)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		// TODO Auto-generated method stub
		return true;
	}

}

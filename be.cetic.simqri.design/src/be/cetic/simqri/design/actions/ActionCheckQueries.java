package be.cetic.simqri.design.actions;

import java.util.Collection;


import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import be.cetic.simqri.cockpit.main.CheckQueries;
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
 */
public class ActionCheckQueries implements IExternalJavaAction {

	public ActionCheckQueries() {
	}
	
	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		Model model = (Model) parameters.get("model");
		String errMessages = checkModelValidity(model);
		CheckQueries.check(model, errMessages);
	}
	
	private String checkModelValidity(Model model) {
		CheckOutputs co = new CheckOutputs();
		CheckFlows cf = new CheckFlows();
		String errMessages = "";
		errMessages += cf.isLinkedToFlow(model);
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

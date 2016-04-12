package be.cetic.simqri.design.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import be.cetic.simqri.design.templates.CheckFlows;
import be.cetic.simqri.design.templates.CheckOutputs;
import be.cetic.simqri.metamodel.Model;

public class ActionSimulation implements IExternalJavaAction {

	public ActionSimulation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		// TODO Auto-generated method stub

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

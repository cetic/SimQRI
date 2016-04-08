package be.cetic.simqri.design;

import java.util.Collection;


import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import be.cetic.simqri.cockpit.Test;
import be.cetic.simqri.metamodel.Model;

public class Gateway implements IExternalJavaAction {

	public Gateway() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		// System.out.println("Collection : "+selections.toString());
		Model model = (Model) parameters.get("model");
		Test.test(model);
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		// TODO Auto-generated method stub
		return true;
	}

}

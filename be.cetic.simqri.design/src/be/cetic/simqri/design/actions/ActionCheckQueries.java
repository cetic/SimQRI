package be.cetic.simqri.design.actions;

import java.util.Collection;


import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import be.cetic.simqri.cockpit.main.CheckQueries;
import be.cetic.simqri.metamodel.Model;

public class ActionCheckQueries implements IExternalJavaAction {

	public ActionCheckQueries() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		Model model = (Model) parameters.get("model");
		// TODO Next step : retrieve "println" messages in the window
		CheckQueries.check(model);
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		// TODO Auto-generated method stub
		return true;
	}

}

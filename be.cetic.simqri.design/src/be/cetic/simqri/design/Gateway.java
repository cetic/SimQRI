package be.cetic.simqri.design;

import java.util.Collection;
import java.util.Map;

import javax.swing.JFrame;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

public class Gateway implements IExternalJavaAction {

	public Gateway() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		System.out.println(selections.size());
		JFrame fenetre = new JFrame();
	    fenetre.setVisible(true);
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		// TODO Auto-generated method stub
		return true;
	}

}

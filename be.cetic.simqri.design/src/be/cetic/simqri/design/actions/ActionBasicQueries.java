package be.cetic.simqri.design.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import be.cetic.simqri.metamodel.Component;
import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.metamodel.Query;
import be.cetic.simqri.metamodel.Supplier;
import be.cetic.simqri.metamodel.impl.QueryImpl;

public class ActionBasicQueries implements IExternalJavaAction {

	public ActionBasicQueries() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		Model model = (Model) parameters.get("model");
		addQuery("Number of time units plus 1", "plus(time,1)", model);
		for(Component c : model.getComponent()) {
			if(c instanceof Supplier) {
				Supplier s = (Supplier) c;
				addQuery(s.getName()+" : Number of started batches", "startedBatchCount(\""+s.getName()+"\")", model);
				addQuery(s.getName()+" : Number of completed batches", "completedBatchCount(\""+s.getName()+"\")", model);
				addQuery(s.getName()+" : Percentage of time idle", "div(totalWaitDuration(\""+s.getName()+"\"), time)", model);
			}
		}
	}
	
	private boolean containsQuery(String name, String value, Model model) {
		// TODO Check if the query is not already set before adding it into the model
		// Use the value or (the name and the value) to check it
		return false;
	}
	
	private void addQuery(String name, String value, Model model) {
		if(!containsQuery(name, value, model)) {
			Query q = new QueryImpl();
			q.setName(name); q.setValue(value);
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(model);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				public void doExecute() {
					model.getQuery().add(q);
				}
			});
		}

	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

}

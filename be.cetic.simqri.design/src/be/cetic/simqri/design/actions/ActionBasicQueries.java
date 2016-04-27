package be.cetic.simqri.design.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import be.cetic.simqri.metamodel.BatchProcess;
import be.cetic.simqri.metamodel.Component;
import be.cetic.simqri.metamodel.ConveyorBelt;
import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.metamodel.Query;
import be.cetic.simqri.metamodel.Storage;
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
				addQuery(c.getName()+" : Number of started batches", "startedBatchCount(\""+c.getName()+"\")", model);
				addQuery(c.getName()+" : Number of completed batches", "completedBatchCount(\""+c.getName()+"\")", model);
				addQuery(c.getName()+" : Percentage of time idle", "div(totalWaitDuration(\""+c.getName()+"\"), time)", model);
			}
			else if( c instanceof Storage) {
				Storage s = (Storage) c;
				addQuery(s.getName()+" : Maximum relative stock level", "maxOnHistory(relativeStockLevel(\""+s.getName()+"\"))", model);
				addQuery(s.getName()+" : Average relative stock level", "avgOnHistory(relativeStockLevel(\""+s.getName()+"\"))", model);
				if(s.isOverflow())
					addQuery(s.getName()+" : Total lost by overflow", "totalLostByOverflow(\""+s.getName()+"\")", model);
				else
					addQuery(s.getName()+" : Minimum relative stock level", "minOnHistory(relativeStockLevel(\""+s.getName()+"\"))", model);
			}
			else if (c instanceof BatchProcess || c instanceof ConveyorBelt) {
				addQuery(c.getName()+" : Number of started batches", "startedBatchCount(\""+c.getName()+"\")", model);
				addQuery(c.getName()+" : Number of completed batches", "completedBatchCount(\""+c.getName()+"\")", model);
				addQuery(c.getName()+" : Percentage of time idle", "div(totalWaitDuration(\""+c.getName()+"\"), time)", model);
			}
		}
	}
	
	private boolean containsQuery(String name, String value, Model model) {
		for(Query q : model.getQuery()) {
			if(q.getValue().equals(value))
				return true;
		}
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

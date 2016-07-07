package be.cetic.simqri.design.templates;

import java.util.ArrayList;
import java.util.List;

import be.cetic.simqri.metamodel.*;
import be.cetic.simqri.metamodel.Process;

/**
 * 
 * @author Francois Kouptchinsky
 * @since 24/03/2016
 * @version 2.0
 * 
 * Contains all checks about flows of SimQRi graphical tool
 */
public class CheckFlows {	
	
	/**
	 * 
	 * @param The model of the diagram
	 * @return An error message if there is at least one process of the model that has more than one flow from the same storage. An empty string otherwise.
	 */
	public String hasOneFlowFromThatStorage(Model model) {
		String errMessage = "";
		List<Storage> storages = new ArrayList<Storage>();
		for(Component c : model.getComponent()) {
			if(c instanceof Process) {
				Process p = (Process) c;
				for(StorageOutputFlow sof : p.getStorageOutputFlow()) {
					if(!storages.contains(sof.getSource()))
						storages.add(sof.getSource());
					else 
						errMessage += "> Process ["+p.getName()+"] can only have one flow from the same storage ('"+sof.getSource().getName()+"' here)\n";
				}
			}
			storages.clear();
		}
		return errMessage;
	}
	
	/**
	 * 
	 * @param The model of the diagram
	 * @return An error message if there is at least one storage of the model that has more than one flow from the same supplier. An empty string otherwise.
	 */
	public String hasOneFlowFromThatSupplier(Model model) {
		String errMessage = "";
		List<Supplier> suppliers = new ArrayList<Supplier>();
		for(Component c : model.getComponent()) {
			if(c instanceof Storage) {
				Storage s = (Storage) c;
				for(OrderOnStockThreshold oost : s.getOrderOnStockThreshold()) {
					if(!suppliers.contains(oost.getSupplier())) 
						suppliers.add(oost.getSupplier());
					else 
						errMessage += "> Storage ["+s.getName()+"] can not have several flows from the same supplier ('"+oost.getSupplier().getName()+"' here)\n";
				}
			}
			suppliers.clear();
		}
		return errMessage;
	}
	
	/**
	 * 
	 * @param The model of the diagram
	 * @return An error message if there is at least one storage of the model that has more than one flow from the same port. An empty string otherwise.
	 */
	public String hasOneFlowFromThatPort(Model model) {
		String errMessage = "";
		List<Output> outputs = new ArrayList<Output>();
		for(Component c : model.getComponent()) {
			if(c instanceof Storage) {
				Storage s = (Storage) c;
				for(ProcessOutputFlow pof : s.getProcessOutputFlow()) {
					if(!outputs.contains(pof.getSource())) 
						outputs.add(pof.getSource());
					else 
						errMessage += "> Storage ["+s.getName()+"] can not have several flows from a same output ('"+pof.getSource().getType()+"' here)\n";
				}
			}
			outputs.clear();
		}
		return errMessage;
	}
	/**
	 * 
	 * @param The model of the diagram
	 * @return An error message if there is at least one probability attribute that is not set. An empty string otherwise.
	 */
	public String isProbabilitySet(Model model) {
		String errMessage = "";
		for(Component c : model.getComponent()) {
			if(c instanceof Supplier) {
				Supplier s = (Supplier) c;
				if(s.getSupplierDelay() == null) {
					errMessage += "> The delay of supplier ["+s.getName()+"] is not defined\n";
				}
			}
			else if(c instanceof BatchProcess) {
				BatchProcess bp = (BatchProcess) c;
				if(bp.getDuration() == null) {
					errMessage += "> The duration of batch process ["+bp.getName()+"] is not defined\n";
				}
			}
		}
		for(Flow f : model.getFlow()) {
			if(f.getQuantity() == null) {
				errMessage += "> The quantity of a flow is not set\n";
			}
			if(f instanceof ProcessOutputFlow) {
				ProcessOutputFlow pof = (ProcessOutputFlow) f;
				if(pof.getProcessOutputFlowDelay() == null) {
					errMessage += "> The delay of a process output flow is not set\n";
				}
			}
		}
		return errMessage;
	}
}

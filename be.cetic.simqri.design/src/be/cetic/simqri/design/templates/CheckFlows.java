package be.cetic.simqri.design.templates;

import java.util.ArrayList;
import java.util.List;

import be.cetic.simqri.metamodel.*;
import be.cetic.simqri.metamodel.Process;

/**
 * 
 * @author François Kouptchinsky
 * @since 24/03/2016
 * @version 1.0
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
		List<Storage> storages = new ArrayList<Storage>();
		for(Component c : model.getComponent()) {
			if(c instanceof Process) {
				Process p = (Process) c;
				for(StorageOutputFlow sof : p.getStorageOutputFlow()) {
					if(!storages.contains(sof.getSource()))
						storages.add(sof.getSource());
					else 
						return "> Each process can only have one flow from the same storage\n";
				}
			}
			storages.clear();
		}
		return "";
	}
	
	/**
	 * 
	 * @param The model of the diagram
	 * @return An error message if there is at least one storage of the model that has more than one flow from the same supplier. An empty string otherwise.
	 */
	public String hasOneFlowFromThatSupplier(Model model) {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		for(Component c : model.getComponent()) {
			if(c instanceof Storage) {
				Storage s = (Storage) c;
				for(OrderOnStockThreshold oost : s.getOrderOnStockThreshold()) {
					if(!suppliers.contains(oost.getSupplier())) 
						suppliers.add(oost.getSupplier());
					else 
						return "> Storages can not have several flows from the same supplier\n";
				}
			}
			suppliers.clear();
		}
		return "";
	}
	
	/**
	 * 
	 * @param The model of the diagram
	 * @return An error message if there is at least one storage of the model that has more than one flow from the same port. An empty string otherwise.
	 */
	public String hasOneFlowFromThatPort(Model model) {
		List<Output> outputs = new ArrayList<Output>();
		for(Component c : model.getComponent()) {
			if(c instanceof Storage) {
				Storage s = (Storage) c;
				for(ProcessOutputFlow pof : s.getProcessOutputFlow()) {
					if(!outputs.contains(pof.getSource())) 
						outputs.add(pof.getSource());
					else 
						return "> Storages can not have several flows from the same output\n";
				}
			}
			outputs.clear();
		}
		return "";
	}
}

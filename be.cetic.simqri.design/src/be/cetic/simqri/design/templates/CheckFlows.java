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
	
	// private List<Process> processes = new ArrayList<Process>();
	
	
	/**
	 * 
	 * @param The model of the diagram
	 * @return False if at least one process of the model has more than one flow from the same storage. True otherwise.
	 */
	public boolean hasOneFlowFromThatStorage(Model model) {
		List<Storage> storages = new ArrayList<Storage>();
		for(Component c : model.getComponent()) {
			if(c instanceof Process) {
				Process p = (Process) c;
				for(StorageOutputFlow sof : p.getStorageOutputFlow()) {
					if(!storages.contains(sof.getSource()))
						storages.add(sof.getSource());
					else 
						return false;
				}
			}
			storages.clear();
		}
		return true;
	}
	
	/**
	 * 
	 * @param The model of the diagram
	 * @return False if at least one storage of the model has more than one flow from the same supplier. True otherwise.
	 */
	public boolean hasOneFlowFromThatSupplier(Model model) {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		for(Component c : model.getComponent()) {
			if(c instanceof Storage) {
				Storage s = (Storage) c;
				for(OrderOnStockThreshold oost : s.getOrderOnStockThreshold()) {
					if(!suppliers.contains(oost.getSupplier())) 
						suppliers.add(oost.getSupplier());
					else 
						return false;
				}
			}
			suppliers.clear();
		}
		return true;
	}
	
	/**
	 * 
	 * @param The model of the diagram
	 * @return False if at least one storage of the model has more than one flow from the same port. True otherwise.
	 */
	public boolean haseOneFlowFromThatPort(Model model) {
		List<Output> outputs = new ArrayList<Output>();
		for(Component c : model.getComponent()) {
			if(c instanceof Storage) {
				Storage s = (Storage) c;
				for(ProcessOutputFlow pof : s.getProcessOutputFlow()) {
					if(!outputs.contains(pof.getSource())) 
						outputs.add(pof.getSource());
					else 
						return false;
				}
			}
			outputs.clear();
		}
		return true;
	}
}

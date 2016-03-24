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
	private List<Storage> storages = new ArrayList<Storage>();
	
	public boolean hasOneFlowFromThatStorage(Model model) {
		for(Component c : model.getComponent()) {
			if(c instanceof Process) {
				Process p = (Process) c;
				for(StorageOutputFlow sof : p.getStorageOutputFlow()) {
					if(!storages.contains(sof.getSource())) {
						storages.add(sof.getSource());
					}
					else {
						return false;
					}
				}
			}
			storages.clear();
		}
		return true;
	}
}

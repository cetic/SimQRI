package be.cetic.simqri.design.templates;

import java.util.ArrayList;
import java.util.List;

import be.cetic.simqri.metamodel.BatchProcess;
import be.cetic.simqri.metamodel.Component;
import be.cetic.simqri.metamodel.ConveyorBelt;
import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.metamodel.Output;
import be.cetic.simqri.metamodel.OutputType;

/**
 * 
 * @author François Kouptchinsky
 * @since 24/03/2016
 * @version 1.0
 * 
 * Contains all checks about ports (process outputs) of SimQRi graphical tool
 */
public class CheckOutputs {
	
	private List<OutputType> outputTypes = new ArrayList<OutputType>();
	
	/**
	 * 
	 * @param The root model of the diagram
	 * @return false if at least one process of the model has two outputs of the same type. True otherwise.
	 */
	public boolean hasNotTwoOutputsOfSameType(Model model) {
		BatchProcess bp = null;
		OutputType  outputType = null;
		for(Component c : model.getComponent()) {
			if(c instanceof BatchProcess) {
				bp = (BatchProcess) c;
				for(Output output : bp.getOutputs()) {
					outputType = output.getType();
					if(!outputTypes.contains(outputType)) 
						outputTypes.add(outputType);
					else 
						return false;
				}
				// Check if the process contains at least one "success" output if he contains some outputs
				if(!outputTypes.isEmpty() && !outputTypes.contains(OutputType.SUCCESS)) {
					return false;
				}
			}
			outputTypes.clear();
		}
		return true;
	}
	
	/**
	 * 
	 * @param The root model of the diagram
	 * @return false if at least one conveyor belt of the model has not a success output. True otherwise.
	 */
	public boolean hasAnOutputOfSuccessType(Model model) {
		ConveyorBelt cb = null;
		for(Component c : model.getComponent()) {
			if(c instanceof ConveyorBelt) {
				cb = (ConveyorBelt) c;
				if(cb.getOutput() != null && cb.getOutput().getType() != OutputType.SUCCESS)
					return false;
			}
		}
		return true;
	}
}

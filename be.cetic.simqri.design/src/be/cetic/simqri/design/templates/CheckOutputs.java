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
 * @version 2.0
 * 
 * Contains all checks about ports (process outputs) of SimQRi graphical tool
 */
public class CheckOutputs {
	
	private List<OutputType> outputTypes = new ArrayList<OutputType>();
	
	/**
	 * 
	 * @param The root model of the diagram
	 * @return An error message if there is at least one process of the model that has two outputs of the same type. An empty string otherwise.
	 */
	public String hasNotTwoOutputsOfSameType(Model model) {
		String errMessage = "";
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
						errMessage += "> Process "+bp.getName()+" has two outputs of the same type ("+outputType+" here)\n";
				}
				// Check if the process contains at least one "success" output if he contains some outputs
				if(!outputTypes.isEmpty() && !outputTypes.contains(OutputType.SUCCESS)) {
					errMessage += "> Process "+bp.getName()+" need a \"success\" output\n";
				}
			}
			outputTypes.clear();
		}
		return errMessage;
	}
	
	/**
	 * 
	 * @param The root model of the diagram
	 * @return A warning message if there is at least one conveyor belt of the model that has not a success output. An empty string otherwise.
	 * /!\ The type of the output will not influence the execution of the simulation
	 */
	public String hasAnOutputOfSuccessType(Model model) {
		String errMessage = "";
		ConveyorBelt cb = null;
		for(Component c : model.getComponent()) {
			if(c instanceof ConveyorBelt) {
				cb = (ConveyorBelt) c;
				if(cb.getOutput() != null && cb.getOutput().getType() != OutputType.SUCCESS)
					errMessage += "> The output port of the conveyor belt "+cb.getName()+" has to be a \"SUCCESS\" output. Whatever its type, it will be considered as such.\n";
			}
		}
		return errMessage;
	}
}

/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface BatchProcessPropertiesEditionPart {

	/**
	 * @return the name
	 * 
	 */
	public String getName();

	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 * 
	 */
	public void setName(String newValue);


	/**
	 * @return the duration
	 * 
	 */
	public String getDuration();

	/**
	 * Defines a new duration
	 * @param newValue the new duration to set
	 * 
	 */
	public void setDuration(String newValue);


	/**
	 * @return the percentageOfSuccess
	 * 
	 */
	public String getPercentageOfSuccess();

	/**
	 * Defines a new percentageOfSuccess
	 * @param newValue the new percentageOfSuccess to set
	 * 
	 */
	public void setPercentageOfSuccess(String newValue);


	/**
	 * @return the numberOfLines
	 * 
	 */
	public String getNumberOfLines();

	/**
	 * Defines a new numberOfLines
	 * @param newValue the new numberOfLines to set
	 * 
	 */
	public void setNumberOfLines(String newValue);




	/**
	 * Init the outputs
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initOutputs(ReferencesTableSettings settings);

	/**
	 * Update the outputs
	 * @param newValue the outputs to update
	 * 
	 */
	public void updateOutputs();

	/**
	 * Adds the given filter to the outputs edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToOutputs(ViewerFilter filter);

	/**
	 * Adds the given filter to the outputs edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToOutputs(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the outputs table
	 * 
	 */
	public boolean isContainedInOutputsTable(EObject element);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}

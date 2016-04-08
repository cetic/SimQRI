/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface OutputPropertiesEditionPart {

	/**
	 * @return the type
	 * 
	 */
	public Enumerator getType();

	/**
	 * Init the type
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initType(Object input, Enumerator current);

	/**
	 * Defines a new type
	 * @param newValue the new type to set
	 * 
	 */
	public void setType(Enumerator newValue);




	/**
	 * Init the processOutputFlow
	 * @param settings settings for the processOutputFlow ReferencesTable 
	 */
	public void initProcessOutputFlow(ReferencesTableSettings settings);

	/**
	 * Update the processOutputFlow
	 * @param newValue the processOutputFlow to update
	 * 
	 */
	public void updateProcessOutputFlow();

	/**
	 * Adds the given filter to the processOutputFlow edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToProcessOutputFlow(ViewerFilter filter);

	/**
	 * Adds the given filter to the processOutputFlow edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToProcessOutputFlow(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the processOutputFlow table
	 * 
	 */
	public boolean isContainedInProcessOutputFlowTable(EObject element);


	/**
	 * @return the description
	 * 
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * @param newValue the new description to set
	 * 
	 */
	public void setDescription(String newValue);





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

/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface ConveyorBeltPropertiesEditionPart {

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
	 * Init the storageOutputFlow
	 * @param settings settings for the storageOutputFlow ReferencesTable 
	 */
	public void initStorageOutputFlow(ReferencesTableSettings settings);

	/**
	 * Update the storageOutputFlow
	 * @param newValue the storageOutputFlow to update
	 * 
	 */
	public void updateStorageOutputFlow();

	/**
	 * Adds the given filter to the storageOutputFlow edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToStorageOutputFlow(ViewerFilter filter);

	/**
	 * Adds the given filter to the storageOutputFlow edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToStorageOutputFlow(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the storageOutputFlow table
	 * 
	 */
	public boolean isContainedInStorageOutputFlowTable(EObject element);


	/**
	 * @return the minimalSeparationBetweenBatches
	 * 
	 */
	public String getMinimalSeparationBetweenBatches();

	/**
	 * Defines a new minimalSeparationBetweenBatches
	 * @param newValue the new minimalSeparationBetweenBatches to set
	 * 
	 */
	public void setMinimalSeparationBetweenBatches(String newValue);


	/**
	 * @return the output
	 * 
	 */
	public EObject getOutput();

	/**
	 * Init the output
	 * @param settings the combo setting
	 */
	public void initOutput(EObjectFlatComboSettings settings);

	/**
	 * Defines a new output
	 * @param newValue the new output to set
	 * 
	 */
	public void setOutput(EObject newValue);





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

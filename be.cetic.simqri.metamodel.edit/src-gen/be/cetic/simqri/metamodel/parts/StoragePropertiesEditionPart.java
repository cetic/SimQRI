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
public interface StoragePropertiesEditionPart {

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
	 * @return the size
	 * 
	 */
	public String getSize();

	/**
	 * Defines a new size
	 * @param newValue the new size to set
	 * 
	 */
	public void setSize(String newValue);


	/**
	 * @return the initialContent
	 * 
	 */
	public String getInitialContent();

	/**
	 * Defines a new initialContent
	 * @param newValue the new initialContent to set
	 * 
	 */
	public void setInitialContent(String newValue);


	/**
	 * @return the overflow
	 * 
	 */
	public Boolean getOverflow();

	/**
	 * Defines a new overflow
	 * @param newValue the new overflow to set
	 * 
	 */
	public void setOverflow(Boolean newValue);




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
	 * Init the orderOnStockThreshold
	 * @param settings settings for the orderOnStockThreshold ReferencesTable 
	 */
	public void initOrderOnStockThreshold(ReferencesTableSettings settings);

	/**
	 * Update the orderOnStockThreshold
	 * @param newValue the orderOnStockThreshold to update
	 * 
	 */
	public void updateOrderOnStockThreshold();

	/**
	 * Adds the given filter to the orderOnStockThreshold edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToOrderOnStockThreshold(ViewerFilter filter);

	/**
	 * Adds the given filter to the orderOnStockThreshold edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToOrderOnStockThreshold(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the orderOnStockThreshold table
	 * 
	 */
	public boolean isContainedInOrderOnStockThresholdTable(EObject element);




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
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}

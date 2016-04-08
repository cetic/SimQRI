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
public interface SupplierPropertiesEditionPart {

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
	 * @return the deliveredPercentage
	 * 
	 */
	public String getDeliveredPercentage();

	/**
	 * Defines a new deliveredPercentage
	 * @param newValue the new deliveredPercentage to set
	 * 
	 */
	public void setDeliveredPercentage(String newValue);




	/**
	 * Init the refillPolicy
	 * @param settings settings for the refillPolicy ReferencesTable 
	 */
	public void initRefillPolicy(ReferencesTableSettings settings);

	/**
	 * Update the refillPolicy
	 * @param newValue the refillPolicy to update
	 * 
	 */
	public void updateRefillPolicy();

	/**
	 * Adds the given filter to the refillPolicy edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToRefillPolicy(ViewerFilter filter);

	/**
	 * Adds the given filter to the refillPolicy edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToRefillPolicy(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the refillPolicy table
	 * 
	 */
	public boolean isContainedInRefillPolicyTable(EObject element);


	/**
	 * @return the supplierDelay
	 * 
	 */
	public EObject getSupplierDelay();

	/**
	 * Init the supplierDelay
	 * @param settings the combo setting
	 */
	public void initSupplierDelay(EObjectFlatComboSettings settings);

	/**
	 * Defines a new supplierDelay
	 * @param newValue the new supplierDelay to set
	 * 
	 */
	public void setSupplierDelay(EObject newValue);





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

/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface OrderOnStockThresholdPropertiesEditionPart {

	/**
	 * @return the period
	 * 
	 */
	public String getPeriod();

	/**
	 * Defines a new period
	 * @param newValue the new period to set
	 * 
	 */
	public void setPeriod(String newValue);


	/**
	 * @return the threshold
	 * 
	 */
	public String getThreshold();

	/**
	 * Defines a new threshold
	 * @param newValue the new threshold to set
	 * 
	 */
	public void setThreshold(String newValue);


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
	 * @return the orderQuantity
	 * 
	 */
	public String getOrderQuantity();

	/**
	 * Defines a new orderQuantity
	 * @param newValue the new orderQuantity to set
	 * 
	 */
	public void setOrderQuantity(String newValue);


	/**
	 * @return the orderType
	 * 
	 */
	public Enumerator getOrderType();

	/**
	 * Init the orderType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initOrderType(Object input, Enumerator current);

	/**
	 * Defines a new orderType
	 * @param newValue the new orderType to set
	 * 
	 */
	public void setOrderType(Enumerator newValue);


	/**
	 * @return the supplier
	 * 
	 */
	public EObject getSupplier();

	/**
	 * Init the supplier
	 * @param settings the combo setting
	 */
	public void initSupplier(EObjectFlatComboSettings settings);

	/**
	 * Defines a new supplier
	 * @param newValue the new supplier to set
	 * 
	 */
	public void setSupplier(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setSupplierButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the supplier edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSupplier(ViewerFilter filter);

	/**
	 * Adds the given filter to the supplier edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSupplier(ViewerFilter filter);


	/**
	 * @return the storage
	 * 
	 */
	public EObject getStorage();

	/**
	 * Init the storage
	 * @param settings the combo setting
	 */
	public void initStorage(EObjectFlatComboSettings settings);

	/**
	 * Defines a new storage
	 * @param newValue the new storage to set
	 * 
	 */
	public void setStorage(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setStorageButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the storage edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToStorage(ViewerFilter filter);

	/**
	 * Adds the given filter to the storage edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToStorage(ViewerFilter filter);





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

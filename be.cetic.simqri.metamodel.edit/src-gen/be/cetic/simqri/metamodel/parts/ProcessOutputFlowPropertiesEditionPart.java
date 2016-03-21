/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface ProcessOutputFlowPropertiesEditionPart {

	/**
	 * @return the destination
	 * 
	 */
	public EObject getDestination();

	/**
	 * Init the destination
	 * @param settings the combo setting
	 */
	public void initDestination(EObjectFlatComboSettings settings);

	/**
	 * Defines a new destination
	 * @param newValue the new destination to set
	 * 
	 */
	public void setDestination(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setDestinationButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the destination edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToDestination(ViewerFilter filter);

	/**
	 * Adds the given filter to the destination edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToDestination(ViewerFilter filter);


	/**
	 * @return the source
	 * 
	 */
	public EObject getSource();

	/**
	 * Init the source
	 * @param settings the combo setting
	 */
	public void initSource(EObjectFlatComboSettings settings);

	/**
	 * Defines a new source
	 * @param newValue the new source to set
	 * 
	 */
	public void setSource(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setSourceButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the source edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSource(ViewerFilter filter);

	/**
	 * Adds the given filter to the source edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSource(ViewerFilter filter);


	/**
	 * @return the quantity
	 * 
	 */
	public EObject getQuantity();

	/**
	 * Init the quantity
	 * @param settings the combo setting
	 */
	public void initQuantity(EObjectFlatComboSettings settings);

	/**
	 * Defines a new quantity
	 * @param newValue the new quantity to set
	 * 
	 */
	public void setQuantity(EObject newValue);


	/**
	 * @return the delay
	 * 
	 */
	public EObject getDelay();

	/**
	 * Init the delay
	 * @param settings the combo setting
	 */
	public void initDelay(EObjectFlatComboSettings settings);

	/**
	 * Defines a new delay
	 * @param newValue the new delay to set
	 * 
	 */
	public void setDelay(EObject newValue);





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

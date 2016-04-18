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
public interface ModelPropertiesEditionPart {

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
	 * Init the query
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initQuery(ReferencesTableSettings settings);

	/**
	 * Update the query
	 * @param newValue the query to update
	 * 
	 */
	public void updateQuery();

	/**
	 * Adds the given filter to the query edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToQuery(ViewerFilter filter);

	/**
	 * Adds the given filter to the query edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToQuery(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the query table
	 * 
	 */
	public boolean isContainedInQueryTable(EObject element);




	/**
	 * Init the component
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initComponent(ReferencesTableSettings settings);

	/**
	 * Update the component
	 * @param newValue the component to update
	 * 
	 */
	public void updateComponent();

	/**
	 * Adds the given filter to the component edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToComponent(ViewerFilter filter);

	/**
	 * Adds the given filter to the component edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToComponent(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the component table
	 * 
	 */
	public boolean isContainedInComponentTable(EObject element);




	/**
	 * Init the flow
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initFlow(ReferencesTableSettings settings);

	/**
	 * Update the flow
	 * @param newValue the flow to update
	 * 
	 */
	public void updateFlow();

	/**
	 * Adds the given filter to the flow edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToFlow(ViewerFilter filter);

	/**
	 * Adds the given filter to the flow edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToFlow(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the flow table
	 * 
	 */
	public boolean isContainedInFlowTable(EObject element);





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

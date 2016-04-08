/**
 */
package be.cetic.simqri.metamodel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.Process#getStorageOutputFlow <em>Storage Output Flow</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Process#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getProcess()
 * @model abstract="true"
 * @generated
 */
public interface Process extends Component {
	/**
	 * Returns the value of the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' containment reference.
	 * @see #setDuration(Probability)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getProcess_Duration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Probability getDuration();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Process#getDuration <em>Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' containment reference.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(Probability value);

	/**
	 * Returns the value of the '<em><b>Storage Output Flow</b></em>' reference list.
	 * The list contents are of type {@link be.cetic.simqri.metamodel.StorageOutputFlow}.
	 * It is bidirectional and its opposite is '{@link be.cetic.simqri.metamodel.StorageOutputFlow#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Storage Output Flow</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storage Output Flow</em>' reference list.
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getProcess_StorageOutputFlow()
	 * @see be.cetic.simqri.metamodel.StorageOutputFlow#getDestination
	 * @model opposite="destination"
	 * @generated
	 */
	EList<StorageOutputFlow> getStorageOutputFlow();

} // Process

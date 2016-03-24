/**
 */
package be.cetic.simqri.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Storage Output Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.StorageOutputFlow#getSource <em>Source</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.StorageOutputFlow#getDestination <em>Destination</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getStorageOutputFlow()
 * @model
 * @generated
 */
public interface StorageOutputFlow extends Flow {
	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link be.cetic.simqri.metamodel.Process#getStorageOutputFlow <em>Storage Output Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(be.cetic.simqri.metamodel.Process)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getStorageOutputFlow_Destination()
	 * @see be.cetic.simqri.metamodel.Process#getStorageOutputFlow
	 * @model opposite="storageOutputFlow" required="true"
	 * @generated
	 */
	be.cetic.simqri.metamodel.Process getDestination();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.StorageOutputFlow#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(be.cetic.simqri.metamodel.Process value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link be.cetic.simqri.metamodel.Storage#getStorageOutputFlow <em>Storage Output Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Storage)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getStorageOutputFlow_Source()
	 * @see be.cetic.simqri.metamodel.Storage#getStorageOutputFlow
	 * @model opposite="storageOutputFlow" required="true"
	 * @generated
	 */
	Storage getSource();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.StorageOutputFlow#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Storage value);

} // StorageOutputFlow

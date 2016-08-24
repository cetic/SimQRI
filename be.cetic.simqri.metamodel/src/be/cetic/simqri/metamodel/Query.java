/**
 */
package be.cetic.simqri.metamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.Query#getName <em>Name</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Query#getValue <em>Value</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Query#getError <em>Error</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Query#getType <em>Type</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Query#isSystem <em>System</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getQuery()
 * @model
 * @generated
 */
public interface Query extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"query"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getQuery_Name()
	 * @model default="query"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Query#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getQuery_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Query#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error</em>' attribute.
	 * @see #setError(String)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getQuery_Error()
	 * @model
	 * @generated
	 */
	String getError();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Query#getError <em>Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error</em>' attribute.
	 * @see #getError()
	 * @generated
	 */
	void setError(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"UNDEFINED"</code>.
	 * The literals are from the enumeration {@link be.cetic.simqri.metamodel.QueryType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see be.cetic.simqri.metamodel.QueryType
	 * @see #setType(QueryType)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getQuery_Type()
	 * @model default="UNDEFINED"
	 * @generated
	 */
	QueryType getType();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Query#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see be.cetic.simqri.metamodel.QueryType
	 * @see #getType()
	 * @generated
	 */
	void setType(QueryType value);

	/**
	 * Returns the value of the '<em><b>System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' attribute.
	 * @see #setSystem(boolean)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getQuery_System()
	 * @model
	 * @generated
	 */
	boolean isSystem();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Query#isSystem <em>System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' attribute.
	 * @see #isSystem()
	 * @generated
	 */
	void setSystem(boolean value);

} // Query

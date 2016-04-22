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
 *   <li>{@link be.cetic.simqri.metamodel.Query#getResult <em>Result</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Query#getMax <em>Max</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Query#getMin <em>Min</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Query#getMean <em>Mean</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Query#getVariance <em>Variance</em>}</li>
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
	 * Returns the value of the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(String)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getQuery_Result()
	 * @model
	 * @generated
	 */
	String getResult();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Query#getResult <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(String value);

	/**
	 * Returns the value of the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max</em>' attribute.
	 * @see #setMax(String)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getQuery_Max()
	 * @model
	 * @generated
	 */
	String getMax();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Query#getMax <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max</em>' attribute.
	 * @see #getMax()
	 * @generated
	 */
	void setMax(String value);

	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #setMin(String)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getQuery_Min()
	 * @model
	 * @generated
	 */
	String getMin();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Query#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' attribute.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(String value);

	/**
	 * Returns the value of the '<em><b>Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mean</em>' attribute.
	 * @see #setMean(String)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getQuery_Mean()
	 * @model
	 * @generated
	 */
	String getMean();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Query#getMean <em>Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mean</em>' attribute.
	 * @see #getMean()
	 * @generated
	 */
	void setMean(String value);

	/**
	 * Returns the value of the '<em><b>Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variance</em>' attribute.
	 * @see #setVariance(String)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getQuery_Variance()
	 * @model
	 * @generated
	 */
	String getVariance();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Query#getVariance <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variance</em>' attribute.
	 * @see #getVariance()
	 * @generated
	 */
	void setVariance(String value);

} // Query

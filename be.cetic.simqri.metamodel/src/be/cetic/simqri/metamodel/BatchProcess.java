/**
 */
package be.cetic.simqri.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Batch Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.BatchProcess#getPercentageOfSuccess <em>Percentage Of Success</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.BatchProcess#getNumberOfLines <em>Number Of Lines</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.BatchProcess#getOutputs <em>Outputs</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getBatchProcess()
 * @model
 * @generated
 */
public interface BatchProcess extends be.cetic.simqri.metamodel.Process {
	/**
	 * Returns the value of the '<em><b>Percentage Of Success</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percentage Of Success</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percentage Of Success</em>' attribute.
	 * @see #setPercentageOfSuccess(Double)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getBatchProcess_PercentageOfSuccess()
	 * @model default="100" dataType="be.cetic.simqri.metamodel.Percent"
	 * @generated
	 */
	Double getPercentageOfSuccess();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.BatchProcess#getPercentageOfSuccess <em>Percentage Of Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percentage Of Success</em>' attribute.
	 * @see #getPercentageOfSuccess()
	 * @generated
	 */
	void setPercentageOfSuccess(Double value);

	/**
	 * Returns the value of the '<em><b>Number Of Lines</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Lines</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Lines</em>' attribute.
	 * @see #setNumberOfLines(Integer)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getBatchProcess_NumberOfLines()
	 * @model default="3" dataType="be.cetic.simqri.metamodel.PositiveIntNotNull"
	 * @generated
	 */
	Integer getNumberOfLines();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.BatchProcess#getNumberOfLines <em>Number Of Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Lines</em>' attribute.
	 * @see #getNumberOfLines()
	 * @generated
	 */
	void setNumberOfLines(Integer value);

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link be.cetic.simqri.metamodel.Output}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getBatchProcess_Outputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Output> getOutputs();

} // BatchProcess

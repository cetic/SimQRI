/**
 */
package be.cetic.simqri.metamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ghost Batch Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.GhostBatchProcess#getPercentageOfSuccess <em>Percentage Of Success</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.GhostBatchProcess#getNumberOfLines <em>Number Of Lines</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getGhostBatchProcess()
 * @model
 * @generated
 */
public interface GhostBatchProcess extends EObject {
	/**
	 * Returns the value of the '<em><b>Percentage Of Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percentage Of Success</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percentage Of Success</em>' attribute.
	 * @see #setPercentageOfSuccess(double)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getGhostBatchProcess_PercentageOfSuccess()
	 * @model
	 * @generated
	 */
	double getPercentageOfSuccess();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.GhostBatchProcess#getPercentageOfSuccess <em>Percentage Of Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percentage Of Success</em>' attribute.
	 * @see #getPercentageOfSuccess()
	 * @generated
	 */
	void setPercentageOfSuccess(double value);

	/**
	 * Returns the value of the '<em><b>Number Of Lines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Lines</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Lines</em>' attribute.
	 * @see #setNumberOfLines(int)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getGhostBatchProcess_NumberOfLines()
	 * @model
	 * @generated
	 */
	int getNumberOfLines();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.GhostBatchProcess#getNumberOfLines <em>Number Of Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Lines</em>' attribute.
	 * @see #getNumberOfLines()
	 * @generated
	 */
	void setNumberOfLines(int value);

} // GhostBatchProcess

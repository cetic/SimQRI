/**
 */
package be.cetic.simqri.metamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.Output#getType <em>Type</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Output#getProcessOutputFlow <em>Process Output Flow</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Output#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getOutput()
 * @model
 * @generated
 */
public interface Output extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link be.cetic.simqri.metamodel.OutputType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see be.cetic.simqri.metamodel.OutputType
	 * @see #setType(OutputType)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getOutput_Type()
	 * @model
	 * @generated
	 */
	OutputType getType();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Output#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see be.cetic.simqri.metamodel.OutputType
	 * @see #getType()
	 * @generated
	 */
	void setType(OutputType value);

	/**
	 * Returns the value of the '<em><b>Process Output Flow</b></em>' reference list.
	 * The list contents are of type {@link be.cetic.simqri.metamodel.ProcessOutputFlow}.
	 * It is bidirectional and its opposite is '{@link be.cetic.simqri.metamodel.ProcessOutputFlow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Output Flow</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Output Flow</em>' reference list.
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getOutput_ProcessOutputFlow()
	 * @see be.cetic.simqri.metamodel.ProcessOutputFlow#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<ProcessOutputFlow> getProcessOutputFlow();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getOutput_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Output#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // Output

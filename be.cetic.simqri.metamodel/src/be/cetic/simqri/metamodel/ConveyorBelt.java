/**
 */
package be.cetic.simqri.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conveyor Belt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.ConveyorBelt#getMinimalSeparationBetweenBatches <em>Minimal Separation Between Batches</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.ConveyorBelt#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getConveyorBelt()
 * @model
 * @generated
 */
public interface ConveyorBelt extends be.cetic.simqri.metamodel.Process {
	/**
	 * Returns the value of the '<em><b>Minimal Separation Between Batches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimal Separation Between Batches</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimal Separation Between Batches</em>' attribute.
	 * @see #setMinimalSeparationBetweenBatches(Double)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getConveyorBelt_MinimalSeparationBetweenBatches()
	 * @model dataType="be.cetic.simqri.metamodel.PositiveDouble"
	 * @generated
	 */
	Double getMinimalSeparationBetweenBatches();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.ConveyorBelt#getMinimalSeparationBetweenBatches <em>Minimal Separation Between Batches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimal Separation Between Batches</em>' attribute.
	 * @see #getMinimalSeparationBetweenBatches()
	 * @generated
	 */
	void setMinimalSeparationBetweenBatches(Double value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference.
	 * @see #setOutput(Output)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getConveyorBelt_Output()
	 * @model containment="true"
	 * @generated
	 */
	Output getOutput();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.ConveyorBelt#getOutput <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' containment reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Output value);

} // ConveyorBelt

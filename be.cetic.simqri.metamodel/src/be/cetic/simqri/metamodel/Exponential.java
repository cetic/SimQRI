/**
 */
package be.cetic.simqri.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exponential</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.Exponential#getScale <em>Scale</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getExponential()
 * @model
 * @generated
 */
public interface Exponential extends Distribution {
	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see #setScale(Double)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getExponential_Scale()
	 * @model default="1" dataType="be.cetic.simqri.metamodel.PositiveDoubleNotNull"
	 * @generated
	 */
	Double getScale();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Exponential#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #getScale()
	 * @generated
	 */
	void setScale(Double value);

} // Exponential

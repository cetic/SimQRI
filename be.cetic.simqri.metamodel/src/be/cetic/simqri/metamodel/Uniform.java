/**
 */
package be.cetic.simqri.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uniform</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.Uniform#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Uniform#getMaximum <em>Maximum</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getUniform()
 * @model
 * @generated
 */
public interface Uniform extends Distribution {
	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum</em>' attribute.
	 * @see #setMinimum(double)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getUniform_Minimum()
	 * @model default="0.0"
	 * @generated
	 */
	double getMinimum();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Uniform#getMinimum <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' attribute.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(double value);

	/**
	 * Returns the value of the '<em><b>Maximum</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum</em>' attribute.
	 * @see #setMaximum(double)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getUniform_Maximum()
	 * @model default="0.0"
	 * @generated
	 */
	double getMaximum();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Uniform#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(double value);

} // Uniform

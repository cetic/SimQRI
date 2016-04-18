/**
 */
package be.cetic.simqri.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Geometric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.Geometric#getProbaOfSuccess <em>Proba Of Success</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getGeometric()
 * @model
 * @generated
 */
public interface Geometric extends Distribution {
	/**
	 * Returns the value of the '<em><b>Proba Of Success</b></em>' attribute.
	 * The default value is <code>"0.1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proba Of Success</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proba Of Success</em>' attribute.
	 * @see #setProbaOfSuccess(Double)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getGeometric_ProbaOfSuccess()
	 * @model default="0.1" dataType="be.cetic.simqri.metamodel.ProbaDoubleNotNull"
	 * @generated
	 */
	Double getProbaOfSuccess();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Geometric#getProbaOfSuccess <em>Proba Of Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proba Of Success</em>' attribute.
	 * @see #getProbaOfSuccess()
	 * @generated
	 */
	void setProbaOfSuccess(Double value);

} // Geometric

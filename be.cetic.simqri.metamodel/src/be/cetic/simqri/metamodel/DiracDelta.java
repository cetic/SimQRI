/**
 */
package be.cetic.simqri.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dirac Delta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.DiracDelta#getMean <em>Mean</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getDiracDelta()
 * @model
 * @generated
 */
public interface DiracDelta extends Distribution {
	/**
	 * Returns the value of the '<em><b>Mean</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mean</em>' attribute.
	 * @see #setMean(Integer)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getDiracDelta_Mean()
	 * @model default="1" dataType="be.cetic.simqri.metamodel.PositiveIntNotNull"
	 * @generated
	 */
	Integer getMean();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.DiracDelta#getMean <em>Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mean</em>' attribute.
	 * @see #getMean()
	 * @generated
	 */
	void setMean(Integer value);

} // DiracDelta

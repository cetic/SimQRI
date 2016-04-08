/**
 */
package be.cetic.simqri.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Chi Square</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.ChiSquare#getDegreeOfFreedom <em>Degree Of Freedom</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getChiSquare()
 * @model
 * @generated
 */
public interface ChiSquare extends Distribution {
	/**
	 * Returns the value of the '<em><b>Degree Of Freedom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Degree Of Freedom</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Degree Of Freedom</em>' attribute.
	 * @see #setDegreeOfFreedom(Integer)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getChiSquare_DegreeOfFreedom()
	 * @model dataType="be.cetic.simqri.metamodel.PositiveIntNotNull"
	 * @generated
	 */
	Integer getDegreeOfFreedom();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.ChiSquare#getDegreeOfFreedom <em>Degree Of Freedom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Degree Of Freedom</em>' attribute.
	 * @see #getDegreeOfFreedom()
	 * @generated
	 */
	void setDegreeOfFreedom(Integer value);

} // ChiSquare

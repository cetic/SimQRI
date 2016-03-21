/**
 */
package be.cetic.simqri.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Students T</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.StudentsT#getDegreeOfFreedom <em>Degree Of Freedom</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getStudentsT()
 * @model
 * @generated
 */
public interface StudentsT extends Distribution {
	/**
	 * Returns the value of the '<em><b>Degree Of Freedom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Degree Of Freedom</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Degree Of Freedom</em>' attribute.
	 * @see #setDegreeOfFreedom(Double)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getStudentsT_DegreeOfFreedom()
	 * @model dataType="be.cetic.simqri.metamodel.PositiveDoubleNotNull"
	 * @generated
	 */
	Double getDegreeOfFreedom();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.StudentsT#getDegreeOfFreedom <em>Degree Of Freedom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Degree Of Freedom</em>' attribute.
	 * @see #getDegreeOfFreedom()
	 * @generated
	 */
	void setDegreeOfFreedom(Double value);

} // StudentsT

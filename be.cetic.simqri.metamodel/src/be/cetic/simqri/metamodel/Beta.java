/**
 */
package be.cetic.simqri.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Beta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.Beta#getFreedomDegreeA <em>Freedom Degree A</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Beta#getFreedomDegreeB <em>Freedom Degree B</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getBeta()
 * @model
 * @generated
 */
public interface Beta extends Distribution {
	/**
	 * Returns the value of the '<em><b>Freedom Degree A</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Freedom Degree A</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Freedom Degree A</em>' attribute.
	 * @see #setFreedomDegreeA(Double)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getBeta_FreedomDegreeA()
	 * @model default="1" dataType="be.cetic.simqri.metamodel.PositiveDoubleNotNull"
	 * @generated
	 */
	Double getFreedomDegreeA();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Beta#getFreedomDegreeA <em>Freedom Degree A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Freedom Degree A</em>' attribute.
	 * @see #getFreedomDegreeA()
	 * @generated
	 */
	void setFreedomDegreeA(Double value);

	/**
	 * Returns the value of the '<em><b>Freedom Degree B</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Freedom Degree B</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Freedom Degree B</em>' attribute.
	 * @see #setFreedomDegreeB(Double)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getBeta_FreedomDegreeB()
	 * @model default="1" dataType="be.cetic.simqri.metamodel.PositiveDoubleNotNull"
	 * @generated
	 */
	Double getFreedomDegreeB();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Beta#getFreedomDegreeB <em>Freedom Degree B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Freedom Degree B</em>' attribute.
	 * @see #getFreedomDegreeB()
	 * @generated
	 */
	void setFreedomDegreeB(Double value);

} // Beta

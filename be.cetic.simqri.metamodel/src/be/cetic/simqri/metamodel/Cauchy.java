/**
 */
package be.cetic.simqri.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cauchy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.Cauchy#getLocation <em>Location</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Cauchy#getScale <em>Scale</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getCauchy()
 * @model
 * @generated
 */
public interface Cauchy extends Distribution {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(double)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getCauchy_Location()
	 * @model default="0"
	 * @generated
	 */
	double getLocation();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Cauchy#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(double value);

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
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getCauchy_Scale()
	 * @model default="1" dataType="be.cetic.simqri.metamodel.PositiveDoubleNotNull"
	 * @generated
	 */
	Double getScale();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Cauchy#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #getScale()
	 * @generated
	 */
	void setScale(Double value);

} // Cauchy

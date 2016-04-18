/**
 */
package be.cetic.simqri.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binomial</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.Binomial#getNbrOfTrial <em>Nbr Of Trial</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Binomial#getProbaOfSuccess <em>Proba Of Success</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getBinomial()
 * @model
 * @generated
 */
public interface Binomial extends Distribution {
	/**
	 * Returns the value of the '<em><b>Nbr Of Trial</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nbr Of Trial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nbr Of Trial</em>' attribute.
	 * @see #setNbrOfTrial(Integer)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getBinomial_NbrOfTrial()
	 * @model default="1" dataType="be.cetic.simqri.metamodel.PositiveIntNotNull"
	 * @generated
	 */
	Integer getNbrOfTrial();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Binomial#getNbrOfTrial <em>Nbr Of Trial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nbr Of Trial</em>' attribute.
	 * @see #getNbrOfTrial()
	 * @generated
	 */
	void setNbrOfTrial(Integer value);

	/**
	 * Returns the value of the '<em><b>Proba Of Success</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proba Of Success</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proba Of Success</em>' attribute.
	 * @see #setProbaOfSuccess(Double)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getBinomial_ProbaOfSuccess()
	 * @model default="0.0" dataType="be.cetic.simqri.metamodel.ProbaDouble"
	 * @generated
	 */
	Double getProbaOfSuccess();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Binomial#getProbaOfSuccess <em>Proba Of Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proba Of Success</em>' attribute.
	 * @see #getProbaOfSuccess()
	 * @generated
	 */
	void setProbaOfSuccess(Double value);

} // Binomial

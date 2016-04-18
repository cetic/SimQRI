/**
 */
package be.cetic.simqri.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Supplier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.Supplier#getDeliveredPercentage <em>Delivered Percentage</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Supplier#getRefillPolicy <em>Refill Policy</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Supplier#getSupplierDelay <em>Supplier Delay</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getSupplier()
 * @model
 * @generated
 */
public interface Supplier extends Component {
	/**
	 * Returns the value of the '<em><b>Delivered Percentage</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delivered Percentage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delivered Percentage</em>' attribute.
	 * @see #setDeliveredPercentage(Double)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getSupplier_DeliveredPercentage()
	 * @model default="100" dataType="be.cetic.simqri.metamodel.Percent"
	 * @generated
	 */
	Double getDeliveredPercentage();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Supplier#getDeliveredPercentage <em>Delivered Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delivered Percentage</em>' attribute.
	 * @see #getDeliveredPercentage()
	 * @generated
	 */
	void setDeliveredPercentage(Double value);

	/**
	 * Returns the value of the '<em><b>Refill Policy</b></em>' reference list.
	 * The list contents are of type {@link be.cetic.simqri.metamodel.OrderOnStockThreshold}.
	 * It is bidirectional and its opposite is '{@link be.cetic.simqri.metamodel.OrderOnStockThreshold#getSupplier <em>Supplier</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refill Policy</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refill Policy</em>' reference list.
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getSupplier_RefillPolicy()
	 * @see be.cetic.simqri.metamodel.OrderOnStockThreshold#getSupplier
	 * @model opposite="supplier"
	 * @generated
	 */
	EList<OrderOnStockThreshold> getRefillPolicy();

	/**
	 * Returns the value of the '<em><b>Supplier Delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supplier Delay</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supplier Delay</em>' containment reference.
	 * @see #setSupplierDelay(Probability)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getSupplier_SupplierDelay()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Probability getSupplierDelay();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Supplier#getSupplierDelay <em>Supplier Delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supplier Delay</em>' containment reference.
	 * @see #getSupplierDelay()
	 * @generated
	 */
	void setSupplierDelay(Probability value);

} // Supplier

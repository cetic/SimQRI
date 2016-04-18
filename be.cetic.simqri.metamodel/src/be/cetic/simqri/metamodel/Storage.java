/**
 */
package be.cetic.simqri.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Storage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.Storage#getSize <em>Size</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Storage#getInitialContent <em>Initial Content</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Storage#isOverflow <em>Overflow</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Storage#getStorageOutputFlow <em>Storage Output Flow</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Storage#getOrderOnStockThreshold <em>Order On Stock Threshold</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.Storage#getProcessOutputFlow <em>Process Output Flow</em>}</li>
 * </ul>
 *
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getStorage()
 * @model
 * @generated
 */
public interface Storage extends Component {
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(Integer)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getStorage_Size()
	 * @model default="100" dataType="be.cetic.simqri.metamodel.PositiveIntNotNull"
	 * @generated
	 */
	Integer getSize();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Storage#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Integer value);

	/**
	 * Returns the value of the '<em><b>Initial Content</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Content</em>' attribute.
	 * @see #setInitialContent(Integer)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getStorage_InitialContent()
	 * @model default="100" dataType="be.cetic.simqri.metamodel.PositiveInt"
	 * @generated
	 */
	Integer getInitialContent();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Storage#getInitialContent <em>Initial Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Content</em>' attribute.
	 * @see #getInitialContent()
	 * @generated
	 */
	void setInitialContent(Integer value);

	/**
	 * Returns the value of the '<em><b>Overflow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overflow</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overflow</em>' attribute.
	 * @see #setOverflow(boolean)
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getStorage_Overflow()
	 * @model
	 * @generated
	 */
	boolean isOverflow();

	/**
	 * Sets the value of the '{@link be.cetic.simqri.metamodel.Storage#isOverflow <em>Overflow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overflow</em>' attribute.
	 * @see #isOverflow()
	 * @generated
	 */
	void setOverflow(boolean value);

	/**
	 * Returns the value of the '<em><b>Storage Output Flow</b></em>' reference list.
	 * The list contents are of type {@link be.cetic.simqri.metamodel.StorageOutputFlow}.
	 * It is bidirectional and its opposite is '{@link be.cetic.simqri.metamodel.StorageOutputFlow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Storage Output Flow</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storage Output Flow</em>' reference list.
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getStorage_StorageOutputFlow()
	 * @see be.cetic.simqri.metamodel.StorageOutputFlow#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<StorageOutputFlow> getStorageOutputFlow();

	/**
	 * Returns the value of the '<em><b>Order On Stock Threshold</b></em>' reference list.
	 * The list contents are of type {@link be.cetic.simqri.metamodel.OrderOnStockThreshold}.
	 * It is bidirectional and its opposite is '{@link be.cetic.simqri.metamodel.OrderOnStockThreshold#getStorage <em>Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order On Stock Threshold</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order On Stock Threshold</em>' reference list.
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getStorage_OrderOnStockThreshold()
	 * @see be.cetic.simqri.metamodel.OrderOnStockThreshold#getStorage
	 * @model opposite="storage"
	 * @generated
	 */
	EList<OrderOnStockThreshold> getOrderOnStockThreshold();

	/**
	 * Returns the value of the '<em><b>Process Output Flow</b></em>' reference list.
	 * The list contents are of type {@link be.cetic.simqri.metamodel.ProcessOutputFlow}.
	 * It is bidirectional and its opposite is '{@link be.cetic.simqri.metamodel.ProcessOutputFlow#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Output Flow</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Output Flow</em>' reference list.
	 * @see be.cetic.simqri.metamodel.MetamodelPackage#getStorage_ProcessOutputFlow()
	 * @see be.cetic.simqri.metamodel.ProcessOutputFlow#getDestination
	 * @model opposite="destination"
	 * @generated
	 */
	EList<ProcessOutputFlow> getProcessOutputFlow();

} // Storage

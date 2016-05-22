/**
 */
package be.cetic.simqri.metamodel.impl;

import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.OrderOnStockThreshold;
import be.cetic.simqri.metamodel.ProcessOutputFlow;
import be.cetic.simqri.metamodel.Storage;
import be.cetic.simqri.metamodel.StorageOutputFlow;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Storage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.impl.StorageImpl#getSize <em>Size</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.StorageImpl#getInitialContent <em>Initial Content</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.StorageImpl#isOverflow <em>Overflow</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.StorageImpl#getStorageOutputFlow <em>Storage Output Flow</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.StorageImpl#getOrderOnStockThreshold <em>Order On Stock Threshold</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.StorageImpl#getProcessOutputFlow <em>Process Output Flow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StorageImpl extends ComponentImpl implements Storage {
	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final Integer SIZE_EDEFAULT = 100;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected Integer size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitialContent() <em>Initial Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialContent()
	 * @generated
	 * @ordered
	 */
	protected static final Integer INITIAL_CONTENT_EDEFAULT = 100;

	/**
	 * The cached value of the '{@link #getInitialContent() <em>Initial Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialContent()
	 * @generated
	 * @ordered
	 */
	protected Integer initialContent = INITIAL_CONTENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isOverflow() <em>Overflow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverflow()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OVERFLOW_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOverflow() <em>Overflow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverflow()
	 * @generated
	 * @ordered
	 */
	protected boolean overflow = OVERFLOW_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStorageOutputFlow() <em>Storage Output Flow</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageOutputFlow()
	 * @generated
	 * @ordered
	 */
	protected EList<StorageOutputFlow> storageOutputFlow;

	/**
	 * The cached value of the '{@link #getOrderOnStockThreshold() <em>Order On Stock Threshold</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderOnStockThreshold()
	 * @generated
	 * @ordered
	 */
	protected EList<OrderOnStockThreshold> orderOnStockThreshold;

	/**
	 * The cached value of the '{@link #getProcessOutputFlow() <em>Process Output Flow</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessOutputFlow()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessOutputFlow> processOutputFlow;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.STORAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(Integer newSize) {
		Integer oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.STORAGE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getInitialContent() {
		return initialContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialContent(Integer newInitialContent) {
		Integer oldInitialContent = initialContent;
		initialContent = newInitialContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.STORAGE__INITIAL_CONTENT, oldInitialContent, initialContent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverflow() {
		return overflow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverflow(boolean newOverflow) {
		boolean oldOverflow = overflow;
		overflow = newOverflow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.STORAGE__OVERFLOW, oldOverflow, overflow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StorageOutputFlow> getStorageOutputFlow() {
		if (storageOutputFlow == null) {
			storageOutputFlow = new EObjectWithInverseResolvingEList<StorageOutputFlow>(StorageOutputFlow.class, this, MetamodelPackage.STORAGE__STORAGE_OUTPUT_FLOW, MetamodelPackage.STORAGE_OUTPUT_FLOW__SOURCE);
		}
		return storageOutputFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrderOnStockThreshold> getOrderOnStockThreshold() {
		if (orderOnStockThreshold == null) {
			orderOnStockThreshold = new EObjectWithInverseResolvingEList<OrderOnStockThreshold>(OrderOnStockThreshold.class, this, MetamodelPackage.STORAGE__ORDER_ON_STOCK_THRESHOLD, MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__STORAGE);
		}
		return orderOnStockThreshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessOutputFlow> getProcessOutputFlow() {
		if (processOutputFlow == null) {
			processOutputFlow = new EObjectWithInverseResolvingEList<ProcessOutputFlow>(ProcessOutputFlow.class, this, MetamodelPackage.STORAGE__PROCESS_OUTPUT_FLOW, MetamodelPackage.PROCESS_OUTPUT_FLOW__DESTINATION);
		}
		return processOutputFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.STORAGE__STORAGE_OUTPUT_FLOW:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStorageOutputFlow()).basicAdd(otherEnd, msgs);
			case MetamodelPackage.STORAGE__ORDER_ON_STOCK_THRESHOLD:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOrderOnStockThreshold()).basicAdd(otherEnd, msgs);
			case MetamodelPackage.STORAGE__PROCESS_OUTPUT_FLOW:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProcessOutputFlow()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.STORAGE__STORAGE_OUTPUT_FLOW:
				return ((InternalEList<?>)getStorageOutputFlow()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.STORAGE__ORDER_ON_STOCK_THRESHOLD:
				return ((InternalEList<?>)getOrderOnStockThreshold()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.STORAGE__PROCESS_OUTPUT_FLOW:
				return ((InternalEList<?>)getProcessOutputFlow()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.STORAGE__SIZE:
				return getSize();
			case MetamodelPackage.STORAGE__INITIAL_CONTENT:
				return getInitialContent();
			case MetamodelPackage.STORAGE__OVERFLOW:
				return isOverflow();
			case MetamodelPackage.STORAGE__STORAGE_OUTPUT_FLOW:
				return getStorageOutputFlow();
			case MetamodelPackage.STORAGE__ORDER_ON_STOCK_THRESHOLD:
				return getOrderOnStockThreshold();
			case MetamodelPackage.STORAGE__PROCESS_OUTPUT_FLOW:
				return getProcessOutputFlow();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.STORAGE__SIZE:
				setSize((Integer)newValue);
				return;
			case MetamodelPackage.STORAGE__INITIAL_CONTENT:
				setInitialContent((Integer)newValue);
				return;
			case MetamodelPackage.STORAGE__OVERFLOW:
				setOverflow((Boolean)newValue);
				return;
			case MetamodelPackage.STORAGE__STORAGE_OUTPUT_FLOW:
				getStorageOutputFlow().clear();
				getStorageOutputFlow().addAll((Collection<? extends StorageOutputFlow>)newValue);
				return;
			case MetamodelPackage.STORAGE__ORDER_ON_STOCK_THRESHOLD:
				getOrderOnStockThreshold().clear();
				getOrderOnStockThreshold().addAll((Collection<? extends OrderOnStockThreshold>)newValue);
				return;
			case MetamodelPackage.STORAGE__PROCESS_OUTPUT_FLOW:
				getProcessOutputFlow().clear();
				getProcessOutputFlow().addAll((Collection<? extends ProcessOutputFlow>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetamodelPackage.STORAGE__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case MetamodelPackage.STORAGE__INITIAL_CONTENT:
				setInitialContent(INITIAL_CONTENT_EDEFAULT);
				return;
			case MetamodelPackage.STORAGE__OVERFLOW:
				setOverflow(OVERFLOW_EDEFAULT);
				return;
			case MetamodelPackage.STORAGE__STORAGE_OUTPUT_FLOW:
				getStorageOutputFlow().clear();
				return;
			case MetamodelPackage.STORAGE__ORDER_ON_STOCK_THRESHOLD:
				getOrderOnStockThreshold().clear();
				return;
			case MetamodelPackage.STORAGE__PROCESS_OUTPUT_FLOW:
				getProcessOutputFlow().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetamodelPackage.STORAGE__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
			case MetamodelPackage.STORAGE__INITIAL_CONTENT:
				return INITIAL_CONTENT_EDEFAULT == null ? initialContent != null : !INITIAL_CONTENT_EDEFAULT.equals(initialContent);
			case MetamodelPackage.STORAGE__OVERFLOW:
				return overflow != OVERFLOW_EDEFAULT;
			case MetamodelPackage.STORAGE__STORAGE_OUTPUT_FLOW:
				return storageOutputFlow != null && !storageOutputFlow.isEmpty();
			case MetamodelPackage.STORAGE__ORDER_ON_STOCK_THRESHOLD:
				return orderOnStockThreshold != null && !orderOnStockThreshold.isEmpty();
			case MetamodelPackage.STORAGE__PROCESS_OUTPUT_FLOW:
				return processOutputFlow != null && !processOutputFlow.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (size: ");
		result.append(size);
		result.append(", initialContent: ");
		result.append(initialContent);
		result.append(", overflow: ");
		result.append(overflow);
		result.append(')');
		return result.toString();
	}

} //StorageImpl

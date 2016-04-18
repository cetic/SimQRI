/**
 */
package be.cetic.simqri.metamodel.impl;

import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.OrderOnStockThreshold;
import be.cetic.simqri.metamodel.OrderType;
import be.cetic.simqri.metamodel.Storage;
import be.cetic.simqri.metamodel.Supplier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Order On Stock Threshold</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.impl.OrderOnStockThresholdImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.OrderOnStockThresholdImpl#getThreshold <em>Threshold</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.OrderOnStockThresholdImpl#getName <em>Name</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.OrderOnStockThresholdImpl#getOrderQuantity <em>Order Quantity</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.OrderOnStockThresholdImpl#getOrderType <em>Order Type</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.OrderOnStockThresholdImpl#getSupplier <em>Supplier</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.OrderOnStockThresholdImpl#getStorage <em>Storage</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OrderOnStockThresholdImpl extends MinimalEObjectImpl.Container implements OrderOnStockThreshold {
	/**
	 * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final Double PERIOD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected Double period = PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final Integer THRESHOLD_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreshold()
	 * @generated
	 * @ordered
	 */
	protected Integer threshold = THRESHOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrderQuantity() <em>Order Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final Integer ORDER_QUANTITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOrderQuantity() <em>Order Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderQuantity()
	 * @generated
	 * @ordered
	 */
	protected Integer orderQuantity = ORDER_QUANTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrderType() <em>Order Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderType()
	 * @generated
	 * @ordered
	 */
	protected static final OrderType ORDER_TYPE_EDEFAULT = OrderType.FIXED;

	/**
	 * The cached value of the '{@link #getOrderType() <em>Order Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderType()
	 * @generated
	 * @ordered
	 */
	protected OrderType orderType = ORDER_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSupplier() <em>Supplier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupplier()
	 * @generated
	 * @ordered
	 */
	protected Supplier supplier;

	/**
	 * The cached value of the '{@link #getStorage() <em>Storage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorage()
	 * @generated
	 * @ordered
	 */
	protected Storage storage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrderOnStockThresholdImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.ORDER_ON_STOCK_THRESHOLD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getPeriod() {
		return period;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(Double newPeriod) {
		Double oldPeriod = period;
		period = newPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__PERIOD, oldPeriod, period));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getThreshold() {
		return threshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreshold(Integer newThreshold) {
		Integer oldThreshold = threshold;
		threshold = newThreshold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__THRESHOLD, oldThreshold, threshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrderQuantity(Integer newOrderQuantity) {
		Integer oldOrderQuantity = orderQuantity;
		orderQuantity = newOrderQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__ORDER_QUANTITY, oldOrderQuantity, orderQuantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderType getOrderType() {
		return orderType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrderType(OrderType newOrderType) {
		OrderType oldOrderType = orderType;
		orderType = newOrderType == null ? ORDER_TYPE_EDEFAULT : newOrderType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__ORDER_TYPE, oldOrderType, orderType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Storage getStorage() {
		if (storage != null && storage.eIsProxy()) {
			InternalEObject oldStorage = (InternalEObject)storage;
			storage = (Storage)eResolveProxy(oldStorage);
			if (storage != oldStorage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__STORAGE, oldStorage, storage));
			}
		}
		return storage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Storage basicGetStorage() {
		return storage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStorage(Storage newStorage, NotificationChain msgs) {
		Storage oldStorage = storage;
		storage = newStorage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__STORAGE, oldStorage, newStorage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStorage(Storage newStorage) {
		if (newStorage != storage) {
			NotificationChain msgs = null;
			if (storage != null)
				msgs = ((InternalEObject)storage).eInverseRemove(this, MetamodelPackage.STORAGE__ORDER_ON_STOCK_THRESHOLD, Storage.class, msgs);
			if (newStorage != null)
				msgs = ((InternalEObject)newStorage).eInverseAdd(this, MetamodelPackage.STORAGE__ORDER_ON_STOCK_THRESHOLD, Storage.class, msgs);
			msgs = basicSetStorage(newStorage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__STORAGE, newStorage, newStorage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Supplier getSupplier() {
		if (supplier != null && supplier.eIsProxy()) {
			InternalEObject oldSupplier = (InternalEObject)supplier;
			supplier = (Supplier)eResolveProxy(oldSupplier);
			if (supplier != oldSupplier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__SUPPLIER, oldSupplier, supplier));
			}
		}
		return supplier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Supplier basicGetSupplier() {
		return supplier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSupplier(Supplier newSupplier, NotificationChain msgs) {
		Supplier oldSupplier = supplier;
		supplier = newSupplier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__SUPPLIER, oldSupplier, newSupplier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupplier(Supplier newSupplier) {
		if (newSupplier != supplier) {
			NotificationChain msgs = null;
			if (supplier != null)
				msgs = ((InternalEObject)supplier).eInverseRemove(this, MetamodelPackage.SUPPLIER__REFILL_POLICY, Supplier.class, msgs);
			if (newSupplier != null)
				msgs = ((InternalEObject)newSupplier).eInverseAdd(this, MetamodelPackage.SUPPLIER__REFILL_POLICY, Supplier.class, msgs);
			msgs = basicSetSupplier(newSupplier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__SUPPLIER, newSupplier, newSupplier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__SUPPLIER:
				if (supplier != null)
					msgs = ((InternalEObject)supplier).eInverseRemove(this, MetamodelPackage.SUPPLIER__REFILL_POLICY, Supplier.class, msgs);
				return basicSetSupplier((Supplier)otherEnd, msgs);
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__STORAGE:
				if (storage != null)
					msgs = ((InternalEObject)storage).eInverseRemove(this, MetamodelPackage.STORAGE__ORDER_ON_STOCK_THRESHOLD, Storage.class, msgs);
				return basicSetStorage((Storage)otherEnd, msgs);
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
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__SUPPLIER:
				return basicSetSupplier(null, msgs);
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__STORAGE:
				return basicSetStorage(null, msgs);
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
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__PERIOD:
				return getPeriod();
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__THRESHOLD:
				return getThreshold();
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__NAME:
				return getName();
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__ORDER_QUANTITY:
				return getOrderQuantity();
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__ORDER_TYPE:
				return getOrderType();
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__SUPPLIER:
				if (resolve) return getSupplier();
				return basicGetSupplier();
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__STORAGE:
				if (resolve) return getStorage();
				return basicGetStorage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__PERIOD:
				setPeriod((Double)newValue);
				return;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__THRESHOLD:
				setThreshold((Integer)newValue);
				return;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__NAME:
				setName((String)newValue);
				return;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__ORDER_QUANTITY:
				setOrderQuantity((Integer)newValue);
				return;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__ORDER_TYPE:
				setOrderType((OrderType)newValue);
				return;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__SUPPLIER:
				setSupplier((Supplier)newValue);
				return;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__STORAGE:
				setStorage((Storage)newValue);
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
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__PERIOD:
				setPeriod(PERIOD_EDEFAULT);
				return;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__THRESHOLD:
				setThreshold(THRESHOLD_EDEFAULT);
				return;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__ORDER_QUANTITY:
				setOrderQuantity(ORDER_QUANTITY_EDEFAULT);
				return;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__ORDER_TYPE:
				setOrderType(ORDER_TYPE_EDEFAULT);
				return;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__SUPPLIER:
				setSupplier((Supplier)null);
				return;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__STORAGE:
				setStorage((Storage)null);
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
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__PERIOD:
				return PERIOD_EDEFAULT == null ? period != null : !PERIOD_EDEFAULT.equals(period);
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__THRESHOLD:
				return THRESHOLD_EDEFAULT == null ? threshold != null : !THRESHOLD_EDEFAULT.equals(threshold);
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__ORDER_QUANTITY:
				return ORDER_QUANTITY_EDEFAULT == null ? orderQuantity != null : !ORDER_QUANTITY_EDEFAULT.equals(orderQuantity);
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__ORDER_TYPE:
				return orderType != ORDER_TYPE_EDEFAULT;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__SUPPLIER:
				return supplier != null;
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD__STORAGE:
				return storage != null;
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
		result.append(" (period: ");
		result.append(period);
		result.append(", threshold: ");
		result.append(threshold);
		result.append(", name: ");
		result.append(name);
		result.append(", orderQuantity: ");
		result.append(orderQuantity);
		result.append(", orderType: ");
		result.append(orderType);
		result.append(')');
		return result.toString();
	}

} //OrderOnStockThresholdImpl

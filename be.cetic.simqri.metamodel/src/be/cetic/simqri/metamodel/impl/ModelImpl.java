/**
 */
package be.cetic.simqri.metamodel.impl;

import be.cetic.simqri.metamodel.Component;
import be.cetic.simqri.metamodel.Flow;
import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.metamodel.OrderOnStockThreshold;
import be.cetic.simqri.metamodel.Query;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.impl.ModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.ModelImpl#isValid <em>Valid</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.ModelImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.ModelImpl#getOrderOnStockThreshold <em>Order On Stock Threshold</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.ModelImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.ModelImpl#getFlow <em>Flow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model {
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
	 * The default value of the '{@link #isValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValid()
	 * @generated
	 * @ordered
	 */
	protected boolean valid = VALID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected EList<Query> query;

	/**
	 * The cached value of the '{@link #getOrderOnStockThreshold() <em>Order On Stock Threshold</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderOnStockThreshold()
	 * @generated
	 * @ordered
	 */
	protected EList<OrderOnStockThreshold> orderOnStockThreshold;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> component;

	/**
	 * The cached value of the '{@link #getFlow() <em>Flow</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlow()
	 * @generated
	 * @ordered
	 */
	protected EList<Flow> flow;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.MODEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValid(boolean newValid) {
		boolean oldValid = valid;
		valid = newValid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.MODEL__VALID, oldValid, valid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Query> getQuery() {
		if (query == null) {
			query = new EObjectContainmentEList<Query>(Query.class, this, MetamodelPackage.MODEL__QUERY);
		}
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrderOnStockThreshold> getOrderOnStockThreshold() {
		if (orderOnStockThreshold == null) {
			orderOnStockThreshold = new EObjectContainmentEList<OrderOnStockThreshold>(OrderOnStockThreshold.class, this, MetamodelPackage.MODEL__ORDER_ON_STOCK_THRESHOLD);
		}
		return orderOnStockThreshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getComponent() {
		if (component == null) {
			component = new EObjectContainmentEList<Component>(Component.class, this, MetamodelPackage.MODEL__COMPONENT);
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Flow> getFlow() {
		if (flow == null) {
			flow = new EObjectContainmentEList<Flow>(Flow.class, this, MetamodelPackage.MODEL__FLOW);
		}
		return flow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.MODEL__QUERY:
				return ((InternalEList<?>)getQuery()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.MODEL__ORDER_ON_STOCK_THRESHOLD:
				return ((InternalEList<?>)getOrderOnStockThreshold()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.MODEL__COMPONENT:
				return ((InternalEList<?>)getComponent()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.MODEL__FLOW:
				return ((InternalEList<?>)getFlow()).basicRemove(otherEnd, msgs);
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
			case MetamodelPackage.MODEL__NAME:
				return getName();
			case MetamodelPackage.MODEL__VALID:
				return isValid();
			case MetamodelPackage.MODEL__QUERY:
				return getQuery();
			case MetamodelPackage.MODEL__ORDER_ON_STOCK_THRESHOLD:
				return getOrderOnStockThreshold();
			case MetamodelPackage.MODEL__COMPONENT:
				return getComponent();
			case MetamodelPackage.MODEL__FLOW:
				return getFlow();
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
			case MetamodelPackage.MODEL__NAME:
				setName((String)newValue);
				return;
			case MetamodelPackage.MODEL__VALID:
				setValid((Boolean)newValue);
				return;
			case MetamodelPackage.MODEL__QUERY:
				getQuery().clear();
				getQuery().addAll((Collection<? extends Query>)newValue);
				return;
			case MetamodelPackage.MODEL__ORDER_ON_STOCK_THRESHOLD:
				getOrderOnStockThreshold().clear();
				getOrderOnStockThreshold().addAll((Collection<? extends OrderOnStockThreshold>)newValue);
				return;
			case MetamodelPackage.MODEL__COMPONENT:
				getComponent().clear();
				getComponent().addAll((Collection<? extends Component>)newValue);
				return;
			case MetamodelPackage.MODEL__FLOW:
				getFlow().clear();
				getFlow().addAll((Collection<? extends Flow>)newValue);
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
			case MetamodelPackage.MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MetamodelPackage.MODEL__VALID:
				setValid(VALID_EDEFAULT);
				return;
			case MetamodelPackage.MODEL__QUERY:
				getQuery().clear();
				return;
			case MetamodelPackage.MODEL__ORDER_ON_STOCK_THRESHOLD:
				getOrderOnStockThreshold().clear();
				return;
			case MetamodelPackage.MODEL__COMPONENT:
				getComponent().clear();
				return;
			case MetamodelPackage.MODEL__FLOW:
				getFlow().clear();
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
			case MetamodelPackage.MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MetamodelPackage.MODEL__VALID:
				return valid != VALID_EDEFAULT;
			case MetamodelPackage.MODEL__QUERY:
				return query != null && !query.isEmpty();
			case MetamodelPackage.MODEL__ORDER_ON_STOCK_THRESHOLD:
				return orderOnStockThreshold != null && !orderOnStockThreshold.isEmpty();
			case MetamodelPackage.MODEL__COMPONENT:
				return component != null && !component.isEmpty();
			case MetamodelPackage.MODEL__FLOW:
				return flow != null && !flow.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", valid: ");
		result.append(valid);
		result.append(')');
		return result.toString();
	}

} //ModelImpl

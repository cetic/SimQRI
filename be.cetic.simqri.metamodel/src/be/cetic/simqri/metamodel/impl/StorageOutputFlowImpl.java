/**
 */
package be.cetic.simqri.metamodel.impl;

import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.Storage;
import be.cetic.simqri.metamodel.StorageOutputFlow;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Storage Output Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.impl.StorageOutputFlowImpl#getSource <em>Source</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.StorageOutputFlowImpl#getDestination <em>Destination</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StorageOutputFlowImpl extends FlowImpl implements StorageOutputFlow {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Storage source;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected be.cetic.simqri.metamodel.Process destination;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StorageOutputFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.STORAGE_OUTPUT_FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public be.cetic.simqri.metamodel.Process getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject)destination;
			destination = (be.cetic.simqri.metamodel.Process)eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.STORAGE_OUTPUT_FLOW__DESTINATION, oldDestination, destination));
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public be.cetic.simqri.metamodel.Process basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(be.cetic.simqri.metamodel.Process newDestination, NotificationChain msgs) {
		be.cetic.simqri.metamodel.Process oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.STORAGE_OUTPUT_FLOW__DESTINATION, oldDestination, newDestination);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(be.cetic.simqri.metamodel.Process newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null)
				msgs = ((InternalEObject)destination).eInverseRemove(this, MetamodelPackage.PROCESS__STORAGE_OUTPUT_FLOW, be.cetic.simqri.metamodel.Process.class, msgs);
			if (newDestination != null)
				msgs = ((InternalEObject)newDestination).eInverseAdd(this, MetamodelPackage.PROCESS__STORAGE_OUTPUT_FLOW, be.cetic.simqri.metamodel.Process.class, msgs);
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.STORAGE_OUTPUT_FLOW__DESTINATION, newDestination, newDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Storage getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Storage)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.STORAGE_OUTPUT_FLOW__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Storage basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Storage newSource, NotificationChain msgs) {
		Storage oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.STORAGE_OUTPUT_FLOW__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Storage newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, MetamodelPackage.STORAGE__STORAGE_OUTPUT_FLOW, Storage.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, MetamodelPackage.STORAGE__STORAGE_OUTPUT_FLOW, Storage.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.STORAGE_OUTPUT_FLOW__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.STORAGE_OUTPUT_FLOW__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, MetamodelPackage.STORAGE__STORAGE_OUTPUT_FLOW, Storage.class, msgs);
				return basicSetSource((Storage)otherEnd, msgs);
			case MetamodelPackage.STORAGE_OUTPUT_FLOW__DESTINATION:
				if (destination != null)
					msgs = ((InternalEObject)destination).eInverseRemove(this, MetamodelPackage.PROCESS__STORAGE_OUTPUT_FLOW, be.cetic.simqri.metamodel.Process.class, msgs);
				return basicSetDestination((be.cetic.simqri.metamodel.Process)otherEnd, msgs);
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
			case MetamodelPackage.STORAGE_OUTPUT_FLOW__SOURCE:
				return basicSetSource(null, msgs);
			case MetamodelPackage.STORAGE_OUTPUT_FLOW__DESTINATION:
				return basicSetDestination(null, msgs);
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
			case MetamodelPackage.STORAGE_OUTPUT_FLOW__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MetamodelPackage.STORAGE_OUTPUT_FLOW__DESTINATION:
				if (resolve) return getDestination();
				return basicGetDestination();
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
			case MetamodelPackage.STORAGE_OUTPUT_FLOW__SOURCE:
				setSource((Storage)newValue);
				return;
			case MetamodelPackage.STORAGE_OUTPUT_FLOW__DESTINATION:
				setDestination((be.cetic.simqri.metamodel.Process)newValue);
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
			case MetamodelPackage.STORAGE_OUTPUT_FLOW__SOURCE:
				setSource((Storage)null);
				return;
			case MetamodelPackage.STORAGE_OUTPUT_FLOW__DESTINATION:
				setDestination((be.cetic.simqri.metamodel.Process)null);
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
			case MetamodelPackage.STORAGE_OUTPUT_FLOW__SOURCE:
				return source != null;
			case MetamodelPackage.STORAGE_OUTPUT_FLOW__DESTINATION:
				return destination != null;
		}
		return super.eIsSet(featureID);
	}

} //StorageOutputFlowImpl

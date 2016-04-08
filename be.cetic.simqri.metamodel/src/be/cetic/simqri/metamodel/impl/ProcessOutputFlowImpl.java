/**
 */
package be.cetic.simqri.metamodel.impl;

import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.Output;
import be.cetic.simqri.metamodel.Probability;
import be.cetic.simqri.metamodel.ProcessOutputFlow;
import be.cetic.simqri.metamodel.Storage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Output Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.impl.ProcessOutputFlowImpl#getSource <em>Source</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.ProcessOutputFlowImpl#getProcessOutputFlowDelay <em>Process Output Flow Delay</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.ProcessOutputFlowImpl#getDestination <em>Destination</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessOutputFlowImpl extends FlowImpl implements ProcessOutputFlow {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Output source;

	/**
	 * The cached value of the '{@link #getProcessOutputFlowDelay() <em>Process Output Flow Delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessOutputFlowDelay()
	 * @generated
	 * @ordered
	 */
	protected Probability processOutputFlowDelay;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected Storage destination;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessOutputFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Storage getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject)destination;
			destination = (Storage)eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.PROCESS_OUTPUT_FLOW__DESTINATION, oldDestination, destination));
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Storage basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(Storage newDestination, NotificationChain msgs) {
		Storage oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.PROCESS_OUTPUT_FLOW__DESTINATION, oldDestination, newDestination);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(Storage newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null)
				msgs = ((InternalEObject)destination).eInverseRemove(this, MetamodelPackage.STORAGE__PROCESS_OUTPUT_FLOW, Storage.class, msgs);
			if (newDestination != null)
				msgs = ((InternalEObject)newDestination).eInverseAdd(this, MetamodelPackage.STORAGE__PROCESS_OUTPUT_FLOW, Storage.class, msgs);
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.PROCESS_OUTPUT_FLOW__DESTINATION, newDestination, newDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Output)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.PROCESS_OUTPUT_FLOW__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Output newSource, NotificationChain msgs) {
		Output oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.PROCESS_OUTPUT_FLOW__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Output newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, MetamodelPackage.OUTPUT__PROCESS_OUTPUT_FLOW, Output.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, MetamodelPackage.OUTPUT__PROCESS_OUTPUT_FLOW, Output.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.PROCESS_OUTPUT_FLOW__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Probability getProcessOutputFlowDelay() {
		return processOutputFlowDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcessOutputFlowDelay(Probability newProcessOutputFlowDelay, NotificationChain msgs) {
		Probability oldProcessOutputFlowDelay = processOutputFlowDelay;
		processOutputFlowDelay = newProcessOutputFlowDelay;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY, oldProcessOutputFlowDelay, newProcessOutputFlowDelay);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessOutputFlowDelay(Probability newProcessOutputFlowDelay) {
		if (newProcessOutputFlowDelay != processOutputFlowDelay) {
			NotificationChain msgs = null;
			if (processOutputFlowDelay != null)
				msgs = ((InternalEObject)processOutputFlowDelay).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY, null, msgs);
			if (newProcessOutputFlowDelay != null)
				msgs = ((InternalEObject)newProcessOutputFlowDelay).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY, null, msgs);
			msgs = basicSetProcessOutputFlowDelay(newProcessOutputFlowDelay, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY, newProcessOutputFlowDelay, newProcessOutputFlowDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, MetamodelPackage.OUTPUT__PROCESS_OUTPUT_FLOW, Output.class, msgs);
				return basicSetSource((Output)otherEnd, msgs);
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__DESTINATION:
				if (destination != null)
					msgs = ((InternalEObject)destination).eInverseRemove(this, MetamodelPackage.STORAGE__PROCESS_OUTPUT_FLOW, Storage.class, msgs);
				return basicSetDestination((Storage)otherEnd, msgs);
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
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__SOURCE:
				return basicSetSource(null, msgs);
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY:
				return basicSetProcessOutputFlowDelay(null, msgs);
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__DESTINATION:
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
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY:
				return getProcessOutputFlowDelay();
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__DESTINATION:
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
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__SOURCE:
				setSource((Output)newValue);
				return;
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY:
				setProcessOutputFlowDelay((Probability)newValue);
				return;
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__DESTINATION:
				setDestination((Storage)newValue);
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
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__SOURCE:
				setSource((Output)null);
				return;
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY:
				setProcessOutputFlowDelay((Probability)null);
				return;
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__DESTINATION:
				setDestination((Storage)null);
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
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__SOURCE:
				return source != null;
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY:
				return processOutputFlowDelay != null;
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__DESTINATION:
				return destination != null;
		}
		return super.eIsSet(featureID);
	}

} //ProcessOutputFlowImpl

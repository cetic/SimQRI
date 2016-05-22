/**
 */
package be.cetic.simqri.metamodel.impl;

import be.cetic.simqri.metamodel.ConveyorBelt;
import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.Output;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conveyor Belt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.impl.ConveyorBeltImpl#getMinimalSeparationBetweenBatches <em>Minimal Separation Between Batches</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.ConveyorBeltImpl#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConveyorBeltImpl extends ProcessImpl implements ConveyorBelt {
	/**
	 * The default value of the '{@link #getMinimalSeparationBetweenBatches() <em>Minimal Separation Between Batches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimalSeparationBetweenBatches()
	 * @generated
	 * @ordered
	 */
	protected static final Double MINIMAL_SEPARATION_BETWEEN_BATCHES_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getMinimalSeparationBetweenBatches() <em>Minimal Separation Between Batches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimalSeparationBetweenBatches()
	 * @generated
	 * @ordered
	 */
	protected Double minimalSeparationBetweenBatches = MINIMAL_SEPARATION_BETWEEN_BATCHES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected Output output;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConveyorBeltImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.CONVEYOR_BELT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getMinimalSeparationBetweenBatches() {
		return minimalSeparationBetweenBatches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimalSeparationBetweenBatches(Double newMinimalSeparationBetweenBatches) {
		Double oldMinimalSeparationBetweenBatches = minimalSeparationBetweenBatches;
		minimalSeparationBetweenBatches = newMinimalSeparationBetweenBatches;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONVEYOR_BELT__MINIMAL_SEPARATION_BETWEEN_BATCHES, oldMinimalSeparationBetweenBatches, minimalSeparationBetweenBatches));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutput(Output newOutput, NotificationChain msgs) {
		Output oldOutput = output;
		output = newOutput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONVEYOR_BELT__OUTPUT, oldOutput, newOutput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(Output newOutput) {
		if (newOutput != output) {
			NotificationChain msgs = null;
			if (output != null)
				msgs = ((InternalEObject)output).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.CONVEYOR_BELT__OUTPUT, null, msgs);
			if (newOutput != null)
				msgs = ((InternalEObject)newOutput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.CONVEYOR_BELT__OUTPUT, null, msgs);
			msgs = basicSetOutput(newOutput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONVEYOR_BELT__OUTPUT, newOutput, newOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.CONVEYOR_BELT__OUTPUT:
				return basicSetOutput(null, msgs);
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
			case MetamodelPackage.CONVEYOR_BELT__MINIMAL_SEPARATION_BETWEEN_BATCHES:
				return getMinimalSeparationBetweenBatches();
			case MetamodelPackage.CONVEYOR_BELT__OUTPUT:
				return getOutput();
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
			case MetamodelPackage.CONVEYOR_BELT__MINIMAL_SEPARATION_BETWEEN_BATCHES:
				setMinimalSeparationBetweenBatches((Double)newValue);
				return;
			case MetamodelPackage.CONVEYOR_BELT__OUTPUT:
				setOutput((Output)newValue);
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
			case MetamodelPackage.CONVEYOR_BELT__MINIMAL_SEPARATION_BETWEEN_BATCHES:
				setMinimalSeparationBetweenBatches(MINIMAL_SEPARATION_BETWEEN_BATCHES_EDEFAULT);
				return;
			case MetamodelPackage.CONVEYOR_BELT__OUTPUT:
				setOutput((Output)null);
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
			case MetamodelPackage.CONVEYOR_BELT__MINIMAL_SEPARATION_BETWEEN_BATCHES:
				return MINIMAL_SEPARATION_BETWEEN_BATCHES_EDEFAULT == null ? minimalSeparationBetweenBatches != null : !MINIMAL_SEPARATION_BETWEEN_BATCHES_EDEFAULT.equals(minimalSeparationBetweenBatches);
			case MetamodelPackage.CONVEYOR_BELT__OUTPUT:
				return output != null;
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
		result.append(" (minimalSeparationBetweenBatches: ");
		result.append(minimalSeparationBetweenBatches);
		result.append(')');
		return result.toString();
	}

} //ConveyorBeltImpl

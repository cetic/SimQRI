/**
 */
package be.cetic.simqri.metamodel.impl;

import be.cetic.simqri.metamodel.Geometric;
import be.cetic.simqri.metamodel.MetamodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Geometric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.impl.GeometricImpl#getProbaOfSuccess <em>Proba Of Success</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GeometricImpl extends DistributionImpl implements Geometric {
	/**
	 * The default value of the '{@link #getProbaOfSuccess() <em>Proba Of Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbaOfSuccess()
	 * @generated
	 * @ordered
	 */
	protected static final Double PROBA_OF_SUCCESS_EDEFAULT = 0.1;

	/**
	 * The cached value of the '{@link #getProbaOfSuccess() <em>Proba Of Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbaOfSuccess()
	 * @generated
	 * @ordered
	 */
	protected Double probaOfSuccess = PROBA_OF_SUCCESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeometricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.GEOMETRIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getProbaOfSuccess() {
		return probaOfSuccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbaOfSuccess(Double newProbaOfSuccess) {
		Double oldProbaOfSuccess = probaOfSuccess;
		probaOfSuccess = newProbaOfSuccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.GEOMETRIC__PROBA_OF_SUCCESS, oldProbaOfSuccess, probaOfSuccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.GEOMETRIC__PROBA_OF_SUCCESS:
				return getProbaOfSuccess();
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
			case MetamodelPackage.GEOMETRIC__PROBA_OF_SUCCESS:
				setProbaOfSuccess((Double)newValue);
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
			case MetamodelPackage.GEOMETRIC__PROBA_OF_SUCCESS:
				setProbaOfSuccess(PROBA_OF_SUCCESS_EDEFAULT);
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
			case MetamodelPackage.GEOMETRIC__PROBA_OF_SUCCESS:
				return PROBA_OF_SUCCESS_EDEFAULT == null ? probaOfSuccess != null : !PROBA_OF_SUCCESS_EDEFAULT.equals(probaOfSuccess);
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
		result.append(" (probaOfSuccess: ");
		result.append(probaOfSuccess);
		result.append(')');
		return result.toString();
	}

} //GeometricImpl

/**
 */
package be.cetic.simqri.metamodel.impl;

import be.cetic.simqri.metamodel.Binomial;
import be.cetic.simqri.metamodel.MetamodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binomial</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.impl.BinomialImpl#getNbrOfTrial <em>Nbr Of Trial</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.BinomialImpl#getProbaOfSuccess <em>Proba Of Success</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinomialImpl extends DistributionImpl implements Binomial {
	/**
	 * The default value of the '{@link #getNbrOfTrial() <em>Nbr Of Trial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbrOfTrial()
	 * @generated
	 * @ordered
	 */
	protected static final Integer NBR_OF_TRIAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNbrOfTrial() <em>Nbr Of Trial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbrOfTrial()
	 * @generated
	 * @ordered
	 */
	protected Integer nbrOfTrial = NBR_OF_TRIAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getProbaOfSuccess() <em>Proba Of Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbaOfSuccess()
	 * @generated
	 * @ordered
	 */
	protected static final Double PROBA_OF_SUCCESS_EDEFAULT = null;

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
	protected BinomialImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.BINOMIAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getNbrOfTrial() {
		return nbrOfTrial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbrOfTrial(Integer newNbrOfTrial) {
		Integer oldNbrOfTrial = nbrOfTrial;
		nbrOfTrial = newNbrOfTrial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.BINOMIAL__NBR_OF_TRIAL, oldNbrOfTrial, nbrOfTrial));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.BINOMIAL__PROBA_OF_SUCCESS, oldProbaOfSuccess, probaOfSuccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.BINOMIAL__NBR_OF_TRIAL:
				return getNbrOfTrial();
			case MetamodelPackage.BINOMIAL__PROBA_OF_SUCCESS:
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
			case MetamodelPackage.BINOMIAL__NBR_OF_TRIAL:
				setNbrOfTrial((Integer)newValue);
				return;
			case MetamodelPackage.BINOMIAL__PROBA_OF_SUCCESS:
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
			case MetamodelPackage.BINOMIAL__NBR_OF_TRIAL:
				setNbrOfTrial(NBR_OF_TRIAL_EDEFAULT);
				return;
			case MetamodelPackage.BINOMIAL__PROBA_OF_SUCCESS:
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
			case MetamodelPackage.BINOMIAL__NBR_OF_TRIAL:
				return NBR_OF_TRIAL_EDEFAULT == null ? nbrOfTrial != null : !NBR_OF_TRIAL_EDEFAULT.equals(nbrOfTrial);
			case MetamodelPackage.BINOMIAL__PROBA_OF_SUCCESS:
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
		result.append(" (nbrOfTrial: ");
		result.append(nbrOfTrial);
		result.append(", probaOfSuccess: ");
		result.append(probaOfSuccess);
		result.append(')');
		return result.toString();
	}

} //BinomialImpl

/**
 */
package be.cetic.simqri.metamodel.impl;

import be.cetic.simqri.metamodel.FDistribution;
import be.cetic.simqri.metamodel.MetamodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FDistribution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.impl.FDistributionImpl#getFreedomDegreeA <em>Freedom Degree A</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.FDistributionImpl#getFreedomDegreeB <em>Freedom Degree B</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FDistributionImpl extends DistributionImpl implements FDistribution {
	/**
	 * The default value of the '{@link #getFreedomDegreeA() <em>Freedom Degree A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreedomDegreeA()
	 * @generated
	 * @ordered
	 */
	protected static final Double FREEDOM_DEGREE_A_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getFreedomDegreeA() <em>Freedom Degree A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreedomDegreeA()
	 * @generated
	 * @ordered
	 */
	protected Double freedomDegreeA = FREEDOM_DEGREE_A_EDEFAULT;

	/**
	 * The default value of the '{@link #getFreedomDegreeB() <em>Freedom Degree B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreedomDegreeB()
	 * @generated
	 * @ordered
	 */
	protected static final Double FREEDOM_DEGREE_B_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getFreedomDegreeB() <em>Freedom Degree B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreedomDegreeB()
	 * @generated
	 * @ordered
	 */
	protected Double freedomDegreeB = FREEDOM_DEGREE_B_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FDistributionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.FDISTRIBUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getFreedomDegreeA() {
		return freedomDegreeA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreedomDegreeA(Double newFreedomDegreeA) {
		Double oldFreedomDegreeA = freedomDegreeA;
		freedomDegreeA = newFreedomDegreeA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.FDISTRIBUTION__FREEDOM_DEGREE_A, oldFreedomDegreeA, freedomDegreeA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getFreedomDegreeB() {
		return freedomDegreeB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreedomDegreeB(Double newFreedomDegreeB) {
		Double oldFreedomDegreeB = freedomDegreeB;
		freedomDegreeB = newFreedomDegreeB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.FDISTRIBUTION__FREEDOM_DEGREE_B, oldFreedomDegreeB, freedomDegreeB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.FDISTRIBUTION__FREEDOM_DEGREE_A:
				return getFreedomDegreeA();
			case MetamodelPackage.FDISTRIBUTION__FREEDOM_DEGREE_B:
				return getFreedomDegreeB();
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
			case MetamodelPackage.FDISTRIBUTION__FREEDOM_DEGREE_A:
				setFreedomDegreeA((Double)newValue);
				return;
			case MetamodelPackage.FDISTRIBUTION__FREEDOM_DEGREE_B:
				setFreedomDegreeB((Double)newValue);
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
			case MetamodelPackage.FDISTRIBUTION__FREEDOM_DEGREE_A:
				setFreedomDegreeA(FREEDOM_DEGREE_A_EDEFAULT);
				return;
			case MetamodelPackage.FDISTRIBUTION__FREEDOM_DEGREE_B:
				setFreedomDegreeB(FREEDOM_DEGREE_B_EDEFAULT);
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
			case MetamodelPackage.FDISTRIBUTION__FREEDOM_DEGREE_A:
				return FREEDOM_DEGREE_A_EDEFAULT == null ? freedomDegreeA != null : !FREEDOM_DEGREE_A_EDEFAULT.equals(freedomDegreeA);
			case MetamodelPackage.FDISTRIBUTION__FREEDOM_DEGREE_B:
				return FREEDOM_DEGREE_B_EDEFAULT == null ? freedomDegreeB != null : !FREEDOM_DEGREE_B_EDEFAULT.equals(freedomDegreeB);
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
		result.append(" (freedomDegreeA: ");
		result.append(freedomDegreeA);
		result.append(", freedomDegreeB: ");
		result.append(freedomDegreeB);
		result.append(')');
		return result.toString();
	}

} //FDistributionImpl

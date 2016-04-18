/**
 */
package be.cetic.simqri.metamodel.impl;

import be.cetic.simqri.metamodel.BatchProcess;
import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.Output;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Batch Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link be.cetic.simqri.metamodel.impl.BatchProcessImpl#getPercentageOfSuccess <em>Percentage Of Success</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.BatchProcessImpl#getNumberOfLines <em>Number Of Lines</em>}</li>
 *   <li>{@link be.cetic.simqri.metamodel.impl.BatchProcessImpl#getOutputs <em>Outputs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BatchProcessImpl extends ProcessImpl implements BatchProcess {
	/**
	 * The default value of the '{@link #getPercentageOfSuccess() <em>Percentage Of Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentageOfSuccess()
	 * @generated
	 * @ordered
	 */
	protected static final Double PERCENTAGE_OF_SUCCESS_EDEFAULT = 100.0;

	/**
	 * The cached value of the '{@link #getPercentageOfSuccess() <em>Percentage Of Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentageOfSuccess()
	 * @generated
	 * @ordered
	 */
	protected Double percentageOfSuccess = PERCENTAGE_OF_SUCCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfLines() <em>Number Of Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfLines()
	 * @generated
	 * @ordered
	 */
	protected static final Integer NUMBER_OF_LINES_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getNumberOfLines() <em>Number Of Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfLines()
	 * @generated
	 * @ordered
	 */
	protected Integer numberOfLines = NUMBER_OF_LINES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Output> outputs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BatchProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.BATCH_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getPercentageOfSuccess() {
		return percentageOfSuccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPercentageOfSuccess(Double newPercentageOfSuccess) {
		Double oldPercentageOfSuccess = percentageOfSuccess;
		percentageOfSuccess = newPercentageOfSuccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.BATCH_PROCESS__PERCENTAGE_OF_SUCCESS, oldPercentageOfSuccess, percentageOfSuccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getNumberOfLines() {
		return numberOfLines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfLines(Integer newNumberOfLines) {
		Integer oldNumberOfLines = numberOfLines;
		numberOfLines = newNumberOfLines;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.BATCH_PROCESS__NUMBER_OF_LINES, oldNumberOfLines, numberOfLines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Output> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectContainmentEList<Output>(Output.class, this, MetamodelPackage.BATCH_PROCESS__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.BATCH_PROCESS__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
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
			case MetamodelPackage.BATCH_PROCESS__PERCENTAGE_OF_SUCCESS:
				return getPercentageOfSuccess();
			case MetamodelPackage.BATCH_PROCESS__NUMBER_OF_LINES:
				return getNumberOfLines();
			case MetamodelPackage.BATCH_PROCESS__OUTPUTS:
				return getOutputs();
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
			case MetamodelPackage.BATCH_PROCESS__PERCENTAGE_OF_SUCCESS:
				setPercentageOfSuccess((Double)newValue);
				return;
			case MetamodelPackage.BATCH_PROCESS__NUMBER_OF_LINES:
				setNumberOfLines((Integer)newValue);
				return;
			case MetamodelPackage.BATCH_PROCESS__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Output>)newValue);
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
			case MetamodelPackage.BATCH_PROCESS__PERCENTAGE_OF_SUCCESS:
				setPercentageOfSuccess(PERCENTAGE_OF_SUCCESS_EDEFAULT);
				return;
			case MetamodelPackage.BATCH_PROCESS__NUMBER_OF_LINES:
				setNumberOfLines(NUMBER_OF_LINES_EDEFAULT);
				return;
			case MetamodelPackage.BATCH_PROCESS__OUTPUTS:
				getOutputs().clear();
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
			case MetamodelPackage.BATCH_PROCESS__PERCENTAGE_OF_SUCCESS:
				return PERCENTAGE_OF_SUCCESS_EDEFAULT == null ? percentageOfSuccess != null : !PERCENTAGE_OF_SUCCESS_EDEFAULT.equals(percentageOfSuccess);
			case MetamodelPackage.BATCH_PROCESS__NUMBER_OF_LINES:
				return NUMBER_OF_LINES_EDEFAULT == null ? numberOfLines != null : !NUMBER_OF_LINES_EDEFAULT.equals(numberOfLines);
			case MetamodelPackage.BATCH_PROCESS__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
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
		result.append(" (percentageOfSuccess: ");
		result.append(percentageOfSuccess);
		result.append(", numberOfLines: ");
		result.append(numberOfLines);
		result.append(')');
		return result.toString();
	}

} //BatchProcessImpl

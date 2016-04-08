/**
 */
package be.cetic.simqri.metamodel.impl;

import be.cetic.simqri.metamodel.Distribution;
import be.cetic.simqri.metamodel.MetamodelPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Distribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class DistributionImpl extends ProbabilityImpl implements Distribution {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DistributionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.DISTRIBUTION;
	}

} //DistributionImpl

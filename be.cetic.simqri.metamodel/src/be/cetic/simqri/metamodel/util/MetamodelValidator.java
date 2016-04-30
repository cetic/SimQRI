/**
 */
package be.cetic.simqri.metamodel.util;

import be.cetic.simqri.metamodel.BatchProcess;

import be.cetic.simqri.metamodel.Beta;
import be.cetic.simqri.metamodel.Binomial;
import be.cetic.simqri.metamodel.Cauchy;
import be.cetic.simqri.metamodel.ChiSquare;
import be.cetic.simqri.metamodel.Component;
import be.cetic.simqri.metamodel.ConveyorBelt;
import be.cetic.simqri.metamodel.Distribution;
import be.cetic.simqri.metamodel.Exponential;
import be.cetic.simqri.metamodel.FDistribution;
import be.cetic.simqri.metamodel.Flow;
import be.cetic.simqri.metamodel.Gamma;
import be.cetic.simqri.metamodel.Gaussian;
import be.cetic.simqri.metamodel.Geometric;
import be.cetic.simqri.metamodel.LogNormal;
import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.metamodel.OrderOnStockThreshold;
import be.cetic.simqri.metamodel.OrderType;
import be.cetic.simqri.metamodel.Output;
import be.cetic.simqri.metamodel.OutputType;
import be.cetic.simqri.metamodel.Pareto;
import be.cetic.simqri.metamodel.Poisson;
import be.cetic.simqri.metamodel.Probability;
import be.cetic.simqri.metamodel.ProcessOutputFlow;
import be.cetic.simqri.metamodel.Query;
import be.cetic.simqri.metamodel.Scalar;
import be.cetic.simqri.metamodel.Storage;
import be.cetic.simqri.metamodel.StorageOutputFlow;
import be.cetic.simqri.metamodel.StudentsT;
import be.cetic.simqri.metamodel.Supplier;
import be.cetic.simqri.metamodel.Uniform;
import be.cetic.simqri.metamodel.Weibull;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see be.cetic.simqri.metamodel.MetamodelPackage
 * @generated
 */
public class MetamodelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MetamodelValidator INSTANCE = new MetamodelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "be.cetic.simqri.metamodel";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return MetamodelPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case MetamodelPackage.MODEL:
				return validateModel((Model)value, diagnostics, context);
			case MetamodelPackage.QUERY:
				return validateQuery((Query)value, diagnostics, context);
			case MetamodelPackage.STORAGE:
				return validateStorage((Storage)value, diagnostics, context);
			case MetamodelPackage.SUPPLIER:
				return validateSupplier((Supplier)value, diagnostics, context);
			case MetamodelPackage.BATCH_PROCESS:
				return validateBatchProcess((BatchProcess)value, diagnostics, context);
			case MetamodelPackage.OUTPUT:
				return validateOutput((Output)value, diagnostics, context);
			case MetamodelPackage.STORAGE_OUTPUT_FLOW:
				return validateStorageOutputFlow((StorageOutputFlow)value, diagnostics, context);
			case MetamodelPackage.PROCESS_OUTPUT_FLOW:
				return validateProcessOutputFlow((ProcessOutputFlow)value, diagnostics, context);
			case MetamodelPackage.PROCESS:
				return validateProcess((be.cetic.simqri.metamodel.Process)value, diagnostics, context);
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD:
				return validateOrderOnStockThreshold((OrderOnStockThreshold)value, diagnostics, context);
			case MetamodelPackage.COMPONENT:
				return validateComponent((Component)value, diagnostics, context);
			case MetamodelPackage.FLOW:
				return validateFlow((Flow)value, diagnostics, context);
			case MetamodelPackage.PROBABILITY:
				return validateProbability((Probability)value, diagnostics, context);
			case MetamodelPackage.DISTRIBUTION:
				return validateDistribution((Distribution)value, diagnostics, context);
			case MetamodelPackage.CAUCHY:
				return validateCauchy((Cauchy)value, diagnostics, context);
			case MetamodelPackage.BINOMIAL:
				return validateBinomial((Binomial)value, diagnostics, context);
			case MetamodelPackage.BETA:
				return validateBeta((Beta)value, diagnostics, context);
			case MetamodelPackage.SCALAR:
				return validateScalar((Scalar)value, diagnostics, context);
			case MetamodelPackage.CHI_SQUARE:
				return validateChiSquare((ChiSquare)value, diagnostics, context);
			case MetamodelPackage.EXPONENTIAL:
				return validateExponential((Exponential)value, diagnostics, context);
			case MetamodelPackage.FDISTRIBUTION:
				return validateFDistribution((FDistribution)value, diagnostics, context);
			case MetamodelPackage.GAMMA:
				return validateGamma((Gamma)value, diagnostics, context);
			case MetamodelPackage.GEOMETRIC:
				return validateGeometric((Geometric)value, diagnostics, context);
			case MetamodelPackage.LOG_NORMAL:
				return validateLogNormal((LogNormal)value, diagnostics, context);
			case MetamodelPackage.GAUSSIAN:
				return validateGaussian((Gaussian)value, diagnostics, context);
			case MetamodelPackage.PARETO:
				return validatePareto((Pareto)value, diagnostics, context);
			case MetamodelPackage.POISSON:
				return validatePoisson((Poisson)value, diagnostics, context);
			case MetamodelPackage.STUDENTS_T:
				return validateStudentsT((StudentsT)value, diagnostics, context);
			case MetamodelPackage.UNIFORM:
				return validateUniform((Uniform)value, diagnostics, context);
			case MetamodelPackage.WEIBULL:
				return validateWeibull((Weibull)value, diagnostics, context);
			case MetamodelPackage.CONVEYOR_BELT:
				return validateConveyorBelt((ConveyorBelt)value, diagnostics, context);
			case MetamodelPackage.ORDER_TYPE:
				return validateOrderType((OrderType)value, diagnostics, context);
			case MetamodelPackage.OUTPUT_TYPE:
				return validateOutputType((OutputType)value, diagnostics, context);
			case MetamodelPackage.PERCENT:
				return validatePercent((Double)value, diagnostics, context);
			case MetamodelPackage.POSITIVE_INT:
				return validatePositiveInt((Integer)value, diagnostics, context);
			case MetamodelPackage.POSITIVE_DOUBLE:
				return validatePositiveDouble((Double)value, diagnostics, context);
			case MetamodelPackage.POSITIVE_INT_NOT_NULL:
				return validatePositiveIntNotNull((Integer)value, diagnostics, context);
			case MetamodelPackage.POSITIVE_DOUBLE_NOT_NULL:
				return validatePositiveDoubleNotNull((Double)value, diagnostics, context);
			case MetamodelPackage.PROBA_DOUBLE:
				return validateProbaDouble((Double)value, diagnostics, context);
			case MetamodelPackage.PROBA_DOUBLE_NOT_NULL:
				return validateProbaDoubleNotNull((Double)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModel(Model model, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(model, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQuery(Query query, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(query, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStorage(Storage storage, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(storage, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSupplier(Supplier supplier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(supplier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConveyorBelt(ConveyorBelt conveyorBelt, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(conveyorBelt, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBatchProcess(BatchProcess batchProcess, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(batchProcess, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutput(Output output, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(output, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStorageOutputFlow(StorageOutputFlow storageOutputFlow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(storageOutputFlow, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessOutputFlow(ProcessOutputFlow processOutputFlow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processOutputFlow, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcess(be.cetic.simqri.metamodel.Process process, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(process, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderOnStockThreshold(OrderOnStockThreshold orderOnStockThreshold, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(orderOnStockThreshold, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponent(Component component, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(component, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlow(Flow flow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(flow, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProbability(Probability probability, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(probability, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDistribution(Distribution distribution, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(distribution, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCauchy(Cauchy cauchy, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(cauchy, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinomial(Binomial binomial, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(binomial, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBeta(Beta beta, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(beta, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScalar(Scalar scalar, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(scalar, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChiSquare(ChiSquare chiSquare, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(chiSquare, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExponential(Exponential exponential, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(exponential, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFDistribution(FDistribution fDistribution, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fDistribution, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGamma(Gamma gamma, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(gamma, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeometric(Geometric geometric, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(geometric, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogNormal(LogNormal logNormal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(logNormal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGaussian(Gaussian gaussian, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(gaussian, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePareto(Pareto pareto, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(pareto, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePoisson(Poisson poisson, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(poisson, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStudentsT(StudentsT studentsT, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(studentsT, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUniform(Uniform uniform, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(uniform, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWeibull(Weibull weibull, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(weibull, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderType(OrderType orderType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutputType(OutputType outputType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePercent(Double percent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validatePercent_Min(percent, diagnostics, context);
		if (result || diagnostics != null) result &= validatePercent_Max(percent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatePercent_Min
	 */
	public static final Double PERCENT__MIN__VALUE = 0.0;

	/**
	 * Validates the Min constraint of '<em>Percent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePercent_Min(Double percent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = percent.compareTo(PERCENT__MIN__VALUE) >= 0;
		if (!result && diagnostics != null)
			reportMinViolation(MetamodelPackage.Literals.PERCENT, percent, PERCENT__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatePercent_Max
	 */
	public static final Double PERCENT__MAX__VALUE = 100.0;

	/**
	 * Validates the Max constraint of '<em>Percent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePercent_Max(Double percent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = percent.compareTo(PERCENT__MAX__VALUE) <= 0;
		if (!result && diagnostics != null)
			reportMaxViolation(MetamodelPackage.Literals.PERCENT, percent, PERCENT__MAX__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePositiveInt(Integer positiveInt, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validatePositiveInt_Min(positiveInt, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatePositiveInt_Min
	 */
	public static final Integer POSITIVE_INT__MIN__VALUE = 0;

	/**
	 * Validates the Min constraint of '<em>Positive Int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePositiveInt_Min(Integer positiveInt, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = positiveInt.compareTo(POSITIVE_INT__MIN__VALUE) >= 0;
		if (!result && diagnostics != null)
			reportMinViolation(MetamodelPackage.Literals.POSITIVE_INT, positiveInt, POSITIVE_INT__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePositiveDouble(Double positiveDouble, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validatePositiveDouble_Min(positiveDouble, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatePositiveDouble_Min
	 */
	public static final Double POSITIVE_DOUBLE__MIN__VALUE = 0.0;

	/**
	 * Validates the Min constraint of '<em>Positive Double</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePositiveDouble_Min(Double positiveDouble, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = positiveDouble.compareTo(POSITIVE_DOUBLE__MIN__VALUE) >= 0;
		if (!result && diagnostics != null)
			reportMinViolation(MetamodelPackage.Literals.POSITIVE_DOUBLE, positiveDouble, POSITIVE_DOUBLE__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePositiveIntNotNull(Integer positiveIntNotNull, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validatePositiveIntNotNull_Min(positiveIntNotNull, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatePositiveIntNotNull_Min
	 */
	public static final Integer POSITIVE_INT_NOT_NULL__MIN__VALUE = 1;

	/**
	 * Validates the Min constraint of '<em>Positive Int Not Null</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePositiveIntNotNull_Min(Integer positiveIntNotNull, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = positiveIntNotNull.compareTo(POSITIVE_INT_NOT_NULL__MIN__VALUE) >= 0;
		if (!result && diagnostics != null)
			reportMinViolation(MetamodelPackage.Literals.POSITIVE_INT_NOT_NULL, positiveIntNotNull, POSITIVE_INT_NOT_NULL__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePositiveDoubleNotNull(Double positiveDoubleNotNull, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validatePositiveDoubleNotNull_Min(positiveDoubleNotNull, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatePositiveDoubleNotNull_Min
	 */
	public static final Double POSITIVE_DOUBLE_NOT_NULL__MIN__VALUE = 0.0;

	/**
	 * Validates the Min constraint of '<em>Positive Double Not Null</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePositiveDoubleNotNull_Min(Double positiveDoubleNotNull, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = positiveDoubleNotNull.compareTo(POSITIVE_DOUBLE_NOT_NULL__MIN__VALUE) > 0;
		if (!result && diagnostics != null)
			reportMinViolation(MetamodelPackage.Literals.POSITIVE_DOUBLE_NOT_NULL, positiveDoubleNotNull, POSITIVE_DOUBLE_NOT_NULL__MIN__VALUE, false, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProbaDouble(Double probaDouble, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateProbaDouble_Min(probaDouble, diagnostics, context);
		if (result || diagnostics != null) result &= validateProbaDouble_Max(probaDouble, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateProbaDouble_Min
	 */
	public static final Double PROBA_DOUBLE__MIN__VALUE = 0.0;

	/**
	 * Validates the Min constraint of '<em>Proba Double</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProbaDouble_Min(Double probaDouble, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = probaDouble.compareTo(PROBA_DOUBLE__MIN__VALUE) >= 0;
		if (!result && diagnostics != null)
			reportMinViolation(MetamodelPackage.Literals.PROBA_DOUBLE, probaDouble, PROBA_DOUBLE__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateProbaDouble_Max
	 */
	public static final Double PROBA_DOUBLE__MAX__VALUE = 1.0;

	/**
	 * Validates the Max constraint of '<em>Proba Double</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProbaDouble_Max(Double probaDouble, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = probaDouble.compareTo(PROBA_DOUBLE__MAX__VALUE) <= 0;
		if (!result && diagnostics != null)
			reportMaxViolation(MetamodelPackage.Literals.PROBA_DOUBLE, probaDouble, PROBA_DOUBLE__MAX__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProbaDoubleNotNull(Double probaDoubleNotNull, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateProbaDoubleNotNull_Min(probaDoubleNotNull, diagnostics, context);
		if (result || diagnostics != null) result &= validateProbaDoubleNotNull_Max(probaDoubleNotNull, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateProbaDoubleNotNull_Min
	 */
	public static final Double PROBA_DOUBLE_NOT_NULL__MIN__VALUE = 0.0;

	/**
	 * Validates the Min constraint of '<em>Proba Double Not Null</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProbaDoubleNotNull_Min(Double probaDoubleNotNull, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = probaDoubleNotNull.compareTo(PROBA_DOUBLE_NOT_NULL__MIN__VALUE) > 0;
		if (!result && diagnostics != null)
			reportMinViolation(MetamodelPackage.Literals.PROBA_DOUBLE_NOT_NULL, probaDoubleNotNull, PROBA_DOUBLE_NOT_NULL__MIN__VALUE, false, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateProbaDoubleNotNull_Max
	 */
	public static final Double PROBA_DOUBLE_NOT_NULL__MAX__VALUE = 1.0;

	/**
	 * Validates the Max constraint of '<em>Proba Double Not Null</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProbaDoubleNotNull_Max(Double probaDoubleNotNull, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = probaDoubleNotNull.compareTo(PROBA_DOUBLE_NOT_NULL__MAX__VALUE) <= 0;
		if (!result && diagnostics != null)
			reportMaxViolation(MetamodelPackage.Literals.PROBA_DOUBLE_NOT_NULL, probaDoubleNotNull, PROBA_DOUBLE_NOT_NULL__MAX__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //MetamodelValidator

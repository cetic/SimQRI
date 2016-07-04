/**
 */
package be.cetic.simqri.metamodel.impl;

import be.cetic.simqri.metamodel.BatchProcess;
import be.cetic.simqri.metamodel.ConveyorBelt;
import be.cetic.simqri.metamodel.Gaussian;
import be.cetic.simqri.metamodel.MetamodelFactory;
import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.metamodel.OrderOnStockThreshold;
import be.cetic.simqri.metamodel.OrderType;
import be.cetic.simqri.metamodel.Output;
import be.cetic.simqri.metamodel.OutputType;
import be.cetic.simqri.metamodel.Poisson;
import be.cetic.simqri.metamodel.ProcessOutputFlow;
import be.cetic.simqri.metamodel.Query;
import be.cetic.simqri.metamodel.Scalar;
import be.cetic.simqri.metamodel.Storage;
import be.cetic.simqri.metamodel.StorageOutputFlow;
import be.cetic.simqri.metamodel.Supplier;
import be.cetic.simqri.metamodel.Uniform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetamodelFactoryImpl extends EFactoryImpl implements MetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MetamodelFactory init() {
		try {
			MetamodelFactory theMetamodelFactory = (MetamodelFactory)EPackage.Registry.INSTANCE.getEFactory(MetamodelPackage.eNS_URI);
			if (theMetamodelFactory != null) {
				return theMetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MetamodelPackage.MODEL: return createModel();
			case MetamodelPackage.QUERY: return createQuery();
			case MetamodelPackage.STORAGE: return createStorage();
			case MetamodelPackage.SUPPLIER: return createSupplier();
			case MetamodelPackage.BATCH_PROCESS: return createBatchProcess();
			case MetamodelPackage.OUTPUT: return createOutput();
			case MetamodelPackage.STORAGE_OUTPUT_FLOW: return createStorageOutputFlow();
			case MetamodelPackage.PROCESS_OUTPUT_FLOW: return createProcessOutputFlow();
			case MetamodelPackage.ORDER_ON_STOCK_THRESHOLD: return createOrderOnStockThreshold();
			case MetamodelPackage.SCALAR: return createScalar();
			case MetamodelPackage.GAUSSIAN: return createGaussian();
			case MetamodelPackage.POISSON: return createPoisson();
			case MetamodelPackage.UNIFORM: return createUniform();
			case MetamodelPackage.CONVEYOR_BELT: return createConveyorBelt();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case MetamodelPackage.ORDER_TYPE:
				return createOrderTypeFromString(eDataType, initialValue);
			case MetamodelPackage.OUTPUT_TYPE:
				return createOutputTypeFromString(eDataType, initialValue);
			case MetamodelPackage.PERCENT:
				return createPercentFromString(eDataType, initialValue);
			case MetamodelPackage.POSITIVE_INT:
				return createPositiveIntFromString(eDataType, initialValue);
			case MetamodelPackage.POSITIVE_DOUBLE:
				return createPositiveDoubleFromString(eDataType, initialValue);
			case MetamodelPackage.POSITIVE_INT_NOT_NULL:
				return createPositiveIntNotNullFromString(eDataType, initialValue);
			case MetamodelPackage.POSITIVE_DOUBLE_NOT_NULL:
				return createPositiveDoubleNotNullFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case MetamodelPackage.ORDER_TYPE:
				return convertOrderTypeToString(eDataType, instanceValue);
			case MetamodelPackage.OUTPUT_TYPE:
				return convertOutputTypeToString(eDataType, instanceValue);
			case MetamodelPackage.PERCENT:
				return convertPercentToString(eDataType, instanceValue);
			case MetamodelPackage.POSITIVE_INT:
				return convertPositiveIntToString(eDataType, instanceValue);
			case MetamodelPackage.POSITIVE_DOUBLE:
				return convertPositiveDoubleToString(eDataType, instanceValue);
			case MetamodelPackage.POSITIVE_INT_NOT_NULL:
				return convertPositiveIntNotNullToString(eDataType, instanceValue);
			case MetamodelPackage.POSITIVE_DOUBLE_NOT_NULL:
				return convertPositiveDoubleNotNullToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Query createQuery() {
		QueryImpl query = new QueryImpl();
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Storage createStorage() {
		StorageImpl storage = new StorageImpl();
		return storage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Supplier createSupplier() {
		SupplierImpl supplier = new SupplierImpl();
		return supplier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConveyorBelt createConveyorBelt() {
		ConveyorBeltImpl conveyorBelt = new ConveyorBeltImpl();
		return conveyorBelt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BatchProcess createBatchProcess() {
		BatchProcessImpl batchProcess = new BatchProcessImpl();
		return batchProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output createOutput() {
		OutputImpl output = new OutputImpl();
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorageOutputFlow createStorageOutputFlow() {
		StorageOutputFlowImpl storageOutputFlow = new StorageOutputFlowImpl();
		return storageOutputFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessOutputFlow createProcessOutputFlow() {
		ProcessOutputFlowImpl processOutputFlow = new ProcessOutputFlowImpl();
		return processOutputFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderOnStockThreshold createOrderOnStockThreshold() {
		OrderOnStockThresholdImpl orderOnStockThreshold = new OrderOnStockThresholdImpl();
		return orderOnStockThreshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scalar createScalar() {
		ScalarImpl scalar = new ScalarImpl();
		return scalar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gaussian createGaussian() {
		GaussianImpl gaussian = new GaussianImpl();
		return gaussian;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Poisson createPoisson() {
		PoissonImpl poisson = new PoissonImpl();
		return poisson;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Uniform createUniform() {
		UniformImpl uniform = new UniformImpl();
		return uniform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderType createOrderTypeFromString(EDataType eDataType, String initialValue) {
		OrderType result = OrderType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOrderTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputType createOutputTypeFromString(EDataType eDataType, String initialValue) {
		OutputType result = OutputType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOutputTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double createPercentFromString(EDataType eDataType, String initialValue) {
		return (Double)EcoreFactory.eINSTANCE.createFromString(EcorePackage.Literals.EDOUBLE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPercentToString(EDataType eDataType, Object instanceValue) {
		return EcoreFactory.eINSTANCE.convertToString(EcorePackage.Literals.EDOUBLE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createPositiveIntFromString(EDataType eDataType, String initialValue) {
		return (Integer)EcoreFactory.eINSTANCE.createFromString(EcorePackage.Literals.EINT, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPositiveIntToString(EDataType eDataType, Object instanceValue) {
		return EcoreFactory.eINSTANCE.convertToString(EcorePackage.Literals.EINT, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double createPositiveDoubleFromString(EDataType eDataType, String initialValue) {
		return (Double)EcoreFactory.eINSTANCE.createFromString(EcorePackage.Literals.EDOUBLE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPositiveDoubleToString(EDataType eDataType, Object instanceValue) {
		return EcoreFactory.eINSTANCE.convertToString(EcorePackage.Literals.EDOUBLE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createPositiveIntNotNullFromString(EDataType eDataType, String initialValue) {
		return (Integer)EcoreFactory.eINSTANCE.createFromString(EcorePackage.Literals.EINT, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPositiveIntNotNullToString(EDataType eDataType, Object instanceValue) {
		return EcoreFactory.eINSTANCE.convertToString(EcorePackage.Literals.EINT, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double createPositiveDoubleNotNullFromString(EDataType eDataType, String initialValue) {
		return (Double)EcoreFactory.eINSTANCE.createFromString(EcorePackage.Literals.EDOUBLE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPositiveDoubleNotNullToString(EDataType eDataType, Object instanceValue) {
		return EcoreFactory.eINSTANCE.convertToString(EcorePackage.Literals.EDOUBLE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelPackage getMetamodelPackage() {
		return (MetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetamodelPackage getPackage() {
		return MetamodelPackage.eINSTANCE;
	}

} //MetamodelFactoryImpl

/**
 */
package be.cetic.simqri.metamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see be.cetic.simqri.metamodel.MetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface MetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/metamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "metamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetamodelPackage eINSTANCE = be.cetic.simqri.metamodel.impl.MetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.ModelImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__QUERY = 1;

	/**
	 * The feature id for the '<em><b>Order On Stock Threshold</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ORDER_ON_STOCK_THRESHOLD = 2;

	/**
	 * The feature id for the '<em><b>Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__COMPONENT = 3;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__FLOW = 4;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.QueryImpl <em>Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.QueryImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getQuery()
	 * @generated
	 */
	int QUERY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__RESULT = 2;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__MAX = 3;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__MIN = 4;

	/**
	 * The feature id for the '<em><b>Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__MEAN = 5;

	/**
	 * The feature id for the '<em><b>Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY__VARIANCE = 6;

	/**
	 * The number of structural features of the '<em>Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.ComponentImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.StorageImpl <em>Storage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.StorageImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getStorage()
	 * @generated
	 */
	int STORAGE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__SIZE = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__INITIAL_CONTENT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Overflow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__OVERFLOW = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Storage Output Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__STORAGE_OUTPUT_FLOW = COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Order On Stock Threshold</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__ORDER_ON_STOCK_THRESHOLD = COMPONENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Process Output Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__PROCESS_OUTPUT_FLOW = COMPONENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Storage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Storage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.SupplierImpl <em>Supplier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.SupplierImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getSupplier()
	 * @generated
	 */
	int SUPPLIER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Delivered Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__DELIVERED_PERCENTAGE = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refill Policy</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__REFILL_POLICY = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Supplier Delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__SUPPLIER_DELAY = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Supplier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Supplier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.ProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.ProcessImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Storage Output Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__STORAGE_OUTPUT_FLOW = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__DURATION = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.ConveyorBeltImpl <em>Conveyor Belt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.ConveyorBeltImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getConveyorBelt()
	 * @generated
	 */
	int CONVEYOR_BELT = 30;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.BatchProcessImpl <em>Batch Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.BatchProcessImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getBatchProcess()
	 * @generated
	 */
	int BATCH_PROCESS = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BATCH_PROCESS__NAME = PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Storage Output Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BATCH_PROCESS__STORAGE_OUTPUT_FLOW = PROCESS__STORAGE_OUTPUT_FLOW;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BATCH_PROCESS__DURATION = PROCESS__DURATION;

	/**
	 * The feature id for the '<em><b>Percentage Of Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BATCH_PROCESS__PERCENTAGE_OF_SUCCESS = PROCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Number Of Lines</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BATCH_PROCESS__NUMBER_OF_LINES = PROCESS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BATCH_PROCESS__OUTPUTS = PROCESS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Batch Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BATCH_PROCESS_FEATURE_COUNT = PROCESS_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Batch Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BATCH_PROCESS_OPERATION_COUNT = PROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.OutputImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Process Output Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__PROCESS_OUTPUT_FLOW = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.FlowImpl <em>Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.FlowImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getFlow()
	 * @generated
	 */
	int FLOW = 11;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__QUANTITY = 0;

	/**
	 * The number of structural features of the '<em>Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.StorageOutputFlowImpl <em>Storage Output Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.StorageOutputFlowImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getStorageOutputFlow()
	 * @generated
	 */
	int STORAGE_OUTPUT_FLOW = 6;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_OUTPUT_FLOW__QUANTITY = FLOW__QUANTITY;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_OUTPUT_FLOW__SOURCE = FLOW_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_OUTPUT_FLOW__DESTINATION = FLOW_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Storage Output Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_OUTPUT_FLOW_FEATURE_COUNT = FLOW_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Storage Output Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_OUTPUT_FLOW_OPERATION_COUNT = FLOW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.ProcessOutputFlowImpl <em>Process Output Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.ProcessOutputFlowImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getProcessOutputFlow()
	 * @generated
	 */
	int PROCESS_OUTPUT_FLOW = 7;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OUTPUT_FLOW__QUANTITY = FLOW__QUANTITY;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OUTPUT_FLOW__SOURCE = FLOW_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Process Output Flow Delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY = FLOW_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OUTPUT_FLOW__DESTINATION = FLOW_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Process Output Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OUTPUT_FLOW_FEATURE_COUNT = FLOW_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Process Output Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OUTPUT_FLOW_OPERATION_COUNT = FLOW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.OrderOnStockThresholdImpl <em>Order On Stock Threshold</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.OrderOnStockThresholdImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getOrderOnStockThreshold()
	 * @generated
	 */
	int ORDER_ON_STOCK_THRESHOLD = 9;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_ON_STOCK_THRESHOLD__PERIOD = 0;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_ON_STOCK_THRESHOLD__THRESHOLD = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_ON_STOCK_THRESHOLD__NAME = 2;

	/**
	 * The feature id for the '<em><b>Order Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_ON_STOCK_THRESHOLD__ORDER_QUANTITY = 3;

	/**
	 * The feature id for the '<em><b>Order Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_ON_STOCK_THRESHOLD__ORDER_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Supplier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_ON_STOCK_THRESHOLD__SUPPLIER = 5;

	/**
	 * The feature id for the '<em><b>Storage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_ON_STOCK_THRESHOLD__STORAGE = 6;

	/**
	 * The number of structural features of the '<em>Order On Stock Threshold</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_ON_STOCK_THRESHOLD_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Order On Stock Threshold</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_ON_STOCK_THRESHOLD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.ProbabilityImpl <em>Probability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.ProbabilityImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getProbability()
	 * @generated
	 */
	int PROBABILITY = 12;

	/**
	 * The number of structural features of the '<em>Probability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Probability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.DistributionImpl <em>Distribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.DistributionImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getDistribution()
	 * @generated
	 */
	int DISTRIBUTION = 13;

	/**
	 * The number of structural features of the '<em>Distribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_FEATURE_COUNT = PROBABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Distribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_OPERATION_COUNT = PROBABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.CauchyImpl <em>Cauchy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.CauchyImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getCauchy()
	 * @generated
	 */
	int CAUCHY = 14;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAUCHY__LOCATION = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAUCHY__SCALE = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cauchy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAUCHY_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Cauchy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAUCHY_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.BinomialImpl <em>Binomial</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.BinomialImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getBinomial()
	 * @generated
	 */
	int BINOMIAL = 15;

	/**
	 * The feature id for the '<em><b>Nbr Of Trial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINOMIAL__NBR_OF_TRIAL = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Proba Of Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINOMIAL__PROBA_OF_SUCCESS = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binomial</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINOMIAL_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Binomial</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINOMIAL_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.BetaImpl <em>Beta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.BetaImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getBeta()
	 * @generated
	 */
	int BETA = 16;

	/**
	 * The feature id for the '<em><b>Freedom Degree A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BETA__FREEDOM_DEGREE_A = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Freedom Degree B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BETA__FREEDOM_DEGREE_B = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Beta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BETA_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Beta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BETA_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.ScalarImpl <em>Scalar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.ScalarImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getScalar()
	 * @generated
	 */
	int SCALAR = 17;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR__VALUE = PROBABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_FEATURE_COUNT = PROBABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_OPERATION_COUNT = PROBABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.ChiSquareImpl <em>Chi Square</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.ChiSquareImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getChiSquare()
	 * @generated
	 */
	int CHI_SQUARE = 18;

	/**
	 * The feature id for the '<em><b>Degree Of Freedom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHI_SQUARE__DEGREE_OF_FREEDOM = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Chi Square</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHI_SQUARE_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Chi Square</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHI_SQUARE_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.ExponentialImpl <em>Exponential</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.ExponentialImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getExponential()
	 * @generated
	 */
	int EXPONENTIAL = 19;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPONENTIAL__SCALE = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Exponential</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPONENTIAL_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Exponential</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPONENTIAL_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.FDistributionImpl <em>FDistribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.FDistributionImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getFDistribution()
	 * @generated
	 */
	int FDISTRIBUTION = 20;

	/**
	 * The feature id for the '<em><b>Freedom Degree A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FDISTRIBUTION__FREEDOM_DEGREE_A = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Freedom Degree B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FDISTRIBUTION__FREEDOM_DEGREE_B = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FDistribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FDISTRIBUTION_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>FDistribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FDISTRIBUTION_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.GammaImpl <em>Gamma</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.GammaImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getGamma()
	 * @generated
	 */
	int GAMMA = 21;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMMA__SHAPE = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gamma</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMMA_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Gamma</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMMA_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.GeometricImpl <em>Geometric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.GeometricImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getGeometric()
	 * @generated
	 */
	int GEOMETRIC = 22;

	/**
	 * The feature id for the '<em><b>Proba Of Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC__PROBA_OF_SUCCESS = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Geometric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Geometric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.LogNormalImpl <em>Log Normal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.LogNormalImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getLogNormal()
	 * @generated
	 */
	int LOG_NORMAL = 23;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_NORMAL__LOCATION = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_NORMAL__SCALE = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Log Normal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_NORMAL_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Log Normal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_NORMAL_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.GaussianImpl <em>Gaussian</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.GaussianImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getGaussian()
	 * @generated
	 */
	int GAUSSIAN = 24;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN__LOCATION = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN__SCALE = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gaussian</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Gaussian</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.ParetoImpl <em>Pareto</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.ParetoImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPareto()
	 * @generated
	 */
	int PARETO = 25;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARETO__SHAPE = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARETO__SCALE = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pareto</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARETO_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Pareto</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARETO_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.PoissonImpl <em>Poisson</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.PoissonImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPoisson()
	 * @generated
	 */
	int POISSON = 26;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POISSON__INTERVAL = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Poisson</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POISSON_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Poisson</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POISSON_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.StudentsTImpl <em>Students T</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.StudentsTImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getStudentsT()
	 * @generated
	 */
	int STUDENTS_T = 27;

	/**
	 * The feature id for the '<em><b>Degree Of Freedom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENTS_T__DEGREE_OF_FREEDOM = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Students T</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENTS_T_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Students T</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENTS_T_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.UniformImpl <em>Uniform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.UniformImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getUniform()
	 * @generated
	 */
	int UNIFORM = 28;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM__MINIMUM = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM__MAXIMUM = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Uniform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Uniform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.impl.WeibullImpl <em>Weibull</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.impl.WeibullImpl
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getWeibull()
	 * @generated
	 */
	int WEIBULL = 29;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIBULL__SHAPE = DISTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIBULL__SCALE = DISTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Weibull</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIBULL_FEATURE_COUNT = DISTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Weibull</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEIBULL_OPERATION_COUNT = DISTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVEYOR_BELT__NAME = PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Storage Output Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVEYOR_BELT__STORAGE_OUTPUT_FLOW = PROCESS__STORAGE_OUTPUT_FLOW;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVEYOR_BELT__DURATION = PROCESS__DURATION;

	/**
	 * The feature id for the '<em><b>Minimal Separation Between Batches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVEYOR_BELT__MINIMAL_SEPARATION_BETWEEN_BATCHES = PROCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVEYOR_BELT__OUTPUT = PROCESS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Conveyor Belt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVEYOR_BELT_FEATURE_COUNT = PROCESS_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Conveyor Belt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVEYOR_BELT_OPERATION_COUNT = PROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.OrderType <em>Order Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.OrderType
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getOrderType()
	 * @generated
	 */
	int ORDER_TYPE = 31;

	/**
	 * The meta object id for the '{@link be.cetic.simqri.metamodel.OutputType <em>Output Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see be.cetic.simqri.metamodel.OutputType
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getOutputType()
	 * @generated
	 */
	int OUTPUT_TYPE = 32;

	/**
	 * The meta object id for the '<em>Percent</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Double
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPercent()
	 * @generated
	 */
	int PERCENT = 33;

	/**
	 * The meta object id for the '<em>Positive Int</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Integer
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPositiveInt()
	 * @generated
	 */
	int POSITIVE_INT = 34;

	/**
	 * The meta object id for the '<em>Positive Double</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Double
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPositiveDouble()
	 * @generated
	 */
	int POSITIVE_DOUBLE = 35;

	/**
	 * The meta object id for the '<em>Positive Int Not Null</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Integer
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPositiveIntNotNull()
	 * @generated
	 */
	int POSITIVE_INT_NOT_NULL = 36;

	/**
	 * The meta object id for the '<em>Positive Double Not Null</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Double
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPositiveDoubleNotNull()
	 * @generated
	 */
	int POSITIVE_DOUBLE_NOT_NULL = 37;

	/**
	 * The meta object id for the '<em>Proba Double</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Double
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getProbaDouble()
	 * @generated
	 */
	int PROBA_DOUBLE = 38;

	/**
	 * The meta object id for the '<em>Proba Double Not Null</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Double
	 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getProbaDoubleNotNull()
	 * @generated
	 */
	int PROBA_DOUBLE_NOT_NULL = 39;


	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see be.cetic.simqri.metamodel.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Model#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see be.cetic.simqri.metamodel.Model#getName()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link be.cetic.simqri.metamodel.Model#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Query</em>'.
	 * @see be.cetic.simqri.metamodel.Model#getQuery()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Query();

	/**
	 * Returns the meta object for the containment reference list '{@link be.cetic.simqri.metamodel.Model#getOrderOnStockThreshold <em>Order On Stock Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Order On Stock Threshold</em>'.
	 * @see be.cetic.simqri.metamodel.Model#getOrderOnStockThreshold()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_OrderOnStockThreshold();

	/**
	 * Returns the meta object for the containment reference list '{@link be.cetic.simqri.metamodel.Model#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component</em>'.
	 * @see be.cetic.simqri.metamodel.Model#getComponent()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Component();

	/**
	 * Returns the meta object for the containment reference list '{@link be.cetic.simqri.metamodel.Model#getFlow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Flow</em>'.
	 * @see be.cetic.simqri.metamodel.Model#getFlow()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Flow();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query</em>'.
	 * @see be.cetic.simqri.metamodel.Query
	 * @generated
	 */
	EClass getQuery();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Query#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see be.cetic.simqri.metamodel.Query#getName()
	 * @see #getQuery()
	 * @generated
	 */
	EAttribute getQuery_Name();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Query#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see be.cetic.simqri.metamodel.Query#getValue()
	 * @see #getQuery()
	 * @generated
	 */
	EAttribute getQuery_Value();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Query#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see be.cetic.simqri.metamodel.Query#getResult()
	 * @see #getQuery()
	 * @generated
	 */
	EAttribute getQuery_Result();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Query#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see be.cetic.simqri.metamodel.Query#getMax()
	 * @see #getQuery()
	 * @generated
	 */
	EAttribute getQuery_Max();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Query#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see be.cetic.simqri.metamodel.Query#getMin()
	 * @see #getQuery()
	 * @generated
	 */
	EAttribute getQuery_Min();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Query#getMean <em>Mean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mean</em>'.
	 * @see be.cetic.simqri.metamodel.Query#getMean()
	 * @see #getQuery()
	 * @generated
	 */
	EAttribute getQuery_Mean();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Query#getVariance <em>Variance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variance</em>'.
	 * @see be.cetic.simqri.metamodel.Query#getVariance()
	 * @see #getQuery()
	 * @generated
	 */
	EAttribute getQuery_Variance();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Storage <em>Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Storage</em>'.
	 * @see be.cetic.simqri.metamodel.Storage
	 * @generated
	 */
	EClass getStorage();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Storage#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see be.cetic.simqri.metamodel.Storage#getSize()
	 * @see #getStorage()
	 * @generated
	 */
	EAttribute getStorage_Size();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Storage#getInitialContent <em>Initial Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Content</em>'.
	 * @see be.cetic.simqri.metamodel.Storage#getInitialContent()
	 * @see #getStorage()
	 * @generated
	 */
	EAttribute getStorage_InitialContent();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Storage#isOverflow <em>Overflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overflow</em>'.
	 * @see be.cetic.simqri.metamodel.Storage#isOverflow()
	 * @see #getStorage()
	 * @generated
	 */
	EAttribute getStorage_Overflow();

	/**
	 * Returns the meta object for the reference list '{@link be.cetic.simqri.metamodel.Storage#getStorageOutputFlow <em>Storage Output Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Storage Output Flow</em>'.
	 * @see be.cetic.simqri.metamodel.Storage#getStorageOutputFlow()
	 * @see #getStorage()
	 * @generated
	 */
	EReference getStorage_StorageOutputFlow();

	/**
	 * Returns the meta object for the reference list '{@link be.cetic.simqri.metamodel.Storage#getOrderOnStockThreshold <em>Order On Stock Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Order On Stock Threshold</em>'.
	 * @see be.cetic.simqri.metamodel.Storage#getOrderOnStockThreshold()
	 * @see #getStorage()
	 * @generated
	 */
	EReference getStorage_OrderOnStockThreshold();

	/**
	 * Returns the meta object for the reference list '{@link be.cetic.simqri.metamodel.Storage#getProcessOutputFlow <em>Process Output Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Process Output Flow</em>'.
	 * @see be.cetic.simqri.metamodel.Storage#getProcessOutputFlow()
	 * @see #getStorage()
	 * @generated
	 */
	EReference getStorage_ProcessOutputFlow();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Supplier <em>Supplier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supplier</em>'.
	 * @see be.cetic.simqri.metamodel.Supplier
	 * @generated
	 */
	EClass getSupplier();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Supplier#getDeliveredPercentage <em>Delivered Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delivered Percentage</em>'.
	 * @see be.cetic.simqri.metamodel.Supplier#getDeliveredPercentage()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_DeliveredPercentage();

	/**
	 * Returns the meta object for the reference list '{@link be.cetic.simqri.metamodel.Supplier#getRefillPolicy <em>Refill Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refill Policy</em>'.
	 * @see be.cetic.simqri.metamodel.Supplier#getRefillPolicy()
	 * @see #getSupplier()
	 * @generated
	 */
	EReference getSupplier_RefillPolicy();

	/**
	 * Returns the meta object for the containment reference '{@link be.cetic.simqri.metamodel.Supplier#getSupplierDelay <em>Supplier Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Supplier Delay</em>'.
	 * @see be.cetic.simqri.metamodel.Supplier#getSupplierDelay()
	 * @see #getSupplier()
	 * @generated
	 */
	EReference getSupplier_SupplierDelay();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.ConveyorBelt <em>Conveyor Belt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conveyor Belt</em>'.
	 * @see be.cetic.simqri.metamodel.ConveyorBelt
	 * @generated
	 */
	EClass getConveyorBelt();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.ConveyorBelt#getMinimalSeparationBetweenBatches <em>Minimal Separation Between Batches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimal Separation Between Batches</em>'.
	 * @see be.cetic.simqri.metamodel.ConveyorBelt#getMinimalSeparationBetweenBatches()
	 * @see #getConveyorBelt()
	 * @generated
	 */
	EAttribute getConveyorBelt_MinimalSeparationBetweenBatches();

	/**
	 * Returns the meta object for the containment reference '{@link be.cetic.simqri.metamodel.ConveyorBelt#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output</em>'.
	 * @see be.cetic.simqri.metamodel.ConveyorBelt#getOutput()
	 * @see #getConveyorBelt()
	 * @generated
	 */
	EReference getConveyorBelt_Output();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.BatchProcess <em>Batch Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Batch Process</em>'.
	 * @see be.cetic.simqri.metamodel.BatchProcess
	 * @generated
	 */
	EClass getBatchProcess();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.BatchProcess#getPercentageOfSuccess <em>Percentage Of Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Percentage Of Success</em>'.
	 * @see be.cetic.simqri.metamodel.BatchProcess#getPercentageOfSuccess()
	 * @see #getBatchProcess()
	 * @generated
	 */
	EAttribute getBatchProcess_PercentageOfSuccess();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.BatchProcess#getNumberOfLines <em>Number Of Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Lines</em>'.
	 * @see be.cetic.simqri.metamodel.BatchProcess#getNumberOfLines()
	 * @see #getBatchProcess()
	 * @generated
	 */
	EAttribute getBatchProcess_NumberOfLines();

	/**
	 * Returns the meta object for the containment reference list '{@link be.cetic.simqri.metamodel.BatchProcess#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see be.cetic.simqri.metamodel.BatchProcess#getOutputs()
	 * @see #getBatchProcess()
	 * @generated
	 */
	EReference getBatchProcess_Outputs();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see be.cetic.simqri.metamodel.Output
	 * @generated
	 */
	EClass getOutput();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Output#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see be.cetic.simqri.metamodel.Output#getType()
	 * @see #getOutput()
	 * @generated
	 */
	EAttribute getOutput_Type();

	/**
	 * Returns the meta object for the reference list '{@link be.cetic.simqri.metamodel.Output#getProcessOutputFlow <em>Process Output Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Process Output Flow</em>'.
	 * @see be.cetic.simqri.metamodel.Output#getProcessOutputFlow()
	 * @see #getOutput()
	 * @generated
	 */
	EReference getOutput_ProcessOutputFlow();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Output#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see be.cetic.simqri.metamodel.Output#getDescription()
	 * @see #getOutput()
	 * @generated
	 */
	EAttribute getOutput_Description();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.StorageOutputFlow <em>Storage Output Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Storage Output Flow</em>'.
	 * @see be.cetic.simqri.metamodel.StorageOutputFlow
	 * @generated
	 */
	EClass getStorageOutputFlow();

	/**
	 * Returns the meta object for the reference '{@link be.cetic.simqri.metamodel.StorageOutputFlow#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see be.cetic.simqri.metamodel.StorageOutputFlow#getDestination()
	 * @see #getStorageOutputFlow()
	 * @generated
	 */
	EReference getStorageOutputFlow_Destination();

	/**
	 * Returns the meta object for the reference '{@link be.cetic.simqri.metamodel.StorageOutputFlow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see be.cetic.simqri.metamodel.StorageOutputFlow#getSource()
	 * @see #getStorageOutputFlow()
	 * @generated
	 */
	EReference getStorageOutputFlow_Source();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.ProcessOutputFlow <em>Process Output Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Output Flow</em>'.
	 * @see be.cetic.simqri.metamodel.ProcessOutputFlow
	 * @generated
	 */
	EClass getProcessOutputFlow();

	/**
	 * Returns the meta object for the reference '{@link be.cetic.simqri.metamodel.ProcessOutputFlow#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see be.cetic.simqri.metamodel.ProcessOutputFlow#getDestination()
	 * @see #getProcessOutputFlow()
	 * @generated
	 */
	EReference getProcessOutputFlow_Destination();

	/**
	 * Returns the meta object for the reference '{@link be.cetic.simqri.metamodel.ProcessOutputFlow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see be.cetic.simqri.metamodel.ProcessOutputFlow#getSource()
	 * @see #getProcessOutputFlow()
	 * @generated
	 */
	EReference getProcessOutputFlow_Source();

	/**
	 * Returns the meta object for the containment reference '{@link be.cetic.simqri.metamodel.ProcessOutputFlow#getProcessOutputFlowDelay <em>Process Output Flow Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Process Output Flow Delay</em>'.
	 * @see be.cetic.simqri.metamodel.ProcessOutputFlow#getProcessOutputFlowDelay()
	 * @see #getProcessOutputFlow()
	 * @generated
	 */
	EReference getProcessOutputFlow_ProcessOutputFlowDelay();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see be.cetic.simqri.metamodel.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for the containment reference '{@link be.cetic.simqri.metamodel.Process#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Duration</em>'.
	 * @see be.cetic.simqri.metamodel.Process#getDuration()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_Duration();

	/**
	 * Returns the meta object for the reference list '{@link be.cetic.simqri.metamodel.Process#getStorageOutputFlow <em>Storage Output Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Storage Output Flow</em>'.
	 * @see be.cetic.simqri.metamodel.Process#getStorageOutputFlow()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_StorageOutputFlow();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.OrderOnStockThreshold <em>Order On Stock Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Order On Stock Threshold</em>'.
	 * @see be.cetic.simqri.metamodel.OrderOnStockThreshold
	 * @generated
	 */
	EClass getOrderOnStockThreshold();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.OrderOnStockThreshold#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see be.cetic.simqri.metamodel.OrderOnStockThreshold#getPeriod()
	 * @see #getOrderOnStockThreshold()
	 * @generated
	 */
	EAttribute getOrderOnStockThreshold_Period();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.OrderOnStockThreshold#getThreshold <em>Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Threshold</em>'.
	 * @see be.cetic.simqri.metamodel.OrderOnStockThreshold#getThreshold()
	 * @see #getOrderOnStockThreshold()
	 * @generated
	 */
	EAttribute getOrderOnStockThreshold_Threshold();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.OrderOnStockThreshold#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see be.cetic.simqri.metamodel.OrderOnStockThreshold#getName()
	 * @see #getOrderOnStockThreshold()
	 * @generated
	 */
	EAttribute getOrderOnStockThreshold_Name();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.OrderOnStockThreshold#getOrderQuantity <em>Order Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order Quantity</em>'.
	 * @see be.cetic.simqri.metamodel.OrderOnStockThreshold#getOrderQuantity()
	 * @see #getOrderOnStockThreshold()
	 * @generated
	 */
	EAttribute getOrderOnStockThreshold_OrderQuantity();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.OrderOnStockThreshold#getOrderType <em>Order Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order Type</em>'.
	 * @see be.cetic.simqri.metamodel.OrderOnStockThreshold#getOrderType()
	 * @see #getOrderOnStockThreshold()
	 * @generated
	 */
	EAttribute getOrderOnStockThreshold_OrderType();

	/**
	 * Returns the meta object for the reference '{@link be.cetic.simqri.metamodel.OrderOnStockThreshold#getStorage <em>Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Storage</em>'.
	 * @see be.cetic.simqri.metamodel.OrderOnStockThreshold#getStorage()
	 * @see #getOrderOnStockThreshold()
	 * @generated
	 */
	EReference getOrderOnStockThreshold_Storage();

	/**
	 * Returns the meta object for the reference '{@link be.cetic.simqri.metamodel.OrderOnStockThreshold#getSupplier <em>Supplier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Supplier</em>'.
	 * @see be.cetic.simqri.metamodel.OrderOnStockThreshold#getSupplier()
	 * @see #getOrderOnStockThreshold()
	 * @generated
	 */
	EReference getOrderOnStockThreshold_Supplier();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see be.cetic.simqri.metamodel.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Component#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see be.cetic.simqri.metamodel.Component#getName()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Name();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Flow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow</em>'.
	 * @see be.cetic.simqri.metamodel.Flow
	 * @generated
	 */
	EClass getFlow();

	/**
	 * Returns the meta object for the containment reference '{@link be.cetic.simqri.metamodel.Flow#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Quantity</em>'.
	 * @see be.cetic.simqri.metamodel.Flow#getQuantity()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_Quantity();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Probability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Probability</em>'.
	 * @see be.cetic.simqri.metamodel.Probability
	 * @generated
	 */
	EClass getProbability();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Distribution <em>Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distribution</em>'.
	 * @see be.cetic.simqri.metamodel.Distribution
	 * @generated
	 */
	EClass getDistribution();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Cauchy <em>Cauchy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cauchy</em>'.
	 * @see be.cetic.simqri.metamodel.Cauchy
	 * @generated
	 */
	EClass getCauchy();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Cauchy#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see be.cetic.simqri.metamodel.Cauchy#getLocation()
	 * @see #getCauchy()
	 * @generated
	 */
	EAttribute getCauchy_Location();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Cauchy#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see be.cetic.simqri.metamodel.Cauchy#getScale()
	 * @see #getCauchy()
	 * @generated
	 */
	EAttribute getCauchy_Scale();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Binomial <em>Binomial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binomial</em>'.
	 * @see be.cetic.simqri.metamodel.Binomial
	 * @generated
	 */
	EClass getBinomial();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Binomial#getNbrOfTrial <em>Nbr Of Trial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nbr Of Trial</em>'.
	 * @see be.cetic.simqri.metamodel.Binomial#getNbrOfTrial()
	 * @see #getBinomial()
	 * @generated
	 */
	EAttribute getBinomial_NbrOfTrial();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Binomial#getProbaOfSuccess <em>Proba Of Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proba Of Success</em>'.
	 * @see be.cetic.simqri.metamodel.Binomial#getProbaOfSuccess()
	 * @see #getBinomial()
	 * @generated
	 */
	EAttribute getBinomial_ProbaOfSuccess();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Beta <em>Beta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Beta</em>'.
	 * @see be.cetic.simqri.metamodel.Beta
	 * @generated
	 */
	EClass getBeta();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Beta#getFreedomDegreeA <em>Freedom Degree A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Freedom Degree A</em>'.
	 * @see be.cetic.simqri.metamodel.Beta#getFreedomDegreeA()
	 * @see #getBeta()
	 * @generated
	 */
	EAttribute getBeta_FreedomDegreeA();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Beta#getFreedomDegreeB <em>Freedom Degree B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Freedom Degree B</em>'.
	 * @see be.cetic.simqri.metamodel.Beta#getFreedomDegreeB()
	 * @see #getBeta()
	 * @generated
	 */
	EAttribute getBeta_FreedomDegreeB();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Scalar <em>Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar</em>'.
	 * @see be.cetic.simqri.metamodel.Scalar
	 * @generated
	 */
	EClass getScalar();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Scalar#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see be.cetic.simqri.metamodel.Scalar#getValue()
	 * @see #getScalar()
	 * @generated
	 */
	EAttribute getScalar_Value();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.ChiSquare <em>Chi Square</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Chi Square</em>'.
	 * @see be.cetic.simqri.metamodel.ChiSquare
	 * @generated
	 */
	EClass getChiSquare();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.ChiSquare#getDegreeOfFreedom <em>Degree Of Freedom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Degree Of Freedom</em>'.
	 * @see be.cetic.simqri.metamodel.ChiSquare#getDegreeOfFreedom()
	 * @see #getChiSquare()
	 * @generated
	 */
	EAttribute getChiSquare_DegreeOfFreedom();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Exponential <em>Exponential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exponential</em>'.
	 * @see be.cetic.simqri.metamodel.Exponential
	 * @generated
	 */
	EClass getExponential();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Exponential#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see be.cetic.simqri.metamodel.Exponential#getScale()
	 * @see #getExponential()
	 * @generated
	 */
	EAttribute getExponential_Scale();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.FDistribution <em>FDistribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FDistribution</em>'.
	 * @see be.cetic.simqri.metamodel.FDistribution
	 * @generated
	 */
	EClass getFDistribution();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.FDistribution#getFreedomDegreeA <em>Freedom Degree A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Freedom Degree A</em>'.
	 * @see be.cetic.simqri.metamodel.FDistribution#getFreedomDegreeA()
	 * @see #getFDistribution()
	 * @generated
	 */
	EAttribute getFDistribution_FreedomDegreeA();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.FDistribution#getFreedomDegreeB <em>Freedom Degree B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Freedom Degree B</em>'.
	 * @see be.cetic.simqri.metamodel.FDistribution#getFreedomDegreeB()
	 * @see #getFDistribution()
	 * @generated
	 */
	EAttribute getFDistribution_FreedomDegreeB();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Gamma <em>Gamma</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gamma</em>'.
	 * @see be.cetic.simqri.metamodel.Gamma
	 * @generated
	 */
	EClass getGamma();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Gamma#getShape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shape</em>'.
	 * @see be.cetic.simqri.metamodel.Gamma#getShape()
	 * @see #getGamma()
	 * @generated
	 */
	EAttribute getGamma_Shape();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Geometric <em>Geometric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Geometric</em>'.
	 * @see be.cetic.simqri.metamodel.Geometric
	 * @generated
	 */
	EClass getGeometric();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Geometric#getProbaOfSuccess <em>Proba Of Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proba Of Success</em>'.
	 * @see be.cetic.simqri.metamodel.Geometric#getProbaOfSuccess()
	 * @see #getGeometric()
	 * @generated
	 */
	EAttribute getGeometric_ProbaOfSuccess();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.LogNormal <em>Log Normal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Normal</em>'.
	 * @see be.cetic.simqri.metamodel.LogNormal
	 * @generated
	 */
	EClass getLogNormal();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.LogNormal#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see be.cetic.simqri.metamodel.LogNormal#getLocation()
	 * @see #getLogNormal()
	 * @generated
	 */
	EAttribute getLogNormal_Location();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.LogNormal#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see be.cetic.simqri.metamodel.LogNormal#getScale()
	 * @see #getLogNormal()
	 * @generated
	 */
	EAttribute getLogNormal_Scale();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Gaussian <em>Gaussian</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gaussian</em>'.
	 * @see be.cetic.simqri.metamodel.Gaussian
	 * @generated
	 */
	EClass getGaussian();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Gaussian#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see be.cetic.simqri.metamodel.Gaussian#getLocation()
	 * @see #getGaussian()
	 * @generated
	 */
	EAttribute getGaussian_Location();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Gaussian#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see be.cetic.simqri.metamodel.Gaussian#getScale()
	 * @see #getGaussian()
	 * @generated
	 */
	EAttribute getGaussian_Scale();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Pareto <em>Pareto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pareto</em>'.
	 * @see be.cetic.simqri.metamodel.Pareto
	 * @generated
	 */
	EClass getPareto();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Pareto#getShape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shape</em>'.
	 * @see be.cetic.simqri.metamodel.Pareto#getShape()
	 * @see #getPareto()
	 * @generated
	 */
	EAttribute getPareto_Shape();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Pareto#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see be.cetic.simqri.metamodel.Pareto#getScale()
	 * @see #getPareto()
	 * @generated
	 */
	EAttribute getPareto_Scale();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Poisson <em>Poisson</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Poisson</em>'.
	 * @see be.cetic.simqri.metamodel.Poisson
	 * @generated
	 */
	EClass getPoisson();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Poisson#getInterval <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interval</em>'.
	 * @see be.cetic.simqri.metamodel.Poisson#getInterval()
	 * @see #getPoisson()
	 * @generated
	 */
	EAttribute getPoisson_Interval();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.StudentsT <em>Students T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Students T</em>'.
	 * @see be.cetic.simqri.metamodel.StudentsT
	 * @generated
	 */
	EClass getStudentsT();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.StudentsT#getDegreeOfFreedom <em>Degree Of Freedom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Degree Of Freedom</em>'.
	 * @see be.cetic.simqri.metamodel.StudentsT#getDegreeOfFreedom()
	 * @see #getStudentsT()
	 * @generated
	 */
	EAttribute getStudentsT_DegreeOfFreedom();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Uniform <em>Uniform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uniform</em>'.
	 * @see be.cetic.simqri.metamodel.Uniform
	 * @generated
	 */
	EClass getUniform();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Uniform#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see be.cetic.simqri.metamodel.Uniform#getMinimum()
	 * @see #getUniform()
	 * @generated
	 */
	EAttribute getUniform_Minimum();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Uniform#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see be.cetic.simqri.metamodel.Uniform#getMaximum()
	 * @see #getUniform()
	 * @generated
	 */
	EAttribute getUniform_Maximum();

	/**
	 * Returns the meta object for class '{@link be.cetic.simqri.metamodel.Weibull <em>Weibull</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Weibull</em>'.
	 * @see be.cetic.simqri.metamodel.Weibull
	 * @generated
	 */
	EClass getWeibull();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Weibull#getShape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shape</em>'.
	 * @see be.cetic.simqri.metamodel.Weibull#getShape()
	 * @see #getWeibull()
	 * @generated
	 */
	EAttribute getWeibull_Shape();

	/**
	 * Returns the meta object for the attribute '{@link be.cetic.simqri.metamodel.Weibull#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see be.cetic.simqri.metamodel.Weibull#getScale()
	 * @see #getWeibull()
	 * @generated
	 */
	EAttribute getWeibull_Scale();

	/**
	 * Returns the meta object for enum '{@link be.cetic.simqri.metamodel.OrderType <em>Order Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Order Type</em>'.
	 * @see be.cetic.simqri.metamodel.OrderType
	 * @generated
	 */
	EEnum getOrderType();

	/**
	 * Returns the meta object for enum '{@link be.cetic.simqri.metamodel.OutputType <em>Output Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Output Type</em>'.
	 * @see be.cetic.simqri.metamodel.OutputType
	 * @generated
	 */
	EEnum getOutputType();

	/**
	 * Returns the meta object for data type '{@link java.lang.Double <em>Percent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Percent</em>'.
	 * @see java.lang.Double
	 * @model instanceClass="java.lang.Double"
	 *        extendedMetaData="baseType='http://www.eclipse.org/emf/2002/Ecore#EDouble' minInclusive='0' maxInclusive='100'"
	 * @generated
	 */
	EDataType getPercent();

	/**
	 * Returns the meta object for data type '{@link java.lang.Integer <em>Positive Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Positive Int</em>'.
	 * @see java.lang.Integer
	 * @model instanceClass="java.lang.Integer"
	 *        extendedMetaData="baseType='http://www.eclipse.org/emf/2002/Ecore#EInt' minInclusive='0' name='PositiveInt'"
	 * @generated
	 */
	EDataType getPositiveInt();

	/**
	 * Returns the meta object for data type '{@link java.lang.Double <em>Positive Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Positive Double</em>'.
	 * @see java.lang.Double
	 * @model instanceClass="java.lang.Double"
	 *        extendedMetaData="minInclusive='0' baseType='http://www.eclipse.org/emf/2002/Ecore#EDouble'"
	 * @generated
	 */
	EDataType getPositiveDouble();

	/**
	 * Returns the meta object for data type '{@link java.lang.Integer <em>Positive Int Not Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Positive Int Not Null</em>'.
	 * @see java.lang.Integer
	 * @model instanceClass="java.lang.Integer"
	 *        extendedMetaData="baseType='http://www.eclipse.org/emf/2002/Ecore#EInt' minInclusive='1'"
	 * @generated
	 */
	EDataType getPositiveIntNotNull();

	/**
	 * Returns the meta object for data type '{@link java.lang.Double <em>Positive Double Not Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Positive Double Not Null</em>'.
	 * @see java.lang.Double
	 * @model instanceClass="java.lang.Double"
	 *        extendedMetaData="name='PositiveDoubleNotNull' minExclusive='0' baseType='http://www.eclipse.org/emf/2002/Ecore#EDouble'"
	 * @generated
	 */
	EDataType getPositiveDoubleNotNull();

	/**
	 * Returns the meta object for data type '{@link java.lang.Double <em>Proba Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Proba Double</em>'.
	 * @see java.lang.Double
	 * @model instanceClass="java.lang.Double"
	 *        extendedMetaData="baseType='http://www.eclipse.org/emf/2002/Ecore#EDouble' minInclusive='0' maxInclusive='1'"
	 * @generated
	 */
	EDataType getProbaDouble();

	/**
	 * Returns the meta object for data type '{@link java.lang.Double <em>Proba Double Not Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Proba Double Not Null</em>'.
	 * @see java.lang.Double
	 * @model instanceClass="java.lang.Double"
	 *        extendedMetaData="baseType='http://www.eclipse.org/emf/2002/Ecore#EDouble' maxInclusive='1' minExclusive='0'"
	 * @generated
	 */
	EDataType getProbaDoubleNotNull();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetamodelFactory getMetamodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.ModelImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__QUERY = eINSTANCE.getModel_Query();

		/**
		 * The meta object literal for the '<em><b>Order On Stock Threshold</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ORDER_ON_STOCK_THRESHOLD = eINSTANCE.getModel_OrderOnStockThreshold();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__COMPONENT = eINSTANCE.getModel_Component();

		/**
		 * The meta object literal for the '<em><b>Flow</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__FLOW = eINSTANCE.getModel_Flow();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.QueryImpl <em>Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.QueryImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getQuery()
		 * @generated
		 */
		EClass QUERY = eINSTANCE.getQuery();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY__NAME = eINSTANCE.getQuery_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY__VALUE = eINSTANCE.getQuery_Value();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY__RESULT = eINSTANCE.getQuery_Result();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY__MAX = eINSTANCE.getQuery_Max();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY__MIN = eINSTANCE.getQuery_Min();

		/**
		 * The meta object literal for the '<em><b>Mean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY__MEAN = eINSTANCE.getQuery_Mean();

		/**
		 * The meta object literal for the '<em><b>Variance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY__VARIANCE = eINSTANCE.getQuery_Variance();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.StorageImpl <em>Storage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.StorageImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getStorage()
		 * @generated
		 */
		EClass STORAGE = eINSTANCE.getStorage();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORAGE__SIZE = eINSTANCE.getStorage_Size();

		/**
		 * The meta object literal for the '<em><b>Initial Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORAGE__INITIAL_CONTENT = eINSTANCE.getStorage_InitialContent();

		/**
		 * The meta object literal for the '<em><b>Overflow</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORAGE__OVERFLOW = eINSTANCE.getStorage_Overflow();

		/**
		 * The meta object literal for the '<em><b>Storage Output Flow</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORAGE__STORAGE_OUTPUT_FLOW = eINSTANCE.getStorage_StorageOutputFlow();

		/**
		 * The meta object literal for the '<em><b>Order On Stock Threshold</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORAGE__ORDER_ON_STOCK_THRESHOLD = eINSTANCE.getStorage_OrderOnStockThreshold();

		/**
		 * The meta object literal for the '<em><b>Process Output Flow</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORAGE__PROCESS_OUTPUT_FLOW = eINSTANCE.getStorage_ProcessOutputFlow();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.SupplierImpl <em>Supplier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.SupplierImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getSupplier()
		 * @generated
		 */
		EClass SUPPLIER = eINSTANCE.getSupplier();

		/**
		 * The meta object literal for the '<em><b>Delivered Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__DELIVERED_PERCENTAGE = eINSTANCE.getSupplier_DeliveredPercentage();

		/**
		 * The meta object literal for the '<em><b>Refill Policy</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPPLIER__REFILL_POLICY = eINSTANCE.getSupplier_RefillPolicy();

		/**
		 * The meta object literal for the '<em><b>Supplier Delay</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPPLIER__SUPPLIER_DELAY = eINSTANCE.getSupplier_SupplierDelay();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.ConveyorBeltImpl <em>Conveyor Belt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.ConveyorBeltImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getConveyorBelt()
		 * @generated
		 */
		EClass CONVEYOR_BELT = eINSTANCE.getConveyorBelt();

		/**
		 * The meta object literal for the '<em><b>Minimal Separation Between Batches</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONVEYOR_BELT__MINIMAL_SEPARATION_BETWEEN_BATCHES = eINSTANCE.getConveyorBelt_MinimalSeparationBetweenBatches();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONVEYOR_BELT__OUTPUT = eINSTANCE.getConveyorBelt_Output();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.BatchProcessImpl <em>Batch Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.BatchProcessImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getBatchProcess()
		 * @generated
		 */
		EClass BATCH_PROCESS = eINSTANCE.getBatchProcess();

		/**
		 * The meta object literal for the '<em><b>Percentage Of Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BATCH_PROCESS__PERCENTAGE_OF_SUCCESS = eINSTANCE.getBatchProcess_PercentageOfSuccess();

		/**
		 * The meta object literal for the '<em><b>Number Of Lines</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BATCH_PROCESS__NUMBER_OF_LINES = eINSTANCE.getBatchProcess_NumberOfLines();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BATCH_PROCESS__OUTPUTS = eINSTANCE.getBatchProcess_Outputs();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.OutputImpl <em>Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.OutputImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getOutput()
		 * @generated
		 */
		EClass OUTPUT = eINSTANCE.getOutput();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT__TYPE = eINSTANCE.getOutput_Type();

		/**
		 * The meta object literal for the '<em><b>Process Output Flow</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT__PROCESS_OUTPUT_FLOW = eINSTANCE.getOutput_ProcessOutputFlow();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT__DESCRIPTION = eINSTANCE.getOutput_Description();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.StorageOutputFlowImpl <em>Storage Output Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.StorageOutputFlowImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getStorageOutputFlow()
		 * @generated
		 */
		EClass STORAGE_OUTPUT_FLOW = eINSTANCE.getStorageOutputFlow();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORAGE_OUTPUT_FLOW__DESTINATION = eINSTANCE.getStorageOutputFlow_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORAGE_OUTPUT_FLOW__SOURCE = eINSTANCE.getStorageOutputFlow_Source();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.ProcessOutputFlowImpl <em>Process Output Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.ProcessOutputFlowImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getProcessOutputFlow()
		 * @generated
		 */
		EClass PROCESS_OUTPUT_FLOW = eINSTANCE.getProcessOutputFlow();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_OUTPUT_FLOW__DESTINATION = eINSTANCE.getProcessOutputFlow_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_OUTPUT_FLOW__SOURCE = eINSTANCE.getProcessOutputFlow_Source();

		/**
		 * The meta object literal for the '<em><b>Process Output Flow Delay</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY = eINSTANCE.getProcessOutputFlow_ProcessOutputFlowDelay();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.ProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.ProcessImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__DURATION = eINSTANCE.getProcess_Duration();

		/**
		 * The meta object literal for the '<em><b>Storage Output Flow</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__STORAGE_OUTPUT_FLOW = eINSTANCE.getProcess_StorageOutputFlow();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.OrderOnStockThresholdImpl <em>Order On Stock Threshold</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.OrderOnStockThresholdImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getOrderOnStockThreshold()
		 * @generated
		 */
		EClass ORDER_ON_STOCK_THRESHOLD = eINSTANCE.getOrderOnStockThreshold();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER_ON_STOCK_THRESHOLD__PERIOD = eINSTANCE.getOrderOnStockThreshold_Period();

		/**
		 * The meta object literal for the '<em><b>Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER_ON_STOCK_THRESHOLD__THRESHOLD = eINSTANCE.getOrderOnStockThreshold_Threshold();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER_ON_STOCK_THRESHOLD__NAME = eINSTANCE.getOrderOnStockThreshold_Name();

		/**
		 * The meta object literal for the '<em><b>Order Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER_ON_STOCK_THRESHOLD__ORDER_QUANTITY = eINSTANCE.getOrderOnStockThreshold_OrderQuantity();

		/**
		 * The meta object literal for the '<em><b>Order Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER_ON_STOCK_THRESHOLD__ORDER_TYPE = eINSTANCE.getOrderOnStockThreshold_OrderType();

		/**
		 * The meta object literal for the '<em><b>Storage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDER_ON_STOCK_THRESHOLD__STORAGE = eINSTANCE.getOrderOnStockThreshold_Storage();

		/**
		 * The meta object literal for the '<em><b>Supplier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDER_ON_STOCK_THRESHOLD__SUPPLIER = eINSTANCE.getOrderOnStockThreshold_Supplier();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.ComponentImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__NAME = eINSTANCE.getComponent_Name();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.FlowImpl <em>Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.FlowImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getFlow()
		 * @generated
		 */
		EClass FLOW = eINSTANCE.getFlow();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__QUANTITY = eINSTANCE.getFlow_Quantity();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.ProbabilityImpl <em>Probability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.ProbabilityImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getProbability()
		 * @generated
		 */
		EClass PROBABILITY = eINSTANCE.getProbability();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.DistributionImpl <em>Distribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.DistributionImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getDistribution()
		 * @generated
		 */
		EClass DISTRIBUTION = eINSTANCE.getDistribution();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.CauchyImpl <em>Cauchy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.CauchyImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getCauchy()
		 * @generated
		 */
		EClass CAUCHY = eINSTANCE.getCauchy();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAUCHY__LOCATION = eINSTANCE.getCauchy_Location();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAUCHY__SCALE = eINSTANCE.getCauchy_Scale();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.BinomialImpl <em>Binomial</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.BinomialImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getBinomial()
		 * @generated
		 */
		EClass BINOMIAL = eINSTANCE.getBinomial();

		/**
		 * The meta object literal for the '<em><b>Nbr Of Trial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINOMIAL__NBR_OF_TRIAL = eINSTANCE.getBinomial_NbrOfTrial();

		/**
		 * The meta object literal for the '<em><b>Proba Of Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINOMIAL__PROBA_OF_SUCCESS = eINSTANCE.getBinomial_ProbaOfSuccess();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.BetaImpl <em>Beta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.BetaImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getBeta()
		 * @generated
		 */
		EClass BETA = eINSTANCE.getBeta();

		/**
		 * The meta object literal for the '<em><b>Freedom Degree A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BETA__FREEDOM_DEGREE_A = eINSTANCE.getBeta_FreedomDegreeA();

		/**
		 * The meta object literal for the '<em><b>Freedom Degree B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BETA__FREEDOM_DEGREE_B = eINSTANCE.getBeta_FreedomDegreeB();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.ScalarImpl <em>Scalar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.ScalarImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getScalar()
		 * @generated
		 */
		EClass SCALAR = eINSTANCE.getScalar();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR__VALUE = eINSTANCE.getScalar_Value();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.ChiSquareImpl <em>Chi Square</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.ChiSquareImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getChiSquare()
		 * @generated
		 */
		EClass CHI_SQUARE = eINSTANCE.getChiSquare();

		/**
		 * The meta object literal for the '<em><b>Degree Of Freedom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHI_SQUARE__DEGREE_OF_FREEDOM = eINSTANCE.getChiSquare_DegreeOfFreedom();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.ExponentialImpl <em>Exponential</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.ExponentialImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getExponential()
		 * @generated
		 */
		EClass EXPONENTIAL = eINSTANCE.getExponential();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPONENTIAL__SCALE = eINSTANCE.getExponential_Scale();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.FDistributionImpl <em>FDistribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.FDistributionImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getFDistribution()
		 * @generated
		 */
		EClass FDISTRIBUTION = eINSTANCE.getFDistribution();

		/**
		 * The meta object literal for the '<em><b>Freedom Degree A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FDISTRIBUTION__FREEDOM_DEGREE_A = eINSTANCE.getFDistribution_FreedomDegreeA();

		/**
		 * The meta object literal for the '<em><b>Freedom Degree B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FDISTRIBUTION__FREEDOM_DEGREE_B = eINSTANCE.getFDistribution_FreedomDegreeB();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.GammaImpl <em>Gamma</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.GammaImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getGamma()
		 * @generated
		 */
		EClass GAMMA = eINSTANCE.getGamma();

		/**
		 * The meta object literal for the '<em><b>Shape</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAMMA__SHAPE = eINSTANCE.getGamma_Shape();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.GeometricImpl <em>Geometric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.GeometricImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getGeometric()
		 * @generated
		 */
		EClass GEOMETRIC = eINSTANCE.getGeometric();

		/**
		 * The meta object literal for the '<em><b>Proba Of Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEOMETRIC__PROBA_OF_SUCCESS = eINSTANCE.getGeometric_ProbaOfSuccess();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.LogNormalImpl <em>Log Normal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.LogNormalImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getLogNormal()
		 * @generated
		 */
		EClass LOG_NORMAL = eINSTANCE.getLogNormal();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_NORMAL__LOCATION = eINSTANCE.getLogNormal_Location();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_NORMAL__SCALE = eINSTANCE.getLogNormal_Scale();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.GaussianImpl <em>Gaussian</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.GaussianImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getGaussian()
		 * @generated
		 */
		EClass GAUSSIAN = eINSTANCE.getGaussian();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAUSSIAN__LOCATION = eINSTANCE.getGaussian_Location();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAUSSIAN__SCALE = eINSTANCE.getGaussian_Scale();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.ParetoImpl <em>Pareto</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.ParetoImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPareto()
		 * @generated
		 */
		EClass PARETO = eINSTANCE.getPareto();

		/**
		 * The meta object literal for the '<em><b>Shape</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARETO__SHAPE = eINSTANCE.getPareto_Shape();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARETO__SCALE = eINSTANCE.getPareto_Scale();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.PoissonImpl <em>Poisson</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.PoissonImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPoisson()
		 * @generated
		 */
		EClass POISSON = eINSTANCE.getPoisson();

		/**
		 * The meta object literal for the '<em><b>Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POISSON__INTERVAL = eINSTANCE.getPoisson_Interval();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.StudentsTImpl <em>Students T</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.StudentsTImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getStudentsT()
		 * @generated
		 */
		EClass STUDENTS_T = eINSTANCE.getStudentsT();

		/**
		 * The meta object literal for the '<em><b>Degree Of Freedom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STUDENTS_T__DEGREE_OF_FREEDOM = eINSTANCE.getStudentsT_DegreeOfFreedom();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.UniformImpl <em>Uniform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.UniformImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getUniform()
		 * @generated
		 */
		EClass UNIFORM = eINSTANCE.getUniform();

		/**
		 * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIFORM__MINIMUM = eINSTANCE.getUniform_Minimum();

		/**
		 * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIFORM__MAXIMUM = eINSTANCE.getUniform_Maximum();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.impl.WeibullImpl <em>Weibull</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.impl.WeibullImpl
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getWeibull()
		 * @generated
		 */
		EClass WEIBULL = eINSTANCE.getWeibull();

		/**
		 * The meta object literal for the '<em><b>Shape</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEIBULL__SHAPE = eINSTANCE.getWeibull_Shape();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEIBULL__SCALE = eINSTANCE.getWeibull_Scale();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.OrderType <em>Order Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.OrderType
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getOrderType()
		 * @generated
		 */
		EEnum ORDER_TYPE = eINSTANCE.getOrderType();

		/**
		 * The meta object literal for the '{@link be.cetic.simqri.metamodel.OutputType <em>Output Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see be.cetic.simqri.metamodel.OutputType
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getOutputType()
		 * @generated
		 */
		EEnum OUTPUT_TYPE = eINSTANCE.getOutputType();

		/**
		 * The meta object literal for the '<em>Percent</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Double
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPercent()
		 * @generated
		 */
		EDataType PERCENT = eINSTANCE.getPercent();

		/**
		 * The meta object literal for the '<em>Positive Int</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Integer
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPositiveInt()
		 * @generated
		 */
		EDataType POSITIVE_INT = eINSTANCE.getPositiveInt();

		/**
		 * The meta object literal for the '<em>Positive Double</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Double
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPositiveDouble()
		 * @generated
		 */
		EDataType POSITIVE_DOUBLE = eINSTANCE.getPositiveDouble();

		/**
		 * The meta object literal for the '<em>Positive Int Not Null</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Integer
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPositiveIntNotNull()
		 * @generated
		 */
		EDataType POSITIVE_INT_NOT_NULL = eINSTANCE.getPositiveIntNotNull();

		/**
		 * The meta object literal for the '<em>Positive Double Not Null</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Double
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getPositiveDoubleNotNull()
		 * @generated
		 */
		EDataType POSITIVE_DOUBLE_NOT_NULL = eINSTANCE.getPositiveDoubleNotNull();

		/**
		 * The meta object literal for the '<em>Proba Double</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Double
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getProbaDouble()
		 * @generated
		 */
		EDataType PROBA_DOUBLE = eINSTANCE.getProbaDouble();

		/**
		 * The meta object literal for the '<em>Proba Double Not Null</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Double
		 * @see be.cetic.simqri.metamodel.impl.MetamodelPackageImpl#getProbaDoubleNotNull()
		 * @generated
		 */
		EDataType PROBA_DOUBLE_NOT_NULL = eINSTANCE.getProbaDoubleNotNull();

	}

} //MetamodelPackage

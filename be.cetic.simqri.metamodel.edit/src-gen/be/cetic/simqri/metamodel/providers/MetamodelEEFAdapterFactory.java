/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.providers;

import be.cetic.simqri.metamodel.util.MetamodelAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;

/**
 * 
 * 
 */
public class MetamodelEEFAdapterFactory extends MetamodelAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createModelAdapter()
	 * 
	 */
	public Adapter createModelAdapter() {
		return new ModelPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createQueryAdapter()
	 * 
	 */
	public Adapter createQueryAdapter() {
		return new QueryPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createStorageAdapter()
	 * 
	 */
	public Adapter createStorageAdapter() {
		return new StoragePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createSupplierAdapter()
	 * 
	 */
	public Adapter createSupplierAdapter() {
		return new SupplierPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createBatchProcessAdapter()
	 * 
	 */
	public Adapter createBatchProcessAdapter() {
		return new BatchProcessPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createOutputAdapter()
	 * 
	 */
	public Adapter createOutputAdapter() {
		return new OutputPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createStorageOutputFlowAdapter()
	 * 
	 */
	public Adapter createStorageOutputFlowAdapter() {
		return new StorageOutputFlowPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createProcessOutputFlowAdapter()
	 * 
	 */
	public Adapter createProcessOutputFlowAdapter() {
		return new ProcessOutputFlowPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createOrderOnStockThresholdAdapter()
	 * 
	 */
	public Adapter createOrderOnStockThresholdAdapter() {
		return new OrderOnStockThresholdPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createScalarAdapter()
	 * 
	 */
	public Adapter createScalarAdapter() {
		return new ScalarPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createGaussianAdapter()
	 * 
	 */
	public Adapter createGaussianAdapter() {
		return new GaussianPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createPoissonAdapter()
	 * 
	 */
	public Adapter createPoissonAdapter() {
		return new PoissonPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createUniformAdapter()
	 * 
	 */
	public Adapter createUniformAdapter() {
		return new UniformPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see be.cetic.simqri.metamodel.util.MetamodelAdapterFactory#createConveyorBeltAdapter()
	 * 
	 */
	public Adapter createConveyorBeltAdapter() {
		return new ConveyorBeltPropertiesEditionProvider();
	}

}

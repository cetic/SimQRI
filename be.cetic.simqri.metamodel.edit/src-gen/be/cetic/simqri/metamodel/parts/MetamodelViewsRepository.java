/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts;

/**
 * 
 * 
 */
public class MetamodelViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * Model view descriptor
	 * 
	 */
	public static class Model {
		public static class Properties {
	
			
			public static String name = "metamodel::Model::properties::name";
			
			
			public static String valid = "metamodel::Model::properties::valid";
			
			
			public static String query = "metamodel::Model::properties::query";
			
			
			public static String component = "metamodel::Model::properties::component";
			
			
			public static String flow = "metamodel::Model::properties::flow";
			
	
		}
	
	}

	/**
	 * Query view descriptor
	 * 
	 */
	public static class Query {
		public static class Properties {
	
			
			public static String name = "metamodel::Query::properties::name";
			
			
			public static String value = "metamodel::Query::properties::value";
			
	
		}
	
	}

	/**
	 * Storage view descriptor
	 * 
	 */
	public static class Storage {
		public static class Properties {
	
			
			public static String name = "metamodel::Storage::properties::name";
			
			
			public static String size = "metamodel::Storage::properties::size";
			
			
			public static String initialContent = "metamodel::Storage::properties::initialContent";
			
			
			public static String overflow = "metamodel::Storage::properties::overflow";
			
			
			public static String storageOutputFlow = "metamodel::Storage::properties::storageOutputFlow";
			
			
			public static String orderOnStockThreshold = "metamodel::Storage::properties::orderOnStockThreshold";
			
			
			public static String processOutputFlow = "metamodel::Storage::properties::processOutputFlow";
			
	
		}
	
	}

	/**
	 * Supplier view descriptor
	 * 
	 */
	public static class Supplier {
		public static class Properties {
	
			
			public static String name = "metamodel::Supplier::properties::name";
			
			
			public static String deliveredPercentage = "metamodel::Supplier::properties::deliveredPercentage";
			
			
			public static String refillPolicy = "metamodel::Supplier::properties::refillPolicy";
			
			
			public static String supplierDelay = "metamodel::Supplier::properties::supplierDelay";
			
	
		}
	
	}

	/**
	 * BatchProcess view descriptor
	 * 
	 */
	public static class BatchProcess {
		public static class Properties {
	
			
			public static String name = "metamodel::BatchProcess::properties::name";
			
			
			public static String duration = "metamodel::BatchProcess::properties::duration";
			
			
			public static String storageOutputFlow = "metamodel::BatchProcess::properties::storageOutputFlow";
			
			
			public static String percentageOfSuccess = "metamodel::BatchProcess::properties::percentageOfSuccess";
			
			
			public static String numberOfLines = "metamodel::BatchProcess::properties::numberOfLines";
			
			
			public static String outputs = "metamodel::BatchProcess::properties::outputs";
			
	
		}
	
	}

	/**
	 * Output view descriptor
	 * 
	 */
	public static class Output {
		public static class Properties {
	
			
			public static String type = "metamodel::Output::properties::type";
			
			
			public static String processOutputFlow = "metamodel::Output::properties::processOutputFlow";
			
			
			public static String description = "metamodel::Output::properties::description";
			
	
		}
	
	}

	/**
	 * StorageOutputFlow view descriptor
	 * 
	 */
	public static class StorageOutputFlow {
		public static class Properties {
	
			
			public static String source = "metamodel::StorageOutputFlow::properties::source";
			
			
			public static String destination = "metamodel::StorageOutputFlow::properties::destination";
			
			
			public static String quantity = "metamodel::StorageOutputFlow::properties::quantity";
			
	
		}
	
	}

	/**
	 * ProcessOutputFlow view descriptor
	 * 
	 */
	public static class ProcessOutputFlow {
		public static class Properties {
	
			
			public static String source = "metamodel::ProcessOutputFlow::properties::source";
			
			
			public static String destination = "metamodel::ProcessOutputFlow::properties::destination";
			
			
			public static String quantity = "metamodel::ProcessOutputFlow::properties::quantity";
			
			
			public static String processOutputFlowDelay = "metamodel::ProcessOutputFlow::properties::processOutputFlowDelay";
			
	
		}
	
	}

	/**
	 * OrderOnStockThreshold view descriptor
	 * 
	 */
	public static class OrderOnStockThreshold {
		public static class Properties {
	
			
			public static String period = "metamodel::OrderOnStockThreshold::properties::period";
			
			
			public static String threshold = "metamodel::OrderOnStockThreshold::properties::threshold";
			
			
			public static String name = "metamodel::OrderOnStockThreshold::properties::name";
			
			
			public static String orderQuantity = "metamodel::OrderOnStockThreshold::properties::orderQuantity";
			
			
			public static String orderType = "metamodel::OrderOnStockThreshold::properties::orderType";
			
			
			public static String supplier = "metamodel::OrderOnStockThreshold::properties::supplier";
			
			
			public static String storage = "metamodel::OrderOnStockThreshold::properties::storage";
			
	
		}
	
	}

	/**
	 * Cauchy view descriptor
	 * 
	 */
	public static class Cauchy {
		public static class Properties {
	
			
			public static String location = "metamodel::Cauchy::properties::location";
			
			
			public static String scale = "metamodel::Cauchy::properties::scale";
			
	
		}
	
	}

	/**
	 * Binomial view descriptor
	 * 
	 */
	public static class Binomial {
		public static class Properties {
	
			
			public static String nbrOfTrial = "metamodel::Binomial::properties::nbrOfTrial";
			
			
			public static String probaOfSuccess = "metamodel::Binomial::properties::probaOfSuccess";
			
	
		}
	
	}

	/**
	 * Beta view descriptor
	 * 
	 */
	public static class Beta {
		public static class Properties {
	
			
			public static String freedomDegreeA = "metamodel::Beta::properties::freedomDegreeA";
			
			
			public static String freedomDegreeB = "metamodel::Beta::properties::freedomDegreeB";
			
	
		}
	
	}

	/**
	 * Scalar view descriptor
	 * 
	 */
	public static class Scalar {
		public static class Properties {
	
			
			public static String value = "metamodel::Scalar::properties::value";
			
	
		}
	
	}

	/**
	 * ChiSquare view descriptor
	 * 
	 */
	public static class ChiSquare {
		public static class Properties {
	
			
			public static String degreeOfFreedom = "metamodel::ChiSquare::properties::degreeOfFreedom";
			
	
		}
	
	}

	/**
	 * DiracDelta view descriptor
	 * 
	 */
	public static class DiracDelta {
		public static class Properties {
	
			
			public static String mean = "metamodel::DiracDelta::properties::mean";
			
	
		}
	
	}

	/**
	 * Exponential view descriptor
	 * 
	 */
	public static class Exponential {
		public static class Properties {
	
			
			public static String scale = "metamodel::Exponential::properties::scale";
			
	
		}
	
	}

	/**
	 * FDistribution view descriptor
	 * 
	 */
	public static class FDistribution {
		public static class Properties {
	
			
			public static String freedomDegreeA = "metamodel::FDistribution::properties::freedomDegreeA";
			
			
			public static String freedomDegreeB = "metamodel::FDistribution::properties::freedomDegreeB";
			
	
		}
	
	}

	/**
	 * Gamma view descriptor
	 * 
	 */
	public static class Gamma {
		public static class Properties {
	
			
			public static String shape = "metamodel::Gamma::properties::shape";
			
	
		}
	
	}

	/**
	 * Geometric view descriptor
	 * 
	 */
	public static class Geometric {
		public static class Properties {
	
			
			public static String probaOfSuccess = "metamodel::Geometric::properties::probaOfSuccess";
			
	
		}
	
	}

	/**
	 * LogNormal view descriptor
	 * 
	 */
	public static class LogNormal {
		public static class Properties {
	
			
			public static String location = "metamodel::LogNormal::properties::location";
			
			
			public static String scale = "metamodel::LogNormal::properties::scale";
			
	
		}
	
	}

	/**
	 * Gaussian view descriptor
	 * 
	 */
	public static class Gaussian {
		public static class Properties {
	
			
			public static String location = "metamodel::Gaussian::properties::location";
			
			
			public static String scale = "metamodel::Gaussian::properties::scale";
			
	
		}
	
	}

	/**
	 * Pareto view descriptor
	 * 
	 */
	public static class Pareto {
		public static class Properties {
	
			
			public static String shape = "metamodel::Pareto::properties::shape";
			
			
			public static String scale = "metamodel::Pareto::properties::scale";
			
	
		}
	
	}

	/**
	 * Poisson view descriptor
	 * 
	 */
	public static class Poisson {
		public static class Properties {
	
			
			public static String interval = "metamodel::Poisson::properties::interval";
			
	
		}
	
	}

	/**
	 * StudentsT view descriptor
	 * 
	 */
	public static class StudentsT {
		public static class Properties {
	
			
			public static String degreeOfFreedom = "metamodel::StudentsT::properties::degreeOfFreedom";
			
	
		}
	
	}

	/**
	 * Uniform view descriptor
	 * 
	 */
	public static class Uniform {
		public static class Properties {
	
			
			public static String minimum = "metamodel::Uniform::properties::minimum";
			
			
			public static String maximum = "metamodel::Uniform::properties::maximum";
			
	
		}
	
	}

	/**
	 * Weibull view descriptor
	 * 
	 */
	public static class Weibull {
		public static class Properties {
	
			
			public static String shape = "metamodel::Weibull::properties::shape";
			
			
			public static String scale = "metamodel::Weibull::properties::scale";
			
	
		}
	
	}

	/**
	 * ConveyorBelt view descriptor
	 * 
	 */
	public static class ConveyorBelt {
		public static class Properties {
	
			
			public static String name = "metamodel::ConveyorBelt::properties::name";
			
			
			public static String duration = "metamodel::ConveyorBelt::properties::duration";
			
			
			public static String storageOutputFlow = "metamodel::ConveyorBelt::properties::storageOutputFlow";
			
			
			public static String minimalSeparationBetweenBatches = "metamodel::ConveyorBelt::properties::minimalSeparationBetweenBatches";
			
			
			public static String output = "metamodel::ConveyorBelt::properties::output";
			
	
		}
	
	}

}

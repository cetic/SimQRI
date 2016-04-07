package be.cetic.simqri.mapping;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import be.cetic.simqri.metamodel.Component;
import be.cetic.simqri.metamodel.OrderOnStockThreshold;
import be.cetic.simqri.metamodel.OrderType;
import be.cetic.simqri.metamodel.Supplier;
import oscar.des.flow.core.Fetchable;
import oscar.des.flow.core.Putable;
import oscar.des.flow.lib.ActivableProcess;
import oscar.des.flow.lib.FactoryModel;
import oscar.des.flow.lib.SingleBatchProcess;
import oscar.des.flow.lib.Storage;
import oscar.des.flow.modeling.FactorySimulationHelperClass;
import scala.Array;
import scala.Function0;
import scala.Tuple2;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.$colon$colon;

/**
 * @author FK
 * @version 1.0
 * @since 31/03/2016
 *
 * This class contains methods that convert entities from Metamodel EMF to an OscaR DES objects
 * Based on SimQRiModel.scala
 */
public class Mapping extends FactorySimulationHelperClass { 	
	// Java can't extends Scala traits => a class that extends the trait has been defined
	
	private static final int ITEM_CLASS = 0;
	private static FactoryModel factoryModel;
	private static Map<String, String> mapQueries = new HashMap<String, String>();
	private static Map<Integer, Storage> mapStorages = new HashMap<Integer, Storage>();
	private static Map<Integer, MapSupplier> mapPartSuppliers = new HashMap<Integer, MapSupplier>();
	private static java.util.List<ActivableProcess> activableProcesses = new ArrayList<ActivableProcess>();
	private static int countID;
	private static be.cetic.simqri.metamodel.Model model;

	public static FactoryModel doMapping(be.cetic.simqri.metamodel.Model newModel) {
		factoryModel = new FactoryModel(null, null, null, null, null, null);
		model = newModel;
		countID = 1;
		fillMaps(factoryModel);
		
		
		return factoryModel;
	}
	
	/**
	 * @author KF
	 * @param factoryModel the factory that handles OscaR DES model instances
	 * 
	 * This methods fills all maps with the OscaR DES components translated from metamodel EMF objects
	 */
	private static void fillMaps(FactoryModel factoryModel) {
		for(Component c : model.getComponent()) {
			if(c instanceof be.cetic.simqri.metamodel.Storage) {
				be.cetic.simqri.metamodel.Storage storage = (be.cetic.simqri.metamodel.Storage) c;
				putStorage(storage);
			}
			else if(c instanceof Supplier) {
				Supplier supplier = (Supplier) c;
				putSupplier(supplier);
			}
			
			countID++;
		}
		
	}
	
	/**
	 * @author KF
	 * @param storage A storage object from the metamodel EMF
	 * 
	 * This method puts a new Storage object from OscaR DES model based on a storage object 
	 * from Metamodel EMF into the map. The storage can be overflowed or not
	 */
	private static void putStorage(be.cetic.simqri.metamodel.Storage storage) {
		Tuple2<Object, Object> tuple = new Tuple2<Object, Object>(storage.getInitialContent(), ITEM_CLASS);
		List<Tuple2<Object, Object>> initialContentRdl = list(tuple);
		Storage newStorage = 
				factoryModel.fIFOStorage((int)storage.getSize(), initialContentRdl,  
						storage.getName(), storage.isOverflow(), "0");
		mapStorages.put(countID, newStorage);
	}
	
	/**
	 * @author KF
	 * @param supplier The supplier from the metamodel EMF
	 * 
	 * This method puts a new Supplier based on a supplier object from Metamodel EMF into the map.
	 */
	private static void putSupplier(Supplier supplier) {
		for(OrderOnStockThreshold oost : supplier.getRefillPolicy()) {
			int orderQty = 0;
			if(oost.getOrderType() == OrderType.FIXED)
				orderQty = oost.getOrderQuantity();
			else 
				orderQty = oost.getStorage().getSize() - oost.getStorage().getInitialContent();
			putStorage(oost.getStorage());
			Tuple2<Function0<Object>, Fetchable> inputs = new Tuple2<Function0<Object>, Fetchable>(null, null);
		}
		
		MapSupplier mapSupplier 
			= new MapSupplier(supplier.getName(), 
								ProbabilityHandler.getNonNegativeDoubleFunc(supplier.getSupplierDelay()),
								supplier.getDeliveredPercentage());
		mapPartSuppliers.put(countID,  mapSupplier);
	}
	
	
	/**
	 * @author A dude from stackoverflow.com
	 * @return a raw list compatible with scala usage
	 * 
	 * This method allows java to use scala list type
	 */
	@SafeVarargs
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> List<T> list(T ... ts) {
        List<T> result = List$.MODULE$.empty();
        for(int i = ts.length; i > 0; i--) {
            result = new $colon$colon(ts[i - 1], result);
        }
        return result;
    }
	
	
}

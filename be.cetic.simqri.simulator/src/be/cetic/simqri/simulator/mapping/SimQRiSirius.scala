package be.cetic.simqri.simulator.mapping

import oscar.des.flow.core.{AttributeDefinitions, DiscreteChoice, Putable, Fetchable}

import oscar.des.engine.SimControl

import oscar.des.flow.lib._
import oscar.des.flow.modeling._
import oscar.des.montecarlo.DataSampling
import oscar.des.logger._

import scala.util.control._
import scala.collection.{mutable, SortedSet}
import scala.collection.mutable
import scala.collection.JavaConversions._
import be.cetic.simqri.metamodel.OrderType
import be.cetic.simqri.metamodel.Output
import be.cetic.simqri.metamodel.OutputType
import be.cetic.simqri.metamodel.Component
import be.cetic.simqri.metamodel.Flow
import be.cetic.simqri.metamodel.StorageOutputFlow
import be.cetic.simqri.metamodel.ProcessOutputFlow

/**
 * SimQRi Project.

	 This module implements the mapping from the metamodel sent from the Eclipse front-end to the
   SimQRi model in OscaR-DES
 * @author FK & Gustavo Ospina
 */
class SimQRiSirius(duration : Float, verbose : Boolean, sqlogger: Logger[String], mcSim : Boolean) extends FactorySimulationHelper {
  
  val tools = new Tools
  // val m = new Model
  private val verboseFunc = if (verbose) sqlogger.loggerFunc else null
  var runTime = 0L
  var loading = 0 // NEW (MC loop status)
  var mcAborted = false
  
  // TODO Get Attribute Definitions
  val attrsDef = new AttributeDefinitions()
  val factoryModel = if (mcSim) new FactoryModel(null, attrsDef) else new FactoryModel(verboseFunc, attrsDef)
  
  var simQRiComponents : Array[SimQRiComponent] = new Array[SimQRiComponent](0)
  var nonMappedComponentNames : Array[String] = new Array[String](0)
  // val standardItemClass = zeroItemClass
  val attributes = attributeDefinitions("rawQuantity")
  val rawBatch = attributes.getN(0)
  val ph = new ProbabilityHandler()
  
  // Variables for MC Simulation
  var samplingMap : Map[String, Map[String,DataSampling]] = null
  var singleProbesSamplingMap : Map[String,DataSampling] = null
  var historyProbesMap : Map[String,List[(Double,List[Double])]] = null
  val samplingRuntime = new DataSampling
  
  // Auxiliary function to obtain the list of outputs
  // it will create Delay objects if the delay data is not zero
  def getStorageFlowOutputInfo(nameProcess : String, storInfo : mutable.HashMap[Int, Storage],
                               connInfo : List[(() => Int, Option[()=>Double], Int)]) : List[(() => Int, Putable)] = connInfo match {
    case Nil => Nil
    case (dur, delayOpt, storId)::ls =>
      val storeInf = storInfo.get(storId)
      storeInf match {
        case Some(stor) =>
          delayOpt match {
            case None => (dur, stor)::getStorageFlowOutputInfo(nameProcess, storInfo, ls)
            case Some(delay) =>
              // Old way (Delay object) I don't delete it, it could be restored in the future
              // val newDelay = new Delay(stor, m, delay)
              // (dur, newDelay)::getStorageFlowOutputInfo(storInfo, ls)
              
              // New way : create a Single Batch Process containing the delay, with an intermediate storage
              // (1) Create the intermediate storage
              //TODO change the FIFO by other thing, depending on the interface
              val intStorage = factoryModel.fIFOStorage(2*stor.maxCapacity, List((0, attributeSet(SortedSet(rawBatch), attributes).itemClass)),
                                                        s"$nameProcess -> ${stor.name} Delay Storage",
                                                        overflowOnInput = false)
              simQRiComponents +:= CStorage(intStorage)
              // (2) Create the single batch process corresponding to the delay
              val delayProcess = factoryModel.singleBatchProcess(delay,
                                                                   Array( (dur, intStorage) ),
                                                                   Array( (dur, stor) ),
                                                                   "",
                                                                   s"$nameProcess -> ${stor.name} Delay Process")
              simQRiComponents +:= CSingleBatchProcess(delayProcess)
                              (dur, intStorage)::getStorageFlowOutputInfo(nameProcess, storInfo, ls)
          }
        case None => getStorageFlowOutputInfo(nameProcess, storInfo, ls)
      }
  }
  
  /**
   * Main function for create the model (with OscaR-DES-Flow)
   * Returns a String which is empty if all queries are valid. It will contain the error message(s) otherwise
   */
  def fillModelWithSiriusData(model : be.cetic.simqri.metamodel.Model) : java.util.ArrayList[String] = {
    
    // Retrieve Processes (BP & CB), Storages & Suppliers from the 'sirius' model
    val components = model.getComponent.toList
    // Retrieve Flows (SOF & POF) from the 'sirius' model
    val flows = model.getFlow.toList
    
    // We proceed as follows : the first step is a loop on the components
    // for identifying the storages and the part suppliers of the model.
    // those elements will be put in a map so they can be accessed by these ids
    
    // Notice that the loops are implemented in a functional style, using foreach
    var mapStorages = new mutable.HashMap[Int, Storage]()
    var mapPartSuppliers = new mutable.HashMap[Int, (String, () => Double, Int)]()
    var activableProcesses = new mutable.MutableList[ActivableProcess]()
    
    var mapLinkInfos = new mutable.HashMap[Int, (mutable.MutableList[(() => Int, Int)], // ID_PROC => (<INPUTS, ID_STORAGE>, <OUTPUTS, ID_STORAGE>, <FAILS, ID_STORAGE>)
                                                 mutable.MutableList[(() => Int, Option[() => Double], Int)],
                                                 mutable.MutableList[(() => Int, Option[() => Double], Int)])]()
    // The handeling of a new kind of outputs will require a new mutable list in the tuple above
                                                 
    for(c <- components) {
      if(c.isInstanceOf[be.cetic.simqri.metamodel.Storage]) {
        val storage = c.asInstanceOf[be.cetic.simqri.metamodel.Storage]
        val newStorage = factoryModel.fIFOStorage(storage.getSize, 
                                                  List((storage.getInitialContent.asInstanceOf[Int], attributeSet(SortedSet(rawBatch), attributes).itemClass)), 
                                                  storage.getName, 
                                                  storage.isOverflow(),
                                                  "0")
                                                  
        // check if the storage is linked to another element
        if(!storage.getProcessOutputFlow.isEmpty() || !storage.getStorageOutputFlow.isEmpty() || !storage.getOrderOnStockThreshold.isEmpty()) {
          mapStorages += (components.indexOf(c) -> newStorage)
          simQRiComponents +:= CStorage(newStorage)
        }
        else {
          nonMappedComponentNames +:= storage.getName;
        }
        // mapStorages += (components.indexOf(c) -> newStorage)
        // simQRiComponents +:= CStorage(newStorage)
      }
      else if(c.isInstanceOf[be.cetic.simqri.metamodel.Supplier]) {
        val supplier = c.asInstanceOf[be.cetic.simqri.metamodel.Supplier]
        val triplet = (supplier.getName,
                       ph.getNonNegativeDoubleFunc(supplier.getSupplierDelay), 
                       supplier.getDeliveredPercentage.intValue())
        // check if the supplier is linked to another element
        if(!supplier.getRefillPolicy.isEmpty())
          mapPartSuppliers += (components.indexOf(c) -> triplet)
        else {
          nonMappedComponentNames +:= supplier.getName;
        }
        // mapPartSuppliers += (components.indexOf(c) -> triplet)
      }
      // NEW : we fill a map which will contain informations about processes inputs and
      // all kinds of outputs that will be used to create process objects in the oscar-des simulator
      else if(c.isInstanceOf[be.cetic.simqri.metamodel.Process]) {
        val process = c.asInstanceOf[be.cetic.simqri.metamodel.Process]
        val idProc = components.indexOf(c)
        var inputs = mutable.MutableList[(() => Int, Int)]()
        var outputs = mutable.MutableList[(() => Int, Option[() => Double], Int)]()
        var fails = mutable.MutableList[(() => Int, Option[() => Double], Int)]()
        for(flow <- flows) {
          if(flow.isInstanceOf[StorageOutputFlow]) {
            val sof = flow.asInstanceOf[StorageOutputFlow]
            if(sof.getDestination.equals(process))
              inputs.+=((ph.getNonNegativeIntFunc(sof.getQuantity), tools.getIdStorage(components, sof.getSource)))
          }
          else if(flow.isInstanceOf[ProcessOutputFlow]) {
            val pof = flow.asInstanceOf[ProcessOutputFlow]
            val listOfOutputPorts = tools.getOutputPorts(process)
            var pofLinkedToProcess = false
            for(port <- listOfOutputPorts) {
              if(port.equals(pof.getSource))
                  pofLinkedToProcess = true
            }
            if(pofLinkedToProcess) {
              val delay = ph.getNonNegativeDoubleFunc(pof.getProcessOutputFlowDelay)
              val out = (ph.getNonNegativeIntFunc(pof.getQuantity), 
                         if(delay().doubleValue() == 0F) None else Some(delay), 
                         tools.getIdStorage(components, pof.getDestination))
              val outputPort = pof.getSource
              outputPort.getType match {
                case OutputType.SUCCESS => outputs.+=(out)
                case OutputType.FAILURE => fails.+=(out)
                case OutputType.TRASH => fails.+=(out)
                case _ => outputs.+=(out)
                // TODO : Other output types behaviours 
              }
            }
          }
        }
        mapLinkInfos.+=(idProc -> (inputs, outputs, fails))
      }
    }
    
    // The second loop is done on the OrderOnStockThreshold links and will allow to create 
    // some objects of the model which have linking information associated to them
    
    val oosts = model.getOrderOnStockThreshold.toList;
    
    for (oost <- oosts) {
      var storageDest = oost.getStorage
      // Declaration of the oscar-des storage (will definitely be updated in the following loop)
      var optionStorage = mapStorages.get(0) 
      // Retrieve the storage from oscar-des correspinding to the storage dest of the oost from metamodel
      for(c <- components) {
        if(c.isInstanceOf[be.cetic.simqri.metamodel.Storage] && c.equals(storageDest)) {
          optionStorage = mapStorages.get(components.indexOf(c))
        }
      }
      // Transform the Option[Storage] to Storage (need for the upcoming singleBatchProcess creation)
      var oStorage = optionStorage.get
      
      var supplierSrc = oost.getSupplier;
      // Declaration of the mapped supplier (will definitely be updated in the following loop)
      var partSuppInfo = mapPartSuppliers.get(0) 
      // Retrieve the right mapped supplier from oscar-des correspinding to the supplier src of the oost from metamodel
      for(c <- components) {
        if(c.isInstanceOf[be.cetic.simqri.metamodel.Supplier] && c.equals(supplierSrc)) {
          partSuppInfo = mapPartSuppliers.get(components.indexOf(c))
        }
      }
      
      
      val orderQtyFunc = if(oost.getOrderType == OrderType.FIXED) 
                            (x:Int) => oost.getOrderQuantity.toInt
                         else
                            (x:Int) => oStorage.maxCapacity - oStorage.contentSize
      val activateFunc = (x : Int) => 1
      // We create now the single batch process corresponding to the part supplier
      val partSupp = factoryModel.singleBatchProcess(partSuppInfo.get._2,
                                                     Array(), 
                                                     Array(( () => partSuppInfo.get._3*orderQtyFunc(oost.getThreshold())/100, oStorage)), 
                                                     "", 
                                                     partSuppInfo.get._1,
                                                     "0")
      val period = oost.getPeriod.toFloat                                               
      val newOost = factoryModel.onLowerThreshold(oStorage, partSupp, oost.getThreshold, activateFunc, period, oost.getName)
      activableProcesses +:= partSupp
      simQRiComponents +:= CPartSupplier(partSupp)
      simQRiComponents +:= COrderOnStockThreshold(newOost)
    }
    
    // The third loop is done on the elements to create and add all the process elements in the model.
    for(c <- components) {
      if(c.isInstanceOf[be.cetic.simqri.metamodel.BatchProcess]) {
        val batchProcess = c.asInstanceOf[be.cetic.simqri.metamodel.BatchProcess]
        val numLines = batchProcess.getNumberOfChains
        val perSuc = batchProcess.getPercentageOfSuccess/100
        val duration = ph.getNonNegativeDoubleFunc(batchProcess.getDuration)
        val linkInfos = mapLinkInfos.get(components.indexOf(c))
        val storageFlowInfo = tools.getStorageFlowInfo(mapStorages, linkInfos.get._1.toList).toArray

        val storageFlowOutputInfo = getStorageFlowOutputInfo(batchProcess.getName, mapStorages, linkInfos.get._2.toList).toArray

        val getStorageFlowOutputFailsInfo = getStorageFlowOutputInfo(batchProcess.getName, mapStorages, linkInfos.get._3.toList).toArray

        if(numLines==1 && perSuc==100) {
          val newSBP = factoryModel.singleBatchProcess(duration, 
                                                       storageFlowInfo, 
                                                       storageFlowOutputInfo, 
                                                       "", 
                                                       batchProcess.getName, 
                                                       "0")
          // check if the sbp is linked to another element
          var noLinked = true
          if(!batchProcess.getOutputs.isEmpty()) {
            val loop = new Breaks
            loop.breakable {
              for(o <- batchProcess.getOutputs) {
                if(!o.getProcessOutputFlow.isEmpty() && !batchProcess.getStorageOutputFlow.isEmpty()) {
                  activableProcesses +:= newSBP
                  simQRiComponents +:= CSingleBatchProcess(newSBP)
                  noLinked = false
                  loop.break()
                }
              }
            }
          }
          if(noLinked) {
            nonMappedComponentNames +:= batchProcess.getName;
          }
          // activableProcesses +:= newSBP
          // simQRiComponents +:= CSingleBatchProcess(newSBP)
        }
        else if(numLines!=1 && perSuc==100) {
          val newBP = factoryModel.batchProcess(batchProcess.getNumberOfChains,
                                                duration, 
                                                storageFlowInfo, 
                                                storageFlowOutputInfo, 
                                                batchProcess.getName,
                                                "",
                                                "0")
          // check if the bp is linked to another element
          var noLinked = true
          if(!batchProcess.getOutputs.isEmpty()) {
            val loop = new Breaks
            loop.breakable {
              for(o <- batchProcess.getOutputs) {
                if(!o.getProcessOutputFlow.isEmpty() && !batchProcess.getStorageOutputFlow.isEmpty()) {
                  activableProcesses +:= newBP
                  simQRiComponents +:= CBatchProcess(newBP)
                  noLinked = false
                  loop.break()
                }
              }
            }
          }
          if(noLinked) {
            nonMappedComponentNames +:= batchProcess.getName;
          }
          // activableProcesses +:= newBP
          // simQRiComponents +:= CBatchProcess(newBP)
        }
        else if(numLines==1 && perSuc!=100) {
          val choiceStr = s" outputPort 0 weight $perSuc \n outputPort 1 weight ${1F-perSuc}"
          // val portChoices = List((0, perSuc.toDouble), (1, 1D-perSuc)) // former way to select the right port
          val newFSBP = factoryModel.splittingSingleBatchProcess(duration, 
                                                                 storageFlowInfo, 
                                                                 Array(storageFlowOutputInfo, getStorageFlowOutputFailsInfo),
                                                                 choiceStr, 
                                                                 batchProcess.getName,
                                                                 "0")
          // check if the fsbp is linked to another element
          var noLinked = true
          if(!batchProcess.getOutputs.isEmpty()) {
            val loop = new Breaks
            loop.breakable {
              for(o <- batchProcess.getOutputs) {
                if(!o.getProcessOutputFlow.isEmpty() && !batchProcess.getStorageOutputFlow.isEmpty()) {
                  activableProcesses +:= newFSBP
                  simQRiComponents +:= CFailingSingleBatchProcess(newFSBP)
                  noLinked = false
                  loop.break()
                }
              }
            }
          }
          if(noLinked) {
            nonMappedComponentNames +:= batchProcess.getName;
          }
          // activableProcesses +:= newFSBP
          // simQRiComponents +:= CFailingSingleBatchProcess(newFSBP)
        }
        else if(numLines!=1 && perSuc!=100) {
          val choiceStr = s" outputPort 0 weight $perSuc \n outputPort 1 weight ${1F-perSuc}"
          // val portChoices = List((0, perSuc.toDouble), (1, 1D-perSuc)) // former way to select the right port
          val newFBP = factoryModel.splittingBatchProcess(numLines, 
                                                          duration,
                                                          storageFlowInfo, 
                                                          Array(storageFlowOutputInfo, getStorageFlowOutputFailsInfo),
                                                          batchProcess.getName,
                                                          choiceStr, 
                                                          "0")
          // check if the fbp is linked to another element
          var noLinked = true
          if(!batchProcess.getOutputs.isEmpty()) {
            val loop = new Breaks
            loop.breakable {
              for(o <- batchProcess.getOutputs) {
                if(!o.getProcessOutputFlow.isEmpty() && !batchProcess.getStorageOutputFlow.isEmpty()) {
                  activableProcesses +:= newFBP
                  simQRiComponents +:= CFailingBatchProcess(newFBP)
                  noLinked = false
                  loop.break()
                }
              }
            }
          }
          if(noLinked) {
            nonMappedComponentNames +:= batchProcess.getName;
          }
          // activableProcesses +:= newFBP
          // simQRiComponents +:= CFailingBatchProcess(newFBP)
        }
      }
      else if(c.isInstanceOf[be.cetic.simqri.metamodel.ConveyorBelt]) {
        val conveyorBelt = c.asInstanceOf[be.cetic.simqri.metamodel.ConveyorBelt]
        val duration = ph.getNonNegativeDoubleFunc(conveyorBelt.getDuration)
        val linkInfos = mapLinkInfos.get(components.indexOf(c))
        val storageFlowInfo = tools.getStorageFlowInfo(mapStorages, linkInfos.get._1.toList).toArray
        val storageFlowOutputInfo = getStorageFlowOutputInfo(conveyorBelt.getName, mapStorages, linkInfos.get._2.toList).toArray
        val newCBP = factoryModel.conveyorBeltProcess(duration, 
                                                      conveyorBelt.getMinimalSeparationBetweenBatches, 
                                                      storageFlowInfo, 
                                                      storageFlowOutputInfo, 
                                                      "", 
                                                      conveyorBelt.getName, 
                                                      "0")
        // check if the cbp is linked to another element
        var noLinked = true
        if(conveyorBelt.getOutput != null) {
          if(!conveyorBelt.getOutput().getProcessOutputFlow.isEmpty() && !conveyorBelt.getStorageOutputFlow.isEmpty()) {
            activableProcesses +:= newCBP
            noLinked = false
            simQRiComponents +:= CConveyorBeltProcess(newCBP)
          }
        }
        if(noLinked) {
          nonMappedComponentNames +:= conveyorBelt.getName;
        }
        // activableProcesses +:= newCBP
        // simQRiComponents +:= CConveyorBeltProcess(newCBP)
      }
    }
    
    // The final loop is on the probes. We will parse and add them to the probes list
    var probesList : List[(String,Expression)] = Nil
    val probeParser = ListenerParser.apply(mapStorages.values, activableProcesses, attrsDef)
    var message : java.util.ArrayList[String] = new java.util.ArrayList // check if all queries are valid
    // The model is now complete! We can now simulate it.
    for(query <- model.getQuery) {
        var parsing = true
        val loop = new Breaks()
        // check if the query doesn't refer to a non mapped element
        loop.breakable {
          for(name <- nonMappedComponentNames) {
            if(query.getValue.contains(name)) {
              parsing = false
              loop.break()
            }
          }
        }
        if(parsing) {
          probeParser.apply(query.getValue) match { // probesList :+= (s"${query.getName} $query.getType", boolExpr) add a type to probes ?
            case BooleanExpressionResult(boolExpr) =>
              probesList :+= (s"${query.getName}", boolExpr)
            case DoubleExpressionResult(dblExpr) =>
              probesList :+= (s"${query.getName}", dblExpr)
            case BoolHistoryExpressionResult(boolHistExpr) =>
              probesList :+= (s"${query.getName}", boolHistExpr)
            case DoubleHistoryExpressionResult(dblHistExpr) =>
              probesList :+= (s"${query.getName}", dblHistExpr)
            case ParsingError(errStr) =>
              if(verbose)
                message.add("The probe "+query.getName+" cannot be parsed. This is the error : \n"+errStr)
            case _ =>
          }
        }
    }
    factoryModel.setQueries(probesList)
    
    // This epilogue loop is just here to check the good working of this service...
    /*println("-----------------------------------------------------------------------")
    println("PROCESSES")
    println(activableProcesses)
    println("-----------------------------------------------------------------------")
    println("STORAGES")
    println(mapStorages)
    println("-----------------------------------------------------------------------")
    println("QUERIES")
    for(c <- factoryModel.queries)
      println(c._1.toString()+' '+c._2.toString())
    println("-----------------------------------------------------------------------") 
    */
    return message
  }
  
  // Main function for creating the model (with OscaR-DES-Flow) and simulating it.
  def simulateOneShot(simControl:SimControl): Unit = {
    val time0 = System.nanoTime()
    factoryModel.simulate(duration, simControl)
    val time1 = System.nanoTime()
    runTime = time1 - time0
    sqlogger.log("probe", "Elapsed time in nanoseconds", runTime.toString)
    factoryModel.logMetrics()
    simQRiComponents.foreach((comp) => {
      comp.mapInfo.foreach((tuple) => {
        val attr = tuple._1
        val value = tuple._2.toString
        sqlogger.log("mapinfo", comp.getName, comp.getType, attr, value)
      })
    })    
  }
  
    // Main function for MC simulation
  def simulateMonteCarlo(numIterations : Int, simControl:SimControl): Unit = {
    var i = 0
    var currentFM = factoryModel
    while (i < numIterations && !mcAborted) {
      val time0 = System.nanoTime()
      currentFM.simulate(duration, simControl)
      val time1 = System.nanoTime()
      runTime = time1 - time0
      val mapsTup = if (singleProbesSamplingMap == null)
                      SimQRiModel.createProbesMaps(currentFM)
                    else
                      SimQRiModel.addProbeValuesToMaps(currentFM, singleProbesSamplingMap, historyProbesMap)
      singleProbesSamplingMap = mapsTup._1
      historyProbesMap = mapsTup._2
      samplingRuntime <-- runTime.toDouble
      if (i == 0) {
        samplingMap = SimQRiModel.createSamplingMap(SimQRiModel.getMapInfos(currentFM))
      }
      else {
        samplingMap = SimQRiModel.addToSamplingMap(samplingMap, SimQRiModel.getMapInfos(currentFM))
      }
      currentFM = factoryModel.cloneReset
      i += 1
      loading += 1;
    }
    // Log elements infos
    if (samplingMap != null) {
      samplingMap.foreach((samplings) => {
        val elem_name = samplings._1
        val attrs_map = samplings._2
        attrs_map.foreach((attr_map) => {
          val attr_name = attr_map._1
          val attr_sampling = attr_map._2
          sqlogger.log("mc_sampling_element", elem_name, attr_name, attr_sampling.toJSONString)
        })
      })
    }
    // Log runtime info
    if (samplingRuntime != null) {
      sqlogger.log("mc_sampling_runtime", samplingRuntime.toJSONString)
    }
    // Log single probes info
    if (singleProbesSamplingMap != null) {
      singleProbesSamplingMap.foreach((probe_map) => {
        val probe_name = probe_map._1
        val probe_sampling = probe_map._2
        sqlogger.log("mc_sampling_probe", probe_name, probe_sampling.toJSONString)
      })
    }
    // Log history probes info
    if (historyProbesMap != null) {
      historyProbesMap.foreach((history_map) => {
        val probe_name = history_map._1
        val probe_history = history_map._2
        sqlogger.log("mc_history_probe", probe_name, SimQRiModel.historyListToJSONString(probe_history))
      })
    }
  }
}
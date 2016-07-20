package be.cetic.simqri.simulator.mapping

import oscar.des.engine.Model

import oscar.des.flow.core.{DiscreteChoice, Putable, Fetchable}
import oscar.des.flow.lib._
import oscar.des.flow.modeling._
import oscar.des.logger._

import scala.collection.{mutable, SortedSet}
import scala.collection.mutable
import scala.collection.JavaConversions._

import be.cetic.simqri.metamodel.Output
import be.cetic.simqri.metamodel.Component

/**
 * @author FK & Gustavo Ospina
 * 
 * This class contains all the auxiliary functions used in SimQRiSirius.scala
 */
class Tools extends FactorySimulationHelper {
  
    val m = new Model
  
    // Auxiliary function to obtain the list of inputs or failures
    def getStorageFlowInfo(storInfo : mutable.HashMap[Int, Storage],
                           connInfo : List[(() => Int, Int)]) : List[(() => Int, Fetchable)] = connInfo match {
      case Nil => Nil
      case (dur, storId)::ls =>
        val storeInf = storInfo.get(storId)
        storeInf match {
          case Some(stor) => (dur, stor)::getStorageFlowInfo(storInfo, ls)
          case None => getStorageFlowInfo(storInfo, ls)
        }
    }
    
    // NEW : Auxiliary function to obtain the place of a Storage object in a list of components from the 'sirius' model
    def getIdStorage(components : List[Component], storage : be.cetic.simqri.metamodel.Storage) : Int = {
      var index = -1
      for(c <- components) {
        if(c.isInstanceOf[be.cetic.simqri.metamodel.Storage]) {
          val s = c.asInstanceOf[be.cetic.simqri.metamodel.Storage]
          if(s.equals(storage)) {
            index = components.indexOf(c)
          }
        }
      }
      index
    }
    
    // NEW : Auxiliary function to obtain the output port(s) of a process
    def getOutputPorts(process : be.cetic.simqri.metamodel.Process) : List[Output] = {
      if(process.isInstanceOf[be.cetic.simqri.metamodel.BatchProcess]) {
        val batchProcess = process.asInstanceOf[be.cetic.simqri.metamodel.BatchProcess]
        val ports = batchProcess.getOutputs.toList
        ports
      }
      else if (process.isInstanceOf[be.cetic.simqri.metamodel.ConveyorBelt]) {
        val conveyorBelt = process.asInstanceOf[be.cetic.simqri.metamodel.ConveyorBelt]
        val port = List(conveyorBelt.getOutput)
        port
      }
      else {
        List()
      }
    }
   
    // NEW : Auxiliary functions to obtain a java map from scala maps of simulation results (ONE SHOT)
    def eventsToJavaMap(sqlogger : TraceLogger) : java.util.Map[Double, List[(String, String)]] = {
      var events = sqlogger.logs.events
      var javaEvents = mapAsJavaMap(events)
      javaEvents
    }
    def mapInfosToJavaMap(sqlogger : TraceLogger) : java.util.Map[String, (String, List[(String, Double)])] = {
      var mapInfos = sqlogger.logs.mapInfos
      var javaMapInfos = mapAsJavaMap(mapInfos)
      mapInfos
    }
    
    // NEW : Auxiliary functions to obtain a java map from scala maps of simulation results (MONTE_CARLO)
    def elementsSamplingsToJavaMap(sqlogger : TraceLogger) : java.util.Map[String, List[SamplingTuple]] = {
      var elementsSamplings = sqlogger.logs.mcSamplings.elementsSamplings
      var esMap = mapAsJavaMap(elementsSamplings)
      esMap
    }
}
package be.cetic.simqri.simulator.mapping

import oscar.des.engine.Model

import oscar.des.flow.core.{DiscreteChoice, Putable, Fetchable}
import oscar.des.flow.lib._
import oscar.des.flow.modeling._

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
class Tools {
  
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
    
    // Auxiliary function to obtain the list of outputs
    // it will create Delay objects if the delay data is not zero
    def getStorageFlowOutputInfo(storInfo : mutable.HashMap[Int, Storage],
                                 connInfo : List[(() => Int, Option[()=>Double], Int)]) : List[(() => Int, Putable)] = connInfo match {
      case Nil => Nil
      case (dur, delayOpt, storId)::ls =>
        val storeInf = storInfo.get(storId)
        storeInf match {
          case Some(stor) =>
            delayOpt match {
              case None => (dur, stor)::getStorageFlowOutputInfo(storInfo, ls)
              case Some(delay) =>
                val newDelay = new Delay(stor, m, delay)
                (dur, newDelay)::getStorageFlowOutputInfo(storInfo, ls)
            }
          case None => getStorageFlowOutputInfo(storInfo, ls)
        }
    }
    
    // NEW : Auxiliary function to obtain the place of a Storage object in a list of components from the 'sirius' model
    def getIdStorage(components : List[Component], storage : be.cetic.simqri.metamodel.Storage) : Int = {
      var index = -1
      for(c <- components) {
        if(c.isInstanceOf[be.cetic.simqri.metamodel.Storage]) {
          val s = c.asInstanceOf[be.cetic.simqri.metamodel.Storage]
          if(s.equals(storage)) {
            println("egalité des storages ok")
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
}
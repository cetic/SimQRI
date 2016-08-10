package be.cetic.simqri.simulator.mapping

import oscar.des.flow.lib._

import oscar.des.flow.modeling._
import oscar.des.montecarlo.DataSampling

/**
 * @author Gustavo Ospina
 * 
 * This object is used to make Monte-Carlo simulation in SimQRISirius.scala.
 * The SimQRi web project has typically the same object.
 * 
 */
object SimQRiModel {
  private def addListDoubleToList(dblLs : List[(Double,Double)],
                                  dlsLs : List[(Double,List[Double])]) : List[(Double,List[Double])] = {
    def addTupleToList(tup : (Double,Double),
                       lsDls : List[(Double,List[Double])]) : List[(Double,List[Double])] = lsDls match {
      case Nil => List((tup._1,List(tup._2)))
      case dt::dts =>
        if (tup._1 == dt._1)
          (tup._1, tup._2::dt._2)::dts
        else
          dt::addTupleToList(tup, dts)
    }
    ///// definition of addListDoubleToList/2 /////
    dblLs.foldLeft(dlsLs)((lsDls, tup) => addTupleToList(tup, lsDls))
  }

  def getMapInfos(fm : FactoryModel) : Map[String, Map[String, Double]] = {
    val initialMap : Map[String, Map[String,Double]] = Map()
    val mapWithSt = fm.getStorages.foldLeft(initialMap)((mapInfos, storage) => mapInfos + (storage.name -> storage.mapInfo))
    val endMap = fm.getProcesses.foldLeft(mapWithSt)((mapInfos, proc) => mapInfos + (proc.name -> proc.mapInfo))
    endMap
  }

  def createProbesMaps(fm : FactoryModel) : (Map[String, DataSampling],Map[String,List[(Double,List[Double])]]) = {
    var singleProbesMap : Map[String, DataSampling] = Map()
    var historyProbesMap : Map[String,List[(Double,List[Double])]] = Map()
    if (fm.getMetrics != null) {
      for {(name, expr) <- fm.getMetrics.rootExpressions} {
        expr match {
          case be:BoolExpr =>
            singleProbesMap += (name -> new DataSampling)
          case de:DoubleExpr =>
            singleProbesMap += (name -> new DataSampling)
          case bhe:BoolHistoryExpr =>
            historyProbesMap += (name -> Nil)
          case dhe:DoubleHistoryExpr =>
            historyProbesMap += (name -> Nil)
          case _ =>
        }
      }
    }
    (singleProbesMap, historyProbesMap)
  }

  def addProbeValuesToMaps(fm : FactoryModel,
                           singleProbesMap : Map[String, DataSampling],
                           historyProbesMap : Map[String,List[(Double,List[Double])]]) : (Map[String, DataSampling],
                                                                                          Map[String,List[(Double,List[Double])]]) = {
    var newHistoryProbesMap : Map[String,List[(Double,List[Double])]] = Map()
    if (fm.getMetrics != null) {
      for {(name, expr) <- fm.getMetrics.rootExpressions} {
        expr match {
          case be:BoolExpr =>
            singleProbesMap(name) <-- (if (be.value) 1 else 0)
          case de:DoubleExpr =>
            singleProbesMap(name) <-- de.value
          case bhe:BoolHistoryExpr =>
            newHistoryProbesMap += (name -> addListDoubleToList(bhe.getHistory.map(tup => (tup._1, if (tup._2) 1D else 0D)),
                                                                historyProbesMap(name)))
          case dhe:DoubleHistoryExpr =>
            newHistoryProbesMap += (name -> addListDoubleToList(dhe.getHistory, historyProbesMap(name)))
          case _ =>
        }
      }
    }
    (singleProbesMap, newHistoryProbesMap)
  }

  def createSamplingMap(mapInfo : Map[String, Map[String, Double]]) : Map[String, Map[String,DataSampling]] = {
    val emptyMap : Map[String, Map[String,DataSampling]] = Map()
    mapInfo.keys.foldLeft(emptyMap)((compMap, compName) => {
      val mapValue = mapInfo(compName)
      val emptyMapDS : Map[String,DataSampling] = Map()
      compMap + (compName -> mapValue.keys.foldLeft(emptyMapDS)((sampleMap, sampleValue) => {
        val newSample = new DataSampling
        sampleMap + (sampleValue -> newSample)
      }))
    })
  }

  def addToSamplingMap(samplingMap : Map[String, Map[String,DataSampling]],
                       mapInfo : Map[String, Map[String, Double]]) : Map[String, Map[String,DataSampling]] = {
    samplingMap.keySet.foreach(compName => {
      val sampleVals = samplingMap(compName)
      sampleVals.keySet.foreach(sampleName => {
        sampleVals(sampleName) <-- mapInfo(compName)(sampleName)
      })
    })
    samplingMap
  }

  def historyListToJSONString(ls : List[(Double,List[Double])]) = {
    def historyTupleToJSONString(time : Double, vals : List[Double]) =
      "{\"time\":" + time + ",\"values\":[" + vals.foldLeft("")((str, vl) => {str + (if (str == "") s"$vl" else s",$vl")}) + "]}"
    ///// Definition of historyListToJSONString /////
    s"[${ls.foldLeft("")((str, tup) => {str + (if (str == "") "" else ",") + historyTupleToJSONString(tup._1, tup._2)})}]"
  }
}
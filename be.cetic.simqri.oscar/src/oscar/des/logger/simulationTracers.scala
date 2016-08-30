/*******************************************************************************
  * OscaR is free software: you can redistribute it and/or modify
  * it under the terms of the GNU Lesser General Public License as published by
  * the Free Software Foundation, either version 2.1 of the License, or
  * (at your option) any later version.
  *
  * OscaR is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU Lesser General Public License  for more details.
  *
  * You should have received a copy of the GNU Lesser General Public License along with OscaR.
  * If not, see http://www.gnu.org/licenses/lgpl-3.0.en.html
  ******************************************************************************/

package oscar.des.logger

import scala.collection.mutable

/**
  * Represents a tuple attribute - sampling JSON
  * @param name the name of the attribute
  * @param samplingStr the JSON string of the sampling
  */
case class SamplingTuple(name : String, samplingStr : String) {
  def toJSONString = "{\"name\":\"" + name + "\",\"dataSampling\":" + samplingStr + "}"
}

case class HistorySampling(name : String, historyStr : String) {
  def toJSONString = "{\"name\":\"" + name + "\",\"history\":" + historyStr + "}"
}

/**
  * Class containing the components of a Monte Carlo Simulation
  */
class MonteCarloSampling {
  var active = false
  var elementsSamplings : mutable.Map[String, List[SamplingTuple]] = new mutable.HashMap[String, List[SamplingTuple]]()
  var runtimeSampling : SamplingTuple = null
  var probesSampling : List[SamplingTuple] = Nil
  var historySampling : List[HistorySampling] = Nil

  def toJSONString = {
    if (active) {
      var elemsSampsStr = "["
      var comma = false
      elementsSamplings.foreach((elemSampTuple) => {
        val attrName = elemSampTuple._1
        val attrSampls = elemSampTuple._2
        if (comma) {
          elemsSampsStr += ", "
        }
        else {
          comma = true
        }
        // attributeList
        var attrSamplsStr = "["
        var comma2 = false
        for {attrSamp <- attrSampls} {
          if (comma2) {
            attrSamplsStr += ", "
          }
          else {
            comma2 = true
          }
          attrSamplsStr += attrSamp.toJSONString
        }
        attrSamplsStr += "]"
        elemsSampsStr += "{\"name\":\"" + attrName + "\", \"attributes\":" + attrSamplsStr + "}"
      })
      elemsSampsStr += "]"
      var probesSampsStr = "["
      comma = false
      for {probeSamp <- probesSampling} {
        if (comma) {
          probesSampsStr += ", "
        }
        else {
          comma = true
        }
        probesSampsStr += probeSamp.toJSONString
      }
      probesSampsStr += "]"
      var historyStr = "["
      comma = false
      for {historyProbe <- historySampling} {
        if (comma) {
          historyStr += ", "
        }
        else {
          comma = true
        }
        historyStr += historyProbe.toJSONString
      }
      historyStr += "]"
      ", \"mcSamplings\":{\"elements\":" + elemsSampsStr + ", \"runtime\":" + runtimeSampling.toJSONString +
      ", \"probes\":" + probesSampsStr + ", \"history_probes\":" + historyStr + "}"
    }
    else ""
  }
}

class SimulationTracer {
  var events : mutable.Map[Double, List[(String, String)]] = new mutable.HashMap[Double, List[(String, String)]]()
  var mapInfos : mutable.Map[String, (String, List[(String, Double)])] = new mutable.HashMap[String, (String, List[(String, Double)])]()
  var probes : List[(String, String)] = Nil
  var rawInfos : List[String] = Nil
  var mcSamplings = new MonteCarloSampling

  def addEvent(time : Double, from : String, log : String) = {
    val eventTime = events.getOrElse(time, Nil)
    events.update(time, eventTime :+ (from, log))
  }

  def addMapInfo(nameElem : String, typeElem : String, attr : String, value : Double) = {
    val (typeEl, lsAttrs) = mapInfos.getOrElse(nameElem, (typeElem, Nil))
    mapInfos.update(nameElem, (typeEl, lsAttrs :+ (attr, value)))
  }

  def addProbe(query : String, value : String) = {
    if (probes.exists((probePair) => probePair._1 == query)) {
      probes = probes.map((probePair) => {
        if (probePair._1 == query)  (probePair._1, value)
        else probePair
      })
    }
    else {
      probes :+= (query, value)
    }
  }

  def addRawInfo(rawInfo : String) = {
    rawInfos :+= rawInfo.replaceAll("\"", "''").replaceAll("\n", " ")
  }

  def addSamplingAttrElem(nameElem : String, nameAttr : String, samplingStr : String) = {
    if (mcSamplings.elementsSamplings.exists((tuple) => tuple._1 == nameElem)) {
      mcSamplings.elementsSamplings = mcSamplings.elementsSamplings.map((sampleTuple) => {
        if (sampleTuple._1 == nameElem) (sampleTuple._1, sampleTuple._2 :+ SamplingTuple(nameAttr, samplingStr))
        else sampleTuple
      })
    }
    else {
      mcSamplings.elementsSamplings += (nameElem -> List(SamplingTuple(nameAttr, samplingStr)))
    }
  }

  def addRuntimeSampling(strSampling : String) = {
    mcSamplings.runtimeSampling = SamplingTuple("Runtime", strSampling)
  }

  def addProbeSampling(strProbe : String, strSampling : String) = {
    mcSamplings.probesSampling :+= SamplingTuple(strProbe, strSampling)
  }

  def addProbeHistory(strProbe : String, strHistory : String) = {
    mcSamplings.historySampling :+= HistorySampling(strProbe, strHistory)
  }

  def activateMCSampling() = {
    mcSamplings.active = true
  }

  def toJSONString = {
    // Events
    def eventsToJSONStr = {
      def eventToJSONStr(time: Double, traces : List[(String, String)]) = {
        def tracesToJSONStr(traces : List[(String, String)]) = {
          def tracesToJSONStrComma(traces : List[(String, String)]) : String = traces match {
            case Nil => ""
            case tr::trs =>
              ", {\"from\":\"" + tr._1.replaceAll("\"", "''").replaceAll("\n", " ") + "\", \"log\":\"" + tr._2.replaceAll("\"", "''").replaceAll("\n", " ") + "\"}" + tracesToJSONStrComma(trs)
          }
          traces match {
            case Nil => "[]"
            case tr::trs =>
              "[{\"from\":\"" + tr._1.replaceAll("\"", "''").replaceAll("\n", " ") + "\", \"log\":\"" + tr._2.replaceAll("\"", "''").replaceAll("\n", " ") + "\"}" + tracesToJSONStrComma(trs) + "]"
          }
        }
        "{\"time\":" + time + ", \"traces\":" + tracesToJSONStr(traces) +"}"
      }
      ///// Definition of eventsToJSONStr
      var strRes = "["
      var comma = false
      for {time <- events.keySet.toList.sorted} {
        if (comma) {
          strRes += ", "
        }
        else {
          comma = true
        }
        val traces = events(time)
        strRes += eventToJSONStr(time, traces)
      }
      strRes + "]"
    }
    // mapInfos
    def mapInfosToJSONStr = {
      def mapInfoToJSON(elemName : String, typeElem : String, infos : List[(String, Double)]) = {
        def infosToJSON(infos : List[(String, Double)]) = {
          def infosToJSONComma(infos : List[(String, Double)]) : String = infos match {
            case Nil => ""
            case inf::infs =>
              ", {\"attribute\":\"" + inf._1.replaceAll("\"", "''").replaceAll("\n", " ") + "\", \"value\":" + inf._2 + "}" + infosToJSONComma(infs)
          }
          infos match {
            case Nil => "[]"
            case inf::infs =>
              "[{\"attribute\":\"" + inf._1.replaceAll("\"", "''").replaceAll("\n", " ") + "\", \"value\":" + inf._2 + "}" + infosToJSONComma(infs) + "]"
          }
        }
        "{\"element\":\"" + elemName.replaceAll("\"", "''").replaceAll("\n", " ") + "\", \"type\":\"" + typeElem + "\", \"infos\":" + infosToJSON(infos) + "}"
      }

      ///// Definition of mapInfosToJSON
      var strRes = "["
      var comma = false
      for {keyInfo <- mapInfos.keys} {
        if (comma) {
          strRes += ", "
        }
        else {
          comma = true
        }
        val keyMapInfo = mapInfos.get(keyInfo).get
        val typeEl = keyMapInfo._1
        val infos = keyMapInfo._2
        strRes += mapInfoToJSON(keyInfo, typeEl, infos)
      }
      strRes + "]"
    }
    // probes
    def probesToJSONStr = {
      def probesToJSONSeq(lsProbes : List[(String, String)]) : String = lsProbes match {
        case Nil => ""
        case pr::prs =>
          ", {\"query\":\"" + pr._1.replaceAll("\"", "''").replaceAll("\n", " ") + "\", \"value\":" + pr._2 + "}" + probesToJSONSeq(prs)
      }
      ///// Definition of probesToJSONStr
      val probesSeq = probes match {
        case Nil => ""
        case pr::prs =>
          "{\"query\":\"" + pr._1.replaceAll("\"", "''").replaceAll("\n", " ") + "\", \"value\":" + pr._2 + "}" + probesToJSONSeq(prs)
      }
      s"[$probesSeq]"
    }
    // raw Infos
    def rawInfosToJSONStr = {
      var strRes = "["
      var comma = false
      rawInfos.foreach((rawInfo) => {
        if (comma) {
          strRes += ", "
        }
        else {
          comma = true
        }
        strRes += "\"" + rawInfo.replaceAll("\"", "''").replaceAll("\n", " ") + "\""
      })
      strRes + "]"
    }
    ///// Definition of toJSONString
    "{\"events\":" + eventsToJSONStr + ", \"mapInfos\":" + mapInfosToJSONStr + ", \"probes\":" + probesToJSONStr +
    ", \"rawInfos\":" + rawInfosToJSONStr + mcSamplings.toJSONString + "}"
  }

  // Technical overriding of toString
  override def toString = toJSONString
}
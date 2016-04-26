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

abstract class Logger[T] {
  def reset() : Unit

  def log(ls : T*) : Unit

  def logIfTrue(cond : Boolean, ls : T*) = {
    if (cond) log(ls:_*)
  }

  val loggerFunc = log _
}

object StdoutLogger extends Logger[String] {
  def reset() = {}

  def log(ls : String*) = ls.foreach((l) => println(l))
}

object TextLogger extends Logger[String] {
  var logs = ""

  def reset() = {
    logs = ""
  }

  def log(ls : String*) = {
    logs += ls.foldLeft("")((l, acc) => s"$l $acc\n")
  }
}

object HtmlLogger extends Logger[String] {
  var logs = ""

  def reset() = {
    logs = ""
  }

  def log(ls : String*) = {
    logs += ls.foldLeft("")((l, acc) => s"$l $acc<br />")
  }
}

abstract class LoggerContent
case class LoggerLine(line : String) extends LoggerContent
case object EndLogger extends LoggerContent

class BufferLogger extends Logger[String] {
  var logs : List[LoggerContent] = Nil

  def reset() = {
    logs = Nil
  }

  def log(ls : String*) = {
    logs = logs ::: ls.map((l) => LoggerLine(l)).toList
  }

  def endLogger() = {
    logs :+= EndLogger
  }

  def readFrom(n: Int) : (Option[List[String]], Int, Boolean) = {
    val len = logs.length
    if (n < len) {
      var ls : List[String] = Nil
      for (i <- n until len) {
        logs(i) match {
          case LoggerLine(line) =>
            ls = ls :+ line
          case EndLogger =>
        }
      }
      (Some(ls), logs.length, logs(len-1) == EndLogger)
    }
    else (None, n, false)
  }

  def readOne(n : Int) : (Option[String], Int, Boolean) = {
    if (n < logs.length) {
      logs(n) match {
        case LoggerLine(line) => (Some(line), n+1, false)
        case EndLogger => (None, n, true)
      }
    }
    else (None, n, false)
  }
}

class TraceLogger extends Logger[String] {
  var logs = new SimulationTracer

  var curtime = 0D

  def reset() = {
    logs = new SimulationTracer
  }

  def log(ls : String*) = {
    if (ls.nonEmpty) {
      val typeLog = ls.head
      typeLog match {
        case "time" =>
          curtime = ls(1).toDouble
        case "event" =>
          val nameElem = ls(1)
          val logTrace = ls(2)
          logs.addEvent(curtime, nameElem, logTrace)
        case "rawinfo" =>
          val rawInfo = ls(1)
          logs.addRawInfo(rawInfo)
        case "mapinfo" =>
          val elemName = ls(1)
          val typeElem = ls(2)
          val attrName = ls(3)
          val attrVal = ls(4).toDouble
          logs.addMapInfo(elemName, typeElem, attrName, attrVal)
        case "probe" =>
          val queryName = ls(1)
          val queryVal = ls(2)
          logs.addProbe(queryName, queryVal)
        case "mc_activate" =>
          logs.activateMCSampling()
        case "mc_sampling_element" =>
          val elem_name = ls(1)
          val name_attr = ls(2)
          val sampling_str = ls(3)
          logs.addSamplingAttrElem(elem_name, name_attr, sampling_str)
        case "mc_sampling_runtime" =>
          val sampling_str = ls(1)
          logs.addRuntimeSampling(sampling_str)
        case "mc_sampling_probe" =>
          val probe_name = ls(1)
          val sampling_str = ls(2)
          logs.addProbeSampling(probe_name, sampling_str)
        case "mc_history_probe" =>
          val probe_name = ls(1)
          val history_str = ls(2)
          logs.addProbeHistory(probe_name, history_str)
        case _ =>
      }
    }
  }
}
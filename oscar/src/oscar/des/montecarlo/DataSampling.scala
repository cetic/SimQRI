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

package oscar.des.montecarlo

/**
 * This class contains a list of numbers for which some statistics can be computed.
 *
 * @author gustavo.ospina@cetic.be
 */
class DataSampling {
  var samples : List[Double] = Nil
  var max : Option[Double] = None
  var min : Option[Double] = None
  var mean : Option[Double] = None
  var variance : Option[Double] = None
  private var sum = 0D
  private var size = 0L

  def <-- (x : Double) = {
    samples :+= x
    sum += x
    size += 1
    max = Some(Math.max(max.getOrElse(Double.MinValue), x))
    min = Some(Math.min(min.getOrElse(Double.MaxValue), x))
    val mean0 = mean.getOrElse(0D)
    mean = Some(mean0 + (x - mean0)/size)
    if (size > 1) {
      val variance0 = variance.getOrElse(0D)
      variance = Some(((variance0/(size-1)) + (x - mean0)*(x-mean.get)) / size)
    }
  }

  def toJSONString = {
    var strSamples = "["
    var comma = false
    for {sample <- samples} {
      if (comma) {
        strSamples += ", "
      }
      else {
        comma = true
      }
      strSamples += sample.toString
    }
    strSamples += "]"
    strSamples
    "{\"samples\":" + strSamples + DataSampling.toJSONfield("max", max) +
    DataSampling.toJSONfield("min", min) + DataSampling.toJSONfield("mean", mean) +
    DataSampling.toJSONfield("variance", variance) + "}"
  }

  override def toString = {
    def strOpt[T](opt : Option[T]) : String = opt match {
      case Some(data) => s"$data"
      case None => "Undefined"
    }

    s"<ul><li>Maximum : ${strOpt(max)}</li><li>Minimum : ${strOpt(min)}</li><li>Mean : ${strOpt(mean)}</li><li>Variance : ${strOpt(variance)}</li></ul>"
  }
}

object DataSampling {
  def toJSONfield(fieldName : String, fieldVal : Option[Double]) = fieldVal match {
    case None => ""
    case Some(value) => ", \"" + fieldName + "\":" + value
  }
}

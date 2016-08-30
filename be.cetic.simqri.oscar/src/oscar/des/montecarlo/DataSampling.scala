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
  
  def getHistogram = DataSampling.histogram(samples, min.getOrElse(0), max.getOrElse(0))

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
    ", \"histogram\":" + DataSampling.histogramToJSONString(getHistogram) +
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
  
  def histogram(samples: List[Double], min: Double, max: Double): List[(Double, Int)] = {
    // compute number of bins
    def numberOfBins(sortedSamples: List[Double]) = {
      if (sortedSamples.isEmpty)
        0
      else {
        val indFirstQuartile = sortedSamples.length/4
        val indThirdQuartile = 3*sortedSamples.length/4
        val iqr = sortedSamples(indThirdQuartile)-sortedSamples(indFirstQuartile)
        val cubicRootN = math.pow(sortedSamples.length, 1D/3D)
        val h = 2*iqr/cubicRootN
        if (h == 0)
          math.ceil(2*cubicRootN).toInt
        else
          math.ceil((max-min)/h).toInt
      }
    }
    // Filling bins
    def filledAllBins(ls: List[Double], sizeInterval: Double, initBin: Int, nBins: Int): List[(Double, Int)] = {
      def filledBin(ls: List[Double], to: Double): ((Double, Int), List[Double]) = {
        def filledBin(ls: List[Double], to: Double, sum: Double, size: Int): ((Double, Int), List[Double]) =
          ls match {
            case Nil => if (size == 0) ((0,0), Nil) else ((sum/size, size), Nil)
            case v::vs =>
              if (v > to)
                if (size == 0) ((0,0), ls) else ((sum/size, size), ls)
              else
                filledBin(vs, to, sum+v, size+1)
          }
        filledBin(ls, to, 0, 0)
      }
      def filledAllBins(ls: List[Double], initBin: Int, binsAcc: List[(Double, Int)]): List[(Double, Int)] = {
        def binNul(bin: (Double, Int)) = (bin._1 == 0) && (bin._2 == 0)
        if (initBin > nBins)
          binsAcc
        else {
          val to = min + initBin*sizeInterval
          val (bin, lsRem) = filledBin(ls, to)
          filledAllBins(lsRem, initBin+1, if (binNul(bin)) binsAcc else binsAcc :+ bin)
        }
      }
      filledAllBins(ls, initBin, Nil)
    }
    // Definition of histogram/3
    if (samples.isEmpty)
      Nil
    else {
      val sortedSamples = samples.sorted
      val numBins = numberOfBins(sortedSamples)
      val sizeInterval = if (numBins == 0) 0D else (max - min)/numBins
      filledAllBins(sortedSamples, sizeInterval, 1, numBins)
    }
  }

  def histogramToJSONString(ls: List[(Double, Int)]) = {
    s"[${ls.foldLeft("")((str, tup) => {str + (if (str == "") "" else ",") + "{\"mean\": " + tup._1 + ", \"frequency\": " + tup._2 +"}"})}]"
  }
  
  def toJSONfield(fieldName : String, fieldVal : Option[Double]) = fieldVal match {
    case None => ""
    case Some(value) => ", \"" + fieldName + "\":" + value
  }
}

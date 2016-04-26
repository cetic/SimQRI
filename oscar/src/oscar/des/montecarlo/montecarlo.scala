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

import JSci.maths.statistics._

import scala.collection.immutable.SortedMap

/**
  * Monte Carlo framework.
  *
  * @param nIterations the number of iterations
  * @param nVariables the number of random variables
  * @param probabilityDistr the probability distribution of all variables
  * @param typeVariables type of values (Int, Double)
  * @param evaluationFunction function to evaluate on random variables in each
  *                           iteration
  * @param resultFunction function to analyse the aggregated results
  * @author gustavo.ospina@cetic.be
  */
class MonteCarlo(nIterations : Long = 10000,
                 nVariables : Int = 1,
                 probabilityDistr : ProbabilityDistribution = new UniformDistribution(0,1),
                 typeVariables : TypeRdVar = DoubleRdVar,
                 evaluationFunction : List[AnyVal] => Double = _ => 0.0,
                 resultFunction : Aggregator => Double = _ => 0.0) {
  private val aggregator = new Aggregator
  private val randomVars = new RandomVarList("RVs", probabilityDistr)
  initRandomVars()

  def initRandomVars(): Unit = {
    def initRandomVars(i : Long): Unit = {
      if (i < nVariables) {
        typeVariables match {
          case IntRdVar => randomVars.addIntRandomVar()
          case DoubleRdVar => randomVars.addDoubleRandomVar()
        }
        initRandomVars(i+1)
      }
    }
    initRandomVars(0)
  }

  def runSimulation(): Double = {
    def runSimulation(i : Long) : Double = {
      if (i < nIterations) {
        aggregator + evaluationFunction(randomVars.getValues)
        runSimulation(i+1)
      }
      else {
        resultFunction(aggregator)
      }
    }
    aggregator.reset()
    runSimulation(0)
  }
}

/**
  * This class represents a very very simple statistical aggregator.
  */
class Aggregator{
  var sum = 0.0
  var mult = 1.0
  var size = 1L
  var max = Double.NegativeInfinity
  var min = Double.PositiveInfinity

  def +(x : Double): Unit = {
    sum += x
    mult *= x
    size += 1
    if (x > max)
      max = x
    if (x < min)
      min = x
  }

  def reset(): Unit = {
    sum = 0.0
    mult = 1.0
    size = 0
    max = Double.NegativeInfinity
    min = Double.PositiveInfinity
  }

  override def toString = s"Aggregator(sum=$sum, mult=$mult, size=$size, max=$max, min=$min)"
}


class RichAggregator(doubleFields:Array[String], booleanFields:Array[String]){
  //bool is true for Double (lool this is not intuitive)
  val fieldDico:SortedMap[String,(Boolean,Int)] =
    SortedMap.empty[String,(Boolean,Int)]
      .++ (for (a <- doubleFields.indices) yield (doubleFields(a),(true,a)))
      .++ (for (a <- booleanFields.indices) yield (booleanFields(a),(true,a)))

  var recordedData:List[(Array[Double],Array[Boolean])] = List.empty

  def addData(d:Array[Double],b:Array[Boolean]): Unit ={
    recordedData = (d,b) :: recordedData
  }

  def statisticsForField(field:String):SingleDataStatistics = {
    val (isDouble,id) = fieldDico(field)
    if(isDouble){
      val dataForThisField = recordedData.map(_._1.apply(id))
      Statistics.applyDouble(dataForThisField,field)
    }else{
      val dataForThisField = recordedData.map(_._2.apply(id))
      Statistics.applyBool(dataForThisField,field)
    }
  }

  def statisticsForTheseTwoFields(field1:String,field2:String):PairDataStatistics = {
    val (double1, id1) = fieldDico(field1)
    val (double2, id2) = fieldDico(field2)

    (double1, double2) match {
      case (true, true) => NoPairStatistics(field1,field2)
      case (true, false) => Statistics.applyBoolDouble(recordedData.map(l => (l._2.apply(id2),l._1.apply(id1))), field2, field1)
      case (false, true) => Statistics.applyBoolDouble(recordedData.map(l => (l._2.apply(id1),l._1.apply(id2))), field1, field2)
      case (false, false) => Statistics.applyBoolBool(recordedData.map(l => (l._2.apply(id1),l._2.apply(id2))),field1, field2)
    }
  }
}

sealed abstract class SingleDataStatistics(val fieldName:String){
  def stringNoFieldName:String
  override def toString: String = fieldName + ":" + stringNoFieldName
}
case class BoolStatistics(trueRatio:Double, falseRatio:Double,totalSample:Int,override val fieldName:String) extends SingleDataStatistics(fieldName){
  override def stringNoFieldName: String = "(trueRatio:" + trueRatio + " falseRatio:" + falseRatio + " totalSample:" + totalSample + ")"
}

case class DoubleStatistics(min:Double, max:Double, avg:Double, med:Double, totalSample:Int, override val fieldName:String) extends SingleDataStatistics(fieldName){
  override def stringNoFieldName:String = "(min:" + min + " max:" + max + " avg:" + avg + " med:" + med + "totalSample:" + totalSample + ")"
}

case class NoSingleStatistics(override val fieldName:String) extends SingleDataStatistics(fieldName){
  override def stringNoFieldName: String = "no statistics"
}

object Statistics {
  def applyDouble(l: List[Double], fieldName: String): DoubleStatistics = {
    require(l.nonEmpty)
    val sorted = l.sorted
    val size = l.size
    DoubleStatistics(min = sorted.head, max = sorted.last, avg = (l.sum / (size.toDouble)), med = sorted.apply(size / 2), size, fieldName)
  }

  def applyBool(l: List[Boolean], fieldName: String): BoolStatistics = {
    require(l.nonEmpty)
    val size = l.size
    val nbTrue: Int = l.count(b => b)
    val trueRatio = nbTrue.toDouble / size.toDouble
    BoolStatistics(trueRatio, 1.0 - trueRatio, size, fieldName)
  }

  def applyBoolBool(fieldValues: List[(Boolean, Boolean)], field1: String, field2: String): PairDataStatistics = {
    val stat1 = applyBool(fieldValues.map(_._1), field1)
    val stat2 = applyBool(fieldValues.map(_._2), field2)

    var trueTrue: Int = 0
    var trueFalse: Int = 0
    var falseTrue: Int = 0
    var falseFalse: Int = 0
    var nbSample = 0;

    for (vc <- fieldValues) {
      vc match {
        case (true, true) => trueTrue += 1
        case (true, false) => trueFalse += 1
        case (false, true) => falseTrue += 1
        case (false, false) => falseFalse += 1
      }
      nbSample += 1
    }

    BoolBoolStatistics(stat1, stat2, trueTrue.toDouble / nbSample, falseFalse.toDouble / nbSample, trueFalse.toDouble / nbSample, falseTrue.toDouble / nbSample)
  }

  def applyBoolDouble(fieldValues: List[(Boolean, Double)], field1: String, field2: String): PairDataStatistics = {
    val stat1 = applyBool(fieldValues.map(_._1), field1)
    val stat2 = applyDouble(fieldValues.map(_._2), field2)

    var valuesWhenTrue: List[Double] = List.empty
    var valuesWhenFalse: List[Double] = List.empty
    var nbSample = 0;
    for (vc <- fieldValues) {
      vc match {
        case (true, v) => valuesWhenTrue = v :: valuesWhenTrue
        case (false, v) => valuesWhenFalse = v :: valuesWhenFalse
      }
      nbSample += 1
    }

    BoolDoubleStatistics(stat1, stat2, applyDouble(valuesWhenTrue, field2 + " with " + field2 + "=true"), applyDouble(valuesWhenFalse, field2 + " with " + field2 + "=false"))
  }
}

sealed abstract class PairDataStatistics(val field1:String,val field2:String){
  def nSpace(n:Int):String = if(n <= 0) "" else " " + nSpace(n-1)
  protected def padToLength(s: String, l: Int) = (s + nSpace(l)).substring(0, l)
}

case class NoPairStatistics(override val field1:String,override val field2:String) extends PairDataStatistics(field1,field2){
  override def toString: String = "no statistics for " + field1 + "," + field2
}

case class BoolBoolStatistics(field1Statistics:BoolStatistics,field2Statistics:BoolStatistics, trueTrue:Double ,falseFalse:Double, trueFalse:Double, falseTrue:Double)
  extends PairDataStatistics(field1Statistics.fieldName,field1Statistics.fieldName){
  override def toString: String = {
    field1Statistics + "\n" +
      field2Statistics + "\n" +
      padToLength(field1,15) + "|" + padToLength(field2,15) + "| stat\n" +
      " false         | false         |" + falseFalse + "\n" +
      " false         | true          |" + falseTrue + "\n" +
      " true          | false         |" + trueFalse + "\n" +
      " true          | true          |" + trueTrue + "\n"
  }
}

case class BoolDoubleStatistics(field1Statistics:BoolStatistics,field2Statistics:DoubleStatistics, field2Whenfield1True:DoubleStatistics, field2whenField1False:DoubleStatistics)
  extends PairDataStatistics(field1Statistics.fieldName,field1Statistics.fieldName){
  override def toString: String = {
    field1Statistics + "\n" +
      field2Statistics + "\n" +
      padToLength(field1,15) + "|" + padToLength(field2,15) +
      " false         |" + field2whenField1False.stringNoFieldName + "\n" +
      " true          |" + field2Whenfield1True.stringNoFieldName + "\n"
  }
}
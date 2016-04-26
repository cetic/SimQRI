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

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import oscar.des.engine.NumberGenerator
import JSci.maths.statistics._

/**
 * Case classes representing the actual type of random variables
 */
abstract class TypeRdVar
case object IntRdVar extends TypeRdVar
case object DoubleRdVar extends TypeRdVar

/**
 * Case classes representing random values
 */
abstract class RandomValue
case class RandomInt(value : Int) extends RandomValue
case class RandomDouble(value : Double) extends RandomValue

/**
 * General category of Random Variables
 *
 * @tparam T the type of values for the random variable (subtype of AnyVal)
 * @author gustavo.ospina@cetic.be
 */
trait RandomVar[+T <: AnyVal] {
  val typeVar : TypeRdVar

  def getValue: T

  def staticIntRandomFunc: () => Int

  def staticFloatRandomFunc: () => Float

  def staticDoubleRandomFunc: () => Double

  def staticBooleanRandomFunc: () => Boolean = () => staticIntRandomFunc() != 0

  def dynamicIntRandomFunc: () => Int

  def dynamicFloatRandomFunc: () => Float

  def dynamicDoubleRandomFunc: () => Double

  def dynamicBooleanRandomFunc: () => Boolean = () => dynamicIntRandomFunc() != 0

  def apply[U](fn : T => U) : U = fn(getValue)

  def applyInt[U](fn : Int => U) = fn(dynamicIntRandomFunc())

  def applyDouble[U](fn : Double => U) = fn(dynamicDoubleRandomFunc())

  def resetDynamicFunctions()
}

/**
 * Integer random variable
 *
 * @param name the name of the variable
 * @param numberGenerator the number generator associated (with a probability distribution)
 * @author gustavo.ospina@cetic.be
 */
class IntRandomVar(name : String, numberGenerator: NumberGenerator) extends RandomVar[Int] {
  val typeVar = IntRdVar

  var randomInt : Option[Int] = None

  def this(nm : String, dist : ProbabilityDistribution) = this(nm, new NumberGenerator(dist))

  def getValue = numberGenerator.generateNext().toInt

  def staticIntRandomFunc = () => randomInt match {
    case Some(v) => v
    case None =>
      val v = getValue
      randomInt = Some(v)
      v
  }

  def staticFloatRandomFunc = () => staticIntRandomFunc().toFloat

  def staticDoubleRandomFunc = () => staticIntRandomFunc().toDouble

  def dynamicIntRandomFunc = () => getValue

  def dynamicFloatRandomFunc = () => getValue.toFloat

  def dynamicDoubleRandomFunc = () => getValue.toDouble

  def resetDynamicFunctions(): Unit = {
    randomInt = None
  }

  override def toString : String = {
    s"Integer Random Variable $name : $getValue"
  }
}

/**
 * Double random variable
 *
 * @param name the name of the variable
 * @param numberGenerator the number generator associated (with a probability distribution)
 * @author gustavo.ospina@cetic.be
 */
class DoubleRandomVar(name : String, numberGenerator: NumberGenerator) extends RandomVar[Double] {
  val typeVar = DoubleRdVar

  var randomDbl : Option[Double] = None

  def this(nm : String, dist : ProbabilityDistribution) = this(nm, new NumberGenerator(dist))

  def getValue = numberGenerator.generateNext()

  def staticIntRandomFunc = () => staticDoubleRandomFunc().toInt

  def staticFloatRandomFunc = () => staticDoubleRandomFunc().toFloat

  def staticDoubleRandomFunc = () => randomDbl match {
    case Some(v) => v
    case None =>
      val v = getValue
      randomDbl = Some(v)
      v
  }

  def dynamicIntRandomFunc = () => getValue.toInt

  def dynamicFloatRandomFunc = () => getValue.toFloat

  def dynamicDoubleRandomFunc = () => getValue

  def resetDynamicFunctions(): Unit = {
    randomDbl = None
  }

  override def toString : String = {
    s"Double Random Variable $name : $getValue"
  }
}

/**
 * A list of random variables with the same probability distribution
 *
 * @param name the name of the list
 * @param numberGenerator the number generator associated (with a probability distribution)
 * @author gustavo.ospina@cetic.be
 */
class RandomVarList(name : String, numberGenerator: NumberGenerator) {
  private var rvList : ListBuffer[RandomVar[AnyVal]] = new ListBuffer[RandomVar[AnyVal]]()

  def this(nm : String, dist : ProbabilityDistribution) = this(nm, new NumberGenerator(dist))

  def addRandomVar(typeVar : TypeRdVar): Unit = typeVar match {
    case IntRdVar =>
      addIntRandomVar()
    case DoubleRdVar =>
      addDoubleRandomVar()
  }

  def addIntRandomVar(): Unit = {
    val lg = rvList.length
    rvList = rvList += new IntRandomVar(name + s"__$lg", numberGenerator)
  }

  def addDoubleRandomVar(): Unit = {
    val lg = rvList.length
    rvList = rvList += new DoubleRandomVar(name + s"__$lg", numberGenerator)
  }

  def getValues : List[AnyVal] = rvList.map((rv) => rv.getValue).toList

  def getRVList : List[RandomVar[AnyVal]] = rvList.toList

  def map[U](fn : AnyVal => U) : List[U] = {
    val ls = for (rv <- rvList) yield rv.apply(fn)
    ls.toList
  }

  def mapInt[U](fn : Int => U) : List[U] = {
    val ls = for (rv <- rvList) yield rv.applyInt(fn)
    ls.toList
  }

  def mapDouble[U](fn : Double => U) : List[U] = {
    val ls = for (rv <- rvList) yield rv.applyDouble(fn)
    ls.toList
  }

  def fold(z : AnyVal)(op : (AnyVal, AnyVal) => AnyVal) : AnyVal =
    foldLeft(z)(op)

  def foldLeft[U](z : U)(op : (U, AnyVal) => U) : U =
    rvList.foldLeft(z)((u:U, rv:RandomVar[AnyVal]) => op(u, rv.getValue))

  def foldRight[U](z : U)(op : (AnyVal, U) => U) : U =
    rvList.foldRight(z)((rv:RandomVar[AnyVal], u:U) => op(rv.getValue, u))

  def resetDynamicFunctions(): Unit =  rvList.foreach((rv) => rv.resetDynamicFunctions())
}

/**
 * A set of random variables (which can have different distributions)
 *
 * @param name the name of the set
 */
class RandomVarSet(name : String) {
  private var rvSet : mutable.Set[RandomVar[AnyVal]] = mutable.Set()

  def addRandomVar(typeVar : TypeRdVar, dist : ProbabilityDistribution): Unit = typeVar match {
    case IntRdVar =>
      addIntRandomVar(dist)
    case DoubleRdVar =>
      addDoubleRandomVar(dist)
  }

  def addIntRandomVar(dist : ProbabilityDistribution): Unit = {
    val lg = rvSet.size
    rvSet += new IntRandomVar(name + s"__$lg", dist)
  }

  def addDoubleRandomVar(dist : ProbabilityDistribution): Unit = {
    val lg = rvSet.size
    rvSet += new DoubleRandomVar(name + s"__$lg", dist)
  }

  def addRandomVarList(rvLst : RandomVarList): Unit = {
    rvLst.getRVList.foreach((rv) => { rvSet += rv })
  }

  def addRandomVarSet(otherSet : RandomVarSet): Unit = {
    rvSet = rvSet ++ otherSet.rvSet
  }

  def getValues : List[AnyVal] = rvSet.map((rv) => rv.getValue).toList

  def resetDynamicFunctions(): Unit =  rvSet.foreach((rv) => rv.resetDynamicFunctions())
}
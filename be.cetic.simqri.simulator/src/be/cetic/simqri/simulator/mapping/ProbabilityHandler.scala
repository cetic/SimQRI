package be.cetic.simqri.simulator.mapping

import be.cetic.simqri.metamodel._
import JSci.maths.statistics._
import oscar.des.montecarlo.{DoubleRandomVar, IntRandomVar}

/**
 * This class allows the conversion between a probability distribution object and a random var
 * 
 * @author FK & Gustavo Ospina
 */
class ProbabilityHandler {
  
  def getIntFunc(p : Probability) : () => Int = p match {
    case s: Scalar =>
      () => s.getValue.toInt
    case n : Gaussian => // = "normal" in the web client
      val intRdVar = new IntRandomVar("normal", new NormalDistribution(n.getLocation, n.getScale))
      intRdVar.dynamicIntRandomFunc
    case po : Poisson =>
      val intRdVar = new IntRandomVar("poisson", new PoissonDistribution(po.getInterval))
      intRdVar.dynamicIntRandomFunc
    case u : Uniform =>
      val intRdVar = new IntRandomVar("uniform", new UniformDistribution(u.getMinimum, u.getMaximum))
      intRdVar.dynamicIntRandomFunc
    case _ =>
      () => 0
  }
  
  def getNonNegativeIntFunc(p : Probability) : () => Int = () => {
    val intVal = getIntFunc(p)()
    if (intVal >= 0) intVal else 0
  }
  
  def getDoubleFunc(p : Probability) : () => Double = p match {
    case s: Scalar =>
      () => s.getValue
    case n : Gaussian =>
      val doubleRdVar = new DoubleRandomVar("normal", new NormalDistribution(n.getLocation, n.getScale))
      doubleRdVar.dynamicDoubleRandomFunc
    case po : Poisson =>
      val doubleRdVar = new DoubleRandomVar("poisson", new PoissonDistribution(po.getInterval))
      doubleRdVar.dynamicDoubleRandomFunc
    case u : Uniform =>
      val doubleRdVar = new DoubleRandomVar("uniform", new UniformDistribution(u.getMinimum, u.getMaximum))
      doubleRdVar.dynamicDoubleRandomFunc
    case _ =>
      () => 0
  }
  
  def getNonNegativeDoubleFunc(p : Probability) : () => Double = () => {
    val dblVal = getDoubleFunc(p)()
    if (dblVal >= 0D) dblVal else 0D
  }

  def getFloatFunc(p : Probability) = () => getDoubleFunc(p)().toFloat

  def getNonNegativeFloatFunc(p : Probability) = () => getNonNegativeDoubleFunc(p)().toFloat
  
}
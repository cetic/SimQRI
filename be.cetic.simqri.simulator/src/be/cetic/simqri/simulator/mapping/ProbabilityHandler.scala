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
      () => s.getValue
    case b: Beta =>
      val intRdVar = new IntRandomVar("beta", new BetaDistribution(b.getFreedomDegreeA, b.getFreedomDegreeB))
      intRdVar.dynamicIntRandomFunc
    case bi : Binomial =>
      val intRdVar = new IntRandomVar("binomial", new BinomialDistribution(bi.getNbrOfTrial, bi.getProbaOfSuccess))
      intRdVar.dynamicIntRandomFunc
    case c : Cauchy =>
      val intRdVar = new IntRandomVar("cauchy", new CauchyDistribution(c.getLocation, c.getScale))
      intRdVar.dynamicIntRandomFunc
    case cs : ChiSquare =>
      val intRdVar = new IntRandomVar("chisqr", new ChiSqrDistribution(cs.getDegreeOfFreedom.doubleValue()))
      intRdVar.dynamicIntRandomFunc
    case e : Exponential =>
      val intRdVar = new IntRandomVar("exponential", new ExponentialDistribution(e.getScale))
      intRdVar.dynamicIntRandomFunc
    case fd : be.cetic.simqri.metamodel.FDistribution =>
      val intRdVar = new IntRandomVar("fdistr", new JSci.maths.statistics.FDistribution(fd.getFreedomDegreeA, fd.getFreedomDegreeB))
      intRdVar.dynamicIntRandomFunc
    case g : Gamma =>
      val intRdVar = new IntRandomVar("gamma", new GammaDistribution(g.getShape))
      intRdVar.dynamicIntRandomFunc
    case ge : Geometric =>
      val intRdVar = new IntRandomVar("geometric", new GeometricDistribution(ge.getProbaOfSuccess))
      intRdVar.dynamicIntRandomFunc
    case ln : LogNormal =>
      val intRdVar = new IntRandomVar("lognormal", new LognormalDistribution(ln.getLocation, ln.getScale))
      intRdVar.dynamicIntRandomFunc
    case n : Gaussian => // = "normal" in the web client
      val intRdVar = new IntRandomVar("normal", new NormalDistribution(n.getLocation, n.getScale))
      intRdVar.dynamicIntRandomFunc
    case p : Pareto =>
      val intRdVar = new IntRandomVar("pareto", new ParetoDistribution(p.getShape, p.getScale))
      intRdVar.dynamicIntRandomFunc
    case po : Poisson =>
      val intRdVar = new IntRandomVar("poisson", new PoissonDistribution(po.getInterval))
      intRdVar.dynamicIntRandomFunc
    case st : StudentsT =>
      val intRdVar = new IntRandomVar("lognormal", new TDistribution(st.getDegreeOfFreedom.intValue()))
      intRdVar.dynamicIntRandomFunc
    case u : Uniform =>
      val intRdVar = new IntRandomVar("uniform", new UniformDistribution(u.getMinimum, u.getMaximum))
      intRdVar.dynamicIntRandomFunc
    case w : Weibull =>
      val intRdVar = new IntRandomVar("weibull", new WeibullDistribution(w.getShape))
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
      () => s.getValue.doubleValue()
    case b: Beta =>
      val doubleRdVar = new DoubleRandomVar("beta", new BetaDistribution(b.getFreedomDegreeA, b.getFreedomDegreeB))
      doubleRdVar.dynamicDoubleRandomFunc
    case bi : Binomial =>
      val doubleRdVar = new DoubleRandomVar("binomial", new BinomialDistribution(bi.getNbrOfTrial, bi.getProbaOfSuccess))
      doubleRdVar.dynamicDoubleRandomFunc
    case c : Cauchy =>
      val doubleRdVar = new DoubleRandomVar("cauchy", new CauchyDistribution(c.getLocation, c.getScale))
      doubleRdVar.dynamicDoubleRandomFunc
    case cs : ChiSquare =>
      val doubleRdVar = new DoubleRandomVar("chisqr", new ChiSqrDistribution(cs.getDegreeOfFreedom.doubleValue()))
      doubleRdVar.dynamicDoubleRandomFunc
    case e : Exponential =>
      val doubleRdVar = new DoubleRandomVar("exponential", new ExponentialDistribution(e.getScale))
      doubleRdVar.dynamicDoubleRandomFunc
    case fd : be.cetic.simqri.metamodel.FDistribution =>
      val doubleRdVar = new DoubleRandomVar("fdistr", new JSci.maths.statistics.FDistribution(fd.getFreedomDegreeA, fd.getFreedomDegreeB))
      doubleRdVar.dynamicDoubleRandomFunc
    case g : Gamma =>
      val doubleRdVar = new DoubleRandomVar("gamma", new GammaDistribution(g.getShape))
      doubleRdVar.dynamicDoubleRandomFunc
    case ge : Geometric =>
      val doubleRdVar = new DoubleRandomVar("geometric", new GeometricDistribution(ge.getProbaOfSuccess))
      doubleRdVar.dynamicDoubleRandomFunc
    case ln : LogNormal =>
      val doubleRdVar = new DoubleRandomVar("lognormal", new LognormalDistribution(ln.getLocation, ln.getScale))
      doubleRdVar.dynamicDoubleRandomFunc
    case n : Gaussian =>
      val doubleRdVar = new DoubleRandomVar("normal", new NormalDistribution(n.getLocation, n.getScale))
      doubleRdVar.dynamicDoubleRandomFunc
    case p : Pareto =>
      val doubleRdVar = new DoubleRandomVar("pareto", new ParetoDistribution(p.getShape, p.getScale))
      doubleRdVar.dynamicDoubleRandomFunc
    case po : Poisson =>
      val doubleRdVar = new DoubleRandomVar("poisson", new PoissonDistribution(po.getInterval))
      doubleRdVar.dynamicDoubleRandomFunc
    case st : StudentsT =>
      val doubleRdVar = new DoubleRandomVar("lognormal", new TDistribution(st.getDegreeOfFreedom.intValue()))
      doubleRdVar.dynamicDoubleRandomFunc
    case u : Uniform =>
      val doubleRdVar = new DoubleRandomVar("uniform", new UniformDistribution(u.getMinimum, u.getMaximum))
      doubleRdVar.dynamicDoubleRandomFunc
    case w : Weibull =>
      val doubleRdVar = new DoubleRandomVar("weibull", new WeibullDistribution(w.getShape))
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
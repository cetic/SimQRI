package be.cetic.simqri.mapping;

import JSci.maths.statistics.*;
import JSci.maths.statistics.FDistribution;
import be.cetic.simqri.metamodel.*;
import oscar.des.montecarlo.DoubleRandomVar;
import oscar.des.montecarlo.IntRandomVar;

/**
 * 
 * @author FK
 *
 * This class is inspired from SimQRiJSONData.scala and manages the random var generation from a
 * probability distribution
 */
public class ProbabilityHandler {
	
	public static Object getIntFunc(Probability p) {
		if (p instanceof Scalar) {
			Scalar s = (Scalar) p;
			return s.getValue();
		}
		else if (p instanceof Beta) {
			Beta b = (Beta) p;
			IntRandomVar intRdVar 
				= new IntRandomVar("beta", new BetaDistribution(b.getFreedomDegreeA(), b.getFreedomDegreeB()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Binomial) {
			Binomial b = (Binomial) p;
			IntRandomVar intRdVar 
				= new IntRandomVar("binomial", new BinomialDistribution(b.getNbrOfTrial(), b.getProbaOfSuccess()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Cauchy) {
			Cauchy c = (Cauchy) p;
			IntRandomVar intRdVar 
				= new IntRandomVar("cauchy", new CauchyDistribution(c.getLocation(), c.getScale()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof ChiSquare) {
			ChiSquare cs = (ChiSquare) p;
			IntRandomVar intRdVar
				= new IntRandomVar("chisqr", new ChiSqrDistribution(cs.getDegreeOfFreedom()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof DiracDelta) {
			DiracDelta dd = (DiracDelta) p;
			IntRandomVar intRdVar 
				= new IntRandomVar("diracdelta", new DiracDeltaDistribution(dd.getMean()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Exponential) {
			Exponential e = (Exponential) p;
			IntRandomVar intRdVar 
				= new IntRandomVar("exponential", new ExponentialDistribution(e.getScale()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof be.cetic.simqri.metamodel.FDistribution) {
			be.cetic.simqri.metamodel.FDistribution fd = (be.cetic.simqri.metamodel.FDistribution) p;
			IntRandomVar intRdVar 
				= new IntRandomVar("fdistr", new FDistribution(fd.getFreedomDegreeA(), fd.getFreedomDegreeB()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Gamma) {
			Gamma g = (Gamma) p;
			IntRandomVar intRdVar
				= new IntRandomVar("gamma", new GammaDistribution(g.getShape()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Geometric) {
			Geometric g = (Geometric) p;
			IntRandomVar intRdVar 
				= new IntRandomVar("geometric", new GeometricDistribution(g.getProbaOfSuccess()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof LogNormal) {
			LogNormal ln = (LogNormal) p;
			IntRandomVar intRdVar 
				= new IntRandomVar("lognormal", new LognormalDistribution(ln.getLocation(), ln.getScale()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Gaussian) { // = Normal
			Gaussian g = (Gaussian) p;
			IntRandomVar intRdVar 
				= new IntRandomVar("normal", new NormalDistribution(g.getLocation(), g.getScale()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Pareto) {
			Pareto pa = (Pareto) p;
			IntRandomVar intRdVar
				= new IntRandomVar("pareto", new ParetoDistribution(pa.getShape(), pa.getScale()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Poisson) {
			Poisson po = (Poisson) p;
			IntRandomVar intRdVar 
				= new IntRandomVar("poisson", new PoissonDistribution(po.getInterval()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof StudentsT) {
			StudentsT s = (StudentsT) p;
			IntRandomVar intRdVar
				= new IntRandomVar("studentst", new TDistribution((s.getDegreeOfFreedom().intValue())));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Uniform) {
			Uniform u = (Uniform) p;
			IntRandomVar intRdVar 
				= new IntRandomVar("uniform", new UniformDistribution(u.getMinimum(), u.getMaximum()));
			return intRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Weibull) {
			Weibull w = (Weibull) p;
			IntRandomVar intRdVar 
				= new IntRandomVar("weibull", new WeibullDistribution(w.getShape()));
			return intRdVar.dynamicIntRandomFunc();
		}
		return 0;
	}
	
	public static Object getNonNegativeIntFunc(Probability p) {
		Object o = getIntFunc(p);
		if((int) o >= 0) 
			return getIntFunc(p);
		else return 0;
	}
	
	public static Object getDoubleFunc(Probability p) {
		if (p instanceof Scalar) {
			Scalar s = (Scalar) p;
			return s.getValue();
		}
		else if (p instanceof Beta) {
			Beta b = (Beta) p;
			DoubleRandomVar dblRdVar 
				= new DoubleRandomVar("beta", new BetaDistribution(b.getFreedomDegreeA(), b.getFreedomDegreeB()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Binomial) {
			Binomial b = (Binomial) p;
			DoubleRandomVar dblRdVar 
				= new DoubleRandomVar("binomial", new BinomialDistribution(b.getNbrOfTrial(), b.getProbaOfSuccess()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Cauchy) {
			Cauchy c = (Cauchy) p;
			DoubleRandomVar dblRdVar 
				= new DoubleRandomVar("cauchy", new CauchyDistribution(c.getLocation(), c.getScale()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof ChiSquare) {
			ChiSquare cs = (ChiSquare) p;
			DoubleRandomVar dblRdVar
				= new DoubleRandomVar("chisqr", new ChiSqrDistribution(cs.getDegreeOfFreedom()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof DiracDelta) {
			DiracDelta dd = (DiracDelta) p;
			DoubleRandomVar dblRdVar 
				= new DoubleRandomVar("diracdelta", new DiracDeltaDistribution(dd.getMean()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Exponential) {
			Exponential e = (Exponential) p;
			DoubleRandomVar dblRdVar 
				= new DoubleRandomVar("exponential", new ExponentialDistribution(e.getScale()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof be.cetic.simqri.metamodel.FDistribution) {
			be.cetic.simqri.metamodel.FDistribution fd = (be.cetic.simqri.metamodel.FDistribution) p;
			DoubleRandomVar dblRdVar 
				= new DoubleRandomVar("fdistr", new FDistribution(fd.getFreedomDegreeA(), fd.getFreedomDegreeB()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Gamma) {
			Gamma g = (Gamma) p;
			DoubleRandomVar dblRdVar
				= new DoubleRandomVar("gamma", new GammaDistribution(g.getShape()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Geometric) {
			Geometric g = (Geometric) p;
			DoubleRandomVar dblRdVar 
				= new DoubleRandomVar("geometric", new GeometricDistribution(g.getProbaOfSuccess()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof LogNormal) {
			LogNormal ln = (LogNormal) p;
			DoubleRandomVar dblRdVar 
				= new DoubleRandomVar("lognormal", new LognormalDistribution(ln.getLocation(), ln.getScale()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Gaussian) { // = Normal
			Gaussian g = (Gaussian) p;
			DoubleRandomVar dblRdVar 
				= new DoubleRandomVar("normal", new NormalDistribution(g.getLocation(), g.getScale()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Pareto) {
			Pareto pa = (Pareto) p;
			DoubleRandomVar dblRdVar
				= new DoubleRandomVar("pareto", new ParetoDistribution(pa.getShape(), pa.getScale()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Poisson) {
			Poisson po = (Poisson) p;
			DoubleRandomVar dblRdVar 
				= new DoubleRandomVar("poisson", new PoissonDistribution(po.getInterval()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof StudentsT) {
			StudentsT s = (StudentsT) p;
			DoubleRandomVar dblRdVar
				= new DoubleRandomVar("studentst", new TDistribution((s.getDegreeOfFreedom().intValue())));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Uniform) {
			Uniform u = (Uniform) p;
			DoubleRandomVar dblRdVar 
				= new DoubleRandomVar("uniform", new UniformDistribution(u.getMinimum(), u.getMaximum()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		else if (p instanceof Weibull) {
			Weibull w = (Weibull) p;
			DoubleRandomVar dblRdVar 
				= new DoubleRandomVar("weibull", new WeibullDistribution(w.getShape()));
			return dblRdVar.dynamicIntRandomFunc();
		}
		return 0;
	}
	
	public static Object getNonNegativeDoubleFunc(Probability p) {
		Object o = getDoubleFunc(p);
		if((int) o >= 0) 
			return getDoubleFunc(p);
		else return 0;
	}
	
}

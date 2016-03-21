/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.providers;

import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;

import be.cetic.simqri.metamodel.parts.forms.BatchProcessPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.BetaPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.BinomialPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.CauchyPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.ChiSquarePropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.ConveyorBeltPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.DiracDeltaPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.ExponentialPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.FDistributionPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.GammaPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.GaussianPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.GeometricPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.LogNormalPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.ModelPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.OrderOnStockThresholdPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.OutputPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.ParetoPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.PoissonPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.ProcessOutputFlowPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.QueryPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.ScalarPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.StorageOutputFlowPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.StoragePropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.StudentsTPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.SupplierPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.UniformPropertiesEditionPartForm;
import be.cetic.simqri.metamodel.parts.forms.WeibullPropertiesEditionPartForm;

import be.cetic.simqri.metamodel.parts.impl.BatchProcessPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.BetaPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.BinomialPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.CauchyPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.ChiSquarePropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.ConveyorBeltPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.DiracDeltaPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.ExponentialPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.FDistributionPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.GammaPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.GaussianPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.GeometricPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.LogNormalPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.ModelPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.OrderOnStockThresholdPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.OutputPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.ParetoPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.PoissonPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.ProcessOutputFlowPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.QueryPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.ScalarPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.StorageOutputFlowPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.StoragePropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.StudentsTPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.SupplierPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.UniformPropertiesEditionPartImpl;
import be.cetic.simqri.metamodel.parts.impl.WeibullPropertiesEditionPartImpl;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

/**
 * 
 * 
 */
public class MetamodelPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == MetamodelViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == MetamodelViewsRepository.Model.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new ModelPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new ModelPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Query.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new QueryPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new QueryPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Storage.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new StoragePropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new StoragePropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Supplier.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new SupplierPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new SupplierPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.ConveyorBelt.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new ConveyorBeltPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new ConveyorBeltPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.BatchProcess.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new BatchProcessPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new BatchProcessPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Output.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new OutputPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new OutputPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.StorageOutputFlow.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new StorageOutputFlowPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new StorageOutputFlowPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.ProcessOutputFlow.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new ProcessOutputFlowPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new ProcessOutputFlowPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.OrderOnStockThreshold.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new OrderOnStockThresholdPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new OrderOnStockThresholdPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Cauchy.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new CauchyPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new CauchyPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Binomial.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new BinomialPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new BinomialPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Beta.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new BetaPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new BetaPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Scalar.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new ScalarPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new ScalarPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.ChiSquare.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new ChiSquarePropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new ChiSquarePropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.DiracDelta.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new DiracDeltaPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new DiracDeltaPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Exponential.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new ExponentialPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new ExponentialPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.FDistribution.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new FDistributionPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new FDistributionPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Gamma.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new GammaPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new GammaPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Geometric.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new GeometricPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new GeometricPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.LogNormal.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new LogNormalPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new LogNormalPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Gaussian.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new GaussianPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new GaussianPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Pareto.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new ParetoPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new ParetoPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Poisson.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new PoissonPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new PoissonPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.StudentsT.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new StudentsTPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new StudentsTPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Uniform.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new UniformPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new UniformPropertiesEditionPartForm(component);
		}
		if (key == MetamodelViewsRepository.Weibull.class) {
			if (kind == MetamodelViewsRepository.SWT_KIND)
				return new WeibullPropertiesEditionPartImpl(component);
			if (kind == MetamodelViewsRepository.FORM_KIND)
				return new WeibullPropertiesEditionPartForm(component);
		}
		return null;
	}

}

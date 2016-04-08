/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.components;

// Start of user code for imports
import be.cetic.simqri.metamodel.Binomial;
import be.cetic.simqri.metamodel.MetamodelPackage;

import be.cetic.simqri.metamodel.parts.BinomialPropertiesEditionPart;
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.sirius.eef.components.SiriusAwarePropertiesEditingComponent;


// End of user code

/**
 * 
 * 
 */
public class BinomialPropertiesEditionComponent extends SiriusAwarePropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public BinomialPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject binomial, String editing_mode) {
		super(editingContext, binomial, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MetamodelViewsRepository.class;
		partKey = MetamodelViewsRepository.Binomial.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final Binomial binomial = (Binomial)elt;
			final BinomialPropertiesEditionPart basePart = (BinomialPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(MetamodelViewsRepository.Binomial.Properties.nbrOfTrial))
				basePart.setNbrOfTrial(EEFConverterUtil.convertToString(MetamodelPackage.Literals.POSITIVE_INT_NOT_NULL, binomial.getNbrOfTrial()));
			
			if (isAccessible(MetamodelViewsRepository.Binomial.Properties.probaOfSuccess))
				basePart.setProbaOfSuccess(EEFConverterUtil.convertToString(MetamodelPackage.Literals.PROBA_DOUBLE, binomial.getProbaOfSuccess()));
			
			// init filters
			
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}





	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == MetamodelViewsRepository.Binomial.Properties.nbrOfTrial) {
			return MetamodelPackage.eINSTANCE.getBinomial_NbrOfTrial();
		}
		if (editorKey == MetamodelViewsRepository.Binomial.Properties.probaOfSuccess) {
			return MetamodelPackage.eINSTANCE.getBinomial_ProbaOfSuccess();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Binomial binomial = (Binomial)semanticObject;
		if (MetamodelViewsRepository.Binomial.Properties.nbrOfTrial == event.getAffectedEditor()) {
			binomial.setNbrOfTrial((java.lang.Integer)EEFConverterUtil.createFromString(MetamodelPackage.Literals.POSITIVE_INT_NOT_NULL, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.Binomial.Properties.probaOfSuccess == event.getAffectedEditor()) {
			binomial.setProbaOfSuccess((java.lang.Double)EEFConverterUtil.createFromString(MetamodelPackage.Literals.PROBA_DOUBLE, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			BinomialPropertiesEditionPart basePart = (BinomialPropertiesEditionPart)editingPart;
			if (MetamodelPackage.eINSTANCE.getBinomial_NbrOfTrial().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.Binomial.Properties.nbrOfTrial)) {
				if (msg.getNewValue() != null) {
					basePart.setNbrOfTrial(EcoreUtil.convertToString(MetamodelPackage.Literals.POSITIVE_INT_NOT_NULL, msg.getNewValue()));
				} else {
					basePart.setNbrOfTrial("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getBinomial_ProbaOfSuccess().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.Binomial.Properties.probaOfSuccess)) {
				if (msg.getNewValue() != null) {
					basePart.setProbaOfSuccess(EcoreUtil.convertToString(MetamodelPackage.Literals.PROBA_DOUBLE, msg.getNewValue()));
				} else {
					basePart.setProbaOfSuccess("");
				}
			}
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			MetamodelPackage.eINSTANCE.getBinomial_NbrOfTrial(),
			MetamodelPackage.eINSTANCE.getBinomial_ProbaOfSuccess()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (MetamodelViewsRepository.Binomial.Properties.nbrOfTrial == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getBinomial_NbrOfTrial().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getBinomial_NbrOfTrial().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.Binomial.Properties.probaOfSuccess == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getBinomial_ProbaOfSuccess().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getBinomial_ProbaOfSuccess().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}

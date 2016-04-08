/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.components;

// Start of user code for imports
import be.cetic.simqri.metamodel.Beta;
import be.cetic.simqri.metamodel.MetamodelPackage;

import be.cetic.simqri.metamodel.parts.BetaPropertiesEditionPart;
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
public class BetaPropertiesEditionComponent extends SiriusAwarePropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public BetaPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject beta, String editing_mode) {
		super(editingContext, beta, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MetamodelViewsRepository.class;
		partKey = MetamodelViewsRepository.Beta.class;
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
			
			final Beta beta = (Beta)elt;
			final BetaPropertiesEditionPart basePart = (BetaPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(MetamodelViewsRepository.Beta.Properties.freedomDegreeA))
				basePart.setFreedomDegreeA(EEFConverterUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE_NOT_NULL, beta.getFreedomDegreeA()));
			
			if (isAccessible(MetamodelViewsRepository.Beta.Properties.freedomDegreeB))
				basePart.setFreedomDegreeB(EEFConverterUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE_NOT_NULL, beta.getFreedomDegreeB()));
			
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
		if (editorKey == MetamodelViewsRepository.Beta.Properties.freedomDegreeA) {
			return MetamodelPackage.eINSTANCE.getBeta_FreedomDegreeA();
		}
		if (editorKey == MetamodelViewsRepository.Beta.Properties.freedomDegreeB) {
			return MetamodelPackage.eINSTANCE.getBeta_FreedomDegreeB();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Beta beta = (Beta)semanticObject;
		if (MetamodelViewsRepository.Beta.Properties.freedomDegreeA == event.getAffectedEditor()) {
			beta.setFreedomDegreeA((java.lang.Double)EEFConverterUtil.createFromString(MetamodelPackage.Literals.POSITIVE_DOUBLE_NOT_NULL, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.Beta.Properties.freedomDegreeB == event.getAffectedEditor()) {
			beta.setFreedomDegreeB((java.lang.Double)EEFConverterUtil.createFromString(MetamodelPackage.Literals.POSITIVE_DOUBLE_NOT_NULL, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			BetaPropertiesEditionPart basePart = (BetaPropertiesEditionPart)editingPart;
			if (MetamodelPackage.eINSTANCE.getBeta_FreedomDegreeA().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.Beta.Properties.freedomDegreeA)) {
				if (msg.getNewValue() != null) {
					basePart.setFreedomDegreeA(EcoreUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE_NOT_NULL, msg.getNewValue()));
				} else {
					basePart.setFreedomDegreeA("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getBeta_FreedomDegreeB().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.Beta.Properties.freedomDegreeB)) {
				if (msg.getNewValue() != null) {
					basePart.setFreedomDegreeB(EcoreUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE_NOT_NULL, msg.getNewValue()));
				} else {
					basePart.setFreedomDegreeB("");
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
			MetamodelPackage.eINSTANCE.getBeta_FreedomDegreeA(),
			MetamodelPackage.eINSTANCE.getBeta_FreedomDegreeB()		);
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
				if (MetamodelViewsRepository.Beta.Properties.freedomDegreeA == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getBeta_FreedomDegreeA().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getBeta_FreedomDegreeA().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.Beta.Properties.freedomDegreeB == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getBeta_FreedomDegreeB().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getBeta_FreedomDegreeB().getEAttributeType(), newValue);
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

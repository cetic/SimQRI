/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.components;

// Start of user code for imports
import be.cetic.simqri.metamodel.LogNormal;
import be.cetic.simqri.metamodel.MetamodelPackage;

import be.cetic.simqri.metamodel.parts.LogNormalPropertiesEditionPart;
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

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
public class LogNormalPropertiesEditionComponent extends SiriusAwarePropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public LogNormalPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject logNormal, String editing_mode) {
		super(editingContext, logNormal, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MetamodelViewsRepository.class;
		partKey = MetamodelViewsRepository.LogNormal.class;
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
			
			final LogNormal logNormal = (LogNormal)elt;
			final LogNormalPropertiesEditionPart basePart = (LogNormalPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(MetamodelViewsRepository.LogNormal.Properties.location)) {
				basePart.setLocation(EEFConverterUtil.convertToString(EcorePackage.Literals.EDOUBLE, logNormal.getLocation()));
			}
			
			if (isAccessible(MetamodelViewsRepository.LogNormal.Properties.scale))
				basePart.setScale(EEFConverterUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE_NOT_NULL, logNormal.getScale()));
			
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
		if (editorKey == MetamodelViewsRepository.LogNormal.Properties.location) {
			return MetamodelPackage.eINSTANCE.getLogNormal_Location();
		}
		if (editorKey == MetamodelViewsRepository.LogNormal.Properties.scale) {
			return MetamodelPackage.eINSTANCE.getLogNormal_Scale();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		LogNormal logNormal = (LogNormal)semanticObject;
		if (MetamodelViewsRepository.LogNormal.Properties.location == event.getAffectedEditor()) {
			logNormal.setLocation((EEFConverterUtil.createDoubleFromString(EcorePackage.Literals.EDOUBLE, (String)event.getNewValue())));
		}
		if (MetamodelViewsRepository.LogNormal.Properties.scale == event.getAffectedEditor()) {
			logNormal.setScale((java.lang.Double)EEFConverterUtil.createFromString(MetamodelPackage.Literals.POSITIVE_DOUBLE_NOT_NULL, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			LogNormalPropertiesEditionPart basePart = (LogNormalPropertiesEditionPart)editingPart;
			if (MetamodelPackage.eINSTANCE.getLogNormal_Location().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.LogNormal.Properties.location)) {
				if (msg.getNewValue() != null) {
					basePart.setLocation(EcoreUtil.convertToString(EcorePackage.Literals.EDOUBLE, msg.getNewValue()));
				} else {
					basePart.setLocation("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getLogNormal_Scale().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.LogNormal.Properties.scale)) {
				if (msg.getNewValue() != null) {
					basePart.setScale(EcoreUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE_NOT_NULL, msg.getNewValue()));
				} else {
					basePart.setScale("");
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
			MetamodelPackage.eINSTANCE.getLogNormal_Location(),
			MetamodelPackage.eINSTANCE.getLogNormal_Scale()		);
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
				if (MetamodelViewsRepository.LogNormal.Properties.location == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getLogNormal_Location().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getLogNormal_Location().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.LogNormal.Properties.scale == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getLogNormal_Scale().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getLogNormal_Scale().getEAttributeType(), newValue);
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

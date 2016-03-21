/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.components;

// Start of user code for imports
import be.cetic.simqri.metamodel.ConveyorBelt;
import be.cetic.simqri.metamodel.MetamodelPackage;

import be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart;
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

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.sirius.eef.components.SiriusAwarePropertiesEditingComponent;


// End of user code

/**
 * 
 * 
 */
public class ConveyorBeltPropertiesEditionComponent extends SiriusAwarePropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for output SingleCompositionEditor
	 */
	private EObjectFlatComboSettings outputSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ConveyorBeltPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject conveyorBelt, String editing_mode) {
		super(editingContext, conveyorBelt, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MetamodelViewsRepository.class;
		partKey = MetamodelViewsRepository.ConveyorBelt.class;
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
			
			final ConveyorBelt conveyorBelt = (ConveyorBelt)elt;
			final ConveyorBeltPropertiesEditionPart basePart = (ConveyorBeltPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(MetamodelViewsRepository.ConveyorBelt.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, conveyorBelt.getName()));
			
			if (isAccessible(MetamodelViewsRepository.ConveyorBelt.Properties.duration))
				basePart.setDuration(EEFConverterUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE, conveyorBelt.getDuration()));
			
			if (isAccessible(MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches))
				basePart.setMinimalSeparationBetweenBatches(EEFConverterUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE, conveyorBelt.getMinimalSeparationBetweenBatches()));
			
			if (isAccessible(MetamodelViewsRepository.ConveyorBelt.Properties.output)) {
				// init part
				outputSettings = new EObjectFlatComboSettings(conveyorBelt, MetamodelPackage.eINSTANCE.getConveyorBelt_Output());
				basePart.initOutput(outputSettings);
			}
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
		if (editorKey == MetamodelViewsRepository.ConveyorBelt.Properties.name) {
			return MetamodelPackage.eINSTANCE.getComponent_Name();
		}
		if (editorKey == MetamodelViewsRepository.ConveyorBelt.Properties.duration) {
			return MetamodelPackage.eINSTANCE.getProcess_Duration();
		}
		if (editorKey == MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches) {
			return MetamodelPackage.eINSTANCE.getConveyorBelt_MinimalSeparationBetweenBatches();
		}
		if (editorKey == MetamodelViewsRepository.ConveyorBelt.Properties.output) {
			return MetamodelPackage.eINSTANCE.getConveyorBelt_Output();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ConveyorBelt conveyorBelt = (ConveyorBelt)semanticObject;
		if (MetamodelViewsRepository.ConveyorBelt.Properties.name == event.getAffectedEditor()) {
			conveyorBelt.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.ConveyorBelt.Properties.duration == event.getAffectedEditor()) {
			conveyorBelt.setDuration((java.lang.Double)EEFConverterUtil.createFromString(MetamodelPackage.Literals.POSITIVE_DOUBLE, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches == event.getAffectedEditor()) {
			conveyorBelt.setMinimalSeparationBetweenBatches((java.lang.Double)EEFConverterUtil.createFromString(MetamodelPackage.Literals.POSITIVE_DOUBLE, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.ConveyorBelt.Properties.output == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.EDIT) {
				if (outputSettings.getValue() == "") {
					EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, outputSettings, editingContext.getAdapterFactory());
					PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(editingContext.getEObject(), PropertiesEditingProvider.class);
					Object result = null;
					if (provider != null) {
						PropertiesEditingPolicy policy = provider.getPolicy(context);
						if (policy instanceof CreateEditingPolicy) {
							policy.execute();
							result = ((CreateEditingPolicy) policy).getResult();
						}
					}
					if (result != null) {
						outputSettings.setToReference(result);
					}
				} else {
					EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) outputSettings.getValue(), editingContext.getAdapterFactory());
					PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(outputSettings.getValue(), PropertiesEditingProvider.class);
					if (provider != null) {
						PropertiesEditingPolicy policy = provider.getPolicy(context);
						if (policy != null) {
							policy.execute();
						}
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.UNSET) {
				outputSettings.setToReference(null);
			}
			
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			ConveyorBeltPropertiesEditionPart basePart = (ConveyorBeltPropertiesEditionPart)editingPart;
			if (MetamodelPackage.eINSTANCE.getComponent_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.ConveyorBelt.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getProcess_Duration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.ConveyorBelt.Properties.duration)) {
				if (msg.getNewValue() != null) {
					basePart.setDuration(EcoreUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE, msg.getNewValue()));
				} else {
					basePart.setDuration("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getConveyorBelt_MinimalSeparationBetweenBatches().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches)) {
				if (msg.getNewValue() != null) {
					basePart.setMinimalSeparationBetweenBatches(EcoreUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE, msg.getNewValue()));
				} else {
					basePart.setMinimalSeparationBetweenBatches("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getConveyorBelt_Output().equals(msg.getFeature()) && basePart != null && isAccessible(MetamodelViewsRepository.ConveyorBelt.Properties.output))
				basePart.setOutput((EObject)msg.getNewValue());
			
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
			MetamodelPackage.eINSTANCE.getComponent_Name(),
			MetamodelPackage.eINSTANCE.getProcess_Duration(),
			MetamodelPackage.eINSTANCE.getConveyorBelt_MinimalSeparationBetweenBatches(),
			MetamodelPackage.eINSTANCE.getConveyorBelt_Output()		);
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
				if (MetamodelViewsRepository.ConveyorBelt.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getComponent_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getComponent_Name().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.ConveyorBelt.Properties.duration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getProcess_Duration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getProcess_Duration().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getConveyorBelt_MinimalSeparationBetweenBatches().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getConveyorBelt_MinimalSeparationBetweenBatches().getEAttributeType(), newValue);
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

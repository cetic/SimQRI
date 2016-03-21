/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.components;

// Start of user code for imports
import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.Output;
import be.cetic.simqri.metamodel.OutputType;
import be.cetic.simqri.metamodel.ProcessOutputFlow;

import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.OutputPropertiesEditionPart;

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

import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.sirius.eef.components.SiriusAwarePropertiesEditingComponent;


// End of user code

/**
 * 
 * 
 */
public class OutputPropertiesEditionComponent extends SiriusAwarePropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for processOutputFlow ReferencesTable
	 */
	private ReferencesTableSettings processOutputFlowSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public OutputPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject output, String editing_mode) {
		super(editingContext, output, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MetamodelViewsRepository.class;
		partKey = MetamodelViewsRepository.Output.class;
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
			
			final Output output = (Output)elt;
			final OutputPropertiesEditionPart basePart = (OutputPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(MetamodelViewsRepository.Output.Properties.type)) {
				basePart.initType(EEFUtils.choiceOfValues(output, MetamodelPackage.eINSTANCE.getOutput_Type()), output.getType());
			}
			if (isAccessible(MetamodelViewsRepository.Output.Properties.processOutputFlow)) {
				processOutputFlowSettings = new ReferencesTableSettings(output, MetamodelPackage.eINSTANCE.getOutput_ProcessOutputFlow());
				basePart.initProcessOutputFlow(processOutputFlowSettings);
			}
			if (isAccessible(MetamodelViewsRepository.Output.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, output.getDescription()));
			
			// init filters
			
			if (isAccessible(MetamodelViewsRepository.Output.Properties.processOutputFlow)) {
				basePart.addFilterToProcessOutputFlow(new EObjectFilter(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW));
				// Start of user code for additional businessfilters for processOutputFlow
				// End of user code
			}
			
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
		if (editorKey == MetamodelViewsRepository.Output.Properties.type) {
			return MetamodelPackage.eINSTANCE.getOutput_Type();
		}
		if (editorKey == MetamodelViewsRepository.Output.Properties.processOutputFlow) {
			return MetamodelPackage.eINSTANCE.getOutput_ProcessOutputFlow();
		}
		if (editorKey == MetamodelViewsRepository.Output.Properties.description) {
			return MetamodelPackage.eINSTANCE.getOutput_Description();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Output output = (Output)semanticObject;
		if (MetamodelViewsRepository.Output.Properties.type == event.getAffectedEditor()) {
			output.setType((OutputType)event.getNewValue());
		}
		if (MetamodelViewsRepository.Output.Properties.processOutputFlow == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof ProcessOutputFlow) {
					processOutputFlowSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				processOutputFlowSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				processOutputFlowSettings.move(event.getNewIndex(), (ProcessOutputFlow) event.getNewValue());
			}
		}
		if (MetamodelViewsRepository.Output.Properties.description == event.getAffectedEditor()) {
			output.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			OutputPropertiesEditionPart basePart = (OutputPropertiesEditionPart)editingPart;
			if (MetamodelPackage.eINSTANCE.getOutput_Type().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(MetamodelViewsRepository.Output.Properties.type))
				basePart.setType((OutputType)msg.getNewValue());
			
			if (MetamodelPackage.eINSTANCE.getOutput_ProcessOutputFlow().equals(msg.getFeature())  && isAccessible(MetamodelViewsRepository.Output.Properties.processOutputFlow))
				basePart.updateProcessOutputFlow();
			if (MetamodelPackage.eINSTANCE.getOutput_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.Output.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
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
			MetamodelPackage.eINSTANCE.getOutput_Type(),
			MetamodelPackage.eINSTANCE.getOutput_ProcessOutputFlow(),
			MetamodelPackage.eINSTANCE.getOutput_Description()		);
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
				if (MetamodelViewsRepository.Output.Properties.type == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getOutput_Type().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getOutput_Type().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.Output.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getOutput_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getOutput_Description().getEAttributeType(), newValue);
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

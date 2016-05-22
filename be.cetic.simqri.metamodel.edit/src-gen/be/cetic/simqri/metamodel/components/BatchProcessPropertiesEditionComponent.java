/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.components;

// Start of user code for imports
import be.cetic.simqri.metamodel.BatchProcess;
import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.Output;
import be.cetic.simqri.metamodel.StorageOutputFlow;
import be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart;
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
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.sirius.eef.components.SiriusAwarePropertiesEditingComponent;


// End of user code

/**
 * 
 * 
 */
public class BatchProcessPropertiesEditionComponent extends SiriusAwarePropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for duration SingleCompositionEditor
	 */
	private EObjectFlatComboSettings durationSettings;
	
	/**
	 * Settings for storageOutputFlow ReferencesTable
	 */
	private ReferencesTableSettings storageOutputFlowSettings;
	
	/**
	 * Settings for outputs ReferencesTable
	 */
	protected ReferencesTableSettings outputsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public BatchProcessPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject batchProcess, String editing_mode) {
		super(editingContext, batchProcess, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MetamodelViewsRepository.class;
		partKey = MetamodelViewsRepository.BatchProcess.class;
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
			
			final BatchProcess batchProcess = (BatchProcess)elt;
			final BatchProcessPropertiesEditionPart basePart = (BatchProcessPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(MetamodelViewsRepository.BatchProcess.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, batchProcess.getName()));
			
			if (isAccessible(MetamodelViewsRepository.BatchProcess.Properties.duration)) {
				// init part
				durationSettings = new EObjectFlatComboSettings(batchProcess, MetamodelPackage.eINSTANCE.getProcess_Duration());
				basePart.initDuration(durationSettings);
			}
			if (isAccessible(MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow)) {
				storageOutputFlowSettings = new ReferencesTableSettings(batchProcess, MetamodelPackage.eINSTANCE.getProcess_StorageOutputFlow());
				basePart.initStorageOutputFlow(storageOutputFlowSettings);
			}
			if (isAccessible(MetamodelViewsRepository.BatchProcess.Properties.percentageOfSuccess))
				basePart.setPercentageOfSuccess(EEFConverterUtil.convertToString(MetamodelPackage.Literals.PERCENT, batchProcess.getPercentageOfSuccess()));
			
			if (isAccessible(MetamodelViewsRepository.BatchProcess.Properties.numberOfLines))
				basePart.setNumberOfLines(EEFConverterUtil.convertToString(MetamodelPackage.Literals.POSITIVE_INT_NOT_NULL, batchProcess.getNumberOfChains()));
			
			if (isAccessible(MetamodelViewsRepository.BatchProcess.Properties.outputs)) {
				outputsSettings = new ReferencesTableSettings(batchProcess, MetamodelPackage.eINSTANCE.getBatchProcess_Outputs());
				basePart.initOutputs(outputsSettings);
			}
			// init filters
			
			
			if (isAccessible(MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow)) {
				basePart.addFilterToStorageOutputFlow(new EObjectFilter(MetamodelPackage.Literals.STORAGE_OUTPUT_FLOW));
				// Start of user code for additional businessfilters for storageOutputFlow
				// End of user code
			}
			
			
			if (isAccessible(MetamodelViewsRepository.BatchProcess.Properties.outputs)) {
				basePart.addFilterToOutputs(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Output); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for outputs
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
		if (editorKey == MetamodelViewsRepository.BatchProcess.Properties.name) {
			return MetamodelPackage.eINSTANCE.getComponent_Name();
		}
		if (editorKey == MetamodelViewsRepository.BatchProcess.Properties.duration) {
			return MetamodelPackage.eINSTANCE.getProcess_Duration();
		}
		if (editorKey == MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow) {
			return MetamodelPackage.eINSTANCE.getProcess_StorageOutputFlow();
		}
		if (editorKey == MetamodelViewsRepository.BatchProcess.Properties.percentageOfSuccess) {
			return MetamodelPackage.eINSTANCE.getBatchProcess_PercentageOfSuccess();
		}
		if (editorKey == MetamodelViewsRepository.BatchProcess.Properties.numberOfLines) {
			return MetamodelPackage.eINSTANCE.getBatchProcess_NumberOfChains();
		}
		if (editorKey == MetamodelViewsRepository.BatchProcess.Properties.outputs) {
			return MetamodelPackage.eINSTANCE.getBatchProcess_Outputs();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		BatchProcess batchProcess = (BatchProcess)semanticObject;
		if (MetamodelViewsRepository.BatchProcess.Properties.name == event.getAffectedEditor()) {
			batchProcess.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.BatchProcess.Properties.duration == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.EDIT) {
				if (durationSettings.getValue() == "") {
					EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, durationSettings, editingContext.getAdapterFactory());
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
						durationSettings.setToReference(result);
					}
				} else {
					EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) durationSettings.getValue(), editingContext.getAdapterFactory());
					PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(durationSettings.getValue(), PropertiesEditingProvider.class);
					if (provider != null) {
						PropertiesEditingPolicy policy = provider.getPolicy(context);
						if (policy != null) {
							policy.execute();
						}
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.UNSET) {
				durationSettings.setToReference(null);
			}
			
		}
		if (MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof StorageOutputFlow) {
					storageOutputFlowSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				storageOutputFlowSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				storageOutputFlowSettings.move(event.getNewIndex(), (StorageOutputFlow) event.getNewValue());
			}
		}
		if (MetamodelViewsRepository.BatchProcess.Properties.percentageOfSuccess == event.getAffectedEditor()) {
			batchProcess.setPercentageOfSuccess((java.lang.Double)EEFConverterUtil.createFromString(MetamodelPackage.Literals.PERCENT, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.BatchProcess.Properties.numberOfLines == event.getAffectedEditor()) {
			batchProcess.setNumberOfChains((java.lang.Integer)EEFConverterUtil.createFromString(MetamodelPackage.Literals.POSITIVE_INT_NOT_NULL, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.BatchProcess.Properties.outputs == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, outputsSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				outputsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				outputsSettings.move(event.getNewIndex(), (Output) event.getNewValue());
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
			BatchProcessPropertiesEditionPart basePart = (BatchProcessPropertiesEditionPart)editingPart;
			if (MetamodelPackage.eINSTANCE.getComponent_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.BatchProcess.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getProcess_Duration().equals(msg.getFeature()) && basePart != null && isAccessible(MetamodelViewsRepository.BatchProcess.Properties.duration))
				basePart.setDuration((EObject)msg.getNewValue());
			if (MetamodelPackage.eINSTANCE.getProcess_StorageOutputFlow().equals(msg.getFeature())  && isAccessible(MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow))
				basePart.updateStorageOutputFlow();
			if (MetamodelPackage.eINSTANCE.getBatchProcess_PercentageOfSuccess().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.BatchProcess.Properties.percentageOfSuccess)) {
				if (msg.getNewValue() != null) {
					basePart.setPercentageOfSuccess(EcoreUtil.convertToString(MetamodelPackage.Literals.PERCENT, msg.getNewValue()));
				} else {
					basePart.setPercentageOfSuccess("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getBatchProcess_NumberOfChains().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.BatchProcess.Properties.numberOfLines)) {
				if (msg.getNewValue() != null) {
					basePart.setNumberOfLines(EcoreUtil.convertToString(MetamodelPackage.Literals.POSITIVE_INT_NOT_NULL, msg.getNewValue()));
				} else {
					basePart.setNumberOfLines("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getBatchProcess_Outputs().equals(msg.getFeature()) && isAccessible(MetamodelViewsRepository.BatchProcess.Properties.outputs))
				basePart.updateOutputs();
			
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
			MetamodelPackage.eINSTANCE.getProcess_StorageOutputFlow(),
			MetamodelPackage.eINSTANCE.getBatchProcess_PercentageOfSuccess(),
			MetamodelPackage.eINSTANCE.getBatchProcess_NumberOfChains(),
			MetamodelPackage.eINSTANCE.getBatchProcess_Outputs()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == MetamodelViewsRepository.BatchProcess.Properties.duration;
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
				if (MetamodelViewsRepository.BatchProcess.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getComponent_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getComponent_Name().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.BatchProcess.Properties.percentageOfSuccess == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getBatchProcess_PercentageOfSuccess().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getBatchProcess_PercentageOfSuccess().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.BatchProcess.Properties.numberOfLines == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getBatchProcess_NumberOfChains().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getBatchProcess_NumberOfChains().getEAttributeType(), newValue);
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

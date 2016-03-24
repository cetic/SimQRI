/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.components;

// Start of user code for imports
import be.cetic.simqri.metamodel.MetamodelFactory;

import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.Output;
import be.cetic.simqri.metamodel.ProcessOutputFlow;
import be.cetic.simqri.metamodel.Storage;

import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;


import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.sirius.eef.components.SiriusAwarePropertiesEditingComponent;


// End of user code

/**
 * 
 * 
 */
public class ProcessOutputFlowPropertiesEditionComponent extends SiriusAwarePropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for source EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings sourceSettings;
	
	/**
	 * Settings for destination EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings destinationSettings;
	
	/**
	 * Settings for quantity SingleCompositionEditor
	 */
	private EObjectFlatComboSettings quantitySettings;
	
	/**
	 * Settings for processOutputFlowDelay SingleCompositionEditor
	 */
	private EObjectFlatComboSettings processOutputFlowDelaySettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ProcessOutputFlowPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject processOutputFlow, String editing_mode) {
		super(editingContext, processOutputFlow, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MetamodelViewsRepository.class;
		partKey = MetamodelViewsRepository.ProcessOutputFlow.class;
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
			
			final ProcessOutputFlow processOutputFlow = (ProcessOutputFlow)elt;
			final ProcessOutputFlowPropertiesEditionPart basePart = (ProcessOutputFlowPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(MetamodelViewsRepository.ProcessOutputFlow.Properties.source)) {
				// init part
				sourceSettings = new EObjectFlatComboSettings(processOutputFlow, MetamodelPackage.eINSTANCE.getProcessOutputFlow_Source());
				basePart.initSource(sourceSettings);
				// set the button mode
				basePart.setSourceButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(MetamodelViewsRepository.ProcessOutputFlow.Properties.destination)) {
				// init part
				destinationSettings = new EObjectFlatComboSettings(processOutputFlow, MetamodelPackage.eINSTANCE.getProcessOutputFlow_Destination());
				basePart.initDestination(destinationSettings);
				// set the button mode
				basePart.setDestinationButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity)) {
				// init part
				quantitySettings = new EObjectFlatComboSettings(processOutputFlow, MetamodelPackage.eINSTANCE.getFlow_Quantity());
				basePart.initQuantity(quantitySettings);
			}
			if (isAccessible(MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay)) {
				// init part
				processOutputFlowDelaySettings = new EObjectFlatComboSettings(processOutputFlow, MetamodelPackage.eINSTANCE.getProcessOutputFlow_ProcessOutputFlowDelay());
				basePart.initProcessOutputFlowDelay(processOutputFlowDelaySettings);
			}
			// init filters
			if (isAccessible(MetamodelViewsRepository.ProcessOutputFlow.Properties.source)) {
				basePart.addFilterToSource(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Output);
					}
					
				});
				// Start of user code for additional businessfilters for source
				// End of user code
			}
			if (isAccessible(MetamodelViewsRepository.ProcessOutputFlow.Properties.destination)) {
				basePart.addFilterToDestination(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Storage);
					}
					
				});
				// Start of user code for additional businessfilters for destination
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
		if (editorKey == MetamodelViewsRepository.ProcessOutputFlow.Properties.source) {
			return MetamodelPackage.eINSTANCE.getProcessOutputFlow_Source();
		}
		if (editorKey == MetamodelViewsRepository.ProcessOutputFlow.Properties.destination) {
			return MetamodelPackage.eINSTANCE.getProcessOutputFlow_Destination();
		}
		if (editorKey == MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity) {
			return MetamodelPackage.eINSTANCE.getFlow_Quantity();
		}
		if (editorKey == MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay) {
			return MetamodelPackage.eINSTANCE.getProcessOutputFlow_ProcessOutputFlowDelay();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	@SuppressWarnings("unused")
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ProcessOutputFlow processOutputFlow = (ProcessOutputFlow)semanticObject;
		if (MetamodelViewsRepository.ProcessOutputFlow.Properties.source == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				sourceSettings.setToReference((Output)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Output eObject = MetamodelFactory.eINSTANCE.createOutput();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				sourceSettings.setToReference(eObject);
			}
		}
		if (MetamodelViewsRepository.ProcessOutputFlow.Properties.destination == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				destinationSettings.setToReference((Storage)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Storage eObject = MetamodelFactory.eINSTANCE.createStorage();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				destinationSettings.setToReference(eObject);
			}
		}
		if (MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.EDIT) {
				if (quantitySettings.getValue() == "") {
					EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, quantitySettings, editingContext.getAdapterFactory());
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
						quantitySettings.setToReference(result);
					}
				} else {
					EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) quantitySettings.getValue(), editingContext.getAdapterFactory());
					PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(quantitySettings.getValue(), PropertiesEditingProvider.class);
					if (provider != null) {
						PropertiesEditingPolicy policy = provider.getPolicy(context);
						if (policy != null) {
							policy.execute();
						}
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.UNSET) {
				quantitySettings.setToReference(null);
			}
			
		}
		if (MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.EDIT) {
				if (processOutputFlowDelaySettings.getValue() == "") {
					EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, processOutputFlowDelaySettings, editingContext.getAdapterFactory());
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
						processOutputFlowDelaySettings.setToReference(result);
					}
				} else {
					EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) processOutputFlowDelaySettings.getValue(), editingContext.getAdapterFactory());
					PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(processOutputFlowDelaySettings.getValue(), PropertiesEditingProvider.class);
					if (provider != null) {
						PropertiesEditingPolicy policy = provider.getPolicy(context);
						if (policy != null) {
							policy.execute();
						}
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.UNSET) {
				processOutputFlowDelaySettings.setToReference(null);
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
			ProcessOutputFlowPropertiesEditionPart basePart = (ProcessOutputFlowPropertiesEditionPart)editingPart;
			if (MetamodelPackage.eINSTANCE.getProcessOutputFlow_Source().equals(msg.getFeature()) && basePart != null && isAccessible(MetamodelViewsRepository.ProcessOutputFlow.Properties.source))
				basePart.setSource((EObject)msg.getNewValue());
			if (MetamodelPackage.eINSTANCE.getProcessOutputFlow_Destination().equals(msg.getFeature()) && basePart != null && isAccessible(MetamodelViewsRepository.ProcessOutputFlow.Properties.destination))
				basePart.setDestination((EObject)msg.getNewValue());
			if (MetamodelPackage.eINSTANCE.getFlow_Quantity().equals(msg.getFeature()) && basePart != null && isAccessible(MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity))
				basePart.setQuantity((EObject)msg.getNewValue());
			if (MetamodelPackage.eINSTANCE.getProcessOutputFlow_ProcessOutputFlowDelay().equals(msg.getFeature()) && basePart != null && isAccessible(MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay))
				basePart.setProcessOutputFlowDelay((EObject)msg.getNewValue());
			
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
			MetamodelPackage.eINSTANCE.getProcessOutputFlow_Source(),
			MetamodelPackage.eINSTANCE.getProcessOutputFlow_Destination(),
			MetamodelPackage.eINSTANCE.getFlow_Quantity(),
			MetamodelPackage.eINSTANCE.getProcessOutputFlow_ProcessOutputFlowDelay()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == MetamodelViewsRepository.ProcessOutputFlow.Properties.source || key == MetamodelViewsRepository.ProcessOutputFlow.Properties.destination || key == MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity || key == MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay;
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
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}

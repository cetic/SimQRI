/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.components;

// Start of user code for imports
import be.cetic.simqri.metamodel.MetamodelFactory;

import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.Storage;
import be.cetic.simqri.metamodel.StorageOutputFlow;

import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart;

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
public class StorageOutputFlowPropertiesEditionComponent extends SiriusAwarePropertiesEditingComponent {

	
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
	 * Default constructor
	 * 
	 */
	public StorageOutputFlowPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject storageOutputFlow, String editing_mode) {
		super(editingContext, storageOutputFlow, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MetamodelViewsRepository.class;
		partKey = MetamodelViewsRepository.StorageOutputFlow.class;
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
			
			final StorageOutputFlow storageOutputFlow = (StorageOutputFlow)elt;
			final StorageOutputFlowPropertiesEditionPart basePart = (StorageOutputFlowPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(MetamodelViewsRepository.StorageOutputFlow.Properties.source)) {
				// init part
				sourceSettings = new EObjectFlatComboSettings(storageOutputFlow, MetamodelPackage.eINSTANCE.getStorageOutputFlow_Source());
				basePart.initSource(sourceSettings);
				// set the button mode
				basePart.setSourceButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(MetamodelViewsRepository.StorageOutputFlow.Properties.destination)) {
				// init part
				destinationSettings = new EObjectFlatComboSettings(storageOutputFlow, MetamodelPackage.eINSTANCE.getStorageOutputFlow_Destination());
				basePart.initDestination(destinationSettings);
				// set the button mode
				basePart.setDestinationButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(MetamodelViewsRepository.StorageOutputFlow.Properties.quantity)) {
				// init part
				quantitySettings = new EObjectFlatComboSettings(storageOutputFlow, MetamodelPackage.eINSTANCE.getFlow_Quantity());
				basePart.initQuantity(quantitySettings);
			}
			// init filters
			if (isAccessible(MetamodelViewsRepository.StorageOutputFlow.Properties.source)) {
				basePart.addFilterToSource(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Storage);
					}
					
				});
				// Start of user code for additional businessfilters for source
				// End of user code
			}
			if (isAccessible(MetamodelViewsRepository.StorageOutputFlow.Properties.destination)) {
				basePart.addFilterToDestination(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Process);
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
		if (editorKey == MetamodelViewsRepository.StorageOutputFlow.Properties.source) {
			return MetamodelPackage.eINSTANCE.getStorageOutputFlow_Source();
		}
		if (editorKey == MetamodelViewsRepository.StorageOutputFlow.Properties.destination) {
			return MetamodelPackage.eINSTANCE.getStorageOutputFlow_Destination();
		}
		if (editorKey == MetamodelViewsRepository.StorageOutputFlow.Properties.quantity) {
			return MetamodelPackage.eINSTANCE.getFlow_Quantity();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		@SuppressWarnings("unused")
		StorageOutputFlow storageOutputFlow = (StorageOutputFlow)semanticObject;
		if (MetamodelViewsRepository.StorageOutputFlow.Properties.source == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				sourceSettings.setToReference((Storage)event.getNewValue());
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
				sourceSettings.setToReference(eObject);
			}
		}
		if (MetamodelViewsRepository.StorageOutputFlow.Properties.destination == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				destinationSettings.setToReference((Process)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, destinationSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
		if (MetamodelViewsRepository.StorageOutputFlow.Properties.quantity == event.getAffectedEditor()) {
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
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			StorageOutputFlowPropertiesEditionPart basePart = (StorageOutputFlowPropertiesEditionPart)editingPart;
			if (MetamodelPackage.eINSTANCE.getStorageOutputFlow_Source().equals(msg.getFeature()) && basePart != null && isAccessible(MetamodelViewsRepository.StorageOutputFlow.Properties.source))
				basePart.setSource((EObject)msg.getNewValue());
			if (MetamodelPackage.eINSTANCE.getStorageOutputFlow_Destination().equals(msg.getFeature()) && basePart != null && isAccessible(MetamodelViewsRepository.StorageOutputFlow.Properties.destination))
				basePart.setDestination((EObject)msg.getNewValue());
			if (MetamodelPackage.eINSTANCE.getFlow_Quantity().equals(msg.getFeature()) && basePart != null && isAccessible(MetamodelViewsRepository.StorageOutputFlow.Properties.quantity))
				basePart.setQuantity((EObject)msg.getNewValue());
			
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
			MetamodelPackage.eINSTANCE.getStorageOutputFlow_Source(),
			MetamodelPackage.eINSTANCE.getStorageOutputFlow_Destination(),
			MetamodelPackage.eINSTANCE.getFlow_Quantity()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == MetamodelViewsRepository.StorageOutputFlow.Properties.source || key == MetamodelViewsRepository.StorageOutputFlow.Properties.destination || key == MetamodelViewsRepository.StorageOutputFlow.Properties.quantity;
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

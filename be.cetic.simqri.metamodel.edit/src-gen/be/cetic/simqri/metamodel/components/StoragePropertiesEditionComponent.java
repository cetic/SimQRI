/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.components;

// Start of user code for imports
import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.OrderOnStockThreshold;
import be.cetic.simqri.metamodel.ProcessOutputFlow;
import be.cetic.simqri.metamodel.Storage;
import be.cetic.simqri.metamodel.StorageOutputFlow;

import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart;

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

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.sirius.eef.components.SiriusAwarePropertiesEditingComponent;


// End of user code

/**
 * 
 * 
 */
public class StoragePropertiesEditionComponent extends SiriusAwarePropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for storageOutputFlow ReferencesTable
	 */
	private ReferencesTableSettings storageOutputFlowSettings;
	
	/**
	 * Settings for orderOnStockThreshold ReferencesTable
	 */
	private ReferencesTableSettings orderOnStockThresholdSettings;
	
	/**
	 * Settings for processOutputFlow ReferencesTable
	 */
	private ReferencesTableSettings processOutputFlowSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public StoragePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject storage, String editing_mode) {
		super(editingContext, storage, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MetamodelViewsRepository.class;
		partKey = MetamodelViewsRepository.Storage.class;
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
			
			final Storage storage = (Storage)elt;
			final StoragePropertiesEditionPart basePart = (StoragePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(MetamodelViewsRepository.Storage.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, storage.getName()));
			
			if (isAccessible(MetamodelViewsRepository.Storage.Properties.size))
				basePart.setSize(EEFConverterUtil.convertToString(MetamodelPackage.Literals.POSITIVE_INT_NOT_NULL, storage.getSize()));
			
			if (isAccessible(MetamodelViewsRepository.Storage.Properties.initialContent))
				basePart.setInitialContent(EEFConverterUtil.convertToString(MetamodelPackage.Literals.POSITIVE_INT, storage.getInitialContent()));
			
			if (isAccessible(MetamodelViewsRepository.Storage.Properties.overflow)) {
				basePart.setOverflow(storage.isOverflow());
			}
			if (isAccessible(MetamodelViewsRepository.Storage.Properties.storageOutputFlow)) {
				storageOutputFlowSettings = new ReferencesTableSettings(storage, MetamodelPackage.eINSTANCE.getStorage_StorageOutputFlow());
				basePart.initStorageOutputFlow(storageOutputFlowSettings);
			}
			if (isAccessible(MetamodelViewsRepository.Storage.Properties.orderOnStockThreshold)) {
				orderOnStockThresholdSettings = new ReferencesTableSettings(storage, MetamodelPackage.eINSTANCE.getStorage_OrderOnStockThreshold());
				basePart.initOrderOnStockThreshold(orderOnStockThresholdSettings);
			}
			if (isAccessible(MetamodelViewsRepository.Storage.Properties.processOutputFlow)) {
				processOutputFlowSettings = new ReferencesTableSettings(storage, MetamodelPackage.eINSTANCE.getStorage_ProcessOutputFlow());
				basePart.initProcessOutputFlow(processOutputFlowSettings);
			}
			// init filters
			
			
			
			
			if (isAccessible(MetamodelViewsRepository.Storage.Properties.storageOutputFlow)) {
				basePart.addFilterToStorageOutputFlow(new EObjectFilter(MetamodelPackage.Literals.STORAGE_OUTPUT_FLOW));
				// Start of user code for additional businessfilters for storageOutputFlow
				// End of user code
			}
			if (isAccessible(MetamodelViewsRepository.Storage.Properties.orderOnStockThreshold)) {
				basePart.addFilterToOrderOnStockThreshold(new EObjectFilter(MetamodelPackage.Literals.ORDER_ON_STOCK_THRESHOLD));
				// Start of user code for additional businessfilters for orderOnStockThreshold
				// End of user code
			}
			if (isAccessible(MetamodelViewsRepository.Storage.Properties.processOutputFlow)) {
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
		if (editorKey == MetamodelViewsRepository.Storage.Properties.name) {
			return MetamodelPackage.eINSTANCE.getComponent_Name();
		}
		if (editorKey == MetamodelViewsRepository.Storage.Properties.size) {
			return MetamodelPackage.eINSTANCE.getStorage_Size();
		}
		if (editorKey == MetamodelViewsRepository.Storage.Properties.initialContent) {
			return MetamodelPackage.eINSTANCE.getStorage_InitialContent();
		}
		if (editorKey == MetamodelViewsRepository.Storage.Properties.overflow) {
			return MetamodelPackage.eINSTANCE.getStorage_Overflow();
		}
		if (editorKey == MetamodelViewsRepository.Storage.Properties.storageOutputFlow) {
			return MetamodelPackage.eINSTANCE.getStorage_StorageOutputFlow();
		}
		if (editorKey == MetamodelViewsRepository.Storage.Properties.orderOnStockThreshold) {
			return MetamodelPackage.eINSTANCE.getStorage_OrderOnStockThreshold();
		}
		if (editorKey == MetamodelViewsRepository.Storage.Properties.processOutputFlow) {
			return MetamodelPackage.eINSTANCE.getStorage_ProcessOutputFlow();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Storage storage = (Storage)semanticObject;
		if (MetamodelViewsRepository.Storage.Properties.name == event.getAffectedEditor()) {
			storage.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.Storage.Properties.size == event.getAffectedEditor()) {
			storage.setSize((java.lang.Integer)EEFConverterUtil.createFromString(MetamodelPackage.Literals.POSITIVE_INT_NOT_NULL, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.Storage.Properties.initialContent == event.getAffectedEditor()) {
			storage.setInitialContent((java.lang.Integer)EEFConverterUtil.createFromString(MetamodelPackage.Literals.POSITIVE_INT, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.Storage.Properties.overflow == event.getAffectedEditor()) {
			storage.setOverflow((Boolean)event.getNewValue());
		}
		if (MetamodelViewsRepository.Storage.Properties.storageOutputFlow == event.getAffectedEditor()) {
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
		if (MetamodelViewsRepository.Storage.Properties.orderOnStockThreshold == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof OrderOnStockThreshold) {
					orderOnStockThresholdSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				orderOnStockThresholdSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				orderOnStockThresholdSettings.move(event.getNewIndex(), (OrderOnStockThreshold) event.getNewValue());
			}
		}
		if (MetamodelViewsRepository.Storage.Properties.processOutputFlow == event.getAffectedEditor()) {
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
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			StoragePropertiesEditionPart basePart = (StoragePropertiesEditionPart)editingPart;
			if (MetamodelPackage.eINSTANCE.getComponent_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.Storage.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getStorage_Size().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.Storage.Properties.size)) {
				if (msg.getNewValue() != null) {
					basePart.setSize(EcoreUtil.convertToString(MetamodelPackage.Literals.POSITIVE_INT_NOT_NULL, msg.getNewValue()));
				} else {
					basePart.setSize("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getStorage_InitialContent().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.Storage.Properties.initialContent)) {
				if (msg.getNewValue() != null) {
					basePart.setInitialContent(EcoreUtil.convertToString(MetamodelPackage.Literals.POSITIVE_INT, msg.getNewValue()));
				} else {
					basePart.setInitialContent("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getStorage_Overflow().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.Storage.Properties.overflow))
				basePart.setOverflow((Boolean)msg.getNewValue());
			
			if (MetamodelPackage.eINSTANCE.getStorage_StorageOutputFlow().equals(msg.getFeature())  && isAccessible(MetamodelViewsRepository.Storage.Properties.storageOutputFlow))
				basePart.updateStorageOutputFlow();
			if (MetamodelPackage.eINSTANCE.getStorage_OrderOnStockThreshold().equals(msg.getFeature())  && isAccessible(MetamodelViewsRepository.Storage.Properties.orderOnStockThreshold))
				basePart.updateOrderOnStockThreshold();
			if (MetamodelPackage.eINSTANCE.getStorage_ProcessOutputFlow().equals(msg.getFeature())  && isAccessible(MetamodelViewsRepository.Storage.Properties.processOutputFlow))
				basePart.updateProcessOutputFlow();
			
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
			MetamodelPackage.eINSTANCE.getStorage_Size(),
			MetamodelPackage.eINSTANCE.getStorage_InitialContent(),
			MetamodelPackage.eINSTANCE.getStorage_Overflow(),
			MetamodelPackage.eINSTANCE.getStorage_StorageOutputFlow(),
			MetamodelPackage.eINSTANCE.getStorage_OrderOnStockThreshold(),
			MetamodelPackage.eINSTANCE.getStorage_ProcessOutputFlow()		);
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
				if (MetamodelViewsRepository.Storage.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getComponent_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getComponent_Name().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.Storage.Properties.size == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getStorage_Size().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getStorage_Size().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.Storage.Properties.initialContent == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getStorage_InitialContent().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getStorage_InitialContent().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.Storage.Properties.overflow == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getStorage_Overflow().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getStorage_Overflow().getEAttributeType(), newValue);
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

/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.components;

// Start of user code for imports
import be.cetic.simqri.metamodel.MetamodelFactory;
import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.OrderOnStockThreshold;
import be.cetic.simqri.metamodel.OrderType;
import be.cetic.simqri.metamodel.Storage;
import be.cetic.simqri.metamodel.Supplier;

import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart;

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

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

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
public class OrderOnStockThresholdPropertiesEditionComponent extends SiriusAwarePropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for supplier EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings supplierSettings;
	
	/**
	 * Settings for storage EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings storageSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public OrderOnStockThresholdPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject orderOnStockThreshold, String editing_mode) {
		super(editingContext, orderOnStockThreshold, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MetamodelViewsRepository.class;
		partKey = MetamodelViewsRepository.OrderOnStockThreshold.class;
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
			
			final OrderOnStockThreshold orderOnStockThreshold = (OrderOnStockThreshold)elt;
			final OrderOnStockThresholdPropertiesEditionPart basePart = (OrderOnStockThresholdPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.period))
				basePart.setPeriod(EEFConverterUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE, orderOnStockThreshold.getPeriod()));
			
			if (isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold))
				basePart.setThreshold(EEFConverterUtil.convertToString(MetamodelPackage.Literals.POSITIVE_INT, orderOnStockThreshold.getThreshold()));
			
			if (isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, orderOnStockThreshold.getName()));
			
			if (isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity))
				basePart.setOrderQuantity(EEFConverterUtil.convertToString(MetamodelPackage.Literals.POSITIVE_INT, orderOnStockThreshold.getOrderQuantity()));
			
			if (isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderType)) {
				basePart.initOrderType(EEFUtils.choiceOfValues(orderOnStockThreshold, MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_OrderType()), orderOnStockThreshold.getOrderType());
			}
			if (isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier)) {
				// init part
				supplierSettings = new EObjectFlatComboSettings(orderOnStockThreshold, MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Supplier());
				basePart.initSupplier(supplierSettings);
				// set the button mode
				basePart.setSupplierButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage)) {
				// init part
				storageSettings = new EObjectFlatComboSettings(orderOnStockThreshold, MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Storage());
				basePart.initStorage(storageSettings);
				// set the button mode
				basePart.setStorageButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			
			
			
			
			if (isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier)) {
				basePart.addFilterToSupplier(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Supplier);
					}
					
				});
				// Start of user code for additional businessfilters for supplier
				// End of user code
			}
			if (isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage)) {
				basePart.addFilterToStorage(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Storage);
					}
					
				});
				// Start of user code for additional businessfilters for storage
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
		if (editorKey == MetamodelViewsRepository.OrderOnStockThreshold.Properties.period) {
			return MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Period();
		}
		if (editorKey == MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold) {
			return MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Threshold();
		}
		if (editorKey == MetamodelViewsRepository.OrderOnStockThreshold.Properties.name) {
			return MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Name();
		}
		if (editorKey == MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity) {
			return MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_OrderQuantity();
		}
		if (editorKey == MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderType) {
			return MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_OrderType();
		}
		if (editorKey == MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier) {
			return MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Supplier();
		}
		if (editorKey == MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage) {
			return MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Storage();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		OrderOnStockThreshold orderOnStockThreshold = (OrderOnStockThreshold)semanticObject;
		if (MetamodelViewsRepository.OrderOnStockThreshold.Properties.period == event.getAffectedEditor()) {
			orderOnStockThreshold.setPeriod((java.lang.Double)EEFConverterUtil.createFromString(MetamodelPackage.Literals.POSITIVE_DOUBLE, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold == event.getAffectedEditor()) {
			orderOnStockThreshold.setThreshold((java.lang.Integer)EEFConverterUtil.createFromString(MetamodelPackage.Literals.POSITIVE_INT, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.OrderOnStockThreshold.Properties.name == event.getAffectedEditor()) {
			orderOnStockThreshold.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity == event.getAffectedEditor()) {
			orderOnStockThreshold.setOrderQuantity((java.lang.Integer)EEFConverterUtil.createFromString(MetamodelPackage.Literals.POSITIVE_INT, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderType == event.getAffectedEditor()) {
			orderOnStockThreshold.setOrderType((OrderType)event.getNewValue());
		}
		if (MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				supplierSettings.setToReference((Supplier)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Supplier eObject = MetamodelFactory.eINSTANCE.createSupplier();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				supplierSettings.setToReference(eObject);
			}
		}
		if (MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				storageSettings.setToReference((Storage)event.getNewValue());
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
				storageSettings.setToReference(eObject);
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
			OrderOnStockThresholdPropertiesEditionPart basePart = (OrderOnStockThresholdPropertiesEditionPart)editingPart;
			if (MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Period().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.period)) {
				if (msg.getNewValue() != null) {
					basePart.setPeriod(EcoreUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE, msg.getNewValue()));
				} else {
					basePart.setPeriod("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Threshold().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold)) {
				if (msg.getNewValue() != null) {
					basePart.setThreshold(EcoreUtil.convertToString(MetamodelPackage.Literals.POSITIVE_INT, msg.getNewValue()));
				} else {
					basePart.setThreshold("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_OrderQuantity().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity)) {
				if (msg.getNewValue() != null) {
					basePart.setOrderQuantity(EcoreUtil.convertToString(MetamodelPackage.Literals.POSITIVE_INT, msg.getNewValue()));
				} else {
					basePart.setOrderQuantity("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_OrderType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderType))
				basePart.setOrderType((OrderType)msg.getNewValue());
			
			if (MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Supplier().equals(msg.getFeature()) && basePart != null && isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier))
				basePart.setSupplier((EObject)msg.getNewValue());
			if (MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Storage().equals(msg.getFeature()) && basePart != null && isAccessible(MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage))
				basePart.setStorage((EObject)msg.getNewValue());
			
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
			MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Period(),
			MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Threshold(),
			MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Name(),
			MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_OrderQuantity(),
			MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_OrderType(),
			MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Supplier(),
			MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Storage()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier || key == MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage;
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
				if (MetamodelViewsRepository.OrderOnStockThreshold.Properties.period == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Period().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Period().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Threshold().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Threshold().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.OrderOnStockThreshold.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_Name().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_OrderQuantity().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_OrderQuantity().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_OrderType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getOrderOnStockThreshold_OrderType().getEAttributeType(), newValue);
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

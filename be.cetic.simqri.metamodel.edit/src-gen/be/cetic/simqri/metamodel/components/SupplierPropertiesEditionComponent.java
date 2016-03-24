/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.components;

// Start of user code for imports
import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.OrderOnStockThreshold;
import be.cetic.simqri.metamodel.Supplier;

import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart;

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

import org.eclipse.sirius.eef.components.SiriusAwarePropertiesEditingComponent;


// End of user code

/**
 * 
 * 
 */
public class SupplierPropertiesEditionComponent extends SiriusAwarePropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for refillPolicy ReferencesTable
	 */
	private ReferencesTableSettings refillPolicySettings;
	
	/**
	 * Settings for supplierDelay SingleCompositionEditor
	 */
	private EObjectFlatComboSettings supplierDelaySettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public SupplierPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject supplier, String editing_mode) {
		super(editingContext, supplier, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MetamodelViewsRepository.class;
		partKey = MetamodelViewsRepository.Supplier.class;
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
			
			final Supplier supplier = (Supplier)elt;
			final SupplierPropertiesEditionPart basePart = (SupplierPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(MetamodelViewsRepository.Supplier.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, supplier.getName()));
			
			if (isAccessible(MetamodelViewsRepository.Supplier.Properties.deliveredPercentage))
				basePart.setDeliveredPercentage(EEFConverterUtil.convertToString(MetamodelPackage.Literals.PERCENT, supplier.getDeliveredPercentage()));
			
			if (isAccessible(MetamodelViewsRepository.Supplier.Properties.refillPolicy)) {
				refillPolicySettings = new ReferencesTableSettings(supplier, MetamodelPackage.eINSTANCE.getSupplier_RefillPolicy());
				basePart.initRefillPolicy(refillPolicySettings);
			}
			if (isAccessible(MetamodelViewsRepository.Supplier.Properties.supplierDelay)) {
				// init part
				supplierDelaySettings = new EObjectFlatComboSettings(supplier, MetamodelPackage.eINSTANCE.getSupplier_SupplierDelay());
				basePart.initSupplierDelay(supplierDelaySettings);
			}
			// init filters
			
			
			if (isAccessible(MetamodelViewsRepository.Supplier.Properties.refillPolicy)) {
				basePart.addFilterToRefillPolicy(new EObjectFilter(MetamodelPackage.Literals.ORDER_ON_STOCK_THRESHOLD));
				// Start of user code for additional businessfilters for refillPolicy
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
		if (editorKey == MetamodelViewsRepository.Supplier.Properties.name) {
			return MetamodelPackage.eINSTANCE.getComponent_Name();
		}
		if (editorKey == MetamodelViewsRepository.Supplier.Properties.deliveredPercentage) {
			return MetamodelPackage.eINSTANCE.getSupplier_DeliveredPercentage();
		}
		if (editorKey == MetamodelViewsRepository.Supplier.Properties.refillPolicy) {
			return MetamodelPackage.eINSTANCE.getSupplier_RefillPolicy();
		}
		if (editorKey == MetamodelViewsRepository.Supplier.Properties.supplierDelay) {
			return MetamodelPackage.eINSTANCE.getSupplier_SupplierDelay();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Supplier supplier = (Supplier)semanticObject;
		if (MetamodelViewsRepository.Supplier.Properties.name == event.getAffectedEditor()) {
			supplier.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.Supplier.Properties.deliveredPercentage == event.getAffectedEditor()) {
			supplier.setDeliveredPercentage((java.lang.Double)EEFConverterUtil.createFromString(MetamodelPackage.Literals.PERCENT, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.Supplier.Properties.refillPolicy == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof OrderOnStockThreshold) {
					refillPolicySettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				refillPolicySettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				refillPolicySettings.move(event.getNewIndex(), (OrderOnStockThreshold) event.getNewValue());
			}
		}
		if (MetamodelViewsRepository.Supplier.Properties.supplierDelay == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.EDIT) {
				if (supplierDelaySettings.getValue() == "") {
					EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, supplierDelaySettings, editingContext.getAdapterFactory());
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
						supplierDelaySettings.setToReference(result);
					}
				} else {
					EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) supplierDelaySettings.getValue(), editingContext.getAdapterFactory());
					PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(supplierDelaySettings.getValue(), PropertiesEditingProvider.class);
					if (provider != null) {
						PropertiesEditingPolicy policy = provider.getPolicy(context);
						if (policy != null) {
							policy.execute();
						}
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.UNSET) {
				supplierDelaySettings.setToReference(null);
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
			SupplierPropertiesEditionPart basePart = (SupplierPropertiesEditionPart)editingPart;
			if (MetamodelPackage.eINSTANCE.getComponent_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.Supplier.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getSupplier_DeliveredPercentage().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.Supplier.Properties.deliveredPercentage)) {
				if (msg.getNewValue() != null) {
					basePart.setDeliveredPercentage(EcoreUtil.convertToString(MetamodelPackage.Literals.PERCENT, msg.getNewValue()));
				} else {
					basePart.setDeliveredPercentage("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getSupplier_RefillPolicy().equals(msg.getFeature())  && isAccessible(MetamodelViewsRepository.Supplier.Properties.refillPolicy))
				basePart.updateRefillPolicy();
			if (MetamodelPackage.eINSTANCE.getSupplier_SupplierDelay().equals(msg.getFeature()) && basePart != null && isAccessible(MetamodelViewsRepository.Supplier.Properties.supplierDelay))
				basePart.setSupplierDelay((EObject)msg.getNewValue());
			
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
			MetamodelPackage.eINSTANCE.getSupplier_DeliveredPercentage(),
			MetamodelPackage.eINSTANCE.getSupplier_RefillPolicy(),
			MetamodelPackage.eINSTANCE.getSupplier_SupplierDelay()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == MetamodelViewsRepository.Supplier.Properties.supplierDelay;
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
				if (MetamodelViewsRepository.Supplier.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getComponent_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getComponent_Name().getEAttributeType(), newValue);
				}
				if (MetamodelViewsRepository.Supplier.Properties.deliveredPercentage == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getSupplier_DeliveredPercentage().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getSupplier_DeliveredPercentage().getEAttributeType(), newValue);
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

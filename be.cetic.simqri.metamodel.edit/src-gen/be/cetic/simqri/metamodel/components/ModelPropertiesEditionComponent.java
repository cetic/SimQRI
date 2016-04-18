/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.components;

// Start of user code for imports
import be.cetic.simqri.metamodel.Component;
import be.cetic.simqri.metamodel.Flow;
import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.metamodel.Query;

import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart;

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

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.sirius.eef.components.SiriusAwarePropertiesEditingComponent;


// End of user code

/**
 * 
 * 
 */
public class ModelPropertiesEditionComponent extends SiriusAwarePropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for query ReferencesTable
	 */
	protected ReferencesTableSettings querySettings;
	
	/**
	 * Settings for component ReferencesTable
	 */
	protected ReferencesTableSettings componentSettings;
	
	/**
	 * Settings for flow ReferencesTable
	 */
	protected ReferencesTableSettings flowSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ModelPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject model, String editing_mode) {
		super(editingContext, model, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MetamodelViewsRepository.class;
		partKey = MetamodelViewsRepository.Model.class;
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
			
			final Model model = (Model)elt;
			final ModelPropertiesEditionPart basePart = (ModelPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(MetamodelViewsRepository.Model.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, model.getName()));

			if (isAccessible(MetamodelViewsRepository.Model.Properties.query)) {
				querySettings = new ReferencesTableSettings(model, MetamodelPackage.eINSTANCE.getModel_Query());
				basePart.initQuery(querySettings);
			}
			if (isAccessible(MetamodelViewsRepository.Model.Properties.component)) {
				componentSettings = new ReferencesTableSettings(model, MetamodelPackage.eINSTANCE.getModel_Component());
				basePart.initComponent(componentSettings);
			}
			if (isAccessible(MetamodelViewsRepository.Model.Properties.flow)) {
				flowSettings = new ReferencesTableSettings(model, MetamodelPackage.eINSTANCE.getModel_Flow());
				basePart.initFlow(flowSettings);
			}
			// init filters
			
			
			if (isAccessible(MetamodelViewsRepository.Model.Properties.query)) {
				basePart.addFilterToQuery(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Query); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for query
				// End of user code
			}
			if (isAccessible(MetamodelViewsRepository.Model.Properties.component)) {
				basePart.addFilterToComponent(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Component); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for component
				// End of user code
			}
			if (isAccessible(MetamodelViewsRepository.Model.Properties.flow)) {
				basePart.addFilterToFlow(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Flow); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for flow
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
		if (editorKey == MetamodelViewsRepository.Model.Properties.name) {
			return MetamodelPackage.eINSTANCE.getModel_Name();
		}
		if (editorKey == MetamodelViewsRepository.Model.Properties.query) {
			return MetamodelPackage.eINSTANCE.getModel_Query();
		}
		if (editorKey == MetamodelViewsRepository.Model.Properties.component) {
			return MetamodelPackage.eINSTANCE.getModel_Component();
		}
		if (editorKey == MetamodelViewsRepository.Model.Properties.flow) {
			return MetamodelPackage.eINSTANCE.getModel_Flow();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Model model = (Model)semanticObject;
		if (MetamodelViewsRepository.Model.Properties.name == event.getAffectedEditor()) {
			model.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (MetamodelViewsRepository.Model.Properties.query == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, querySettings, editingContext.getAdapterFactory());
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
				querySettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				querySettings.move(event.getNewIndex(), (Query) event.getNewValue());
			}
		}
		if (MetamodelViewsRepository.Model.Properties.component == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, componentSettings, editingContext.getAdapterFactory());
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
				componentSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				componentSettings.move(event.getNewIndex(), (Component) event.getNewValue());
			}
		}
		if (MetamodelViewsRepository.Model.Properties.flow == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, flowSettings, editingContext.getAdapterFactory());
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
				flowSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				flowSettings.move(event.getNewIndex(), (Flow) event.getNewValue());
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
			ModelPropertiesEditionPart basePart = (ModelPropertiesEditionPart)editingPart;
			if (MetamodelPackage.eINSTANCE.getModel_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.Model.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (MetamodelPackage.eINSTANCE.getModel_Query().equals(msg.getFeature()) && isAccessible(MetamodelViewsRepository.Model.Properties.query))
				basePart.updateQuery();
			if (MetamodelPackage.eINSTANCE.getModel_Component().equals(msg.getFeature()) && isAccessible(MetamodelViewsRepository.Model.Properties.component))
				basePart.updateComponent();
			if (MetamodelPackage.eINSTANCE.getModel_Flow().equals(msg.getFeature()) && isAccessible(MetamodelViewsRepository.Model.Properties.flow))
				basePart.updateFlow();
			
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
			MetamodelPackage.eINSTANCE.getModel_Name(),
			MetamodelPackage.eINSTANCE.getModel_Query(),
			MetamodelPackage.eINSTANCE.getModel_Component(),
			MetamodelPackage.eINSTANCE.getModel_Flow()		);
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
				if (MetamodelViewsRepository.Model.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getModel_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getModel_Name().getEAttributeType(), newValue);
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

/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.forms;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart;

import be.cetic.simqri.metamodel.providers.MetamodelMessages;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.SingleCompositionEditor;

import org.eclipse.emf.eef.runtime.ui.widgets.SingleCompositionEditor.SingleCompositionListener;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * 
 * 
 */
public class StorageOutputFlowPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, StorageOutputFlowPropertiesEditionPart {

	protected EObjectFlatComboViewer source;
	protected EObjectFlatComboViewer destination;
	protected SingleCompositionEditor quantity;



	/**
	 * For {@link ISection} use only.
	 */
	public StorageOutputFlowPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public StorageOutputFlowPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence storageOutputFlowStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = storageOutputFlowStep.addStep(MetamodelViewsRepository.StorageOutputFlow.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.StorageOutputFlow.Properties.source);
		propertiesStep.addStep(MetamodelViewsRepository.StorageOutputFlow.Properties.destination);
		propertiesStep.addStep(MetamodelViewsRepository.StorageOutputFlow.Properties.quantity);
		
		
		composer = new PartComposer(storageOutputFlowStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.StorageOutputFlow.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.StorageOutputFlow.Properties.source) {
					return createSourceFlatComboViewer(parent, widgetFactory);
				}
				if (key == MetamodelViewsRepository.StorageOutputFlow.Properties.destination) {
					return createDestinationFlatComboViewer(parent, widgetFactory);
				}
				if (key == MetamodelViewsRepository.StorageOutputFlow.Properties.quantity) {
					return createQuantitySingleCompositionEditor(parent, widgetFactory);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(MetamodelMessages.StorageOutputFlowPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createSourceFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, MetamodelViewsRepository.StorageOutputFlow.Properties.source, MetamodelMessages.StorageOutputFlowPropertiesEditionPart_SourceLabel);
		source = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(MetamodelViewsRepository.StorageOutputFlow.Properties.source, MetamodelViewsRepository.FORM_KIND));
		widgetFactory.adapt(source);
		source.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData sourceData = new GridData(GridData.FILL_HORIZONTAL);
		source.setLayoutData(sourceData);
		source.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StorageOutputFlowPropertiesEditionPartForm.this, MetamodelViewsRepository.StorageOutputFlow.Properties.source, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSource()));
			}

		});
		source.setID(MetamodelViewsRepository.StorageOutputFlow.Properties.source);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.StorageOutputFlow.Properties.source, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createDestinationFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, MetamodelViewsRepository.StorageOutputFlow.Properties.destination, MetamodelMessages.StorageOutputFlowPropertiesEditionPart_DestinationLabel);
		destination = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(MetamodelViewsRepository.StorageOutputFlow.Properties.destination, MetamodelViewsRepository.FORM_KIND));
		widgetFactory.adapt(destination);
		destination.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData destinationData = new GridData(GridData.FILL_HORIZONTAL);
		destination.setLayoutData(destinationData);
		destination.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StorageOutputFlowPropertiesEditionPartForm.this, MetamodelViewsRepository.StorageOutputFlow.Properties.destination, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDestination()));
			}

		});
		destination.setID(MetamodelViewsRepository.StorageOutputFlow.Properties.destination);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.StorageOutputFlow.Properties.destination, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDestinationFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createQuantitySingleCompositionEditor(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, MetamodelViewsRepository.StorageOutputFlow.Properties.quantity, MetamodelMessages.StorageOutputFlowPropertiesEditionPart_QuantityLabel);
		//create widget
		quantity = new SingleCompositionEditor(widgetFactory, parent, SWT.NONE);
		GridData quantityData = new GridData(GridData.FILL_HORIZONTAL);
		quantity.setLayoutData(quantityData);
		quantity.addEditorListener(new SingleCompositionListener() {
			
			public void edit() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StorageOutputFlowPropertiesEditionPartForm.this,  MetamodelViewsRepository.StorageOutputFlow.Properties.quantity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, null));				
				quantity.refresh();
			}
			
			public void clear() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StorageOutputFlowPropertiesEditionPartForm.this,  MetamodelViewsRepository.StorageOutputFlow.Properties.quantity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.UNSET, null, null));
				quantity.refresh();
			}
		});
		quantity.setID(MetamodelViewsRepository.StorageOutputFlow.Properties.quantity);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.StorageOutputFlow.Properties.quantity, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createQuantitySingleCompositionEditor

		// End of user code
		return parent;
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#getSource()
	 * 
	 */
	public EObject getSource() {
		if (source.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) source.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#initSource(EObjectFlatComboSettings)
	 */
	public void initSource(EObjectFlatComboSettings settings) {
		source.setInput(settings);
		if (current != null) {
			source.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.StorageOutputFlow.Properties.source);
		if (eefElementEditorReadOnlyState && source.isEnabled()) {
			source.setEnabled(false);
			source.setToolTipText(MetamodelMessages.StorageOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !source.isEnabled()) {
			source.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#setSource(EObject newValue)
	 * 
	 */
	public void setSource(EObject newValue) {
		if (newValue != null) {
			source.setSelection(new StructuredSelection(newValue));
		} else {
			source.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.StorageOutputFlow.Properties.source);
		if (eefElementEditorReadOnlyState && source.isEnabled()) {
			source.setEnabled(false);
			source.setToolTipText(MetamodelMessages.StorageOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !source.isEnabled()) {
			source.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#setSourceButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSourceButtonMode(ButtonsModeEnum newValue) {
		source.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#addFilterSource(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSource(ViewerFilter filter) {
		source.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#addBusinessFilterSource(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSource(ViewerFilter filter) {
		source.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#getDestination()
	 * 
	 */
	public EObject getDestination() {
		if (destination.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) destination.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#initDestination(EObjectFlatComboSettings)
	 */
	public void initDestination(EObjectFlatComboSettings settings) {
		destination.setInput(settings);
		if (current != null) {
			destination.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.StorageOutputFlow.Properties.destination);
		if (eefElementEditorReadOnlyState && destination.isEnabled()) {
			destination.setEnabled(false);
			destination.setToolTipText(MetamodelMessages.StorageOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !destination.isEnabled()) {
			destination.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#setDestination(EObject newValue)
	 * 
	 */
	public void setDestination(EObject newValue) {
		if (newValue != null) {
			destination.setSelection(new StructuredSelection(newValue));
		} else {
			destination.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.StorageOutputFlow.Properties.destination);
		if (eefElementEditorReadOnlyState && destination.isEnabled()) {
			destination.setEnabled(false);
			destination.setToolTipText(MetamodelMessages.StorageOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !destination.isEnabled()) {
			destination.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#setDestinationButtonMode(ButtonsModeEnum newValue)
	 */
	public void setDestinationButtonMode(ButtonsModeEnum newValue) {
		destination.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#addFilterDestination(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDestination(ViewerFilter filter) {
		destination.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#addBusinessFilterDestination(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDestination(ViewerFilter filter) {
		destination.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#getQuantity()
	 * 
	 */
	public EObject getQuantity() {
		return (EObject) quantity.getInput();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#initQuantity(EObjectFlatComboSettings)
	 */
	public void initQuantity(EObjectFlatComboSettings settings) {
		quantity.setAdapterFactory(adapterFactory);
		quantity.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.StorageOutputFlow.Properties.quantity);
		if (eefElementEditorReadOnlyState && quantity.isEnabled()) {
			quantity.setEnabled(false);
			quantity.setToolTipText(MetamodelMessages.StorageOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !quantity.isEnabled()) {
			quantity.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart#setQuantity(EObject newValue)
	 * 
	 */
	public void setQuantity(EObject newValue) {
		quantity.refresh();
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.StorageOutputFlow.Properties.quantity);
		if (eefElementEditorReadOnlyState && quantity.isEnabled()) {
			quantity.setEnabled(false);
			quantity.setToolTipText(MetamodelMessages.StorageOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !quantity.isEnabled()) {
			quantity.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MetamodelMessages.StorageOutputFlow_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

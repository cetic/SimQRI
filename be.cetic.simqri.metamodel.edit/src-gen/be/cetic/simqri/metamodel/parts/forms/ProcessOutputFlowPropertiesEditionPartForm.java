/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.forms;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart;

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
public class ProcessOutputFlowPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ProcessOutputFlowPropertiesEditionPart {

	protected EObjectFlatComboViewer source;
	protected EObjectFlatComboViewer destination;
	protected SingleCompositionEditor quantity;
	protected SingleCompositionEditor processOutputFlowDelay;



	/**
	 * For {@link ISection} use only.
	 */
	public ProcessOutputFlowPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ProcessOutputFlowPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence processOutputFlowStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = processOutputFlowStep.addStep(MetamodelViewsRepository.ProcessOutputFlow.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.ProcessOutputFlow.Properties.source);
		propertiesStep.addStep(MetamodelViewsRepository.ProcessOutputFlow.Properties.destination);
		propertiesStep.addStep(MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity);
		propertiesStep.addStep(MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay);
		
		
		composer = new PartComposer(processOutputFlowStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.ProcessOutputFlow.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.ProcessOutputFlow.Properties.source) {
					return createSourceFlatComboViewer(parent, widgetFactory);
				}
				if (key == MetamodelViewsRepository.ProcessOutputFlow.Properties.destination) {
					return createDestinationFlatComboViewer(parent, widgetFactory);
				}
				if (key == MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity) {
					return createQuantitySingleCompositionEditor(parent, widgetFactory);
				}
				if (key == MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay) {
					return createProcessOutputFlowDelaySingleCompositionEditor(parent, widgetFactory);
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
		propertiesSection.setText(MetamodelMessages.ProcessOutputFlowPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, MetamodelViewsRepository.ProcessOutputFlow.Properties.source, MetamodelMessages.ProcessOutputFlowPropertiesEditionPart_SourceLabel);
		source = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(MetamodelViewsRepository.ProcessOutputFlow.Properties.source, MetamodelViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProcessOutputFlowPropertiesEditionPartForm.this, MetamodelViewsRepository.ProcessOutputFlow.Properties.source, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSource()));
			}

		});
		source.setID(MetamodelViewsRepository.ProcessOutputFlow.Properties.source);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ProcessOutputFlow.Properties.source, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		createDescription(parent, MetamodelViewsRepository.ProcessOutputFlow.Properties.destination, MetamodelMessages.ProcessOutputFlowPropertiesEditionPart_DestinationLabel);
		destination = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(MetamodelViewsRepository.ProcessOutputFlow.Properties.destination, MetamodelViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProcessOutputFlowPropertiesEditionPartForm.this, MetamodelViewsRepository.ProcessOutputFlow.Properties.destination, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDestination()));
			}

		});
		destination.setID(MetamodelViewsRepository.ProcessOutputFlow.Properties.destination);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ProcessOutputFlow.Properties.destination, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		createDescription(parent, MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity, MetamodelMessages.ProcessOutputFlowPropertiesEditionPart_QuantityLabel);
		//create widget
		quantity = new SingleCompositionEditor(widgetFactory, parent, SWT.NONE);
		GridData quantityData = new GridData(GridData.FILL_HORIZONTAL);
		quantity.setLayoutData(quantityData);
		quantity.addEditorListener(new SingleCompositionListener() {
			
			public void edit() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProcessOutputFlowPropertiesEditionPartForm.this,  MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, null));				
				quantity.refresh();
			}
			
			public void clear() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProcessOutputFlowPropertiesEditionPartForm.this,  MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.UNSET, null, null));
				quantity.refresh();
			}
		});
		quantity.setID(MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createQuantitySingleCompositionEditor

		// End of user code
		return parent;
	}


	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createProcessOutputFlowDelaySingleCompositionEditor(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay, MetamodelMessages.ProcessOutputFlowPropertiesEditionPart_ProcessOutputFlowDelayLabel);
		//create widget
		processOutputFlowDelay = new SingleCompositionEditor(widgetFactory, parent, SWT.NONE);
		GridData processOutputFlowDelayData = new GridData(GridData.FILL_HORIZONTAL);
		processOutputFlowDelay.setLayoutData(processOutputFlowDelayData);
		processOutputFlowDelay.addEditorListener(new SingleCompositionListener() {
			
			public void edit() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProcessOutputFlowPropertiesEditionPartForm.this,  MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, null));				
				processOutputFlowDelay.refresh();
			}
			
			public void clear() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProcessOutputFlowPropertiesEditionPartForm.this,  MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.UNSET, null, null));
				processOutputFlowDelay.refresh();
			}
		});
		processOutputFlowDelay.setID(MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createProcessOutputFlowDelaySingleCompositionEditor

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
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#getSource()
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
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#initSource(EObjectFlatComboSettings)
	 */
	public void initSource(EObjectFlatComboSettings settings) {
		source.setInput(settings);
		if (current != null) {
			source.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ProcessOutputFlow.Properties.source);
		if (eefElementEditorReadOnlyState && source.isEnabled()) {
			source.setEnabled(false);
			source.setToolTipText(MetamodelMessages.ProcessOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !source.isEnabled()) {
			source.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#setSource(EObject newValue)
	 * 
	 */
	public void setSource(EObject newValue) {
		if (newValue != null) {
			source.setSelection(new StructuredSelection(newValue));
		} else {
			source.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ProcessOutputFlow.Properties.source);
		if (eefElementEditorReadOnlyState && source.isEnabled()) {
			source.setEnabled(false);
			source.setToolTipText(MetamodelMessages.ProcessOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !source.isEnabled()) {
			source.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#setSourceButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSourceButtonMode(ButtonsModeEnum newValue) {
		source.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#addFilterSource(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSource(ViewerFilter filter) {
		source.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#addBusinessFilterSource(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSource(ViewerFilter filter) {
		source.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#getDestination()
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
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#initDestination(EObjectFlatComboSettings)
	 */
	public void initDestination(EObjectFlatComboSettings settings) {
		destination.setInput(settings);
		if (current != null) {
			destination.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ProcessOutputFlow.Properties.destination);
		if (eefElementEditorReadOnlyState && destination.isEnabled()) {
			destination.setEnabled(false);
			destination.setToolTipText(MetamodelMessages.ProcessOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !destination.isEnabled()) {
			destination.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#setDestination(EObject newValue)
	 * 
	 */
	public void setDestination(EObject newValue) {
		if (newValue != null) {
			destination.setSelection(new StructuredSelection(newValue));
		} else {
			destination.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ProcessOutputFlow.Properties.destination);
		if (eefElementEditorReadOnlyState && destination.isEnabled()) {
			destination.setEnabled(false);
			destination.setToolTipText(MetamodelMessages.ProcessOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !destination.isEnabled()) {
			destination.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#setDestinationButtonMode(ButtonsModeEnum newValue)
	 */
	public void setDestinationButtonMode(ButtonsModeEnum newValue) {
		destination.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#addFilterDestination(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDestination(ViewerFilter filter) {
		destination.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#addBusinessFilterDestination(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDestination(ViewerFilter filter) {
		destination.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#getQuantity()
	 * 
	 */
	public EObject getQuantity() {
		return (EObject) quantity.getInput();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#initQuantity(EObjectFlatComboSettings)
	 */
	public void initQuantity(EObjectFlatComboSettings settings) {
		quantity.setAdapterFactory(adapterFactory);
		quantity.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity);
		if (eefElementEditorReadOnlyState && quantity.isEnabled()) {
			quantity.setEnabled(false);
			quantity.setToolTipText(MetamodelMessages.ProcessOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !quantity.isEnabled()) {
			quantity.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#setQuantity(EObject newValue)
	 * 
	 */
	public void setQuantity(EObject newValue) {
		quantity.refresh();
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity);
		if (eefElementEditorReadOnlyState && quantity.isEnabled()) {
			quantity.setEnabled(false);
			quantity.setToolTipText(MetamodelMessages.ProcessOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !quantity.isEnabled()) {
			quantity.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#getProcessOutputFlowDelay()
	 * 
	 */
	public EObject getProcessOutputFlowDelay() {
		return (EObject) processOutputFlowDelay.getInput();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#initProcessOutputFlowDelay(EObjectFlatComboSettings)
	 */
	public void initProcessOutputFlowDelay(EObjectFlatComboSettings settings) {
		processOutputFlowDelay.setAdapterFactory(adapterFactory);
		processOutputFlowDelay.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay);
		if (eefElementEditorReadOnlyState && processOutputFlowDelay.isEnabled()) {
			processOutputFlowDelay.setEnabled(false);
			processOutputFlowDelay.setToolTipText(MetamodelMessages.ProcessOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !processOutputFlowDelay.isEnabled()) {
			processOutputFlowDelay.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#setProcessOutputFlowDelay(EObject newValue)
	 * 
	 */
	public void setProcessOutputFlowDelay(EObject newValue) {
		processOutputFlowDelay.refresh();
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ProcessOutputFlow.Properties.processOutputFlowDelay);
		if (eefElementEditorReadOnlyState && processOutputFlowDelay.isEnabled()) {
			processOutputFlowDelay.setEnabled(false);
			processOutputFlowDelay.setToolTipText(MetamodelMessages.ProcessOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !processOutputFlowDelay.isEnabled()) {
			processOutputFlowDelay.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MetamodelMessages.ProcessOutputFlow_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

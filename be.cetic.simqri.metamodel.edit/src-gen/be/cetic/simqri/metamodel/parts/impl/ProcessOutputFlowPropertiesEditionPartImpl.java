/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.impl;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart;

import be.cetic.simqri.metamodel.providers.MetamodelMessages;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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
import org.eclipse.swt.widgets.Group;

// End of user code

/**
 * 
 * 
 */
public class ProcessOutputFlowPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ProcessOutputFlowPropertiesEditionPart {

	protected EObjectFlatComboViewer destination;
	protected EObjectFlatComboViewer source;
	private SingleCompositionEditor quantity;
	private SingleCompositionEditor delay;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ProcessOutputFlowPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence processOutputFlowStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = processOutputFlowStep.addStep(MetamodelViewsRepository.ProcessOutputFlow.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.ProcessOutputFlow.Properties.destination);
		propertiesStep.addStep(MetamodelViewsRepository.ProcessOutputFlow.Properties.source);
		propertiesStep.addStep(MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity);
		propertiesStep.addStep(MetamodelViewsRepository.ProcessOutputFlow.Properties.delay);
		
		
		composer = new PartComposer(processOutputFlowStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.ProcessOutputFlow.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == MetamodelViewsRepository.ProcessOutputFlow.Properties.destination) {
					return createDestinationFlatComboViewer(parent);
				}
				if (key == MetamodelViewsRepository.ProcessOutputFlow.Properties.source) {
					return createSourceFlatComboViewer(parent);
				}
				if (key == MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity) {
					return createQuantitySingleCompositionEditor(parent);
				}
				if (key == MetamodelViewsRepository.ProcessOutputFlow.Properties.delay) {
					return createDelaySingleCompositionEditor(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(MetamodelMessages.ProcessOutputFlowPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createDestinationFlatComboViewer(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.ProcessOutputFlow.Properties.destination, MetamodelMessages.ProcessOutputFlowPropertiesEditionPart_DestinationLabel);
		destination = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(MetamodelViewsRepository.ProcessOutputFlow.Properties.destination, MetamodelViewsRepository.SWT_KIND));
		destination.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		destination.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProcessOutputFlowPropertiesEditionPartImpl.this, MetamodelViewsRepository.ProcessOutputFlow.Properties.destination, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getDestination()));
			}

		});
		GridData destinationData = new GridData(GridData.FILL_HORIZONTAL);
		destination.setLayoutData(destinationData);
		destination.setID(MetamodelViewsRepository.ProcessOutputFlow.Properties.destination);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ProcessOutputFlow.Properties.destination, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDestinationFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createSourceFlatComboViewer(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.ProcessOutputFlow.Properties.source, MetamodelMessages.ProcessOutputFlowPropertiesEditionPart_SourceLabel);
		source = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(MetamodelViewsRepository.ProcessOutputFlow.Properties.source, MetamodelViewsRepository.SWT_KIND));
		source.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		source.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProcessOutputFlowPropertiesEditionPartImpl.this, MetamodelViewsRepository.ProcessOutputFlow.Properties.source, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getSource()));
			}

		});
		GridData sourceData = new GridData(GridData.FILL_HORIZONTAL);
		source.setLayoutData(sourceData);
		source.setID(MetamodelViewsRepository.ProcessOutputFlow.Properties.source);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ProcessOutputFlow.Properties.source, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createQuantitySingleCompositionEditor(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity, MetamodelMessages.ProcessOutputFlowPropertiesEditionPart_QuantityLabel);
		//create widget
		quantity = new SingleCompositionEditor(parent, SWT.NONE);
		GridData quantityData = new GridData(GridData.FILL_HORIZONTAL);
		quantity.setLayoutData(quantityData);
		quantity.addEditorListener(new SingleCompositionListener() {
			
			public void edit() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProcessOutputFlowPropertiesEditionPartImpl.this,  MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, null));				
				quantity.refresh();
			}
			
			public void clear() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProcessOutputFlowPropertiesEditionPartImpl.this,  MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.UNSET, null, null));
				quantity.refresh();
			}
		});
		quantity.setID(MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ProcessOutputFlow.Properties.quantity, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createQuantitySingleCompositionEditor

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createDelaySingleCompositionEditor(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.ProcessOutputFlow.Properties.delay, MetamodelMessages.ProcessOutputFlowPropertiesEditionPart_DelayLabel);
		//create widget
		delay = new SingleCompositionEditor(parent, SWT.NONE);
		GridData delayData = new GridData(GridData.FILL_HORIZONTAL);
		delay.setLayoutData(delayData);
		delay.addEditorListener(new SingleCompositionListener() {
			
			public void edit() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProcessOutputFlowPropertiesEditionPartImpl.this,  MetamodelViewsRepository.ProcessOutputFlow.Properties.delay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, null));				
				delay.refresh();
			}
			
			public void clear() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProcessOutputFlowPropertiesEditionPartImpl.this,  MetamodelViewsRepository.ProcessOutputFlow.Properties.delay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.UNSET, null, null));
				delay.refresh();
			}
		});
		delay.setID(MetamodelViewsRepository.ProcessOutputFlow.Properties.delay);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ProcessOutputFlow.Properties.delay, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDelaySingleCompositionEditor

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
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#getDelay()
	 * 
	 */
	public EObject getDelay() {
		return (EObject) delay.getInput();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#initDelay(EObjectFlatComboSettings)
	 */
	public void initDelay(EObjectFlatComboSettings settings) {
		delay.setAdapterFactory(adapterFactory);
		delay.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ProcessOutputFlow.Properties.delay);
		if (eefElementEditorReadOnlyState && delay.isEnabled()) {
			delay.setEnabled(false);
			delay.setToolTipText(MetamodelMessages.ProcessOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !delay.isEnabled()) {
			delay.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ProcessOutputFlowPropertiesEditionPart#setDelay(EObject newValue)
	 * 
	 */
	public void setDelay(EObject newValue) {
		delay.refresh();
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ProcessOutputFlow.Properties.delay);
		if (eefElementEditorReadOnlyState && delay.isEnabled()) {
			delay.setEnabled(false);
			delay.setToolTipText(MetamodelMessages.ProcessOutputFlow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !delay.isEnabled()) {
			delay.setEnabled(true);
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

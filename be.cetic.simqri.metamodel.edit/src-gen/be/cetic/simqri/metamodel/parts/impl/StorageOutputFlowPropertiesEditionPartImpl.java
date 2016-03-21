/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.impl;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.StorageOutputFlowPropertiesEditionPart;

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
public class StorageOutputFlowPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, StorageOutputFlowPropertiesEditionPart {

	protected EObjectFlatComboViewer destination;
	protected EObjectFlatComboViewer source;
	private SingleCompositionEditor quantity;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public StorageOutputFlowPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence storageOutputFlowStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = storageOutputFlowStep.addStep(MetamodelViewsRepository.StorageOutputFlow.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.StorageOutputFlow.Properties.destination);
		propertiesStep.addStep(MetamodelViewsRepository.StorageOutputFlow.Properties.source);
		propertiesStep.addStep(MetamodelViewsRepository.StorageOutputFlow.Properties.quantity);
		
		
		composer = new PartComposer(storageOutputFlowStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.StorageOutputFlow.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == MetamodelViewsRepository.StorageOutputFlow.Properties.destination) {
					return createDestinationFlatComboViewer(parent);
				}
				if (key == MetamodelViewsRepository.StorageOutputFlow.Properties.source) {
					return createSourceFlatComboViewer(parent);
				}
				if (key == MetamodelViewsRepository.StorageOutputFlow.Properties.quantity) {
					return createQuantitySingleCompositionEditor(parent);
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
		propertiesGroup.setText(MetamodelMessages.StorageOutputFlowPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, MetamodelViewsRepository.StorageOutputFlow.Properties.destination, MetamodelMessages.StorageOutputFlowPropertiesEditionPart_DestinationLabel);
		destination = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(MetamodelViewsRepository.StorageOutputFlow.Properties.destination, MetamodelViewsRepository.SWT_KIND));
		destination.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		destination.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StorageOutputFlowPropertiesEditionPartImpl.this, MetamodelViewsRepository.StorageOutputFlow.Properties.destination, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getDestination()));
			}

		});
		GridData destinationData = new GridData(GridData.FILL_HORIZONTAL);
		destination.setLayoutData(destinationData);
		destination.setID(MetamodelViewsRepository.StorageOutputFlow.Properties.destination);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.StorageOutputFlow.Properties.destination, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDestinationFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createSourceFlatComboViewer(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.StorageOutputFlow.Properties.source, MetamodelMessages.StorageOutputFlowPropertiesEditionPart_SourceLabel);
		source = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(MetamodelViewsRepository.StorageOutputFlow.Properties.source, MetamodelViewsRepository.SWT_KIND));
		source.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		source.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StorageOutputFlowPropertiesEditionPartImpl.this, MetamodelViewsRepository.StorageOutputFlow.Properties.source, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getSource()));
			}

		});
		GridData sourceData = new GridData(GridData.FILL_HORIZONTAL);
		source.setLayoutData(sourceData);
		source.setID(MetamodelViewsRepository.StorageOutputFlow.Properties.source);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.StorageOutputFlow.Properties.source, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createQuantitySingleCompositionEditor(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.StorageOutputFlow.Properties.quantity, MetamodelMessages.StorageOutputFlowPropertiesEditionPart_QuantityLabel);
		//create widget
		quantity = new SingleCompositionEditor(parent, SWT.NONE);
		GridData quantityData = new GridData(GridData.FILL_HORIZONTAL);
		quantity.setLayoutData(quantityData);
		quantity.addEditorListener(new SingleCompositionListener() {
			
			public void edit() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StorageOutputFlowPropertiesEditionPartImpl.this,  MetamodelViewsRepository.StorageOutputFlow.Properties.quantity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, null));				
				quantity.refresh();
			}
			
			public void clear() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StorageOutputFlowPropertiesEditionPartImpl.this,  MetamodelViewsRepository.StorageOutputFlow.Properties.quantity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.UNSET, null, null));
				quantity.refresh();
			}
		});
		quantity.setID(MetamodelViewsRepository.StorageOutputFlow.Properties.quantity);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.StorageOutputFlow.Properties.quantity, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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

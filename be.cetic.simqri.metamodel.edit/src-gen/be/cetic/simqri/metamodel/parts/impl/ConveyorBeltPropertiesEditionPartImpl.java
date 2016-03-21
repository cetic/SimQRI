/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.impl;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart;
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;

import be.cetic.simqri.metamodel.providers.MetamodelMessages;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.SingleCompositionEditor;

import org.eclipse.emf.eef.runtime.ui.widgets.SingleCompositionEditor.SingleCompositionListener;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * 
 * 
 */
public class ConveyorBeltPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ConveyorBeltPropertiesEditionPart {

	protected Text name;
	protected Text duration;
	protected Text minimalSeparationBetweenBatches;
	private SingleCompositionEditor output;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ConveyorBeltPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence conveyorBeltStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = conveyorBeltStep.addStep(MetamodelViewsRepository.ConveyorBelt.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.ConveyorBelt.Properties.name);
		propertiesStep.addStep(MetamodelViewsRepository.ConveyorBelt.Properties.duration);
		propertiesStep.addStep(MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches);
		propertiesStep.addStep(MetamodelViewsRepository.ConveyorBelt.Properties.output);
		
		
		composer = new PartComposer(conveyorBeltStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.ConveyorBelt.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == MetamodelViewsRepository.ConveyorBelt.Properties.name) {
					return createNameText(parent);
				}
				if (key == MetamodelViewsRepository.ConveyorBelt.Properties.duration) {
					return createDurationText(parent);
				}
				if (key == MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches) {
					return createMinimalSeparationBetweenBatchesText(parent);
				}
				if (key == MetamodelViewsRepository.ConveyorBelt.Properties.output) {
					return createOutputSingleCompositionEditor(parent);
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
		propertiesGroup.setText(MetamodelMessages.ConveyorBeltPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.ConveyorBelt.Properties.name, MetamodelMessages.ConveyorBeltPropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartImpl.this, MetamodelViewsRepository.ConveyorBelt.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartImpl.this, MetamodelViewsRepository.ConveyorBelt.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, MetamodelViewsRepository.ConveyorBelt.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ConveyorBelt.Properties.name, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createDurationText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.ConveyorBelt.Properties.duration, MetamodelMessages.ConveyorBeltPropertiesEditionPart_DurationLabel);
		duration = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData durationData = new GridData(GridData.FILL_HORIZONTAL);
		duration.setLayoutData(durationData);
		duration.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartImpl.this, MetamodelViewsRepository.ConveyorBelt.Properties.duration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, duration.getText()));
			}

		});
		duration.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartImpl.this, MetamodelViewsRepository.ConveyorBelt.Properties.duration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, duration.getText()));
				}
			}

		});
		EditingUtils.setID(duration, MetamodelViewsRepository.ConveyorBelt.Properties.duration);
		EditingUtils.setEEFtype(duration, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ConveyorBelt.Properties.duration, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDurationText

		// End of user code
		return parent;
	}

	
	protected Composite createMinimalSeparationBetweenBatchesText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches, MetamodelMessages.ConveyorBeltPropertiesEditionPart_MinimalSeparationBetweenBatchesLabel);
		minimalSeparationBetweenBatches = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData minimalSeparationBetweenBatchesData = new GridData(GridData.FILL_HORIZONTAL);
		minimalSeparationBetweenBatches.setLayoutData(minimalSeparationBetweenBatchesData);
		minimalSeparationBetweenBatches.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartImpl.this, MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minimalSeparationBetweenBatches.getText()));
			}

		});
		minimalSeparationBetweenBatches.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartImpl.this, MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minimalSeparationBetweenBatches.getText()));
				}
			}

		});
		EditingUtils.setID(minimalSeparationBetweenBatches, MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches);
		EditingUtils.setEEFtype(minimalSeparationBetweenBatches, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMinimalSeparationBetweenBatchesText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createOutputSingleCompositionEditor(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.ConveyorBelt.Properties.output, MetamodelMessages.ConveyorBeltPropertiesEditionPart_OutputLabel);
		//create widget
		output = new SingleCompositionEditor(parent, SWT.NONE);
		GridData outputData = new GridData(GridData.FILL_HORIZONTAL);
		output.setLayoutData(outputData);
		output.addEditorListener(new SingleCompositionListener() {
			
			public void edit() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartImpl.this,  MetamodelViewsRepository.ConveyorBelt.Properties.output, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, null));				
				output.refresh();
			}
			
			public void clear() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartImpl.this,  MetamodelViewsRepository.ConveyorBelt.Properties.output, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.UNSET, null, null));
				output.refresh();
			}
		});
		output.setID(MetamodelViewsRepository.ConveyorBelt.Properties.output);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ConveyorBelt.Properties.output, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOutputSingleCompositionEditor

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
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ConveyorBelt.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(MetamodelMessages.ConveyorBelt_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#getDuration()
	 * 
	 */
	public String getDuration() {
		return duration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#setDuration(String newValue)
	 * 
	 */
	public void setDuration(String newValue) {
		if (newValue != null) {
			duration.setText(newValue);
		} else {
			duration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ConveyorBelt.Properties.duration);
		if (eefElementEditorReadOnlyState && duration.isEnabled()) {
			duration.setEnabled(false);
			duration.setToolTipText(MetamodelMessages.ConveyorBelt_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !duration.isEnabled()) {
			duration.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#getMinimalSeparationBetweenBatches()
	 * 
	 */
	public String getMinimalSeparationBetweenBatches() {
		return minimalSeparationBetweenBatches.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#setMinimalSeparationBetweenBatches(String newValue)
	 * 
	 */
	public void setMinimalSeparationBetweenBatches(String newValue) {
		if (newValue != null) {
			minimalSeparationBetweenBatches.setText(newValue);
		} else {
			minimalSeparationBetweenBatches.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches);
		if (eefElementEditorReadOnlyState && minimalSeparationBetweenBatches.isEnabled()) {
			minimalSeparationBetweenBatches.setEnabled(false);
			minimalSeparationBetweenBatches.setToolTipText(MetamodelMessages.ConveyorBelt_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !minimalSeparationBetweenBatches.isEnabled()) {
			minimalSeparationBetweenBatches.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#getOutput()
	 * 
	 */
	public EObject getOutput() {
		return (EObject) output.getInput();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#initOutput(EObjectFlatComboSettings)
	 */
	public void initOutput(EObjectFlatComboSettings settings) {
		output.setAdapterFactory(adapterFactory);
		output.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ConveyorBelt.Properties.output);
		if (eefElementEditorReadOnlyState && output.isEnabled()) {
			output.setEnabled(false);
			output.setToolTipText(MetamodelMessages.ConveyorBelt_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !output.isEnabled()) {
			output.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#setOutput(EObject newValue)
	 * 
	 */
	public void setOutput(EObject newValue) {
		output.refresh();
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ConveyorBelt.Properties.output);
		if (eefElementEditorReadOnlyState && output.isEnabled()) {
			output.setEnabled(false);
			output.setToolTipText(MetamodelMessages.ConveyorBelt_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !output.isEnabled()) {
			output.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MetamodelMessages.ConveyorBelt_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

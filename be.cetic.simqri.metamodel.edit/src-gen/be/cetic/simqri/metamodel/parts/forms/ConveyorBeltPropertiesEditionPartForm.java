/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.forms;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart;

import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;

import be.cetic.simqri.metamodel.providers.MetamodelMessages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.SingleCompositionEditor;

import org.eclipse.emf.eef.runtime.ui.widgets.SingleCompositionEditor.SingleCompositionListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * 
 * 
 */
public class ConveyorBeltPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ConveyorBeltPropertiesEditionPart {

	protected Text name;
	protected Text duration;
	protected ReferencesTable storageOutputFlow;
	protected List<ViewerFilter> storageOutputFlowBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> storageOutputFlowFilters = new ArrayList<ViewerFilter>();
	protected Text minimalSeparationBetweenBatches;
	protected SingleCompositionEditor output;



	/**
	 * For {@link ISection} use only.
	 */
	public ConveyorBeltPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ConveyorBeltPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence conveyorBeltStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = conveyorBeltStep.addStep(MetamodelViewsRepository.ConveyorBelt.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.ConveyorBelt.Properties.name);
		propertiesStep.addStep(MetamodelViewsRepository.ConveyorBelt.Properties.duration);
		propertiesStep.addStep(MetamodelViewsRepository.ConveyorBelt.Properties.storageOutputFlow);
		propertiesStep.addStep(MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches);
		propertiesStep.addStep(MetamodelViewsRepository.ConveyorBelt.Properties.output);
		
		
		composer = new PartComposer(conveyorBeltStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.ConveyorBelt.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.ConveyorBelt.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.ConveyorBelt.Properties.duration) {
					return createDurationText(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.ConveyorBelt.Properties.storageOutputFlow) {
					return createStorageOutputFlowReferencesTable(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches) {
					return createMinimalSeparationBetweenBatchesText(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.ConveyorBelt.Properties.output) {
					return createOutputSingleCompositionEditor(parent, widgetFactory);
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
		propertiesSection.setText(MetamodelMessages.ConveyorBeltPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.ConveyorBelt.Properties.name, MetamodelMessages.ConveyorBeltPropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ConveyorBeltPropertiesEditionPartForm.this,
							MetamodelViewsRepository.ConveyorBelt.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ConveyorBeltPropertiesEditionPartForm.this,
									MetamodelViewsRepository.ConveyorBelt.Properties.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ConveyorBeltPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartForm.this, MetamodelViewsRepository.ConveyorBelt.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, MetamodelViewsRepository.ConveyorBelt.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ConveyorBelt.Properties.name, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createDurationText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.ConveyorBelt.Properties.duration, MetamodelMessages.ConveyorBeltPropertiesEditionPart_DurationLabel);
		duration = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		duration.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData durationData = new GridData(GridData.FILL_HORIZONTAL);
		duration.setLayoutData(durationData);
		duration.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ConveyorBeltPropertiesEditionPartForm.this,
							MetamodelViewsRepository.ConveyorBelt.Properties.duration,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, duration.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ConveyorBeltPropertiesEditionPartForm.this,
									MetamodelViewsRepository.ConveyorBelt.Properties.duration,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, duration.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ConveyorBeltPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		duration.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartForm.this, MetamodelViewsRepository.ConveyorBelt.Properties.duration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, duration.getText()));
				}
			}
		});
		EditingUtils.setID(duration, MetamodelViewsRepository.ConveyorBelt.Properties.duration);
		EditingUtils.setEEFtype(duration, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ConveyorBelt.Properties.duration, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDurationText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createStorageOutputFlowReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.storageOutputFlow = new ReferencesTable(getDescription(MetamodelViewsRepository.ConveyorBelt.Properties.storageOutputFlow, MetamodelMessages.ConveyorBeltPropertiesEditionPart_StorageOutputFlowLabel), new ReferencesTableListener	() {
			public void handleAdd() { addStorageOutputFlow(); }
			public void handleEdit(EObject element) { editStorageOutputFlow(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveStorageOutputFlow(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromStorageOutputFlow(element); }
			public void navigateTo(EObject element) { }
		});
		this.storageOutputFlow.setHelpText(propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ConveyorBelt.Properties.storageOutputFlow, MetamodelViewsRepository.FORM_KIND));
		this.storageOutputFlow.createControls(parent, widgetFactory);
		this.storageOutputFlow.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartForm.this, MetamodelViewsRepository.ConveyorBelt.Properties.storageOutputFlow, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData storageOutputFlowData = new GridData(GridData.FILL_HORIZONTAL);
		storageOutputFlowData.horizontalSpan = 3;
		this.storageOutputFlow.setLayoutData(storageOutputFlowData);
		this.storageOutputFlow.disableMove();
		storageOutputFlow.setID(MetamodelViewsRepository.ConveyorBelt.Properties.storageOutputFlow);
		storageOutputFlow.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createStorageOutputFlowReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addStorageOutputFlow() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(storageOutputFlow.getInput(), storageOutputFlowFilters, storageOutputFlowBusinessFilters,
		"storageOutputFlow", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartForm.this, MetamodelViewsRepository.ConveyorBelt.Properties.storageOutputFlow,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				storageOutputFlow.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveStorageOutputFlow(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartForm.this, MetamodelViewsRepository.ConveyorBelt.Properties.storageOutputFlow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		storageOutputFlow.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromStorageOutputFlow(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartForm.this, MetamodelViewsRepository.ConveyorBelt.Properties.storageOutputFlow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		storageOutputFlow.refresh();
	}

	/**
	 * 
	 */
	protected void editStorageOutputFlow(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				storageOutputFlow.refresh();
			}
		}
	}

	
	protected Composite createMinimalSeparationBetweenBatchesText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches, MetamodelMessages.ConveyorBeltPropertiesEditionPart_MinimalSeparationBetweenBatchesLabel);
		minimalSeparationBetweenBatches = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		minimalSeparationBetweenBatches.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData minimalSeparationBetweenBatchesData = new GridData(GridData.FILL_HORIZONTAL);
		minimalSeparationBetweenBatches.setLayoutData(minimalSeparationBetweenBatchesData);
		minimalSeparationBetweenBatches.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ConveyorBeltPropertiesEditionPartForm.this,
							MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minimalSeparationBetweenBatches.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ConveyorBeltPropertiesEditionPartForm.this,
									MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, minimalSeparationBetweenBatches.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ConveyorBeltPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		minimalSeparationBetweenBatches.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartForm.this, MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minimalSeparationBetweenBatches.getText()));
				}
			}
		});
		EditingUtils.setID(minimalSeparationBetweenBatches, MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches);
		EditingUtils.setEEFtype(minimalSeparationBetweenBatches, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ConveyorBelt.Properties.minimalSeparationBetweenBatches, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMinimalSeparationBetweenBatchesText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createOutputSingleCompositionEditor(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, MetamodelViewsRepository.ConveyorBelt.Properties.output, MetamodelMessages.ConveyorBeltPropertiesEditionPart_OutputLabel);
		//create widget
		output = new SingleCompositionEditor(widgetFactory, parent, SWT.NONE);
		GridData outputData = new GridData(GridData.FILL_HORIZONTAL);
		output.setLayoutData(outputData);
		output.addEditorListener(new SingleCompositionListener() {
			
			public void edit() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartForm.this,  MetamodelViewsRepository.ConveyorBelt.Properties.output, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, null));				
				output.refresh();
			}
			
			public void clear() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ConveyorBeltPropertiesEditionPartForm.this,  MetamodelViewsRepository.ConveyorBelt.Properties.output, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.UNSET, null, null));
				output.refresh();
			}
		});
		output.setID(MetamodelViewsRepository.ConveyorBelt.Properties.output);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ConveyorBelt.Properties.output, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#initStorageOutputFlow(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initStorageOutputFlow(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		storageOutputFlow.setContentProvider(contentProvider);
		storageOutputFlow.setInput(settings);
		storageOutputFlowBusinessFilters.clear();
		storageOutputFlowFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ConveyorBelt.Properties.storageOutputFlow);
		if (eefElementEditorReadOnlyState && storageOutputFlow.getTable().isEnabled()) {
			storageOutputFlow.setEnabled(false);
			storageOutputFlow.setToolTipText(MetamodelMessages.ConveyorBelt_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !storageOutputFlow.getTable().isEnabled()) {
			storageOutputFlow.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#updateStorageOutputFlow()
	 * 
	 */
	public void updateStorageOutputFlow() {
	storageOutputFlow.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#addFilterStorageOutputFlow(ViewerFilter filter)
	 * 
	 */
	public void addFilterToStorageOutputFlow(ViewerFilter filter) {
		storageOutputFlowFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#addBusinessFilterStorageOutputFlow(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToStorageOutputFlow(ViewerFilter filter) {
		storageOutputFlowBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ConveyorBeltPropertiesEditionPart#isContainedInStorageOutputFlowTable(EObject element)
	 * 
	 */
	public boolean isContainedInStorageOutputFlowTable(EObject element) {
		return ((ReferencesTableSettings)storageOutputFlow.getInput()).contains(element);
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

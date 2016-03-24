/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.impl;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart;
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;

import be.cetic.simqri.metamodel.providers.MetamodelMessages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * 
 * 
 */
public class BatchProcessPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, BatchProcessPropertiesEditionPart {

	protected Text name;
	protected Text duration;
	protected ReferencesTable storageOutputFlow;
	protected List<ViewerFilter> storageOutputFlowBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> storageOutputFlowFilters = new ArrayList<ViewerFilter>();
	protected Text percentageOfSuccess;
	protected Text numberOfLines;
	protected ReferencesTable outputs;
	protected List<ViewerFilter> outputsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> outputsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public BatchProcessPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence batchProcessStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = batchProcessStep.addStep(MetamodelViewsRepository.BatchProcess.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.BatchProcess.Properties.name);
		propertiesStep.addStep(MetamodelViewsRepository.BatchProcess.Properties.duration);
		propertiesStep.addStep(MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow);
		propertiesStep.addStep(MetamodelViewsRepository.BatchProcess.Properties.percentageOfSuccess);
		propertiesStep.addStep(MetamodelViewsRepository.BatchProcess.Properties.numberOfLines);
		propertiesStep.addStep(MetamodelViewsRepository.BatchProcess.Properties.outputs);
		
		
		composer = new PartComposer(batchProcessStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.BatchProcess.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == MetamodelViewsRepository.BatchProcess.Properties.name) {
					return createNameText(parent);
				}
				if (key == MetamodelViewsRepository.BatchProcess.Properties.duration) {
					return createDurationText(parent);
				}
				if (key == MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow) {
					return createStorageOutputFlowAdvancedReferencesTable(parent);
				}
				if (key == MetamodelViewsRepository.BatchProcess.Properties.percentageOfSuccess) {
					return createPercentageOfSuccessText(parent);
				}
				if (key == MetamodelViewsRepository.BatchProcess.Properties.numberOfLines) {
					return createNumberOfLinesText(parent);
				}
				if (key == MetamodelViewsRepository.BatchProcess.Properties.outputs) {
					return createOutputsAdvancedTableComposition(parent);
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
		propertiesGroup.setText(MetamodelMessages.BatchProcessPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.BatchProcess.Properties.name, MetamodelMessages.BatchProcessPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, MetamodelViewsRepository.BatchProcess.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.BatchProcess.Properties.name, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createDurationText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.BatchProcess.Properties.duration, MetamodelMessages.BatchProcessPropertiesEditionPart_DurationLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.duration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, duration.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.duration, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, duration.getText()));
				}
			}

		});
		EditingUtils.setID(duration, MetamodelViewsRepository.BatchProcess.Properties.duration);
		EditingUtils.setEEFtype(duration, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.BatchProcess.Properties.duration, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDurationText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createStorageOutputFlowAdvancedReferencesTable(Composite parent) {
		String label = getDescription(MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow, MetamodelMessages.BatchProcessPropertiesEditionPart_StorageOutputFlowLabel);		 
		this.storageOutputFlow = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addStorageOutputFlow(); }
			public void handleEdit(EObject element) { editStorageOutputFlow(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveStorageOutputFlow(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromStorageOutputFlow(element); }
			public void navigateTo(EObject element) { }
		});
		this.storageOutputFlow.setHelpText(propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow, MetamodelViewsRepository.SWT_KIND));
		this.storageOutputFlow.createControls(parent);
		this.storageOutputFlow.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData storageOutputFlowData = new GridData(GridData.FILL_HORIZONTAL);
		storageOutputFlowData.horizontalSpan = 3;
		this.storageOutputFlow.setLayoutData(storageOutputFlowData);
		this.storageOutputFlow.disableMove();
		storageOutputFlow.setID(MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow);
		storageOutputFlow.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow,
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		storageOutputFlow.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromStorageOutputFlow(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
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

	
	protected Composite createPercentageOfSuccessText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.BatchProcess.Properties.percentageOfSuccess, MetamodelMessages.BatchProcessPropertiesEditionPart_PercentageOfSuccessLabel);
		percentageOfSuccess = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData percentageOfSuccessData = new GridData(GridData.FILL_HORIZONTAL);
		percentageOfSuccess.setLayoutData(percentageOfSuccessData);
		percentageOfSuccess.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.percentageOfSuccess, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, percentageOfSuccess.getText()));
			}

		});
		percentageOfSuccess.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.percentageOfSuccess, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, percentageOfSuccess.getText()));
				}
			}

		});
		EditingUtils.setID(percentageOfSuccess, MetamodelViewsRepository.BatchProcess.Properties.percentageOfSuccess);
		EditingUtils.setEEFtype(percentageOfSuccess, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.BatchProcess.Properties.percentageOfSuccess, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPercentageOfSuccessText

		// End of user code
		return parent;
	}

	
	protected Composite createNumberOfLinesText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.BatchProcess.Properties.numberOfLines, MetamodelMessages.BatchProcessPropertiesEditionPart_NumberOfLinesLabel);
		numberOfLines = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData numberOfLinesData = new GridData(GridData.FILL_HORIZONTAL);
		numberOfLines.setLayoutData(numberOfLinesData);
		numberOfLines.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.numberOfLines, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, numberOfLines.getText()));
			}

		});
		numberOfLines.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.numberOfLines, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, numberOfLines.getText()));
				}
			}

		});
		EditingUtils.setID(numberOfLines, MetamodelViewsRepository.BatchProcess.Properties.numberOfLines);
		EditingUtils.setEEFtype(numberOfLines, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.BatchProcess.Properties.numberOfLines, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNumberOfLinesText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createOutputsAdvancedTableComposition(Composite parent) {
		this.outputs = new ReferencesTable(getDescription(MetamodelViewsRepository.BatchProcess.Properties.outputs, MetamodelMessages.BatchProcessPropertiesEditionPart_OutputsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.outputs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				outputs.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.outputs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				outputs.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.outputs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				outputs.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.outputs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				outputs.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.outputsFilters) {
			this.outputs.addFilter(filter);
		}
		this.outputs.setHelpText(propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.BatchProcess.Properties.outputs, MetamodelViewsRepository.SWT_KIND));
		this.outputs.createControls(parent);
		this.outputs.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BatchProcessPropertiesEditionPartImpl.this, MetamodelViewsRepository.BatchProcess.Properties.outputs, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData outputsData = new GridData(GridData.FILL_HORIZONTAL);
		outputsData.horizontalSpan = 3;
		this.outputs.setLayoutData(outputsData);
		this.outputs.setLowerBound(0);
		this.outputs.setUpperBound(-1);
		outputs.setID(MetamodelViewsRepository.BatchProcess.Properties.outputs);
		outputs.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createOutputsAdvancedTableComposition

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
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.BatchProcess.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(MetamodelMessages.BatchProcess_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#getDuration()
	 * 
	 */
	public String getDuration() {
		return duration.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#setDuration(String newValue)
	 * 
	 */
	public void setDuration(String newValue) {
		if (newValue != null) {
			duration.setText(newValue);
		} else {
			duration.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.BatchProcess.Properties.duration);
		if (eefElementEditorReadOnlyState && duration.isEnabled()) {
			duration.setEnabled(false);
			duration.setToolTipText(MetamodelMessages.BatchProcess_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !duration.isEnabled()) {
			duration.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#initStorageOutputFlow(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initStorageOutputFlow(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		storageOutputFlow.setContentProvider(contentProvider);
		storageOutputFlow.setInput(settings);
		storageOutputFlowBusinessFilters.clear();
		storageOutputFlowFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.BatchProcess.Properties.storageOutputFlow);
		if (eefElementEditorReadOnlyState && storageOutputFlow.getTable().isEnabled()) {
			storageOutputFlow.setEnabled(false);
			storageOutputFlow.setToolTipText(MetamodelMessages.BatchProcess_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !storageOutputFlow.getTable().isEnabled()) {
			storageOutputFlow.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#updateStorageOutputFlow()
	 * 
	 */
	public void updateStorageOutputFlow() {
	storageOutputFlow.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#addFilterStorageOutputFlow(ViewerFilter filter)
	 * 
	 */
	public void addFilterToStorageOutputFlow(ViewerFilter filter) {
		storageOutputFlowFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#addBusinessFilterStorageOutputFlow(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToStorageOutputFlow(ViewerFilter filter) {
		storageOutputFlowBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#isContainedInStorageOutputFlowTable(EObject element)
	 * 
	 */
	public boolean isContainedInStorageOutputFlowTable(EObject element) {
		return ((ReferencesTableSettings)storageOutputFlow.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#getPercentageOfSuccess()
	 * 
	 */
	public String getPercentageOfSuccess() {
		return percentageOfSuccess.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#setPercentageOfSuccess(String newValue)
	 * 
	 */
	public void setPercentageOfSuccess(String newValue) {
		if (newValue != null) {
			percentageOfSuccess.setText(newValue);
		} else {
			percentageOfSuccess.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.BatchProcess.Properties.percentageOfSuccess);
		if (eefElementEditorReadOnlyState && percentageOfSuccess.isEnabled()) {
			percentageOfSuccess.setEnabled(false);
			percentageOfSuccess.setToolTipText(MetamodelMessages.BatchProcess_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !percentageOfSuccess.isEnabled()) {
			percentageOfSuccess.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#getNumberOfLines()
	 * 
	 */
	public String getNumberOfLines() {
		return numberOfLines.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#setNumberOfLines(String newValue)
	 * 
	 */
	public void setNumberOfLines(String newValue) {
		if (newValue != null) {
			numberOfLines.setText(newValue);
		} else {
			numberOfLines.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.BatchProcess.Properties.numberOfLines);
		if (eefElementEditorReadOnlyState && numberOfLines.isEnabled()) {
			numberOfLines.setEnabled(false);
			numberOfLines.setToolTipText(MetamodelMessages.BatchProcess_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !numberOfLines.isEnabled()) {
			numberOfLines.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#initOutputs(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOutputs(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		outputs.setContentProvider(contentProvider);
		outputs.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.BatchProcess.Properties.outputs);
		if (eefElementEditorReadOnlyState && outputs.isEnabled()) {
			outputs.setEnabled(false);
			outputs.setToolTipText(MetamodelMessages.BatchProcess_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputs.isEnabled()) {
			outputs.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#updateOutputs()
	 * 
	 */
	public void updateOutputs() {
	outputs.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#addFilterOutputs(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOutputs(ViewerFilter filter) {
		outputsFilters.add(filter);
		if (this.outputs != null) {
			this.outputs.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#addBusinessFilterOutputs(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOutputs(ViewerFilter filter) {
		outputsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BatchProcessPropertiesEditionPart#isContainedInOutputsTable(EObject element)
	 * 
	 */
	public boolean isContainedInOutputsTable(EObject element) {
		return ((ReferencesTableSettings)outputs.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MetamodelMessages.BatchProcess_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.impl;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.OutputPropertiesEditionPart;

import be.cetic.simqri.metamodel.providers.MetamodelMessages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

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

import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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
public class OutputPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, OutputPropertiesEditionPart {

	protected EMFComboViewer type;
	protected ReferencesTable processOutputFlow;
	protected List<ViewerFilter> processOutputFlowBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> processOutputFlowFilters = new ArrayList<ViewerFilter>();
	protected Text description;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public OutputPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence outputStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = outputStep.addStep(MetamodelViewsRepository.Output.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.Output.Properties.type);
		propertiesStep.addStep(MetamodelViewsRepository.Output.Properties.processOutputFlow);
		propertiesStep.addStep(MetamodelViewsRepository.Output.Properties.description);
		
		
		composer = new PartComposer(outputStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.Output.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == MetamodelViewsRepository.Output.Properties.type) {
					return createTypeEMFComboViewer(parent);
				}
				if (key == MetamodelViewsRepository.Output.Properties.processOutputFlow) {
					return createProcessOutputFlowAdvancedReferencesTable(parent);
				}
				if (key == MetamodelViewsRepository.Output.Properties.description) {
					return createDescriptionText(parent);
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
		propertiesGroup.setText(MetamodelMessages.OutputPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createTypeEMFComboViewer(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Output.Properties.type, MetamodelMessages.OutputPropertiesEditionPart_TypeLabel);
		type = new EMFComboViewer(parent);
		type.setContentProvider(new ArrayContentProvider());
		type.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.getCombo().setLayoutData(typeData);
		type.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OutputPropertiesEditionPartImpl.this, MetamodelViewsRepository.Output.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getType()));
			}

		});
		type.setID(MetamodelViewsRepository.Output.Properties.type);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Output.Properties.type, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createProcessOutputFlowAdvancedReferencesTable(Composite parent) {
		String label = getDescription(MetamodelViewsRepository.Output.Properties.processOutputFlow, MetamodelMessages.OutputPropertiesEditionPart_ProcessOutputFlowLabel);		 
		this.processOutputFlow = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addProcessOutputFlow(); }
			public void handleEdit(EObject element) { editProcessOutputFlow(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveProcessOutputFlow(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromProcessOutputFlow(element); }
			public void navigateTo(EObject element) { }
		});
		this.processOutputFlow.setHelpText(propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Output.Properties.processOutputFlow, MetamodelViewsRepository.SWT_KIND));
		this.processOutputFlow.createControls(parent);
		this.processOutputFlow.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OutputPropertiesEditionPartImpl.this, MetamodelViewsRepository.Output.Properties.processOutputFlow, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData processOutputFlowData = new GridData(GridData.FILL_HORIZONTAL);
		processOutputFlowData.horizontalSpan = 3;
		this.processOutputFlow.setLayoutData(processOutputFlowData);
		this.processOutputFlow.disableMove();
		processOutputFlow.setID(MetamodelViewsRepository.Output.Properties.processOutputFlow);
		processOutputFlow.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addProcessOutputFlow() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(processOutputFlow.getInput(), processOutputFlowFilters, processOutputFlowBusinessFilters,
		"processOutputFlow", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OutputPropertiesEditionPartImpl.this, MetamodelViewsRepository.Output.Properties.processOutputFlow,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				processOutputFlow.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveProcessOutputFlow(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OutputPropertiesEditionPartImpl.this, MetamodelViewsRepository.Output.Properties.processOutputFlow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		processOutputFlow.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromProcessOutputFlow(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OutputPropertiesEditionPartImpl.this, MetamodelViewsRepository.Output.Properties.processOutputFlow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		processOutputFlow.refresh();
	}

	/**
	 * 
	 */
	protected void editProcessOutputFlow(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				processOutputFlow.refresh();
			}
		}
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Output.Properties.description, MetamodelMessages.OutputPropertiesEditionPart_DescriptionLabel);
		description = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OutputPropertiesEditionPartImpl.this, MetamodelViewsRepository.Output.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		description.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OutputPropertiesEditionPartImpl.this, MetamodelViewsRepository.Output.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, MetamodelViewsRepository.Output.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Output.Properties.description, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

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
	 * @see be.cetic.simqri.metamodel.parts.OutputPropertiesEditionPart#getType()
	 * 
	 */
	public Enumerator getType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) type.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OutputPropertiesEditionPart#initType(Object input, Enumerator current)
	 */
	public void initType(Object input, Enumerator current) {
		type.setInput(input);
		type.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Output.Properties.type);
		if (eefElementEditorReadOnlyState && type.isEnabled()) {
			type.setEnabled(false);
			type.setToolTipText(MetamodelMessages.Output_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !type.isEnabled()) {
			type.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OutputPropertiesEditionPart#setType(Enumerator newValue)
	 * 
	 */
	public void setType(Enumerator newValue) {
		type.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Output.Properties.type);
		if (eefElementEditorReadOnlyState && type.isEnabled()) {
			type.setEnabled(false);
			type.setToolTipText(MetamodelMessages.Output_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !type.isEnabled()) {
			type.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OutputPropertiesEditionPart#initProcessOutputFlow(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initProcessOutputFlow(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		processOutputFlow.setContentProvider(contentProvider);
		processOutputFlow.setInput(settings);
		processOutputFlowBusinessFilters.clear();
		processOutputFlowFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Output.Properties.processOutputFlow);
		if (eefElementEditorReadOnlyState && processOutputFlow.getTable().isEnabled()) {
			processOutputFlow.setEnabled(false);
			processOutputFlow.setToolTipText(MetamodelMessages.Output_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !processOutputFlow.getTable().isEnabled()) {
			processOutputFlow.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OutputPropertiesEditionPart#updateProcessOutputFlow()
	 * 
	 */
	public void updateProcessOutputFlow() {
	processOutputFlow.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OutputPropertiesEditionPart#addFilterProcessOutputFlow(ViewerFilter filter)
	 * 
	 */
	public void addFilterToProcessOutputFlow(ViewerFilter filter) {
		processOutputFlowFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OutputPropertiesEditionPart#addBusinessFilterProcessOutputFlow(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToProcessOutputFlow(ViewerFilter filter) {
		processOutputFlowBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OutputPropertiesEditionPart#isContainedInProcessOutputFlowTable(EObject element)
	 * 
	 */
	public boolean isContainedInProcessOutputFlowTable(EObject element) {
		return ((ReferencesTableSettings)processOutputFlow.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OutputPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OutputPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Output.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(MetamodelMessages.Output_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MetamodelMessages.Output_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

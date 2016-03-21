/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.impl;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart;

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

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * 
 * 
 */
public class StoragePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, StoragePropertiesEditionPart {

	protected Text name;
	protected Text size;
	protected Text initialContent;
	protected Button overflow;
	protected ReferencesTable storageOutputFlow;
	protected List<ViewerFilter> storageOutputFlowBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> storageOutputFlowFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public StoragePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence storageStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = storageStep.addStep(MetamodelViewsRepository.Storage.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.Storage.Properties.name);
		propertiesStep.addStep(MetamodelViewsRepository.Storage.Properties.size);
		propertiesStep.addStep(MetamodelViewsRepository.Storage.Properties.initialContent);
		propertiesStep.addStep(MetamodelViewsRepository.Storage.Properties.overflow);
		propertiesStep.addStep(MetamodelViewsRepository.Storage.Properties.storageOutputFlow);
		
		
		composer = new PartComposer(storageStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.Storage.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == MetamodelViewsRepository.Storage.Properties.name) {
					return createNameText(parent);
				}
				if (key == MetamodelViewsRepository.Storage.Properties.size) {
					return createSizeText(parent);
				}
				if (key == MetamodelViewsRepository.Storage.Properties.initialContent) {
					return createInitialContentText(parent);
				}
				if (key == MetamodelViewsRepository.Storage.Properties.overflow) {
					return createOverflowCheckbox(parent);
				}
				if (key == MetamodelViewsRepository.Storage.Properties.storageOutputFlow) {
					return createStorageOutputFlowAdvancedReferencesTable(parent);
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
		propertiesGroup.setText(MetamodelMessages.StoragePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Storage.Properties.name, MetamodelMessages.StoragePropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoragePropertiesEditionPartImpl.this, MetamodelViewsRepository.Storage.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoragePropertiesEditionPartImpl.this, MetamodelViewsRepository.Storage.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, MetamodelViewsRepository.Storage.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Storage.Properties.name, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createSizeText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Storage.Properties.size, MetamodelMessages.StoragePropertiesEditionPart_SizeLabel);
		size = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData sizeData = new GridData(GridData.FILL_HORIZONTAL);
		size.setLayoutData(sizeData);
		size.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoragePropertiesEditionPartImpl.this, MetamodelViewsRepository.Storage.Properties.size, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, size.getText()));
			}

		});
		size.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoragePropertiesEditionPartImpl.this, MetamodelViewsRepository.Storage.Properties.size, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, size.getText()));
				}
			}

		});
		EditingUtils.setID(size, MetamodelViewsRepository.Storage.Properties.size);
		EditingUtils.setEEFtype(size, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Storage.Properties.size, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSizeText

		// End of user code
		return parent;
	}

	
	protected Composite createInitialContentText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Storage.Properties.initialContent, MetamodelMessages.StoragePropertiesEditionPart_InitialContentLabel);
		initialContent = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData initialContentData = new GridData(GridData.FILL_HORIZONTAL);
		initialContent.setLayoutData(initialContentData);
		initialContent.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoragePropertiesEditionPartImpl.this, MetamodelViewsRepository.Storage.Properties.initialContent, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, initialContent.getText()));
			}

		});
		initialContent.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoragePropertiesEditionPartImpl.this, MetamodelViewsRepository.Storage.Properties.initialContent, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, initialContent.getText()));
				}
			}

		});
		EditingUtils.setID(initialContent, MetamodelViewsRepository.Storage.Properties.initialContent);
		EditingUtils.setEEFtype(initialContent, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Storage.Properties.initialContent, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInitialContentText

		// End of user code
		return parent;
	}

	
	protected Composite createOverflowCheckbox(Composite parent) {
		overflow = new Button(parent, SWT.CHECK);
		overflow.setText(getDescription(MetamodelViewsRepository.Storage.Properties.overflow, MetamodelMessages.StoragePropertiesEditionPart_OverflowLabel));
		overflow.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoragePropertiesEditionPartImpl.this, MetamodelViewsRepository.Storage.Properties.overflow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(overflow.getSelection())));
			}

		});
		GridData overflowData = new GridData(GridData.FILL_HORIZONTAL);
		overflowData.horizontalSpan = 2;
		overflow.setLayoutData(overflowData);
		EditingUtils.setID(overflow, MetamodelViewsRepository.Storage.Properties.overflow);
		EditingUtils.setEEFtype(overflow, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Storage.Properties.overflow, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOverflowCheckbox

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createStorageOutputFlowAdvancedReferencesTable(Composite parent) {
		String label = getDescription(MetamodelViewsRepository.Storage.Properties.storageOutputFlow, MetamodelMessages.StoragePropertiesEditionPart_StorageOutputFlowLabel);		 
		this.storageOutputFlow = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addStorageOutputFlow(); }
			public void handleEdit(EObject element) { editStorageOutputFlow(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveStorageOutputFlow(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromStorageOutputFlow(element); }
			public void navigateTo(EObject element) { }
		});
		this.storageOutputFlow.setHelpText(propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Storage.Properties.storageOutputFlow, MetamodelViewsRepository.SWT_KIND));
		this.storageOutputFlow.createControls(parent);
		this.storageOutputFlow.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoragePropertiesEditionPartImpl.this, MetamodelViewsRepository.Storage.Properties.storageOutputFlow, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData storageOutputFlowData = new GridData(GridData.FILL_HORIZONTAL);
		storageOutputFlowData.horizontalSpan = 3;
		this.storageOutputFlow.setLayoutData(storageOutputFlowData);
		this.storageOutputFlow.disableMove();
		storageOutputFlow.setID(MetamodelViewsRepository.Storage.Properties.storageOutputFlow);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoragePropertiesEditionPartImpl.this, MetamodelViewsRepository.Storage.Properties.storageOutputFlow,
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoragePropertiesEditionPartImpl.this, MetamodelViewsRepository.Storage.Properties.storageOutputFlow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		storageOutputFlow.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromStorageOutputFlow(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StoragePropertiesEditionPartImpl.this, MetamodelViewsRepository.Storage.Properties.storageOutputFlow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
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
	 * @see be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Storage.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(MetamodelMessages.Storage_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart#getSize()
	 * 
	 */
	public String getSize() {
		return size.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart#setSize(String newValue)
	 * 
	 */
	public void setSize(String newValue) {
		if (newValue != null) {
			size.setText(newValue);
		} else {
			size.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Storage.Properties.size);
		if (eefElementEditorReadOnlyState && size.isEnabled()) {
			size.setEnabled(false);
			size.setToolTipText(MetamodelMessages.Storage_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !size.isEnabled()) {
			size.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart#getInitialContent()
	 * 
	 */
	public String getInitialContent() {
		return initialContent.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart#setInitialContent(String newValue)
	 * 
	 */
	public void setInitialContent(String newValue) {
		if (newValue != null) {
			initialContent.setText(newValue);
		} else {
			initialContent.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Storage.Properties.initialContent);
		if (eefElementEditorReadOnlyState && initialContent.isEnabled()) {
			initialContent.setEnabled(false);
			initialContent.setToolTipText(MetamodelMessages.Storage_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !initialContent.isEnabled()) {
			initialContent.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart#getOverflow()
	 * 
	 */
	public Boolean getOverflow() {
		return Boolean.valueOf(overflow.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart#setOverflow(Boolean newValue)
	 * 
	 */
	public void setOverflow(Boolean newValue) {
		if (newValue != null) {
			overflow.setSelection(newValue.booleanValue());
		} else {
			overflow.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Storage.Properties.overflow);
		if (eefElementEditorReadOnlyState && overflow.isEnabled()) {
			overflow.setEnabled(false);
			overflow.setToolTipText(MetamodelMessages.Storage_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !overflow.isEnabled()) {
			overflow.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart#initStorageOutputFlow(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initStorageOutputFlow(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		storageOutputFlow.setContentProvider(contentProvider);
		storageOutputFlow.setInput(settings);
		storageOutputFlowBusinessFilters.clear();
		storageOutputFlowFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Storage.Properties.storageOutputFlow);
		if (eefElementEditorReadOnlyState && storageOutputFlow.getTable().isEnabled()) {
			storageOutputFlow.setEnabled(false);
			storageOutputFlow.setToolTipText(MetamodelMessages.Storage_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !storageOutputFlow.getTable().isEnabled()) {
			storageOutputFlow.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart#updateStorageOutputFlow()
	 * 
	 */
	public void updateStorageOutputFlow() {
	storageOutputFlow.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart#addFilterStorageOutputFlow(ViewerFilter filter)
	 * 
	 */
	public void addFilterToStorageOutputFlow(ViewerFilter filter) {
		storageOutputFlowFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart#addBusinessFilterStorageOutputFlow(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToStorageOutputFlow(ViewerFilter filter) {
		storageOutputFlowBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StoragePropertiesEditionPart#isContainedInStorageOutputFlowTable(EObject element)
	 * 
	 */
	public boolean isContainedInStorageOutputFlowTable(EObject element) {
		return ((ReferencesTableSettings)storageOutputFlow.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MetamodelMessages.Storage_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

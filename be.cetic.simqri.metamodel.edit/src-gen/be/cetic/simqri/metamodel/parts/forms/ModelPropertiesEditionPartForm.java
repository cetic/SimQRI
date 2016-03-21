/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.forms;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart;

import be.cetic.simqri.metamodel.providers.MetamodelMessages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

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
public class ModelPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ModelPropertiesEditionPart {

	protected Text name;
	protected Button valid;
	protected ReferencesTable query;
	protected List<ViewerFilter> queryBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> queryFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable component;
	protected List<ViewerFilter> componentBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> componentFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable flow;
	protected List<ViewerFilter> flowBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> flowFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public ModelPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ModelPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence modelStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = modelStep.addStep(MetamodelViewsRepository.Model.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.Model.Properties.name);
		propertiesStep.addStep(MetamodelViewsRepository.Model.Properties.valid);
		propertiesStep.addStep(MetamodelViewsRepository.Model.Properties.query);
		propertiesStep.addStep(MetamodelViewsRepository.Model.Properties.component);
		propertiesStep.addStep(MetamodelViewsRepository.Model.Properties.flow);
		
		
		composer = new PartComposer(modelStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.Model.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Model.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Model.Properties.valid) {
					return createValidCheckbox(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Model.Properties.query) {
					return createQueryTableComposition(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Model.Properties.component) {
					return createComponentTableComposition(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Model.Properties.flow) {
					return createFlowTableComposition(widgetFactory, parent);
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
		propertiesSection.setText(MetamodelMessages.ModelPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, MetamodelViewsRepository.Model.Properties.name, MetamodelMessages.ModelPropertiesEditionPart_NameLabel);
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
							ModelPropertiesEditionPartForm.this,
							MetamodelViewsRepository.Model.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ModelPropertiesEditionPartForm.this,
									MetamodelViewsRepository.Model.Properties.name,
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
									ModelPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, MetamodelViewsRepository.Model.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Model.Properties.name, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createValidCheckbox(FormToolkit widgetFactory, Composite parent) {
		valid = widgetFactory.createButton(parent, getDescription(MetamodelViewsRepository.Model.Properties.valid, MetamodelMessages.ModelPropertiesEditionPart_ValidLabel), SWT.CHECK);
		valid.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.valid, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(valid.getSelection())));
			}

		});
		GridData validData = new GridData(GridData.FILL_HORIZONTAL);
		validData.horizontalSpan = 2;
		valid.setLayoutData(validData);
		EditingUtils.setID(valid, MetamodelViewsRepository.Model.Properties.valid);
		EditingUtils.setEEFtype(valid, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Model.Properties.valid, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValidCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createQueryTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.query = new ReferencesTable(getDescription(MetamodelViewsRepository.Model.Properties.query, MetamodelMessages.ModelPropertiesEditionPart_QueryLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.query, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				query.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.query, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				query.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.query, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				query.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.query, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				query.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.queryFilters) {
			this.query.addFilter(filter);
		}
		this.query.setHelpText(propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Model.Properties.query, MetamodelViewsRepository.FORM_KIND));
		this.query.createControls(parent, widgetFactory);
		this.query.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.query, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData queryData = new GridData(GridData.FILL_HORIZONTAL);
		queryData.horizontalSpan = 3;
		this.query.setLayoutData(queryData);
		this.query.setLowerBound(0);
		this.query.setUpperBound(-1);
		query.setID(MetamodelViewsRepository.Model.Properties.query);
		query.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createQueryTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createComponentTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.component = new ReferencesTable(getDescription(MetamodelViewsRepository.Model.Properties.component, MetamodelMessages.ModelPropertiesEditionPart_ComponentLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.component, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				component.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.component, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				component.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.component, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				component.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.component, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				component.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.componentFilters) {
			this.component.addFilter(filter);
		}
		this.component.setHelpText(propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Model.Properties.component, MetamodelViewsRepository.FORM_KIND));
		this.component.createControls(parent, widgetFactory);
		this.component.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.component, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData componentData = new GridData(GridData.FILL_HORIZONTAL);
		componentData.horizontalSpan = 3;
		this.component.setLayoutData(componentData);
		this.component.setLowerBound(0);
		this.component.setUpperBound(-1);
		component.setID(MetamodelViewsRepository.Model.Properties.component);
		component.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createComponentTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createFlowTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.flow = new ReferencesTable(getDescription(MetamodelViewsRepository.Model.Properties.flow, MetamodelMessages.ModelPropertiesEditionPart_FlowLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.flow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				flow.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.flow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				flow.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.flow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				flow.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.flow, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				flow.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.flowFilters) {
			this.flow.addFilter(filter);
		}
		this.flow.setHelpText(propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Model.Properties.flow, MetamodelViewsRepository.FORM_KIND));
		this.flow.createControls(parent, widgetFactory);
		this.flow.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelPropertiesEditionPartForm.this, MetamodelViewsRepository.Model.Properties.flow, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData flowData = new GridData(GridData.FILL_HORIZONTAL);
		flowData.horizontalSpan = 3;
		this.flow.setLayoutData(flowData);
		this.flow.setLowerBound(0);
		this.flow.setUpperBound(-1);
		flow.setID(MetamodelViewsRepository.Model.Properties.flow);
		flow.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createFlowTableComposition

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
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Model.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(MetamodelMessages.Model_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#getValid()
	 * 
	 */
	public Boolean getValid() {
		return Boolean.valueOf(valid.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#setValid(Boolean newValue)
	 * 
	 */
	public void setValid(Boolean newValue) {
		if (newValue != null) {
			valid.setSelection(newValue.booleanValue());
		} else {
			valid.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Model.Properties.valid);
		if (eefElementEditorReadOnlyState && valid.isEnabled()) {
			valid.setEnabled(false);
			valid.setToolTipText(MetamodelMessages.Model_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !valid.isEnabled()) {
			valid.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#initQuery(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initQuery(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		query.setContentProvider(contentProvider);
		query.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Model.Properties.query);
		if (eefElementEditorReadOnlyState && query.isEnabled()) {
			query.setEnabled(false);
			query.setToolTipText(MetamodelMessages.Model_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !query.isEnabled()) {
			query.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#updateQuery()
	 * 
	 */
	public void updateQuery() {
	query.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#addFilterQuery(ViewerFilter filter)
	 * 
	 */
	public void addFilterToQuery(ViewerFilter filter) {
		queryFilters.add(filter);
		if (this.query != null) {
			this.query.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#addBusinessFilterQuery(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToQuery(ViewerFilter filter) {
		queryBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#isContainedInQueryTable(EObject element)
	 * 
	 */
	public boolean isContainedInQueryTable(EObject element) {
		return ((ReferencesTableSettings)query.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#initComponent(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initComponent(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		component.setContentProvider(contentProvider);
		component.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Model.Properties.component);
		if (eefElementEditorReadOnlyState && component.isEnabled()) {
			component.setEnabled(false);
			component.setToolTipText(MetamodelMessages.Model_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !component.isEnabled()) {
			component.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#updateComponent()
	 * 
	 */
	public void updateComponent() {
	component.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#addFilterComponent(ViewerFilter filter)
	 * 
	 */
	public void addFilterToComponent(ViewerFilter filter) {
		componentFilters.add(filter);
		if (this.component != null) {
			this.component.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#addBusinessFilterComponent(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToComponent(ViewerFilter filter) {
		componentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#isContainedInComponentTable(EObject element)
	 * 
	 */
	public boolean isContainedInComponentTable(EObject element) {
		return ((ReferencesTableSettings)component.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#initFlow(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initFlow(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		flow.setContentProvider(contentProvider);
		flow.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Model.Properties.flow);
		if (eefElementEditorReadOnlyState && flow.isEnabled()) {
			flow.setEnabled(false);
			flow.setToolTipText(MetamodelMessages.Model_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !flow.isEnabled()) {
			flow.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#updateFlow()
	 * 
	 */
	public void updateFlow() {
	flow.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#addFilterFlow(ViewerFilter filter)
	 * 
	 */
	public void addFilterToFlow(ViewerFilter filter) {
		flowFilters.add(filter);
		if (this.flow != null) {
			this.flow.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#addBusinessFilterFlow(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToFlow(ViewerFilter filter) {
		flowBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ModelPropertiesEditionPart#isContainedInFlowTable(EObject element)
	 * 
	 */
	public boolean isContainedInFlowTable(EObject element) {
		return ((ReferencesTableSettings)flow.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MetamodelMessages.Model_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

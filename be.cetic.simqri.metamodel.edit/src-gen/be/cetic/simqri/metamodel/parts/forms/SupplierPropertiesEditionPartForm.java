/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.forms;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart;

import be.cetic.simqri.metamodel.providers.MetamodelMessages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

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

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

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
public class SupplierPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, SupplierPropertiesEditionPart {

	protected Text name;
	protected Text deliveredPercentage;
	protected ReferencesTable refillPolicy;
	protected List<ViewerFilter> refillPolicyBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> refillPolicyFilters = new ArrayList<ViewerFilter>();
	protected SingleCompositionEditor delay;



	/**
	 * For {@link ISection} use only.
	 */
	public SupplierPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SupplierPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence supplierStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = supplierStep.addStep(MetamodelViewsRepository.Supplier.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.Supplier.Properties.name);
		propertiesStep.addStep(MetamodelViewsRepository.Supplier.Properties.deliveredPercentage);
		propertiesStep.addStep(MetamodelViewsRepository.Supplier.Properties.refillPolicy);
		propertiesStep.addStep(MetamodelViewsRepository.Supplier.Properties.delay);
		
		
		composer = new PartComposer(supplierStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.Supplier.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Supplier.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Supplier.Properties.deliveredPercentage) {
					return createDeliveredPercentageText(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Supplier.Properties.refillPolicy) {
					return createRefillPolicyReferencesTable(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Supplier.Properties.delay) {
					return createDelaySingleCompositionEditor(parent, widgetFactory);
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
		propertiesSection.setText(MetamodelMessages.SupplierPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, MetamodelViewsRepository.Supplier.Properties.name, MetamodelMessages.SupplierPropertiesEditionPart_NameLabel);
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
							SupplierPropertiesEditionPartForm.this,
							MetamodelViewsRepository.Supplier.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SupplierPropertiesEditionPartForm.this,
									MetamodelViewsRepository.Supplier.Properties.name,
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
									SupplierPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SupplierPropertiesEditionPartForm.this, MetamodelViewsRepository.Supplier.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, MetamodelViewsRepository.Supplier.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Supplier.Properties.name, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createDeliveredPercentageText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Supplier.Properties.deliveredPercentage, MetamodelMessages.SupplierPropertiesEditionPart_DeliveredPercentageLabel);
		deliveredPercentage = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		deliveredPercentage.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData deliveredPercentageData = new GridData(GridData.FILL_HORIZONTAL);
		deliveredPercentage.setLayoutData(deliveredPercentageData);
		deliveredPercentage.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SupplierPropertiesEditionPartForm.this,
							MetamodelViewsRepository.Supplier.Properties.deliveredPercentage,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, deliveredPercentage.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SupplierPropertiesEditionPartForm.this,
									MetamodelViewsRepository.Supplier.Properties.deliveredPercentage,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, deliveredPercentage.getText()));
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
									SupplierPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		deliveredPercentage.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SupplierPropertiesEditionPartForm.this, MetamodelViewsRepository.Supplier.Properties.deliveredPercentage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, deliveredPercentage.getText()));
				}
			}
		});
		EditingUtils.setID(deliveredPercentage, MetamodelViewsRepository.Supplier.Properties.deliveredPercentage);
		EditingUtils.setEEFtype(deliveredPercentage, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Supplier.Properties.deliveredPercentage, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDeliveredPercentageText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createRefillPolicyReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.refillPolicy = new ReferencesTable(getDescription(MetamodelViewsRepository.Supplier.Properties.refillPolicy, MetamodelMessages.SupplierPropertiesEditionPart_RefillPolicyLabel), new ReferencesTableListener	() {
			public void handleAdd() { addRefillPolicy(); }
			public void handleEdit(EObject element) { editRefillPolicy(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveRefillPolicy(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromRefillPolicy(element); }
			public void navigateTo(EObject element) { }
		});
		this.refillPolicy.setHelpText(propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Supplier.Properties.refillPolicy, MetamodelViewsRepository.FORM_KIND));
		this.refillPolicy.createControls(parent, widgetFactory);
		this.refillPolicy.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SupplierPropertiesEditionPartForm.this, MetamodelViewsRepository.Supplier.Properties.refillPolicy, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData refillPolicyData = new GridData(GridData.FILL_HORIZONTAL);
		refillPolicyData.horizontalSpan = 3;
		this.refillPolicy.setLayoutData(refillPolicyData);
		this.refillPolicy.disableMove();
		refillPolicy.setID(MetamodelViewsRepository.Supplier.Properties.refillPolicy);
		refillPolicy.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createRefillPolicyReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addRefillPolicy() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(refillPolicy.getInput(), refillPolicyFilters, refillPolicyBusinessFilters,
		"refillPolicy", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SupplierPropertiesEditionPartForm.this, MetamodelViewsRepository.Supplier.Properties.refillPolicy,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				refillPolicy.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveRefillPolicy(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SupplierPropertiesEditionPartForm.this, MetamodelViewsRepository.Supplier.Properties.refillPolicy, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		refillPolicy.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromRefillPolicy(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SupplierPropertiesEditionPartForm.this, MetamodelViewsRepository.Supplier.Properties.refillPolicy, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		refillPolicy.refresh();
	}

	/**
	 * 
	 */
	protected void editRefillPolicy(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				refillPolicy.refresh();
			}
		}
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createDelaySingleCompositionEditor(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, MetamodelViewsRepository.Supplier.Properties.delay, MetamodelMessages.SupplierPropertiesEditionPart_DelayLabel);
		//create widget
		delay = new SingleCompositionEditor(widgetFactory, parent, SWT.NONE);
		GridData delayData = new GridData(GridData.FILL_HORIZONTAL);
		delay.setLayoutData(delayData);
		delay.addEditorListener(new SingleCompositionListener() {
			
			public void edit() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SupplierPropertiesEditionPartForm.this,  MetamodelViewsRepository.Supplier.Properties.delay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, null));				
				delay.refresh();
			}
			
			public void clear() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SupplierPropertiesEditionPartForm.this,  MetamodelViewsRepository.Supplier.Properties.delay, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.UNSET, null, null));
				delay.refresh();
			}
		});
		delay.setID(MetamodelViewsRepository.Supplier.Properties.delay);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Supplier.Properties.delay, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Supplier.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(MetamodelMessages.Supplier_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart#getDeliveredPercentage()
	 * 
	 */
	public String getDeliveredPercentage() {
		return deliveredPercentage.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart#setDeliveredPercentage(String newValue)
	 * 
	 */
	public void setDeliveredPercentage(String newValue) {
		if (newValue != null) {
			deliveredPercentage.setText(newValue);
		} else {
			deliveredPercentage.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Supplier.Properties.deliveredPercentage);
		if (eefElementEditorReadOnlyState && deliveredPercentage.isEnabled()) {
			deliveredPercentage.setEnabled(false);
			deliveredPercentage.setToolTipText(MetamodelMessages.Supplier_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !deliveredPercentage.isEnabled()) {
			deliveredPercentage.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart#initRefillPolicy(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initRefillPolicy(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		refillPolicy.setContentProvider(contentProvider);
		refillPolicy.setInput(settings);
		refillPolicyBusinessFilters.clear();
		refillPolicyFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Supplier.Properties.refillPolicy);
		if (eefElementEditorReadOnlyState && refillPolicy.getTable().isEnabled()) {
			refillPolicy.setEnabled(false);
			refillPolicy.setToolTipText(MetamodelMessages.Supplier_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !refillPolicy.getTable().isEnabled()) {
			refillPolicy.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart#updateRefillPolicy()
	 * 
	 */
	public void updateRefillPolicy() {
	refillPolicy.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart#addFilterRefillPolicy(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRefillPolicy(ViewerFilter filter) {
		refillPolicyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart#addBusinessFilterRefillPolicy(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRefillPolicy(ViewerFilter filter) {
		refillPolicyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart#isContainedInRefillPolicyTable(EObject element)
	 * 
	 */
	public boolean isContainedInRefillPolicyTable(EObject element) {
		return ((ReferencesTableSettings)refillPolicy.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart#getDelay()
	 * 
	 */
	public EObject getDelay() {
		return (EObject) delay.getInput();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart#initDelay(EObjectFlatComboSettings)
	 */
	public void initDelay(EObjectFlatComboSettings settings) {
		delay.setAdapterFactory(adapterFactory);
		delay.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Supplier.Properties.delay);
		if (eefElementEditorReadOnlyState && delay.isEnabled()) {
			delay.setEnabled(false);
			delay.setToolTipText(MetamodelMessages.Supplier_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !delay.isEnabled()) {
			delay.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.SupplierPropertiesEditionPart#setDelay(EObject newValue)
	 * 
	 */
	public void setDelay(EObject newValue) {
		delay.refresh();
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Supplier.Properties.delay);
		if (eefElementEditorReadOnlyState && delay.isEnabled()) {
			delay.setEnabled(false);
			delay.setToolTipText(MetamodelMessages.Supplier_ReadOnly);
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
		return MetamodelMessages.Supplier_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

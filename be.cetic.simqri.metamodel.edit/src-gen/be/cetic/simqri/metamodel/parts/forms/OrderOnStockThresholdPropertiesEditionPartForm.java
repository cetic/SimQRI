/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.forms;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;

import be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart;

import be.cetic.simqri.metamodel.providers.MetamodelMessages;

import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

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
public class OrderOnStockThresholdPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, OrderOnStockThresholdPropertiesEditionPart {

	protected Text period;
	protected Text threshold;
	protected Text name;
	protected Text orderQuantity;
	protected EMFComboViewer orderType;
	protected EObjectFlatComboViewer supplier;
	protected EObjectFlatComboViewer storage;



	/**
	 * For {@link ISection} use only.
	 */
	public OrderOnStockThresholdPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public OrderOnStockThresholdPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence orderOnStockThresholdStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = orderOnStockThresholdStep.addStep(MetamodelViewsRepository.OrderOnStockThreshold.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.OrderOnStockThreshold.Properties.period);
		propertiesStep.addStep(MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold);
		propertiesStep.addStep(MetamodelViewsRepository.OrderOnStockThreshold.Properties.name);
		propertiesStep.addStep(MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity);
		propertiesStep.addStep(MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderType);
		propertiesStep.addStep(MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier);
		propertiesStep.addStep(MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage);
		
		
		composer = new PartComposer(orderOnStockThresholdStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.OrderOnStockThreshold.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.OrderOnStockThreshold.Properties.period) {
					return createPeriodText(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold) {
					return createThresholdText(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.OrderOnStockThreshold.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity) {
					return createOrderQuantityText(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderType) {
					return createOrderTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier) {
					return createSupplierFlatComboViewer(parent, widgetFactory);
				}
				if (key == MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage) {
					return createStorageFlatComboViewer(parent, widgetFactory);
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
		propertiesSection.setText(MetamodelMessages.OrderOnStockThresholdPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createPeriodText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.OrderOnStockThreshold.Properties.period, MetamodelMessages.OrderOnStockThresholdPropertiesEditionPart_PeriodLabel);
		period = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		period.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData periodData = new GridData(GridData.FILL_HORIZONTAL);
		period.setLayoutData(periodData);
		period.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							OrderOnStockThresholdPropertiesEditionPartForm.this,
							MetamodelViewsRepository.OrderOnStockThreshold.Properties.period,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, period.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									OrderOnStockThresholdPropertiesEditionPartForm.this,
									MetamodelViewsRepository.OrderOnStockThreshold.Properties.period,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, period.getText()));
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
									OrderOnStockThresholdPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		period.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OrderOnStockThresholdPropertiesEditionPartForm.this, MetamodelViewsRepository.OrderOnStockThreshold.Properties.period, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, period.getText()));
				}
			}
		});
		EditingUtils.setID(period, MetamodelViewsRepository.OrderOnStockThreshold.Properties.period);
		EditingUtils.setEEFtype(period, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.OrderOnStockThreshold.Properties.period, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPeriodText

		// End of user code
		return parent;
	}

	
	protected Composite createThresholdText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold, MetamodelMessages.OrderOnStockThresholdPropertiesEditionPart_ThresholdLabel);
		threshold = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		threshold.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData thresholdData = new GridData(GridData.FILL_HORIZONTAL);
		threshold.setLayoutData(thresholdData);
		threshold.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							OrderOnStockThresholdPropertiesEditionPartForm.this,
							MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, threshold.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									OrderOnStockThresholdPropertiesEditionPartForm.this,
									MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, threshold.getText()));
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
									OrderOnStockThresholdPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		threshold.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OrderOnStockThresholdPropertiesEditionPartForm.this, MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, threshold.getText()));
				}
			}
		});
		EditingUtils.setID(threshold, MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold);
		EditingUtils.setEEFtype(threshold, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createThresholdText

		// End of user code
		return parent;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.OrderOnStockThreshold.Properties.name, MetamodelMessages.OrderOnStockThresholdPropertiesEditionPart_NameLabel);
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
							OrderOnStockThresholdPropertiesEditionPartForm.this,
							MetamodelViewsRepository.OrderOnStockThreshold.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									OrderOnStockThresholdPropertiesEditionPartForm.this,
									MetamodelViewsRepository.OrderOnStockThreshold.Properties.name,
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
									OrderOnStockThresholdPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OrderOnStockThresholdPropertiesEditionPartForm.this, MetamodelViewsRepository.OrderOnStockThreshold.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, MetamodelViewsRepository.OrderOnStockThreshold.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.OrderOnStockThreshold.Properties.name, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createOrderQuantityText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity, MetamodelMessages.OrderOnStockThresholdPropertiesEditionPart_OrderQuantityLabel);
		orderQuantity = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		orderQuantity.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData orderQuantityData = new GridData(GridData.FILL_HORIZONTAL);
		orderQuantity.setLayoutData(orderQuantityData);
		orderQuantity.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							OrderOnStockThresholdPropertiesEditionPartForm.this,
							MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, orderQuantity.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									OrderOnStockThresholdPropertiesEditionPartForm.this,
									MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, orderQuantity.getText()));
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
									OrderOnStockThresholdPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		orderQuantity.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OrderOnStockThresholdPropertiesEditionPartForm.this, MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, orderQuantity.getText()));
				}
			}
		});
		EditingUtils.setID(orderQuantity, MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity);
		EditingUtils.setEEFtype(orderQuantity, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOrderQuantityText

		// End of user code
		return parent;
	}

	
	protected Composite createOrderTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderType, MetamodelMessages.OrderOnStockThresholdPropertiesEditionPart_OrderTypeLabel);
		orderType = new EMFComboViewer(parent);
		orderType.setContentProvider(new ArrayContentProvider());
		orderType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData orderTypeData = new GridData(GridData.FILL_HORIZONTAL);
		orderType.getCombo().setLayoutData(orderTypeData);
		orderType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OrderOnStockThresholdPropertiesEditionPartForm.this, MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOrderType()));
			}

		});
		orderType.setID(MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderType, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createOrderTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createSupplierFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier, MetamodelMessages.OrderOnStockThresholdPropertiesEditionPart_SupplierLabel);
		supplier = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier, MetamodelViewsRepository.FORM_KIND));
		widgetFactory.adapt(supplier);
		supplier.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData supplierData = new GridData(GridData.FILL_HORIZONTAL);
		supplier.setLayoutData(supplierData);
		supplier.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OrderOnStockThresholdPropertiesEditionPartForm.this, MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSupplier()));
			}

		});
		supplier.setID(MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSupplierFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createStorageFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage, MetamodelMessages.OrderOnStockThresholdPropertiesEditionPart_StorageLabel);
		storage = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage, MetamodelViewsRepository.FORM_KIND));
		widgetFactory.adapt(storage);
		storage.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData storageData = new GridData(GridData.FILL_HORIZONTAL);
		storage.setLayoutData(storageData);
		storage.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OrderOnStockThresholdPropertiesEditionPartForm.this, MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getStorage()));
			}

		});
		storage.setID(MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createStorageFlatComboViewer

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
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#getPeriod()
	 * 
	 */
	public String getPeriod() {
		return period.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#setPeriod(String newValue)
	 * 
	 */
	public void setPeriod(String newValue) {
		if (newValue != null) {
			period.setText(newValue);
		} else {
			period.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.OrderOnStockThreshold.Properties.period);
		if (eefElementEditorReadOnlyState && period.isEnabled()) {
			period.setEnabled(false);
			period.setToolTipText(MetamodelMessages.OrderOnStockThreshold_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !period.isEnabled()) {
			period.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#getThreshold()
	 * 
	 */
	public String getThreshold() {
		return threshold.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#setThreshold(String newValue)
	 * 
	 */
	public void setThreshold(String newValue) {
		if (newValue != null) {
			threshold.setText(newValue);
		} else {
			threshold.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.OrderOnStockThreshold.Properties.threshold);
		if (eefElementEditorReadOnlyState && threshold.isEnabled()) {
			threshold.setEnabled(false);
			threshold.setToolTipText(MetamodelMessages.OrderOnStockThreshold_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !threshold.isEnabled()) {
			threshold.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.OrderOnStockThreshold.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(MetamodelMessages.OrderOnStockThreshold_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#getOrderQuantity()
	 * 
	 */
	public String getOrderQuantity() {
		return orderQuantity.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#setOrderQuantity(String newValue)
	 * 
	 */
	public void setOrderQuantity(String newValue) {
		if (newValue != null) {
			orderQuantity.setText(newValue);
		} else {
			orderQuantity.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderQuantity);
		if (eefElementEditorReadOnlyState && orderQuantity.isEnabled()) {
			orderQuantity.setEnabled(false);
			orderQuantity.setToolTipText(MetamodelMessages.OrderOnStockThreshold_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !orderQuantity.isEnabled()) {
			orderQuantity.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#getOrderType()
	 * 
	 */
	public Enumerator getOrderType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) orderType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#initOrderType(Object input, Enumerator current)
	 */
	public void initOrderType(Object input, Enumerator current) {
		orderType.setInput(input);
		orderType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderType);
		if (eefElementEditorReadOnlyState && orderType.isEnabled()) {
			orderType.setEnabled(false);
			orderType.setToolTipText(MetamodelMessages.OrderOnStockThreshold_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !orderType.isEnabled()) {
			orderType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#setOrderType(Enumerator newValue)
	 * 
	 */
	public void setOrderType(Enumerator newValue) {
		orderType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.OrderOnStockThreshold.Properties.orderType);
		if (eefElementEditorReadOnlyState && orderType.isEnabled()) {
			orderType.setEnabled(false);
			orderType.setToolTipText(MetamodelMessages.OrderOnStockThreshold_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !orderType.isEnabled()) {
			orderType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#getSupplier()
	 * 
	 */
	public EObject getSupplier() {
		if (supplier.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) supplier.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#initSupplier(EObjectFlatComboSettings)
	 */
	public void initSupplier(EObjectFlatComboSettings settings) {
		supplier.setInput(settings);
		if (current != null) {
			supplier.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier);
		if (eefElementEditorReadOnlyState && supplier.isEnabled()) {
			supplier.setEnabled(false);
			supplier.setToolTipText(MetamodelMessages.OrderOnStockThreshold_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !supplier.isEnabled()) {
			supplier.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#setSupplier(EObject newValue)
	 * 
	 */
	public void setSupplier(EObject newValue) {
		if (newValue != null) {
			supplier.setSelection(new StructuredSelection(newValue));
		} else {
			supplier.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.OrderOnStockThreshold.Properties.supplier);
		if (eefElementEditorReadOnlyState && supplier.isEnabled()) {
			supplier.setEnabled(false);
			supplier.setToolTipText(MetamodelMessages.OrderOnStockThreshold_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !supplier.isEnabled()) {
			supplier.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#setSupplierButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSupplierButtonMode(ButtonsModeEnum newValue) {
		supplier.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#addFilterSupplier(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSupplier(ViewerFilter filter) {
		supplier.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#addBusinessFilterSupplier(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSupplier(ViewerFilter filter) {
		supplier.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#getStorage()
	 * 
	 */
	public EObject getStorage() {
		if (storage.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) storage.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#initStorage(EObjectFlatComboSettings)
	 */
	public void initStorage(EObjectFlatComboSettings settings) {
		storage.setInput(settings);
		if (current != null) {
			storage.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage);
		if (eefElementEditorReadOnlyState && storage.isEnabled()) {
			storage.setEnabled(false);
			storage.setToolTipText(MetamodelMessages.OrderOnStockThreshold_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !storage.isEnabled()) {
			storage.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#setStorage(EObject newValue)
	 * 
	 */
	public void setStorage(EObject newValue) {
		if (newValue != null) {
			storage.setSelection(new StructuredSelection(newValue));
		} else {
			storage.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.OrderOnStockThreshold.Properties.storage);
		if (eefElementEditorReadOnlyState && storage.isEnabled()) {
			storage.setEnabled(false);
			storage.setToolTipText(MetamodelMessages.OrderOnStockThreshold_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !storage.isEnabled()) {
			storage.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#setStorageButtonMode(ButtonsModeEnum newValue)
	 */
	public void setStorageButtonMode(ButtonsModeEnum newValue) {
		storage.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#addFilterStorage(ViewerFilter filter)
	 * 
	 */
	public void addFilterToStorage(ViewerFilter filter) {
		storage.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.OrderOnStockThresholdPropertiesEditionPart#addBusinessFilterStorage(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToStorage(ViewerFilter filter) {
		storage.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MetamodelMessages.OrderOnStockThreshold_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

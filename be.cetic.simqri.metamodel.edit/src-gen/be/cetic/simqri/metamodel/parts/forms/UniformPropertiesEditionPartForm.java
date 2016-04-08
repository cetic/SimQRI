/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.forms;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.UniformPropertiesEditionPart;

import be.cetic.simqri.metamodel.providers.MetamodelMessages;

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
public class UniformPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, UniformPropertiesEditionPart {

	protected Text minimum;
	protected Text maximum;



	/**
	 * For {@link ISection} use only.
	 */
	public UniformPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public UniformPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence uniformStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = uniformStep.addStep(MetamodelViewsRepository.Uniform.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.Uniform.Properties.minimum);
		propertiesStep.addStep(MetamodelViewsRepository.Uniform.Properties.maximum);
		
		
		composer = new PartComposer(uniformStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.Uniform.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Uniform.Properties.minimum) {
					return createMinimumText(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Uniform.Properties.maximum) {
					return createMaximumText(widgetFactory, parent);
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
		propertiesSection.setText(MetamodelMessages.UniformPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createMinimumText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Uniform.Properties.minimum, MetamodelMessages.UniformPropertiesEditionPart_MinimumLabel);
		minimum = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		minimum.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData minimumData = new GridData(GridData.FILL_HORIZONTAL);
		minimum.setLayoutData(minimumData);
		minimum.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							UniformPropertiesEditionPartForm.this,
							MetamodelViewsRepository.Uniform.Properties.minimum,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minimum.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									UniformPropertiesEditionPartForm.this,
									MetamodelViewsRepository.Uniform.Properties.minimum,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, minimum.getText()));
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
									UniformPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		minimum.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UniformPropertiesEditionPartForm.this, MetamodelViewsRepository.Uniform.Properties.minimum, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minimum.getText()));
				}
			}
		});
		EditingUtils.setID(minimum, MetamodelViewsRepository.Uniform.Properties.minimum);
		EditingUtils.setEEFtype(minimum, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Uniform.Properties.minimum, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMinimumText

		// End of user code
		return parent;
	}

	
	protected Composite createMaximumText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Uniform.Properties.maximum, MetamodelMessages.UniformPropertiesEditionPart_MaximumLabel);
		maximum = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		maximum.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData maximumData = new GridData(GridData.FILL_HORIZONTAL);
		maximum.setLayoutData(maximumData);
		maximum.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							UniformPropertiesEditionPartForm.this,
							MetamodelViewsRepository.Uniform.Properties.maximum,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maximum.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									UniformPropertiesEditionPartForm.this,
									MetamodelViewsRepository.Uniform.Properties.maximum,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, maximum.getText()));
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
									UniformPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		maximum.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UniformPropertiesEditionPartForm.this, MetamodelViewsRepository.Uniform.Properties.maximum, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maximum.getText()));
				}
			}
		});
		EditingUtils.setID(maximum, MetamodelViewsRepository.Uniform.Properties.maximum);
		EditingUtils.setEEFtype(maximum, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Uniform.Properties.maximum, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createMaximumText

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
	 * @see be.cetic.simqri.metamodel.parts.UniformPropertiesEditionPart#getMinimum()
	 * 
	 */
	public String getMinimum() {
		return minimum.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.UniformPropertiesEditionPart#setMinimum(String newValue)
	 * 
	 */
	public void setMinimum(String newValue) {
		if (newValue != null) {
			minimum.setText(newValue);
		} else {
			minimum.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Uniform.Properties.minimum);
		if (eefElementEditorReadOnlyState && minimum.isEnabled()) {
			minimum.setEnabled(false);
			minimum.setToolTipText(MetamodelMessages.Uniform_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !minimum.isEnabled()) {
			minimum.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.UniformPropertiesEditionPart#getMaximum()
	 * 
	 */
	public String getMaximum() {
		return maximum.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.UniformPropertiesEditionPart#setMaximum(String newValue)
	 * 
	 */
	public void setMaximum(String newValue) {
		if (newValue != null) {
			maximum.setText(newValue);
		} else {
			maximum.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Uniform.Properties.maximum);
		if (eefElementEditorReadOnlyState && maximum.isEnabled()) {
			maximum.setEnabled(false);
			maximum.setToolTipText(MetamodelMessages.Uniform_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !maximum.isEnabled()) {
			maximum.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MetamodelMessages.Uniform_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

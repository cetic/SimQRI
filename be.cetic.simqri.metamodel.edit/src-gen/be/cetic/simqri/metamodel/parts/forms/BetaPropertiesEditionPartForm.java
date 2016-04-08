/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.forms;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.BetaPropertiesEditionPart;
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;

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
public class BetaPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, BetaPropertiesEditionPart {

	protected Text freedomDegreeA;
	protected Text freedomDegreeB;



	/**
	 * For {@link ISection} use only.
	 */
	public BetaPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public BetaPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence betaStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = betaStep.addStep(MetamodelViewsRepository.Beta.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.Beta.Properties.freedomDegreeA);
		propertiesStep.addStep(MetamodelViewsRepository.Beta.Properties.freedomDegreeB);
		
		
		composer = new PartComposer(betaStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.Beta.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Beta.Properties.freedomDegreeA) {
					return createFreedomDegreeAText(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Beta.Properties.freedomDegreeB) {
					return createFreedomDegreeBText(widgetFactory, parent);
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
		propertiesSection.setText(MetamodelMessages.BetaPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createFreedomDegreeAText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Beta.Properties.freedomDegreeA, MetamodelMessages.BetaPropertiesEditionPart_FreedomDegreeALabel);
		freedomDegreeA = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		freedomDegreeA.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData freedomDegreeAData = new GridData(GridData.FILL_HORIZONTAL);
		freedomDegreeA.setLayoutData(freedomDegreeAData);
		freedomDegreeA.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							BetaPropertiesEditionPartForm.this,
							MetamodelViewsRepository.Beta.Properties.freedomDegreeA,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, freedomDegreeA.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									BetaPropertiesEditionPartForm.this,
									MetamodelViewsRepository.Beta.Properties.freedomDegreeA,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, freedomDegreeA.getText()));
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
									BetaPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		freedomDegreeA.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BetaPropertiesEditionPartForm.this, MetamodelViewsRepository.Beta.Properties.freedomDegreeA, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, freedomDegreeA.getText()));
				}
			}
		});
		EditingUtils.setID(freedomDegreeA, MetamodelViewsRepository.Beta.Properties.freedomDegreeA);
		EditingUtils.setEEFtype(freedomDegreeA, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Beta.Properties.freedomDegreeA, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFreedomDegreeAText

		// End of user code
		return parent;
	}

	
	protected Composite createFreedomDegreeBText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Beta.Properties.freedomDegreeB, MetamodelMessages.BetaPropertiesEditionPart_FreedomDegreeBLabel);
		freedomDegreeB = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		freedomDegreeB.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData freedomDegreeBData = new GridData(GridData.FILL_HORIZONTAL);
		freedomDegreeB.setLayoutData(freedomDegreeBData);
		freedomDegreeB.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							BetaPropertiesEditionPartForm.this,
							MetamodelViewsRepository.Beta.Properties.freedomDegreeB,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, freedomDegreeB.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									BetaPropertiesEditionPartForm.this,
									MetamodelViewsRepository.Beta.Properties.freedomDegreeB,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, freedomDegreeB.getText()));
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
									BetaPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		freedomDegreeB.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BetaPropertiesEditionPartForm.this, MetamodelViewsRepository.Beta.Properties.freedomDegreeB, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, freedomDegreeB.getText()));
				}
			}
		});
		EditingUtils.setID(freedomDegreeB, MetamodelViewsRepository.Beta.Properties.freedomDegreeB);
		EditingUtils.setEEFtype(freedomDegreeB, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Beta.Properties.freedomDegreeB, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFreedomDegreeBText

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
	 * @see be.cetic.simqri.metamodel.parts.BetaPropertiesEditionPart#getFreedomDegreeA()
	 * 
	 */
	public String getFreedomDegreeA() {
		return freedomDegreeA.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BetaPropertiesEditionPart#setFreedomDegreeA(String newValue)
	 * 
	 */
	public void setFreedomDegreeA(String newValue) {
		if (newValue != null) {
			freedomDegreeA.setText(newValue);
		} else {
			freedomDegreeA.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Beta.Properties.freedomDegreeA);
		if (eefElementEditorReadOnlyState && freedomDegreeA.isEnabled()) {
			freedomDegreeA.setEnabled(false);
			freedomDegreeA.setToolTipText(MetamodelMessages.Beta_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !freedomDegreeA.isEnabled()) {
			freedomDegreeA.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BetaPropertiesEditionPart#getFreedomDegreeB()
	 * 
	 */
	public String getFreedomDegreeB() {
		return freedomDegreeB.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BetaPropertiesEditionPart#setFreedomDegreeB(String newValue)
	 * 
	 */
	public void setFreedomDegreeB(String newValue) {
		if (newValue != null) {
			freedomDegreeB.setText(newValue);
		} else {
			freedomDegreeB.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Beta.Properties.freedomDegreeB);
		if (eefElementEditorReadOnlyState && freedomDegreeB.isEnabled()) {
			freedomDegreeB.setEnabled(false);
			freedomDegreeB.setToolTipText(MetamodelMessages.Beta_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !freedomDegreeB.isEnabled()) {
			freedomDegreeB.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MetamodelMessages.Beta_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

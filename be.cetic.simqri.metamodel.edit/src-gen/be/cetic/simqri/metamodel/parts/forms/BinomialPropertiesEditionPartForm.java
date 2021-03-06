/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.forms;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.BinomialPropertiesEditionPart;
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
public class BinomialPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, BinomialPropertiesEditionPart {

	protected Text nbrOfTrial;
	protected Text probaOfSuccess;



	/**
	 * For {@link ISection} use only.
	 */
	public BinomialPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public BinomialPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence binomialStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = binomialStep.addStep(MetamodelViewsRepository.Binomial.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.Binomial.Properties.nbrOfTrial);
		propertiesStep.addStep(MetamodelViewsRepository.Binomial.Properties.probaOfSuccess);
		
		
		composer = new PartComposer(binomialStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.Binomial.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Binomial.Properties.nbrOfTrial) {
					return createNbrOfTrialText(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.Binomial.Properties.probaOfSuccess) {
					return createProbaOfSuccessText(widgetFactory, parent);
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
		propertiesSection.setText(MetamodelMessages.BinomialPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createNbrOfTrialText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Binomial.Properties.nbrOfTrial, MetamodelMessages.BinomialPropertiesEditionPart_NbrOfTrialLabel);
		nbrOfTrial = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		nbrOfTrial.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nbrOfTrialData = new GridData(GridData.FILL_HORIZONTAL);
		nbrOfTrial.setLayoutData(nbrOfTrialData);
		nbrOfTrial.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							BinomialPropertiesEditionPartForm.this,
							MetamodelViewsRepository.Binomial.Properties.nbrOfTrial,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nbrOfTrial.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									BinomialPropertiesEditionPartForm.this,
									MetamodelViewsRepository.Binomial.Properties.nbrOfTrial,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, nbrOfTrial.getText()));
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
									BinomialPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		nbrOfTrial.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BinomialPropertiesEditionPartForm.this, MetamodelViewsRepository.Binomial.Properties.nbrOfTrial, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nbrOfTrial.getText()));
				}
			}
		});
		EditingUtils.setID(nbrOfTrial, MetamodelViewsRepository.Binomial.Properties.nbrOfTrial);
		EditingUtils.setEEFtype(nbrOfTrial, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Binomial.Properties.nbrOfTrial, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNbrOfTrialText

		// End of user code
		return parent;
	}

	
	protected Composite createProbaOfSuccessText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Binomial.Properties.probaOfSuccess, MetamodelMessages.BinomialPropertiesEditionPart_ProbaOfSuccessLabel);
		probaOfSuccess = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		probaOfSuccess.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData probaOfSuccessData = new GridData(GridData.FILL_HORIZONTAL);
		probaOfSuccess.setLayoutData(probaOfSuccessData);
		probaOfSuccess.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							BinomialPropertiesEditionPartForm.this,
							MetamodelViewsRepository.Binomial.Properties.probaOfSuccess,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, probaOfSuccess.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									BinomialPropertiesEditionPartForm.this,
									MetamodelViewsRepository.Binomial.Properties.probaOfSuccess,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, probaOfSuccess.getText()));
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
									BinomialPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		probaOfSuccess.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BinomialPropertiesEditionPartForm.this, MetamodelViewsRepository.Binomial.Properties.probaOfSuccess, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, probaOfSuccess.getText()));
				}
			}
		});
		EditingUtils.setID(probaOfSuccess, MetamodelViewsRepository.Binomial.Properties.probaOfSuccess);
		EditingUtils.setEEFtype(probaOfSuccess, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Binomial.Properties.probaOfSuccess, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createProbaOfSuccessText

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
	 * @see be.cetic.simqri.metamodel.parts.BinomialPropertiesEditionPart#getNbrOfTrial()
	 * 
	 */
	public String getNbrOfTrial() {
		return nbrOfTrial.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BinomialPropertiesEditionPart#setNbrOfTrial(String newValue)
	 * 
	 */
	public void setNbrOfTrial(String newValue) {
		if (newValue != null) {
			nbrOfTrial.setText(newValue);
		} else {
			nbrOfTrial.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Binomial.Properties.nbrOfTrial);
		if (eefElementEditorReadOnlyState && nbrOfTrial.isEnabled()) {
			nbrOfTrial.setEnabled(false);
			nbrOfTrial.setToolTipText(MetamodelMessages.Binomial_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !nbrOfTrial.isEnabled()) {
			nbrOfTrial.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BinomialPropertiesEditionPart#getProbaOfSuccess()
	 * 
	 */
	public String getProbaOfSuccess() {
		return probaOfSuccess.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.BinomialPropertiesEditionPart#setProbaOfSuccess(String newValue)
	 * 
	 */
	public void setProbaOfSuccess(String newValue) {
		if (newValue != null) {
			probaOfSuccess.setText(newValue);
		} else {
			probaOfSuccess.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Binomial.Properties.probaOfSuccess);
		if (eefElementEditorReadOnlyState && probaOfSuccess.isEnabled()) {
			probaOfSuccess.setEnabled(false);
			probaOfSuccess.setToolTipText(MetamodelMessages.Binomial_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !probaOfSuccess.isEnabled()) {
			probaOfSuccess.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MetamodelMessages.Binomial_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

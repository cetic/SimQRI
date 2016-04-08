/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.forms;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.StudentsTPropertiesEditionPart;

import be.cetic.simqri.metamodel.providers.MetamodelMessages;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;

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
public class StudentsTPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, StudentsTPropertiesEditionPart {

	protected Text degreeOfFreedom;



	/**
	 * For {@link ISection} use only.
	 */
	public StudentsTPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public StudentsTPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence studentsTStep = new BindingCompositionSequence(propertiesEditionComponent);
		studentsTStep
			.addStep(MetamodelViewsRepository.StudentsT.Properties.class)
			.addStep(MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom);
		
		
		composer = new PartComposer(studentsTStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.StudentsT.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom) {
					return createDegreeOfFreedomText(widgetFactory, parent);
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
		propertiesSection.setText(MetamodelMessages.StudentsTPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createDegreeOfFreedomText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom, MetamodelMessages.StudentsTPropertiesEditionPart_DegreeOfFreedomLabel);
		degreeOfFreedom = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		degreeOfFreedom.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData degreeOfFreedomData = new GridData(GridData.FILL_HORIZONTAL);
		degreeOfFreedom.setLayoutData(degreeOfFreedomData);
		degreeOfFreedom.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							StudentsTPropertiesEditionPartForm.this,
							MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, degreeOfFreedom.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									StudentsTPropertiesEditionPartForm.this,
									MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, degreeOfFreedom.getText()));
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
									StudentsTPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		degreeOfFreedom.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StudentsTPropertiesEditionPartForm.this, MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, degreeOfFreedom.getText()));
				}
			}
		});
		EditingUtils.setID(degreeOfFreedom, MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom);
		EditingUtils.setEEFtype(degreeOfFreedom, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom, MetamodelViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDegreeOfFreedomText

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
	 * @see be.cetic.simqri.metamodel.parts.StudentsTPropertiesEditionPart#getDegreeOfFreedom()
	 * 
	 */
	public String getDegreeOfFreedom() {
		return degreeOfFreedom.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.StudentsTPropertiesEditionPart#setDegreeOfFreedom(String newValue)
	 * 
	 */
	public void setDegreeOfFreedom(String newValue) {
		if (newValue != null) {
			degreeOfFreedom.setText(newValue);
		} else {
			degreeOfFreedom.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom);
		if (eefElementEditorReadOnlyState && degreeOfFreedom.isEnabled()) {
			degreeOfFreedom.setEnabled(false);
			degreeOfFreedom.setToolTipText(MetamodelMessages.StudentsT_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !degreeOfFreedom.isEnabled()) {
			degreeOfFreedom.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MetamodelMessages.StudentsT_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

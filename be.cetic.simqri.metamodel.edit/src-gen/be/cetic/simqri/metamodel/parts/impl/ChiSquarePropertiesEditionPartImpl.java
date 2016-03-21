/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.impl;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.ChiSquarePropertiesEditionPart;
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;

import be.cetic.simqri.metamodel.providers.MetamodelMessages;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

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
public class ChiSquarePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ChiSquarePropertiesEditionPart {

	protected Text degreeOfFreedom;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ChiSquarePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence chiSquareStep = new BindingCompositionSequence(propertiesEditionComponent);
		chiSquareStep
			.addStep(MetamodelViewsRepository.ChiSquare.Properties.class)
			.addStep(MetamodelViewsRepository.ChiSquare.Properties.degreeOfFreedom);
		
		
		composer = new PartComposer(chiSquareStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.ChiSquare.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == MetamodelViewsRepository.ChiSquare.Properties.degreeOfFreedom) {
					return createDegreeOfFreedomText(parent);
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
		propertiesGroup.setText(MetamodelMessages.ChiSquarePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createDegreeOfFreedomText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.ChiSquare.Properties.degreeOfFreedom, MetamodelMessages.ChiSquarePropertiesEditionPart_DegreeOfFreedomLabel);
		degreeOfFreedom = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData degreeOfFreedomData = new GridData(GridData.FILL_HORIZONTAL);
		degreeOfFreedom.setLayoutData(degreeOfFreedomData);
		degreeOfFreedom.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ChiSquarePropertiesEditionPartImpl.this, MetamodelViewsRepository.ChiSquare.Properties.degreeOfFreedom, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, degreeOfFreedom.getText()));
			}

		});
		degreeOfFreedom.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ChiSquarePropertiesEditionPartImpl.this, MetamodelViewsRepository.ChiSquare.Properties.degreeOfFreedom, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, degreeOfFreedom.getText()));
				}
			}

		});
		EditingUtils.setID(degreeOfFreedom, MetamodelViewsRepository.ChiSquare.Properties.degreeOfFreedom);
		EditingUtils.setEEFtype(degreeOfFreedom, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.ChiSquare.Properties.degreeOfFreedom, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see be.cetic.simqri.metamodel.parts.ChiSquarePropertiesEditionPart#getDegreeOfFreedom()
	 * 
	 */
	public String getDegreeOfFreedom() {
		return degreeOfFreedom.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ChiSquarePropertiesEditionPart#setDegreeOfFreedom(String newValue)
	 * 
	 */
	public void setDegreeOfFreedom(String newValue) {
		if (newValue != null) {
			degreeOfFreedom.setText(newValue);
		} else {
			degreeOfFreedom.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.ChiSquare.Properties.degreeOfFreedom);
		if (eefElementEditorReadOnlyState && degreeOfFreedom.isEnabled()) {
			degreeOfFreedom.setEnabled(false);
			degreeOfFreedom.setToolTipText(MetamodelMessages.ChiSquare_ReadOnly);
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
		return MetamodelMessages.ChiSquare_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

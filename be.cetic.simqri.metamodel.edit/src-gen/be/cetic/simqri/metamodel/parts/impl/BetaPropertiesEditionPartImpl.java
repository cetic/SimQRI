/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.impl;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.BetaPropertiesEditionPart;
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
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

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
public class BetaPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, BetaPropertiesEditionPart {

	protected Text freedomDegreeA;
	protected Text freedomDegreeB;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public BetaPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence betaStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = betaStep.addStep(MetamodelViewsRepository.Beta.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.Beta.Properties.freedomDegreeA);
		propertiesStep.addStep(MetamodelViewsRepository.Beta.Properties.freedomDegreeB);
		
		
		composer = new PartComposer(betaStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.Beta.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == MetamodelViewsRepository.Beta.Properties.freedomDegreeA) {
					return createFreedomDegreeAText(parent);
				}
				if (key == MetamodelViewsRepository.Beta.Properties.freedomDegreeB) {
					return createFreedomDegreeBText(parent);
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
		propertiesGroup.setText(MetamodelMessages.BetaPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createFreedomDegreeAText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Beta.Properties.freedomDegreeA, MetamodelMessages.BetaPropertiesEditionPart_FreedomDegreeALabel);
		freedomDegreeA = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData freedomDegreeAData = new GridData(GridData.FILL_HORIZONTAL);
		freedomDegreeA.setLayoutData(freedomDegreeAData);
		freedomDegreeA.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BetaPropertiesEditionPartImpl.this, MetamodelViewsRepository.Beta.Properties.freedomDegreeA, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, freedomDegreeA.getText()));
			}

		});
		freedomDegreeA.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BetaPropertiesEditionPartImpl.this, MetamodelViewsRepository.Beta.Properties.freedomDegreeA, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, freedomDegreeA.getText()));
				}
			}

		});
		EditingUtils.setID(freedomDegreeA, MetamodelViewsRepository.Beta.Properties.freedomDegreeA);
		EditingUtils.setEEFtype(freedomDegreeA, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Beta.Properties.freedomDegreeA, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createFreedomDegreeAText

		// End of user code
		return parent;
	}

	
	protected Composite createFreedomDegreeBText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Beta.Properties.freedomDegreeB, MetamodelMessages.BetaPropertiesEditionPart_FreedomDegreeBLabel);
		freedomDegreeB = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData freedomDegreeBData = new GridData(GridData.FILL_HORIZONTAL);
		freedomDegreeB.setLayoutData(freedomDegreeBData);
		freedomDegreeB.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BetaPropertiesEditionPartImpl.this, MetamodelViewsRepository.Beta.Properties.freedomDegreeB, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, freedomDegreeB.getText()));
			}

		});
		freedomDegreeB.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(BetaPropertiesEditionPartImpl.this, MetamodelViewsRepository.Beta.Properties.freedomDegreeB, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, freedomDegreeB.getText()));
				}
			}

		});
		EditingUtils.setID(freedomDegreeB, MetamodelViewsRepository.Beta.Properties.freedomDegreeB);
		EditingUtils.setEEFtype(freedomDegreeB, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Beta.Properties.freedomDegreeB, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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

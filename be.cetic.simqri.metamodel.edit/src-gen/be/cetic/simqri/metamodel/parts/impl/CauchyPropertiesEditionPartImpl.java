/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.impl;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.CauchyPropertiesEditionPart;
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
public class CauchyPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CauchyPropertiesEditionPart {

	protected Text location;
	protected Text scale;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CauchyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence cauchyStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = cauchyStep.addStep(MetamodelViewsRepository.Cauchy.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.Cauchy.Properties.location);
		propertiesStep.addStep(MetamodelViewsRepository.Cauchy.Properties.scale);
		
		
		composer = new PartComposer(cauchyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.Cauchy.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == MetamodelViewsRepository.Cauchy.Properties.location) {
					return createLocationText(parent);
				}
				if (key == MetamodelViewsRepository.Cauchy.Properties.scale) {
					return createScaleText(parent);
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
		propertiesGroup.setText(MetamodelMessages.CauchyPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createLocationText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Cauchy.Properties.location, MetamodelMessages.CauchyPropertiesEditionPart_LocationLabel);
		location = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData locationData = new GridData(GridData.FILL_HORIZONTAL);
		location.setLayoutData(locationData);
		location.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CauchyPropertiesEditionPartImpl.this, MetamodelViewsRepository.Cauchy.Properties.location, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, location.getText()));
			}

		});
		location.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CauchyPropertiesEditionPartImpl.this, MetamodelViewsRepository.Cauchy.Properties.location, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, location.getText()));
				}
			}

		});
		EditingUtils.setID(location, MetamodelViewsRepository.Cauchy.Properties.location);
		EditingUtils.setEEFtype(location, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Cauchy.Properties.location, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createLocationText

		// End of user code
		return parent;
	}

	
	protected Composite createScaleText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Cauchy.Properties.scale, MetamodelMessages.CauchyPropertiesEditionPart_ScaleLabel);
		scale = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData scaleData = new GridData(GridData.FILL_HORIZONTAL);
		scale.setLayoutData(scaleData);
		scale.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CauchyPropertiesEditionPartImpl.this, MetamodelViewsRepository.Cauchy.Properties.scale, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scale.getText()));
			}

		});
		scale.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CauchyPropertiesEditionPartImpl.this, MetamodelViewsRepository.Cauchy.Properties.scale, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scale.getText()));
				}
			}

		});
		EditingUtils.setID(scale, MetamodelViewsRepository.Cauchy.Properties.scale);
		EditingUtils.setEEFtype(scale, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Cauchy.Properties.scale, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createScaleText

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
	 * @see be.cetic.simqri.metamodel.parts.CauchyPropertiesEditionPart#getLocation()
	 * 
	 */
	public String getLocation() {
		return location.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.CauchyPropertiesEditionPart#setLocation(String newValue)
	 * 
	 */
	public void setLocation(String newValue) {
		if (newValue != null) {
			location.setText(newValue);
		} else {
			location.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Cauchy.Properties.location);
		if (eefElementEditorReadOnlyState && location.isEnabled()) {
			location.setEnabled(false);
			location.setToolTipText(MetamodelMessages.Cauchy_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !location.isEnabled()) {
			location.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.CauchyPropertiesEditionPart#getScale()
	 * 
	 */
	public String getScale() {
		return scale.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.CauchyPropertiesEditionPart#setScale(String newValue)
	 * 
	 */
	public void setScale(String newValue) {
		if (newValue != null) {
			scale.setText(newValue);
		} else {
			scale.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Cauchy.Properties.scale);
		if (eefElementEditorReadOnlyState && scale.isEnabled()) {
			scale.setEnabled(false);
			scale.setToolTipText(MetamodelMessages.Cauchy_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !scale.isEnabled()) {
			scale.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MetamodelMessages.Cauchy_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

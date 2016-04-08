/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.impl;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.UniformPropertiesEditionPart;

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
public class UniformPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, UniformPropertiesEditionPart {

	protected Text minimum;
	protected Text maximum;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public UniformPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence uniformStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = uniformStep.addStep(MetamodelViewsRepository.Uniform.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.Uniform.Properties.minimum);
		propertiesStep.addStep(MetamodelViewsRepository.Uniform.Properties.maximum);
		
		
		composer = new PartComposer(uniformStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.Uniform.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == MetamodelViewsRepository.Uniform.Properties.minimum) {
					return createMinimumText(parent);
				}
				if (key == MetamodelViewsRepository.Uniform.Properties.maximum) {
					return createMaximumText(parent);
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
		propertiesGroup.setText(MetamodelMessages.UniformPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createMinimumText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Uniform.Properties.minimum, MetamodelMessages.UniformPropertiesEditionPart_MinimumLabel);
		minimum = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData minimumData = new GridData(GridData.FILL_HORIZONTAL);
		minimum.setLayoutData(minimumData);
		minimum.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UniformPropertiesEditionPartImpl.this, MetamodelViewsRepository.Uniform.Properties.minimum, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minimum.getText()));
			}

		});
		minimum.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UniformPropertiesEditionPartImpl.this, MetamodelViewsRepository.Uniform.Properties.minimum, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, minimum.getText()));
				}
			}

		});
		EditingUtils.setID(minimum, MetamodelViewsRepository.Uniform.Properties.minimum);
		EditingUtils.setEEFtype(minimum, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Uniform.Properties.minimum, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createMinimumText

		// End of user code
		return parent;
	}

	
	protected Composite createMaximumText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Uniform.Properties.maximum, MetamodelMessages.UniformPropertiesEditionPart_MaximumLabel);
		maximum = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData maximumData = new GridData(GridData.FILL_HORIZONTAL);
		maximum.setLayoutData(maximumData);
		maximum.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UniformPropertiesEditionPartImpl.this, MetamodelViewsRepository.Uniform.Properties.maximum, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maximum.getText()));
			}

		});
		maximum.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UniformPropertiesEditionPartImpl.this, MetamodelViewsRepository.Uniform.Properties.maximum, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, maximum.getText()));
				}
			}

		});
		EditingUtils.setID(maximum, MetamodelViewsRepository.Uniform.Properties.maximum);
		EditingUtils.setEEFtype(maximum, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Uniform.Properties.maximum, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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

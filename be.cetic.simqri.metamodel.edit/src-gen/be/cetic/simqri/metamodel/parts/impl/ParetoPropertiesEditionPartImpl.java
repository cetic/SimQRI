/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.parts.impl;

// Start of user code for imports
import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.ParetoPropertiesEditionPart;

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
public class ParetoPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ParetoPropertiesEditionPart {

	protected Text shape;
	protected Text scale;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ParetoPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence paretoStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = paretoStep.addStep(MetamodelViewsRepository.Pareto.Properties.class);
		propertiesStep.addStep(MetamodelViewsRepository.Pareto.Properties.shape);
		propertiesStep.addStep(MetamodelViewsRepository.Pareto.Properties.scale);
		
		
		composer = new PartComposer(paretoStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == MetamodelViewsRepository.Pareto.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == MetamodelViewsRepository.Pareto.Properties.shape) {
					return createShapeText(parent);
				}
				if (key == MetamodelViewsRepository.Pareto.Properties.scale) {
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
		propertiesGroup.setText(MetamodelMessages.ParetoPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createShapeText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Pareto.Properties.shape, MetamodelMessages.ParetoPropertiesEditionPart_ShapeLabel);
		shape = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData shapeData = new GridData(GridData.FILL_HORIZONTAL);
		shape.setLayoutData(shapeData);
		shape.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParetoPropertiesEditionPartImpl.this, MetamodelViewsRepository.Pareto.Properties.shape, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, shape.getText()));
			}

		});
		shape.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParetoPropertiesEditionPartImpl.this, MetamodelViewsRepository.Pareto.Properties.shape, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, shape.getText()));
				}
			}

		});
		EditingUtils.setID(shape, MetamodelViewsRepository.Pareto.Properties.shape);
		EditingUtils.setEEFtype(shape, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Pareto.Properties.shape, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createShapeText

		// End of user code
		return parent;
	}

	
	protected Composite createScaleText(Composite parent) {
		createDescription(parent, MetamodelViewsRepository.Pareto.Properties.scale, MetamodelMessages.ParetoPropertiesEditionPart_ScaleLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParetoPropertiesEditionPartImpl.this, MetamodelViewsRepository.Pareto.Properties.scale, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scale.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParetoPropertiesEditionPartImpl.this, MetamodelViewsRepository.Pareto.Properties.scale, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, scale.getText()));
				}
			}

		});
		EditingUtils.setID(scale, MetamodelViewsRepository.Pareto.Properties.scale);
		EditingUtils.setEEFtype(scale, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MetamodelViewsRepository.Pareto.Properties.scale, MetamodelViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see be.cetic.simqri.metamodel.parts.ParetoPropertiesEditionPart#getShape()
	 * 
	 */
	public String getShape() {
		return shape.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ParetoPropertiesEditionPart#setShape(String newValue)
	 * 
	 */
	public void setShape(String newValue) {
		if (newValue != null) {
			shape.setText(newValue);
		} else {
			shape.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Pareto.Properties.shape);
		if (eefElementEditorReadOnlyState && shape.isEnabled()) {
			shape.setEnabled(false);
			shape.setToolTipText(MetamodelMessages.Pareto_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !shape.isEnabled()) {
			shape.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ParetoPropertiesEditionPart#getScale()
	 * 
	 */
	public String getScale() {
		return scale.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see be.cetic.simqri.metamodel.parts.ParetoPropertiesEditionPart#setScale(String newValue)
	 * 
	 */
	public void setScale(String newValue) {
		if (newValue != null) {
			scale.setText(newValue);
		} else {
			scale.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(MetamodelViewsRepository.Pareto.Properties.scale);
		if (eefElementEditorReadOnlyState && scale.isEnabled()) {
			scale.setEnabled(false);
			scale.setToolTipText(MetamodelMessages.Pareto_ReadOnly);
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
		return MetamodelMessages.Pareto_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}

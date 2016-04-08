/**
 * Generated with Acceleo
 */
package be.cetic.simqri.metamodel.components;

// Start of user code for imports
import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.StudentsT;

import be.cetic.simqri.metamodel.parts.MetamodelViewsRepository;
import be.cetic.simqri.metamodel.parts.StudentsTPropertiesEditionPart;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.sirius.eef.components.SiriusAwarePropertiesEditingComponent;


// End of user code

/**
 * 
 * 
 */
public class StudentsTPropertiesEditionComponent extends SiriusAwarePropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public StudentsTPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject studentsT, String editing_mode) {
		super(editingContext, studentsT, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MetamodelViewsRepository.class;
		partKey = MetamodelViewsRepository.StudentsT.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final StudentsT studentsT = (StudentsT)elt;
			final StudentsTPropertiesEditionPart basePart = (StudentsTPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom))
				basePart.setDegreeOfFreedom(EEFConverterUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE_NOT_NULL, studentsT.getDegreeOfFreedom()));
			
			// init filters
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}




	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom) {
			return MetamodelPackage.eINSTANCE.getStudentsT_DegreeOfFreedom();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		StudentsT studentsT = (StudentsT)semanticObject;
		if (MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom == event.getAffectedEditor()) {
			studentsT.setDegreeOfFreedom((java.lang.Double)EEFConverterUtil.createFromString(MetamodelPackage.Literals.POSITIVE_DOUBLE_NOT_NULL, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			StudentsTPropertiesEditionPart basePart = (StudentsTPropertiesEditionPart)editingPart;
			if (MetamodelPackage.eINSTANCE.getStudentsT_DegreeOfFreedom().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom)) {
				if (msg.getNewValue() != null) {
					basePart.setDegreeOfFreedom(EcoreUtil.convertToString(MetamodelPackage.Literals.POSITIVE_DOUBLE_NOT_NULL, msg.getNewValue()));
				} else {
					basePart.setDegreeOfFreedom("");
				}
			}
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			MetamodelPackage.eINSTANCE.getStudentsT_DegreeOfFreedom()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (MetamodelViewsRepository.StudentsT.Properties.degreeOfFreedom == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(MetamodelPackage.eINSTANCE.getStudentsT_DegreeOfFreedom().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(MetamodelPackage.eINSTANCE.getStudentsT_DegreeOfFreedom().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}

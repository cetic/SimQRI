/**
 */
package be.cetic.simqri.metamodel.provider;


import be.cetic.simqri.metamodel.MetamodelFactory;
import be.cetic.simqri.metamodel.MetamodelPackage;
import be.cetic.simqri.metamodel.ProcessOutputFlow;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link be.cetic.simqri.metamodel.ProcessOutputFlow} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcessOutputFlowItemProvider extends FlowItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessOutputFlowItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addDestinationPropertyDescriptor(object);
			addSourcePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Destination feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDestinationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProcessOutputFlow_destination_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProcessOutputFlow_destination_feature", "_UI_ProcessOutputFlow_type"),
				 MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__DESTINATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProcessOutputFlow_source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProcessOutputFlow_source_feature", "_UI_ProcessOutputFlow_type"),
				 MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__SOURCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ProcessOutputFlow.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ProcessOutputFlow"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ProcessOutputFlow_type");
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ProcessOutputFlow.class)) {
			case MetamodelPackage.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createCauchy()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createBinomial()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createBeta()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createScalar()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createChiSquare()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createDiracDelta()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createExponential()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createFDistribution()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createGamma()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createGeometric()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createLogNormal()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createGaussian()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createPareto()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createPoisson()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createStudentsT()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createUniform()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY,
				 MetamodelFactory.eINSTANCE.createWeibull()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == MetamodelPackage.Literals.FLOW__QUANTITY ||
			childFeature == MetamodelPackage.Literals.PROCESS_OUTPUT_FLOW__PROCESS_OUTPUT_FLOW_DELAY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}

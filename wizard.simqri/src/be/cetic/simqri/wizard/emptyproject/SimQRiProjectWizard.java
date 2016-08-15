package be.cetic.simqri.wizard.emptyproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.dialect.command.CreateRepresentationCommand;
import org.eclipse.sirius.business.api.helper.SiriusResourceHelper;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelection;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallbackWithConfimation;
import org.eclipse.sirius.ui.business.internal.commands.ChangeViewpointSelectionCommand;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import be.cetic.simqri.metamodel.MetamodelFactory;

/**
 * 
 * @author FK
 * @version 1.0
 * @since 05/07/2016
 * 
 * This class manages the creation of an empty modeling project with a "ready to use" Sirius Diagram.
 *
 */

@SuppressWarnings("restriction")
public class SimQRiProjectWizard extends Wizard implements INewWizard {
	
	private WizardNewProjectCreationPage _pageOne;
	private static final String WIZARD_NAME = "New Empty SimQRi Project";
	private static final String FILE_EXTENSION = "simqri";
	
	public SimQRiProjectWizard() {
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}
	
	/**
	 * This method create the window in which the user can enter the name of his modeling project
	 */
	@Override
	public void addPages() {
	    super.addPages();
	    _pageOne = new WizardNewProjectCreationPage(WIZARD_NAME);
	    _pageOne.setTitle(WIZARD_NAME);
	    _pageOne.setDescription("This wizard allows you to create a new SimQRi project");
	    addPage(_pageOne);
	}
	
	/**
	 * This method initialize the modeling project
	 */
	@Override
	public boolean performFinish() {
		
		String projectName = _pageOne.getProjectName();
		
		Job job = new Job("Create Project Job") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				//create a sirius modeling project
				IProject project = null;
				try {
					project = ModelingProjectManager.INSTANCE.createNewModelingProject(projectName, true, monitor);
				} catch (CoreException e) {
					e.printStackTrace();
				}
				
				//create a resource file
				ResourceSet resourceSet = new ResourceSetImpl();
				org.eclipse.emf.common.util.URI fileURI = URI.createPlatformResourceURI("/" + projectName + "/" + projectName + "." + FILE_EXTENSION, true);
				Resource resource = resourceSet.createResource(fileURI);
				EObject rootObject = MetamodelFactory.eINSTANCE.createModel();
				resource.getContents().add(rootObject);
				Map<Object, Object> options = new HashMap<Object, Object>();
				options.put(XMLResource.OPTION_ENCODING, "UTF-8");
				try {
					resource.save(options);
				} catch (IOException e) {
					e.printStackTrace();
				}

				//create viewpoint
				IFile airdFile = project.getFile("representations.aird");

				URI airdFileURI = URI.createPlatformResourceURI(airdFile.getFullPath().toOSString(), true);
				Session session = SessionManager.INSTANCE.getSession(airdFileURI, monitor);
				
				//adding the resource also to Sirius session
				AddSemanticResourceCommand addCommandToSession = new AddSemanticResourceCommand(session, fileURI, monitor );
				session.getTransactionalEditingDomain().getCommandStack().execute(addCommandToSession);
				session.save(monitor);
				
				//find and add viewpoint
				Set<Viewpoint> availableViewpoints = ViewpointSelection.getViewpoints(FILE_EXTENSION);

				Set<Viewpoint> viewpoints = new HashSet<Viewpoint>();
				for(Viewpoint p : availableViewpoints)
					viewpoints.add(SiriusResourceHelper.getCorrespondingViewpoint(session, p));

				ViewpointSelection.Callback callback = new ViewpointSelectionCallbackWithConfimation();
				 
				RecordingCommand command = new ChangeViewpointSelectionCommand(
						session,
						callback,
						viewpoints, new HashSet<Viewpoint>(), true, monitor);
				TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
				domain.getCommandStack().execute(command);

				rootObject = session.getSemanticResources().iterator().next().getContents().get(0);

				//create representation
				Collection<RepresentationDescription> descriptions = DialectManager.INSTANCE.getAvailableRepresentationDescriptions(session.getSelectedViewpoints(false),  rootObject );
				RepresentationDescription description = descriptions.iterator().next();

				DialectManager viewpointDialectManager = DialectManager.INSTANCE;
				Command createViewCommand = new CreateRepresentationCommand(session,
						  description, rootObject, projectName, monitor);
				 
				session.getTransactionalEditingDomain().getCommandStack().execute(createViewCommand);

				SessionManager.INSTANCE.notifyRepresentationCreated(session);

				//open editor 
				Collection<DRepresentation> representations = viewpointDialectManager.getRepresentations(description, session);
				DRepresentation myDiagramRepresentation = representations.iterator().next();

				DialectUIManager dialectUIManager = DialectUIManager.INSTANCE;
					dialectUIManager.openEditor(session,
						myDiagramRepresentation, monitor);
				 
				
				//create report templates folder
				IFolder templatesFolder = project.getFolder("Report Templates");
				try {
					templatesFolder.create(false,  true, null);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//create reports folder
				IFolder reportsFolder = project.getFolder("Generated Reports");
				try {
					reportsFolder.create(false,  true, null);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//fill report templates folder with 2 templates
				IFile mcDefaultTablesTemplate = templatesFolder.getFile("montecarlo-tables.rptdesign");
				try {
					mcDefaultTablesTemplate.create(new FileInputStream("simqri-reports/montecarlo-tables.rptdesign"), false, monitor);
				} catch (FileNotFoundException | CoreException e1) {
					JOptionPane.showMessageDialog(null, "The default tables report template cannot be imported.\n"
							+ "Make sure you have correctly initialized the \"simqri-reports\" folder as explained in the installation guide.",
							"FILE(S) NOT FOUND", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				IFile mcDefaultChartsTemplate = templatesFolder.getFile("montecarlo-charts.rptdesign");
				try {
					mcDefaultChartsTemplate.create(new FileInputStream("simqri-reports/montecarlo-charts.rptdesign"), false, monitor);
				} catch (FileNotFoundException | CoreException e1) {
					JOptionPane.showMessageDialog(null, "The default charts report template cannot be imported.\n"
							+ "Make sure you have correctly initialized the \"simqri-reports\" folder as explained in the installation guide.",
							"FILE(S) NOT FOUND", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
				//save session and refresh workspace
				session.save(monitor);
				try {
					project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
				} catch (CoreException e) {
					e.printStackTrace();
				}
				
				return Status.OK_STATUS;
			}
		};
		job.schedule();
		return true;
	}
}

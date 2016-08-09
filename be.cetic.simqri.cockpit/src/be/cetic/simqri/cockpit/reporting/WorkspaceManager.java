package be.cetic.simqri.cockpit.reporting;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

/**
 * 
 * @author François
 * @since 03/08/2016
 * @version 1.0
 * 
 * This class contains useful methods that allow SimQRi to interact with the workspace of the user
 */
public class WorkspaceManager {
	
	public static String SELECTED_PROJECT; // Project choosen by the user (in which reports will be generated)
	public static String SELECTED_TEMPLATE; // Reporting template selected by the user
	public static String TEMPLATE_PATH; // Full path of the template selected by the user
	public static String REPORT_FOLDER_PATH; // Full path of the reports folder in which reports will be generated
	
	/**
	 * 
	 * @return the list of all simqri modeling projects name available in the user's workspace
	 */
	public static List<String> getModelingProjects() { // ONLY the open ones !
		List<String> projectsNameList = new ArrayList<String>();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for(int i=0 ; i<projects.length; i++) {
			if(projects[i].getFile("representations.aird").exists()) {
				projectsNameList.add(projects[i].getName());
			}
		}
		return projectsNameList;
	}
	
	/**
	 * 
	 * @param modelingProject the name of the selected modeling project
	 * @return the list of all the report templates name that are available in the selected modeling project
	 */
	public static List<String> getTemplates(String modelingProject) { // For the SimulationManagementWindow (names)
		List<String> templatesName = new ArrayList<String>();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(modelingProject);
		IFolder templatesFolder = project.getFolder("Report Templates");
		try {
			IResource[] folderContent = templatesFolder.members();
			for(IResource resource : folderContent) {
				if(resource.getType() == IFile.FILE && resource.getFileExtension().equals("rptdesign")) {
					templatesName.add(resource.getName());
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return templatesName;
	}
	
	/**
	 * 
	 * @param reportTemplate the name of the selected report template
	 * @param modelingProject the name of the selected modeling project
	 * @return the path of the selected report template
	 */
	public static void setTemplatePath(String modelingProject, String reportTemplate) { // For ReportManager (path)
		String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		TEMPLATE_PATH = workspacePath+"/"+modelingProject+"/Report Templates/"+reportTemplate;
	}
	
	/**
	 * 
	 * @param modelingProject the name of the selected modeling project
	 * @return the directory path in which reports will be generated
	 */
	public static void setReportFolderPath(String modelingProject) { // For ReportManager
		String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		REPORT_FOLDER_PATH = workspacePath+"/"+modelingProject+"/Generated Reports";
	}
}

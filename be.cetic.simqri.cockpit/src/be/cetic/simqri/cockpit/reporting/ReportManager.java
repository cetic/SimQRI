package be.cetic.simqri.cockpit.reporting;

import java.io.File;

import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.eclipse.birt.core.framework.*;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;

import be.cetic.simqri.cockpit.views.LoaderWindow;

/**
 * 
 * @author FK
 * @version 1.1
 * This class manages the process of the BIRT reporting services
 *
 */
public class ReportManager {
	
	private List<String> extensions; // .pdf, .docx, .html, etc. Retrieved from NewSimulation.java
	private IReportEngine engine;
	private IReportRunnable report;
	private int createdReports;
	private boolean aborted;

	public ReportManager(List<String> extensions) {
		this.extensions = extensions;
	}
	
	public List<String> getExtensions() {
		return extensions;
	}

	public void setExtensions(List<String> extensions) {
		this.extensions = extensions;
	}
	
	public int getCreatedReports() {
		return createdReports;
	}

	public void setCreatedReports(int createdReports) {
		this.createdReports = createdReports;
	}
	
	public boolean isAborted() {
		return aborted;
	}

	public void setAborted(boolean aborted) {
		this.aborted = aborted;
	}
	
	/**
	 * 
	 * @param type the type of the executed simulation
	 * @throws EngineException
	 * This method generates the reports by using the rptdesign files (which are using the previously generated XML files) 
	 * and all the mechanisms provided by the BIRT Report Engine API
	 * 
	 */
	public void executeReport() throws EngineException {
		EngineConfig config = null;
		this.engine = null;
	    try
	    {
	    	// Prepare & open the BIRT report design
	    	config = new EngineConfig();                   
	        config.setLogConfig("simqri-reports/logs", java.util.logging.Level.WARNING);
	        
	        // Set the path that refers to the BIRT ReportEngine. 
	        // NO MORE USED : plug-ins are directly installed on the Eclipse IDE with the BIRT osgi update site
	        // config.setBIRTHome("simqri-reports/ReportEngine");
	        // config.setEngineHome("simqri-reports/ReportEngine");
	        
	        Platform.startup(config);
	        IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject( IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
	        engine = factory.createReportEngine( config );
	        WorkspaceManager.setReportFolderPath(WorkspaceManager.SELECTED_PROJECT);
	        WorkspaceManager.setTemplatePath(WorkspaceManager.SELECTED_PROJECT, WorkspaceManager.SELECTED_TEMPLATE);
	        try {
	         	report = engine.openReportDesign(WorkspaceManager.TEMPLATE_PATH);
	        }
	        catch(Exception e)
	        {
	        	JOptionPane.showMessageDialog(null, WorkspaceManager.TEMPLATE_PATH + " not found !\n"
	        			+ "Make sure your .rptdesign file is well located in the \"Report Templates\" directory !", "TEMPLATE FILE NOT FOUND", JOptionPane.ERROR_MESSAGE);
	            engine.destroy( );
	            Platform.shutdown();
	            return;
	        }
     
	        int nbReports = extensions.size();
	        this.createdReports = 0;
	        // Thread that manages the loader window behaviour
			Thread t = new Thread(new Runnable(){
		        public void run(){
		        	LoaderWindow lw = new LoaderWindow(nbReports, "Creating reports", "Results reports are being generated...", 
		        			"Process aborted !\nHowever, some reports may have already been generated.");
		        	while(lw.isEnabled()) {
		        		lw.setJpbStatus(createdReports);
		        		if(lw.getJpbStatus() == nbReports) {
		        			setAborted(false);
		        			lw.dispose();
		        		}
		        		else if(lw.isAborted()) {
		        			setAborted(true);
		        			lw.dispose();
		        		}
		        	}
		        }
		    });
			t.start();
			for(String extension : extensions) {
				if(isAborted()) 
					break;
	        	createReport(WorkspaceManager.REPORT_FOLDER_PATH, extension);
	        	this.createdReports++;
	        }
			// t.interrupt();
			if(!isAborted())
	        	JOptionPane.showMessageDialog(null,  "Your reports are now available in the selected directory !", "Simulation succeded", JOptionPane.INFORMATION_MESSAGE);
	        engine.destroy( );
	        Platform.shutdown();
	        engine = null;
	        return;
	    }
	    catch (Exception e)
		{
		    e.printStackTrace();
		} 
	}
	
	/**
	 * 
	 * @param path the path of the directory in which reports files will be created
	 * @param extension a file extension selected by the user
	 */
	private void createReport(String path, String extension) {
		// Get the full date to set it in the file name
		String format = "dd-MM-yyyy-HH-mm-ss"; 
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date date = new java.util.Date(); 
		String strDate = formater.format(date);
		if(isAborted()) return;
		IRunAndRenderTask task = engine.createRunAndRenderTask( report );
		
		// Particular for .pdf format
		if(extension.equals("pdf")) {
			PDFRenderOption options = new PDFRenderOption( );
	        options.setOutputFormat("pdf");
	        options.setOutputFileName(path+"/REPORT_"+strDate+".pdf");
	        task.setRenderOption(options);
		}
		else {
			HTMLRenderOption options = new HTMLRenderOption();
			options.setOutputFormat(extension);
			options.setOutputFileName(path+"/REPORT_"+strDate+"."+extension);
			task.setRenderOption(options);
		}
		if(isAborted()) return;
		try {
			task.run();
		}
		catch(EngineException e1) {
			JOptionPane.showMessageDialog(null, "Report generating failed in "+extension+" format.\n", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	@SuppressWarnings("unused")
	private String selectDirectoryPath() {
		String path = "";
		JFileChooser chooser = new JFileChooser();
	    // chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Select a destination folder for your reports !");
	    chooser.setCurrentDirectory(new File("current workspace ?"));
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
	    	path = chooser.getSelectedFile().toString();
	    else
	    	path = "";
	    return path;
	}
}

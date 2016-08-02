package be.cetic.simqri.cockpit.reporting;

import java.util.List;

import javax.swing.ImageIcon;
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

/**
 * 
 * @author FK
 * @version 1.0
 * This class manages the process of the BIRT reporting services
 *
 */
public class ReportManager {
	
	private List<String> extensions; // .pdf, .docx, .html, etc. Retrieved from NewSimulation.java
	private IReportEngine engine;
	private IReportRunnable report;
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
	public void executeReport(String type) throws EngineException {
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
	        String reportFilepath = null;
	        if(type.equals("One Shot"))
	        	reportFilepath = "simqri-reports/oneshot.rptdesign";
	        else
	        	reportFilepath = "simqri-reports/montecarlo.rptdesign";
	        try {
	         	report = engine.openReportDesign(reportFilepath);
	        }
	        catch(Exception e)
	        {
	        	JOptionPane.showMessageDialog(null, reportFilepath + " not found!\n"
	        			+ "Make sure you have properly configured your \"simqri-reports\" folder as it is explained in the installation guide ! ", "REPORT DESIGN FILE NOT FOUND", JOptionPane.ERROR_MESSAGE);
	            engine.destroy( );
	            Platform.shutdown();
	            return;
	        }
	        
	        // the user choose the path of the directory in which we will save report(s) file(s)
	        String path = selectDirectoryPath();
	        if(path.isEmpty()) {
	        	JOptionPane.showMessageDialog(null,  "The choice of the directory is aborted !", "Warning", JOptionPane.WARNING_MESSAGE);
	        	return;
	        }
	        
			Thread t = new Thread(new Runnable(){
		        public void run(){
		            int abort = JOptionPane.showConfirmDialog(null,  "Results reports are being processed.\nThis operation may also take a while...", "Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("simqri-reports/gifs/loader.gif"));
		            if(abort == JOptionPane.CANCEL_OPTION) {
			        	JOptionPane.showMessageDialog(null,  "Process aborted !\nHowever, some reports may have already been generated.", "Warning", JOptionPane.WARNING_MESSAGE);
		            	setAborted(true);
		            }
		        }
		    });
			t.start();
			for(String extension : extensions) {
	        	createReport(path, extension);
	        	if(isAborted()) 
					return;
	        }
			t.interrupt();
			
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
			JOptionPane.showMessageDialog(null, "Report " + path + " run failed in "+extension+" format.\n", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private String selectDirectoryPath() {
		String path = "";
		JFileChooser chooser = new JFileChooser();
	    // chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Select a destination folder for your reports !");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
	    	path = chooser.getSelectedFile().toString();
	    else
	    	path = "";
	    return path;
	}
}

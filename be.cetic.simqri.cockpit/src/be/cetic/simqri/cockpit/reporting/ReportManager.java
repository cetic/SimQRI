package be.cetic.simqri.cockpit.reporting;

import java.io.BufferedWriter;





import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

import be.cetic.simqri.cockpit.tracer.MonteCarloTracer;
import be.cetic.simqri.cockpit.tracer.OneShotTracer;

public class ReportManager {
	
	private File XMLFile;
	private List<String> extensions;
	IReportEngine engine;
	IReportRunnable report;

	public List<String> getExtensions() {
		return extensions;
	}

	public void setExtensions(List<String> extensions) {
		this.extensions = extensions;
	}

	public ReportManager(List<String> extensions) {
		this.extensions = extensions;
	}
	
	public void createXMLFile(OneShotTracer ost) {
		String allResults = "<oneshot>"+ost.getStringEvents()+ost.getStringElements()+ost.getStringProbes()+"</oneshot>";
		this.XMLFile = new File("simqri-reports/oneshot.xml");
		
		// Placing results in a XML file
		BufferedWriter  bf = null;
		try {
			bf = new BufferedWriter(new FileWriter(this.XMLFile));
			bf.write(allResults);
			bf.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "");
		}
	}
	
	public void createXMLFile(MonteCarloTracer mct) {
		String allResults = "<montecarlo>"+mct.getStringElements()+mct.getStringRuntime()+mct.getStringProbes()+"</montecarlo>";
		this.XMLFile = new File("simqri-reports/montecarlo.xml");
		
		// Placing results in a XML file 
		BufferedWriter  bf = null;
		try {
			bf = new BufferedWriter(new FileWriter(this.XMLFile));
			bf.write(allResults);
			bf.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "");
		}
	}
	
	public void executeReport(String type) throws EngineException {
		EngineConfig config = null;
		this.engine = null;
	    try
	    {
	    	// Prepare & open the BIRT report design
	    	config = new EngineConfig();                   
	        config.setLogConfig("simqri-reports/logs", java.util.logging.Level.WARNING);
	        // config.setBIRTHome("simqri-reports/ReportEngine");
	        // config.setEngineHome("simqri-reports/ReportEngine");
	        Platform.startup(config);
	        IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject( IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
	        System.out.println(factory);
	        engine = factory.createReportEngine( config );
	        String reportFilepath = null;
	        if(type.equals("One Shot"))
	        	reportFilepath = "simqri-reports/oneshot.rptdesign";
	        else
	        	reportFilepath = "simqri-reports/montecarlo.rptdesign";
	        try {
	         	report = engine.openReportDesign(reportFilepath);
	         	// TODO do while the report design file is not found
	        }
	        catch(Exception e)
	        {
	        	JOptionPane.showMessageDialog(null, ".rptdesign file " + reportFilepath + " not found!\n"
	        			+ "Make sure you have properly configured your \"simqri-reports\" folder as it is explained in the installation guide ! ", "REPORT DESIGN FILE NOT FOUND", JOptionPane.ERROR_MESSAGE);
	            engine.destroy( );
	            return;
	        }
	        
	        // choose the path for saving file(s) AND saving formats !
	        String path = selectDirectoryPath();
	        
	        for(String extension : extensions) {
	        	createReport(path, extension);
	        }
	        JOptionPane.showMessageDialog(null,  "Your reports are now available in the selected directory !", "Simulation succeded", JOptionPane.INFORMATION_MESSAGE);
	        // TODO Destroy XMLs
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
	    
	private void createReport(String path, String extension) {
		// Get the full date to set it as file name
		String format = "dd-MM-yyyy-HH-mm-ss"; 
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date date = new java.util.Date(); 
		String strDate = formater.format(date);
		
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
	    return path;
	}

}

package be.cetic.simqri.cockpit.tracer;

import java.io.BufferedWriter;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONException;

import be.cetic.simqri.cockpit.reporting.WorkspaceManager;
import be.cetic.simqri.cockpit.util.JsonFormat;
import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.metamodel.Query;
import oscar.des.logger.HistorySampling;
import oscar.des.logger.SamplingTuple;
import scala.collection.Iterator;
import scala.collection.immutable.List;

/**
 * 
 * @author FK
 * @since 20/04/2016
 * @version 3.0
 * 
 * This class stores "Monte-Carlo" simulation results by using appropriates collections.
 * It also creates an XML file containing data used for the reporting services.
 */
public class MonteCarloTracer {
	
	// Map = Java map ; List = Scala list
	// SamplingTuple & HistorySampling = JSon Strings
	private Map<String, List<SamplingTuple>> elementsSampling;
	private SamplingTuple runtimeSampling;
	private List<SamplingTuple> probesSampling;
	private List<HistorySampling> historySampling;
	private File XMLFile;
	private BufferedWriter bf;
	private Model model;
	
	public MonteCarloTracer(Model model) {
		this.XMLFile = new File("xml/montecarlo.xml");
		this.model = model;
		this.XMLFile.getParentFile().mkdirs();
	}
	
	public MonteCarloTracer(Model model, Map<String, List<SamplingTuple>> elementsSampling, SamplingTuple runtimeSampling,
			List<SamplingTuple> probesSampling, List<HistorySampling> historySampling) {
		super();
		this.elementsSampling = elementsSampling;
		this.runtimeSampling = runtimeSampling;
		this.probesSampling = probesSampling;
		this.historySampling = historySampling;
		this.model = model;
		this.XMLFile = new File("xml/montecarlo.xml");
		this.XMLFile.getParentFile().mkdirs();
	}
	
	public File getXMLFile() {
		return this.XMLFile;
	}
	
	public void createMonteCarloXMLFile() {
		try {
			bf = new BufferedWriter(new FileWriter(this.XMLFile));
			bf.write("<montecarlo>");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "");
		}
		this.setXMLElements();
		this.setXMLRuntime();
		this.setXMLProbes();
		this.endOfXMLFile();
	}
	
	private static void copyFileUsingStream(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	}
	
	private void endOfXMLFile() {
		try {
			bf.append("</montecarlo>");
			bf.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "");
		}
		// copy the generated XML File on the workspace for the user
		File xmlWorkspaceFile = new File(WorkspaceManager.XML_FOLDER_WORKSPACE_PATH+"/montecarlo.xml");
		try {
			copyFileUsingStream(this.XMLFile, xmlWorkspaceFile);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,  "Error while generating XML Workspace file !", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void setXMLElements() {
		@SuppressWarnings("unused")
		String elementsString = "\n  ----------------ELEMENTS---------------- \n";
		for(Map.Entry<String, List<SamplingTuple>> entry : elementsSampling.entrySet()) {
			String name = entry.getKey();
			elementsString += "\n  Element "+name+" : \n \n";
			Iterator<SamplingTuple> itAttributes = entry.getValue().iterator();
			while(itAttributes.hasNext()) {
				SamplingTuple attribute = itAttributes.next();
				String jsonAttribute = attribute.toJSONString();
				String attrName = JsonFormat.jsonToString(jsonAttribute, "name");
				String jsonDataSampling = JsonFormat.getJSonFromJSon(jsonAttribute,  "dataSampling");
				
				String attrMax = String.format("%.2f", JsonFormat.jsonToDouble(jsonDataSampling, "max"));
				String attrMin = String.format("%.2f", JsonFormat.jsonToDouble(jsonDataSampling, "min"));
				String attrMean = String.format("%.2f", JsonFormat.jsonToDouble(jsonDataSampling, "mean"));
				double attrVariance = JsonFormat.jsonToDouble(jsonDataSampling, "variance");
				String elementXML = "<element>";
				elementXML += "<name>"+name+"</name>";
				elementXML += "<attribute>"+attrName+"</attribute><max>"+attrMax+"</max><min>"+attrMin+"</min>";
				elementXML += "<mean>"+attrMean+"</mean><variance>"+attrVariance+"</variance></element>";
				try {
					bf.append(elementXML);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "");
				}
				elementsString += "  * "+attrName+" : \n";
				elementsString += "    - Max : "+attrMax+" \n";
				elementsString += "    - Min : "+attrMin+" \n";
				elementsString += "    - Mean : "+attrMean+" \n";
				elementsString += "    - Variance : "+attrVariance+" \n \n";
			}
			elementsString += "  ---------------------------------------- \n";
		}
		// return elementsString;
	}
	
	private void setXMLRuntime() {
		@SuppressWarnings("unused")
		String runtimeString = "\n  ----------------RUNTIME----------------- \n";
		String jsonRuntime = runtimeSampling.toJSONString();
		String jsonDataSampling = JsonFormat.getJSonFromJSon(jsonRuntime, "dataSampling");
		
		double attrMax = JsonFormat.jsonToDouble(jsonDataSampling, "max");
		double attrMin = JsonFormat.jsonToDouble(jsonDataSampling, "min");
		double attrMean = JsonFormat.jsonToDouble(jsonDataSampling, "mean");
		double attrVariance = JsonFormat.jsonToDouble(jsonDataSampling, "variance");
		
		String runtimeXML = "<runtime><max>"+attrMax+"</max><min>"+attrMin+"</min><mean>"+attrMean+"</mean><variance>"+attrVariance+"</variance>";
		runtimeString += "  * Max : "+attrMax+" \n";
		runtimeString += "  * Min : "+attrMin+" \n";
		runtimeString += "  * Mean : "+attrMean+" \n";
		runtimeString += "  * Variance : "+attrVariance+" \n \n";
		runtimeString += "  ---------------------------------------- \n";
		runtimeXML += "</runtime>";
		try {
			bf.append(runtimeXML);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "");
		}
		// return runtimeString;
	}
	
	private void setXMLProbes() {
		@SuppressWarnings("unused")
		String probesString = "\n  -----------------QUERIES----------------- \n";
		Iterator<SamplingTuple> itProbes = probesSampling.iterator();
		while(itProbes.hasNext()) {
			SamplingTuple probe = itProbes.next();
			
			String jsonProbe = probe.toJSONString();
			String attrName = JsonFormat.jsonToString(jsonProbe, "name");
			
			// Query XML conversion
			String jsonProbeSampling = JsonFormat.getJSonFromJSon(jsonProbe,  "dataSampling");
			String attrMax = String.format("%.2f", JsonFormat.jsonToDouble(jsonProbeSampling, "max"));
			String attrMin = String.format("%.2f", JsonFormat.jsonToDouble(jsonProbeSampling, "min"));
			String attrMean = String.format("%.2f", JsonFormat.jsonToDouble(jsonProbeSampling, "mean"));
			double attrVariance = JsonFormat.jsonToDouble(jsonProbeSampling, "variance");
			String probeXML = "<query>";
			probeXML += "<name>"+attrName+"</name>"+"<value>"+getQueryValue(attrName)+"</value>";
			probeXML += "<type>"+getQueryType(attrName)+"</type>"+"<system>"+getQuerySystem(attrName)+"</system>";
			probeXML += "<max>"+attrMax+"</max><min>"+attrMin+"</min>";
			probeXML += "<mean>"+attrMean+"</mean><variance>"+attrVariance+"</variance></query>";
			
			// Query's Histograms XML conversion
			JSONArray histograms = JsonFormat.jsonToArray(jsonProbeSampling, "histogram");
			java.util.List<Double> histoList = getQueryHistograms(histograms);
			String histoProbeXML = "";
			for(int i=0; i < histoList.size(); i+=2) {
				histoProbeXML += "<histogram>";
				histoProbeXML += "<name>"+attrName+"</name>";
				histoProbeXML += "<value>"+getQueryValue(attrName)+"</value>";
				histoProbeXML += "<type>"+getQueryType(attrName)+"</type>";
				histoProbeXML += "<system>"+getQuerySystem(attrName)+"</system>";
				histoProbeXML += "<mean>"+histoList.get(i)+"</mean>";
				histoProbeXML += "<frequency>"+histoList.get(i+1)+"</frequency></histogram>";
			}
			try {
				bf.append(probeXML);
				bf.append(histoProbeXML);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "");
			}
			probesString += "  * "+attrName+" : \n";
			probesString += "    - Max : "+attrMax+" \n";
			probesString += "    - Min : "+attrMin+" \n";
			probesString += "    - Mean : "+attrMean+" \n";
			probesString += "    - Variance : "+attrVariance+" \n \n";
		}
		probesString += "  ----------------------------------------- \n";
		// return probesString;
	}
	
	private java.util.List<Double> getQueryHistograms(JSONArray histograms) {
		java.util.List<Double> histoList = new java.util.ArrayList<Double>();
		for(int i=0; i<histograms.length(); i++) {
			String histogram = "";
			try {
				histogram = histograms.get(i).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double mean = JsonFormat.jsonToDouble(histogram, "mean");
			double frequency = JsonFormat.jsonToDouble(histogram,  "frequency");
			histoList.add(mean);
			histoList.add(frequency);
		}
		return histoList;
	}
	
	private String getQueryValue(String queryName) {
		for(Query q : model.getQuery()) {
			if(q.getName().equals(queryName))
				return q.getValue();
		}
		return "";
	}
	
	private String getQueryType(String queryName) {
		for(Query q : model.getQuery()) {
			if(q.getName().equals(queryName))
				return q.getType().toString();
		}
		return "";
	}
	
	private boolean getQuerySystem(String queryName) {
		for(Query q : model.getQuery()) {
			if(q.getName().equals(queryName))
				return q.isSystem();
		}
		return false;
	}
	
	/**
	 * @deprecated
	 */
	public String getStringHistory() {
		String historyString = "\n  -----------------HISTORY----------------- \n";
		Iterator<HistorySampling> itHistory = historySampling.iterator();
		while(itHistory.hasNext()) {
			HistorySampling history = itHistory.next();
			
			String jsonHistory = history.toJSONString().replace(" ",  "");
			String attrName = JsonFormat.jsonToString(jsonHistory, "name");
			
			String jsonHistorySampling = JsonFormat.getJSonFromJSon(jsonHistory,  "history");	
			
			historyString += "  * "+attrName+" : \n";
			historyString += jsonHistorySampling+" \n";
		}
		historyString += "  ----------------------------------------- \n";
		return historyString;
	}

	public Map<String, List<SamplingTuple>> getElementsSampling() {
		return elementsSampling;
	}

	public void setElementsSampling(Map<String, List<SamplingTuple>> elementsSampling) {
		this.elementsSampling = elementsSampling;
	}

	public SamplingTuple getRuntimeSampling() {
		return runtimeSampling;
	}

	public void setRuntimeSampling(SamplingTuple runtimeSampling) {
		this.runtimeSampling = runtimeSampling;
	}

	public List<SamplingTuple> getProbesSampling() {
		return probesSampling;
	}

	public void setProbesSampling(List<SamplingTuple> probesSampling) {
		this.probesSampling = probesSampling;
	}

	public List<HistorySampling> getHistorySampling() {
		return historySampling;
	}

	public void setHistorySampling(List<HistorySampling> historySampling) {
		this.historySampling = historySampling;
	}
}

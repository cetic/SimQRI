package be.cetic.simqri.cockpit.tracer;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import be.cetic.simqri.cockpit.reporting.WorkspaceManager;
import be.cetic.simqri.cockpit.util.JsonFormat;
import be.cetic.simqri.metamodel.Component;
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
 * The XML File is created in a "xml" folder at the root of the Eclipse IDE files and is
 * also copied in the workspace to allow an easier access for the user
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
		this.XMLFile.getParentFile().mkdirs();
		this.model = model;
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
	
	public void createXMLFile() {
		try {
			bf = new BufferedWriter(new FileWriter(this.XMLFile));
			bf.write("<montecarlo>");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "", "Error", JOptionPane.ERROR_MESSAGE);
		}
		this.setXMLElements();
		this.setXMLRuntime();
		this.setXMLProbes();
		this.setXMLHistory();
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
		// Retrieving the current date
		String format = "dd-MM-yyyy-HH-mm-ss"; 
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date date = new java.util.Date(); 
		String curDate = formater.format(date);
		// copy the generated XML File on the workspace for the user
		File xmlWorkspaceFile = new File(WorkspaceManager.XML_FOLDER_WORKSPACE_PATH+"/montecarlo_"+curDate+".xml");
		try {
			copyFileUsingStream(this.XMLFile, xmlWorkspaceFile);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,  "Error while creating XML Workspace file !", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Add "Elements" structues and their properties to the XML file
	 */
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
					JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "", "Error", JOptionPane.ERROR_MESSAGE);
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
	
	/**
	 * Add "Runtime" structue and its properties to the XML file
	 */
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
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "", "Error", JOptionPane.ERROR_MESSAGE);
		}
		// return runtimeString;
	}
	
	/**
	 * Add "Query" and "Histogram" structures and their properties to the XML file
	 */
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
			probeXML += "<mean>"+attrMean+"</mean><variance>"+attrVariance+"</variance>";
			probeXML += "<element-name>"+getElementName(getQueryValue(attrName))+"</element-name>";
			probeXML += "<element-type>"+getElementType(getElementName(getQueryValue(attrName)))+"</element-type></query>";
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
				histoProbeXML += "<frequency>"+histoList.get(i+1)+"</frequency>";
				histoProbeXML += "<element-name>"+getElementName(getQueryValue(attrName))+"</element-name>";
				histoProbeXML += "<element-type>"+getElementType(getElementName(getQueryValue(attrName)))+"</element-type></histogram>";
			}
			try {
				bf.append(probeXML);
				bf.append(histoProbeXML);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "", "Error", JOptionPane.ERROR_MESSAGE);
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
	
	public void setXMLHistory() { // Dedicated to "record" queries
		Iterator<HistorySampling> itHistory = historySampling.iterator();
		String historyXML = "";
		while(itHistory.hasNext()) {
			HistorySampling history = itHistory.next();
			String jsonHistory = history.toJSONString();
			String attrName = JsonFormat.jsonToString(jsonHistory,  "name");
			JSONArray historyArray = JsonFormat.jsonToArray(jsonHistory, "history");
			for(int i=0; i<historyArray.length(); i++) {
				JSONObject tuple = null;
				try {
					tuple = historyArray.getJSONObject(i);
				} catch (JSONException e) {
					JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "", "Error", JOptionPane.ERROR_MESSAGE);
				}
				double time = JsonFormat.jsonToDouble(tuple.toString(),  "time");
				JSONArray valuesArray = JsonFormat.jsonToArray(tuple.toString(),  "values");
				ArrayList<Double> values = new ArrayList<Double>();
				for(int j=0; j<valuesArray.length(); j++) {
					try {
						values.add(valuesArray.getDouble(j));
					} catch (JSONException e) {
						JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				double mean = getMean(values);
				historyXML += "<history><name>"+attrName+"</name><time>"+time+"</time>"
						   + "<max>"+getMax(values)+"</max><min>"+getMin(values)+"</min>"
						   + "<mean>"+mean+"</mean><variance>"+getVariance(values, mean)+"</variance></history>";
			}
		}
		try {
			bf.append(historyXML);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 
	 * @param histograms a JSON array that contains "Histogram" structures
	 * @return a List of doubles. even indexes contain "mean" numbers and 
	 * uneven indexes contain "frequency" numbers
	 */
	private java.util.List<Double> getQueryHistograms(JSONArray histograms) {
		java.util.List<Double> histoList = new java.util.ArrayList<Double>();
		for(int i=0; i<histograms.length(); i++) {
			String histogram = "";
			try {
				histogram = histograms.get(i).toString();
			} catch (JSONException e) {
				JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "", "Error", JOptionPane.ERROR_MESSAGE);
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
	
	private String getElementName(String queryValue) {
		Pattern pattern = Pattern.compile("\"(.*?)\"");
		Matcher matcher = pattern.matcher(queryValue);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return "";
	}
	
	private String getElementType(String elementName) {
		String type = "";
		for(Component c : model.getComponent()) {
			if(c.getName().equals(elementName)) {
				switch(c.getClass().toString()) {
				case "class be.cetic.simqri.metamodel.impl.BatchProcessImpl":
					type = "Batch Process";
					break;
				case "class be.cetic.simqri.metamodel.impl.ConveyorBeltImpl":
					type = "Batch Process";
					break;
				case "class be.cetic.simqri.metamodel.impl.StorageImpl":
					type = "Storage";
					break;
				case "class be.cetic.simqri.metamodel.impl.SupplierImpl":
					type = "Supplier";
					break;
				}
				break;
			}
		}
		return type;
	}
	
	private double getMax(ArrayList<Double> values) {
		double max = 0;
		for(double val : values) {
			if(val > max)
				max = val;
		}
		return max;
	}
	
	private double getMin(ArrayList<Double> values) {
		double min = values.get(0);
		for(double val : values) {
			if(val < min)
				min = val;
		}
		return min;
	}
	
	private double getMean(ArrayList<Double> values) {
		double mean = 0, sum = 0;
		for(double val : values)
			sum += val;
		mean = sum/values.size();
		return mean;
	}
	
	private double getVariance(ArrayList<Double> values, double mean) {
		double numerator = 0, denominator = values.size()-1;
		for(double val : values) {
			numerator += (val-mean)*(val-mean);
		}
		return numerator/denominator;
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

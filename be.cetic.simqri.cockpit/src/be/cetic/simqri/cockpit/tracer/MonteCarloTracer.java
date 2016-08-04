package be.cetic.simqri.cockpit.tracer;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import javax.swing.JOptionPane;

import be.cetic.simqri.cockpit.util.JsonFormat;
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
 * It also transform these collections into XML structures in order to be placed in a XML file.
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
	
	public MonteCarloTracer() {
		this.XMLFile = new File("xml/montecarlo.xml");
		this.XMLFile.getParentFile().mkdirs();
	}
	
	public MonteCarloTracer(Map<String, List<SamplingTuple>> elementsSampling, SamplingTuple runtimeSampling,
			List<SamplingTuple> probesSampling, List<HistorySampling> historySampling) {
		super();
		this.elementsSampling = elementsSampling;
		this.runtimeSampling = runtimeSampling;
		this.probesSampling = probesSampling;
		this.historySampling = historySampling;
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
	
	private void endOfXMLFile() {
		try {
			bf.append("</montecarlo>");
			bf.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "");
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
			
			String jsonProbeSampling = JsonFormat.getJSonFromJSon(jsonProbe,  "dataSampling");
			String attrMax = String.format("%.2f", JsonFormat.jsonToDouble(jsonProbeSampling, "max"));
			String attrMin = String.format("%.2f", JsonFormat.jsonToDouble(jsonProbeSampling, "min"));
			String attrMean = String.format("%.2f", JsonFormat.jsonToDouble(jsonProbeSampling, "mean"));
			double attrVariance = JsonFormat.jsonToDouble(jsonProbeSampling, "variance");
			String probeXML = "<query>";
			probeXML += "<name>"+attrName+"</name><max>"+attrMax+"</max><min>"+attrMin+"</min>";
			probeXML += "<mean>"+attrMean+"</mean><variance>"+attrVariance+"</variance></query>";
			try {
				bf.append(probeXML);
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

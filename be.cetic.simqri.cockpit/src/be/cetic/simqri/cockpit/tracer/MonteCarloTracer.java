package be.cetic.simqri.cockpit.tracer;

import java.util.Map;

import be.cetic.simqri.cockpit.util.JsonFormat;
import oscar.des.logger.HistorySampling;
import oscar.des.logger.SamplingTuple;
import scala.collection.Iterator;
import scala.collection.immutable.List;

/**
 * 
 * @author FK
 * @since 20/04/2016
 * @version 1.0
 * 
 * This class stores "Monte-Carlo" simulation results by using appropriates collections.
 * It also transform these collections into more "user-friendly" strings in order 
 * to be displayed to the user.
 * https://forge.cetic.be/projects/stage-maomy/wiki/Format_JSON_Résultats
 *
 */
public class MonteCarloTracer {
	
	// Map = Java map ; List = Scala list
	// SamplingTuple & HistorySampling = JSon Strings
	private Map<String, List<SamplingTuple>> elementsSampling;
	private SamplingTuple runtimeSampling;
	private List<SamplingTuple> probesSampling;
	private List<HistorySampling> historySampling;
	
	public MonteCarloTracer() {
		
	}
	
	public MonteCarloTracer(Map<String, List<SamplingTuple>> elementsSampling, SamplingTuple runtimeSampling,
			List<SamplingTuple> probesSampling, List<HistorySampling> historySampling) {
		super();
		this.elementsSampling = elementsSampling;
		this.runtimeSampling = runtimeSampling;
		this.probesSampling = probesSampling;
		this.historySampling = historySampling;
	}
	
	public String getStringElements() {
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
				
				elementsString += "  * "+attrName+" : \n";
				elementsString += "    - Max : "+attrMax+" \n";
				elementsString += "    - Min : "+attrMin+" \n";
				elementsString += "    - Mean : "+attrMean+" \n";
				elementsString += "    - Variance : "+attrVariance+" \n \n";
			}
			elementsString += "  ---------------------------------------- \n";
		}
		// System.out.println(elementsString);
		return elementsString;
	}
	
	public String getStringRuntime() {
		String runtimeString = "\n  ----------------RUNTIME----------------- \n";
		String jsonRuntime = runtimeSampling.toJSONString();
		String jsonDataSampling = JsonFormat.getJSonFromJSon(jsonRuntime, "dataSampling");
		
		double attrMax = JsonFormat.jsonToDouble(jsonDataSampling, "max");
		double attrMin = JsonFormat.jsonToDouble(jsonDataSampling, "min");
		double attrMean = JsonFormat.jsonToDouble(jsonDataSampling, "mean");
		double attrVariance = JsonFormat.jsonToDouble(jsonDataSampling, "variance");
		
		runtimeString += "  * Max : "+attrMax+" \n";
		runtimeString += "  * Min : "+attrMin+" \n";
		runtimeString += "  * Mean : "+attrMean+" \n";
		runtimeString += "  * Variance : "+attrVariance+" \n \n";
		runtimeString += "  ---------------------------------------- \n";
		
		// System.out.println(runtimeString);
		return runtimeString;
	}
	
	public String getStringProbes() {
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
			
			probesString += "  * "+attrName+" : \n";
			probesString += "    - Max : "+attrMax+" \n";
			probesString += "    - Min : "+attrMin+" \n";
			probesString += "    - Mean : "+attrMean+" \n";
			probesString += "    - Variance : "+attrVariance+" \n \n";
		}
		probesString += "  ----------------------------------------- \n";
		// System.out.println(probesString);
		return probesString;
	}
	
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
		// System.out.println(historyString);
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

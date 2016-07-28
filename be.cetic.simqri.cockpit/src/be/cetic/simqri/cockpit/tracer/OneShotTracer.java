package be.cetic.simqri.cockpit.tracer;

import java.util.Map;
import java.util.TreeMap;

import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.immutable.List;

/**
 * 
 * @author FK
 * @since 20/04/2016
 * @version 2.0
 * 
 * This class stores "One Shot" simulation results by using appropriates collections.
 * It also transform these collections into more "user-friendly" strings in order 
 * to be displayed to the user.
 * https://forge.cetic.be/projects/stage-maomy/wiki/Format_JSON_Résultats
 *
 */
public class OneShotTracer {
	
	// /!\ Map = Java map ; List = Scala list
	// Object = Scala Double
	private Map<Object, List<Tuple2<String, String>>> events;
	private Map<String, Tuple2<String, List<Tuple2<String, Object>>>> mapInfos;
	private List<Tuple2<String, String>> probes;
	private List<String> rawInfos;
	
	public OneShotTracer() {
		
	}
	
	public OneShotTracer(Map<Object, List<Tuple2<String, String>>> events,
			Map<String, Tuple2<String, List<Tuple2<String, Object>>>> mapInfos, List<Tuple2<String, String>> probes,
			List<String> rawInfos) {
		super();
		this.events = events;
		this.mapInfos = mapInfos;
		this.probes = probes;
		this.rawInfos = rawInfos;
	}
	
	public String getStringEvents() {
		String eventsXML = "";
		@SuppressWarnings("unused")
		String eventsString = "\n  -----------------EVENTS----------------- \n";
		for(Map.Entry<Object, List<Tuple2<String, String>>> entry : events.entrySet()) {
			String time = String.valueOf(entry.getKey());
			eventsString += "\n  At time "+time+" : \n";
			Iterator<Tuple2<String, String>> itTraces = entry.getValue().iterator();
			while(itTraces.hasNext()) {
				Tuple2<String, String> trace = itTraces.next();
				eventsXML += "<event>";
				eventsXML += "<time>"+time+"</time>";
				eventsXML += "<element>"+trace._1+"</element><action>"+trace._2+"</action>";
				eventsXML += "</event>";
				eventsString += "  * "+trace._1+" : "+trace._2+" \n";
			}
			eventsString += "  ---------------------------------------- \n";
		}
		return eventsXML;
		//return eventsString;
	}
	
	public String getStringElements() {
		String elementsXML = "";
		@SuppressWarnings("unused")
		String elementsString = "\n  ----------------ELEMENTS---------------- \n";
		for(Map.Entry<String, Tuple2<String, List<Tuple2<String, Object>>>> entry : mapInfos.entrySet()) {
			String name = entry.getKey();
			elementsString += "\n  Element "+name+" ";
			Tuple2<String, List<Tuple2<String, Object>>> typeAndInfos = entry.getValue();
			String type = (String) typeAndInfos._1;
			elementsString += "("+type+") : \n";
			List<Tuple2<String, Object>> listInfos = (List<Tuple2<String, Object>>) typeAndInfos._2;
			Iterator<Tuple2<String, Object>> itInfos = listInfos.iterator();
			while(itInfos.hasNext()) {
				elementsXML += "<element>";
				elementsXML += "<name>"+name+"</name>";
				elementsXML += "<type>"+type+"</type>";
				Tuple2<String, Object> infos = itInfos.next();
				String attribute = infos._1;
				String value = String.valueOf(infos._2);
				elementsXML += "<attribute>"+attribute+"</attribute><value>"+value+"</value>";
				elementsXML += "</element>";
				elementsString += "  * "+attribute+" : "+value+" \n";
			}
			elementsString += "  ---------------------------------------- \n";
		}
		return elementsXML;
		//return elementsString;
	}
	
	public String getStringProbes() {
		String probesXML = "";
		@SuppressWarnings("unused")
		String probesString = "\n  -----------------QUERIES---------------- \n";
		Iterator<Tuple2<String, String>> itProbes = probes.iterator();
		while(itProbes.hasNext()) {
			Tuple2<String, String> probe = itProbes.next();
			String query = probe._1;
			String value = probe._2.replaceAll("[^\\d.]", "");
			double doubleValue = Double.parseDouble(value);
			probesXML += "<query>";
			probesXML += "<name>"+query+"</name><value>"+value+"</value>";
			probesXML += "</query>";
			probesString += "  * "+query+" : "+String.format("%.2f", doubleValue)+"\n";
		}
		probesString += "  ---------------------------------------- \n";
		return probesXML;
		//return probesString;
	}
	
	public Map<Object, List<Tuple2<String, String>>> getEvents() {
		return events;
	}
	
	public void setEvents(Map<Object, List<Tuple2<String, String>>> events) {
		Map<Object, List<Tuple2<String, String>>> sortedEvents = new TreeMap<Object, List<Tuple2<String, String>>>(events);
		this.events = sortedEvents;
	}
	
	public Map<String, Tuple2<String, List<Tuple2<String, Object>>>> getMapInfos() {
		return mapInfos;
	}
	
	public void setMapInfos(Map<String, Tuple2<String, List<Tuple2<String, Object>>>> mapInfos) {
		this.mapInfos = mapInfos;
	}
	
	public List<Tuple2<String, String>> getProbes() {
		return probes;
	}
	
	public void setProbes(List<Tuple2<String, String>> probes) {
		this.probes = probes;
	}
	
	public List<String> getRawInfos() {
		return rawInfos;
	}
	
	public void setRawInfos(List<String> rawInfos) {
		this.rawInfos = rawInfos;
	}
}

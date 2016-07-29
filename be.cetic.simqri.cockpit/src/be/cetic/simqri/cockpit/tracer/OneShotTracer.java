package be.cetic.simqri.cockpit.tracer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.immutable.List;

/**
 * 
 * @author FK
 * @since 20/04/2016
 * @version 3.0
 * 
 * This class stores "One Shot" simulation results by using appropriates collections.
 * It also transform these collections into XML structures in order to be placed in a XML file.
 *
 */
public class OneShotTracer {
	
	// /!\ Map = Java map ; List = Scala list
	// Object = Scala Double
	private Map<Object, List<Tuple2<String, String>>> events;
	private Map<String, Tuple2<String, List<Tuple2<String, Object>>>> mapInfos;
	private List<Tuple2<String, String>> probes;
	private List<String> rawInfos;
	private File XMLFile;
	private BufferedWriter bf;
	
	public OneShotTracer() {
		this.XMLFile = new File("simqri-reports/oneshot.xml");
	}
	
	public OneShotTracer(Map<Object, List<Tuple2<String, String>>> events,
			Map<String, Tuple2<String, List<Tuple2<String, Object>>>> mapInfos, List<Tuple2<String, String>> probes,
			List<String> rawInfos) {
		super();
		this.events = events;
		this.mapInfos = mapInfos;
		this.probes = probes;
		this.rawInfos = rawInfos;
		this.XMLFile = new File("simqri-reports/oneshot.xml");
	}
	
	public File getXMLFile() {
		return this.XMLFile;
	}
	
	public void createOneShotXMLFile() {
		try {
			bf = new BufferedWriter(new FileWriter(this.XMLFile));
			bf.write("<oneshot>");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "");
		}
		this.setXMLEvents();
		this.setXMLElements();
		this.setXMLProbes();
		this.endOfXMLFile();
	}
	
	private void endOfXMLFile() {
		try {
			bf.append("</oneshot>");
			bf.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "");
		}
	}
	
	private void setXMLEvents() {
		@SuppressWarnings("unused")
		String eventsString = "\n  -----------------EVENTS----------------- \n";
		for(Map.Entry<Object, List<Tuple2<String, String>>> entry : events.entrySet()) {
			String time = String.valueOf(entry.getKey());
			eventsString += "\n  At time "+time+" : \n";
			Iterator<Tuple2<String, String>> itTraces = entry.getValue().iterator();
			while(itTraces.hasNext()) {
				Tuple2<String, String> trace = itTraces.next();
				String eventXML = "<event>";
				eventXML += "<time>"+time+"</time>";
				eventXML += "<element>"+trace._1+"</element><action>"+trace._2+"</action>";
				eventXML += "</event>";
				eventsString += "  * "+trace._1+" : "+trace._2+" \n";
				try {
					bf.append(eventXML);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "");
				}
			}
			eventsString += "  ---------------------------------------- \n";
		}
		// return eventsString;
	}
	
	private void setXMLElements() {
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
				String elementXML = "<element>";
				elementXML += "<name>"+name+"</name>";
				elementXML += "<type>"+type+"</type>";
				Tuple2<String, Object> infos = itInfos.next();
				String attribute = infos._1;
				String value = String.valueOf(infos._2);
				elementXML += "<attribute>"+attribute+"</attribute><value>"+value+"</value>";
				elementXML += "</element>";
				try {
					bf.append(elementXML);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "");
				}
				elementsString += "  * "+attribute+" : "+value+" \n";
			}
			elementsString += "  ---------------------------------------- \n";
		}
		// return elementsString;
	}
	
	private void setXMLProbes() {
		@SuppressWarnings("unused")
		String probesString = "\n  -----------------QUERIES---------------- \n";
		Iterator<Tuple2<String, String>> itProbes = probes.iterator();
		while(itProbes.hasNext()) {
			Tuple2<String, String> probe = itProbes.next();
			String query = probe._1;
			String value = probe._2.replaceAll("[^\\d.]", "");
			double doubleValue = Double.parseDouble(value);
			String probeXML = "<query>";
			probeXML += "<name>"+query+"</name><value>"+value+"</value>";
			probeXML += "</query>";
			try {
				bf.append(probeXML);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage() + "");
			}
			probesString += "  * "+query+" : "+String.format("%.2f", doubleValue)+"\n";
		}
		probesString += "  ---------------------------------------- \n";
		// return probesString;
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

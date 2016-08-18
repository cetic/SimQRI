package be.cetic.simqri.cockpit.util;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author FK
 * @since 19/04/2016
 * @version 1.0
 *
 * This class contains static methods that will transphorm simulation results from JSon format to Java types
 */
public class JsonFormat {
	
	/**
	 * 
	 * @param jsonString
	 * @param key
	 * @return a string that contains the json value linked to the key
	 */
	public static String jsonToString(String jsonString, String key) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(jsonString);
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null,  "Invalid JSon format", "Error", JOptionPane.ERROR_MESSAGE);
		}
		String val = null;
		try {
			val = jsonObject.getString(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,  "Invalid JSon format", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return val;
	}
	
	/**
	 * 
	 * @param jsonString
	 * @param key
	 * @return a double that contains the json value linked to the key
	 */
	public static double jsonToDouble(String jsonString, String key) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(jsonString);
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null,  "Invalid JSon format", "Error", JOptionPane.ERROR_MESSAGE);
		}
		double val = 0;
		try {
			val = jsonObject.getDouble(key);
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null,  "Invalid JSon format", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return val;
	}
	
	/**
	 * 
	 * @param jsonString
	 * @param key
	 * @return a JSONArray that contains the json value linked to the key
	 */
	public static JSONArray jsonToArray(String jsonString, String key) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(jsonString);
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null,  "Invalid JSon format", "Error", JOptionPane.ERROR_MESSAGE);
		}
		JSONArray val = null;
		try {
			val = jsonObject.getJSONArray(key);
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null,  "Invalid JSon format", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return val;
	}
	
	/**
	 * 
	 * @param jsonString
	 * @param key
	 * @return a string that contains the json value from an internal json object of the jsonString linked to the key
	 */
	public static String getJSonFromJSon(String jsonString, String key) {
		JSONObject json = null;
		try {
			json = new JSONObject(jsonString);
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null,  "Invalid JSon format", "Error", JOptionPane.ERROR_MESSAGE);
		}
		JSONObject subJson = null;
		try {
			subJson = json.getJSONObject(key);
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null,  "Invalid JSon format", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return subJson.toString();
	}
}

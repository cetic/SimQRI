package be.cetic.simqri.cockpit.util;

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
	
	public static String jsonToString(String jsonString, String key) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(jsonString);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String val = null;
		try {
			val = jsonObject.getString(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return val;
	}
	
	public static double jsonToDouble(String jsonString, String key) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(jsonString);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		double val = 0;
		try {
			val = jsonObject.getDouble(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return val;
	}
	
	public static String getJSonFromJSon(String jsonString, String key) {
		JSONObject json = null;
		try {
			json = new JSONObject(jsonString);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		JSONObject subJson = null;
		try {
			subJson = json.getJSONObject(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return subJson.toString();
	}
}

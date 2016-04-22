package be.cetic.simqri.cockpit.util;

import java.lang.reflect.Type;


import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @author FK
 * @since 19/04/2016
 * @version 1.0
 *
 * This class contains static methods that will transphorm simulation results from JSon format to Java types
 */
public class JsonFormat {
	
	public static java.util.List<String> jsonToList(String jsonString, String key) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(jsonString);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		Type listType = new TypeToken<java.util.List<String>>() {}.getType();
		java.util.List<String> list = null;
		try {
			list = new Gson().fromJson(jsonObject.getJSONArray(key).toString(), listType);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static String jsonToString(String jsonString, String key) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(jsonString);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		Type stringType = new TypeToken<java.lang.String>() {}.getType();
		String val = null;
		try {
			val = new Gson().fromJson(jsonObject.getString(key), stringType);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JSONException e) {
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
		Type doubleType = new TypeToken<java.lang.Double>() {}.getType();
		double val = 0;
		try {
			val = new Gson().fromJson(String.valueOf(jsonObject.getDouble(key)), doubleType);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JSONException e) {
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

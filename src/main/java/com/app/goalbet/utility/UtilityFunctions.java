package com.app.goalbet.utility;

public class UtilityFunctions {
	
	public static String addQueryParam(String url, String param, String value) {
		String resultUrl = url + "?" + param + "=" + value;
		return resultUrl;
	}
	
	public static String addQueryIdentifier(String url, String value) {
		String resultUrl = url + "/identifier" + "/" + value;
		return resultUrl;
	}

}

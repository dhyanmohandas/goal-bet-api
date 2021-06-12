package com.app.goalbet.utility;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class UtilityFunctions {
	
	LocalDateTime convertToUtc(LocalDateTime time) {
	    return time.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();
	}
	
	public static String addQueryParam(String url, String param, String value) {
		String resultUrl = url + "?" + param + "=" + value;
		return resultUrl;
	}
	
	public static String addQueryIdentifier(String url, String value) {
		String resultUrl = url + "/identifier" + "/" + value;
		return resultUrl;
	}

}

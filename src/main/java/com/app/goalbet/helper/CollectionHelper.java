package com.app.goalbet.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.app.goalbet.models.ApiResponse;
import com.app.goalbet.models.ApiResult;
import com.app.goalbet.models.PredictionDetails;
import com.app.goalbet.utility.RestApiUtility;

import io.swagger.models.Response;

@Component
public class CollectionHelper {
	
	@Autowired
	RestApiUtility restApiUtility;


	public ResponseEntity<ApiResult> getAPIResponse(String url, String apiKey) {
		ResponseEntity<ApiResult> response = restApiUtility.getRestTemplate(url, 
				HttpMethod.GET, apiKey);
		return response;
	}
	public ResponseEntity<String> getAPI(String url, String apiKey) {
		ResponseEntity<String> response = restApiUtility.getRestTemplateResponse(url, 
				HttpMethod.GET, apiKey);	
		return response;
	}
	
	public void insertPredictions(String url, String apiKey, PredictionDetails predictionDetails) {
		ResponseEntity<String> response = restApiUtility.postRestTemplateResponse(url, 
				HttpMethod.POST, apiKey, predictionDetails);
	}
}

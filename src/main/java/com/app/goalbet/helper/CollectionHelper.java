package com.app.goalbet.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.app.goalbet.models.PredictionDetails;
import com.app.goalbet.utility.RestApiUtility;

@Component
public class CollectionHelper {
	
	@Autowired
	RestApiUtility restApiUtility;

	public String insertPredictions(PredictionDetails predictionDetails) {		
		return "Success";		
	}
	
	public String getPredictions(String url, String apiKey) {
		System.out.println("Get Predictions from collection");
		ResponseEntity<String> response = restApiUtility.getRestTemplateResponse(url, 
				HttpMethod.GET, apiKey);
		System.out.print(response);
		return "Success";		
	}
	
	public String insertPredictions(String url, String apiKey, PredictionDetails predictionDetails) {
		System.out.println("Insert Predictions from collection");
		ResponseEntity<String> response = restApiUtility.postRestTemplateResponse(url, 
				HttpMethod.POST, apiKey, predictionDetails);
		System.out.print(response);
		return "Success";		
	}
}

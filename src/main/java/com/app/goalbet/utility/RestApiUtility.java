package com.app.goalbet.utility;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.goalbet.models.PredictionDetails;

@Component
public class RestApiUtility {
	public ResponseEntity<String> getRestTemplateResponse(String url, HttpMethod httpMethod, String apiKey) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = getHttpHeaders(apiKey);
		ResponseEntity<String> response = restTemplate.exchange(url, httpMethod, entity, String.class);
		return response;
	}
	
	public ResponseEntity<String> postRestTemplateResponse(String url, HttpMethod httpMethod, String apiKey, PredictionDetails predictionDetails) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = getHttpHeaders(apiKey);
		ResponseEntity<String> response = restTemplate.exchange(url, httpMethod, entity, String.class, predictionDetails);
		return response;
	}

	private HttpEntity<String> getHttpHeaders(String apiKey) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Accept", "application/json");
		headers.set("x-api-key", apiKey);

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return entity;
	}
}

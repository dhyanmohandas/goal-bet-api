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
		HttpHeaders headers = getHttpHeaders(apiKey);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.exchange(url, httpMethod, entity, String.class);		
		return response;
	}

	public ResponseEntity<String> postRestTemplateResponse(String url, HttpMethod httpMethod, String apiKey,
			PredictionDetails predictionDetails) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = getHttpHeaders(apiKey);
		HttpEntity<PredictionDetails> entity = new HttpEntity<PredictionDetails>(predictionDetails, headers);
		ResponseEntity<String> response = restTemplate.exchange(url, httpMethod, entity, String.class);
		return response;
	}

	private HttpHeaders getHttpHeaders(String apiKey) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Accept", "application/json");
		headers.set("x-api-key", apiKey);
		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		return headers;
	}
}

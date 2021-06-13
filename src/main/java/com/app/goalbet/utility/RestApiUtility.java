package com.app.goalbet.utility;

import java.util.Arrays;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.goalbet.models.ApiResult;
import com.app.goalbet.models.PredictionDetails;


@Component
public class RestApiUtility {
	
	public ResponseEntity<ApiResult> getRestTemplate(String url, HttpMethod httpMethod, String apiKey) {
		RestTemplate restTemplate = getRestTemplate();
		HttpHeaders headers = getHttpHeaders(apiKey);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<ApiResult> response = restTemplate.exchange(url, httpMethod, entity, ApiResult.class);
		return response;
	}
	public ResponseEntity<String> getRestTemplateResponse(String url, HttpMethod httpMethod, String apiKey) {
		RestTemplate restTemplate = getRestTemplate();
		HttpHeaders headers = getHttpHeaders(apiKey);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.exchange(url, httpMethod, entity, String.class);
		return response;
	}

	public ResponseEntity<String> postRestTemplateResponse(String url, HttpMethod httpMethod, String apiKey,
			PredictionDetails predictionDetails) {
		RestTemplate restTemplate = getRestTemplate();
		HttpHeaders headers = getHttpHeaders(apiKey);
		HttpEntity<PredictionDetails> entity = new HttpEntity<PredictionDetails>(predictionDetails, headers);
		ResponseEntity<String> response = restTemplate.exchange(url, httpMethod, entity, String.class);
		return response;
	}
	
	private RestTemplate getRestTemplate() {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		return restTemplate;
	}

	private HttpHeaders getHttpHeaders(String apiKey) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Accept", "application/json");
		headers.set("x-api-key", apiKey);
		return headers;
	}
}

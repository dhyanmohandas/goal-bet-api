package com.app.goalbet.service;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.goalbet.helper.CollectionHelper;
import com.app.goalbet.models.ApiResponse;
import com.app.goalbet.models.ApiResult;
import com.app.goalbet.models.MatchDetails;
import com.app.goalbet.models.MatchPredictions;
import com.app.goalbet.models.PredictionDetails;
import com.app.goalbet.utility.CommonConstants;
import com.app.goalbet.utility.UtilityFunctions;

import org.apache.commons.beanutils.*;


@Service
public class GoalBetService {
	
	@Autowired
	CollectionHelper collectionHelper;


	public ResponseEntity<List<MatchPredictions>> getPredictions()  {
		List<MatchPredictions> matchPredictions = new ArrayList<MatchPredictions>();
		ResponseEntity<ApiResult> matchDetails = getNextMatchDetails();
		for (int i = 0; i < matchDetails.getBody().getData().size(); i++) {
			try {
			String url = UtilityFunctions.addQueryParam(CommonConstants.DB_BASE_URL + CommonConstants.PREDICTION_STORE_ID,
					"matchId",BeanUtils.getProperty(matchDetails.getBody().getData().get(i),"_id"));
			ResponseEntity<ApiResult> predictions = collectionHelper.getAPIResponse(url, CommonConstants.PREDICTION_API_KEY);
				
			MatchPredictions matchPrediction = new MatchPredictions();
			matchPrediction.setMatch(matchDetails.getBody().getData().get(i));
			matchPrediction.setPredictions(predictions.getBody().getData());
			matchPredictions.add(matchPrediction);

			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		 return new ResponseEntity<List<MatchPredictions>>(matchPredictions, HttpStatus.OK);
	}
	
	public String insertPredictions(PredictionDetails predictionDetails) {
		String url = UtilityFunctions.addQueryParam(CommonConstants.DB_BASE_URL + CommonConstants.PREDICTION_STORE_ID, "matchId", predictionDetails.getMatchId());
		ResponseEntity<ApiResult> dupResult = collectionHelper.getAPIResponse(url + "&userId=" + predictionDetails.getUserId(), CommonConstants.PREDICTION_API_KEY);
		ApiResult res = dupResult.getBody();
		if(res.getData().size()==0) {
			collectionHelper.insertPredictions(CommonConstants.DB_BASE_URL + CommonConstants.PREDICTION_STORE_ID, CommonConstants.PREDICTION_API_KEY, predictionDetails);
			return "Successfully Inserted";
		}
		return "Insertion Error";		
	}
	
	public ResponseEntity<ApiResult> getNextMatchDetails() {
		LocalDate lt = LocalDate.now();
		String url = UtilityFunctions.addQueryParam(CommonConstants.DB_BASE_URL + CommonConstants.MATCH_STORE_ID, "Date" , lt.toString());
		return collectionHelper.getAPIResponse(url, CommonConstants.MATCH_API_KEY);
	}
	
	public String calculateScore(String matchId, int team1Goals, int team2Goals) {		
		return "success";		
	}
	
	public ResponseEntity<String> getUserDetails(String userId) {
		String url = UtilityFunctions.addQueryIdentifier(CommonConstants.DB_BASE_URL + CommonConstants.USER_STORE_ID , userId);
		return collectionHelper.getAPI(url, CommonConstants.USER_API_KEY);
	}
	
	public ResponseEntity<String> validateUserPrediction(String userId) {
		String result = "";
		ResponseEntity<ApiResult> matchDetails = getNextMatchDetails();

		for (int i = 0; i < matchDetails.getBody().getData().size(); i++) {
			try {
			String url = UtilityFunctions.addQueryParam(CommonConstants.DB_BASE_URL + CommonConstants.PREDICTION_STORE_ID,
					"matchId",BeanUtils.getProperty(matchDetails.getBody().getData().get(i),"_id"));
			ResponseEntity<ApiResult> predictions = collectionHelper.getAPIResponse(url + "&userId=" + userId, CommonConstants.PREDICTION_API_KEY);
			System.out.print("=========================");
			System.out.print(predictions.getBody().getData().toString());
			if(predictions.getBody().getData().size()==0) {
				return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
			}

			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return ResponseEntity.ok("Success");
	}


}

package com.app.goalbet.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.goalbet.helper.CollectionHelper;
import com.app.goalbet.models.PredictionDetails;
import com.app.goalbet.utility.CommonConstants;
import com.app.goalbet.utility.UtilityFunctions;

@Service
public class GoalBetService {
	
	@Autowired
	CollectionHelper collectionHelper;
	

	public ResponseEntity<String> getPredictions() {
		return collectionHelper.getPredictions(CommonConstants.DB_BASE_URL + CommonConstants.PREDICTION_STORE_ID, CommonConstants.PREDICTION_API_KEY);
	}
	
	public void insertPredictions(PredictionDetails predictionDetails) {
		String url = UtilityFunctions.addQueryParam(CommonConstants.DB_BASE_URL + CommonConstants.PREDICTION_STORE_ID, "matchId", predictionDetails.getMatchId());
		ResponseEntity<String> r = collectionHelper.getPredictions(url + "&userId=" + predictionDetails.getUserId(), CommonConstants.PREDICTION_API_KEY);
		System.out.println(r);
		collectionHelper.insertPredictions(CommonConstants.DB_BASE_URL + CommonConstants.PREDICTION_STORE_ID, CommonConstants.PREDICTION_API_KEY, predictionDetails);
		
	}
	
	public ResponseEntity<String> getNextMatchDetails() {
		LocalDate lt = LocalDate.now();
		String url = UtilityFunctions.addQueryParam(CommonConstants.DB_BASE_URL + CommonConstants.MATCH_STORE_ID, "Date" , lt.toString());
		return collectionHelper.getPredictions(url, CommonConstants.MATCH_API_KEY);
	}
	
	public String calculateScore(String matchId, int team1Goals, int team2Goals) {		
		return "success";		
	}
	
	public ResponseEntity<String> getUserDetails(String userId) {
		String url = UtilityFunctions.addQueryIdentifier(CommonConstants.DB_BASE_URL + CommonConstants.USER_STORE_ID , userId);
		return collectionHelper.getPredictions(url, CommonConstants.USER_API_KEY);
	}

}

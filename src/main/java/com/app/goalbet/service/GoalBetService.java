package com.app.goalbet.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.goalbet.helper.CollectionHelper;
import com.app.goalbet.models.ApiResponse;
import com.app.goalbet.models.ApiResult;
import com.app.goalbet.models.PredictionDetails;
import com.app.goalbet.utility.CommonConstants;
import com.app.goalbet.utility.UtilityFunctions;

@Service
public class GoalBetService {
	
	@Autowired
	CollectionHelper collectionHelper;
	

	public ResponseEntity<String> getPredictions() {
		ResponseEntity<ApiResult> matchDetails = getNextMatchDetails();
		collectionHelper.getAPIResponse(CommonConstants.DB_BASE_URL + CommonConstants.PREDICTION_STORE_ID, CommonConstants.PREDICTION_API_KEY);
		 return null;
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

}

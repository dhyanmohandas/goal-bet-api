package com.app.goalbet.service;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.goalbet.helper.CollectionHelper;
import com.app.goalbet.helper.PredictionScoreCalculator;
import com.app.goalbet.models.PredictionDetails;
import com.app.goalbet.utility.CommonConstants;
import com.app.goalbet.utility.UtilityFunctions;

@Service
public class GoalBetService {
	
	@Autowired
	CollectionHelper collectionHelper;
	
	@Autowired
	PredictionScoreCalculator predictionScoreCalculator;
	

	public ResponseEntity<String> getPredictions() {
		return collectionHelper.getPredictions("https://app.usecollection.co/store/LJYQDTQVK85N141Q6VVVN7JV1I192A", "910e061c-924c-4c74-8529-58c0f353299c");
	}
	
	public void insertPredictions(PredictionDetails predictionDetails) {
		predictionScoreCalculator.calculate(predictionDetails.getTeamGoals1(), predictionDetails.getTeamGoals2());
		collectionHelper.insertPredictions("https://app.usecollection.co/store/LJYQDTQVK85N141Q6VVVN7JV1I192A", "910e061c-924c-4c74-8529-58c0f353299c", predictionDetails);
		
	}
	
	public ResponseEntity<String> getNextMatchDetails() {
		LocalDate lt = LocalDate.now();
		String url = UtilityFunctions.addQueryParam(CommonConstants.DB_BASE_URL + CommonConstants.MATCH_STORE_ID, "Date" , lt.plusDays(1).toString());
		return collectionHelper.getPredictions(url, CommonConstants.MATCH_API_KEY);
	}

}

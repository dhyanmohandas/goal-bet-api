package com.app.goalbet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.goalbet.helper.CollectionHelper;
import com.app.goalbet.helper.PredictionScoreCalculator;
import com.app.goalbet.models.PredictionDetails;

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

}

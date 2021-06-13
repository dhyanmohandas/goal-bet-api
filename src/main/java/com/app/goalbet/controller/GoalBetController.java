package com.app.goalbet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.app.goalbet.api.CalculateScoreApi;
import com.app.goalbet.api.GetNextMatchDetailsApi;
import com.app.goalbet.api.GetPredictionsApi;
import com.app.goalbet.api.GetUserDetailsApi;
import com.app.goalbet.api.InfoApi;
import com.app.goalbet.api.PredictGoalApi;
import com.app.goalbet.api.ValidateUserPredictionApi;
import com.app.goalbet.models.ApiResponse;
import com.app.goalbet.models.ApiResult;
import com.app.goalbet.models.MatchPredictions;
import com.app.goalbet.models.PredictionDetails;
import com.app.goalbet.models.UserData;
import com.app.goalbet.service.GoalBetService;


@RestController
public class GoalBetController implements ValidateUserPredictionApi, CalculateScoreApi, GetUserDetailsApi, InfoApi, PredictGoalApi, GetPredictionsApi, GetNextMatchDetailsApi {

	@Override
	 public ResponseEntity<List<UserData>> getUserDetails(){
		 List<UserData> userList = new ArrayList<UserData>();
		 goalBetService.getUserDetails("60c497d27280b3001b12c339");
		return new ResponseEntity<List<UserData>>(userList,HttpStatus.OK);
	}
	
	@Autowired
	GoalBetService goalBetService;

	@Override
	public ResponseEntity<String> getInfo() {
		return new ResponseEntity<String>("Goal-Bet Version1", HttpStatus.OK);
	}

	@Override
	@CrossOrigin
	public ResponseEntity<String> predictGoalPost(@Valid PredictionDetails predictionDetails) {
		String result = goalBetService.insertPredictions(predictionDetails);
		return ResponseEntity.ok(result);
	}

	@Override
	@CrossOrigin
	public ResponseEntity<List<MatchPredictions>> getPredictions() {
		return goalBetService.getPredictions();
	}

	@Override
	public ResponseEntity<ApiResult> getNextMatchDetails() {
		return goalBetService.getNextMatchDetails();
	}

	@Override
	public ResponseEntity<ApiResult> calculateScore(@Valid String matchId, @Valid Integer team1, @Valid Integer team2) {
		return new ResponseEntity<ApiResult>(HttpStatus.OK);
	}

	@Override
	@CrossOrigin
	public ResponseEntity<String> validateUserPrediction(@Valid String userId) {
		return goalBetService.validateUserPrediction(userId);
	}



	
}

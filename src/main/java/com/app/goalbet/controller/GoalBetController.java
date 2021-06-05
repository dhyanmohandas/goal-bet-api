package com.app.goalbet.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.app.goalbet.api.GoalBetApi;
import com.app.goalbet.models.UserData;


@RestController
public class GoalBetController implements GoalBetApi {

	 public ResponseEntity<List<UserData>> goalBetGet(){
		return new ResponseEntity<List<UserData>>(null);
	}
	
}

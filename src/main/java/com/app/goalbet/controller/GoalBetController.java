package com.app.goalbet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoalBetController {

	
	@GetMapping("/")
	public String get() {
		return "Goal Bet 1";	
	}
	
}

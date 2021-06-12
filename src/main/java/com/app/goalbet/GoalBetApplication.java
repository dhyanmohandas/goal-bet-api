package com.app.goalbet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Goal-Bet"))
@SpringBootApplication
public class GoalBetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoalBetApplication.class, args);
	}

}

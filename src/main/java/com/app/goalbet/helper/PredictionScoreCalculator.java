package com.app.goalbet.helper;

import org.springframework.stereotype.Component;

@Component
public class PredictionLossCalculator {

	correct_prediction(int originalGoal1, int originalGoal2, int predictedGoal1, int predictedGoal2)
	{
		if ((originalGoal1 - originalGoal2) * (predictedGoal1 - predictedGoal2) > 0) or ((originalGoal1 - originalGoal2) == 0 and (predictedGoal1 - predictedGoal2) == 0)
			return 1;
	}
	
	public int calculate(int originalGoal1, int originalGoal2, int predictedGoal1, int predictedGoal2) {

		int penalty_for_incorrectness = 5;
		int loss = 0;
		loss = Math.abs(originalGoal1 - predictedGoal1) + Math.abs(originalGoal2 - predictedGoal2) + Math.abs((originalGoal1 - originalGoal2) - (predictedGoal1 - predictedGoal2))

		if !(correct_prediction(int originalGoal1, int originalGoal2, int predictedGoal1, int predictedGoal2))
		{
			loss = loss + penalty_for_incorrectness;
		}
		return loss;
	}

}

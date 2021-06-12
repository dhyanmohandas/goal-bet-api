package com.app.goalbet.helper;

import org.springframework.stereotype.Component;

import com.app.goalbet.utility.CommonConstants;

@Component
public class PredictionScoreCalculator {

	public boolean correctPrediction(int originalGoal1, int originalGoal2, int predictedGoal1, int predictedGoal2)
	{
		if((originalGoal1 - originalGoal2)*(predictedGoal1 - predictedGoal2) > 0) {
			return true;
		}
		if((originalGoal1 - originalGoal2) == 0 && (predictedGoal1 - predictedGoal2) == 0) {
			return true;
		}
		return false;
	}
	
	public int calculate(int originalGoal1, int originalGoal2, int predictedGoal1, int predictedGoal2) {
		int loss = 0;
		loss = Math.abs(originalGoal1 - predictedGoal1) + Math.abs(originalGoal2 - predictedGoal2) + Math.abs((originalGoal1 - originalGoal2) - (predictedGoal1 - predictedGoal2));

		if (!correctPrediction( originalGoal1,originalGoal2,predictedGoal1, predictedGoal2))
		{
			loss = loss + CommonConstants.PENALTY_FOR_INCORRECTNESS;
		}
		return loss;
	}

}

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
	
	public int calculateLoss(int originalGoal1, int originalGoal2, int predictedGoal1, int predictedGoal2) {
		int loss = 0;
		loss = Math.abs(originalGoal1 - predictedGoal1) + Math.abs(originalGoal2 - predictedGoal2) + Math.abs((originalGoal1 - originalGoal2) - (predictedGoal1 - predictedGoal2));

		if (!correctPrediction( originalGoal1,originalGoal2,predictedGoal1, predictedGoal2))
		{
			loss = loss + CommonConstants.PENALTY_FOR_INCORRECTNESS;
		}
		return loss;
	}


	public static double calculateSD(float numArray[])
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length = numArray.length;

        for(double num : numArray) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }

	public int calculateMedian(float losses[]) {
		Arrays.sort(losses);
		double median;
		if (losses.length % 2 == 0)
		    median = ((double)losses[losses.length/2] + (double)losses[losses.length/2 - 1])/2;
		else
		    median = (double) losses[losses.length/2];

		return median;
	}

	public int[] calculateScore(float losses[]){
		int median = calculateMedian(losses);
		int standardDeviation = calculateSD(losses);
		for (i=0; i<losses.length; i++) {
		  losses[i] = (median - losses[i]) / standardDeviation;
		}
		return losses;
	}



}

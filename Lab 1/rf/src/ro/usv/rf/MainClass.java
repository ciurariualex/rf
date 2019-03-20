package ro.usv.rf;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainClass {

	public static void main(String[] args) 
	{
		double[][] learningSet = FileUtils.readLearningSetFromFile("Matrix.txt");
		FileUtils.writeLearningSetToFile("MatrixOut.csv", normalizeLearningSet(learningSet));
	}

	private static double[][] normalizeLearningSet(double[][] learningSet) 
	{
		double[][] normalizedLearningSet = new double[learningSet.length][learningSet[0].length];
		for(int currentCol = 0; currentCol < learningSet[0].length; currentCol++) 
		{
			Double min = Double.MAX_VALUE;
			Double max = Double.NEGATIVE_INFINITY;
			for(int currentLine = 0; currentLine < learningSet.length; currentLine++) 
			{
				if(learningSet[currentLine][currentCol] < min) 
				{
					min = learningSet[currentLine][currentCol];
				}
				if(learningSet[currentLine][currentCol] > max) 
				{
					max = learningSet[currentLine][currentCol];
				}
			}
			for(int currentLine = 0; currentLine < learningSet.length; currentLine++) 
			{
				normalizedLearningSet[currentLine][currentCol] = (learningSet[currentLine][currentCol]-min)
						/ (max - min);
				normalizedLearningSet[currentLine][currentCol] = Math.floor(normalizedLearningSet[currentLine][currentCol]*100)/100;
			}
		}
		
		return normalizedLearningSet;
	}
}
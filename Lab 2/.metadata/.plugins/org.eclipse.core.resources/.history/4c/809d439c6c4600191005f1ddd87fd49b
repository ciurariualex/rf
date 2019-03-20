package ro.usv.rf;

import java.util.HashMap;
import java.util.Map;

public class StatisticsUtils 
{

	protected static double calculateFeatureAverage(Double[] feature) {
		Map<Double, Integer> counterMap = getFeatureDistincElementsCounterMap(feature);
		double featureAverage = 0;

		double sum1 = 0;
		double sum2 = 0;

		sum1 = counterMap.keySet().stream()
				.mapToDouble(x -> calculateSum1(x, counterMap.get(x))).sum();
		sum2 = counterMap.values().stream()
				.mapToInt(x -> x).sum();
		featureAverage = sum1 / sum2;
		System.out.println("The feature average is: " +  featureAverage);
		return featureAverage;
}
	
	protected static Map<Double, Integer> getFeatureDistincElementsCounterMap(Double feature[])
	{
		Map<Double, Integer> counterMap = new HashMap<Double, Integer>();
		for (int j = 0; j < feature.length; j++) {
			if (counterMap.containsKey(feature[j])) {
				int count = counterMap.get(feature[j]);
				counterMap.put((feature[j]), ++count);
			} else {
				counterMap.put((feature[j]), 1);
			}
		}
		return counterMap;
	}
	protected static Map<Double, Double> getFeatureDistincElementsWeightedMap(Double feature[], Double weights[])
	{
		Map<Double, Double> counterMap = new HashMap<Double, Double>();
		for (int j = 0; j < feature.length; j++) {
			if (counterMap.containsKey(feature[j])) {
				Double count = counterMap.get(feature[j]);
				counterMap.put((feature[j]), count+weights[j]);
			} else {
				counterMap.put((feature[j]), weights[j]);
			}
		}
		return counterMap;
	}
	
	private static Double calculateSum1(double value, int count)
	{
		return count * value;
	}
	private static Double calculateSum2(double value, double weight)
	{
		return weight * value;
	}


	protected static double calculateFeatureWeightedAverage(Double[] feature, Double[] weights) {
		double featureWeightedAverage = 0.0;
		// your code here
		Map<Double, Double> counterMap = getFeatureDistincElementsWeightedMap(feature,weights);
		//double featureAverage = 0;

		double sum1 = 0;
		double sum2 = 0;

		sum1 = counterMap.keySet().stream()
				.mapToDouble(x -> calculateSum2(x, counterMap.get(x))).sum();
		sum2 = counterMap.values().stream()
				.mapToDouble(x -> x).sum();
		featureWeightedAverage = sum1 / sum2;
		//System.out.println("The feature weighted average is: " +  featureWeightedAverage);
		return featureWeightedAverage;
	}
	
	protected static double calculateFrequencyOfOccurence(Map<Double, Integer> counterMap, double featureElement) {
		double frequencyOfOccurence = 0.0;
		// your code here
		double sum2 = counterMap.values().stream().mapToDouble(x -> x).sum();
		frequencyOfOccurence=counterMap.get(featureElement)/sum2;
		return frequencyOfOccurence;
	}
	
	protected static double calculateFeatureDispersion(Double[] feature, double featureWeightedAverage) {
		double featureDispersion = 0.0; 
		// your code here
		double interm_sum = 0.0;
		for(int i=0;i<feature.length;i++)
			interm_sum += Math.pow((feature[i] - featureWeightedAverage), 2);
		featureDispersion = interm_sum / (feature.length - 1);
		return featureDispersion;
	}
	
	protected static double calculateCovariance (Double[] feature1, Double[] feature2,
			double feature1WeightedAverage,double feature2WeightedAverage) {
		double covariance = 0.0;
		// your code here
		double interm_sum = 0.0;
		for(int i=0;i<feature1.length;i++)
			interm_sum += (feature1[i] - feature1WeightedAverage)*(feature2[i] - feature2WeightedAverage);
		covariance = interm_sum / (feature1.length - 1);
		return covariance;
	}
	
	protected static double calculateCorrelationCoefficient  (double covariance, double feature1Dispersion, 
			double feature2Dispersion ) {
		double correlationCoefficient = 0.0;
		// your code here
		correlationCoefficient = (covariance) / (Math.sqrt(feature1Dispersion*feature2Dispersion));
		return correlationCoefficient;
	}
	
	protected static double calculateAverageSquareDeviation (double featureDispersion ) {
		double averageSquareDeviation = 0.0;
		// your code here
		averageSquareDeviation = Math.sqrt(featureDispersion);
		return averageSquareDeviation;
	}
}
//

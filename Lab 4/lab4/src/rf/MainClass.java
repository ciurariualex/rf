package rf;

public class MainClass {

	public static void main(String[] args) {
		double[][] learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("in.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;

			double[][] distanceMatrix = DistanceUtils.calculateMatrixDistance(learningSet);

			for (int i = 0; i < distanceMatrix.length; i++) {
				for (int j = 0; j < distanceMatrix[0].length; j++) {
					System.out.print(distanceMatrix[i][j] + "\t");
				}
				System.out.println();
			}
			
			int searchedPatternIndex = learningSet.length - 1;
			double[] distances = distanceMatrix[searchedPatternIndex];
			
			double calculatedClass = DistanceUtils.calculateClass(learningSet[learningSet.length - 1].length,
					learningSet, learningSet[learningSet.length - 1], distances);
			System.out.println("Class: " + calculatedClass);
			System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns,
					numberOfFeatures));
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}

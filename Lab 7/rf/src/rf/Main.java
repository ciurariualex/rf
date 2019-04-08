package rf;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String[][] learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("in.txt");

			List<String> classesList = new ArrayList<String>();
			for (int i = 0; i < learningSet.length; i++) {
				if (!classesList.contains(learningSet[i][learningSet[i].length - 1])) {
					classesList.add(learningSet[i][learningSet[i].length - 1]);
				}
			}

			double[][] wMatrix = new double[classesList.size()][learningSet[0].length];

			for (int i = 0; i < wMatrix.length; i++) {
				double freeTermn = 0.0;
				for (int j = 0; j < wMatrix[i].length - 1; j++) {
					double classSum = 0.0;
					int classMembers = 0;
					for (int k = 0; k < learningSet.length; k++) {
						if (learningSet[k][learningSet[k].length - 1].equals(classesList.get(i))) {
							classSum += Double.valueOf(learningSet[k][j]);
							classMembers++;
						}
					}
					wMatrix[i][j] = classSum / classMembers;
					freeTermn += -0.5 * (Math.pow(wMatrix[i][j], 2));
				}
				wMatrix[i][wMatrix[i].length - 1] = freeTermn;

			}

			double[] form1 = new double[3];
			form1[0] = 4;
			form1[1] = 5;
			form1[2] = 1;

			double[] phi = new double[3];

			for (int i = 0; i < wMatrix.length; i++) {
				double phiVal = 0.0;
				for (int j = 0; j < wMatrix[i].length; j++) {
					phiVal += form1[j] * wMatrix[i][j];
				}
				phi[i] = phiVal;
			}
			double max = Double.NEGATIVE_INFINITY;
			for (int i = 0; i < phi.length; i++) {
				max = Double.max(phi[i], max);
			}

			for (int i = 0; i < phi.length; i++) {
				if (max == phi[i]) {
					System.out.println(classesList.get(i));
				}
			}
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}

import java.util.ArrayList;

public class OptimalAccountBalancing {
	public static int[][] minCashFlow(int[][] adjacencyMatrix, int n) {
		if (n <= 0)
			return adjacencyMatrix;

		int[] netSum = new int[n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				netSum[i] = netSum[i] + (adjacencyMatrix[j][i] - adjacencyMatrix[i][j]);
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				adjacencyMatrix[i][j] = 0;
			}
		}

		int minValueIdx = 0, maxValueIdx = 0, minValue;
		while (true) {
			for (int i = 0; i < n; ++i) {
				if (netSum[i] < netSum[minValueIdx]) {
					minValueIdx = i;
				}

				if (netSum[i] > netSum[maxValueIdx]) {
					maxValueIdx = i;
				}
			}

			if (netSum[minValueIdx] == 0) {
				break;
			}

			minValue = Math.min(-netSum[minValueIdx], netSum[maxValueIdx]);

			netSum[minValueIdx] += minValue;
			netSum[maxValueIdx] -= minValue;

			adjacencyMatrix[minValueIdx][maxValueIdx] = minValue;
		}

		return adjacencyMatrix;
	}

	public static int minTransactions(ArrayList<ArrayList<Integer[]>> adjacencyList) {

		if (adjacencyList.size() < 2)
			return 0;

		int[] netSum = new int[adjacencyList.size()];
		for (int i = 0; i < adjacencyList.size(); ++i) {
			for (Integer[] outgoingEdge : adjacencyList.get(i)) {
				netSum[i] -= outgoingEdge[1];
				netSum[outgoingEdge[0]] += outgoingEdge[1];
			}
		}

		int minTransactions = 0;
		int minValueIdx = 0, maxValueIdx = 0;
		int minValue;
		while (true) {
			for (int i = 0; i < adjacencyList.size(); ++i) {
				if (netSum[i] < netSum[minValueIdx]) {
					minValueIdx = i;
				}

				if (netSum[i] > netSum[maxValueIdx]) {
					maxValueIdx = i;
				}
			}

			if (netSum[minValueIdx] == 0) {
				break;
			}

			minValue = Math.min(-netSum[minValueIdx], netSum[maxValueIdx]);

			netSum[minValueIdx] += minValue;
			netSum[maxValueIdx] -= minValue;

			System.out.println("P" + minValueIdx + " paid " + minValue + " to P" + maxValueIdx + ".");

			++minTransactions;
		}

		return minTransactions;
	}
}

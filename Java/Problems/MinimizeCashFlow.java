package Problems;

/**
 * Given a number of friends who have to give or take some amount of money from
 * one another. Design an algorithm by which the total cash flow among all the
 * friends is minimized.
 * https://www.geeksforgeeks.org/minimize-cash-flow-among-given-set-friends-borrowed-money/
 */
public class MinimizeCashFlow {

    // T = O(n^2) | S = O(n)
    // Where n is number of friends.
    public static int solve(int[][] adjcencyMatrix) {
        int friends = adjcencyMatrix.length;

        int[] cashFlow = new int[friends];
        for (int i = 0; i < friends; ++i) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < friends; ++j) {
                rowSum += adjcencyMatrix[i][j];
                colSum += adjcencyMatrix[j][i];
            }

            cashFlow[i] = colSum - rowSum;
        }

        int transactions = 0;
        while (true) {
            int minValueIdx = 0, maxValueIdx = 0;
            for (int i = 0; i < cashFlow.length; ++i) {
                if (cashFlow[minValueIdx] > cashFlow[i]) {
                    minValueIdx = i;
                }

                if (cashFlow[maxValueIdx] < cashFlow[i]) {
                    maxValueIdx = i;
                }
            }

            if (cashFlow[minValueIdx] == 0 && cashFlow[maxValueIdx] == 0) {
                break;
            }

            cashFlow[minValueIdx] = cashFlow[minValueIdx] + cashFlow[maxValueIdx];
            cashFlow[maxValueIdx] = 0;

            ++transactions;
        }

        return transactions;
    }
}

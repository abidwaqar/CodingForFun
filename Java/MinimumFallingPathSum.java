/**
 * Given an n x n array of integers matrix, return the minimum sum of any
 * falling path through matrix.
 * 
 * A falling path starts at any element in the first row and chooses the element
 * in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col
 * - 1), (row + 1, col), or (row + 1, col + 1).
 * 
 * Example 1:
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 */
public class MinimumFallingPathSum {

    // T = O(n^2) | S = O(n)
    // Where n is input array's length.
    public static int solve(int[][] matrix) {
        int[] aboveRow = new int[matrix.length];
        int[] belowRow = new int[matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            aboveRow[i] = Integer.MAX_VALUE;
            belowRow[i] = matrix[matrix.length - 1][i];
        }

        for (int i = matrix.length - 1; i > 0; --i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                for (int k = Math.max(j - 1, 0); k <= Math.min(j + 1, matrix[i].length - 1); ++k) {
                    aboveRow[k] = Math.min(aboveRow[k], belowRow[j] + matrix[i - 1][k]);
                }

                belowRow[j] = Integer.MAX_VALUE;
            }

            int[] swapVar = aboveRow;
            aboveRow = belowRow;
            belowRow = swapVar;
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; ++i) {
            minSum = Math.min(minSum, belowRow[i]);
        }

        return minSum;
    }
}

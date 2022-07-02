package Problems;

/**
 * Given three sorted arrays A, B and Cof not necessarily same sizes.
 * 
 * Calculate the minimum absolute difference between the maximum and minimum
 * number from the triplet a, b, c such that a, b, c belongs arrays A, B, C
 * respectively.
 * 
 * i.e. minimize | max(a,b,c) - min(a,b,c) |.
 * 
 * Example :
 * Input:
 * A : [ 1, 4, 5, 8, 10 ]
 * B : [ 6, 9, 15 ]
 * C : [ 2, 3, 6, 6 ]
 * 
 * Output:
 * 1
 */
public class MinimizeAbsoluteDifference {

    // T = O(m + n + o) | S = O(1)
    // Where m, n and o are the lengths of the input arrays.
    public static int solve(int[] A, int[] B, int[] C) throws Exception {
        int a = 0, b = 0, c = 0, minDiff = Integer.MAX_VALUE;
        while (a < A.length && b < B.length && c < C.length) {
            minDiff = Math.min(minDiff, Math.max(A[a], Math.max(B[b], C[c])) - Math.min(A[a], Math.min(B[b], C[c])));

            if (A[a] <= B[b] && A[a] <= C[c]) {
                ++a;
            } else if (B[b] <= A[a] && B[b] <= C[c]) {
                ++b;
            } else if (C[c] <= A[a] && C[c] <= B[b]) {
                ++c;
            }
        }

        return minDiff;
    }
}
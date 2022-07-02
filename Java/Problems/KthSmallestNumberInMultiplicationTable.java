package Problems;

/**
 * Nearly everyone has used the Multiplication Table. The multiplication table
 * of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).
 * 
 * Given three integers m, n, and k, return the kth smallest element in the m x
 * n multiplication table.
 */
public class KthSmallestNumberInMultiplicationTable {

    // T = O(m * log(m * n)) | S = O(1)
    public static int solve(int m, int n, int k) {
        int left = 0, right = m * n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (enough(m, n, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean enough(int m, int n, int k, int num) {
        int count = 0;
        for (int i = 1; i <= m; ++i) {
            count += Math.min(n, (num / i));
        }

        return count >= k;
    }
}

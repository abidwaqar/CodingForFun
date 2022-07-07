package Problems;

public class NCR {
    static int nCr(int n, int r) {
        return (int) (Factorial.factorial(n) / (Factorial.factorial(r) * Factorial.factorial(n - r)));
    }

    static int P = 1000000007;

    static int nCrOptimized(int n, int r) {
        int[] C = new int[r + 1];

        C[0] = 1;
        for (int i = 1; i <= r; i++) {
            C[i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; --j) {
                C[j] = (C[j] + C[j - 1]) % P;
            }
        }

        return C[r];
    }
}

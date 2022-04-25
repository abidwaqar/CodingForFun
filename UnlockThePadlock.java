import java.util.Scanner;

public class UnlockThePadlock {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                int N = sc.nextInt();
                int D = sc.nextInt();

                int[] V = new int[N];
                for (int j = 0; j < N; ++j) {
                    V[j] = sc.nextInt();
                }

                System.out.println("Case #" + i + ": " + solve(D, V));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static long solve(int D, int[] V) throws Exception {
        long[][][] cache = new long[V.length][V.length][2];
        for (int i = 0; i < V.length; ++i) {
            for (int j = 0; j < V.length; ++j) {
                for (int k = 0; k < 2; ++k) {
                    cache[i][j][k] = -1;
                }
            }
        }

        return solveRecursive(D, V, 0, V.length - 1, true, cache);
    }

    private static long solveRecursive(int D, int[] V, int i, int j, boolean left, long[][][] cache) {
        if (i > j) {
            return 0;
        }

        int leftBit = left ? 0 : 1;
        if (cache[i][j][leftBit] != -1) {
            return cache[i][j][leftBit];
        }

        int rotations;
        if (left == true && i != 0) {
            rotations = D - V[i - 1];
        } else if (left == false && j != V.length - 1) {
            rotations = D - V[j + 1];
        } else {
            rotations = 0;
        }

        int currActualNum = (V[i] + rotations) % D;
        int currOperations = Math.min(currActualNum, D - currActualNum);
        long val1 = currOperations + solveRecursive(D, V, i + 1, j, true, cache);

        currActualNum = (V[j] + rotations) % D;
        currOperations = Math.min(currActualNum, D - currActualNum);
        long val2 = currOperations + solveRecursive(D, V, i, j - 1, false, cache);

        cache[i][j][leftBit] = Math.min(val1, val2);
        return cache[i][j][leftBit];
    }
}
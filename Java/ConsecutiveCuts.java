
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://www.facebook.com/codingcompetitions/hacker-cup/2022/round-1/problems/A1
 * https://www.facebook.com/codingcompetitions/hacker-cup/2022/round-1/problems/A2
 */
public class ConsecutiveCuts {
    public static void main(String[] args) {
        String filePath = ".\\Java\\Helper\\";
        try (Scanner sc = new Scanner(new File(filePath + "input.txt"));
                PrintWriter writer = new PrintWriter(filePath + "output.txt")) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                int N = sc.nextInt();
                int K = sc.nextInt();

                int[] A = new int[N];
                for (int j = 0; j < N; ++j) {
                    A[j] = sc.nextInt();
                }

                int[] B = new int[N];
                for (int j = 0; j < N; ++j) {
                    B[j] = sc.nextInt();
                }

                writer.println("Case #" + i + ": " + (solve(N, K, A, B) ? "YES" : "NO"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // T = O(n) | S = O(n)
    // Where n is N.
    private static boolean solve(int N, int K, int[] A, int[] B) throws Exception {
        int index = modifiedKmp(N, A, B, K == 1);

        if (index == -1) {
            return false;
        }

        if (N == 2) {
            if (A[0] == A[1] && A[0] == B[0] && A[0] == B[1]) {
                return true;
            }

            return index == (K % 2);
        }

        // N > 2
        return !((index != 0 && K == 0));
    }

    private static int[] preprocessing(int N, int[] A) {
        int[] preprocessedArray = new int[N];
        preprocessedArray[0] = -1;

        int left = 0, right = 1;
        while (right < N) {
            if (A[left] == A[right]) {
                preprocessedArray[right] = left;
                ++left;
                ++right;
            } else {
                if (left == 0) {
                    ++right;
                } else {
                    left = preprocessedArray[left - 1] + 1;
                }
            }
        }

        return preprocessedArray;
    }

    private static int modifiedKmp(int N, int[] A, int[] B, boolean checkFromMiddle) {
        int[] preprocessedArray = preprocessing(N, A);

        int AIdx = 0, BIdx = checkFromMiddle ? 1 : 0, upperBound = checkFromMiddle ? (N * 2) - 1 : N * 2;
        while (BIdx < upperBound) {
            if (A[AIdx] == B[BIdx % N]) {
                ++AIdx;
                ++BIdx;

                if (AIdx == N) {
                    return BIdx - N;
                }
            } else {
                if (AIdx == 0) {
                    ++BIdx;
                } else {
                    AIdx = preprocessedArray[AIdx - 1] + 1;
                }
            }
        }

        return -1;
    }
}
package Problems;

import java.util.Arrays;
import java.util.Scanner;

public class D1000000 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                int N = sc.nextInt();
                int[] S = new int[N];
                for (int j = 0; j < N; j++) {
                    S[j] = sc.nextInt();
                }

                System.out.println("Case #" + i + ": " + solve(S));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int solve(int[] S) throws Exception {
        Arrays.sort(S);

        int longestStraight = 0;
        for (int i : S) {
            if (longestStraight < i) {
                ++longestStraight;
            }
        }

        return longestStraight;
    }
}
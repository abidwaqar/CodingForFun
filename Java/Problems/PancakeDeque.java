package Problems;

import java.util.Scanner;

public class PancakeDeque {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                int N = sc.nextInt();
                int[] D = new int[N];
                for (int j = 0; j < N; ++j) {
                    D[j] = sc.nextInt();
                }

                System.out.println("Case #" + i + ": " + solve(D));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int solve(int[] pancakes) throws Exception {
        int maxDeliciousnessLevel = 0, paidCustomersCount = 0;
        int lowerBound = 0, upperBound = pancakes.length - 1;
        while (lowerBound <= upperBound) {
            int currentPackageDeliciousnessLevel;
            if (pancakes[lowerBound] < pancakes[upperBound]) {
                currentPackageDeliciousnessLevel = pancakes[lowerBound];
                ++lowerBound;
            } else {
                currentPackageDeliciousnessLevel = pancakes[upperBound];
                --upperBound;
            }

            if (maxDeliciousnessLevel <= currentPackageDeliciousnessLevel) {
                maxDeliciousnessLevel = currentPackageDeliciousnessLevel;
                ++paidCustomersCount;
            }
        }

        return paidCustomersCount;
    }
}
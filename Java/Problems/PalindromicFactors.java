package Problems;

import java.util.Scanner;

public class PalindromicFactors {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                long A = sc.nextLong();

                System.out.println("Case #" + i + ": " + solve(A));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int solve(long A) throws Exception {
        int palindromicFactorsCount = 0;

        double sqrtA = Math.sqrt(A);
        for (int i = 1; i <= sqrtA; ++i) {
            if (A % i == 0) {
                long factor = A / i;
                if (factor == i) {
                    if (isPalindrome(String.valueOf(factor))) {
                        ++palindromicFactorsCount;
                    }
                } else {
                    if (isPalindrome(String.valueOf(factor))) {
                        ++palindromicFactorsCount;
                    }
                    if (isPalindrome(String.valueOf(i))) {
                        ++palindromicFactorsCount;
                    }
                }
            }
        }

        return palindromicFactorsCount;
    }

    private static boolean isPalindrome(String str) {
        int limit = str.length() / 2;

        for (int i = 0; i < limit; ++i) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
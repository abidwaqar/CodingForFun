package Problems;

import java.util.Scanner;

public class PalindromeFreeStrings {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                // No need for the length of string
                sc.nextInt();

                StringBuilder S = new StringBuilder(sc.next());

                System.out.println("Case #" + i + ": " + solve(S, 0));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String POSSIBLE = "POSSIBLE";
    private static String IMPOSSIBLE = "IMPOSSIBLE";

    private static String solve(StringBuilder stringBuilder, int index) throws Exception {
        if (index == stringBuilder.length()) {
            return POSSIBLE;
        }

        if (stringBuilder.charAt(index) == '?') {
            stringBuilder.setCharAt(index, '0');
            if (!isLast5or6charactersPalindrome(stringBuilder, index)
                    && solve(stringBuilder, index + 1).equals(POSSIBLE)) {
                return POSSIBLE;
            }

            stringBuilder.setCharAt(index, '1');
            if (!isLast5or6charactersPalindrome(stringBuilder, index)
                    && solve(stringBuilder, index + 1).equals(POSSIBLE)) {
                return POSSIBLE;
            }

            stringBuilder.setCharAt(index, '?');
            return IMPOSSIBLE;
        }

        return isLast5or6charactersPalindrome(stringBuilder, index) ? IMPOSSIBLE : solve(stringBuilder, index + 1);
    }

    static private boolean isLast5or6charactersPalindrome(StringBuilder stringBuilder, int index) {
        if (index >= 4 && stringBuilder.charAt(index) == stringBuilder.charAt(index - 4)
                && stringBuilder.charAt(index - 1) == stringBuilder.charAt(index - 3)) {
            return true;
        }

        if (index >= 5 && stringBuilder.charAt(index) == stringBuilder.charAt(index - 5)
                && stringBuilder.charAt(index - 1) == stringBuilder.charAt(index - 4)
                && stringBuilder.charAt(index - 2) == stringBuilder.charAt(index - 3)) {
            return true;
        }

        return false;
    }
}
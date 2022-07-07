package Problems;

import java.util.Scanner;

/**
 * You are given a string S which denotes a padlock consisting of lower case
 * English letters. You are also given a string F consisting of set of favorite
 * lower case English letters. You are allowed to perform several operations on
 * the padlock. In each operation, you can change one letter of the string to
 * the one following it or preceding it in the alphabetical order. For example:
 * for the letter c, you are allowed to change it to either b or d in an
 * operation. The letters can be considered in a cyclic order, i.e., the
 * preceding letter for letter a would be letter z. Similarly, the following
 * letter for letter z would be letter a. Your aim is to find the minimum number
 * of operations that are required such that each letter in string S after
 * applying the operations, is present in string F.
 */
public class TransformTheString {

    static public int minimumAbsoluteDistance(char a, char b) {
        int absDistance = Math.abs(a - b);
        return absDistance <= 13 ? absDistance : 26 - absDistance;
    }

    static public void transformTheString() {
        Scanner input = new Scanner(System.in);
        int T = Integer.parseInt(input.nextLine());
        String S, F;
        int operationsRequired, minDiff, currentDiff;

        for (int i = 1; i <= T; i++) {
            S = input.nextLine();
            F = input.nextLine();

            if (S.length() == 0 && F.length() == 0)
                System.out.println("Case #" + i + ": " + 0);

            operationsRequired = 0;

            for (int j = 0; j < S.length(); j++) {
                minDiff = minimumAbsoluteDistance(S.charAt(j), F.charAt(0));
                for (int k = 1; k < F.length(); k++) {
                    currentDiff = minimumAbsoluteDistance(S.charAt(j), F.charAt(k));
                    if (currentDiff < minDiff) {
                        minDiff = currentDiff;
                    }
                }
                operationsRequired += minDiff;
            }

            System.out.println("Case #" + i + ": " + operationsRequired);
        }

        input.close();
    }

    public static void main(String[] args) {
        transformTheString();
    }
}

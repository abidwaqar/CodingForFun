package Helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Driver code
 */
class Rough {
    public static void main(String[] args) {
        try {
            // System.out.println(new Rough().shiftingLetters("abc", new int[][] { { 0, 1, 0
            // }, { 1, 2, 1 }, { 0, 2, 1 } }));

            Print.printArray(new Rough().movesToStamp("mda", "mdadddaaaa"));

            String a = "abid";
            char[] b = a.toCharArray();
            b[0] = 'b';
            System.out.println(a);
            Print.printArray(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] movesToStamp(String stamp, String targetStr) {
        char[] targetCharArr = targetStr.toCharArray();
        ArrayList<Integer> stampIndexesArrList = new ArrayList<>();

        int asterisksCount = 0, upperLimit = targetStr.length() - stamp.length();
        while (asterisksCount < targetStr.length()) {

            boolean didReplace = false;
            for (int i = 0; i <= upperLimit; ++i) {
                if (canReplace(stamp, targetCharArr, i)) {
                    asterisksCount += doReplace(stamp.length(), targetCharArr, i);
                    didReplace = true;
                    stampIndexesArrList.add(i);

                    if (asterisksCount == targetStr.length()) {
                        break;
                    }
                }
            }

            if (!didReplace) {
                return new int[0];
            }
        }

        int[] stampIndexesArr = new int[stampIndexesArrList.size()];
        for (int i = 0; i < stampIndexesArrList.size(); ++i) {
            stampIndexesArr[i] = stampIndexesArrList.get(stampIndexesArrList.size() - 1 - i);
        }

        return stampIndexesArr;
    }

    private boolean canReplace(String stamp, char[] targetCharArr, int index) {
        for (int i = 0; i < stamp.length(); ++i) {
            if (targetCharArr[i + index] != stamp.charAt(i) && targetCharArr[i + index] != '*') {
                return false;
            }
        }

        return true;
    }

    private int doReplace(int stampLength, char[] targetCharArr, int index) {
        int charsReplaced = 0;
        for (int i = index; i < stampLength + index; ++i) {
            if (targetCharArr[i] != '*') {
                targetCharArr[i] = '*';
                ++charsReplaced;
            }
        }

        return charsReplaced;
    }
}
import java.util.ArrayList;
import java.util.List;

/**
 * There is a long table with a line of plates and candles arranged on top of
 * it. You are given a 0-indexed string s consisting of characters '*' and '|'
 * only, where a '*' represents a plate and a '|' represents a candle.
 * You are also given a 0-indexed 2D integer array queries where queries[i] =
 * [lefti, righti] denotes the substring s[lefti...righti] (inclusive). For each
 * query, you need to find the number of plates between candles that are in the
 * substring. A plate is considered between candles if there is at least one
 * candle to its left and at least one candle to its right in the substring.
 * For example, s = "||**||**|*", and a query [3, 8] denotes the substring
 * "*||**|". The number of plates between candles in this substring is 2, as
 * each of the two plates has at least one candle in the substring to its left
 * and right.
 * Return an integer array answer where answer[i] is the answer to the ith
 * query.
 */
public class PlatesBetweenCandles {

    // T = O(s + n) | S = O(s + n)
    // where s is the size of the string and n is the sizeof the array.
    public static int[] prefixSumSolution(String s, int[][] queries) {
        int firstPipeIndex = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '|') {
                firstPipeIndex = i;
                break;
            }
        }

        int[] leftPlates = new int[s.length()];

        int platesCount = 0;
        for (int i = firstPipeIndex + 1; i < s.length(); ++i) {
            if (s.charAt(i) == '*') {
                ++platesCount;
            } else {
                leftPlates[i] = platesCount;
                for (int j = i - 1; s.charAt(j) != '|'; --j) {
                    leftPlates[j] = platesCount;
                }
            }
        }

        for (int j = s.length() - 1; j >= 0 && s.charAt(j) != '|'; --j) {
            leftPlates[j] = platesCount;
        }

        int[] rightPlates = new int[s.length()];

        platesCount = 0;
        int currentPlatesCount = 0;
        for (int i = firstPipeIndex + 1; i < s.length(); ++i) {
            if (s.charAt(i) == '*') {
                ++currentPlatesCount;
            } else {
                platesCount += currentPlatesCount;
                currentPlatesCount = 0;
            }

            rightPlates[i] = platesCount;
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            result[i] = Math.max(0, rightPlates[queries[i][1]] - leftPlates[queries[i][0]]);
        }

        return result;
    }

    // T = O(s + nlog(s)) | S = O(s + n)
    // where s is the size of the string and n is the sizeof the array.
    // Uses binary search.
    public static int[] binarySearchSolution(String s, int[][] queries) {
        List<Integer> pipeLocations = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '|') {
                pipeLocations.add(i);
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int left = binarySearch(pipeLocations, queries[i][0]);
            int right = binarySearch(pipeLocations, queries[i][1]);
            if (right >= pipeLocations.size() || pipeLocations.get(right) > queries[i][1]) {
                --right;
            }

            if (left > right) {
                result[i] = 0;
            } else {
                result[i] = (pipeLocations.get(right) - pipeLocations.get(left) + 1) - (right - left + 1);
            }
        }

        return result;
    }

    private static int binarySearch(List<Integer> array, int target) {
        int left = 0, right = array.size();
        while (left < right) {
            int middle = (left + right) / 2;
            if (array.get(middle) >= target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    // T = O(s*n) | S = O(n)
    // where s is the size of the string and n is the sizeof the array.
    public static int[] naiveSolution(String s, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int[] query = queries[i];

            int left = query[0];
            while (s.charAt(left) == '*' && left < s.length()) {
                ++left;
            }

            int right = query[1];
            while (s.charAt(right) == '*' && right >= 0) {
                --right;
            }

            int count = 0;
            while (left <= right) {
                if (s.charAt(left) == '*') {
                    ++count;
                }
                ++left;
            }

            result[i] = count;
        }

        return result;
    }
}
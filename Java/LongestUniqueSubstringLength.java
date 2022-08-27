import java.util.HashMap;

/**
 * Given a string str, find the length of the longest substring without
 * repeating characters.
 */
public class LongestUniqueSubstringLength {

    // T = O(n) | S = O(1) because there can be only 256 characters (constant)
    // Where n is the length of the input string.
    public static int solve(String str) throws Exception {
        HashMap<Character, Integer> lastCharIndex = new HashMap<>();

        int i = 0, j = 0, maxLength = 0;
        while (j < str.length()) {
            Character key = str.charAt(j);
            if (!lastCharIndex.containsKey(key)) {
                lastCharIndex.put(key, j);
            } else {
                i = Math.max(i, lastCharIndex.get(key) + 1);
                lastCharIndex.put(key, j);
            }

            maxLength = Math.max(maxLength, j - i + 1);
            ++j;
        }

        return maxLength;
    }
}
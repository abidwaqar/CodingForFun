import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Smallest Substring of All Characters
 * Given an array of unique characters arr and a string str, Implement a
 * function getShortestUniqueSubstring that finds the smallest substring of str
 * containing all the characters in arr. Return "" (empty string) if such a
 * substring doesn’t exist.
 * 
 * Come up with an asymptotically optimal solution and analyze the time and
 * space complexities.
 * 
 * Example:
 * 
 * input: arr = ['x','y','z'], str = "xyyzyzyx"
 * 
 * output: "zyx"
 * Constraints:
 * 
 * [time limit] 5000ms
 * 
 * [input] array.character arr
 * 
 * 1 ≤ arr.length ≤ 30
 * [input] string str
 * 
 * 1 ≤ str.length ≤ 500
 * [output] string
 */
public class SmallestSubstringOfCharacters {

    // T = O(n + m) | S = O(n + m)
    // Where n is the length of str and m is length of arr.
    static String getShortestUniqueSubstring(char[] arr, String str) {
        Set<Character> uniqueCharacters = new HashSet<>();
        for (char character : arr) {
            uniqueCharacters.add(character);
        }

        HashMap<Character, Integer> characterFrequencies = new HashMap<>();
        int left = 0, right = 0, startIndex = -1, endIndex = -1;
        while (right != str.length() || characterFrequencies.size() == uniqueCharacters.size()) {
            if (characterFrequencies.size() != uniqueCharacters.size()) {
                char currentCharacter = str.charAt(right);
                if (uniqueCharacters.contains(currentCharacter)) {
                    characterFrequencies.put(currentCharacter,
                            characterFrequencies.getOrDefault(currentCharacter, 0) + 1);
                }

                ++right;
            } else {
                if (startIndex == -1 || (right - left < endIndex - startIndex)) {
                    startIndex = left;
                    endIndex = right;
                }

                char currentCharacter = str.charAt(left);
                if (uniqueCharacters.contains(currentCharacter)) {
                    int newCharacterFrequency = characterFrequencies.get(currentCharacter) - 1;
                    if (newCharacterFrequency == 0) {
                        characterFrequencies.remove(currentCharacter);
                    } else {
                        characterFrequencies.put(currentCharacter, newCharacterFrequency);
                    }
                }

                ++left;
            }
        }

        return startIndex == -1 ? "" : str.substring(startIndex, endIndex);
    }
}

package Problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 * 
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * 
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 */
public class WordBreak {

    // T = O(n*m + s^2) | S = O(n*m + s)
    // Where n is input array's length, m is the length of the longest string in
    // that array and s is the length of the given string.
    private static char endingChar = '*';

    private static class TrieNode {
        public Map<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
        }

        public void add(String s) {
            TrieNode currentNode = this;
            for (Character character : s.toCharArray()) {
                if (!currentNode.children.containsKey(character)) {
                    currentNode.children.put(character, new TrieNode());
                }

                currentNode = currentNode.children.get(character);
            }

            if (!currentNode.children.containsKey(endingChar)) {
                currentNode.children.put(endingChar, new TrieNode());
            }
        }
    }

    public static boolean solve(String s, List<String> wordDict) {
        TrieNode rootTrieNode = new TrieNode();
        for (String word : wordDict) {
            rootTrieNode.add(word);
        }

        return wordBreakHelper(s, 0, rootTrieNode, new Boolean[s.length() + 1]);
    }

    private static boolean wordBreakHelper(String s, int index, TrieNode rootTrieNode, Boolean[] cache) {
        if (cache[index] == null) {
            TrieNode currentTrieNode = rootTrieNode;
            cache[index] = false;
            int currentIndex = index;
            while (currentIndex < s.length()) {
                if (currentTrieNode.children.containsKey(endingChar)
                        && wordBreakHelper(s, currentIndex, rootTrieNode, cache)) {
                    return true;
                }

                if (currentTrieNode.children.containsKey(s.charAt(currentIndex))) {
                    currentTrieNode = currentTrieNode.children.get(s.charAt(currentIndex));
                    ++currentIndex;
                } else {
                    cache[index] = false;
                    break;
                }
            }

            if (currentIndex == s.length() && currentTrieNode.children.containsKey(endingChar)) {
                cache[index] = true;
            }
        }

        return cache[index];
    }
}

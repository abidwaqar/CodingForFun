package Problems;

import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        try {
            System.out.println(findWord(new String[] { "P>E", "E>R", "R>U" }));
            System.out.println(findWord(new String[] { "I>N", "A>I", "P>A", "S>P" }));
            System.out.println(findWord(new String[] { "U>N", "G>A", "R>Y", "H>U", "N>G", "A>R" }));
            System.out.println(findWord(new String[] { "I>F", "W>I", "S>W", "F>T" }));
            System.out.println(findWord(new String[] { "R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G" }));
            System.out.println(findWord(new String[] { "U>N", "G>A", "R>Y", "H>U", "N>G", "A>R" }));
            System.out.println(findWord(new String[] { "I>F", "W>I", "S>W", "F>T" }));
            System.out.println(findWord(new String[] { "R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G" }));
            System.out.println(
                    findWord(new String[] { "W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T" }));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // time O(3 * n) = O(n) | space O(2 * n) = O(n) - where n in the length of the
    // input string
    public static String findWord(String[] rules) throws Exception {
        if (rules.length == 0) {
            return "";
        }

        HashMap<Character, Character> forward = new HashMap<>();
        HashMap<Character, Character> backward = new HashMap<>();

        for (String rule : rules) {
            if (rule.charAt(1) == '>') {
                forward.put(rule.charAt(0), rule.charAt(2));
                backward.put(rule.charAt(2), rule.charAt(0));
            } else if (rule.charAt(1) == '<') {
                forward.put(rule.charAt(2), rule.charAt(0));
                backward.put(rule.charAt(0), rule.charAt(2));
            } else {
                throw new Exception(rule.charAt(1) + " rule not supported.");
            }
        }

        char firstCharacter = rules[0].charAt(0);
        while (backward.containsKey(firstCharacter)) {
            firstCharacter = backward.get(firstCharacter);
        }

        char currentCharacter = firstCharacter;
        StringBuilder word = new StringBuilder();
        word.append(currentCharacter);
        while (forward.containsKey(currentCharacter)) {
            currentCharacter = forward.get(currentCharacter);
            word.append(currentCharacter);
        }

        return word.toString();
    }
}
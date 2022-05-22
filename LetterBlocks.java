import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class LetterBlocks {

    private static String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                int N = sc.nextInt();
                String[] input = new String[N];
                for (int j = 0; j < N; j++) {
                    input[j] = sc.next();
                }

                System.out.println("Case #" + i + ": " + solve(input));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String solve(String[] input) throws Exception {
        HashMap<Character, String> hashMap = new HashMap<>();

        for (String currStr : input) {
            Character firstChar = currStr.charAt(0);
            if (hashMap.containsKey(firstChar)) {
                String existingStr = hashMap.get(firstChar);

                if (existingStr.charAt(existingStr.length() - 1) == firstChar) {
                    hashMap.put(firstChar, existingStr + currStr);
                } else if (currStr.charAt(currStr.length() - 1) == existingStr.charAt(0)) {
                    hashMap.put(firstChar, currStr + existingStr);
                } else {
                    return IMPOSSIBLE;
                }
            } else {
                hashMap.put(firstChar, currStr);
            }
        }

        List<Character> keys = new ArrayList<Character>(hashMap.keySet());
        for (Character key : keys) {
            if (hashMap.containsKey(key)) {
                String currStr = hashMap.get(key);
                Character lastCharacter = currStr.charAt(currStr.length() - 1);
                while (lastCharacter != key && hashMap.containsKey(lastCharacter)) {
                    currStr += hashMap.remove(lastCharacter);
                    hashMap.put(key, currStr);
                    lastCharacter = currStr.charAt(currStr.length() - 1);
                }
            }
        }

        String result = String.join("", hashMap.values());

        return isValid(result) ? result : IMPOSSIBLE;
    }

    private static boolean isValid(String str) throws Exception {
        char prevChar = str.charAt(0);
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add(prevChar);
        for (int i = 1; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (prevChar != currChar) {
                if (hashSet.contains(currChar)) {
                    return false;
                } else {
                    hashSet.add(currChar);
                    prevChar = currChar;
                }
            }
        }

        return true;
    }
}
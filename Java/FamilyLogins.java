import java.util.HashMap;

/**
 * Given an array of strings, logins, where all strings have equal lengths. A
 * string can be transformed one time by rotating its characters right by one
 * step. In order words, change character 'a' to 'b', 'b' to 'c' and 'z' to 'a'.
 * Two strings are called family logins if one of them can be transformed into
 * another. An as exmaple strings "bcd" and "abc" are family logins because each
 * character in "bcd" is one above the characters in "abc".
 * 
 * Find the number of pairs of string which are family logins.
 * 
 * Example
 * logins = ["bag", "sfe", "cbh", "cbh", "red"]
 * return 3, the number of pairs.
 */
public class FamilyLogins {

    public static void main(String[] args) {
        try {
            System.out.println(solve(new String[] { "corn", "horn", "dpso", "eqtp", "corn" }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // T = O(n) | S = O(n)
    // Where n is input array's length.
    public static int solve(String[] logins) {
        HashMap<String, Integer> transformedLoginsFrequencies = new HashMap<>();
        for (String login : logins) {
            String transformedLogin = transform(login);
            transformedLoginsFrequencies.put(transformedLogin,
                    transformedLoginsFrequencies.getOrDefault(transformedLogin, 0) + 1);
        }

        int pairs = 0;
        for (String login : logins) {
            pairs += transformedLoginsFrequencies.getOrDefault(login, 0);
        }

        return pairs;
    }

    private static String transform(String login) {
        StringBuilder transformedLoginBuilder = new StringBuilder();
        for (int i = 0; i < login.length(); ++i) {
            char character = login.charAt(i);
            transformedLoginBuilder.append(character == 'z' ? 'a' : (char) (character + 1));
        }

        return transformedLoginBuilder.toString();
    }
}

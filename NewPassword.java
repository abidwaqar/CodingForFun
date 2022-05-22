import java.util.Scanner;

public class NewPassword {
    private static String SpecialCharacters = "#@*&";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                // skipping length
                sc.nextInt();
                StringBuilder input = new StringBuilder(sc.next());

                System.out.println("Case #" + i + ": " + solve(input));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String solve(StringBuilder input) throws Exception {
        boolean upperCasecheck = false;
        boolean lowerCaseCheck = false;
        boolean digitCheck = false;
        boolean specialCharacterCheck = false;

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (Character.isUpperCase(character)) {
                upperCasecheck = true;
            }

            if (Character.isLowerCase(character)) {
                lowerCaseCheck = true;
            }

            if (Character.isDigit(character)) {
                digitCheck = true;
            }

            if (SpecialCharacters.contains(input.substring(i, i + 1))) {
                specialCharacterCheck = true;
            }
        }

        if (upperCasecheck == false) {
            input.append('A');
        }

        if (lowerCaseCheck == false) {
            input.append('a');
        }

        if (digitCheck == false) {
            input.append('0');
        }

        if (specialCharacterCheck == false) {
            input.append('#');
        }

        while (input.length() < 7) {
            input.append('1');
        }

        return input.toString();
    }
}
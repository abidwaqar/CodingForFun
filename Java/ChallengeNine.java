import java.util.Scanner;

public class ChallengeNine {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                String N = sc.next();

                System.out.println("Case #" + i + ": " + solve(N));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String solve(String N) throws Exception {
        if (N.equals("0")) {
            return "90";
        }

        int numberToInsert = calculateNumberToInsert(N);

        for (int i = numberToInsert == 0 ? 1 : 0; i < N.length(); i++) {
            if (Character.getNumericValue(N.charAt(i)) > numberToInsert) {
                return N.substring(0, i) + numberToInsert + N.substring(i, N.length());
            }
        }

        return N + numberToInsert;
    }

    public static int calculateNumberToInsert(String N) {
        int numberToInsert = 0;
        for (int i = 0; i < N.length(); ++i) {
            numberToInsert += Character.getNumericValue(N.charAt(i));
        }
        return (9 - (numberToInsert % 9)) % 9;
    }
}
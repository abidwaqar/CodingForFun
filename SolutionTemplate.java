import java.util.Scanner;

public class SolutionTemplate {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                long A = sc.nextLong();
                long B = sc.nextLong();

                System.out.println("Case #" + i + ": " + solve(A, B));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static long solve(long A, long B) throws Exception {
        return A + B;
    }
}
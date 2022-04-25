import java.util.Scanner;

public class InfinityArea {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                int R = sc.nextInt();
                int A = sc.nextInt();
                int B = sc.nextInt();

                System.out.println("Case #" + i + ": " + solve(R, A, B));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static double solve(int R, int A, int B) throws Exception {
        long radius = R;
        long result = radius * radius;
        boolean toggle = true;
        while (radius != 0) {
            if (toggle) {
                radius = radius * A;
            } else {
                radius = radius / B;
            }

            result += radius * radius;
            toggle = !toggle;
        }

        return Math.PI * result;

    }
}
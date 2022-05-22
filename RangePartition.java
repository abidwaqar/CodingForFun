import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RangePartition {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                int N = sc.nextInt();
                int X = sc.nextInt();
                int Y = sc.nextInt();

                solve(i, N, X, Y);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String POSSIBLE = "POSSIBLE";
    private static String IMPOSSIBLE = "IMPOSSIBLE";

    private static void solve(int testNumber, int N, int X, int Y) throws Exception {
        long NSummation = (N * (N + 1)) / 2;
        int XYSum = X + Y;

        int factor = 1;
        for (; (long) XYSum * factor < NSummation; ++factor)
            ;

        if (XYSum * factor > NSummation) {
            System.out.println("Case #" + testNumber + ": " + IMPOSSIBLE);
            return;
        }

        int XFactored = X * factor;
        List<Integer> alanSubset = new ArrayList<>();
        for (int i = N; XFactored != 0; --i) {
            if (i <= XFactored) {
                XFactored -= i;
                alanSubset.add(i);
            }
        }

        System.out.println("Case #" + testNumber + ": " + POSSIBLE);
        System.out.println(alanSubset.size());
        for (Integer num : alanSubset) {
            System.out.print("" + num + " ");
        }
        System.out.println();
    }
}
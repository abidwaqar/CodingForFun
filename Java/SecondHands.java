
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://www.facebook.com/codingcompetitions/hacker-cup/2022/qualification-round/problems/A
 */
public class SecondHands {
    public static void main(String[] args) {
        String filePath = ".\\Java\\Helper\\";
        try (Scanner sc = new Scanner(new File(filePath + "input.txt"));
                PrintWriter writer = new PrintWriter(filePath + "output.txt")) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                int N = sc.nextInt();
                int K = sc.nextInt();

                int[] clockPartsStyles = new int[N];
                for (int j = 0; j < N; ++j) {
                    clockPartsStyles[j] = sc.nextInt();
                }

                writer.println("Case #" + i + ": " + (solve(clockPartsStyles, K) ? "YES" : "NO"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // T = O(n) | S = O(1)
    // Where n is input array's length.
    private static boolean solve(int[] clockPartsStyles, int K) throws Exception {
        if (K < (clockPartsStyles.length / 2.0)) {
            return false;
        }

        int[] frequencies = new int[101];
        for (int style : clockPartsStyles) {
            ++frequencies[style];
            if (frequencies[style] == 3) {
                return false;
            }
        }

        return true;
    }
}
package Helper;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Competitive programming template instance
 */
public class CPFileTemplate {
    public static void main(String[] args) {
        String filePath = ".\\Java\\Helper\\";
        try (Scanner sc = new Scanner(new File(filePath + "input.txt"));
                PrintWriter writer = new PrintWriter(filePath + "output.txt")) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                long A = sc.nextLong();
                long B = sc.nextLong();

                writer.println("Case #" + i + ": " + solve(A, B));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static long solve(long A, long B) throws Exception {
        return A + B;
    }
}
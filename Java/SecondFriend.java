
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://www.facebook.com/codingcompetitions/hacker-cup/2022/qualification-round/problems/B1
 */
public class SecondFriend {
    public static void main(String[] args) {
        String filePath = ".\\Java\\Helper\\";
        try (Scanner sc = new Scanner(new File(filePath + "input.txt"));
                PrintWriter writer = new PrintWriter(filePath + "output.txt")) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                int R = sc.nextInt();
                int C = sc.nextInt();

                char[][] scene = new char[R][C];
                for (int j = 0; j < R; ++j) {
                    String row = sc.next();
                    for (int k = 0; k < C; k++) {
                        scene[j][k] = row.charAt(k);
                    }
                }

                boolean possible = solve(scene);

                if (!possible) {
                    writer.println("Case #" + i + ": Impossible");
                    continue;
                }

                writer.println("Case #" + i + ": Possible");
                for (int j = 0; j < R; ++j) {
                    for (int k = 0; k < C; k++) {
                        writer.print(scene[j][k]);
                    }

                    writer.println();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // T = O(h * w) | S = O(1)
    // Where h and w are height and width of the input grid.
    private static boolean solve(char[][] scene) throws Exception {
        for (int i = 0; i < scene.length; ++i) {
            for (int j = 0; j < scene[i].length; j++) {
                if (scene[i][j] == '^') {
                    int friends = 0;
                    if (j + 1 < scene[i].length && scene[i][j + 1] == '^') {
                        ++friends;
                    }

                    if (i + 1 < scene.length && scene[i + 1][j] == '^') {
                        ++friends;
                    }

                    if (j - 1 >= 0 && scene[i][j - 1] == '^') {
                        ++friends;
                    }

                    if (i - 1 >= 0 && scene[i - 1][j] == '^') {
                        ++friends;
                    }

                    if (friends >= 2) {
                        continue;
                    }

                    if (scene.length == 1 || scene[i].length == 1) {
                        return false;
                    }

                    int rowIdx = i, colIdx = j;
                    if (rowIdx + 1 == scene.length) {
                        --rowIdx;
                    }

                    if (colIdx + 1 == scene[i].length) {
                        --colIdx;
                    }

                    scene[rowIdx][colIdx] = '^';
                    scene[rowIdx][colIdx + 1] = '^';
                    scene[rowIdx + 1][colIdx] = '^';
                    scene[rowIdx + 1][colIdx + 1] = '^';
                }
            }
        }

        return true;
    }
}
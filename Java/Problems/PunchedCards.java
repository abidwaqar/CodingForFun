package Problems;

import java.util.Scanner;

public class PunchedCards {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                int R = sc.nextInt();
                int C = sc.nextInt();

                System.out.println("Case #" + i + ":");
                System.out.println(solve(R, C));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String solve(int R, int C) throws Exception {
        StringBuilder border = new StringBuilder();
        StringBuilder cell = new StringBuilder();

        for (int i = 0; i < C; i++) {
            border.append("+-");
            cell.append("|.");
        }
        border.append("+\n");
        cell.append("|\n");

        StringBuilder punchedCard = new StringBuilder();
        for (int i = 0; i < R; i++) {
            if (i == 0) {
                border.replace(0, 2, "..");
                cell.replace(0, 2, "..");

                punchedCard.append(border.toString());
                punchedCard.append(cell.toString());

                border.replace(0, 2, "+-");
                cell.replace(0, 2, "|.");
            } else {
                punchedCard.append(border.toString());
                punchedCard.append(cell.toString());
            }
        }

        punchedCard.append(border.toString());

        return punchedCard.toString();
    }
}
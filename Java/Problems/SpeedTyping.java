package Problems;

import java.util.Scanner;

public class SpeedTyping {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                String I = sc.next();
                String P = sc.next();

                System.out.println("Case #" + i + ": " + solve(I, P));
            }
        }
    }

    public static String IMPOSSIBLE = "IMPOSSIBLE";

    public static String solve(String I, String P) {
        int iLength = I.length(), pLength = P.length();
        if (iLength <= pLength) {
            int iCounter = 0, pCounter = 0;
            while (iCounter != iLength && iLength - iCounter <= pLength - pCounter) {
                if (I.charAt(iCounter) == P.charAt(pCounter)) {
                    ++iCounter;
                }
                ++pCounter;
            }

            if (iCounter == iLength) {
                return Integer.toString(pLength - iLength);
            }
        }

        return IMPOSSIBLE;
    }
}
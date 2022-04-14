import java.util.Scanner;

public class ThreeDPrinting {

    private static class Cartridge {
        public int cyan;
        public int magenta;
        public int yellow;
        public int black;
    }

    private static String IMPOSSIBLE = "IMPOSSIBLE";
    private static int targetValue = 1000000;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                Cartridge[] cartridges = new Cartridge[3];
                for (int j = 0; j < cartridges.length; j++) {
                    cartridges[j] = new Cartridge();

                    cartridges[j].cyan = sc.nextInt();
                    cartridges[j].magenta = sc.nextInt();
                    cartridges[j].yellow = sc.nextInt();
                    cartridges[j].black = sc.nextInt();
                }

                System.out.println("Case #" + i + ": " + solve(cartridges));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String solve(Cartridge[] cartridges) throws Exception {
        int minCyan = Integer.MAX_VALUE;
        int minMagenta = Integer.MAX_VALUE;
        int minYellow = Integer.MAX_VALUE;
        int minBlack = Integer.MAX_VALUE;
        for (Cartridge cartridge : cartridges) {
            minCyan = cartridge.cyan < minCyan ? cartridge.cyan : minCyan;
            minMagenta = cartridge.magenta < minMagenta ? cartridge.magenta : minMagenta;
            minYellow = cartridge.yellow < minYellow ? cartridge.yellow : minYellow;
            minBlack = cartridge.black < minBlack ? cartridge.black : minBlack;
        }

        int colorsSum = minCyan + minMagenta + minYellow + minBlack;

        if (colorsSum < targetValue) {
            return IMPOSSIBLE;
        }

        if (colorsSum > targetValue) {
            int amountToSubtract = colorsSum - targetValue;

            if (minCyan >= amountToSubtract) {
                minCyan = minCyan - amountToSubtract;
                amountToSubtract = 0;
            } else {
                amountToSubtract = amountToSubtract - minCyan;
                minCyan = 0;
            }

            if (minMagenta >= amountToSubtract) {
                minMagenta = minMagenta - amountToSubtract;
                amountToSubtract = 0;
            } else {
                amountToSubtract = amountToSubtract - minMagenta;
                minMagenta = 0;
            }

            if (minYellow >= amountToSubtract) {
                minYellow = minYellow - amountToSubtract;
                amountToSubtract = 0;
            } else {
                amountToSubtract = amountToSubtract - minYellow;
                minYellow = 0;
            }

            if (minBlack >= amountToSubtract) {
                minBlack = minBlack - amountToSubtract;
                amountToSubtract = 0;
            } else {
                amountToSubtract = amountToSubtract - minBlack;
                minBlack = 0;
            }
        }

        return "" + minCyan + " " + minMagenta + " " + minYellow + " " + minBlack;
    }
}
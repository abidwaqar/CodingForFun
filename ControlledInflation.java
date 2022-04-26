import java.util.Scanner;

public class ControlledInflation {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                int N = sc.nextInt();
                int P = sc.nextInt();

                int[][] input = new int[N][2];
                for (int j = 0; j < N; ++j) {
                    input[j][0] = Integer.MAX_VALUE;
                    input[j][1] = Integer.MIN_VALUE;
                    for (int k = 0; k < P; ++k) {
                        int currentNumber = sc.nextInt();
                        if (currentNumber < input[j][0]) {
                            input[j][0] = currentNumber;
                        }
                        if (currentNumber > input[j][1]) {
                            input[j][1] = currentNumber;
                        }
                    }
                }

                System.out.println("Case #" + i + ": " + solve(input));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static long solve(int[][] customerProductArr) throws Exception {
        long[][] cache = new long[customerProductArr.length][2];
        for (int i = 0; i < customerProductArr.length; ++i) {
            for (int j = 0; j < 2; j++) {
                cache[i][j] = -1;
            }
        }

        return customerProductArr[0][1]
                + solveRecursive(customerProductArr, 1, false, cache);
    }

    private static long solveRecursive(int[][] customerProductArr,
            int currentIndex, boolean left, long[][] cache) throws Exception {

        if (currentIndex == customerProductArr.length) {
            return 0;
        }

        int leftBit = left ? 0 : 1;
        if (cache[currentIndex][leftBit] != -1) {
            return cache[currentIndex][leftBit];
        }

        int currentPressure = customerProductArr[currentIndex - 1][leftBit];

        if (currentPressure <= customerProductArr[currentIndex][0]
                && currentPressure <= customerProductArr[currentIndex][1]) {
            cache[currentIndex][leftBit] = customerProductArr[currentIndex][1] - currentPressure
                    + solveRecursive(customerProductArr, currentIndex + 1, false, cache);
        } else if (currentPressure >= customerProductArr[currentIndex][0]
                && currentPressure >= customerProductArr[currentIndex][1]) {
            cache[currentIndex][leftBit] = currentPressure - customerProductArr[currentIndex][0]
                    + solveRecursive(customerProductArr, currentIndex + 1, true, cache);
        } else {
            long tempButtonPresses = 0;
            int tempCurrentPressure = currentPressure;

            // 0 - 1
            tempButtonPresses += Math.abs(tempCurrentPressure - customerProductArr[currentIndex][0]);
            tempButtonPresses += Math.abs(customerProductArr[currentIndex][0] - customerProductArr[currentIndex][1]);

            long minToMaxButtonPresses = tempButtonPresses
                    + solveRecursive(customerProductArr, currentIndex + 1, false, cache);

            tempButtonPresses = 0;
            tempCurrentPressure = currentPressure;

            // 1 - 0
            tempButtonPresses += Math.abs(tempCurrentPressure - customerProductArr[currentIndex][1]);
            tempButtonPresses += Math.abs(customerProductArr[currentIndex][1] - customerProductArr[currentIndex][0]);

            long maxToMinButtonPresses = tempButtonPresses
                    + solveRecursive(customerProductArr, currentIndex + 1, true, cache);

            cache[currentIndex][leftBit] = Math.min(minToMaxButtonPresses, maxToMinButtonPresses);
        }

        return cache[currentIndex][leftBit];
    }
}
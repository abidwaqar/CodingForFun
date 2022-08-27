import java.util.HashMap;
import java.util.Scanner;

public class InterestingIntegers {
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

    private static long solve(Long A, Long B) throws Exception {
        if (A < 0) {
            throw new Exception("Input cannot be negative");
        }

        if (A > B) {
            return 0;
        }

        if (A == 0) {
            return InterestingIntegersCount(Long.toString(B), 0, 1, 0, true, true, new HashMap<>());
        } else {
            return InterestingIntegersCount(Long.toString(B), 0, 1, 0, true, true, new HashMap<>())
                    - InterestingIntegersCount(Long.toString(A - 1), 0, 1, 0, true, true, new HashMap<>());
        }
    }

    private static long InterestingIntegersCount(String number, int index, long product, int sum, boolean tight,
            boolean followedByLeadingZeros, HashMap<String, Long> cache) {
        if (index == number.length()) {
            if (sum == 0 || product % sum != 0) {
                return 0;
            } else {
                return 1;
            }
        }

        String key = "" + index + "|" + product + "|" + sum + "|" + tight;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        long count = 0;
        int currentNumber = number.charAt(index) - '0';
        int loopTill = tight == true ? currentNumber : 9;

        for (int i = 0; i <= loopTill; i++) {
            if (followedByLeadingZeros && i == 0) {
                count += InterestingIntegersCount(number, index + 1, product, sum, tight && i == currentNumber, true,
                        cache);
            } else {
                count += InterestingIntegersCount(number, index + 1, product * i, sum + i, tight && i == currentNumber,
                        false, cache);
            }
        }

        cache.put(key, count);
        return count;
    }
}
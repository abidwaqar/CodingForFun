package Problems;

/**
 * An ugly number is a positive integer that is divisible by a, b, or c.
 * 
 * Given four integers n, a, b, and c, return the nth ugly number.
 */
public class UglyNumber3 {

    // T = O(n) | S = O(1) because there can be only 256 characters (constant)
    // Where n is the length of the input string.
    public static int solve(int n, int a, int b, int c) {
        long ab = lcm(a, b);
        long ac = lcm(a, c);
        long bc = lcm(b, c);
        long abc = lcm(a, bc);

        int left = Math.min(a, Math.min(b, c)), right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = (int) (mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc);
            if (count >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
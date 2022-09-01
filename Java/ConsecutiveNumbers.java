/**
 * Given an unsorted array of distinct numbers, write a function that returns
 * true if array consists of consecutive numbers.
 * 
 * https://www.geeksforgeeks.org/check-array-elements-consecutive-time-o1-space-handles-positive-negative-numbers/
 */
public class ConsecutiveNumbers {

    public static void main(String[] args) {
        try {
            System.out.println(solve(new int[] { 2, 1, 0, -3, -1, -2, 3 }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // T = O(n) | S = O(1)
    // Where n is input array's length.
    public static boolean solve(int[] numbers) {
        int minNum = Integer.MAX_VALUE;
        long sum = 0;
        for (int number : numbers) {
            if (number < minNum) {
                minNum = number;
            }

            sum += number;
        }

        return sum == arithmeticProgressionSum(minNum, numbers.length, 1);
    }

    private static long arithmeticProgressionSum(int a, int n, int d) {
        return ((long) n * (2 * a + (n - 1) * d)) / 2;
    }
}

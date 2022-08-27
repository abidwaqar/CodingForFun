/**
 * Given an array of integers nums and an integer threshold, we will choose a
 * positive integer divisor, divide all the array by it, and sum the division's
 * result. Find the smallest divisor such that the result mentioned above is
 * less than or equal to threshold.
 * 
 * Each result of the division is rounded to the nearest integer greater than or
 * equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 * 
 * The test cases are generated so that there will be an answer.
 */
public class SmallestDivisorGivenAThreshold {

    // T = O(n * log(max(nums))) | S = O(1)
    // Where n is the input array size.
    public static int solve(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int left = 1, right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (feasible(nums, threshold, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean feasible(int[] nums, int threshold, int candidateNum) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.ceil((float) num / candidateNum);
        }

        return sum <= threshold;
    }
}
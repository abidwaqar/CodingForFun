package Problems;

import java.util.Arrays;

/**
 * The distance of a pair of integers a and b is defined as the absolute
 * difference between a and b.
 * 
 * Given an integer array nums and an integer k, return the kth smallest
 * distance among all the pairs nums[i] and nums[j] where 0 <= i < j <
 * nums.length.
 */
public class KthSmallestPairDistance {

    // T = O(n * (log(n) + log(max(nums) - min(nums)))) | S = O(log(n))
    // Where n is input array's length.
    public static int solve(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            if (enough(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean enough(int[] nums, int k, int candidateNum) {
        int slow = 0, fast = 1, count = 0;
        while (slow < nums.length) {
            while (fast < nums.length && (nums[fast] - nums[slow]) <= candidateNum) {
                ++fast;
            }

            count += (fast - 1 - slow);
            ++slow;
        }

        return count >= k;
    }
}
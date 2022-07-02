package Problems;

/**
 * Given an array which consists of non-negative integers and an integer m, you
 * can split the array into m non-empty continuous subarrays. Write an algorithm
 * to minimize the largest sum among these m subarrays.
 */
public class SplitArrayLargestSum {

    // T = O(log(sum(nums) - max(nums)) * n) | S = O(1)
    // Where n is the size of the input array.
    public static long solve(int[] nums, int m) throws Exception {
        if (m <= 0) {
            throw new Exception("Atleast 1 subarray is required.");
        }

        long sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        long left = max, right = sum;
        while (left < right) {
            long mid = (left + right) / 2;
            if (feasible(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean feasible(int[] nums, int m, long minPossibleLargestSum) {
        long largestSum = 0;
        int split = 1;
        for (int weight : nums) {
            largestSum += weight;
            if (largestSum > minPossibleLargestSum) {
                largestSum = weight;
                ++split;
                if (split > m) {
                    return false;
                }
            }
        }

        return true;
    }
}

/**
 * Given an array ranks of ranks of students in a school. All students need to
 * be split into groups k. Find the total 'imbalance' of all groups. An
 * imabalance of a group can be found as :
 * 
 * Sorting each group in the order of their ranks.
 * A group contributes to imbalance if any 2 CONSECUTIVE students in the sorted
 * array have a rank difference of more than 1.
 * Find the total sum of imbalance of all such groups.
 * 
 * Note: Consider subarrays only
 * This is the example that was given :
 * [4,1,3,2]
 * [1] imbalance = 0
 * [2] imbalance = 0
 * [3] imbalance = 0
 * [4] imbalance = 0
 * [4,1] => sorted [ 1, 4 ] => 4-1=3>1 => imbalance = 1 i.e 1 and 4 are not
 * consecutive
 * [4,1,3] => sorted [ 1 3 4 ] => 4-3=1, 3-1=2>1 => imbalance = 1 i.e 1, 3 and 4
 * are not consecutive
 * [4,1,3,2] => sorted [ 1 2 3 4 ] => 4-3=1,3-2=1,2-1=1 => imbalance = 0 i.e
 * 1,2,3 and 4 are consecutive
 * [1,3] => sorted [ 1, 3 ] => 3-1=2>1 => imbalance = 1 i.e 1 and 3 are not
 * consecutive
 * [1,3,2] => sorted [ 1, 2, 3 ] => 3-2=1, 2-1=1 => imbalance = 0 i.e 1,2 and 3
 * are consecutive
 * [3,2] => sorted [ 2, 3 ] => 3-2=1 => imbalance = 0 i.e 2 and 3 are
 * consecutive
 * Answer = 1 + 1 + 1 = 3
 * 
 * Example2:
 * Input: nums = [1,2,3]
 * Output:
 * Explanation: The 6 subarrays of nums are the following:
 * [1], imbalance = 0
 * [2], imbalance = 0
 * [3], imbalance = 0
 * [1,2], range = 2 - 1 = 1 => imbalance = 0
 * [2,3], range = 3 - 2 = 1 => imbalance = 0
 * [1,2,3], range = 3 - 2 = 1 and 2-1 = 1 => imbalance =0
 * So the total imbalance is 0 + 0 + 0 + 0 + 0 + 0 = 0.
 */
public class GroupsImbalance {

    public static void main(String[] args) {
        try {
            System.out.println(solve(new int[] { 4, 1, 3, 2 }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // T = O(n ^ 3) | S = O(1)
    // Where n is input array's length.
    public static int solve(int[] ranks) {
        int imbalance = 0;
        for (int i = 2; i <= ranks.length; i++) {
            for (int j = 0; j <= ranks.length - i; j++) {
                if (!isConsecutive(j, j + i, ranks)) {
                    ++imbalance;
                }
            }
        }

        return imbalance;
    }

    /// End will be exclusive
    private static boolean isConsecutive(int start, int end, int[] nums) {
        int minNum = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = start; i < end; ++i) {
            if (nums[i] < minNum) {
                minNum = nums[i];
            }

            sum += nums[i];
        }

        return sum == arithmeticProgressionSum(minNum, end - start, 1);
    }

    private static long arithmeticProgressionSum(int a, int n, int d) {
        return ((long) n * (2 * a + (n - 1) * d)) / 2;
    }
}

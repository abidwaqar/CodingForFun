import java.util.Arrays;

/**
 * There are n points on a road you are driving your taxi on. The n points on
 * the road are labeled from 1 to n in the direction you are going, and you want
 * to drive from point 1 to point n to make money by picking up passengers. You
 * cannot change the direction of the taxi.
 * 
 * The passengers are represented by a 0-indexed 2D integer array rides, where
 * rides[i] = [starti, endi, tipi] denotes the ith passenger requesting a ride
 * from point starti to point endi who is willing to give a tipi dollar tip.
 * 
 * For each passenger i you pick up, you earn endi - starti + tipi dollars. You
 * may only drive at most one passenger at a time.
 * 
 * Given n and rides, return the maximum number of dollars you can earn by
 * picking up the passengers optimally.
 * 
 * Note: You may drop off a passenger and pick up a different passenger at the
 * same point.
 * 
 * Example 1:
 * Input: n = 5, rides = [[2,5,4],[1,5,1]]
 * Output: 7
 * Explanation: We can pick up passenger 0 to earn 5 - 2 + 4 = 7 dollars.
 */
public class MaximumEarningsFromTaxi {

    // T = O(klog(k) + n) | S = O(n + log(k))
    // Where k is the length of input array.
    public static long solve(int n, int[][] rides) {
        Arrays.sort(rides, (x, y) -> Integer.compare(x[1], y[1]));
        long[] dpEarnings = new long[n + 1];

        for (int j = 0, i = 1; i < dpEarnings.length; ++i) {
            dpEarnings[i] = dpEarnings[i - 1];

            while (j < rides.length && i == rides[j][1]) {
                dpEarnings[i] = Math.max(dpEarnings[i],
                        rides[j][1] - rides[j][0] + rides[j][2] + dpEarnings[rides[j][0]]);
                ++j;
            }
        }

        return dpEarnings[n];
    }
}

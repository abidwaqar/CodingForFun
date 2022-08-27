/**
 * You are given an integer array bloomDay, an integer m and an integer k.
 * 
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent
 * flowers from the garden.
 * 
 * The garden consists of n flowers, the ith flower will bloom in the
 * bloomDay[i] and then can be used in exactly one bouquet.
 * 
 * Return the minimum number of days you need to wait to be able to make m
 * bouquets from the garden. If it is impossible to make m bouquets return -1.
 */
public class MinimumNumberOfDaysToMakeMBouquets {

    // T = O(log(max(bloomDays) - min(bloomDays)) * n) | S = O(1)
    // Where n is the size of the input array
    public static int solve(int[] bloomDays, int m, int k) {
        if (bloomDays.length < m * k) {
            return -1;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int bloomDay : bloomDays) {
            min = Math.min(min, bloomDay);
            max = Math.max(max, bloomDay);
        }

        int left = min, right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            if (feasible(bloomDays, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean feasible(int[] bloomDays, int m, int k, int days) {
        int bouquets = 0, flowers = 0;
        for (int bloomDay : bloomDays) {
            if (bloomDay > days) {
                flowers = 0;
            } else {
                ++flowers;
                if (flowers == k) {
                    ++bouquets;
                    flowers = 0;
                }
            }
        }

        return bouquets >= m;
    }
}

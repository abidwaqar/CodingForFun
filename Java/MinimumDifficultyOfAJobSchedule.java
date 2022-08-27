import java.util.Arrays;

/**
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To
 * work on the ith job, you have to finish all the jobs j where 0 <= j < i).
 * 
 * You have to finish at least one task every day. The difficulty of a job
 * schedule is the sum of difficulties of each day of the d days. The difficulty
 * of a day is the maximum difficulty of a job done on that day.
 * 
 * You are given an integer array jobDifficulty and an integer d. The difficulty
 * of the ith job is jobDifficulty[i].
 * 
 * Return the minimum difficulty of a job schedule. If you cannot find a
 * schedule for the jobs return -1.
 * 
 * Example 1:
 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 * Output: 7
 * Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 * Second day you can finish the last job, total difficulty = 1.
 * The difficulty of the schedule = 6 + 1 = 7
 */
public class MinimumDifficultyOfAJobSchedule {

    // T = O(n * n * d) | S = O(n * d)
    // Where n is input array's length and d is days.
    public static int solve(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }

        int[][] cache = new int[jobDifficulty.length][d];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }

        return dfs(0, d, jobDifficulty, cache);
    }

    private static int dfs(int index, int days, int[] jobDifficulty, int[][] cache) {
        final int N = jobDifficulty.length;

        if (days == 0 && index == N) {
            return 0;
        }

        if (days == 0 || index == N) {
            return Integer.MAX_VALUE;
        }

        if (cache[index][days - 1] != -1) {
            return cache[index][days - 1];
        }

        int currMax = jobDifficulty[index];
        int min = Integer.MAX_VALUE;
        for (int i = index; i < N; ++i) {
            currMax = Math.max(currMax, jobDifficulty[i]);
            int restMin = dfs(i + 1, days - 1, jobDifficulty, cache);
            if (restMin != Integer.MAX_VALUE) {
                min = Math.min(min, currMax + restMin);
            }
        }

        return cache[index][days - 1] = min;
    }
}
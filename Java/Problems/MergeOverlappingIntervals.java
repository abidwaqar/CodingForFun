package Problems;

import java.util.*;

class MergeOverlappingIntervals {

    static public int[][] mergeOverlappingIntervals(int[][] intervals) {
        if (intervals.length <= 1)
            return new int[][] {};

        int[][] sortedIntervals = intervals.clone();
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] prev = new int[] { sortedIntervals[0][0], sortedIntervals[0][1] };
        for (int i = 1; i < sortedIntervals.length; ++i) {
            if (prev[1] >= sortedIntervals[i][0]) {
                prev = new int[] { prev[0], Math.max(prev[1], sortedIntervals[i][1]) };
            } else {
                mergedIntervals.add(prev);
                prev = new int[] { sortedIntervals[i][0], sortedIntervals[i][1] };
            }
        }

        mergedIntervals.add(prev);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}

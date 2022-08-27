import java.util.Arrays;

/**
 * Given an array representing n positions along a straight line. Find k (where
 * k <= n) elements from the array such that the minimum distance between any
 * two (consecutive points among the k points) is maximized.
 * 
 * Examples :
 * 
 * Input : arr[] = {1, 2, 8, 4, 9}
 * k = 3
 * Output : 3
 * Largest minimum distance = 3
 * 3 elements arranged at positions 1, 4 and 8,
 * Resulting in a minimum distance of 3
 * 
 * Input : arr[] = {1, 2, 7, 5, 11, 12}
 * k = 3
 * Output : 5
 * Largest minimum distance = 5
 * 3 elements arranged at positions 1, 7 and 12,
 * resulting in a minimum distance of 5 (between
 * 7 and 12)
 */
public class OptimalPointsSelection {

    // T = O(n * log(n)) | S = O(1)
    // Where n is input array's length.
    public static int solve(int[] points, int k) {
        Arrays.sort(points);

        int left = points[1] - points[0], right = points[points.length - 1] - points[0];
        while (left < right) {
            int mid = (left + right) / 2;
            if (!feasible(mid, k, points)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    private static boolean feasible(int distance, int k, int[] points) {
        int lastPoint = points[0];
        for (int i = 1; i < points.length && k > 1; i++) {
            if (points[i] - lastPoint >= distance) {
                lastPoint = points[i];
                --k;
            }
        }

        return k == 1;
    }
}

package Problems;

/**
 * You are given 2 numbers (n , m); the task is to find n√m (nth root of m).
 */
public class NthRoot {
    static public int nthRoot(int n, int m) {
        int low = 0, high = m, mid, result;
        while (low <= high) {
            mid = (low + high) / 2;

            result = (int) Math.pow(mid, n);

            if (result == m)
                return mid;
            else if (result > m)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }
}

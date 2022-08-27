import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of predicted rainfall for next n days, where index i presents
 * a day and day[i] represents the amount of rainfall on that day, return a list
 * of ideal days such that -
 * 
 * day[i-k] >= day[i-k+1] >= ... day[i-1] >= day[i] <= day[i+1] ... <=
 * day[i+k-1] <= day[i+k],
 * 
 * where k is given as an input which represents the number of days prior and
 * after the current day.
 * 
 * As index represents day, while returning, we need to return i+1 as the actual
 * day.
 * 
 * Ex:
 * day = [3,2,2,2,3,4]
 * k = 2
 * Output:
 * [3,4]
 * 
 * Explanation:
 * 
 * the rainfall trend for day3 (i = 2) is day1 >= day2 >= day3 <= day4 <= day5
 * so day3 is ideal
 * the rainfall trend for day4 (i = 3) is day2 >= day3 >= day4 <= day5 <= day6
 * so day4 is ideal
 * 
 * i <= k <= n <= 2x10^5
 * 0 <= day[i] <= 10^9
 * 
 * Testcase1
 * day = [1,0,1,0,1]
 * k = 1
 * Output:
 * [2,4]
 * 
 * Testcase2
 * day = [1,0,0,0,1]
 * k = 2
 * Output:
 * [3]
 * 
 * Testcase3
 * day = [1,1,1,1,1,1,1,1,1,1]
 * k = 3
 * Output:
 * [4,5,6,7]
 */
public class IdealDays {

    // T = O(n) | S = O(n)
    // Where n is input array's length.
    public static List<Integer> solve(int[] rainFallPredictions, int k) {
        int[] forward = new int[rainFallPredictions.length];
        for (int i = 1; i < rainFallPredictions.length; ++i) {
            if (rainFallPredictions[i - 1] >= rainFallPredictions[i]) {
                forward[i] = forward[i - 1] + 1;
            }
        }

        int[] backward = new int[rainFallPredictions.length];
        for (int i = rainFallPredictions.length - 2; i >= 0; --i) {
            if (rainFallPredictions[i + 1] >= rainFallPredictions[i]) {
                backward[i] = backward[i + 1] + 1;
            }
        }

        List<Integer> idealDays = new ArrayList<>();
        for (int i = 0; i < rainFallPredictions.length; ++i) {
            if (forward[i] >= k && backward[i] >= k) {
                idealDays.add(i + 1);
            }
        }

        return idealDays;
    }
}

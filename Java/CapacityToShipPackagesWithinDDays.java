/**
 * A conveyor belt has packages that must be shipped from one port to another
 * within D days. The i-th package on the conveyor belt has a weight of
 * weights[i]. Each day, we load the ship with packages on the conveyor belt (in
 * the order given by weights). We may not load more weight than the maximum
 * weight capacity of the ship.
 * 
 * Return the least weight capacity of the ship that will result in all the
 * packages on the conveyor belt being shipped within D days.
 */
public class CapacityToShipPackagesWithinDDays {

    // T = O(log(sum(weights) - max(weights)) * n) | S = O(1)
    // Where n is the size of the input array.
    public static long solve(int[] weights, int D) throws Exception {
        if (D <= 0) {
            throw new Exception("Atleast 1 day required to ship.");
        }

        long sum = 0;
        int max = 0;
        for (int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }

        long left = max, right = sum;
        while (left < right) {
            long mid = (left + right) / 2;
            if (feasible(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean feasible(int[] weights, int D, long minPossibleWeightCapacity) {
        long weightSum = 0;
        int day = 1;
        for (int weight : weights) {
            weightSum += weight;
            if (weightSum > minPossibleWeightCapacity) {
                weightSum = weight;
                ++day;
                if (day > D) {
                    return false;
                }
            }
        }

        return true;
    }
}

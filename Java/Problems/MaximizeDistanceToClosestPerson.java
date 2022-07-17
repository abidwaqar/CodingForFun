package Problems;

/**
 * You are given an array representing a row of seats where seats[i] = 1
 * represents a person sitting in the ith seat, and seats[i] = 0 represents that
 * the ith seat is empty (0-indexed).
 * 
 * There is at least one empty seat, and at least one person sitting.
 * 
 * Alex wants to sit in the seat such that the distance between him and the
 * closest person to him is maximized.
 * 
 * Return that maximum distance to the closest person.
 * 
 * Example 1:
 * Input: seats = [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (i.e. seats[2]), then the closest person
 * has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 */
public class MaximizeDistanceToClosestPerson {

    // T = O(n) | S = O(1)
    // Where n is input array's length.
    public static int solve(int[] seats) {
        int i = 0;
        while (i < seats.length && seats[i] == 0) {
            ++i;
        }

        int lastOccupiedSeat = i, maxDistance = i;
        for (++i; i < seats.length; ++i) {
            if (seats[i] == 1) {
                maxDistance = Math.max(maxDistance, (i - lastOccupiedSeat) / 2);
                lastOccupiedSeat = i;
            }
        }

        maxDistance = Math.max(maxDistance, i - lastOccupiedSeat - 1);

        return maxDistance;
    }
}

import java.util.HashSet;
import java.util.Set;

// Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
// For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
public class TwoSum {
    // T = O(n) | S = O(n) - where n is the size of the input array.
    public static boolean solve(int[] array, int k) throws Exception {
        Set<Integer> visited = new HashSet<>();
        for (int element : array) {
            if (visited.contains(k - element)) {
                return true;
            }

            visited.add(element);
        }

        return false;
    }
}

import java.util.Stack;

/**
 * There is a straight line of students of various heights. The students'
 * heights are given in in the form of an array, in the order, they are standing
 * in the line. Consider the region of a student as the length of the largest
 * subarray that includes that student's position, and in which that student's
 * height is equal to maximum height among all students present in that
 * subarray. Return the sum of the region of all students.
 * 
 * For example:
 * heights [1, 2, 1]
 * The longest subarray in which the first student height is equal to maximum
 * height among all other students is [1]; thus, the length of the region of the
 * first student is 1. The longest subarray in which the second student height
 * is equal to maximum height among all other students is [1, 2, 1]; thus, the
 * length of the region of the second student is 3. The longest subarray in
 * which the third student height is equal to maximum height among all other
 * students is [1]; thus, the length of the region of the third student is 1. •
 * Thus, the sum of the lengths of all regions of all students is 1+3+1 =5
 */
public class CalculateRegion {

    // T = O(n) | S = O(n)
    // Where n is input array length.
    public static long solve(int[] heights) {
        int region = heights.length;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < heights.length; ++i) {
            int currentRegion = 0;
            while (!stack.isEmpty() && stack.peek()[0] <= heights[i]) {
                currentRegion += stack.pop()[1] + 1;
            }

            region += currentRegion;
            stack.push(new int[] { heights[i], currentRegion });
        }

        stack.clear();

        for (int i = heights.length - 1; i >= 0; --i) {
            int currentRegion = 0;
            while (!stack.isEmpty() && stack.peek()[0] <= heights[i]) {
                currentRegion += stack.pop()[1] + 1;
            }

            region += currentRegion;
            stack.push(new int[] { heights[i], currentRegion });
        }

        return region;
    }
}

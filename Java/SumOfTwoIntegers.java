/**
 * Given two integers a and b, return the sum of the two integers without using
 * the operators + and -.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 * 
 * Input: a = 2, b = 3
 * Output: 5
 * 
 */
public class SumOfTwoIntegers {

    // T = O(1) | S = O(1)
    // Where n is input array's length.
    public static int solve(int a, int b) {
        int result = a ^ b, carry = (a & b) << 1;
        while (carry != 0) {
            int tempResult = result ^ carry;
            carry = (result & carry) << 1;
            result = tempResult;
        }

        return result;
    }
}

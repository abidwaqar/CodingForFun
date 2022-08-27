// Given an array of integers, return a new array such that each element at index i of the new array
// is the product of all the numbers in the original array except the one at i.
// For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
// If our input was [3, 2, 1], the expected output would be [2, 3, 6].
public class ProductArray {
    // T = O(n) | S = O(n) - where n is the size of the input array.
    public static long[] solve(int[] array) throws Exception {
        long[] productArray = new long[array.length];
        productArray[0] = array[0];

        for (int i = 1; i < array.length; ++i) {
            productArray[i] = productArray[i - 1] * array[i];
        }

        long product = 1;
        for (int i = array.length - 1; i > 0; --i) {
            productArray[i] = productArray[i - 1] * product;
            product = product * array[i];
        }
        productArray[0] = product;

        return productArray;
    }
}

import java.util.Arrays;

/**
 * Given an array of elements, rearrange the elements of array in
 * zig-zag fashion. The converted array should be in form a < b > c < d > e < f.
 * 
 * Examples:
 * 
 * Input: arr[] = {4, 3, 7, 8, 6, 2, 1}
 * Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
 * 
 * Input: arr[] = {1, 4, 3, 2}
 * Output: arr[] = {1, 4, 2, 3}
 */
public class ZigZagArray {

    // T = O(n) | S = O(1)
    // Where n is input array's length.
    public static int[] distinctArray(int[] array) {
        boolean lessThan = true;
        for (int i = 0; i < array.length - 1; ++i, lessThan = !lessThan) {
            if (lessThan) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1, array);
                }
            } else {
                if (array[i] < array[i + 1]) {
                    swap(i, i + 1, array);
                }
            }
        }

        return array;
    }

    // T = O(n * log(n)) | S = O(n)
    // Where n is input array's length.
    public static int[] nonDistinctArray(int[] array) {
        Arrays.sort(array);

        boolean lessThan = true;
        int[] result = new int[array.length];
        int leftPointer = 0, rightPointer = array.length - (array.length / 2);
        for (int i = 0; i < array.length; ++i) {
            if (lessThan) {
                result[i] = array[leftPointer];
                ++leftPointer;
            } else {
                result[i] = array[rightPointer];
                ++rightPointer;
            }

            lessThan = !lessThan;
        }

        return result;
    }

    private static void swap(int i, int j, int[] array) {
        int tempVar = array[i];
        array[i] = array[j];
        array[j] = tempVar;
    }
}

// Implement simple binary search, Left most binary search and right most binary search
public class BinarySearch {
    // T = O(log(n)) | S = O(1) - where n is the size of the array.
    public static int simple(int[] array, int target) throws Exception {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] < target) {
                left = middle + 1;
            } else if (array[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return (left + 1) * -1;
    }

    // T = O(log(n)) | S = O(1) - where n is the size of the array.
    public static int leftMost(int[] array, int target) throws Exception {
        int left = 0, right = array.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return (left < array.length && array[left] == target) ? left : (left + 1) * -1;
    }

    // T = O(log(n)) | S = O(1) - where n is the size of the array.
    public static int rightMost(int[] array, int target) throws Exception {
        int left = 0, right = array.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (array[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return (left - 1 >= 0 && array[left - 1] == target) ? left - 1 : (left + 1) * -1;
    }
}

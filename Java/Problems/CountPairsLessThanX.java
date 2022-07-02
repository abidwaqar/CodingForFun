package Problems;

public class CountPairsLessThanX {
    public static int solve(int[] array, int x) throws Exception {
        int count = 0, left = 0, right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] < x) {
                count = count + right - left;
                ++left;
            } else {
                --right;
            }
        }

        return count;
    }
}

package Problems;

public class MergeTwoSortedArraysinConstantSpace {
    public static void solve(int[] array1, int[] array2) throws Exception {
        for (int i = 0; i < array1.length; ++i) {
            if (array1[i] > array2[0]) {
                int swapVar = array1[i];
                array1[i] = array2[0];
                array2[0] = swapVar;

                for (int j = 0; j < array2.length - 1 && array2[j] > array2[j + 1]; ++j) {
                    swapVar = array2[j];
                    array2[j] = array2[j + 1];
                    array2[j + 1] = swapVar;
                }
            }
        }
    }
}

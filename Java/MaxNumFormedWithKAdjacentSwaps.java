public class MaxNumFormedWithKAdjacentSwaps {
    public static int[] solve(int[] array, int k) throws Exception {
        for (int i = 0; i < array.length && k != 0; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < array.length && j <= i + k; ++j) {
                if (array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
            }

            for (int j = maxIndex; j > i && k != 0; --j) {
                int swapVar = array[j - 1];
                array[j - 1] = array[j];
                array[j] = swapVar;

                --k;
            }
        }

        return array;
    }
}

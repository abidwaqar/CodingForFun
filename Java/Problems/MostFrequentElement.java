package Problems;

import java.util.Arrays;

public class MostFrequentElement {
    public static int solve(int[] array) throws Exception {
        Arrays.sort(array);

        int maxCount = Integer.MIN_VALUE, maxCountNum = array[0], currentCount = 1;
        for (int i = 1; i < array.length; ++i) {
            if (array[i] == array[i - 1]) {
                ++currentCount;
            } else {
                if (maxCount < currentCount) {
                    maxCount = currentCount;
                    maxCountNum = array[i - 1];
                }

                currentCount = 1;
            }
        }

        if (maxCount < currentCount) {
            maxCountNum = array[array.length - 1];
        }

        return maxCountNum;
    }
}

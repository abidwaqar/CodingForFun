package Problems;

import java.util.Arrays;

// A customer wants to buy a pair of jeans, a pair of shoes, a skirt, and a top but has a limited budget in dollars.
// Given different pricing options for each product, determine how many options our customer has to buy 1 of each product. 
// You cannot spend more money than the budgeted amount.
public class ShoppingOptions {

    // T = O(a * b * c * d) | S = O(1)
    // where a, b, c and d is the size of the input arrays.
    public static int solveNaive(int[] pairOfJeans, int[] pairOfShoes, int[] skirts, int[] tops, int budget)
            throws Exception {
        int options = 0;
        for (int i : pairOfJeans) {
            for (int j : pairOfShoes) {
                for (int k : skirts) {
                    for (int l : tops) {
                        if (i + j + k + l <= budget) {
                            ++options;
                        }
                    }
                }
            }
        }

        return options;
    }

    // T = O(((a * b) + (c * d)) * log(c * d)) | S = O((a * b) + (c * d))
    // where a, b, c and d is the size of the input arrays.
    public static int solveOptimized(int[] pairOfJeans, int[] pairOfShoes, int[] skirts, int[] tops, int budget)
            throws Exception {

        int index = 0;
        int[] jeansAndShoes = new int[pairOfJeans.length * pairOfShoes.length];
        for (int jeans : pairOfJeans) {
            for (int shoes : pairOfShoes) {
                jeansAndShoes[index++] = jeans + shoes;
            }
        }

        index = 0;
        int[] skirtsAndTops = new int[skirts.length * tops.length];
        for (int skirt : skirts) {
            for (int top : tops) {
                skirtsAndTops[index++] = skirt + top;
            }
        }

        Arrays.sort(skirtsAndTops);

        int possibleOption = 0;
        for (int i : jeansAndShoes) {
            int remainingBudget = budget - i;
            index = rightMostBinarySearch(skirtsAndTops, remainingBudget);
            if (index >= 0) {
                possibleOption = possibleOption + index + 1;
            } else {
                possibleOption = possibleOption + ((index + 1) * -1);
            }
        }

        return possibleOption;
    }

    private static int rightMostBinarySearch(int[] array, int target) {
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

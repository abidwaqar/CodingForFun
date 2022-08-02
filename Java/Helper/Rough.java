package Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Driver code
 */
public class Rough {
    public static void main(String[] args) {
        try {
            System.out.println(new Rough().coinChange(new int[] { 186, 419, 83, 408 }, 6249));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Arrays.sort(coins);

        int[] tabulation = new int[amount + 1];
        Arrays.fill(tabulation, 1, amount + 1, Integer.MAX_VALUE);
        for (int coin : coins) {
            for (int i = coin; i <= amount; ++i) {
                int remainder = i % coin;
                int quotient = i / coin;

                int newValue = tabulation[remainder] == Integer.MAX_VALUE ? Integer.MAX_VALUE
                        : quotient + tabulation[remainder];
                tabulation[i] = Math.min(tabulation[i], newValue);
            }
        }

        return tabulation[amount] == Integer.MAX_VALUE ? -1 : tabulation[amount];
    }
}

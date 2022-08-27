package Helper;

import java.util.ArrayList;
import java.util.Arrays;

import MinimizeCashFlow;
import ZigZagArray;

/**
 * Driver code
 */
public class Program {
    public static void main(String[] args) {
        try {
            System.out.println(
                    MinimizeCashFlow
                            .solve(new int[][] { { 0, 1000, 2000, 0 }, { 0, 0, 5000, 0 }, { 0, 0, 0, 8000 },
                                    { 0, 0, 0, 0 } }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

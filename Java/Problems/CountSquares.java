package Problems;

/**
 * Consider a sample space S consisting of all perfect squares starting from 1,
 * 4, 9 and so on. You are given a number N, you have to output the number of
 * integers less than N in the sample space S.
 */
public class CountSquares {
    public static int countSquares(int N) {
        return (int) Math.sqrt(N - 1);
    }
}

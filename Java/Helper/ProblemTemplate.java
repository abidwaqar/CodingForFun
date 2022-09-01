package Helper;

/**
 * Question statement
 */
public class ProblemTemplate {

    public static void main(String[] args) {
        try {
            System.out.println(solve(new int[] { 1, 2, 3, 4, 5 }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // T = O(n) | S = O(n)
    // Where n is input array's length.
    public static int solve(int[] array) {
        return 0;
    }
}

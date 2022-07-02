package Helper;

/**
 * Driver code
 */
public class Program {
    public static void main(String[] args) {
        try {
            Print.printArray(Problems.IdealDays
                    .solve(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

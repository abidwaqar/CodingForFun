package Helper;

/**
 * Driver code
 */
public class Program {
    public static void main(String[] args) {
        try {
            Print.printArray(Problems.UpgradingJunctionBoxes
                    .solve(new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

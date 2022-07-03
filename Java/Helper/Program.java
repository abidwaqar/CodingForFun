package Helper;

/**
 * Driver code
 */
public class Program {
    public static void main(String[] args) {
        try {
            System.out.println(Problems.ReachTheEndInTime
                    .solve(new char[][] { { '.', '.', '#', '#' }, { '#', '.', '#', '#' }, { '#', '.', '.', '.' } }, 5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

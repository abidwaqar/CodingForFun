package Helper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Driver code
 */
public class Program {
    public static void main(String[] args) {
        try {
            System.out.println(Problems.WordBreak.solve("aaaaaa", new ArrayList<>(Arrays.asList("aaaa", "aa"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

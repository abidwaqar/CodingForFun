import java.util.ArrayList;
import java.util.Collections;

/**
 * You have given a list of q queries and for every query, you are given an
 * integer N. The task is to find how many numbers less than or equal to N have
 * numbers of divisors exactly equal to 3.
 */
public class ThreeDivisors {
    public static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Long long1 : query) {
            result.add(SieveOfEratosthenes.sieveOfEratosthenesOptimizedOptimized((int) Math.sqrt(long1)).size());
        }
        return result;
    }

    public static ArrayList<Integer> threeDivisorsOptimized(ArrayList<Long> query, int q) {
        ArrayList<Integer> primeNumbers = SieveOfEratosthenes
                .sieveOfEratosthenesOptimizedOptimized((int) Math.sqrt(Collections.max(query)));

        int result, sqrtInput;
        ArrayList<Integer> resultArray = new ArrayList<>();
        for (Long input : query) {
            result = 0;
            sqrtInput = (int) Math.sqrt(input);
            for (int i = 0; i < primeNumbers.size(); i++) {
                if (sqrtInput >= primeNumbers.get(i))
                    ++result;
                else
                    break;
            }
            resultArray.add(result);
        }
        return resultArray;
    }
}

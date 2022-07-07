package Problems;

/**
 * Given a number N, check if a number is perfect or not. A number is said to be
 * perfect if sum of all its factors excluding the number itself is equal to the
 * number.
 */
public class PerfectNumbers {
    static public int isPerfectNumber(long number) {
        if (number == 1)
            return 0;

        long result = 1;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                result += i;
                result += (number / i);
            }
        }

        return result == number ? 1 : 0;
    }
}

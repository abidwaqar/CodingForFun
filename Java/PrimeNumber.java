/**
 * For a given number N check if it is prime or not. A prime number is a number
 * which is only divisible by 1 and itself.
 */
public class PrimeNumber {
    static int isPrime(int N) {
        if (N == 1)
            return 0;

        while (N % 2 == 0 && N != 2) {
            return 0;
        }

        for (Long i = 3l; i <= Math.sqrt(N); i += 2) {
            while (N % i == 0) {
                return 0;
            }
        }

        return 1;
    }
}

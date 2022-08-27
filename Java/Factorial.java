public class Factorial {
    static long factorial(long N) {
        long result = 1;
        for (long i = N; i > 0; --i) {
            result *= i;
        }
        return result;
    }
}
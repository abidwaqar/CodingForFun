public class NPR {
    static long nPr(long n, long r) {
        return Factorial.factorial(n) / Factorial.factorial(n - r);
    }
}

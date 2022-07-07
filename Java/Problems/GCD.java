package Problems;

/**
 * Given two positive integers A and B, find GCD of A and B.
 */
public class GCD {
    static public int gcd(int A, int B) {
        if (B == 0)
            return A;
        return gcd(B, A % B);
    }
}

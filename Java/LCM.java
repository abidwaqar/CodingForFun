/**
 * Given two numbers A and B. The task is to find out their LCM
 */
public class LCM {
    static public int lcm(int A, int B) {
        int resultA = A, resultB = B;
        while (resultA != resultB) {
            if (resultA < resultB)
                resultA += A;
            else
                resultB += B;
        }
        return resultA;
    }

    static public int lcmUsingGcd(int A, int B) {
        return (A * B) / GCD.gcd(A, B);
    }
}

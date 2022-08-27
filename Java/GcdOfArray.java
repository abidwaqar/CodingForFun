/**
 * Given an array of N positive integers, find GCD of all the array elements.
 */
public class GcdOfArray {
    static public int gcdOfArrayOptimized(int N, int arr[]) throws Exception {
        if (N == 0)
            throw new Exception("Array is empty");
        int tempGCD = arr[0];
        for (int i = 1; i < N; i++) {
            tempGCD = GCD.gcd(tempGCD, arr[i]);
            if (tempGCD == 1)
                return 1;
        }
        return tempGCD;
    }
}

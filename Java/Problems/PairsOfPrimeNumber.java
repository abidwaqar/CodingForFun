package Problems;

import java.util.ArrayList;

/**
 * Find all pairs (sets) of prime numbers (p,q) such that p*q <= n, where n is
 * given number.
 */
public class PairsOfPrimeNumber {
    public static int[] prime_pairs(int n) {
        ArrayList<Integer> primeFactors = SieveOfEratosthenes.sieveOfEratosthenes(n);
        ArrayList<Integer> primeFactorsSet = new ArrayList<>();

        for (int i = 0; i < primeFactors.size(); i++) {
            for (int j = 0; j < primeFactors.size(); j++) {
                if (primeFactors.get(i) * primeFactors.get(j) <= n) {
                    primeFactorsSet.add(primeFactors.get(i));
                    primeFactorsSet.add(primeFactors.get(j));
                }
            }
        }

        int[] resultArray = new int[primeFactorsSet.size()];
        for (int i = 0; i < primeFactorsSet.size(); i++) {
            resultArray[i] = primeFactorsSet.get(i);
        }
        return resultArray;
    }
}

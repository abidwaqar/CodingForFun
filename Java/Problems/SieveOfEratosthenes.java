package Problems;

import java.util.ArrayList;

/**
 * Given a number N, calculate the prime numbers up to N using Sieve of
 * Eratosthenes.
 */
public class SieveOfEratosthenes {
    static ArrayList<Integer> sieveOfEratosthenes(int N) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= N; ++i) {
            primeNumbers.add(i);
        }

        for (int i = 0; i < primeNumbers.size(); ++i) {
            for (int j = 2; (j * primeNumbers.get(i)) <= N; ++j) {
                primeNumbers.remove((Object) (j * primeNumbers.get(i)));
            }
        }

        return primeNumbers;
    }

    static ArrayList<Integer> sieveOfEratosthenesOptimized(int N) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= N; ++i) {
            primeNumbers.add(i);
        }

        double sqrtN = Math.sqrt(N);
        for (int i = 2; i <= sqrtN; ++i) {
            if (!primeNumbers.contains((Object) i))
                continue;
            for (int j = (i * 2); j <= N; j += i) {
                primeNumbers.remove((Object) (j));
            }
        }

        return primeNumbers;
    }

    static ArrayList<Integer> sieveOfEratosthenesOptimizedOptimized(int N) {
        boolean[] isPrimeNumberArray = new boolean[N + 1];
        // isPrimeNumberArray[0] = false;
        // isPrimeNumberArray[1] = false;
        for (int i = 2; i < (N + 1); i++) {
            isPrimeNumberArray[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrimeNumberArray[i] == true) {
                for (int j = (i * 2); j <= N; j += i) {
                    isPrimeNumberArray[j] = false;
                }
            }
        }

        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= N; ++i) {
            if (isPrimeNumberArray[i] == true)
                primeNumbers.add(i);
        }
        return primeNumbers;
    }
}

package Problems;

import java.util.ArrayList;

public class PrimeFactors {
    static public ArrayList<Integer> primeFactors(long number) {
        ArrayList<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            while (true) {
                if (number % i == 0) {
                    primeFactors.add(i);
                    number = number / i;
                } else {
                    break;
                }
            }
        }
        return primeFactors;
    }

    static public ArrayList<Long> primeFactorsOptimized(long number) {
        ArrayList<Long> primeFactors = new ArrayList<>();

        // Step 1
        while (number % 2 == 0) {
            primeFactors.add(2l);
            number /= 2;
        }

        // Step 2
        for (Long i = 3l; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                primeFactors.add(i);
                number /= i;
            }
        }

        // Step 3
        if (number > 2)
            primeFactors.add(number);

        return primeFactors;
    }
}

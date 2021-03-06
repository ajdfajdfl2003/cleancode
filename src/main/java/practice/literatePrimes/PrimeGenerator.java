package practice.literatePrimes;

import java.util.ArrayList;

public class PrimeGenerator {
    private static int[] primes;
    private static ArrayList<Integer> multiplesOfPrimeFactors;

    public static int[] generate(int numberOfPrimes) {
        primes = new int[numberOfPrimes];
        multiplesOfPrimeFactors = new ArrayList<>();
        setTwoAsFirstPrime();
        checkOddNumbersForSubsequentPrimes();
        return primes;
    }

    private static void checkOddNumbersForSubsequentPrimes() {
        int primeIndex = 1;
        for (int candidate = 3; primeIndex < primes.length; candidate += 2) {
            if (isPrime(candidate)) {
                primes[primeIndex++] = candidate;
            }
        }
    }

    private static boolean isPrime(int candidate) {
        if (isLeastRelevantMultipleOfNextLargerPrimeFactor(candidate)) {
            multiplesOfPrimeFactors.add(candidate);
            return false;
        }
        return isNotMultipleOfAnyPreviousPrimefactor(candidate);
    }

    private static boolean isNotMultipleOfAnyPreviousPrimefactor(int candidate) {
        for (int n = 1; n < multiplesOfPrimeFactors.size(); n++) {
            if (isMultipleOfNthPrimeFactor(candidate, n)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMultipleOfNthPrimeFactor(int candidate, int n) {
        return candidate == smallestOddNthMultipleNotLessThanCandidate(candidate, n);
    }

    private static int smallestOddNthMultipleNotLessThanCandidate(int candidate, int n) {
        int multiple = multiplesOfPrimeFactors.get(n);
        while (multiple < candidate) {
            multiple += 2 * primes[n];
        }
        multiplesOfPrimeFactors.set(n, multiple);
        return multiple;
    }

    private static boolean isLeastRelevantMultipleOfNextLargerPrimeFactor(int candidate) {
        int nextLargerPrimeFactor = primes[multiplesOfPrimeFactors.size()];
        int leastRelevantMultiple = nextLargerPrimeFactor * nextLargerPrimeFactor;
        return candidate == leastRelevantMultiple;
    }

    private static void setTwoAsFirstPrime() {
        primes[0] = 2;
        multiplesOfPrimeFactors.add(2);
    }
}

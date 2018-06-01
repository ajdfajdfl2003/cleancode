/**
 * This class Generates prime numbers up to a user specified maximum.
 * The algorithm used is the Sieve of Eratosthenes.
 * Given an array of integers starting at 2.
 * Find the first uncrossed integer, and cross out
 * all of its multiples.
 * Repeat until there are no more multiples in the array.
 */

public class GeneratePrimes {

    private static boolean[] crossedOut;
    private static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2) {

            return new int[0];

        } else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();

            return result;
        }
    }

    private static void putUncrossedIntegersIntoResult() {
        result = new int[numberOfUncrossedIntegers()];
        // move the primes into the result
        for (int i = 2, j = 0; i < crossedOut.length; i++) {
            if (notCrossed(i)) {// if prime
                result[j++] = i;
            }
        }
    }

    private static int numberOfUncrossedIntegers() {
        // how many primes are there?
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++) {
            if (notCrossed(i))
                count++; // bump count.
        }
        return count;
    }

    private static void crossOutMultiples() {
        int limit = determineIterationLimit();
        for (int i = 2; i <= limit; i++) {
            if (notCrossed(i)) // if i is uncrossed, cross its multiples.
            {
                crossOutMultiplesOf(i);
            }
        }
    }

    private static boolean notCrossed(int i) {
        return !crossedOut[i];
    }

    private static void crossOutMultiplesOf(int i) {
        for (int j = 2 * i; j < crossedOut.length; j += i) {
            crossedOut[j] = true; // multiple is not prime
        }
    }

    private static int determineIterationLimit() {
        return (int) Math.sqrt(crossedOut.length);
    }

    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++) {
            crossedOut[i] = false;
        }
    }
}
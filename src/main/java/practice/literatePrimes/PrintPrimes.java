package practice.literatePrimes;

public class PrintPrimes {
    public static void main(String[] args) {
        final int NUMBER_OF_PRIMES = 1000;
        int[] primes = PrimeGenerator.generate(NUMBER_OF_PRIMES);

        final int ROW_PER_PAGE = 50;
        final int COLUMN_PER_PAGE = 4;
        RowColumnPagePrinter tablePrinter =
                new RowColumnPagePrinter(ROW_PER_PAGE, COLUMN_PER_PAGE,
                        "The First " + NUMBER_OF_PRIMES + " Prime Numbers");
        tablePrinter.print(primes);
    }
}

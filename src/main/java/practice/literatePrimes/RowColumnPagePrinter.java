package practice.literatePrimes;

import java.io.PrintStream;

public class RowColumnPagePrinter {
    private final String pageHeader;
    private final int columnPerPage;
    private final int rowPerPage;
    private final int numbersPerPage;
    private final PrintStream printStream;

    public RowColumnPagePrinter(int rowPerPage, int columnPerPage, String pageHeader) {
        this.rowPerPage = rowPerPage;
        this.columnPerPage = columnPerPage;
        this.pageHeader = pageHeader;
        this.numbersPerPage = rowPerPage * columnPerPage;
        printStream = System.out;
    }

    public void print(int[] data) {
        int pageNumber = 1;
        for (int firstIndexOnPage = 0;
             firstIndexOnPage < data.length;
             firstIndexOnPage += numbersPerPage) {

            int lastIndexOnPage = Math.min(firstIndexOnPage + numbersPerPage - 1,
                    data.length - 1);

            printPageHeader(pageNumber);
            printPage(firstIndexOnPage, lastIndexOnPage, data);
            System.out.println("\f");
            pageNumber++;
        }
    }

    private void printPage(int firstIndexOnPage, int lastIndexOnPage, int[] data) {
        int firstIndexOfLastRowOnPage =
                firstIndexOnPage + rowPerPage - 1;
        for (int firstIndexInRow = firstIndexOnPage;
             firstIndexInRow <= firstIndexOfLastRowOnPage;
             firstIndexInRow++) {
            printRow(firstIndexInRow, lastIndexOnPage, data);
            printStream.println();
        }
    }

    private void printRow(int firstIndexInRow, int lastIndexOnPage, int[] data) {
        for (int column = 0; column < columnPerPage; column++) {
            int index = firstIndexInRow + column * rowPerPage;
            if (index <= lastIndexOnPage) {
                printStream.format("%10d", data[index]);
            }
        }
    }

    private void printPageHeader(int pageNumber) {
        printStream.println(pageHeader + " --- Page " + pageNumber);
        printStream.println();
    }
}

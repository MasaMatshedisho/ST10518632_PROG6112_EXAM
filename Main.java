package mattresssales;

import java.util.Scanner;

/**
 * Console application that captures three months of sales for three
 * mattresses and prints the product sales report (Q.1.1).
 */
public class Main {

    private static final int MONTHS = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Single-dimensional array of product names
        String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        // Two-dimensional array of sales: [product][month]
        int[][] sales = new int[productNames.length][MONTHS];

        // Capture the sales for every product and month
        for (int p = 0; p < productNames.length; p++) {
            for (int m = 0; m < MONTHS; m++) {
                sales[p][m] = readSales(input, m + 1, productNames[p]);
            }
            System.out.println();
        }

        // Calculate and print the report
        Product product = new Product(productNames, sales);
        PrintProduct printer = new PrintProduct(product);
        printer.printHeader();
        printer.printTotalProductSales();
        printer.printAverageProductSales();
        printer.printMostPopularProduct();
    }

    /** Keeps asking until a whole number of 0 or more is entered. */
    private static int readSales(Scanner input, int month, String productName) {
        while (true) {
            System.out.print("Enter number of sales for month " + month
                    + " for " + productName + " mattress: ");
            String text = input.nextLine().trim();
            try {
                int value = Integer.parseInt(text);
                if (value >= 0) {
                    return value;
                }
            } catch (NumberFormatException ex) {
                // fall through to the error message below
            }
            System.out.println("Invalid input. Please enter a whole number of 0 or more.");
        }
    }
}

package mattresssales;

import java.text.DecimalFormat;

/**
 * Responsible only for printing the report data (Q.1.3).
 */
public class PrintProduct {

    private final Product product;
    // Shows 17 as "17" and 17.33 as "17.33"
    private final DecimalFormat averageFormat = new DecimalFormat("0.##");

    public PrintProduct(Product product) {
        this.product = product;
    }

    /** Prints the report heading and the line of stars. */
    public void printHeader() {
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("*".repeat(50));
    }

    public void printTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void printAverageProductSales() {
        System.out.println("AVERAGE PRODUCT SALES: "
                + averageFormat.format(product.GetAverageProductSold()));
    }

    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct()
                + "(" + product.GetMostPopularProductSales() + ")");
    }
}

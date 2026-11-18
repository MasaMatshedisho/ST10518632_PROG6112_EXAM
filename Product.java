package mattresssales;

/**
 * Holds the sales data and performs the report calculations (Q.1.2).
 * A single-dimensional array holds the product names and a
 * two-dimensional array holds the sales: [product][month].
 */
public class Product implements IProduct {

    // Single-dimensional array: one name per product
    private final String[] productNames;
    // Two-dimensional array: rows = products, columns = months
    private final int[][] monthlySales;

    /**
     * @param productNames names of the products
     * @param monthlySales sales per product per month ([product][month])
     */
    public Product(String[] productNames, int[][] monthlySales) {
        this.productNames = productNames;
        this.monthlySales = monthlySales;
    }

    /** Adds up the sales of every month for one product. */
    private int getTotalForProduct(int productIndex) {
        int total = 0;
        for (int sale : monthlySales[productIndex]) {
            total += sale;
        }
        return total;
    }

    /** Total number of products sold across all products and months. */
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < monthlySales.length; i++) {
            total += getTotalForProduct(i);
        }
        return total;
    }

    /** Average sales over every product/month entry (total / number of entries). */
    @Override
    public double GetAverageProductSold() {
        int entries = 0;
        for (int[] row : monthlySales) {
            entries += row.length;
        }
        if (entries == 0) {
            return 0; // avoids dividing by zero
        }
        return (double) GetTotalProductsSold() / entries;
    }

    /** Index of the product with the highest total sales (first one wins a tie). */
    private int getMostPopularIndex() {
        int bestIndex = 0;
        for (int i = 1; i < monthlySales.length; i++) {
            if (getTotalForProduct(i) > getTotalForProduct(bestIndex)) {
                bestIndex = i;
            }
        }
        return bestIndex;
    }

    /** Name of the product with the highest total sales. */
    @Override
    public String GetMostPopularProduct() {
        return productNames[getMostPopularIndex()];
    }

    /** Total sales of the most popular product (shown next to its name in the report). */
    public int GetMostPopularProductSales() {
        return getTotalForProduct(getMostPopularIndex());
    }
}

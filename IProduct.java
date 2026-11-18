package mattresssales;

/**
 * Contract for the product sales calculations (Q.1.2).
 */
public interface IProduct {
    int GetTotalProductsSold();
    double GetAverageProductSold();
    String GetMostPopularProduct();
}

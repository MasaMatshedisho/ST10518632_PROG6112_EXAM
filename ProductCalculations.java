package mattressapp;

/**
 * Calculates the VAT, commission and total sale amount for a product price (Q.2.5).
 */
public class ProductCalculations implements IProductCalculations {

    private static final double VAT_RATE = 0.15;        // 15% of the price
    private static final double COMMISSION_RATE = 0.05; // 5% of the price

    private final double price;

    public ProductCalculations(double price) {
        this.price = price;
    }

    /** Rounds to 2 decimal places so values such as 525.0 print cleanly. */
    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    /** VAT: 15% of the product price. */
    @Override
    public double GetVat() {
        return round(price * VAT_RATE);
    }

    /** Commission: 5% of the product price. */
    @Override
    public double GetCommission() {
        return round(price * COMMISSION_RATE);
    }

    /** Total sale amount: price + VAT + commission. */
    @Override
    public double GetTotal() {
        return round(price + GetVat() + GetCommission());
    }
}

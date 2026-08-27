package food.model;

public class PremiumOrder extends FoodOrder implements Discountable {

    public PremiumOrder(int orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    // Method overriding
    public double calculateDeliveryCharge() {
        return 50;
    }

    // 15% discount

    public double applyDiscount() {
        return getAmount() * 0.15;
    }
}
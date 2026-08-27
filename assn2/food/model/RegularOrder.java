package food.model;


public class RegularOrder extends FoodOrder implements Discountable {

    public RegularOrder(int orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    public double calculateDeliveryCharge() {
        return 80;
    }


    public double applyDiscount() {
        return getAmount() * 0.10;
    }
}
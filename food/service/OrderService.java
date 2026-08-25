package food.service;

import food.model.FoodOrder;
import food.model.Discountable;

public class OrderService {

    public double calculateDiscount(FoodOrder order) {
        if (order instanceof Discountable) {
            Discountable d = (Discountable) order;
            return d.applyDiscount();
        }

        return 0;
    }

    public double calculateDeliveryCharge(FoodOrder order) {
        return order.calculateDeliveryCharge();
    }

    public double calculateFinalAmount(FoodOrder order) {
        double discount = calculateDiscount(order);
        double delivery = calculateDeliveryCharge(order);

        return order.getAmount() - discount + delivery;
    }
}
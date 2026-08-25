package food.utility;

import food.model.FoodOrder;
import food.service.OrderService;

public class OrderUtility {

    // Validate amount
    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    // Validate customer name
    public static boolean validateCustomerName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    // Generate order summary
    public static void generateOrderSummary(FoodOrder order) {

        OrderService service = new OrderService();

        double discount = service.calculateDiscount(order);
        double delivery = service.calculateDeliveryCharge(order);
        double finalAmount = service.calculateFinalAmount(order);

        System.out.println("--------------------------------------");
        System.out.println("Restaurant: " + FoodOrder.getRestaurantName());
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("Order Amount: Rs. " + order.getAmount());
        System.out.println("Discount: Rs. " + discount);
        System.out.println("Delivery Charge: Rs. " + delivery);
        System.out.println("Final Payable: Rs. " + finalAmount);
        System.out.println("--------------------------------------");
    }
}
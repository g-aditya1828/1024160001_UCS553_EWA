import java.util.*;

// ======================================================
// 1. BASE EXCEPTION
// ======================================================

class ApplicationException extends Exception {

    public ApplicationException(String message) {
        super(message);
    }
}


// ======================================================
// 2. PRODUCT EXCEPTION HIERARCHY
// ======================================================

class ProductException extends ApplicationException {

    public ProductException(String message) {
        super(message);
    }
}

class ProductNotFoundException extends ProductException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}

class OutOfStockException extends ProductException {

    public OutOfStockException(String message) {
        super(message);
    }
}


// ======================================================
// 3. PAYMENT EXCEPTION HIERARCHY
// ======================================================

class PaymentException extends ApplicationException {

    public PaymentException(String message) {
        super(message);
    }
}

class InvalidPaymentException extends PaymentException {

    public InvalidPaymentException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends PaymentException {

    public InsufficientFundsException(String message) {
        super(message);
    }
}


// ======================================================
// 4. ORDER EXCEPTION HIERARCHY
// ======================================================

class OrderException extends ApplicationException {

    public OrderException(String message) {
        super(message);
    }
}

class EmptyCartException extends OrderException {

    public EmptyCartException(String message) {
        super(message);
    }
}


// ======================================================
// 5. PRODUCT CLASS
// ======================================================

class Product {

    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        stock -= quantity;
    }

    public void display() {
        System.out.println(
            "ID: " + id +
            " | Name: " + name +
            " | Price: Rs." + price +
            " | Stock: " + stock
        );
    }
}


// ======================================================
// 6. SHOPPING CART CLASS
// ======================================================

class ShoppingCart {

    private ArrayList<Product> cart = new ArrayList<>();


    // --------------------------------------------------
    // SEARCH PRODUCT
    // --------------------------------------------------

    public Product searchProduct(
            ArrayList<Product> products,
            int productId)
            throws ProductNotFoundException {

        for (Product p : products) {

            if (p.getId() == productId) {
                return p;
            }
        }

        throw new ProductNotFoundException(
            "Product with ID " + productId + " not found."
        );
    }


    // --------------------------------------------------
    // ADD PRODUCT
    // --------------------------------------------------

    public void addProduct(
            ArrayList<Product> products,
            int productId)
            throws ProductException {

        Product p = searchProduct(products, productId);

        if (p.getStock() <= 0) {

            throw new OutOfStockException(
                "Product '" + p.getName() +
                "' is out of stock."
            );
        }

        cart.add(p);

        p.reduceStock(1);

        System.out.println(
            p.getName() + " added to cart."
        );
    }


    // --------------------------------------------------
    // REMOVE PRODUCT
    // --------------------------------------------------

    public void removeProduct(int productId)
            throws ProductNotFoundException {

        for (Product p : cart) {

            if (p.getId() == productId) {

                cart.remove(p);

                System.out.println(
                    p.getName() +
                    " removed from cart."
                );

                return;
            }
        }

        throw new ProductNotFoundException(
            "Product is not present in the cart."
        );
    }


    // --------------------------------------------------
    // DISPLAY CART
    // --------------------------------------------------

    public void displayCart() {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\n----- CART -----");

        for (Product p : cart) {

            System.out.println(
                p.getName() +
                " - Rs." +
                p.getPrice()
            );
        }

        System.out.println(
            "Total = Rs." + calculateTotal()
        );
    }


    // --------------------------------------------------
    // CALCULATE TOTAL
    // --------------------------------------------------

    public double calculateTotal() {

        double total = 0;

        for (Product p : cart) {
            total += p.getPrice();
        }

        return total;
    }


    // --------------------------------------------------
    // PAYMENT
    // --------------------------------------------------

    public void makePayment(
            String paymentMethod,
            double availableFunds)
            throws PaymentException,
                   EmptyCartException {

        // Check empty cart
        if (cart.isEmpty()) {

            throw new EmptyCartException(
                "Cannot make payment. Cart is empty."
            );
        }


        // Validate payment method
        if (!paymentMethod.equalsIgnoreCase("card") &&
            !paymentMethod.equalsIgnoreCase("upi") &&
            !paymentMethod.equalsIgnoreCase("cash")) {

            throw new InvalidPaymentException(
                "Invalid payment method."
            );
        }


        double total = calculateTotal();


        // Cash does not need fund validation
        if (!paymentMethod.equalsIgnoreCase("cash")) {

            if (availableFunds < total) {

                throw new InsufficientFundsException(
                    "Insufficient funds. Required: Rs." +
                    total +
                    ", Available: Rs." +
                    availableFunds
                );
            }
        }


        System.out.println(
            "\nPayment successful!"
        );

        System.out.println(
            "Payment Method: " +
            paymentMethod
        );

        System.out.println(
            "Amount Paid: Rs." +
            total
        );

        cart.clear();
    }
}


// ======================================================
// 7. MAIN CLASS
// ======================================================

public class ShoppingCartApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products =
                new ArrayList<>();


        // Adding products
        products.add(
            new Product(101, "Laptop", 50000, 5)
        );

        products.add(
            new Product(102, "Mouse", 800, 10)
        );

        products.add(
            new Product(103, "Keyboard", 1500, 3)
        );

        products.add(
            new Product(104, "Headphones", 2000, 0)
        );


        ShoppingCart cart = new ShoppingCart();


        // ==================================================
        // DISPLAY PRODUCTS
        // ==================================================

        System.out.println("===== AVAILABLE PRODUCTS =====");

        for (Product p : products) {
            p.display();
        }


        // ==================================================
        // SEARCH PRODUCT
        // ==================================================

        try {

            System.out.println(
                "\nSearching for product ID 101..."
            );

            Product p =
                    cart.searchProduct(products, 101);

            System.out.println(
                "Product found: " +
                p.getName()
            );

        } catch (ProductNotFoundException e) {

            System.out.println(
                "Product Error: " +
                e.getMessage()
            );
        }


        // ==================================================
        // ADD PRODUCTS
        // ==================================================

        try {

            cart.addProduct(products, 101);

            cart.addProduct(products, 102);

            cart.addProduct(products, 103);

        } catch (OutOfStockException e) {

            System.out.println(
                "Stock Error: " +
                e.getMessage()
            );

        } catch (ProductNotFoundException e) {

            System.out.println(
                "Product Error: " +
                e.getMessage()
            );
        }


        // ==================================================
        // DISPLAY CART
        // ==================================================

        cart.displayCart();


        // ==================================================
        // REMOVE PRODUCT
        // ==================================================

        try {

            cart.removeProduct(102);

        } catch (ProductNotFoundException e) {

            System.out.println(
                "Remove Error: " +
                e.getMessage()
            );
        }


        cart.displayCart();


        // ==================================================
        // PAYMENT
        // ==================================================

        try {

            cart.makePayment(
                "card",
                100000
            );

        } catch (InvalidPaymentException e) {

            System.out.println(
                "Payment Error: " +
                e.getMessage()
            );

        } catch (InsufficientFundsException e) {

            System.out.println(
                "Payment Error: " +
                e.getMessage()
            );

        } catch (EmptyCartException e) {

            System.out.println(
                "Order Error: " +
                e.getMessage()
            );
        }


        // ==================================================
        // FINAL OUTPUT
        // ==================================================

        System.out.println(
            "\nProgram completed."
        );

        sc.close();
    }
}
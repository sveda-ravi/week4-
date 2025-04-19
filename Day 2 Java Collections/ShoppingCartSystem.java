import java.util.*;

public class ShoppingCartSystem {

    // 1. Shopping Cart Implementation
    public static class ShoppingCart {

        // HashMap to store product prices
        private static Map<String, Double> productPrices = new HashMap<>();

        // LinkedHashMap to maintain the order of items added
        private static Map<String, Double> cart = new LinkedHashMap<>();

        // TreeMap to display items sorted by price
        // Fix: Handle potential null values with a proper comparator
        private static Map<String, Double> sortedCart = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String product1, String product2) {
                Double price1 = cart.get(product1);
                Double price2 = cart.get(product2);

                // Ensure the comparison handles null values gracefully
                if (price1 == null || price2 == null) {
                    return 0;  // Return 0 if either price is null to avoid NullPointerException
                }
                return price1.compareTo(price2);
            }
        });

        // Method to add products and their prices to the product catalog (HashMap)
        public static void addProductToCatalog(String productName, double price) {
            productPrices.put(productName, price);
        }

        // Method to add products to the cart
        public static void addToCart(String productName) {
            if (productPrices.containsKey(productName)) {
                cart.put(productName, productPrices.get(productName));
                sortedCart.put(productName, productPrices.get(productName)); // Add to TreeMap for sorted order
            } else {
                System.out.println("Product " + productName + " not found in catalog.");
            }
        }

        // Method to remove a product from the cart
        public static void removeFromCart(String productName) {
            if (cart.containsKey(productName)) {
                cart.remove(productName);
                sortedCart.remove(productName);
            } else {
                System.out.println("Product " + productName + " not found in cart.");
            }
        }

        // Method to view all products in the cart (in insertion order)
        public static void viewCart() {
            System.out.println("Cart contents (In insertion order):");
            for (Map.Entry<String, Double> entry : cart.entrySet()) {
                System.out.println(entry.getKey() + ": $" + entry.getValue());
            }
        }

        // Method to view the cart sorted by price
        public static void viewCartSortedByPrice() {
            System.out.println("Cart contents (Sorted by price):");
            for (Map.Entry<String, Double> entry : sortedCart.entrySet()) {
                System.out.println(entry.getKey() + ": $" + entry.getValue());
            }
        }

        // Method to calculate total price of the items in the cart
        public static double calculateTotalPrice() {
            double total = 0;
            for (Double price : cart.values()) {
                total += price;
            }
            return total;
        }
    }

    public static void main(String[] args) {

        // Adding products to the catalog (HashMap)
        ShoppingCart.addProductToCatalog("Apple", 1.99);
        ShoppingCart.addProductToCatalog("Banana", 0.99);
        ShoppingCart.addProductToCatalog("Orange", 1.49);
        ShoppingCart.addProductToCatalog("Laptop", 899.99);
        ShoppingCart.addProductToCatalog("Headphones", 49.99);

        // Adding products to the cart (LinkedHashMap)
        ShoppingCart.addToCart("Apple");
        ShoppingCart.addToCart("Laptop");
        ShoppingCart.addToCart("Headphones");

        // Viewing cart in insertion order
        ShoppingCart.viewCart();

        // Viewing cart sorted by price (TreeMap)
        ShoppingCart.viewCartSortedByPrice();

        // Calculating and displaying total price
        System.out.println("Total price of items in the cart: $" + ShoppingCart.calculateTotalPrice());

        // Removing a product from the cart
        ShoppingCart.removeFromCart("Laptop");
        System.out.println("\nAfter removing Laptop:");
        ShoppingCart.viewCart();
        System.out.println("Total price of items in the cart: $" + ShoppingCart.calculateTotalPrice());
    }
}

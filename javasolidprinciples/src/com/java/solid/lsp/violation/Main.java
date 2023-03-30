package com.java.solid.lsp.violation;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("Book", 1000);
        Product product2 = new DiscountedProduct("Laptop", 1500,10);
        cart.addProduct(product1);
        cart.addProduct(product2);
        int totalDisocuntedPrice = cart.calculateTotalDiscountedPrice();
        int totalPrice = cart.calculatePrice();
        System.out.println("Total Price: " + (totalPrice+totalDisocuntedPrice));

    }
}
package com.java.solid.lsp.corrected;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("iPhone", 1000);
        Product product2 = new DiscountedProduct("MacBook", 1500,10);

        cart.addProduct(product1);
        cart.addProduct(product2);

        int total = cart.calculateTotalPrice();
        System.out.println("Total Price: " + total);

    }
}
package com.java.solid.lsp.corrected;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("iPhone", 1000);
        Product product2 = new DiscountedProduct("MacBook", 1500,10);
        Product product3 = new UnavailableProduct("mobile",120);

        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);

        int totalPrice=cart.calculatePrice();
        int totalDiscountedPrice = cart.calculateTotalDiscountedPrice();
        System.out.println("Total Price: " + (totalDiscountedPrice+totalPrice));

    }
}
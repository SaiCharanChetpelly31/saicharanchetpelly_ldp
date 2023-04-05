package com.java.solid.lsp.violation;

public class Main {
    public static void main(String[] args) {
        Product prod = new Product();
        prod.setPrice(100);
        prod.setShippingCharges(50);
        System.out.println(prod.calculateTotalPrice());

        Product prod1 = new DigitalProduct();
        prod1.setPrice(100);
        prod1.setShippingCharges(50);
        System.out.println(prod1.calculateTotalPrice());

    }
}

package com.java.solid.lsp.corrected;

public class Main {
    public static void main(String[] args) {
        Product prod = new Product();
        prod.setPrice(100);
        prod.setShippingCharges(50);
        System.out.println(prod.calculateTotalPrice());

        DigitalProduct prod2 = new DigitalProduct();
        prod2.setPrice(200);
        prod2.setShippingCharges(50);
        System.out.println(prod2.calculateTotalPrice());

        ProductInter prod1 = new DigitalProduct();
        prod1.setPrice(100);
        prod1.setShippingCharges(50);
        System.out.println(prod1.calculateTotalPrice());
    }
}

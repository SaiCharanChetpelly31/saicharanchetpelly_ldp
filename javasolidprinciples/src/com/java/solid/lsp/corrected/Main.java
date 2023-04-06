package com.java.solid.lsp.corrected;

public class Main {
    public static void main(String[] args) {
        Product product1 = new PhysicalProduct(100,50);
        Product product2 = new DigitalProduct(100);
        System.out.println( product1.calculateTotalPrice());
        System.out.println(product2.calculateTotalPrice());
    }
}

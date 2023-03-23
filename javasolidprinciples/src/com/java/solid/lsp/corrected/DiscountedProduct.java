package com.java.solid.lsp.corrected;

public class DiscountedProduct extends Product {

    private int discount;

    public DiscountedProduct(String name, int price) {
        super(name, price);

    }

    public int getPrice() {

        return super.getPrice() - this.applyDiscount(10);
    }
    public int applyDiscount(int discount) {
        return super.getPrice() * (discount)/100;
    }
}
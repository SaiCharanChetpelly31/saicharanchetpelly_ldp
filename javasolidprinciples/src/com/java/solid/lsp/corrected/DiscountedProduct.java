package com.java.solid.lsp.corrected;

public class DiscountedProduct extends Product {

    private int discount;

    public DiscountedProduct(String name, int price,int discount) {
        super(name, price);
        this.discount = discount;
    }

    public int getPrice() {

        return super.getPrice() - this.applyDiscount(discount);
    }
    public int applyDiscount(int discount) {
        return super.getPrice() * (discount)/100;
    }
}
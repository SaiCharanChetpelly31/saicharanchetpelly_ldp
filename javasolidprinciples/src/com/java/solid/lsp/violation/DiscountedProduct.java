package com.java.solid.lsp.violation;

public class DiscountedProduct extends Product {
    private int discount;

    public DiscountedProduct(String name, int price) {
        super(name, price);

    }

    public int getDiscountPrice(int discount) {
        return super.getPrice()-super.getPrice() * (discount)/100;
    }

}
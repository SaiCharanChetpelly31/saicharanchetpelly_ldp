package com.java.solid.lsp.violation;

public class DiscountedProduct extends Product {
    private int discount;

    public DiscountedProduct(String name, int price,int discount) {
        super(name, price);
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public int getDiscountedPrice() {
        return super.getPrice()* (discount)/100;
    }
}
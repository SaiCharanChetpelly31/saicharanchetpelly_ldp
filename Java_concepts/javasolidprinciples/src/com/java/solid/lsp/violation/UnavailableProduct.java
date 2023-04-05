package com.java.solid.lsp.violation;

public class UnavailableProduct extends  Product{
    public UnavailableProduct(String name, int price) {
        super(name, price);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public int getDiscountedPrice() {
        throw new Error();
    }
}

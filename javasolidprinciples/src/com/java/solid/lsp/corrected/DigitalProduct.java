package com.java.solid.lsp.corrected;

public class DigitalProduct implements Product{
    private int price;
    private int shippingCharges;

    public DigitalProduct(int price) {
        this.price = price;
    }

    @Override
    public int calculateTotalPrice() {
        return this.price;
    }
}

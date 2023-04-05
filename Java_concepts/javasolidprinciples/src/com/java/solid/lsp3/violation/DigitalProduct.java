package com.java.solid.lsp3.violation;

public class DigitalProduct extends Product{
    private int price;
    private int shippingCharges;

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void setShippingCharges(int charges) {
        this.shippingCharges = 0;
    }

    @Override
    public int calculateTotalPrice() {
        return this.price + this.shippingCharges;
    }
}

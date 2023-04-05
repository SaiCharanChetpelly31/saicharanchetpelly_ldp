package com.java.solid.lsp3.corrected;

public class Product implements ProductInter{
    private int price;
    private int shippingCharges;
    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void setShippingCharges(int charges) {
        this.shippingCharges = charges;
    }

    @Override
    public int calculateTotalPrice() {
        return this.price + this.shippingCharges;
    }
}

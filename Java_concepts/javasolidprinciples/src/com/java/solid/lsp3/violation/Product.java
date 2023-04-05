package com.java.solid.lsp3.violation;

public class Product {
    private int price;
    private int shippingCharges;

    public void setPrice(int price){
        this.price = price;
    }
    public void setShippingCharges(int charges){
        this.shippingCharges = charges;
    }
    public int calculateTotalPrice(){
        return this.price + this.shippingCharges;
    }
}

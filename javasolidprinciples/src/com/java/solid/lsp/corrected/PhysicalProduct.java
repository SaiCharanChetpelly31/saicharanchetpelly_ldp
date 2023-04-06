package com.java.solid.lsp.corrected;

public class PhysicalProduct implements Product {

    private int price;
    private int shippingCharges;

    public PhysicalProduct(int price,int shippingCharges) {
        this.price = price;
        this.shippingCharges=shippingCharges;
    }
//    public void setShippingCharges(int shippingCharges){
//        this.shippingCharges = shippingCharges;
//    }
    @Override
    public int calculateTotalPrice() {
        return this.price + this.shippingCharges;
    }
}

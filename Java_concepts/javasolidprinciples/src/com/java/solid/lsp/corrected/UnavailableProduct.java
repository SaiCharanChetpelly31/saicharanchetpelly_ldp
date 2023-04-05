package com.java.solid.lsp.corrected;

public class UnavailableProduct extends Product{


    public UnavailableProduct(String name, int price) {
        super(name, price);
    }

    public int getPrice(){
        return 0;
    }

    @Override
    public int getDiscountedPrice() {
        return 0;
    }
}

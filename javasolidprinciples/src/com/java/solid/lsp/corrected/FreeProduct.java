package com.java.solid.lsp.corrected;

public class FreeProduct extends Product{


    public FreeProduct(String name, int price) {
        super(name, price);
    }

    public int getPrice(){
        return 0;
    }
}

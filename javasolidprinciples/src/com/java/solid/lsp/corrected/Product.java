package com.java.solid.lsp.corrected;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public int getPrice() {
        return price;
    }


    public int applyDiscount() {
        return 0;
    }

}

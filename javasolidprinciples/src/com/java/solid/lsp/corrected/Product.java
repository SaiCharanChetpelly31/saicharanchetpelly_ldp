package com.java.solid.lsp.corrected;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        System.out.println("adding "+name+" to cart");
        this.name = name;
        this.price = price;
        System.out.println("Added to cart");
    }


    public int getPrice() {
        return price;
    }


    public int applyDiscount() {
        return 0;
    }

}

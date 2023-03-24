package com.java.solid.lsp.violation;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        System.out.println("adding "+name+" to cart");
        this.name = name;
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

}

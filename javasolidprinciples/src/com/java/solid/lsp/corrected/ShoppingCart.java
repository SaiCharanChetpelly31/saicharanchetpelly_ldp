package com.java.solid.lsp.corrected;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }
    public int calculateTotalPrice() {
        System.out.println("calculating totalprice of items in cart");
        int totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        System.out.println("Total price of items in cart is "+totalPrice);
        return totalPrice;
    }
}

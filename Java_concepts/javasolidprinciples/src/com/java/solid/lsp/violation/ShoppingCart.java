package com.java.solid.lsp.violation;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added to cart");
    }
    public int calculateTotalDiscountedPrice() {
        System.out.println("calculating discountPrice of items in cart");
        int discountedPrice = 0;
        for (Product product : products) {
            discountedPrice+=product.getDiscountedPrice();
        }
        System.out.println("Total discountedPrice of items in cart is "+discountedPrice);
        return discountedPrice;
    }
    public int calculatePrice(){
        System.out.println("calculating totalPrice of items in cart");
        int totalPrice=0;
        for(Product product : products){
            totalPrice+=product.getPrice();
        }
        System.out.println("Total totalPrice of items in cart is "+totalPrice);
        return totalPrice;
    }
}

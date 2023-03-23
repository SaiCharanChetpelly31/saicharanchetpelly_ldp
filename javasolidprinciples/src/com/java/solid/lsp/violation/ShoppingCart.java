package com.java.solid.lsp.violation;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }
    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            if(product instanceof  DiscountedProduct){
                totalPrice+= ((DiscountedProduct) product).getDiscountPrice(10);
            }
            else{
                totalPrice+=product.getPrice();
            }
        }
        return totalPrice;
    }
}

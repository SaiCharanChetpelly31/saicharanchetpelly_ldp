package com.java.solid.lsp3.corrected;

public interface ProductInter {
    void setPrice(int price);
    void setShippingCharges(int charges);

    int calculateTotalPrice();
}

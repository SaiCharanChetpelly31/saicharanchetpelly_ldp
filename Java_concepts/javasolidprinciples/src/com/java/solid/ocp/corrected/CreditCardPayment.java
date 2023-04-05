package com.java.solid.ocp.corrected;

public class CreditCardPayment implements  Payableinterface {

    @Override
    public void pay() {
        System.out.println("Please wait payment in progress...");
        //pay with creditcard
        System.out.println("paying using creditcard");
    }
}

package com.java.solid.ocp.corrected;

public class CreditCardPayment implements  Payableinterface {

    @Override
    public void pay() {
        //pay with creditcard
        System.out.println("paying using creditcard");
    }
}

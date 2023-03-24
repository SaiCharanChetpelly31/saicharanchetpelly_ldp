package com.java.solid.ocp.corrected;

public class DebitCardPayment implements Payableinterface {

    @Override
    public void pay() {
        System.out.println("Please wait payment in progress...");
        //pay with debitcard
        System.out.println("paying using debitcard");
    }
}

package com.java.solid.ocp.corrected;

public class DebitCardPayment implements Payableinterface {

    @Override
    public void pay() {
        //pay with debitcard
        System.out.println("paying using debitcard");
    }
}

package com.java.solid.ocp.violation;

public class Payment {
    public void pay(String payType){
        if(payType.equals("creditcard")) {
            //pay using credit card
            return;
        }
        else if(payType.equals("debitcard")){
            //pay using debit card
        }

        //if we want to add a new paymentType
        else if(payType.equals("payWithPoints")){
            //pay using cashbackpoints
        }
    }
}

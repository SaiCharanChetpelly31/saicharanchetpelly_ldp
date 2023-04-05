package com.java.solid.ocp.corrected;

public class Main {
    public static void main(String[] args) {
        Payableinterface creditCardPayment = new CreditCardPayment();
        Payableinterface debitCardPayment = new DebitCardPayment();
        Payableinterface cashBackPayment = new CashbackPointsPayment();
        creditCardPayment.pay();
        debitCardPayment.pay();
        cashBackPayment.pay();
    }
}

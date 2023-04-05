package com.java.solid.isp.violation;

public class Phonepe implements PaymentMethods {

    @Override
    public void payMoney(int total) {
        System.out.println("online payment of "+total+" through phonepe");
    }

    @Override
    public void scrachCardPayment() {
        System.out.println("scratchcard payment of  money through phonepe");
    }

    //not applicable
    @Override
    public void getCashBackAsCreditBalance() {
        System.out.println("cashback points  payment of  money through phonepe");
    }
}

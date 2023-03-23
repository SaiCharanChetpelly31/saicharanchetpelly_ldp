package com.java.solid.ocp.corrected;

public class CashbackPointsPayment  implements  Payableinterface{
    @Override
    public void pay() {
        //pay with points
        System.out.println("paying using Cashbackpoints");
    }
}

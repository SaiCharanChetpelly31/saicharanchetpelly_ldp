package com.java.solid.dip.corrected;

public class CreditCard implements BankCard{

    public void doTransaction(long amount){
        System.out.println("Paid "+amount+" succesfully using Credit card");
    }
}

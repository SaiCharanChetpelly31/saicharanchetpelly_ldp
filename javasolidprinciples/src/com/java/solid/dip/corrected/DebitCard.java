package com.java.solid.dip.corrected;

public class DebitCard implements BankCard{

    public void doTransaction(long amount){
        System.out.println("Paid "+amount+" succesfully using Debit card");
    }
}
package com.java.solid.dip.corrected;

public class PayAmount {

    private BankCard bankCard;

    public PayAmount(BankCard bankCard) {

        this.bankCard = bankCard;
    }

    public void pay(long amount){

        bankCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        BankCard bankCard=new CreditCard();
        PayAmount website=new PayAmount(bankCard);
        website.pay(5000);
    }
}

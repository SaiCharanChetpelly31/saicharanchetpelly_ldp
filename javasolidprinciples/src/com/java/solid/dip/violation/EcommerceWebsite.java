package com.java.solid.dip.violation;


public class EcommerceWebsite {
    private DebitCard debitCard;
//    private CreditCard creditCard;
    public EcommerceWebsite(DebitCard debitCard) {

        this.debitCard = debitCard;
//        this.creditCard = creditCard;
    }

    public void doPurchaseSomething(long amount){

        debitCard.doTransaction(amount);
//        creditCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        DebitCard debitCard=new DebitCard();
//        CreditCard creditCard = new CreditCard();
        EcommerceWebsite website=new EcommerceWebsite(debitCard);
        website.doPurchaseSomething(5000);
    }
}

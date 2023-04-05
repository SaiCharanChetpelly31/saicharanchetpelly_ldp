package com.example.bank;

public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double accountBalance;

    public BankAccount(int accountNumber, String accountHolderName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(123456, "Sai Charan Chetpelly", 10000.00);
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder Name: " + account.getAccountHolderName());
        System.out.println("Account Balance: " + account.getAccountBalance());
        account.setAccountHolderName("Sai Charan");
        account.setAccountBalance(15000.00);
        System.out.println("Updated Account Holder Name: " + account.getAccountHolderName());
        System.out.println("Updated Account Balance: " + account.getAccountBalance());
    }
}

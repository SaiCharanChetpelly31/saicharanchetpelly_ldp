package abstraction;

import java.util.ArrayList;

// Bank class represents a bank
public class Bank {
    private ArrayList<BankAccount> accounts;

    // Constructor for creating a new bank
    public Bank() {
        accounts = new ArrayList<BankAccount>();
    }

    // Method to add a new account to the bank
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }


    // Method to get the total balance of all accounts in the bank
    public double getTotalBalance() {
        double totalBalance = 0.0;
        for (BankAccount account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }
}


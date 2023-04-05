package abstraction;
// BankAccount class represents a bank account
public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor for creating a new bank account
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Method to get the account balance
    public double getBalance() {
        return balance;
    }
}

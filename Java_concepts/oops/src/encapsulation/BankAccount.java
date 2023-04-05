package encapsulation;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String ownerName;
    private String ownerAddress;

    // Constructor to initialize account details
    public BankAccount(String accountNumber, double balance, String ownerName, String ownerAddress) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    // Method to deposit money into account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw money from account
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

package encapsulation;

public class Bank {
    public static void main(String[] args) {
        // Creating a Bank Account object
        BankAccount account = new BankAccount("1234567890", 5000.0, "Sai Charan", "24-21 Hyderabad");

        // Depositing and Withdrawing money from account
        account.deposit(1000.0);
        account.withdraw(2000.0);

        // Printing account details
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Owner Name: " + account.getOwnerName());
        System.out.println("Owner Address: " + account.getOwnerAddress());
        System.out.println("Balance: " + account.getBalance());
    }
}

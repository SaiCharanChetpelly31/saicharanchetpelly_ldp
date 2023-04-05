package abstraction;

// Main class to test the program
public class Main {
    public static void main(String[] args) {
        // Create a bank
        Bank bank = new Bank();

        // Create some bank accounts
        BankAccount account1 = new BankAccount("123456789", "John Smith");
        BankAccount account2 = new BankAccount("987654321", "Jane Doe");

        // Add the accounts to the bank
        bank.addAccount(account1);
        bank.addAccount(account2);

        // Deposit some money into the accounts
        account1.deposit(1000.0);
        account2.deposit(500.0);

        // Withdraw some money from the accounts
        account1.withdraw(500.0);
        account2.withdraw(200.0);

        // Print the account balances
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());

        // Print the total balance of all accounts in the bank
        System.out.println("Total balance: " + bank.getTotalBalance());
    }
}

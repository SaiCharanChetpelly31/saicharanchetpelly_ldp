package datahiding;

public class BankAccount {
    private double accountBalance = 10000.0;
    private String userName;
    private String userPassword;

    public BankAccount(String userName,String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }
    public double getBalance(String userName,String userPassword){
        if(this.userName.equals(userName) && (this.userPassword.equals(userPassword))){
            return this.accountBalance;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Saicharan","password");
        System.out.println(account.getBalance("Saicharan","password"));
    }
}

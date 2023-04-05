package encapsulation;

public class Account {
    private double balance=10000.0;

    public void setBalance(double balance){
        //validation
        this.balance = balance;
        //some more implementation
    }

    public double getBalance(){
        //validate
        return this.balance;
    }

    public static void main(String[] args) {
        Account myAccount = new Account();
        System.out.println(myAccount.getBalance());
        myAccount.setBalance(20000.0);
        System.out.println(myAccount.getBalance());
    }
}

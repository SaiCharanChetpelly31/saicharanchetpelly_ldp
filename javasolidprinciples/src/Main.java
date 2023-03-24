import com.java.solid.dip.corrected.BankCard;
import com.java.solid.dip.corrected.CreditCard;
import com.java.solid.dip.corrected.PayAmount;
import com.java.solid.isp.violation.Phonepe;
import com.java.solid.lsp.violation.DiscountedProduct;
import com.java.solid.lsp.violation.Product;
import com.java.solid.lsp.violation.ShoppingCart;
import com.java.solid.ocp.corrected.CreditCardPayment;
import com.java.solid.ocp.corrected.Payableinterface;
import com.java.solid.srp.corrected.DisplayUser;
import com.java.solid.srp.corrected.StoreData;
import com.java.solid.srp.corrected.ValidateUser;
import com.java.solid.srp.violation.UserData;

public class Main {
    public static void main(String[] args)  throws Exception{
        System.out.println("Following SOLID principles...");
        Thread.sleep(1000);
        ValidateUser validateUser = new ValidateUser();

       if( validateUser.isUserValidated("Saicharan","password")){
           Thread.sleep(1000);
           System.out.println("User is validated succesfully");
       }
       else{
           Thread.sleep(1000);
           System.out.println("Not a valid username or password");
       }
        Thread.sleep(1000);
        StoreData data = new StoreData();
       data.store("Saicharan","password");
        Thread.sleep(1000);
        DisplayUser display = new DisplayUser();
        display.displayUser("Saicharan","password");

        ShoppingCart myCart = new ShoppingCart();
        Product product1 = new Product("Laptop",35000);
        Thread.sleep(1000);
        Product product2 = new Product("Book",100);
        Thread.sleep(1000);
        Product product3 = new DiscountedProduct("Mobile",10000,10);
        Thread.sleep(1000);

        myCart.addProduct(product1);
        Thread.sleep(1000);
        myCart.addProduct(product2);
        Thread.sleep(1000);
        myCart.addProduct(product3);

        int totalPrice = myCart.calculateTotalPrice();

        Payableinterface creditCardPayment = new CreditCardPayment();
        creditCardPayment.pay();
        Thread.sleep(1000);
        BankCard bankCard=new CreditCard();
        PayAmount payment = new PayAmount(bankCard);
        Thread.sleep(1000);
        payment.pay(totalPrice);


        //By violating SOLID principles
        System.out.println("By violating SOLID principles");
        Thread.sleep(1000);
        UserData user = new UserData();
        if( user.isUserValidated("Saicharan","password")){
            Thread.sleep(1000);
            System.out.println("User is validated succesfully");
        }
        else{
            Thread.sleep(1000);
            System.out.println("Not a valid username or password");
        }
        Thread.sleep(1000);
        user.store("Saicharan","password");
        Thread.sleep(1000);
        user.displayUser("Saicharan","password");

        ShoppingCart cart = new ShoppingCart();
        Product prod1 = new Product("Laptop",35000);
        Thread.sleep(1000);
        Product prod2 = new Product("Book",100);
        Thread.sleep(3000);
        //internally it checks if product instance is of type DiscountedPrice,But what if another type of product is created?
        //Here it is failing lsp, Product type is not Substituable for DiscountedPrice subtyoe
        Product prod3 = new DiscountedProduct("Mobile",10000,10);

        cart.addProduct(prod1);
        Thread.sleep(1000);
        cart.addProduct(prod2);
        Thread.sleep(1000);
        cart.addProduct(prod3);
        int total= cart.calculateTotalPrice();
        Thread.sleep(2000);

        //suppose user want to pay amount by credit card,but there implementaion for only debit card.In this case ocp and dip is failing.
        //Because PayAmount is tightly coupled with debit card payment.

        //If user want to pay through phonepe or paytm. The phonepe doesnt support cashback payments.
        Phonepe phonepe = new Phonepe();
        Thread.sleep(4000);
        phonepe.payMoney(total);

    }
}
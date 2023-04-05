package slap.corrected;

public class Slap {
    public static void main(String[] args) {
        getDetailsAndMail();
    }
    public static void getDetailsAndMail(){
        //fetch details from database
        System.out.println("fetching details from db");
        sendMail("Your details are");
    }
    public static void sendMail(String message){
        System.out.println("sending mail to user"+message);
    }
}

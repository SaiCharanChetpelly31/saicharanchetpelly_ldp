package slap.violated;

public class Slap {
    public static void main(String[] args) {
        getDetailsAndMail();
    }
    public static void getDetailsAndMail(){
        //fetch details from database
        System.out.println("details fetched succesfully");

        //mail the user
        System.out.println("sending mail to user");
    }
}

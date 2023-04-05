package customizedexception.case3;
//case3
//
public class ExceptionClass43 {
    public static void main(String[] args) {
        try{
            System.out.println("statement1");
            System.out.println(10/0);
            System.out.println("statement3");
        }
        catch(NullPointerException e){
            System.out.println("statement4");
        }
        System.out.println("statement5");
    }
}

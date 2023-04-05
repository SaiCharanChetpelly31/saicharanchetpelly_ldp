package customizedexception.case4;

public class Example {
    public static void main(String[] args) {
        try{
            System.out.println("statement1");
            System.out.println(10/0);
            System.out.println("statement3");
        }
        catch(Exception e){
            System.out.println(10/0);
        }
        System.out.println("statement5");
    }
}

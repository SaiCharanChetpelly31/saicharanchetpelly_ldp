package printmethods;

public class Method3 {
    public static void main(String[] args) {
        try{
            System.out.println(10/0);
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}

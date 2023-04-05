package printmethods;

public class Method1 {
    public static void main(String[] args) {
        try{
            System.out.println(10/0);
        }
        catch (ArithmeticException e){
            e.printStackTrace();
        }
    }
}

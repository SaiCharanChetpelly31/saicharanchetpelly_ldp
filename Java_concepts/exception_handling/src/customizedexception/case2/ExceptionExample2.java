package customizedexception.case2;
//casse2
//if exception arised at
public class ExceptionExample2 {
    public static void main(String[] args) {
        try{
            System.out.println("statement1");
            System.out.println(10/0);
            System.out.println("statement3");
        }
        catch(Exception e){
            System.out.println("statement4");
        }
        System.out.println("statement5");
    }
}

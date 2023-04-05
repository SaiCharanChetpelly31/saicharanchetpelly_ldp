package customizedexception.case1;
//case1
//if no exception arised and corresponidng catch blovk matched
public class CustomizedExample1 {
    public static void main(String[] args) {
        try{
            System.out.println("statement1");
            System.out.println("statement2");
            System.out.println("statement3");
        }
        catch(Exception e){
            System.out.println("statement4");
        }
        System.out.println("statement5");
    }
}

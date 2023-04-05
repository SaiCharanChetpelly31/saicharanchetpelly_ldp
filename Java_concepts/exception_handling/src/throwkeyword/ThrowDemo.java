package throwkeyword;

public class ThrowDemo {
    public static void main(String[] args) {
        ArithmeticException e1 = new ArithmeticException();
//        throw e1;
//        throw new ThrowDemo("/ by zero");
        throw new ArithmeticException("division by zero");
    }
}

package assignment8;

// Create three new types of exceptions
class MyException1 extends Exception {}
class MyException2 extends Exception {}
class MyException3 extends Exception {}

public class ExceptionDemo {
    public static void throwExceptions() throws MyException1, MyException2, MyException3 {
        // Throw all three exceptions in one method
//        throw new MyException1();
         throw new MyException2();
        // throw new MyException3();
    }

    public static void main(String[] args) {
        try {
            throwExceptions();
//            throw new NullPointerException();
        } catch (Exception e) { // Use a single catch clause to catch all three types of exceptions
            e.printStackTrace();
        } finally {
            System.out.println("Finally clause executed");
        }
    }
}

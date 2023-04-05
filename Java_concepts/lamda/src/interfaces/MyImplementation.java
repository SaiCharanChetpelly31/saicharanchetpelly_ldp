package interfaces;


public class MyImplementation implements MyInterface {
    @Override
    public void existingMethod() {
        System.out.println("This is an existing method implementation.");
    }

    public static void main(String[] args) {
        MyImplementation obj = new MyImplementation();
        obj.existingMethod(); // Output: This is an existing method implementation.
        obj.newMethod(); // Output: This is a default method.
        MyInterface.staticMethod(); // Output: This is a static method.
    }
}

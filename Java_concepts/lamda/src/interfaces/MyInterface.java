package interfaces;

@FunctionalInterface
public interface MyInterface {
    void existingMethod();
    default void newMethod() {
        System.out.println("This is a default method.");
    }
    static void staticMethod() {
        System.out.println("This is a static method.");
    }
}

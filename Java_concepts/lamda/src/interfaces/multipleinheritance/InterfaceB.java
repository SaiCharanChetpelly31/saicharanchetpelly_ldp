package interfaces.multipleinheritance;

public interface InterfaceB {
    default void methodB() {
        System.out.println("Method B");
    }
}
package interfaces.multipleinheritance;

public interface InterfaceA {
    default void methodA() {
        System.out.println("Method A");
    }
}

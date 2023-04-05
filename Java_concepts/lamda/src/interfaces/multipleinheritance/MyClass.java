package interfaces.multipleinheritance;

public class MyClass implements InterfaceA, InterfaceB {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.methodA(); // Output: Method A
        obj.methodB(); // Output: Method B
    }
}

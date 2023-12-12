package singleton.enums;

public class Main {
    public static void main(String[] args) {
        SingletonDemo singletonDemo = SingletonDemo.INSTANCE;
        System.out.println(singletonDemo.hashCode());
        SingletonDemo singletonDemo2 = SingletonDemo.INSTANCE;
        System.out.println(singletonDemo2.hashCode());

    }
}

public class Demo1 {
    public static void main(String[] args) {
        FunctionalInterface1 i = () -> System.out.println("Hello... By lamda expression");
        i.m1();

        FunctionalInterface2 i2 = (a,b) -> System.out.println(a+b);
        i2.add(10,20);
    }
}

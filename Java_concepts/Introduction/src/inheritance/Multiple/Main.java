package inheritance.Multiple;

public class Main implements Interface1,Interface2 {
    @Override
    public void method1() {
        Interface1.super.method1();
        Interface2.super.method1();
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.method1();
    }
}

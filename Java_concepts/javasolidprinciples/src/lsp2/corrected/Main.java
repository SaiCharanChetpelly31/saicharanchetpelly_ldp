package lsp2.corrected;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Rectangle();
        shape.setWidth(10);
        shape.setHeight(2);
        shape.setWidth(11);
        System.out.println(shape.area());

        Shape shape1 = new Square();
        shape1.setWidth(5);
        shape1.setHeight(5);
        shape1.setWidth(6);
        System.out.println(shape1.area());
    }
}


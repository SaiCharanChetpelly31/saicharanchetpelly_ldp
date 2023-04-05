package lsp2.violation;

import org.w3c.dom.css.Rect;

public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        rect.setWidth(10);
        rect.setHeight(2);
        rect.setWidth(11);
        System.out.println(rect.area());

        Rectangle rect1 = new Square();
        rect1.setHeight(5);
        rect1.setWidth(5);
        rect1.setHeight(6);
        System.out.println(rect1.area());

    }
}

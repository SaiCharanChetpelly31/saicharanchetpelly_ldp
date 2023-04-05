package functions;

import java.util.function.Consumer;

public class ConsumerFnInterfaceDemo {
    public static void main(String[] args) {
        Consumer<Integer> printNumber = n -> System.out.println(n);
        Consumer<Integer> printNumberSqaure = n -> System.out.println(n*n);
        //accept
        printNumber.accept(5);
        printNumberSqaure.accept(5);

        //andThen -default method in Comsumer
        Consumer<Integer> printNumberAndSquare = printNumber.andThen(printNumberSqaure);
        printNumberAndSquare.accept(5);


    }
}

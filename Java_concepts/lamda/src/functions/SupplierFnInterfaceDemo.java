package functions;

import java.util.function.Supplier;

public class SupplierFnInterfaceDemo {
    public static void main(String[] args) {
        Supplier<String[]> fruitSuppier = () -> new String[]{"Apple","Orange"};
        String fruits[] = fruitSuppier.get();
        for(String fruit : fruits){
            System.out.println(fruit);
        }
    }
}

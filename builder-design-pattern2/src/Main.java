public class Main {
    public static void main(String[] args) {
        Director director = new
                Director();
        Product product = director.createProduct(new ProductBuilder());
        System.out.println(product);
        Product product1 = director.createProduct(new ManualBuilder());
        System.out.println(product1);
    }
}
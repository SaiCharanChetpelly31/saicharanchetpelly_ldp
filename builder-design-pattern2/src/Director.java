public class Director {
    private Product product;
    //creating product
    public Product createProduct(ProductBuilder productBuilder){
        Product product = new ProductBuilder()
                .setProductId(1)
                .setProductTitle("Realme")
                .build();
        return product;
    }

    public Product createProduct(ManualBuilder manualBuilder){
        Product product = new ManualBuilder()
                .setProductId(1)
                .setProductTitle("Car")
                .setModel("Nano")
                .build();
        return product;
    }
}

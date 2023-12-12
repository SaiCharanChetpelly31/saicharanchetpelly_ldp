public class ProductBuilder implements IProduct {
    private Product product;

    public ProductBuilder() {
        this.product = new Product();
    }

    @Override
    public ProductBuilder setProductId(int productId) {
        product.setProductId(productId);
        return this;
    }

    @Override
    public ProductBuilder setProductTitle(String productTitle) {
        product.setProductTitle(productTitle);
        return this;
    }

    @Override
    public ProductBuilder setModel(String model) {
        product.setModel(model);
        return this;
    }

    @Override
    public Product build(){
        return this.product;
    }
}

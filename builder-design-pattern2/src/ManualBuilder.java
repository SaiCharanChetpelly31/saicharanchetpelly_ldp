public class ManualBuilder implements IProduct{
    private Product product;

    public ManualBuilder() {
        this.product = new Product();
    }

    @Override
    public IProduct setProductId(int productId) {
        product.setProductId(productId);
        return this;
    }

    @Override
    public IProduct setProductTitle(String productTitle) {
        product.setProductTitle(productTitle);
        return this;
    }

    @Override
    public IProduct setModel(String model) {
        product.setModel(model);
        return this;
    }

    @Override
    public Product build() {
        return this.product;
    }
}

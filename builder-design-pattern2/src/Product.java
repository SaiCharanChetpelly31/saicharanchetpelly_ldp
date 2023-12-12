public class Product {
    private int productId;
    private String productTitle;
    private String model;

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

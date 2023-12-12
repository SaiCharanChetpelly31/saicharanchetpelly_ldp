public interface IProduct {
    IProduct setProductId(int productId);
    IProduct setProductTitle(String productTitle);
    IProduct setModel(String model);
    Product build();
}

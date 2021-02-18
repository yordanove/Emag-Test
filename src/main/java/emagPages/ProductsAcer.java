package emagPages;

public enum ProductsAcer {
    ACER_PRODUCT1("Лаптоп Gaming ACER Nitro 5 AN515-54, 15.6&quot;, Intel® Core™ i5-9300H, RAM 8GB, SSD 256GB, NVIDIA® GeForce® GTX 1650 4GB, Linux, Black"),
    ACER_PRODUCT2("Лаптоп Acer Aspire 3 A315-57G-55GP с Intel Core i5-1035G1 (1.0/3.6 GHz, 6M), 8 GB, 512GB M.2 NVMe SSD, NVIDIA MX330 2 GB GDDR5, Free DOS, тъмносин");

    private final String products;
    private String value;

    ProductsAcer(String product){
        this.products = product;
    }

    public String getAcerProducts() {
        return this.products;
    }
}

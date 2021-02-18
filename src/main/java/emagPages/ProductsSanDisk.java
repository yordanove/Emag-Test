package emagPages;

public enum ProductsSanDisk {
    SAN_DISK_PRODUCT1("Карта памет SanDisk Ultra MicroSDXC, 128GB, UHS-I, Клас 10, 80MB/s + Адаптер"),
    SAN_DISK_PRODUCT2("Карта памет SanDisk Extreme SDXC, 128GB, Class 10, UHS-I/U3, 150MB/s");

    private final String products;
    private String value;

    ProductsSanDisk(String product){
        this.products = product;
    }

    public String getSanDiskProducts() {
        return this.products;
    }
}

public class Product {
    public static int INDEX = 0;
    private int productID;
    private String name;
    private int price;
    private int quantity;
    private String description;
    public Product(String name, int price, int quantity, String description) {
        this.productID = ++INDEX;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public static int getINDEX() {
        return INDEX;
    }
    public static void setINDEX(int INDEX) {
        Product.INDEX = INDEX;
    }

    @Override
    public String toString() {
        return "Product: " +
                "id: " + productID +
                ", name='" + name + '\'' +
                ", price: " + price +
                ", quantity: " + quantity +
                ", description: " + description + '\'' +
                ".";
    }
}

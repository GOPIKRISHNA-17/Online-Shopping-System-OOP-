public abstract class Product {
    private String productID; // Unique identifier for the product
    private String productName; // Name of the product
    private int numOfAvailableItems; // Number of available items in stock
    private double price; // Price of the product
    private int quantity; // Quantity of the product (used in the second constructor)
    private String category; // Category of the product

    // Constructor for initializing product details with productID, productName, numOfAvailableItems, price, and category
    public Product(String productID, String productName, int numOfAvailableItems, double price, String category) {
        this.productID = productID;
        this.productName = productName;
        this.numOfAvailableItems = numOfAvailableItems;
        this.price = price;
        this.category = category;
    }

    // Constructor for initializing product details with productName, price, and quantity
    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Default constructor (protected) for subclasses
    protected Product() {
    }

// Getter and setter methods for each attribute

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumOfAvailableItems() {
        return numOfAvailableItems;
    }

    public void setNumOfAvailableItems(int numOfAvailableItems) {
        this.numOfAvailableItems = numOfAvailableItems;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void displayProductInfo() {
        // Method to display product information, yet to be implemented
    }

}

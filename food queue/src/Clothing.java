public class Clothing extends Product {
    private String size; // Size of the clothing product
    private String color; // Color of the clothing product

    // Constructor for initializing clothing details with category, productID, productName, price, numOfAvailableItems, size, and color
    public Clothing(String category, String productID, String productName, double price, int numOfAvailableItems, String size, String color) {
        super(productID, productName, numOfAvailableItems, price, category);
        this.size = size;
        this.color = color;
    }

// Getter and setter methods for size attribute

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

// Getter and setter methods for color attribute

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Override method to display clothing product information
    @Override
    public void displayProductInfo() {
        System.out.println("Clothing Product - " + getProductName());
        System.out.println("Product ID: " + getProductID());
        System.out.println("Size: " + size);
        System.out.println("Color: " + color);
        System.out.println("Available Items: " + getNumOfAvailableItems());
        System.out.println("Price: $" + getPrice());
    }

}

import java.util.Date;

public class Electronics extends Product{
    private String brand; // Brand of the electronics product
    private Date issueDate; // Date when the electronics product was issued
    private int warrantyPeriod; // Warranty period in months

    // Constructor for initializing electronics details with category, productID, productName, productPrice, productQuantity, and brand
    public Electronics(String category, String productID, String productName, double productPrice, int productQuantity, String brand) {
        super(productID, productName, productQuantity, productPrice, category);
        this.brand = brand;
    }

// Getter and setter methods for each attribute

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    // Override method to display electronics product information
    @Override
    public void displayProductInfo() {
        System.out.println("Electronics Product - " + getProductName());
        System.out.println("Product ID: " + getProductID());
        System.out.println("Brand: " + brand);
        System.out.println("Warranty Period: " + warrantyPeriod + " months");
        System.out.println("Available Items: " + getNumOfAvailableItems());
        System.out.println("Price: $" + getPrice());
    }

}

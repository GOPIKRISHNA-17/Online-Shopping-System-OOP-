import java.util.ArrayList;


public class ShoppingCart {

    // ArrayList to store the products in the shopping cart
    ArrayList<Product> listOfProduct = new ArrayList<>();

    // Method to add an item to the shopping cart
    public void addItem(Product item) {
        listOfProduct.add(item);
        System.out.println("Product added to the Shopping Cart Successfully!");
    }

    // Method to remove an item from the shopping cart
    public void removeItem(Product item) {
        // Check if the item is present in the cart
        if (listOfProduct.contains(item)) {
            listOfProduct.remove(item);
            System.out.println("Product removed from the Shopping Cart Successfully!");
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

    // Method to calculate the total cost of items in the shopping cart
    public double calculateTotal() {
        double totalCost = 0;

        // Iterate through each product in the cart and accumulate the total cost
        for (Product product : listOfProduct) {
            totalCost += product.getPrice();
        }

        return totalCost;
    }
}

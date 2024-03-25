import javax.swing.*;
import java.io.*;
import java.util.*;

public class WestminsterShoppingManager implements shoppingManager {
    public static final ArrayList<Product> productList = new ArrayList<>(50); // List to store products with a capacity of 50
    Scanner scanner = new Scanner(System.in); // Scanner for user input
    private final GUI gui; // GUI object for interacting with the graphical user interface

    // Constructor for WestminsterShoppingManager, taking a GUI object as a parameter
    public WestminsterShoppingManager(GUI gui) {
        this.gui = gui;
    }

    // Method to display the main menu and handle user input
    public void displayMenu() {
        while (true) {
            try {
                // Display the menu options
                System.out.println("-------------------------------------------");
                System.out.println("\nMenu Cart:");
                System.out.println("1. Add a new product to list");
                System.out.println("2. Delete from  product list");
                System.out.println("3. view the list of products");
                System.out.println("4. Save products to file load");
                System.out.println("5. Open Graphical user interface");
                System.out.println("6. Exit");
                System.out.println("-------------------------------------------");

                System.out.print("Enter your choice: ");

                // Check if the user input is an integer
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();

                    // Perform the corresponding action based on the user's choice
                    if (choice == 1) {
                        addProductFromConsole();
                    } else if (choice == 2) {
                        deleteProductFromConsole();
                    } else if (choice == 3) {
                        printProducts();
                    } else if (choice == 4) {
                        storeProducts();
                    } else if (choice == 5) {
                        gui.updateProductTable(productList);
                        gui.setVisible(true);
                    } else if (choice == 6) {
                        System.out.println("Exiting the application.");
                        System.exit(0);
                    } else {
                        System.out.println("Invalid choice. Please enter a valid option.");
                    }

                }
                 else {
                    System.out.println("Invalid input. Please enter a valid integer option.");
                    scanner.next(); // Consume the invalid input to prevent an infinite loop
                }
            } catch (Exception e) {
                System.out.println("An error occurred. .");
                scanner.nextLine(); // Consume any remaining input
            }
        }
    }

    // Method to add a new product from the console
    public void addProductFromConsole() {
        // Check if the productList is full
        if (productList.size() < 50) {
            // Prompt user for product information
            System.out.println("\n1. Add a new product");
            int productType;
            // Validate product type input
            while (true) {
                try {
                    System.out.print("Enter product type (1 for Electronics, 2 for Clothing): ");
                    productType = scanner.nextInt();

                    if (productType != 1 && productType != 2) {
                        System.out.println("\nEnter 1 or 2\n");
                    } else {
                        break; // Exit the loop if a valid product type is entered
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid product type.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }

            // Prompt user for common product information
            String productID;
            while (true) {
                try {
                    System.out.print("Enter product ID: ");
                    productID = scanner.next();
                    break; // Exit the loop if a valid product ID is entered
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid product ID.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
            String productName;
            while (true) {
                try {
                    System.out.print("Enter product name: ");
                    productName = scanner.next();
                    break; // Exit the loop if a valid product name is entered
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid product name.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
            double productPrice;
            while (true) {
                try {
                    System.out.print("Enter product price: ");
                    productPrice = scanner.nextDouble();
                    break; // Exit the loop if a valid product price is entered
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid product price.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
            int productQuantity;
            while (true) {
                try {
                    System.out.print("Enter product quantity: ");
                    productQuantity = scanner.nextInt();
                    break; // Exit the loop if a valid product quantity is entered
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid product quantity.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }

            // Add Electronics or Clothing based on the productType
            if (productType == 1) {
                String brand;
                String category = "Electronics";
                // Prompt user for electronics-specific information
                while (true) {
                    try {
                        System.out.print("Enter electronics brand: ");
                        brand = scanner.next();
                        break; // Exit the loop if a valid brand is entered
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid brand.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                }
                // Add Electronics to the productList
                productList.add(new Electronics(category, productID, productName, productPrice, productQuantity, brand));
                System.out.println("Product Successfully added!");
            } else {
                String size = null;
                String color = null;
                String category = "Clothing";
                // Prompt user for clothing-specific information
                while (true) {
                    try {
                        System.out.print("Enter clothing size: ");
                        size = scanner.next();
                        break; // Exit the loop if a valid size is entered
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid size.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                }
                while (true) {
                    try {
                        System.out.print("Enter clothing color: ");
                        color = scanner.next();
                        break; // Exit the loop if a valid color is entered
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid color.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                }
                // Add Clothing to the productList
                productList.add(new Clothing(category, productID, productName, productPrice, productQuantity, size, color));
                System.out.println("Product Successfully added!");
            }
        } else {
            // Display a message if the productList is full
            System.out.println("Array is Full!");
        }
    }

    // Method to delete a product from the console
    public void deleteProductFromConsole() {
        // Display the delete product menu
        System.out.println("\n2. Delete a product");
        // Print the current list of products
        printProducts();
        String productId;
        // Prompt user for the product ID to delete
        while (true) {
            try {
                System.out.print("Enter product ID to delete: ");
                productId = scanner.next();
                break; // Exit the loop if a valid product ID is entered
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid product ID.");
                scanner.nextLine(); // Consume the invalid input
            }


        }
        // Iterate through productList to find and delete the product
        for (Product product : productList) {
            if (product.getProductID().equals(productId)) {
                System.out.println("Product Successfully Deleted!");
                System.out.println("Deleted Product Information:");
                product.displayProductInfo();
                productList.remove(product);
                System.out.println("Total number of products left: " + productList.size());
                return;
            }
        }
        // Display a message if the product is not found
        System.out.println("Product not found.");
    }

    // Method to print the list of products
    public void printProducts() {
        try {
            // Display the print products menu
            System.out.println("\n3. Print the list of products");
            // Sort productList by product ID
            Collections.sort(productList, Comparator.comparing(Product::getProductID));
            int productIndex = 1;
            // Iterate through productList and display each product's information
            for (Product product : productList) {
                System.out.println();
                System.out.println("\nProduct " + productIndex + ":"); // Indicate the product number
                productIndex++;
                if (product instanceof Electronics) {
                    System.out.println("Electronics - " + product.getProductID());
                } else if (product instanceof Clothing) {
                    System.out.println("Clothing - " + product.getProductID());
                }
                product.displayProductInfo();
            }
        } catch (Exception e) {
            // Display an error message if an error occurs while printing the list
            System.out.println("Sorry, an error occurred while printing the list.");
        }
    }

    // Method to store products to a file
    public void storeProducts() {
        try {
            // Display the store products menu
            System.out.println("\n4. Save products to a file");
            // Create a new file "ProductDetails.txt" if it doesn't exist
            File details = new File("ProductDetails.txt");
            details.createNewFile();
            // Create a FileWriter to write product details to the file
            FileWriter writer = new FileWriter(details.getName());
            // Write header information to the file
            writer.write("** PRODUCT DETAILS **");
            writer.write("\n");
            writer.write("Product Details : ");
            writer.write("\n");
            writer.write("\n");

            // Call private method to write products to the file
            writeProducts(writer);

            // Display success message
            System.out.println("Successfully written!");
            writer.close(); // Close the FileWriter
        } catch (IOException e) {
            // Display an error message if an error occurs while storing products to a file
            System.out.println("An error occurred while storing products to a file.");
        }
    }

    // Private method to write products to a FileWriter
    private void writeProducts(FileWriter writer) throws IOException {
        // Iterate through each product in the list and write its information to the file
        for (Product product : productList) {
            writer.write("➤ Product ID: " + product.getProductID());
            writer.write("  Product Name: " + product.getProductName());
            writer.write("  Category: " + product.getCategory());
            writer.write("  Price: " + product.getPrice());
            writer.write("\n");
        }
    }
}

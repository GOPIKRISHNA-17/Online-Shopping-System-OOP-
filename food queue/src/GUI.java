import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {

    // Declare a private JLabel to represent the selected product label in the UI
    private JLabel selectedProductLabel;

    // Declare a private JTable to display product information in the UI
    private JTable productTable;

    // Declare a private JTable to represent the shopping cart table in the UI
    private JTable shoppingCartTable;

    public GUI() {
        // Set the title of the frame
        setTitle("Westminster Shopping Center");

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a content panel with GridBagLayout
        JPanel contentPanel = new JPanel(new GridBagLayout());

        // Header panel (20% height)

        // Create a JPanel for the header with a right-aligned FlowLayout
        JPanel headerPanel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

// Create a JButton for the "Shopping Cart" and add an ActionListener to open the shopping cart
        JButton shoppingCartButton = new JButton("Shopping Cart");
        shoppingCartButton.addActionListener(e -> openShoppingCart());

// Add the shoppingCartButton to the headerPanel1 with a right-aligned layout
        headerPanel1.add(shoppingCartButton, BorderLayout.EAST);

// Set up GridBagConstraints for the headerPanel1 in the main content panel
        GridBagConstraints gbcHeader = new GridBagConstraints();
        gbcHeader.gridx = 0;            // X position in the grid
        gbcHeader.gridy = 0;            // Y position in the grid
        gbcHeader.weighty = 0.01;       // 10% of the height
        gbcHeader.fill = GridBagConstraints.BOTH;  // Allow the component to grow both horizontally and vertically
        contentPanel.add(headerPanel1, gbcHeader);  // Add the headerPanel1 to the main content panel


        // Create a JPanel for the second header with a centered FlowLayout
        JPanel headerPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

// Create a JLabel for the category selection
        JLabel categoryLabel = new JLabel("Select Category:");

// Add the categoryLabel to the headerPanel2 with a centered layout
        headerPanel2.add(categoryLabel, BorderLayout.CENTER);

// Create an array of category options
        String[] categories = {"All", "Electronics", "Clothing"};

// Create a JComboBox for category selection and add it to the headerPanel2 with a centered layout
        JComboBox<String> categoryDropdown = new JComboBox<>(categories);
        headerPanel2.add(categoryDropdown, BorderLayout.CENTER);

// Add an ActionListener to the categoryDropdown to update the product table based on the selected category
        categoryDropdown.addActionListener(e -> {
            String selectedCategory = (String) categoryDropdown.getSelectedItem();
            updateProductTable2(WestminsterShoppingManager.productList, selectedCategory);
        });

// Set up GridBagConstraints for the headerPanel2 in the main content panel
        GridBagConstraints gbcHeader2 = new GridBagConstraints();
        gbcHeader2.gridx = 0;           // X position in the grid
        gbcHeader2.gridy = 1;           // Y position in the grid
        gbcHeader2.weighty = 0.1;        // 10% of the height
        gbcHeader2.fill = GridBagConstraints.BOTH;  // Allow the component to grow both horizontally and vertically
        contentPanel.add(headerPanel2, gbcHeader2);  // Add the headerPanel2 to the main content panel


        // Table panel (40% height)
        // Create a JPanel for the table with a BorderLayout
        JPanel tablePanel = new JPanel(new BorderLayout());

// Define the headings for the table
        String[] tableHeadings = {"Product ID", "Name", "Category", "Price(£)", "Info"};

// Create a 2D array for table data
        Object[][] tableData = new Object[5][5];

// Create a DefaultTableModel with the specified data and headings
        DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeadings);

// Create a JTable with the default model
        productTable = new JTable(tableModel);

// Set the preferred size of the scrollable viewport for the table
        productTable.setPreferredScrollableViewportSize(new Dimension(500, 100));

// Create a JScrollPane and add the productTable to it
        JScrollPane scrollPane = new JScrollPane(productTable);

// Add the scrollPane to the tablePanel at the center position
        tablePanel.add(scrollPane, BorderLayout.CENTER);

// Add a ListSelectionListener to the productTable to handle row selection
        productTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Get the selected row index
                    int selectedRow = productTable.getSelectedRow();

                    if (selectedRow != -1) {
                        // Get the data from the selected row
                        String productID = productTable.getValueAt(selectedRow, 0).toString();
                        String productName = productTable.getValueAt(selectedRow, 1).toString();
                        String category = productTable.getValueAt(selectedRow, 2).toString();
                        String price = productTable.getValueAt(selectedRow, 3).toString();
                        String info = productTable.getValueAt(selectedRow, 4).toString();

                        // Display the details in the selectedProductLabel
                        selectedProductLabel.setText("<html><b>Selected Product Details</b><br>"+"<br>"+"<br>"
                                + "Product ID: " + productID + "<br>"+"<br>"
                                + "Name: " + productName + "<br>"+"<br>"
                                + "Category: " + category + "<br>"+"<br>"
                                + "Price: £" + price + "<br>"+"<br>"
                                + "Info: " + info + "</html>");
                    }
                }
            }
        });


        // Set up GridBagConstraints for the tablePanel in the main content panel
        GridBagConstraints gbcTable = new GridBagConstraints();
        gbcTable.gridx = 0;           // X position in the grid
        gbcTable.gridy = 2;           // Y position in the grid
        gbcTable.weighty = 0.3;        // 30% of the height
        gbcTable.fill = GridBagConstraints.BOTH;  // Allow the component to grow both horizontally and vertically
        contentPanel.add(tablePanel, gbcTable);  // Add the tablePanel to the main content panel

// Create a JPanel for the third layer with selected product details (40% height)
        JPanel detailsPanel = new JPanel(new BorderLayout());

// Create a JLabel for displaying selected product details at the top
        selectedProductLabel = new JLabel("Selected Product Details");
        selectedProductLabel.setFont(new Font("Arial", Font.BOLD, 16));
        detailsPanel.add(selectedProductLabel, BorderLayout.NORTH);

// Create a JButton "Add to Shopping Cart" and add an ActionListener to handle the action
        JButton addToCartButton = new JButton("Add to Shopping Cart");
        addToCartButton.addActionListener(e -> addToShoppingCart());

// Create a JPanel for holding the button with centered FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addToCartButton);

// Add the buttonPanel to the detailsPanel at the bottom
        detailsPanel.add(buttonPanel, BorderLayout.SOUTH);


        // Add a ListSelectionListener to the productTable to handle row selection
        productTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Get the selected row index
                    int selectedRow = productTable.getSelectedRow();

                    // Update the visibility of the "Add to Shopping Cart" button based on row selection
                    addToCartButton.setVisible(selectedRow != -1);
                }
            }
        });

// Set up GridBagConstraints for the detailsPanel in the main content panel
        GridBagConstraints gbcDetails = new GridBagConstraints();
        gbcDetails.gridx = 0;           // X position in the grid
        gbcDetails.gridy = 3;           // Y position in the grid
        gbcDetails.weighty = 0.5;        // 50% of the height
        gbcDetails.fill = GridBagConstraints.BOTH;  // Allow the component to grow both horizontally and vertically
        contentPanel.add(detailsPanel, gbcDetails);  // Add the detailsPanel to the main content panel


        // Set the content panel as the content pane of the frame
        setContentPane(contentPanel);

        // Set the size of the frame
        setSize(600, 600);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Make the frame visible
        setVisible(true);
    }

    // Method to handle "Add to Shopping Cart" button click
    private void addToShoppingCart() {
        // Get the selected row
        int selectedRow = productTable.getSelectedRow();

        // Check if a row is selected
        if (selectedRow != -1) {
            // Get information from the selected row
            String productName = productTable.getValueAt(selectedRow, 1).toString();
            String price = productTable.getValueAt(selectedRow, 3).toString();

            // Ask the user for the quantity using a JOptionPane
            String quantityString = JOptionPane.showInputDialog(this, "Enter Quantity for " + productName + ":");

            // Check if the user entered a quantity
            if (quantityString != null && !quantityString.isEmpty()) {
                try {
                    // Parse the quantity as an integer
                    int quantity = Integer.parseInt(quantityString);

                    // Add your logic to add the product to the shopping cart with the specified quantity
                    // For now, let's just show a message indicating success
                    String message = "Product successfully added to Shopping Cart:\n"
                            + "Product: " + productName + "\n"
                            + "Quantity: " + quantity + "\n"
                            + "Total Price: £" + (quantity * Double.parseDouble(price));
                    JOptionPane.showMessageDialog(this, message);

                    // Refresh the shopping cart table if it's already open
                    if (shoppingCartTable != null) {
                        refreshShoppingCart();
                    }
                } catch (NumberFormatException e) {
                    // Handle the case where the quantity entered is not a valid integer
                    JOptionPane.showMessageDialog(this, "Invalid quantity. Please enter a valid number.");
                }
            }
        } else {
            // If no row is selected, show a message
            JOptionPane.showMessageDialog(this, "Please select a product from the table.");
        }
    }


    // Method to open the shopping cart
    private void openShoppingCart() {
        if (shoppingCartTable == null) {
            // Create a new shopping cart table if it's not open
            createShoppingCart();
        } else {
            // If already open, bring it to the front
            shoppingCartTable.setVisible(true);
        }
    }

    // Method to create the shopping cart table
    // Modify the createShoppingCart method
    private void createShoppingCart() {
        // Set up the shopping cart table
        String[] cartTableHeadings = {"Product ID", "Product", "Quantity", "Total Cost (£)"};
        Object[][] cartTableData = new Object[0][4];  // Empty data for now
        DefaultTableModel cartTableModel = new DefaultTableModel(cartTableData, cartTableHeadings);
        shoppingCartTable = new JTable(cartTableModel);
        shoppingCartTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
        JScrollPane cartScrollPane = new JScrollPane(shoppingCartTable);

        // Create a new frame for the shopping cart
        JFrame shoppingCartFrame = new JFrame("Shopping Cart");
        shoppingCartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        shoppingCartFrame.setLayout(new BorderLayout());
        shoppingCartFrame.add(cartScrollPane, BorderLayout.CENTER);

        // Create a label to display the total cost below the shopping cart table
        JLabel totalCostLabel = new JLabel("Total Cost: £0.00");
        shoppingCartFrame.add(totalCostLabel, BorderLayout.SOUTH);

        // Set the total cost label as a client property of the table model for reference
//        cartTableModel.putClientProperty("totalCostLabel", totalCostLabel);

        shoppingCartFrame.setSize(400, 300);
        shoppingCartFrame.setLocationRelativeTo(this); // Set location relative to the main frame
        shoppingCartFrame.setVisible(true);
    }


    // Method to refresh the shopping cart table
    private void refreshShoppingCart() {
        // Add your logic to refresh the shopping cart table
        // For now, let's just print a message
        System.out.println("Shopping Cart refreshed!");
    }

    // Other methods...

    public static void main(String[] args) {
        // Create an instance of the GUI
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI(); // Add test data to the product table
        });
    }

    public void updateProductTable(ArrayList<Product> productList) {
        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();
        tableModel.setRowCount(0); // Clear existing rows

        for (Product product : productList) {
            // Add each product to the table
            Object[] rowData = {product.getProductID(), product.getProductName(), product.getProductName(),product.getPrice(),product.getProductName(),product.getPrice()};
            tableModel.addRow(rowData);
        }
    }
    public void updateProductTable2(ArrayList<Product> productList, String selectedCategory) {
        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();
        tableModel.setRowCount(0); // Clear existing rows
        String productType = null;
        for (Product product : productList) {
            if (product instanceof Electronics) {
                 productType = "Electronics";
            } else if (product instanceof Clothing) {
                 productType = "Clothing";
            }
        }

        for (Product product : productList) {
            // Check if the product matches the selected category
            if ("All".equals(selectedCategory) || productType.equals(selectedCategory)) {
                // Add each matching product to the table
                Object[] rowData = {product.getProductID(), product.getProductName(), product.getCategory(), product.getPrice(), product.getPrice()};
                tableModel.addRow(rowData);
            }
        }
    }
}




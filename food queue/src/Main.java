
public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI(); // Create a new GUI instance
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager(gui); // Create a WestminsterShoppingManager instance, passing the GUI as a parameter
        gui.setVisible(false); // Set the GUI to be initially invisible
        shoppingManager.displayMenu(); // Display the shopping manager menu


    }
}
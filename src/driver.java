package projectfinal;

import javax.swing.*;

public class driver {
    private static Inventory inventory = new Inventory();
    private static int receiptID = 1;
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String CUSTOMER_USERNAME = "customer";
    private static final String CUSTOMER_PASSWORD = "customer123";

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            int option = displayMainMenu();
            switch (option) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    customerLogin();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    //Main Menu Function that presents 3 options -> Admin Login, Customer Login, Exit
    private static int displayMainMenu() {
        String[] options = {"Admin Login", "Customer Login", "Exit"};
        return JOptionPane.showOptionDialog(null, "==== Car Sales System ====", "Main Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
    }
    
    
    //If user selects admin login, presents options for admin username and password and authenticates with the details saved.
    private static void adminLogin() {
        String username = JOptionPane.showInputDialog("Username:");
        String password = JOptionPane.showInputDialog("Password:");
        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            Admin admin = new Admin("Admin", username, password, "admin@example.com", 1, "Admin", "Sales");
            adminMenu(admin);
        } else {
        	//Error thrown if not a match
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
        }
    }

    //If admin is authenticated, the admin menu is presented to them.
    private static void adminMenu(Admin admin) {
        boolean logout = false;
        while (!logout) {
            int option = displayAdminMenu();
            switch (option) {
                case 1:
                    addVehicleToInventory();
                    break;
                case 2:
                    deleteVehicleFromInventory();
                    break;
                case 3:
                    inventory.viewInventory();
                    break;
                case 4:
                    logout = true;
                    System.out.println("Logging out as admin...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    //displays admin menu and takes input for what to do next
    private static int displayAdminMenu() {
        String[] options = {"Add Vehicle to Inventory", "Delete Vehicle from Inventory", "View Inventory", "Logout"};
        return JOptionPane.showOptionDialog(null, "==== Admin Menu ====", "Admin Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
    }

    //allows user to add a vehicle to the inventory list
    private static void addVehicleToInventory() {
        String[] vehicleOptions = {"Car", "Motorcycle"};
        int vehicleTypeOption = JOptionPane.showOptionDialog(null, "Enter Vehicle Type:", "Add Vehicle to Inventory",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, vehicleOptions, vehicleOptions[0]);
        if (vehicleTypeOption == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Invalid vehicle type option. Vehicle not added to inventory.");
            return;
        }
        
        int vehicleID = 0;

        try {
            vehicleID = Integer.parseInt(JOptionPane.showInputDialog("Enter Vehicle ID:"));
            // Rest of the code
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input for Vehicle ID. Please enter a valid integer.");
        }

        int wheels = Integer.parseInt(JOptionPane.showInputDialog("Enter Wheels:"));
        String colour = JOptionPane.showInputDialog("Enter Colour:");
        String engine = JOptionPane.showInputDialog("Enter Engine:");
        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter Year:"));
        double mileage = Double.parseDouble(JOptionPane.showInputDialog("Enter Mileage:"));
        String make = JOptionPane.showInputDialog("Enter Make:");
        String model = JOptionPane.showInputDialog("Enter Model:");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price:"));

        Vehicle vehicle;
        if (vehicleTypeOption == 0) {
            int doors = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Doors:"));
            String interiorColour = JOptionPane.showInputDialog("Enter Interior Colour:");
            vehicle = new Car(vehicleID, wheels, colour, engine, year, mileage, make, model, price, doors, interiorColour);
        } else {
            boolean storageBox = Boolean.parseBoolean(JOptionPane.showInputDialog("Has Storage Box (true/false):"));
            String type = JOptionPane.showInputDialog("Enter Motorcycle Type:");
            double engineSize = Double.parseDouble(JOptionPane.showInputDialog("Enter Engine Size:"));
            vehicle = new Motorcycle(vehicleID, wheels, colour, engine, year, mileage, make, model, price, storageBox, type, engineSize);
        }

        // Add the vehicle to the inventory
        inventory.addInventory(vehicle);
        JOptionPane.showMessageDialog(null, "Vehicle added to inventory successfully!");
    }

    private static void deleteVehicleFromInventory() {
    	int vehicleID = 0;
    	try {
    	    vehicleID = Integer.parseInt(JOptionPane.showInputDialog("Enter Vehicle ID:"));
    	    // Rest of the code
    	} catch (NumberFormatException e) {
    	    JOptionPane.showMessageDialog(null, "Invalid input for Vehicle ID. Please enter a valid integer.");
    	}

        // Find the vehicle in the inventory
        Vehicle vehicle = inventory.getInventory(vehicleID);
        if (vehicle != null) {
            boolean removed = inventory.deleteInventory(vehicle);
            if (removed) {
                JOptionPane.showMessageDialog(null, "Vehicle deleted from inventory successfully!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vehicle not found in inventory.");
        }
    }

    private static void customerLogin() {
        String username = JOptionPane.showInputDialog("Username:");
        String password = JOptionPane.showInputDialog("Password:");
        if (username.equals(CUSTOMER_USERNAME) && password.equals(CUSTOMER_PASSWORD)) {
            Customer customer = new Customer("Customer", username, password, "customer@example.com", 1, "Address", "Phone");
            customerMenu(customer);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
        }
    }

    private static void customerMenu(Customer customer) {
        boolean logout = false;
        while (!logout) {
            int option = displayCustomerMenu();
            switch (option) {
                case 1:
                    inventory.viewInventory();
                    break;
                case 2:
                    purchaseVehicle(customer);
                    break;
                case 3:
                    viewReceipts(customer);
                    break;
                case 4:
                    logout = true;
                    System.out.println("Logging out as customer...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static int displayCustomerMenu() {
        String[] options = {"View Inventory", "Purchase Vehicle", "View Receipts", "Logout"};
        return JOptionPane.showOptionDialog(null, "==== Customer Menu ====", "Customer Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
    }

    private static void purchaseVehicle(Customer customer) {
    	
    	int vehicleID = 0;
    	
    	try {
    	    vehicleID = Integer.parseInt(JOptionPane.showInputDialog("Enter Vehicle ID:"));
    	    // Rest of the code
    	} catch (NumberFormatException e) {
    	    JOptionPane.showMessageDialog(null, "Invalid input for Vehicle ID. Please enter a valid integer.");
    	}

        // Find the vehicle in the inventory
        Vehicle vehicle = inventory.getInventory(vehicleID);
        if (vehicle != null) {
            // Generate a receipt ID
            int receiptID = generateReceiptID();
            // Create a new receipt
            Receipt receipt = new Receipt(receiptID, customer, vehicle);
            // Add the receipt to the customer's receipts
            customer.addReceipt(receipt);
            JOptionPane.showMessageDialog(null, "Vehicle purchased successfully!\nReceipt ID: " + receipt.getReceiptID());
        } else {
            JOptionPane.showMessageDialog(null, "Vehicle not found in inventory.");
        }
    }

    private static void viewReceipts(Customer customer) {
        StringBuilder message = new StringBuilder("==== Receipts ====\n");
        if (customer.getReceipts().isEmpty()) {
            message.append("No receipts found.");
        } else {
            for (Receipt receipt : customer.getReceipts()) {
                message.append(receipt).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }

    private static int generateReceiptID() {
        return receiptID++;
    }
}

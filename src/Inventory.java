package projectfinal;

import java.util.ArrayList;

class Inventory {
    private ArrayList<Vehicle> storage;

    public Inventory() {
        storage = new ArrayList<>();
    }

    public void addInventory(Vehicle vehicle) {
        storage.add(vehicle);
        System.out.println("Vehicle added to inventory.");
    }

    public boolean deleteInventory(Vehicle vehicle) {
        boolean removed = storage.remove(vehicle);
        if (removed) {
            System.out.println("Vehicle removed from inventory.");
        }
        return removed;
    }

    public void viewInventory() {
        System.out.println("==== Inventory ====");
        System.out.printf("%-12s %-8s %-10s %-10s %-6s %-8s %-12s %-10s %-8s %-15s %-8s %-12s\n",
                "Vehicle ID", "Wheels", "Colour", "Engine", "Year", "Mileage", "Make", "Model", "Price",
                "Type", "Interior Colour", "Engine Size");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Vehicle vehicle : storage) {
            System.out.printf("%-12s %-8s %-10s %-10s %-6s %-8s %-12s %-10s %-8s",
                    vehicle.getID(), vehicle.getWheels(), vehicle.getColour(), vehicle.getEngine(),
                    vehicle.getYear(), vehicle.getMileage(), vehicle.getMake(), vehicle.getModel(),
                    vehicle.getPrice());
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                System.out.printf("%-15s %-8s\n", "Car", car.getInteriorColour());
            } else if (vehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                System.out.printf("%-15s %-8s\n", "Motorcycle", motorcycle.getEngineSize());
            } else {
                System.out.println();
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        System.out.println();
    }

    public Vehicle getInventory(int vehicleID) {
        for (Vehicle vehicle : storage) {
            if (vehicle.getID() == vehicleID) {
                return vehicle;
            }
        }
        return null;
    }
}

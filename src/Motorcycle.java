package projectfinal;

class Motorcycle extends Vehicle {
    private boolean storageBox;
    private String type;
    private double engineSize;

    public Motorcycle(int ID, int wheels, String colour, String engine, int year, 
    				  double mileage, String make, String model, double price, 
    				  boolean storageBox, String type, double engineSize) {
        super(ID, wheels, colour, engine, year, mileage, make, model, price);
        this.storageBox = storageBox;
        this.type = type;
        this.engineSize = engineSize;
    }

    public boolean hasStorageBox() {
        return storageBox;
    }

    public String getType() {
        return type;
    }

    public double getEngineSize() {
        return engineSize;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Storage Box: " + storageBox + "\n" +
                "Type: " + type + "\n" +
                "Engine Size: " + engineSize;
    }
}


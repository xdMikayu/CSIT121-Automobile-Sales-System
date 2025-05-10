package projectfinal;

class Vehicle {
    private int ID;
    private int wheels;
    private String colour;
    private String engine;
    private int year;
    private double mileage;
    private String make;
    private String model;
    private double price;

    public Vehicle(int ID, int wheels, String colour, String engine, int year, double mileage, String make,
                   String model, double price) {
        this.ID = ID;
        this.wheels = wheels;
        this.colour = colour;
        this.engine = engine;
        this.year = year;
        this.mileage = mileage;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public int getWheels() {
        return wheels;
    }

    public String getColour() {
        return colour;
    }

    public String getEngine() {
        return engine;
    }

    public int getYear() {
        return year;
    }

    public double getMileage() {
        return mileage;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Vehicle ID: " + ID + "\n" +
                "Wheels: " + wheels + "\n" +
                "Colour: " + colour + "\n" +
                "Engine: " + engine + "\n" +
                "Year: " + year + "\n" +
                "Mileage: " + mileage + "\n" +
                "Make: " + make + "\n" +
                "Model: " + model + "\n" +
                "Price: " + price;
    }
}


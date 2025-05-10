package projectfinal;

class Car extends Vehicle {
    private int doors;
    private String interiorColour;

    public Car(int ID, int wheels, String colour, String engine, int year, double mileage, String make,
               String model, double price, int doors, String interiorColour) {
        super(ID, wheels, colour, engine, year, mileage, make, model, price);
        this.doors = doors;
        this.interiorColour = interiorColour;
    }

    public int getDoors() {
        return doors;
    }

    public String getInteriorColour() {
        return interiorColour;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Doors: " + doors + "\n" +
                "Interior Colour: " + interiorColour;
    }
}



package projectfinal;

class Receipt {
    private int receiptID;
    private Customer customer;
    private Vehicle vehicle;

    public Receipt(int receiptID, Customer customer, Vehicle vehicle) {
        this.receiptID = receiptID;
        this.customer = customer;
        this.vehicle = vehicle;
    }

    public int getReceiptID() {
        return receiptID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "Receipt ID: " + receiptID + ", Customer: " + customer.getName() + ", Vehicle: " + vehicle.getMake() + " " + vehicle.getModel();
    }
}



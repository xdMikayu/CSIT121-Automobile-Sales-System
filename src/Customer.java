package projectfinal;

import java.util.ArrayList;

class Customer extends User {
    private int customerID;
    private String address;
    private String phone;
    private ArrayList<Receipt> receipts;

    public Customer(String name, String username, String password, String email, int customerID, String address, String phone) {
        super(name, username, password, email);
        this.customerID = customerID;
        this.address = address;
        this.phone = phone;
        this.receipts = new ArrayList<>();
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Receipt> getReceipts() {
        return receipts;
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }
}



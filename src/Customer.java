import java.util.ArrayList;

public class Customer {

    private String customerID;
    private String name;
    private String address;
    private String telephoneNumber;
    private String email;
    private ArrayList <Order> orders;

    public Customer(String customerID, String name, String address, String telephoneNumber, String email) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.orders = new ArrayList<Order>();
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public static Customer createCustomer(String customerID, String name, String adress, String telephoneNumber, String email){
        return new Customer(customerID, name, adress, telephoneNumber, email);
    }
}

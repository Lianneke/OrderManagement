import java.util.ArrayList;

public class Pharmacy {

    private String name;
    private ArrayList <Customer> customers;

    public Pharmacy(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();

    }

    public void printListOfCustomers(){
        for(int i=0; i<this.customers.size(); i++){
            System.out.println(i+1 + "." +
                    this.customers.get(i).getCustomerID() + " - " +
                    this.customers.get(i).getName());
        }
    }

    public boolean addNewCustomer(Customer customer){
        if(findCustomer(customer.getCustomerID()) >= 0){
            return false;
        }
        customers.add(customer);
        return true;
    }

    private int findCustomer(Customer customer) {
        return this.customers.indexOf(customer);
    }

    private int findCustomer(String customerID) {
        for(int i=0; i<this.customers.size(); i++) {
            Customer customer = this.customers.get(i);
            if(customer.getCustomerID().equals(customerID)) {
                return i;
            }
        }
        return -1;
    }

    public String queryCustomer(Customer customer) {
        if(findCustomer(customer) >=0){
            return customer.getCustomerID();
        }
        return null;
    }

    public Customer queryCustomer(String customerID){
        int position = findCustomer(customerID);
        if(position >=0){
            return this.customers.get(position);
        }
        return null;
    }
}

import java.util.ArrayList;

public class Order {


//    private int nextOrderNumber = 1;

    private Customer customer;
    private long orderNumber;
    private ArrayList <OrderLine> orderLines = new ArrayList<>();

    public Order(Customer customer, long orderNumber) {
        this.customer = customer;
        this.orderNumber = orderNumber;
    }


//    public void printListOfOrderLines(){
//        for(int i=0; i<this.orderLines.size(); i++){
//            System.out.println(i+1 + "." +
//                    this.orderLines.get(i).getMedicine() + " - " +
//                    this.orderLines.get(i).getCharge()  + " - " +
//                    this.orderLines.get(i).getQuantity()  + " - " +
//                    this.orderLines.get(i).getPrice());
//        }
//    }


    @Override
    public String toString() {
        return "Order{" +
                "orderLines=" + orderLines +
                '}';
    }

    public long getOrderNumber(){
        return orderNumber;
    }

    public String getOrderLines() {
        for (int i = 0; i < this.orderLines.size(); i++) {
            String medicineName = orderLines.get(i).getMedicine().toString();
            return medicineName;
        }
        return null;
    }

    public void addNewOrderLine(OrderLine orderLine){
        orderLines.add(orderLine);
    }

//    public static Order createOrder(Customer customer, long orderNumber){
//        return new Order(customer, (int) orderNumber);
//    }
}

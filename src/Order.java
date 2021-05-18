import java.util.ArrayList;

public class Order {


//    private int nextOrderNumber = 1;

    private Customer customer;
    private long orderNumber;
    private ArrayList <OrderLine> orderLines;

    public Order(Customer customer, long orderNumber) {
        this.customer = customer;
        this.orderNumber = orderNumber;
        this.orderLines = new ArrayList<OrderLine>();
    }

    @Override
    public String toString() {
        return getOrderLines().toString();
    }

    public ArrayList<OrderLine> getOrderLines(){
        return this.orderLines;
    }


    public long getOrderNumber(){
        return orderNumber;
    }

    public void addNewOrderLine(OrderLine orderLine){
        orderLines.add(orderLine);
    }
}

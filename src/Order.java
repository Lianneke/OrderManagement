import java.util.ArrayList;

public class Order {

//    private static long count = 0;
    private int orderNumber;
    private Customer customer;
    private OrderLine orderLine;
    private ArrayList <OrderLine> orderLines;

//    private boolean isFilled;

 //   public TestIncrement(String title){
//        name = title;

//        isFilled = false;
//        setOrderNumber(++count);
//    }

    public int getOrderNumber(){
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber){
        this.orderNumber = orderNumber;
    }

    public Order(int orderNumber, Customer customer, OrderLine orderLine) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.orderLine = orderLine;
        this.orderLines = new ArrayList<OrderLine>();
    }

    public boolean addNewOrderLine(OrderLine orderLine){
        orderLines.add(orderLine);
        return true;
    }
}

package rsf2s1g2.Entity;

import rsf2s1g2.adt.CircularQueue;
import rsf2s1g2.adt.CircularQueueInterface;
import rsf2s1g2.adt.SortedList;
import rsf2s1g2.adt.SortedListInterface;


/**
 *
 * @author Wee Yan
 */
public class Order implements Comparable<Order> {

    private static int nextOrderID = 2001;
    private static int count=1;
    private int orderId;
    private String customerName;
    private String phoneNum;
    private String date;
    private double orderAmount;
    CircularQueueInterface<Order> orderQueue = new CircularQueue<>();
    SortedListInterface<Order> AcceptedOrder = new SortedList<>();
    SortedListInterface<Order> RejectedOrder = new SortedList<>();

    public Order(int orderID, String customerName, String date, String phoneNum, double orderAmount){
        this.orderId = orderID;
        this.customerName = customerName;
        this.phoneNum = phoneNum;
        this.date = date;
        this.orderAmount = orderAmount;
        
    }
    
    public Order(String customerName, String date, String phoneNum, double orderAmount){
        this.orderId = nextOrderID++;
        this.customerName = customerName;
        this.phoneNum = phoneNum;
        this.date = date;
        this.orderAmount = orderAmount;
    }
    
    public void addOrder(String customerName, String phoneNum, String date, double orderAmount){
        orderQueue.enqueue(new Order(customerName, date, phoneNum, orderAmount));
    }
    
    public void addOrder(int OrderID, String customerName, String phoneNum, String date, double orderAmount){
        orderQueue.enqueue(new Order(OrderID, customerName, phoneNum, date, orderAmount));
    }
    
    public void setOrderQueue(CircularQueueInterface<Order> orderQueue){
        this.orderQueue = orderQueue;
    }
    
    public CircularQueueInterface<Order> getOrderQueue(){
        return orderQueue;
    }
    
    
    
    @Override
    public int compareTo(Order o) {
        
    }
   
   
    
}

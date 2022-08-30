package rsf2s1g2.Entity;

import rsf2s1g2.adt.CircularQueue;
import rsf2s1g2.adt.CircularQueueInterface;


/**
 *
 * @author Wee Yan
 */
public class OrderEvaluation implements Comparable<OrderEvaluation> {

    private static int nextOrderID = 2001;
    private static int count=1;
    private int orderId;
    private String customerName;
    private String phoneNum;
    private String date;
    private double orderAmount;
    CircularQueueInterface<OrderEvaluation> orderQueue = new CircularQueue<>();

    public OrderEvaluation(int orderID, String customerName, String date, String phoneNum, double orderAmount){
        this.orderId = orderID;
        this.customerName = customerName;
        this.phoneNum = phoneNum;
        this.date = date;
        this.orderAmount = orderAmount;
        
    }
    
    public OrderEvaluation(String customerName, String date, String phoneNum, double orderAmount){
        this.orderId = nextOrderID++;
        this.customerName = customerName;
        this.phoneNum = phoneNum;
        this.date = date;
        this.orderAmount = orderAmount;
    }
    
    public void addOrder(String customerName, String phoneNum, String date, double orderAmount){
        orderQueue.enqueue(new OrderEvaluation(customerName, date, phoneNum, orderAmount));
    }
    
    public void addOrder(int OrderID, String customerName, String phoneNum, String date, double orderAmount){
        orderQueue.enqueue(new OrderEvaluation(OrderID, customerName, phoneNum, date, orderAmount));
    }
    
    public void setOrderQueue(CircularQueueInterface<OrderEvaluation> orderQueue){
        this.orderQueue = orderQueue;
    }
    
    public CircularQueueInterface<OrderEvaluation> getOrderQueue(){
        return orderQueue;
    }
    
    
    
    @Override
    public int compareTo(OrderEvaluation o) {
        
    }
   
   
    
}

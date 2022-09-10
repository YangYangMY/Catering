package rsf2s1g2.entity;
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

    public Order(){
        
    }
    
    public Order(String customerName, String date, String phoneNum, double orderAmount){
        this.orderId = nextOrderID++;
        this.customerName = customerName;
        this.phoneNum = phoneNum;
        this.date = date;
        this.orderAmount = orderAmount;
    }
    
    public void addOrder(String customerName, String date,String phoneNum, double orderAmount){
        orderQueue.enqueue(new Order(customerName, date, phoneNum, orderAmount));
    }  
    
    public CircularQueueInterface<Order> getOrderQueue(){
        return orderQueue;
    }
    
    public SortedListInterface<Order> getAcceptedList(){
        return AcceptedOrder;
    }
    
    public SortedListInterface<Order> getRejectedList(){
        return RejectedOrder;
    }
    
    public void AcceptOrder(Order newEntry){
        boolean check = AcceptedOrder.insert(newEntry);
        if(check == true){
            orderQueue.dequeue();
        }
    }
    
    public void RejectOrder(Order newEntry){
        boolean check = RejectedOrder.insert(newEntry);
        if(check == true){
            orderQueue.dequeue();
        }
    }

    public void CompleteOrder(Order newEntry){
        AcceptedOrder.delete(newEntry);
    }

    @Override
    public String toString() {
        return  String.format("%-10s",count++)  + String.format("%-12s", orderId) + String.format("%-15s", date) + String.format("%-16s", String.format("%.2f",orderAmount)) + String.format("%-26s",customerName) + String.format("%-16s", phoneNum) ;        
    }

    @Override
    public int compareTo(Order o) {
        return this.date.compareTo(o.getDate());
        
    }

    public static int getNextOrderID() {
        return nextOrderID;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Order.count = count;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getDate() {
        return date;
    }
}

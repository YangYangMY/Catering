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
    private BookingInfo bookingInfo;
    private Customer customer;
    private Facility facility;
    private FoodBeverage foodbeverage;

    public Order(String customerName, String date, String phoneNum, double orderAmount){
        this.orderId = nextOrderID++;
        this.customerName = customerName;
        this.phoneNum = phoneNum;
        this.date = date;
        this.orderAmount = orderAmount;
    }
    
    public Order(BookingInfo bookinginfo, Customer customer, Facility facility, FoodBeverage foodbeverage){
        this.orderId = nextOrderID++;
        this.customerName = customer.getName();
        this.phoneNum = customer.getPhoneNum();
        this.date = null;
        this.orderAmount = 0;
        this.bookingInfo = bookinginfo;
        this.customer = customer;
        this.facility = facility;
        this.foodbeverage = foodbeverage;
    }
    

    public void addOrder(BookingInfo bookinginfo, Customer customer, Facility facility, FoodBeverage foodbeverage, CircularQueueInterface<Order> orderQueue ){
        orderQueue.enqueue(new Order(bookinginfo, customer, facility, foodbeverage));
    }  
    
    
    public void acceptOrder(Order newEntry, CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder){
        boolean check = acceptedOrder.insert(newEntry);
        if(check == true){
            orderQueue.dequeue();
        }
    }
    
    public void rejectOrder(Order newEntry, CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> RejectedOrder){
        boolean check = RejectedOrder.insert(newEntry);
        if(check == true){
            orderQueue.dequeue();
        }
    }

    public void completeOrder(Order newEntry, SortedListInterface<Order> acceptedOrder){
        acceptedOrder.delete(newEntry);
    }

    @Override
    public String toString() {
        return  String.format("%-10s",count++)  + String.format("%-12s", orderId) + String.format("%-15s", date) + String.format("%-16s", String.format("%.2f",orderAmount)) + String.format("%-26s",customerName) + String.format("%-16s", phoneNum) ;        
    }

    @Override
    public int compareTo(Order o) {
        return this.date.compareTo(o.getDate());
        
    }
    
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Order.count = count;
    }

    public String getDate() {
        return date;
    }
}

package rsf2s1g2.entity;
import rsf2s1g2.adt.*;
import rsf2s1g2.entity.*;
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


    public Order(String customerName, String date, String phoneNum, double orderAmount){
        this.orderId = nextOrderID++;
        this.customerName = customerName;
        this.phoneNum = phoneNum;
        this.date = date;
        this.orderAmount = orderAmount;
    }
    
    public Order(String date, String icNumber, int paymentID, ListInterface<BookingInfo> bookinginfo, MapInterface<String, Customer> customers){
        this.orderId = nextOrderID++;
        this.customerName = customers.getValue(icNumber).getName();
        this.phoneNum = customers.getValue(icNumber).getPhoneNum();
        this.date = date;
        this.orderAmount = bookinginfo.get(1).getTotalPrice();
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

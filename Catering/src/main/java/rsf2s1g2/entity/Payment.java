package rsf2s1g2.entity;
import java.text.DecimalFormat;

public class Payment {
    private static int id = 1000;
    private int pymtId = 1000;      
    private double amount;
    private String method;
    private int num = 0;
    DecimalFormat df = new DecimalFormat("0.00");

    public Payment(){
    }

    public Payment(double paymentAmount, String paymentMethod){
        this.amount = paymentAmount;
        this.method = paymentMethod;
        id++;
        pymtId++;
    }

    public static int getId(){
        return id;
    }

    public int getPymtId(){
        return pymtId;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        num += 1;

        return num + ".\t" + pymtId + "\t\t  " + method + "\t\t  " + df.format(amount);
    }

}

package rsf2s1g2.entity;

public class Payment {
    private static int id;
    private double amount;
    private String method;

    public Payment(){
    }

    public Payment(double paymentAmount, String paymentMethod){
        this.amount = paymentAmount;
        this.method = paymentMethod;
        id = 1000;
    }

    public static int getId(){
        return id;
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

}

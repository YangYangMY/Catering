package rsf2s1g2.entity;

import java.text.DecimalFormat;

public class FoodBeverage {

    private String fbName;
    private int fbNum;
    private double fbPrice = 0.0;
    private double fbTotal;
    private static double finalTotal;
    DecimalFormat df = new DecimalFormat("0.00");

    public FoodBeverage(String fbName, double fbPrice) {
        this.fbName = fbName;
        this.fbPrice = fbPrice;
    }

    public FoodBeverage(String fbName, int fbNum, double fbPrice) {
        this.fbName = fbName;
        this.fbNum = fbNum;
        this.fbPrice = fbPrice;
    }

    //getters and setters
    public String getFoodname() {
        return fbName;
    }

    public void setFoodname(String fbName) {
        this.fbName = fbName;
    }

    public int getFoodnum() {
        return fbNum;
    }

    public void setFoodnum(int fbNum) {
        this.fbNum = fbNum;
    }

    public double getFoodprice() {
        return fbPrice;
    }

    public void setFoodprice(double fbPrice) {
        this.fbPrice = fbPrice;
    }

    public double getFoodtotal() {
        fbTotal = fbNum * fbPrice;
        return fbTotal;
    }

    public static void resetFinalTotal() {
        finalTotal = 0.0;
    }

    public double getFinaltotal() {
        finalTotal += (fbNum * fbPrice);
        return finalTotal;
    }

    //toStrting method
    @Override
    public String toString() {
        if(getFoodtotal() == 0.0){
            return "Food Name: " + fbName + "\tPrice: RM " + df.format(fbPrice);
        } else {
            return "Food Name: " + fbName + "\tQuality: " + fbNum + "\tPrice: RM " + df.format(fbPrice) + "\tTotal Price: RM " + df.format(getFoodtotal()) + "\tFinal Price: RM " + df.format(getFinaltotal());
        }

    }
}
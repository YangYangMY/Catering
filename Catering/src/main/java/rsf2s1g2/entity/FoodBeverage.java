package rsf2s1g2.entity;

import java.text.DecimalFormat;

public class FoodBeverage {

    private String fbName;
    private int fbNum;
    private double fbPrice;
    private double fbTotal;
    private boolean printStringOne = false;
    private static double foodFinalTotal;
    private static double beverageFinalTotal;
    private static int num = 0;
    DecimalFormat df = new DecimalFormat("0.00");
    
    public FoodBeverage(String fbName, double fbPrice) {
        this.fbName = fbName;
        this.fbPrice = fbPrice;
        printStringOne = true;
    }

    public FoodBeverage(String fbName, int fbNum, double fbPrice) {
        this.fbName = fbName;
        this.fbNum = fbNum;
        this.fbPrice = fbPrice;
        getFoodtotal();
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

    public double getFoodFinaltotal() {
        return foodFinalTotal;
    }

    public void setFoodFinaltotal(double foodFinalTotal) {
        FoodBeverage.foodFinalTotal = foodFinalTotal;
    }

    public double getBeverageFinaltotal() {
        return beverageFinalTotal;
    }

    public void setBeverageFinaltotal(double beverageFinalTotal) {
        FoodBeverage.beverageFinalTotal = beverageFinalTotal;
    }

    public static void resetNum(){
        num = 0;
    }

    //toString method
    @Override
    public String toString() {
        num += 1;
        if(printStringOne){
            return num + ".\t" + fbName + "\t\t  " + df.format(fbPrice);
        } else {
            return num + ".\t" + fbName + "\t\t  " + fbNum + "\t\t  " + df.format(fbPrice) + "\t\t  " + df.format(fbTotal);
        }
    }
}
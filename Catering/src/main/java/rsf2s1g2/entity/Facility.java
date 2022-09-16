package rsf2s1g2.entity;

import java.text.DecimalFormat;

public class Facility {
    private String facilityName;
    private int facilityNum;
    private double facilityPrice;
    private double facilityTotal;
    private boolean prntString = false;
    private static double sizeFinalTotal;
    private static double colorFinalTotal;
    private static double occasionFinalTotal;
    private static int num = 0;
    DecimalFormat df = new DecimalFormat("0.00");

    public Facility(String facilityName, double facilityPrice) {
        this.facilityName = facilityName;
        this.facilityPrice = facilityPrice;
        prntString = true;
    }

    public Facility(String facilityName, double facilityPrice, int facilityNum) {
        this.facilityName = facilityName;
        this.facilityPrice = facilityPrice;
        this.facilityNum = facilityNum;
        getFacilitytotal();
    }

    public String getFacilityname() {
        return facilityName;
    }

    public void setFacilityname(String facilityName) {
        this.facilityName = facilityName;
    }

    public int getFacilitynum() {
        return facilityNum;
    }

    public void setFacilitynum(int facilityNum) {
        this.facilityNum = facilityNum;
    }

    public double getFacilityprice() {
        return facilityPrice;
    }
    
    public void setFacilityprice(double facilityPrice) {
        this.facilityPrice = facilityPrice;
    }

    public double getFacilitytotal() {
        facilityTotal = facilityNum * facilityPrice;
        return facilityTotal;
    }

    public double getSizeFinaltotal() {
        return sizeFinalTotal;
    }

    public double getColorFinaltotal() {
        return colorFinalTotal;
    }

    public double getOccasionFinaltotal() {
        return occasionFinalTotal;
    }

    public void setSizeFinaltotal(double sizeFinalTotal) {
        Facility.sizeFinalTotal = sizeFinalTotal;
    }

    public void setColorFinaltotal(double colorFinalTotal) {
        Facility.colorFinalTotal = colorFinalTotal;
    }

    public void setOccasionFinaltotal(double occasionFinalTotal) {
        Facility.occasionFinalTotal = occasionFinalTotal;
    }

    public static void resetNumber() {
        num = 0;
    }

    @Override
    public String toString() {
        String space = "\t";
        if (prntString) {
            return space + facilityName + " \t\t\t" + df.format(facilityPrice);
        } else {
            num++;
            return num + ". " + facilityName + " \t\t " + facilityNum + " \t\t " + df.format(facilityPrice) + " \t\t" + df.format(facilityTotal);
        }
    }
}

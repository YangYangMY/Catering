package rsf2s1g2.entity;

import java.text.DecimalFormat;

public class Facility {
    private String facilityName;
    private int facilityNum;
    private double facilityPrice;
    private double facilityTotal;
    private boolean prntString = false;
    private static double facilityFinalTotal;
    private static int num = 0;
    DecimalFormat df = new DecimalFormat("0.00");

    public Facility(String facilityName, double facilityPrice) {
        this.facilityName = facilityName;
        this.facilityPrice = facilityPrice;
        prntString = true;
    }

    public Facility(String facilityName, int facilityNum, double facilityPrice) {
        this.facilityName = facilityName;
        this.facilityNum = facilityNum;
        this.facilityPrice = facilityPrice;
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

    public double getFacilityFinaltotal() {
        return facilityFinalTotal;
    }

    public void setFacilityFinaltotal(double facilityFinalTotal) {
        Facility.facilityFinalTotal = facilityFinalTotal;
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
            facilityFinalTotal += facilityTotal;
            return num + ". " + facilityName + " \t\t " + facilityNum + " \t\t " + df.format(facilityPrice) + " \t\t" + df.format(facilityTotal);
        }
    }
}

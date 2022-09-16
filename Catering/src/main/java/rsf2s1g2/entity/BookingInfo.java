package rsf2s1g2.entity;

import rsf2s1g2.adt.ListInterface;
import java.text.DecimalFormat;
import rsf2s1g2.utility.Font;

public class BookingInfo {
    private ListInterface<FoodBeverage> foodselect;
    private ListInterface<FoodBeverage> beverageselect;
    private ListInterface<Facility> sizeselect;
    private ListInterface<Facility> colorselect;
    private ListInterface<Facility> occasionselect;
    DecimalFormat df = new DecimalFormat("0.00");

    public BookingInfo(ListInterface<FoodBeverage> foodselect, ListInterface<FoodBeverage> beverageselect, ListInterface<Facility> sizeselect, ListInterface<Facility> colorselect, ListInterface<Facility> occasionselect) {
        this.foodselect = foodselect;
        this.beverageselect = beverageselect;
        this.sizeselect = sizeselect;
        this.colorselect = colorselect;
        this.occasionselect = occasionselect;
    }

    public void getFoodselect() {
        FoodBeverage.resetNum();
        System.out.println("===================================================================================");
        System.out.println("\tFOOD NAME \t\tQUANTITY  \tPRICE(RM)  \tTOTAL(RM)");
        System.out.println("===================================================================================");
        System.out.print(foodselect.toString());
        System.out.println("===================================================================================");
        Font.print(Font.ANSI_YELLOW,"\t\t\t\t\t\tFINAL TOTAL \t  " + df.format(foodselect.get(1).getFoodFinaltotal()));
        System.out.println("===================================================================================");
    }

    public void getBeverageselect() {
        FoodBeverage.resetNum();
        System.out.println("===================================================================================");
        System.out.println("\tBEVERAGE NAME \t\tQUANTITY  \tPRICE(RM)  \tTOTAL(RM)");
        System.out.println("===================================================================================");
        System.out.print(beverageselect.toString());
        System.out.println("===================================================================================");
        Font.print(Font.ANSI_YELLOW,"\t\t\t\t\t\tFINAL TOTAL \t  " + df.format(beverageselect.get(1).getBeverageFinaltotal()));
        System.out.println("===================================================================================");
    }

    public void getSizeselect() {
        //
    }

    public void getColorselect() {
        
    }

    public void getOccasionselect() {
        
    }

}

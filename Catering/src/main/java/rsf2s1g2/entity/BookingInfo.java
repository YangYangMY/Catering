package rsf2s1g2.entity;

import rsf2s1g2.adt.BagInterface;
import rsf2s1g2.adt.ListInterface;
import java.text.DecimalFormat;
import rsf2s1g2.utility.Font;

public class BookingInfo {
    private ListInterface<FoodBeverage> foodselect;
    private ListInterface<FoodBeverage> beverageselect;
    private ListInterface<Facility> sizeselect;
    private ListInterface<Facility> colorselect;
    private ListInterface<Facility> occasionselect;
    private BagInterface<Accessories> fbAccessoriesSelect;
    private BagInterface<Accessories> facilityAccessoriesSelect;
    DecimalFormat df = new DecimalFormat("0.00");

    public BookingInfo(ListInterface<FoodBeverage> foodselect, ListInterface<FoodBeverage> beverageselect, ListInterface<Facility> sizeselect, ListInterface<Facility> colorselect, ListInterface<Facility> occasionselect, BagInterface<Accessories> fbAccessoriesSelect, BagInterface<Accessories> facilityAccessoriesSelect) {
        this.foodselect = foodselect;
        this.beverageselect = beverageselect;
        this.sizeselect = sizeselect;
        this.colorselect = colorselect;
        this.occasionselect = occasionselect;
        this.fbAccessoriesSelect = fbAccessoriesSelect;
        this.facilityAccessoriesSelect = facilityAccessoriesSelect;
    }

    public void getFoodselect() {
        Font.print(Font.PURPLE_BOLD_BRIGHT,"\t\t\t\t\tFOOD CART");
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
        Font.print(Font.PURPLE_BOLD_BRIGHT,"\t\t\t\tBEVERAGE CART");
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
        Font.print(Font.PURPLE_BOLD_BRIGHT, "\t\t\t\t\t\t\tFACILITIES SIZE CART");
        Facility.resetNumber();
        System.out.println("=================================================================================================================================================");
        System.out.println("\tSIZE \t\tQUANTITY  \tPRICE(RM)  \tTOTAL PRICE(RM)");
        System.out.println("=================================================================================================================================================");
        System.out.print(sizeselect.toString());
        System.out.println("=================================================================================================================================================");
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\tFINAL TOTAL \t\t" + df.format(sizeselect.get(1).getSizeFinaltotal()));
        System.out.println("=================================================================================================================================================");
    }

    public void getColorselect() {
        Font.print(Font.PURPLE_BOLD_BRIGHT, "\t\t\t\t\t\t\tFACILITIES COLOR CART");
        Facility.resetNumber();
        System.out.println("=================================================================================================================================================");
        System.out.println("\tCOLOR \t\tQUANTITY  \tPRICE(RM)  \tTOTAL PRICE(RM)");
        System.out.println("=================================================================================================================================================");
        System.out.print(colorselect.toString());
        System.out.println("=================================================================================================================================================");
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\tFINAL TOTAL \t\t" + df.format(colorselect.get(1).getColorFinaltotal()));
        System.out.println("=================================================================================================================================================");
    }

    public void getOccasionselect() {
        Font.print(Font.PURPLE_BOLD_BRIGHT, "\t\t\t\t\t\t\tFACILITIES OCCASION CART");
        Facility.resetNumber();
        System.out.println("=================================================================================================================================================");
        System.out.println("\tOCCASION \t\tQUANTITY  \tPRICE(RM)  \tTOTAL PRICE(RM)");
        System.out.println("=================================================================================================================================================");
        System.out.print(occasionselect.toString());
        System.out.println("=================================================================================================================================================");
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\tFINAL TOTAL \t\t" + df.format(occasionselect.get(1).getOccasionFinaltotal()));
        System.out.println("=================================================================================================================================================");
    }

    public void getFbAccessoriesSelect() {
        Font.print(Font.PURPLE_BOLD_BRIGHT,"\t\t\t  ACCESSORIES CART");
        if(!fbAccessoriesSelect.isEmpty()){
            Accessories.resetNum();
            System.out.println("====================================================================");
            System.out.println("\tACCESSORIES NAME \t\tQUANTITY");
            System.out.println("====================================================================");
            System.out.println(fbAccessoriesSelect.toString());
            System.out.println("====================================================================");
        } else {
            System.out.println("====================================================================");
            Font.print(Font.RED_BOLD_BRIGHT,"\t\t\tNO ACCESSORIES SELECTED");
            System.out.println("====================================================================");
        }
    }

    public void getFacilityAccessoriesSelect() {
        Font.print(Font.PURPLE_BOLD_BRIGHT,"\t\t\t  ACCESSORIES CART");
        if(!facilityAccessoriesSelect.isEmpty()){
            Accessories.resetNum();
            System.out.println("====================================================================");
            System.out.println("\tACCESSORIES NAME \t\tQUANTITY");
            System.out.println("====================================================================");
            System.out.println(facilityAccessoriesSelect.toString());
            System.out.println("====================================================================");
        } else {
            System.out.println("====================================================================");
            Font.print(Font.RED_BOLD_BRIGHT,"\t\t\tNO ACCESSORIES SELECTED");
            System.out.println("====================================================================");
        }
    }

    public double getTotalPrice(){
        double paymentAmount = foodselect.get(1).getFoodFinaltotal() + beverageselect.get(1).getBeverageFinaltotal() 
        + sizeselect.get(1).getSizeFinaltotal() + colorselect.get(1).getColorFinaltotal() + occasionselect.get(1).getOccasionFinaltotal();
        return paymentAmount;
    }

}

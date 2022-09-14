import java.util.Scanner;

import rsf2s1g2.utility.*;
import rsf2s1g2.adt.*;
import rsf2s1g2.client.*;
import rsf2s1g2.entity.*;

public class Catering {
   
    public static void main(String[] args) {
        ListInterface<FoodBeverage> foodlist = new List<FoodBeverage>(10);
        ListInterface<FoodBeverage> beveragelist = new List<FoodBeverage>(10);
        ListInterface<FoodBeverage> foodselect = new List<FoodBeverage>(10);
        ListInterface<FoodBeverage> beverageselect = new List<FoodBeverage>(10);

        ListInterface<Facility> facilitySizeList = new List<Facility>(10);
        ListInterface<Facility> facilityColorList = new List<Facility>(10);
        ListInterface<Facility> facilityOccasionList = new List<Facility>(10);
        ListInterface<Facility> sizeselect = new List<Facility>(10);
        ListInterface<Facility> colorselect = new List<Facility>(10);
        ListInterface<Facility> occasionselect = new List<Facility>(10);
        Scanner input = new Scanner(System.in);
        
        //Call dummy data from dummyscript
        Order O = dummyScript.DummyOrderData();

        //Start Of Program
        int choice = 0;
        Screen.clear();
        do {
            try {
                choice = 0;
                displayMenu();
                choice = input.nextInt();
                if (choice < 1 || choice > 3) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-3) is allowed, please try again!\n");
                }

            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-3) is allowed, please try again!\n");
                input.next();
                }
                switch(choice){
                    case 1:
                        Screen.clear();
                        //call food and beverage
                        foodandbeverage.foodbeverage(foodlist, beveragelist, foodselect, beverageselect);
                        break;
                        case 2:
                        Screen.clear();
                        //call facility
                        Admin(O);
                        break;
                    case 3:
                        Screen.clear();
                        displayEndScreen();
                        break;
                }
            }while(choice != 3);
    }
        
     public static void displayMenu(){
        Font.print(Font.ANSI_PURPLE,"\t\t  ██████╗ █████╗ ████████╗███████╗██████╗ ██╗███╗   ██╗ ██████╗ ");
        Font.print(Font.ANSI_PURPLE,"\t\t ██╔════╝██╔══██╗╚══██╔══╝██╔════╝██╔══██╗██║████╗  ██║██╔════╝ ");
        Font.print(Font.ANSI_CYAN,"\t\t ██║     ███████║   ██║   █████╗  ██████╔╝██║██╔██╗ ██║██║  ███╗        ");
        Font.print(Font.ANSI_CYAN,"\t\t ██║     ██╔══██║   ██║   ██╔══╝  ██╔══██╗██║██║╚██╗██║██║   ██║");
        Font.print(Font.ANSI_YELLOW,"\t\t ╚██████╗██║  ██║   ██║   ███████╗██║  ██║██║██║ ╚████║╚██████╔╝");
        Font.print(Font.ANSI_YELLOW,"\t\t  ╚═════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝ ╚═════╝ ");
        System.out.println("==================================================================================================");
        System.out.println("\t\t\t\t\t1. Order\n\t\t\t\t\t2. Admin\n\t\t\t\t\t3. Exit");
        System.out.println("==================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");
    }  
    
     public static void displayEndScreen(){
        Font.print(Font.ANSI_YELLOW,"████████╗██╗  ██╗ █████╗ ███╗   ██╗██╗  ██╗    ██╗   ██╗ ██████╗ ██╗   ██╗    ██╗██╗");
        Font.print(Font.ANSI_YELLOW,"╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██║ ██╔╝    ╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║██║");
        Font.print(Font.ANSI_YELLOW,"   ██║   ███████║███████║██╔██╗ ██║█████╔╝      ╚████╔╝ ██║   ██║██║   ██║    ██║██║");
        Font.print(Font.ANSI_YELLOW,"   ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗       ╚██╔╝  ██║   ██║██║   ██║    ╚═╝╚═╝");
        Font.print(Font.ANSI_YELLOW,"   ██║   ██║  ██║██║  ██║██║ ╚████║██║  ██╗       ██║   ╚██████╔╝╚██████╔╝    ██╗██╗");
        Font.print(Font.ANSI_YELLOW,"   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝       ╚═╝    ╚═════╝  ╚═════╝     ╚═╝╚═╝");
     }



    //START OF ADMIN SECTION 



     public static void Admin(Order O){
     
        boolean check = admin.Login();
        if (check == true){
            admin.Menu(O);
        }
     }

     // Exception for handling invalid username or password
        private static class InvalidException extends Exception {

            private final String errorMsg;
    
            InvalidException() {
                this.errorMsg = "                     Invalid Password or Username, please try again!\n";
            }
    
            public String getErrorMsg() {
                return errorMsg;
            }
        }
}

    

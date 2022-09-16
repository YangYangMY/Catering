import java.util.Scanner;

import rsf2s1g2.utility.*;
import rsf2s1g2.adt.*;
import rsf2s1g2.client.*;
import rsf2s1g2.entity.*;

public class Catering {

    public static void main(String[] args) {
        //F&B Initialisation
        ListInterface<FoodBeverage> foodlist = new List<FoodBeverage>(10);
        ListInterface<FoodBeverage> beveragelist = new List<FoodBeverage>(10);
        ListInterface<FoodBeverage> foodselect = new List<FoodBeverage>(10);
        ListInterface<FoodBeverage> beverageselect = new List<FoodBeverage>(10);
        
        //Facility Initialisation
        ListInterface<Facility> facilitySizeList = new List<Facility>(100);
        ListInterface<Facility> facilityColorList = new List<Facility>(100);
        ListInterface<Facility> facilityOccasionList = new List<Facility>(100);
        ListInterface<Facility> sizeselect = new List<Facility>(100);
        ListInterface<Facility> colorselect = new List<Facility>(100);
        ListInterface<Facility> occasionselect = new List<Facility>(100);

        //Booking Initialisation
        ListInterface<BookingInfo> bookinglist = new List<BookingInfo>(100);
        
        Scanner input = new Scanner(System.in);

        // Call dummy data from dummyscript
        Order O = dummyScript.DummyOrderData();

        // Start Of Program
        int choice = 0, choice1 = 0;
        Screen.clear();
        do {
            displayMenu();
            choice = Screen.numInputValid(1, 3, "\t\t\t       Select your Choice: ","                            Only (1-3) is allowed, please try again!");
            Screen.clear();
            switch (choice) {
                case 1: // Menu (Food & Beverage, Facility, Payment)
                    do {
                        OrderMenu();
                        choice1 = Screen.numInputValid(1, 4, "\t\t\t       Select your Choice: ", "                            Only (1-4) is allowed, please try again!");
                        Screen.clear();
                        switch (choice1) {
                            case 1: // call food and beverage
                                foodandbeverage.foodbeverage(foodlist, beveragelist, foodselect, beverageselect);
                                break;
                            case 2: // call facility
                                facilities.facilitiess(facilitySizeList, facilityColorList, facilityOccasionList, sizeselect, colorselect, occasionselect);
                                break;
                            case 3: // call payment
                                if(foodselect.isEmpty() || beverageselect.isEmpty() || sizeselect.isEmpty() || colorselect.isEmpty() || occasionselect.isEmpty()){
                                    Font.print(Font.RED_BOLD_BRIGHT, "\t\tPlease select all the options before proceed to payment!");
                                    continueMessage();
                                } else {
                                    //Payment Start Here
                                    bookinglist.add(new BookingInfo(foodselect, beverageselect, sizeselect, colorselect, occasionselect));
                                    bookinglist.get(1).getFoodselect(); // Function to call the foodselect list, same goes to the other list
                                    displayEndScreen();
                                }
                                break;
                            case 4: // Exit to Home
                                break;
                        }
                    } while (choice1 != 4);
                    break;
                case 2: // Admin
                    Admin(O);
                    break;
                case 3: // End of Program
                    displayEndScreen();
                    break;
            }
        } while (choice != 3);
    }

    public static void displayMenu() {
        Font.print(Font.ANSI_PURPLE, "\t\t  ██████╗ █████╗ ████████╗███████╗██████╗ ██╗███╗   ██╗ ██████╗ ");
        Font.print(Font.ANSI_PURPLE, "\t\t ██╔════╝██╔══██╗╚══██╔══╝██╔════╝██╔══██╗██║████╗  ██║██╔════╝ ");
        Font.print(Font.ANSI_CYAN, "\t\t ██║     ███████║   ██║   █████╗  ██████╔╝██║██╔██╗ ██║██║  ███╗ ");
        Font.print(Font.ANSI_CYAN, "\t\t ██║     ██╔══██║   ██║   ██╔══╝  ██╔══██╗██║██║╚██╗██║██║   ██║");
        Font.print(Font.ANSI_YELLOW, "\t\t ╚██████╗██║  ██║   ██║   ███████╗██║  ██║██║██║ ╚████║╚██████╔╝");
        Font.print(Font.ANSI_YELLOW, "\t\t  ╚═════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝ ╚═════╝ ");
        System.out.println("==================================================================================================");
        System.out.println("\t\t\t\t\t1. Order\n\t\t\t\t\t2. Admin\n\t\t\t\t\t3. Exit");
        System.out.println("==================================================================================================");
    }

    public static void OrderMenu() {
        Font.print(Font.ANSI_PURPLE, "\t\t  ██████╗ █████╗ ████████╗███████╗██████╗ ██╗███╗   ██╗ ██████╗ ");
        Font.print(Font.ANSI_PURPLE, "\t\t ██╔════╝██╔══██╗╚══██╔══╝██╔════╝██╔══██╗██║████╗  ██║██╔════╝ ");
        Font.print(Font.ANSI_CYAN, "\t\t ██║     ███████║   ██║   █████╗  ██████╔╝██║██╔██╗ ██║██║  ███╗ ");
        Font.print(Font.ANSI_CYAN, "\t\t ██║     ██╔══██║   ██║   ██╔══╝  ██╔══██╗██║██║╚██╗██║██║   ██║");
        Font.print(Font.ANSI_YELLOW, "\t\t ╚██████╗██║  ██║   ██║   ███████╗██║  ██║██║██║ ╚████║╚██████╔╝");
        Font.print(Font.ANSI_YELLOW, "\t\t  ╚═════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝ ╚═════╝ ");
        System.out.println("==================================================================================================");
        System.out.println("\t\t\t\t\t1. Food & Beverage\n\t\t\t\t\t2. Facility\n\t\t\t\t\t3. Payment\n\t\t\t\t\t4. Exit");
        System.out.println("==================================================================================================");
    }

    public static void displayEndScreen() {
        Font.print(Font.ANSI_YELLOW,"████████╗██╗  ██╗ █████╗ ███╗   ██╗██╗  ██╗    ██╗   ██╗ ██████╗ ██╗   ██╗    ██╗██╗");
        Font.print(Font.ANSI_YELLOW,"╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██║ ██╔╝    ╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║██║");
        Font.print(Font.ANSI_YELLOW,"   ██║   ███████║███████║██╔██╗ ██║█████╔╝      ╚████╔╝ ██║   ██║██║   ██║    ██║██║");
        Font.print(Font.ANSI_YELLOW,"   ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗       ╚██╔╝  ██║   ██║██║   ██║    ╚═╝╚═╝");
        Font.print(Font.ANSI_YELLOW,"   ██║   ██║  ██║██║  ██║██║ ╚████║██║  ██╗       ██║   ╚██████╔╝╚██████╔╝    ██╗██╗");
        Font.print(Font.ANSI_YELLOW,"   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝       ╚═╝    ╚═════╝  ╚═════╝     ╚═╝╚═╝");
        continueMessage();
    }

    // START OF ADMIN SECTION
    public static void Admin(Order O) {

        boolean check = admin.Login();
        if (check == true) {
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

    public static void continueMessage(){
        Scanner input = new Scanner(System.in);
        System.out.print("\t\t\t       Enter to continue...");
        input.nextLine();
        Screen.clear();
    }
}

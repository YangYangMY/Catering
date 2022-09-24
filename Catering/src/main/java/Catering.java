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
        ListInterface<Accessories> fbAccessoriesList = new List<Accessories>(20);
        BagInterface<Accessories> fbAccessoriesSelect = new Bag<Accessories>(100);
        
        //Facility Initialisation
        ListInterface<Facility> facilitySizeList = new List<Facility>(100);
        ListInterface<Facility> facilityColorList = new List<Facility>(100);
        ListInterface<Facility> facilityOccasionList = new List<Facility>(100);
        ListInterface<Facility> sizeselect = new List<Facility>(100);
        ListInterface<Facility> colorselect = new List<Facility>(100);
        ListInterface<Facility> occasionselect = new List<Facility>(100);
        ListInterface<Accessories> facilityAccessoriesList = new List<Accessories>(20);
        BagInterface<Accessories> facilityAccessoriesSelect = new Bag<Accessories>(100);

        //Booking Initialisation
        ListInterface<BookingInfo> bookinglist = new List<BookingInfo>(100);

        //Payment
        MapInterface<Integer, Payment> payments = new Map<Integer, Payment>();

        //Customer
        MapInterface<String, Customer> customers = new Map<String, Customer>();

        //Order Init
        CircularQueueInterface<Order> orderQueue = new CircularQueue<>();
        SortedListInterface<Order> acceptedOrder = new SortedList<>();
        SortedListInterface<Order> rejectedOrder = new SortedList<>();

        //Order dummy test
        dummyScript.DummyOrderData(orderQueue);

        //initialise
        initialize(foodlist, beveragelist, fbAccessoriesList, facilitySizeList, facilityColorList, facilityOccasionList, facilityAccessoriesList);

        Scanner input = new Scanner(System.in);

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
                                foodandbeverage.foodbeverage(foodlist, beveragelist, foodselect, beverageselect, fbAccessoriesList, fbAccessoriesSelect);
                                break;
                            case 2: // call facility
                                facilities.facilitiess(facilitySizeList, facilityColorList, facilityOccasionList, sizeselect, colorselect, occasionselect, facilityAccessoriesList, facilityAccessoriesSelect);
                                break;
                            case 3: // call payment
                                if(foodselect.isEmpty() || beverageselect.isEmpty() || sizeselect.isEmpty() || colorselect.isEmpty() || occasionselect.isEmpty()){
                                    Font.print(Font.RED_BOLD_BRIGHT, "\t\tPlease select all the options before proceed to payment!");
                                    continueMessage();
                                } else if(bookinglist.isFull()){
                                    Font.print(Font.RED_BOLD_BRIGHT, "\t\tSorry, the booking list is full!");
                                    continueMessage();
                                } else {
                                    //Payment Start Here
                                    if(bookinglist.positionCheck(BookingInfo.bookingPosition)){
                                        bookinglist.set(BookingInfo.bookingPosition, new BookingInfo(foodselect, beverageselect, sizeselect, colorselect, occasionselect, fbAccessoriesSelect, facilityAccessoriesSelect));
                                        choice1 = payment.pymt(customers, payments, bookinglist, orderQueue);
                                    } else {
                                        bookinglist.add(new BookingInfo(foodselect, beverageselect, sizeselect, colorselect, occasionselect, fbAccessoriesSelect, facilityAccessoriesSelect));
                                        choice1 = payment.pymt(customers, payments, bookinglist, orderQueue);
                                    }
                                }
                                break;
                            case 4: // Exit to Home Menu
                                int confirm = Screen.numInputValid(0,1,"\t\tAll cart will be clear. Are you sure? (1 = Yes, 0 = No): ", "\t\tInvalid input. Please try again");
                                Screen.clear();
                                if (confirm == 0){
                                    choice1 = 0;
                                }
                                break;
                        }
                        if(choice1 == 4){
                            clearList(foodlist, beveragelist, foodselect, beverageselect, fbAccessoriesList, fbAccessoriesSelect, facilitySizeList, facilityColorList, facilityOccasionList, sizeselect, colorselect, occasionselect, facilityAccessoriesList, facilityAccessoriesSelect);
                        }
                    } while (choice1 != 4);
                    break;
                case 2: // Admin
                    Admin(orderQueue, acceptedOrder, rejectedOrder);
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
    public static void Admin(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder) {

        boolean check = admin.login();
        if (check == true) {
            admin.Menu(orderQueue, acceptedOrder, rejectedOrder);
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

    public static void clearList(ListInterface<FoodBeverage> foodlist, ListInterface<FoodBeverage> beveragelist, ListInterface<FoodBeverage> foodselect, ListInterface<FoodBeverage> beverageselect, ListInterface<Accessories> fbAccessoriesList, BagInterface<Accessories> fbAccessoriesSelect, ListInterface<Facility> facilitySizeList, ListInterface<Facility> facilityColorList, ListInterface<Facility> facilityOccasionList,
    ListInterface<Facility> sizeselect, ListInterface<Facility> colorselect, ListInterface<Facility> occasionselect, ListInterface<Accessories> facilityAccessoriesList, BagInterface<Accessories> facilityAccessoriesSelect){
        foodselect.clear();
        beverageselect.clear();
        fbAccessoriesSelect.clear();
        sizeselect.clear();
        colorselect.clear();
        occasionselect.clear();
        facilityAccessoriesSelect.clear();
    }

    public static void initialize(ListInterface<FoodBeverage> foodlist, ListInterface<FoodBeverage> beveragelist, ListInterface<Accessories> fbAccessoriesList, ListInterface<Facility> facilitySizeList, ListInterface<Facility> facilityColorList, ListInterface<Facility> facilityOccasionList, ListInterface<Accessories> facilityAccessoriesList){
        //Food List 
        foodlist.add(new FoodBeverage("Fried Chicken", 6.0));
        foodlist.add(new FoodBeverage("Nasi Lemak", 2.0));
        foodlist.add(new FoodBeverage("Rendang Chicken", 6.5));
        foodlist.add(new FoodBeverage("Fried Noodle", 2.5));
        foodlist.add(new FoodBeverage("Chicken Salad", 5.0));
        //Beverage List
        beveragelist.add(new FoodBeverage("Coca-Cola", 2.0));
        beveragelist.add(new FoodBeverage("Lemonade", 1.5));
        beveragelist.add(new FoodBeverage("Plain Water", 0.5));
        beveragelist.add(new FoodBeverage("Green Tea", 1.8));
        beveragelist.add(new FoodBeverage("Honey Lemon", 3.5));
        //Accessories List
        fbAccessoriesList.add(new Accessories("Cutlery Set")); 
        fbAccessoriesList.add(new Accessories("Tissue Box"));
        fbAccessoriesList.add(new Accessories("Napkin"));
        fbAccessoriesList.add(new Accessories("Paper Cup & Plate"));
        // Size lol
        facilitySizeList.add(new Facility("Small", 500.00));
        facilitySizeList.add(new Facility("Medium", 1000.00));
        facilitySizeList.add(new Facility("Large", 1500.00));
        // Color lmao
        facilityColorList.add(new Facility("Red", 50.00));
        facilityColorList.add(new Facility("Blue", 50.00));
        facilityColorList.add(new Facility("Green", 50.00));
        facilityColorList.add(new Facility("Yellow", 50.00));
        facilityColorList.add(new Facility("Orange", 50.00));
        facilityColorList.add(new Facility("Purple", 50.00));
        facilityColorList.add(new Facility("Pink", 50.00));
        facilityColorList.add(new Facility("Black", 50.00));
        facilityColorList.add(new Facility("White", 50.00));
        facilityColorList.add(new Facility("Brown", 50.00));
        //Occasion lmfao
        facilityOccasionList.add(new Facility("Birthday", 100.00));
        facilityOccasionList.add(new Facility("Wedding", 100.00));
        facilityOccasionList.add(new Facility("Graduation", 100.00));
        facilityOccasionList.add(new Facility("Baby Shower", 100.00));
        facilityOccasionList.add(new Facility("Anniversary", 100.00));
        facilityOccasionList.add(new Facility("Retirement", 100.00));
        facilityOccasionList.add(new Facility("Prom", 100.00));
        facilityOccasionList.add(new Facility("Christmas", 100.00));
        facilityOccasionList.add(new Facility("Thanksgiving", 100.00));
        facilityOccasionList.add(new Facility("Halloween", 100.00));
        facilityOccasionList.add(new Facility("Easter", 100.00));
        facilityOccasionList.add(new Facility("Valentine's Day", 100.00));
        facilityOccasionList.add(new Facility("New Year's Eve", 100.00));
        //Accessories
        facilityAccessoriesList.add(new Accessories("LED light")); 
        facilityAccessoriesList.add(new Accessories("Board Game"));
        facilityAccessoriesList.add(new Accessories("Rubbish Bin"));
        facilityAccessoriesList.add(new Accessories("Rubbish Bag"));
    }
}
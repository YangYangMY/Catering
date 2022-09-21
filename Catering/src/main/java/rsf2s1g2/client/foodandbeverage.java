package rsf2s1g2.client;

import java.util.Scanner;
import java.text.DecimalFormat;
import rsf2s1g2.utility.*;
import rsf2s1g2.adt.*;
import rsf2s1g2.entity.*;

public class foodandbeverage {
    public static void foodbeverage(ListInterface<FoodBeverage> foodlist, ListInterface<FoodBeverage> beveragelist, ListInterface<FoodBeverage> foodselect, ListInterface<FoodBeverage> beverageselect, ListInterface<Accessories> fbAccessoriesList, BagInterface<Accessories> fbAccessoriesSelect) {
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner input = new Scanner(System.in);
        int choice, action, position = 1, quantity = 0;
        final int num4Bag = 10;
        initialize(foodlist, beveragelist, fbAccessoriesList);

        do {
            // 1 = food, 2 = beverage, 3 = exit
            Screen.clear();
            displayFAB();
            choice = Screen.numInputValid(1,4,"\t\t\t\t\t\t\t       Select your Choice: ", "\t\t\t\t\t\t\t       Invalid input. Please try again");
            Screen.clear();
            switch (choice) {
                case 1:
                    do {
                        displayFoodSelect(foodselect, df);
                        displayFoodOption();
                        action = Screen.numInputValid(1,5,"\t\tSelect your Choice: ", "\t\tInvalid input. Please try again");
                        Screen.clear();
                        // Add = 1, Remove = 2, Clear = 3, Modify = 4, Back = 5
                        switch (action) {
                            case 1:
                                displayFoodList(foodlist);
                                position = Screen.numInputValid(1,5,"\tSelect Food to Add (1-5): ", "\tInvalid input. Please try again");
                                if (foodlist.size() < position || position < 1) {
                                    Font.print(Font.RED_BOLD_BRIGHT,"\t\tInvalid choice!");
                                    continueMessage();
                                } else {
                                    quantity = Screen.numInputValid(1,5000,"\tHow many do you want to add?: ", "\tPlease enter number within 1-5000");
                                    foodSelectModifications(foodselect, foodlist, action, position, quantity);
                                }
                                break;
                            case 2:
                                if (foodselect.isEmpty()) {
                                    System.out.println("\t\tNo food is selected!");
                                    continueMessage();
                                } else {
                                    displayFoodSelect(foodselect, df);
                                    position = Screen.numInputValid(1,5,"\tSelect the item to be removed: ", "\tInvalid input. Please try again");
                                    if (foodselect.size() < position || position < 1) {
                                        Font.print(Font.RED_BOLD_BRIGHT,"\t\tInvalid choice!");
                                        continueMessage();
                                    } else {
                                        foodSelectModifications(foodselect, foodlist, action, position, quantity);
                                    }
                                }
                                break;
                            case 3:
                                int confirm = Screen.numInputValid(0,1,"\t\tThe food cart will be clear. Are you sure? (1 = Yes, 0 = No): ", "\t\tInvalid input. Please try again");
                                if (confirm == 1 && !foodselect.isEmpty())
                                    foodSelectModifications(foodselect, foodlist, action, position, quantity);
                                Screen.clear();
                                break;
                            case 4:
                                if (foodselect.isEmpty()) {
                                    System.out.println("\t\tNo food is selected!");
                                    continueMessage();
                                } else {
                                    displayFoodSelect(foodselect, df);
                                    position = Screen.numInputValid(1,5,"\tSelect the item to be modified: ", "\tInvalid input. Please try again");
                                    if (foodselect.size() < position || position < 1) {
                                        System.out.println("\t\tInvalid choice!");
                                        continueMessage();
                                    } else {
                                        quantity = Screen.numInputValid(1,5,"\tEnter the number: ", "\tInvalid input. Please try again");
                                        foodSelectModifications(foodselect, foodlist, action, position, quantity);
                                    }
                                }
                                break;
                            case 5:
                                break;
                        }
                    } while (action != 5);
                    break;
                case 2:
                    do {
                        displayBeverageSelect(beverageselect, df);
                        displayBeverageOption();
                        action = Screen.numInputValid(1,5,"\t\tSelect your Choice: ", "\t\tInvalid input. Please try again");
                        Screen.clear();
                        // Add = 1, Remove = 2, Clear = 3, Modify = 4, Back = 5
                        switch (action) {
                            case 1:
                                displayBeverageList(beveragelist);
                                position = Screen.numInputValid(1,5,"\tSelect Beverage to Add (1-5): ", "\tInvalid input. Please try again");
                                if (beveragelist.size() < position || position < 1) {
                                    Font.print(Font.RED_BOLD_BRIGHT,"\t\tInvalid choice!");
                                    continueMessage();
                                } else {
                                    quantity = Screen.numInputValid(1,5000,"\tHow many do you want to add?: ", "\tPlease enter number within 1-5000");
                                    foodSelectModifications(beverageselect, beveragelist, action, position, quantity);
                                }
                                break;
                            case 2:
                                if (beverageselect.isEmpty()) {
                                    System.out.println("\t\tNo beverage is selected!");
                                    continueMessage();
                                } else {
                                    displayBeverageSelect(beverageselect, df);
                                    position = Screen.numInputValid(1,5,"\tSelect the item to be removed: ", "\tInvalid input. Please try again");
                                    if (beverageselect.size() < position || position < 1) {
                                        Font.print(Font.RED_BOLD_BRIGHT,"\t\tInvalid choice!");
                                        continueMessage();
                                    } else {
                                        foodSelectModifications(beverageselect, beveragelist, action, position, quantity);
                                    }
                                }
                                break;
                            case 3:
                                int confirm = Screen.numInputValid(0,1,"\t\tThe beverage cart will be clear. Are you sure? (1 = Yes, 0 = No): ", "\t\tInvalid input. Please try again");
                                if (confirm == 1 && !beverageselect.isEmpty())
                                    foodSelectModifications(beverageselect, beveragelist, action, position, quantity);
                                Screen.clear();
                                break;
                            case 4:
                                if (beverageselect.isEmpty()) {
                                    System.out.println("\t\tNo beverage is selected!");
                                    continueMessage();
                                } else {
                                    displayFoodSelect(beverageselect, df);
                                    position = Screen.numInputValid(1,5,"\tSelect the item to be modified: ", "\tInvalid input. Please try again");
                                    if (beverageselect.size() < position || position < 1) {
                                        Font.print(Font.RED_BOLD_BRIGHT,"\t\tInvalid choice!");
                                        continueMessage();
                                    } else {
                                        quantity = Screen.numInputValid(1,5,"\tEnter the number: ", "\tInvalid input. Please try again");
                                        foodSelectModifications(beverageselect, beveragelist, action, position, quantity);
                                    }
                                }
                                break;
                            case 5:
                                // Exit
                                break;
                        }
                    } while (action != 5);
                    break;
                case 3:
                    // Accessories
                    do{
                        displayAccessoriesSelect(fbAccessoriesSelect);
                        Accessories.displayAccesorries();
                        action = Screen.numInputValid(1,3,"\t\t\tSelect your Choice: ", "\t\t\tInvalid input. Please try again");
                        Screen.clear();
                        switch(action){
                            case 1: //add
                                displayAccesorriesList(fbAccessoriesList);
                                position = Screen.numInputValid(1,4,"  Select Accesorries to Add (1-4): ", " Invalid input. Please try again");
                                if (fbAccessoriesList.size() < position || position < 1) {
                                    Font.print(Font.RED_BOLD_BRIGHT,"\t\tInvalid choice!");
                                    continueMessage();
                                } else {
                                    fbAccessoriesSelect.add(new Accessories(fbAccessoriesList.get(position).getAccName(), num4Bag));
                                    System.out.println("\tAdd Successful");
                                    continueMessage();
                                }
                                break;
                            case 2: //clear
                                int confirm = Screen.numInputValid(0,1,"\t\tThe accessories cart will be clear. Are you sure? (1 = Yes, 0 = No): ", "\t\tInvalid input. Please try again");
                                if (confirm == 1 && !fbAccessoriesSelect.isEmpty()){
                                    fbAccessoriesSelect.clear();
                                    System.out.println("\t\tClear Successful");
                                    continueMessage();
                                }
                                break; 
                            case 3: 
                                //Exit
                                break;
                        }
                    } while(action != 3);
                    break;
                case 4:
                    // Exit
                    break;
            }
        } while (choice != 4);
    }
    
    public static void displayFAB(){
        Font.print(Font.ANSI_YELLOW,"\t ███████╗ ██████╗  ██████╗ ██████╗      █████╗ ███╗   ██╗██████╗     ██████╗ ███████╗██╗   ██╗███████╗██████╗  █████╗  ██████╗ ███████╗ ");
        Font.print(Font.ANSI_YELLOW,"\t ██╔════╝██╔═══██╗██╔═══██╗██╔══██╗    ██╔══██╗████╗  ██║██╔══██╗    ██╔══██╗██╔════╝██║   ██║██╔════╝██╔══██╗██╔══██╗██╔════╝ ██╔════╝ ");
        Font.print(Font.ANSI_YELLOW,"\t █████╗  ██║   ██║██║   ██║██║  ██║    ███████║██╔██╗ ██║██║  ██║    ██████╔╝█████╗  ██║   ██║█████╗  ██████╔╝███████║██║  ███╗█████╗   ");
        Font.print(Font.ANSI_YELLOW,"\t ██╔══╝  ██║   ██║██║   ██║██║  ██║    ██╔══██║██║╚██╗██║██║  ██║    ██╔══██╗██╔══╝  ╚██╗ ██╔╝██╔══╝  ██╔══██╗██╔══██║██║   ██║██╔══╝   ");
        Font.print(Font.ANSI_YELLOW,"\t ██║     ╚██████╔╝╚██████╔╝██████╔╝    ██║  ██║██║ ╚████║██████╔╝    ██████╔╝███████╗ ╚████╔╝ ███████╗██║  ██║██║  ██║╚██████╔╝███████╗ ");
        Font.print(Font.ANSI_YELLOW,"\t ╚═╝      ╚═════╝  ╚═════╝ ╚═════╝     ╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝     ╚═════╝ ╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝ ");
        System.out.println("=================================================================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t1. Food\n\t\t\t\t\t\t\t\t2. Beverage\n\t\t\t\t\t\t\t\t3. Accessories\n\t\t\t\t\t\t\t\t4. Exit");
        System.out.println("=================================================================================================================================================");
    }

    public static void initialize(ListInterface<FoodBeverage> foodlist, ListInterface<FoodBeverage> beveragelist, ListInterface<Accessories> fbAccessoriesList){
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
    }

    public static void displayFoodList(ListInterface<FoodBeverage> foodlist){
        FoodBeverage.resetNum();
        System.out.println("================================================");
        System.out.println("\tFOOD NAME \t\tPRICE(RM)");
        System.out.println("================================================");
        System.out.print(foodlist.toString());
        System.out.println("================================================");
    }

    public static void displayBeverageList(ListInterface<FoodBeverage> beveragelist){
        FoodBeverage.resetNum();
        System.out.println("================================================");
        System.out.println("\tBEVERAGE NAME \t\tPRICE(RM)");
        System.out.println("================================================");
        System.out.print(beveragelist.toString());
        System.out.println("================================================");
    }

    public static void displayAccesorriesList(ListInterface<Accessories> fbAccessoriesList){
        Accessories.resetNum();
        System.out.println("======================================");
        System.out.println("\tACCESSORIES NAME ");
        System.out.println("======================================");
        System.out.print(fbAccessoriesList.toString());
        System.out.println("======================================");
        System.out.println("\t10 per add");
        System.out.println("======================================");
    }

    public static void displayFoodSelect(ListInterface<FoodBeverage> foodselect, DecimalFormat df){
        Font.print(Font.PURPLE_BOLD_BRIGHT,"\t\t\t\t\tFOOD CART");
        if(!foodselect.isEmpty()){
            FoodBeverage.resetNum();
            System.out.println("===================================================================================");
            System.out.println("\tFOOD NAME \t\tQUANTITY  \tPRICE(RM)  \tTOTAL(RM)");
            System.out.println("===================================================================================");
            System.out.print(foodselect.toString());
            System.out.println("===================================================================================");
            Font.print(Font.ANSI_YELLOW,"\t\t\t\t\t\tFINAL TOTAL \t  " + df.format(foodselect.get(1).getFoodFinaltotal()));
            System.out.println("===================================================================================");
        } else {
            System.out.println("===================================================================================");
            Font.print(Font.RED_BOLD_BRIGHT,"\t\t\t\t     NO FOOD SELECTED");
            System.out.println("===================================================================================");
        }
    }

    public static void displayBeverageSelect(ListInterface<FoodBeverage> beverageselect, DecimalFormat df){
        Font.print(Font.PURPLE_BOLD_BRIGHT,"\t\t\t\tBEVERAGE CART");
        if(!beverageselect.isEmpty()){
            FoodBeverage.resetNum();
            System.out.println("===================================================================================");
            System.out.println("\tBEVERAGE NAME \t\tQUANTITY  \tPRICE(RM)  \tTOTAL(RM)");
            System.out.println("===================================================================================");
            System.out.print(beverageselect.toString());
            System.out.println("===================================================================================");
            Font.print(Font.ANSI_YELLOW,"\t\t\t\t\t\tFINAL TOTAL \t  " + df.format(beverageselect.get(1).getBeverageFinaltotal()));
            System.out.println("===================================================================================");
        } else {
            System.out.println("===================================================================================");
            Font.print(Font.RED_BOLD_BRIGHT,"\t\t\t     NO BEVERAGE SELECTED");
            System.out.println("===================================================================================");
        }
    }

    public static void displayAccessoriesSelect(BagInterface<Accessories> fbAccessoriesSelect){
        Font.print(Font.PURPLE_BOLD_BRIGHT,"\t\t\t  ACCESSORIES CART");
        if(!fbAccessoriesSelect.isEmpty()){
            Accessories.resetNum();
            System.out.println("====================================================================");
            System.out.println("\tACCESSORIES NAME \t\tQUANTITY");
            System.out.println("====================================================================");
            System.out.println(fbAccessoriesSelect.toString());
            System.out.println("====================================================================");
            System.out.println("TOTAL ITEMS SELECTED = " + fbAccessoriesSelect.getCurrentSize());
            System.out.println("====================================================================");
        } else {
            System.out.println("====================================================================");
            Font.print(Font.RED_BOLD_BRIGHT,"\t\t\tNO ACCESSORIES SELECTED");
            System.out.println("====================================================================");
        }
    }

    public static void displayFoodOption(){
        System.out.println("\t\t1. Add Food\n\t\t2. Remove Food\n\t\t3. Clear All Food\n\t\t4. Modify Quantity\n\t\t5. Exit");
        System.out.println("===================================================================================");
    }

    public static void displayBeverageOption(){
        System.out.println("\t\t\t1. Add Beverage\n\t\t\t2. Remove Beverage\n\t\t\t3. Clear All Beverage\n\t\t\t4. Modify Quantity\n\t\t\t5. Exit");
        System.out.println("===================================================================================");
    }

    public static void foodSelectModifications(ListInterface<FoodBeverage> fbselect, ListInterface<FoodBeverage> fblist, int action, int posOfObj, int fbNum){
        Scanner input = new Scanner(System.in);
        //Add = 1, Remove = 2, Clear = 3, Undo = 4, Modify = 5
        if (action == 1){
            boolean isDuplicate = false;
            if(!fbselect.isEmpty()){
                for(int i = 1; i < fbselect.size() + 1; i++){
                    if(fblist.get(posOfObj).getFoodname().equals(fbselect.get(i).getFoodname())){
                        System.out.println("\tFood has already been selected before");
                        continueMessage();
                        isDuplicate = true;
                    }
                }
            } 
            if (isDuplicate == false){
                fbselect.add(new FoodBeverage(fblist.get(posOfObj).getFoodname(), fbNum, fblist.get(posOfObj).getFoodprice()));
                setFinaltotalXYZ(fbselect, fblist);
                System.out.println("\tAdd Successful");
                continueMessage();
            }
        } else if (action == 2){
            if(posOfObj < 1 || posOfObj > fblist.size()){
                System.out.println("\tInvalid Position");
                continueMessage();
            } else {
                if(fbselect.size() == 1){
                    if(fblist.get(1).getFoodname().equals("Fried Chicken")){
                        fbselect.get(posOfObj).setFoodFinaltotal(0);
                    } else {
                        fbselect.get(posOfObj).setBeverageFinaltotal(0);
                    }
                    fbselect.clear();
                    System.out.println("\tRemove Successful");
                    continueMessage();
                } else {
                    fbselect.remove(posOfObj);
                    setFinaltotalXYZ(fbselect, fblist);
                    System.out.println("\tRemove Successful");
                    continueMessage();
                }
        }
        } else if (action == 3){
            if(fblist.get(1).getFoodname().equals("Fried Chicken")){
                fbselect.get(posOfObj).setFoodFinaltotal(0);
            } else {
                fbselect.get(posOfObj).setBeverageFinaltotal(0);
            }
            fbselect.clear();
            System.out.println("\t\tClear Successful");
            continueMessage();
        } else if (action == 4){
            if(posOfObj < 1 || posOfObj > fblist.size()){
                System.out.println("Invalid Position");
                continueMessage();
            } else {
                fbselect.set(posOfObj, new FoodBeverage(fbselect.get(posOfObj).getFoodname(), fbNum, fbselect.get(posOfObj).getFoodprice()));
                setFinaltotalXYZ(fbselect, fblist);
                System.out.println("\tModify Successful");
                continueMessage();
            }
        }
    }

    public static void setFinaltotalXYZ(ListInterface<FoodBeverage> fbselect, ListInterface<FoodBeverage> fblist){
        if(fblist.get(1).getFoodname().equals("Fried Chicken")){
            fbselect.get(1).setFoodFinaltotal(0);
            for (int i = 1; i < fbselect.size() + 1; i++){
                fbselect.get(i).setFoodFinaltotal(fbselect.get(i).getFoodFinaltotal() + fbselect.get(i).getFoodtotal());
            }
        } else {
            fbselect.get(1).setBeverageFinaltotal(0);
            for (int i = 1; i < fbselect.size() + 1; i++){
                fbselect.get(i).setBeverageFinaltotal(fbselect.get(i).getBeverageFinaltotal() + fbselect.get(i).getFoodtotal());
            }
        }
    }

    public static void continueMessage(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter to continue...");
        input.nextLine();
        Screen.clear();
    }

    // count the total number of entries in the bag
    public static int getNumberOfEntries(BagInterface<FoodBeverage> Bag) {
        int numberOfEntries = 0;
        Object[] bagArray = Bag.toArray();
        for (int index = 0; index < bagArray.length; index++) {
            numberOfEntries++;
        } // end for
        return numberOfEntries;
    } // end getNumberOfEntries
    

}

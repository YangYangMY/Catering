package rsf2s1g2.client;

import java.util.Scanner;

import rsf2s1g2.utility.*;
import rsf2s1g2.adt.*;
import rsf2s1g2.entity.*;


/**
 *
 * @author Wee Yan
 * 
 */


public class admin {
    

    public static boolean login(){
        boolean check = true;
        Scanner input1 = new Scanner(System.in);
        String username = "admin";
        String password = "123123";
        int times = 3;
        boolean contactManagement = true;
        //Login 
        System.out.println("\t\t\t\t\tAdmin");
        System.out.println("==================================================================================================");
        Font.print(Font.ANSI_BLUE,"                                     Login Page");
        do {
            try {
                System.out.print("                                   Username: ");
                String enteredUsername = input1.nextLine();
                System.out.print("                                   Password: ");
                String enteredPassword = input1.nextLine();
                if (!enteredUsername.equals(username) || !enteredPassword.equals(password)) {
                    throw new InvalidException();
                } else {
                    //Stop Loop when correct username and password
                    times = 0;
                    contactManagement = false;

                    //Enter menu with all objects made
                    Screen.clear();
                    check = true;
                }

            } catch (InvalidException e) {
                Screen.clear();
                Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tAdmin");
                System.out.println("==================================================================================================");
                Font.print(Font.ANSI_BLUE,"                                     Login Page");
                Font.print(Font.ANSI_RED, e.getErrorMsg());
                times--;
                contactManagement = true;
                
            }
        } while (times > 0);

        if (contactManagement) {
            Screen.clear();
            System.out.println("\n");
            Font.print(Font.ANSI_RED, "   Sorry, you have reached the maximum times of login. Please contact the management for the username and password\n");
            Font.print(Font.ANSI_RED, "   Bringing you back to Home screen in 5 Seconds.\n");
            Screen.pause(5);
            Screen.clear();
            check = false;
        }
        return check;
    }

    public static int orderidCheck(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder, int orderid){
        Screen.clear();
        int check = 0;

        int currentOrderId = Order.getNextOrderID();
        if(orderid < (currentOrderId) && orderid >= 2001){
            for (int i = orderQueue.getFront(); i <= orderQueue.getRear(); i++){
                if((orderQueue.getEntry(i).getOrderId()) == orderid){
                    check = 1;
                }
            } 
            for (int i = 0; i < acceptedOrder.getCount(); i++){
                if(acceptedOrder.getEntry(i).getOrderId() == orderid){
                    check = 2;
                }
            }
            for(int i = 0; i < rejectedOrder.getCount(); i++){
                if(rejectedOrder.getEntry(i).getOrderId() == orderid){
                    check = 3;
                }
            }
        }
        else{
            Screen.clear();
            Font.print(Font.ANSI_RED, "                            Order ID is not found, please try again!\n");
            check = 0;
        }

        return check;
    }


public static void displayOrderMenu(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder, int orderid){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Details");
    System.out.println("==================================================================================================");
    Font.print(Font.ANSI_CYAN, "Order Id : " + orderid);
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\n\t\t\t\t[1] Customer\n\t\t\t\t[2] Food Summary\n\t\t\t\t[3] Beverage Summary\n\t\t\t\t[4] Food & Beverage Accessories Summary\n\t\t\t\t[5] Facility Size Summary\n\t\t\t\t[6] Facility Color Summary\n\t\t\t\t[7] Facility Occassion Summary\n\t\t\t\t[8] Facility Accessories Summary\n\t\t\t\t[9] Back");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
}

public static void displayCustomer(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder, int orderid, int check){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Details");
    System.out.println("==================================================================================================");
    Font.print(Font.ANSI_CYAN, "Order Id : " + orderid);
    System.out.println("-------------------------------------------------------------------------------------------------------");
    
    if (check == 1){
        for (int i = orderQueue.getFront(); i <= orderQueue.getRear(); i++){
            if((orderQueue.getEntry(i).getOrderId()) == orderid){
                orderQueue.getEntry(i).getcustomer();
            }
        } 
    }
    else if (check == 2){
        for (int i = 0; i < acceptedOrder.getCount(); i++){
            if(acceptedOrder.getEntry(i).getOrderId() == orderid){
                acceptedOrder.getEntry(i).getcustomer();
            }
        }
    }
    else{
        for(int i = 0; i < rejectedOrder.getCount(); i++){
            if(rejectedOrder.getEntry(i).getOrderId() == orderid){
                rejectedOrder.getEntry(i).getcustomer();
            }
        }
    }
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\n\t\t\t\t[1] Customer\n\t\t\t\t[2] Food Summary\n\t\t\t\t[3] Beverage Summary\n\t\t\t\t[4] Food & Beverage Accessories Summary\n\t\t\t\t[5] Facility Size Summary\n\t\t\t\t[6] Facility Color Summary\n\t\t\t\t[7] Facility Occassion Summary\n\t\t\t\t[8] Facility Accessories Summary\n\t\t\t\t[9] Back");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
}


public static void displayFood(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder, int orderid, int check){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Details");
    System.out.println("==================================================================================================");
    Font.print(Font.ANSI_CYAN, "Order Id : " + orderid);
    System.out.println("-------------------------------------------------------------------------------------------------------");
    
    if (check == 1){
        for (int i = orderQueue.getFront(); i <= orderQueue.getRear(); i++){
            if((orderQueue.getEntry(i).getOrderId()) == orderid){
                orderQueue.getEntry(i).getBookingInfo().get(1).getFoodselect();;
            }
        } 
    }
    else if (check == 2){
        for (int i = 0; i < acceptedOrder.getCount(); i++){
            if(acceptedOrder.getEntry(i).getOrderId() == orderid){
                acceptedOrder.getEntry(i).getBookingInfo().get(1).getFoodselect();
            }
        }
    }
    else{
        for(int i = 0; i < rejectedOrder.getCount(); i++){
            if(rejectedOrder.getEntry(i).getOrderId() == orderid){
                rejectedOrder.getEntry(i).getBookingInfo().get(1).getFoodselect();
            }
        }
    }
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\n\t\t\t\t[1] Customer\n\t\t\t\t[2] Food Summary\n\t\t\t\t[3] Beverage Summary\n\t\t\t\t[4] Food & Beverage Accessories Summary\n\t\t\t\t[5] Facility Size Summary\n\t\t\t\t[6] Facility Color Summary\n\t\t\t\t[7] Facility Occassion Summary\n\t\t\t\t[8] Facility Accessories Summary\n\t\t\t\t[9] Back");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
}

public static void displayBeverage(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder, int orderid, int check){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Details");
    System.out.println("==================================================================================================");
    Font.print(Font.ANSI_CYAN, "Order Id : " + orderid);
    System.out.println("-------------------------------------------------------------------------------------------------------");
    
    if (check == 1){
        for (int i = orderQueue.getFront(); i <= orderQueue.getRear(); i++){
            if((orderQueue.getEntry(i).getOrderId()) == orderid){
                orderQueue.getEntry(i).getBookingInfo().get(1).getBeverageselect();
            }
        } 
    }
    else if (check == 2){
        for (int i = 0; i < acceptedOrder.getCount(); i++){
            if(acceptedOrder.getEntry(i).getOrderId() == orderid){
                acceptedOrder.getEntry(i).getBookingInfo().get(1).getBeverageselect();
            }
        }
    }
    else{
        for(int i = 0; i < rejectedOrder.getCount(); i++){
            if(rejectedOrder.getEntry(i).getOrderId() == orderid){
                rejectedOrder.getEntry(i).getBookingInfo().get(1).getBeverageselect();
            }
        }
    }
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\n\t\t\t\t[1] Customer\n\t\t\t\t[2] Food Summary\n\t\t\t\t[3] Beverage Summary\n\t\t\t\t[4] Food & Beverage Accessories Summary\n\t\t\t\t[5] Facility Size Summary\n\t\t\t\t[6] Facility Color Summary\n\t\t\t\t[7] Facility Occassion Summary\n\t\t\t\t[8] Facility Accessories Summary\n\t\t\t\t[9] Back");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
}

public static void displayFBaccess(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder, int orderid, int check){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Details");
    System.out.println("==================================================================================================");
    Font.print(Font.ANSI_CYAN, "Order Id : " + orderid);
    System.out.println("-------------------------------------------------------------------------------------------------------");
    
    if (check == 1){
        for (int i = orderQueue.getFront(); i <= orderQueue.getRear(); i++){
            if((orderQueue.getEntry(i).getOrderId()) == orderid){
                orderQueue.getEntry(i).getBookingInfo().get(1).getFbAccessoriesSelect();
            }
        } 
    }
    else if (check == 2){
        for (int i = 0; i < acceptedOrder.getCount(); i++){
            if(acceptedOrder.getEntry(i).getOrderId() == orderid){
                acceptedOrder.getEntry(i).getBookingInfo().get(1).getFbAccessoriesSelect();
            }
        }
    }
    else{
        for(int i = 0; i < rejectedOrder.getCount(); i++){
            if(rejectedOrder.getEntry(i).getOrderId() == orderid){
                rejectedOrder.getEntry(i).getBookingInfo().get(1).getFbAccessoriesSelect();
            }
        }
    }
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\n\t\t\t\t[1] Customer\n\t\t\t\t[2] Food Summary\n\t\t\t\t[3] Beverage Summary\n\t\t\t\t[4] Food & Beverage Accessories Summary\n\t\t\t\t[5] Facility Size Summary\n\t\t\t\t[6] Facility Color Summary\n\t\t\t\t[7] Facility Occassion Summary\n\t\t\t\t[8] Facility Accessories Summary\n\t\t\t\t[9] Back");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
}

public static void displayFacilitySize(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder, int orderid, int check){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Details");
    System.out.println("==================================================================================================");
    Font.print(Font.ANSI_CYAN, "Order Id : " + orderid);
    System.out.println("-------------------------------------------------------------------------------------------------------");
    
    if (check == 1){
        for (int i = orderQueue.getFront(); i <= orderQueue.getRear(); i++){
            if((orderQueue.getEntry(i).getOrderId()) == orderid){
                orderQueue.getEntry(i).getBookingInfo().get(1).getSizeselect();
            }
        } 
    }
    else if (check == 2){
        for (int i = 0; i < acceptedOrder.getCount(); i++){
            if(acceptedOrder.getEntry(i).getOrderId() == orderid){
                acceptedOrder.getEntry(i).getBookingInfo().get(1).getSizeselect();
            }
        }
    }
    else{
        for(int i = 0; i < rejectedOrder.getCount(); i++){
            if(rejectedOrder.getEntry(i).getOrderId() == orderid){
                rejectedOrder.getEntry(i).getBookingInfo().get(1).getSizeselect();
            }
        }
    }
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\n\t\t\t\t[1] Customer\n\t\t\t\t[2] Food Summary\n\t\t\t\t[3] Beverage Summary\n\t\t\t\t[4] Food & Beverage Accessories Summary\n\t\t\t\t[5] Facility Size Summary\n\t\t\t\t[6] Facility Color Summary\n\t\t\t\t[7] Facility Occassion Summary\n\t\t\t\t[8] Facility Accessories Summary\n\t\t\t\t[9] Back");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
}

public static void displayFacilityColor(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder, int orderid, int check){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Details");
    System.out.println("==================================================================================================");
    Font.print(Font.ANSI_CYAN, "Order Id : " + orderid);
    System.out.println("-------------------------------------------------------------------------------------------------------");
    
    if (check == 1){
        for (int i = orderQueue.getFront(); i <= orderQueue.getRear(); i++){
            if((orderQueue.getEntry(i).getOrderId()) == orderid){
                orderQueue.getEntry(i).getBookingInfo().get(1).getColorselect();
            }
        } 
    }
    else if (check == 2){
        for (int i = 0; i < acceptedOrder.getCount(); i++){
            if(acceptedOrder.getEntry(i).getOrderId() == orderid){
                acceptedOrder.getEntry(i).getBookingInfo().get(1).getColorselect();
            }
        }
    }
    else{
        for(int i = 0; i < rejectedOrder.getCount(); i++){
            if(rejectedOrder.getEntry(i).getOrderId() == orderid){
                rejectedOrder.getEntry(i).getBookingInfo().get(1).getColorselect();
            }
        }
    }
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\n\t\t\t\t[1] Customer\n\t\t\t\t[2] Food Summary\n\t\t\t\t[3] Beverage Summary\n\t\t\t\t[4] Food & Beverage Accessories Summary\n\t\t\t\t[5] Facility Size Summary\n\t\t\t\t[6] Facility Color Summary\n\t\t\t\t[7] Facility Occassion Summary\n\t\t\t\t[8] Facility Accessories Summary\n\t\t\t\t[9] Back");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
}

public static void displayFacilityOccassion(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder, int orderid, int check){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Details");
    System.out.println("==================================================================================================");
    Font.print(Font.ANSI_CYAN, "Order Id : " + orderid);
    System.out.println("-------------------------------------------------------------------------------------------------------");
    
    if (check == 1){
        for (int i = orderQueue.getFront(); i <= orderQueue.getRear(); i++){
            if((orderQueue.getEntry(i).getOrderId()) == orderid){
                orderQueue.getEntry(i).getBookingInfo().get(1).getOccasionselect();
            }
        } 
    }
    else if (check == 2){
        for (int i = 0; i < acceptedOrder.getCount(); i++){
            if(acceptedOrder.getEntry(i).getOrderId() == orderid){
                acceptedOrder.getEntry(i).getBookingInfo().get(1).getOccasionselect();
            }
        }
    }
    else{
        for(int i = 0; i < rejectedOrder.getCount(); i++){
            if(rejectedOrder.getEntry(i).getOrderId() == orderid){
                rejectedOrder.getEntry(i).getBookingInfo().get(1).getOccasionselect();
            }
        }
    }
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\n\t\t\t\t[1] Customer\n\t\t\t\t[2] Food Summary\n\t\t\t\t[3] Beverage Summary\n\t\t\t\t[4] Food & Beverage Accessories Summary\n\t\t\t\t[5] Facility Size Summary\n\t\t\t\t[6] Facility Color Summary\n\t\t\t\t[7] Facility Occassion Summary\n\t\t\t\t[8] Facility Accessories Summary\n\t\t\t\t[9] Back");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
}

public static void displayFacilityAccessories(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder, int orderid, int check){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Details");
    System.out.println("==================================================================================================");
    Font.print(Font.ANSI_CYAN, "Order Id : " + orderid);
    System.out.println("-------------------------------------------------------------------------------------------------------");
    
    if (check == 1){
        for (int i = orderQueue.getFront(); i <= orderQueue.getRear(); i++){
            if((orderQueue.getEntry(i).getOrderId()) == orderid){
                orderQueue.getEntry(i).getBookingInfo().get(1).getFacilityAccessoriesSelect();
            }
        } 
    }
    else if (check == 2){
        for (int i = 0; i < acceptedOrder.getCount(); i++){
            if(acceptedOrder.getEntry(i).getOrderId() == orderid){
                acceptedOrder.getEntry(i).getBookingInfo().get(1).getFacilityAccessoriesSelect();
            }
        }
    }
    else{
        for(int i = 0; i < rejectedOrder.getCount(); i++){
            if(rejectedOrder.getEntry(i).getOrderId() == orderid){
                rejectedOrder.getEntry(i).getBookingInfo().get(1).getFacilityAccessoriesSelect();
            }
        }
    }
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\n\t\t\t\t[1] Customer\n\t\t\t\t[2] Food Summary\n\t\t\t\t[3] Beverage Summary\n\t\t\t\t[4] Food & Beverage Accessories Summary\n\t\t\t\t[5] Facility Size Summary\n\t\t\t\t[6] Facility Color Summary\n\t\t\t\t[7] Facility Occassion Summary\n\t\t\t\t[8] Facility Accessories Summary\n\t\t\t\t[9] Back");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
}


    public static void orderDetails(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder){
        Scanner input2 = new Scanner(System.in);
        Screen.clear();
        int orderid = 0;
        int check = 0;
        boolean check1 = false;
        int selection = 0;

        do {
            try {
                orderid = 0;
                Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Details");
                System.out.println("==================================================================================================");
                System.out.print("\n\t\t\t       Enter Order ID (Type 0 to exit): ");
                orderid = input2.nextInt();
                check = orderidCheck(orderQueue, rejectedOrder, rejectedOrder, orderid);
                if(orderid == 0 || check == 1 || check == 2 || check == 3){
                    check1 = true;
                }
                else{
                    check1 = false;
                }

            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only numbers allowed, please try again!\n");
                input2.next();
                }
    }while(check1 != true);

    if (orderid == 0){
        return;
    }
    else{
        Screen.clear();
        do {
            try {
                selection = 0;
                
                displayOrderMenu(orderQueue, acceptedOrder, rejectedOrder, orderid);;
                selection = input2.nextInt();
                if (selection < 1 || selection > 9) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-9) is allowed, please try again!\n");
                }

            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-9) is allowed, please try again!\n");
                input2.next();
                }
        

        switch(selection){
            case 1:
                Screen.clear();
                
                break;
            case 2:
                Screen.clear();
                displayFood(orderQueue, acceptedOrder, rejectedOrder, orderid, check);
                break;
            case 3:
                Screen.clear();
                displayBeverage(orderQueue, acceptedOrder, rejectedOrder, orderid, check);
                break;
            case 4:
                Screen.clear();
                displayFBaccess(orderQueue, acceptedOrder, rejectedOrder, orderid, check);
                break;
            case 5:
                Screen.clear();
                displayFacilitySize(orderQueue, acceptedOrder, rejectedOrder, orderid, check);
                break;
            case 6:
                Screen.clear();
                displayFacilityColor(orderQueue, acceptedOrder, rejectedOrder, orderid, check);
                break;
            case 7:
                Screen.clear();
                displayFacilityOccassion(orderQueue, acceptedOrder, rejectedOrder, orderid, check);
                break;
            case 8:
                Screen.clear();
                displayFacilityAccessories(orderQueue, acceptedOrder, rejectedOrder, orderid, check);
                break;
            case 9:
                Screen.clear();
                break;
            }


    }while(selection != 9);
    Screen.clear();

}
    }

    public static void Menu(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder){
        Scanner input1 = new Scanner(System.in);
        int choice1 = 0;
        Screen.clear();
        do {
            try {
                choice1 = 0;
                displayAdminMenu();
                choice1 = input1.nextInt();
                if (choice1 < 1 || choice1 > 5) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-5) is allowed, please try again!\n");
                }

            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-5) is allowed, please try again!\n");
                input1.next();
                }

                switch(choice1){
                    case 1:
                        Screen.clear();
                        queueMenu(orderQueue, acceptedOrder, rejectedOrder);
                        break;
                    case 2:
                        Screen.clear();
                        acceptedListMenu(acceptedOrder);
                        break;
                    case 3:
                        Screen.clear();
                        rejectedListMenu(rejectedOrder);
                        break;
                    case 4:
                        Screen.clear();
                        orderDetails(orderQueue, acceptedOrder, rejectedOrder);
                        break;
                    case 5:
                        Screen.clear();
                        break;
                    }

            }while(choice1 != 5);
            Screen.clear();
    }

    public static void displayAdminMenu(){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tAdmin Panel");
        System.out.println("==================================================================================================");
        System.out.println("\t\t\t\t[1] Order Evaluation\n\t\t\t\t[2] Accepted Orders\n\t\t\t\t[3] Rejected Orders\n\t\t\t\t[4] Order Details\n\t\t\t\t[5] Back");
        System.out.println("==================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");
    }  

    public static void displayQueue(CircularQueueInterface<Order> orderQueue){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Evaluation");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for (int i = orderQueue.getFront(); i <= orderQueue.getRear(); i++){
            System.out.println(orderQueue.getEntry(i));
        } 
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Total number of orders in queue: " + orderQueue.getCount());
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t[1] Accept First Order\n\t\t\t\t[2] Accept All Orders\n\t\t\t\t[3] Reject First Order\n\t\t\t\t[4] Reject All Orders\n\t\t\t\t[5] Back");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");
    }  

    public static void QueueConfirmationMenu(CircularQueueInterface<Order> orderQueue){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Evaluation");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println(orderQueue.peek());
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\tAre you sure to accept this Order?");
        System.out.println("\t\t\t\t[1] Yes\n\t\t\t\t[2] No");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");
    }

    public static void QueueAcceptConfirmation(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder){
        Scanner input = new Scanner(System.in);
        int selection = 0;

        
        do {
            try {
                selection = 0;
                
                QueueConfirmationMenu(orderQueue);
                Order.setCount(1);
                selection = input.nextInt();
                if (selection < 1 || selection > 2) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
                }

            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
                input.next();
                }

                switch(selection){
                    case 1:
                        Screen.clear();
                        boolean check = acceptedOrder.insert(orderQueue.peek());
                        if(check == true){
                            orderQueue.dequeue();
                        }
                        break;
                    case 2:
                        Screen.clear();
                        break;
                }
        }while(selection != 2 && selection != 1);
}

public static void QueueAcceptAllMenu(CircularQueueInterface<Order> orderQueue){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Evaluation");
    System.out.println("=======================================================================================================");
    System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
    System.out.println("-------------------------------------------------------------------------------------------------------");
    for (int i = orderQueue.getFront(); i <= orderQueue.getRear(); i++){
        System.out.println(orderQueue.getEntry(i));
    } 
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\t\t\t\tAre you sure to accept all Orders?");
    System.out.println("\t\t\t\t[1] Yes\n\t\t\t\t[2] No");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
}

public static void QueueAcceptAllConfirmation(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder){
    Scanner input = new Scanner(System.in);
    int selection = 0;

    
    do {
        try {
            selection = 0;
            
            QueueAcceptAllMenu(orderQueue);
            Order.setCount(1);
            selection = input.nextInt();
            if (selection < 1 || selection > 2) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
            }

        } catch (Exception e) {
            Screen.clear();
            Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
            input.next();
            }

            switch(selection){
                case 1:
                    Screen.clear();
                    for(int i2 = orderQueue.getFront(); i2 <= orderQueue.getRear(); i2++){
                        
                        boolean check = acceptedOrder.insert(orderQueue.getEntry(i2));
                        if(check == true){
                            orderQueue.dequeue();
                        }
                        if(orderQueue.getEntry(i2) != null){
                            Font.print(Font.ANSI_RED,"Data cannot be empty.");
                        }
                    }
                    
                    break;
                case 2:
                    Screen.clear();
                    break;
            }
    }while(selection != 2 && selection != 1);
}

public static void QueueRejectConfirmationMenu(CircularQueueInterface<Order> orderQueue){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Evaluation");
    System.out.println("=======================================================================================================");
    System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
    System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println(orderQueue.peek());
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\t\t\t\tAre you sure to reject this Order?");
    System.out.println("\t\t\t\t[1] Yes\n\t\t\t\t[2] No");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
}

public static void QueueRejectConfirmation(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> rejectedOrder){
    Scanner input = new Scanner(System.in);
    int selection = 0;

    
    do {
        try {
            selection = 0;
            
            QueueRejectConfirmationMenu(orderQueue);
            Order.setCount(1);
            selection = input.nextInt();
            if (selection < 1 || selection > 2) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
            }

        } catch (Exception e) {
            Screen.clear();
            Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
            input.next();
            }

            switch(selection){
                case 1:
                    Screen.clear();
                    boolean check = rejectedOrder.insert(orderQueue.peek());
                    if(check == true){
                        orderQueue.dequeue();
                    }
                    
                    break;
                case 2:
                    Screen.clear();
                    break;
            }
    }while(selection != 2 && selection != 1);
}

public static void QueueRejectAllMenu(CircularQueueInterface<Order> orderQueue){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Evaluation");
    System.out.println("=======================================================================================================");
    System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
    System.out.println("-------------------------------------------------------------------------------------------------------");
    for (int i = orderQueue.getFront(); i <= orderQueue.getRear(); i++){
        System.out.println(orderQueue.getEntry(i));
    } 
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\t\t\t\tAre you sure to reject all Orders?");
    System.out.println("\t\t\t\t[1] Yes\n\t\t\t\t[2] No");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
}

public static void QueueRejectAllConfirmation(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> rejectedOrder){
    Scanner input = new Scanner(System.in);
    int selection = 0;

    
    do {
        try {
            selection = 0;
            
            QueueRejectAllMenu(orderQueue);
            Order.setCount(1);
            selection = input.nextInt();
            if (selection < 1 || selection > 2) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
            }

        } catch (Exception e) {
            Screen.clear();
            Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
            input.next();
            }

            switch(selection){
                case 1:
                    Screen.clear();
                    for(int i3 = orderQueue.getFront(); i3 <= orderQueue.getRear(); i3++){
                        boolean check = rejectedOrder.insert(orderQueue.getEntry(i3));
                        if(check == true){
                            orderQueue.dequeue();
                        }
                        if(orderQueue.getEntry(i3) != null){
                            Font.print(Font.ANSI_RED,"Data cannot be empty.");
                        }
                    }
                    
                    break;
                case 2:
                    Screen.clear();
                    break;
            }
    }while(selection != 2 && selection != 1);
}

    public static void queueMenu(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrder){
        int i = 0, i4 = 0;
        Scanner input1 = new Scanner(System.in);
        int choice1 = 0;
        Screen.clear();
        do {
                choice1 = 0;
                
                displayQueue(orderQueue);
                Order.setCount(1);
                choice1 = input1.nextInt();
                if (choice1 < 1 || choice1 > 4) {
                     Screen.clear();
                     Font.print(Font.ANSI_RED, "                            Only (1-4) is allowed, please try again!\n");
                 }


                switch(choice1){
                    case 1:
                        Screen.clear();
                        if(orderQueue.isEmpty()){
                            Font.print(Font.ANSI_RED,"Queue is Empty.");
                            break;
                        }
                        QueueAcceptConfirmation(orderQueue, acceptedOrder);
                        
                        break;
                    case 2:
                        Screen.clear();
                        if(orderQueue.isEmpty()){
                            Font.print(Font.ANSI_RED,"Queue is Empty.");
                            break;
                        }
                        QueueAcceptAllConfirmation(orderQueue, acceptedOrder);

                        
                        break;
                    case 3:
                        Screen.clear();
                        if(orderQueue.isEmpty()){
                            Font.print(Font.ANSI_RED,"Queue is Empty.");
                            break;
                        }
                        QueueRejectConfirmation(orderQueue, rejectedOrder);
                        break;
                    case 4:
                        Screen.clear();
                        if(orderQueue.isEmpty()){
                            Font.print(Font.ANSI_RED,"Queue is Empty.");
                            break;
                        }
                        QueueRejectAllConfirmation(orderQueue, rejectedOrder);
                        break;
                    }

            }while(choice1 != 5);
            Screen.clear();
    }

    public static void displayAcceptedList(SortedListInterface<Order> acceptedOrder){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tAccepted List");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println(acceptedOrder);
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Total number of orders in List: " + acceptedOrder.getCount());
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t[1] Complete First Order\n\t\t\t\t[2] Complete Specific Order\n\t\t\t\t[3] Back");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");

        
    }

   public static void ListCompleteConfirmationMenu(SortedListInterface<Order> acceptedOrder){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tAccepted List");
    System.out.println("=======================================================================================================");
    System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
    System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println(acceptedOrder.getEntry(0));
    
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\t\t\t\tAre you sure to complete first Orders?");
    System.out.println("\t\t\t\t[1] Yes\n\t\t\t\t[2] No");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
   }

   public static void ListCompleteConfirmation(SortedListInterface<Order> acceptedOrder){
    Scanner input = new Scanner(System.in);
    int selection = 0;

    
    do {
        try {
            selection = 0;
            
            ListCompleteConfirmationMenu(acceptedOrder);
            Order.setCount(1);
            selection = input.nextInt();
            if (selection < 1 || selection > 2) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
            }

        } catch (Exception e) {
            Screen.clear();
            Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
            input.next();
            }

            switch(selection){
                case 1:
                    Screen.clear();
                    acceptedOrder.delete(acceptedOrder.getEntry(0));
                    
                    break;
                case 2:
                    Screen.clear();
                    break;
            }
    }while(selection != 2 && selection != 1);
   }

   public static void ListCompleteSpecificConfirmationMenu(SortedListInterface<Order> acceptedOrder, int position){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tAccepted List");
    System.out.println("=======================================================================================================");
    System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
    System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println(acceptedOrder.getEntry(position));
    
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\t\t\t\tAre you sure to complete this Orders?");
    System.out.println("\t\t\t\t[1] Yes\n\t\t\t\t[2] No");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
   }

   public static void ListCompleteSpecificConfirmation(SortedListInterface<Order> acceptedOrder, int position){
    Scanner input = new Scanner(System.in);
    int selection = 0;

    
    do {
        try {
            selection = 0;
            
            ListCompleteSpecificConfirmationMenu(acceptedOrder, position);
            Order.setCount(1);
            selection = input.nextInt();
            if (selection < 1 || selection > 2) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
            }

        } catch (Exception e) {
            Screen.clear();
            Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
            input.next();
            }

            switch(selection){
                case 1:
                    Screen.clear();
                    acceptedOrder.delete(acceptedOrder.getEntry(position));
                    
                    break;
                case 2:
                    Screen.clear();
                    break;
            }
    }while(selection != 2 && selection != 1);
   }

   public static void AcceptedListGetPositionMenu(SortedListInterface<Order> acceptedOrder){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tAccepted List");
    System.out.println("=======================================================================================================");
    System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
    System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println(acceptedOrder);
    
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\t\t\t\tWhich Order do you want to remove?");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
   }

   public static int AcceptedListGetPosition(SortedListInterface<Order> acceptedOrder){
    int selection = 0;
    boolean check = true;
    Scanner input = new Scanner(System.in);
    
    do {
        try {
            selection = 0;
            check = true;
            AcceptedListGetPositionMenu(acceptedOrder);
            Order.setCount(1);
            selection = input.nextInt();
            if (selection < 1 || selection > acceptedOrder.getCount()) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Out of Range, please try again!\n");
                check = false;
            }

        } catch (Exception e) {
            Screen.clear();
            Font.print(Font.ANSI_RED, "                            Only numbers allowed, please try again!\n");
            check = false;
            input.next();
            
            }


            
    }while(check != true);
    selection--;
    Screen.clear();
    return selection;
   }

    public static void acceptedListMenu(SortedListInterface<Order> acceptedOrder){
        int i = 0;
        Scanner input1 = new Scanner(System.in);
        int choice1 = 0;
        Screen.clear();
        do {
            try {
                choice1 = 0;
                
                displayAcceptedList(acceptedOrder);
                Order.setCount(1);
                choice1 = input1.nextInt();
                if (choice1 < 1 || choice1 > 3) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-3) is allowed, please try again!\n");
                }

            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-3) is allowed, please try again!\n");
                input1.next();
                }

                switch(choice1){
                    case 1:
                        Screen.clear();
                        if(acceptedOrder.isEmpty()){
                            Font.print(Font.ANSI_RED,"List is Empty.");
                            break;
                          }
                          ListCompleteConfirmation(acceptedOrder);
                        break;
                    case 2:
                        Screen.clear();
                        if(acceptedOrder.isEmpty()){
                            Font.print(Font.ANSI_RED,"List is Empty.");
                            break;
                          }
                        int position = AcceptedListGetPosition(acceptedOrder);
                        ListCompleteSpecificConfirmation(acceptedOrder, position);
                        break;
                    case 3:
                        Screen.clear();
                        break;

                    }

            }while(choice1 != 3);
            Screen.clear();
    }

    public static void ListRefundConfirmationMenu(SortedListInterface<Order> rejectedOrder){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tRejected List");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println(rejectedOrder.getEntry(0));
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\tAre you sure to refund first Orders?");
        System.out.println("\t\t\t\t[1] Yes\n\t\t\t\t[2] No");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");
       }
    
    public static void ListRefundConfirmation(SortedListInterface<Order> rejectedOrder){
        Scanner input = new Scanner(System.in);
        int selection = 0;
    
        
        do {
            try {
                selection = 0;
                
                ListRefundConfirmationMenu(rejectedOrder);
                Order.setCount(1);
                selection = input.nextInt();
                if (selection < 1 || selection > 2) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
                }
    
            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
                input.next();
                }
    
                switch(selection){
                    case 1:
                        Screen.clear();
                        rejectedOrder.delete(rejectedOrder.getEntry(0));
                        
                        break;
                    case 2:
                        Screen.clear();
                        break;
                }
        }while(selection != 2 && selection != 1);
       }
    
       public static void ListRefundSpecificConfirmationMenu(SortedListInterface<Order> rejectedOrder, int position){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tRejected List");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println(rejectedOrder.getEntry(position));
        
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\tAre you sure to refund this Orders?");
        System.out.println("\t\t\t\t[1] Yes\n\t\t\t\t[2] No");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");
       }
    
       public static void ListRefundSpecificConfirmation(SortedListInterface<Order> rejectedOrder, int position){
        Scanner input = new Scanner(System.in);
        int selection = 0;
    
        
        do {
            try {
                selection = 0;
                
                ListRefundSpecificConfirmationMenu(rejectedOrder, position);
                Order.setCount(1);
                selection = input.nextInt();
                if (selection < 1 || selection > 2) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
                }
    
            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
                input.next();
                }
    
                switch(selection){
                    case 1:
                        Screen.clear();
                        rejectedOrder.delete(rejectedOrder.getEntry(position));
                        
                        break;
                    case 2:
                        Screen.clear();
                        break;
                }
        }while(selection != 2 && selection != 1);
       }
    
       public static void RejectedListGetPositionMenu(SortedListInterface<Order> rejectedOrder){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tRejected List");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println(rejectedOrder);
        
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\tWhich Order do you want to remove?");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");
       }
    
       public static int RejectedListGetPosition(SortedListInterface<Order> rejectedOrder){
        int selection = 0;
        boolean check = true;
        Scanner input = new Scanner(System.in);
        
        do {
            try {
                selection = 0;
                check = true;
                RejectedListGetPositionMenu(rejectedOrder);
                Order.setCount(1);
                selection = input.nextInt();
                if (selection < 1 || selection > rejectedOrder.getCount()) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Out of Range, please try again!\n");
                    check = false;
                }
    
            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only numbers allowed, please try again!\n");
                check = false;
                input.next();
                
                }
    
    
                
        }while(check != true);
        selection--;
        Screen.clear();
        return selection;
       }
    



    public static void rejectedListMenu(SortedListInterface<Order> rejectedOrder){
        int i = 0;
        Scanner input1 = new Scanner(System.in);
        int choice1 = 0;
        Screen.clear();
        do {
            try {
                choice1 = 0;
                
                displayRejectedList(rejectedOrder);
                Order.setCount(1);
                choice1 = input1.nextInt();
                if (choice1 < 1 || choice1 > 3) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-3) is allowed, please try again!\n");
                }

            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-3) is allowed, please try again!\n");
                input1.next();
                }

                switch(choice1){
                    case 1:
                        Screen.clear();
                        if(rejectedOrder.isEmpty()){
                            Font.print(Font.ANSI_RED,"List is Empty.");
                            break;
                          }
                        ListRefundConfirmation(rejectedOrder);
                        break;
                    case 2:
                        Screen.clear();
                        if(rejectedOrder.isEmpty()){
                            Font.print(Font.ANSI_RED,"List is Empty.");
                            break;
                          }
                        int position = RejectedListGetPosition(rejectedOrder);
                        ListRefundSpecificConfirmation(rejectedOrder, position);       
                        break;
                    case 3:
                        Screen.clear();
                        break;
                    }

            }while(choice1 != 3);
            Screen.clear();
    }

    public static void displayRejectedList(SortedListInterface<Order> rejectedOrder){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tRejected List");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println(rejectedOrder);
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Total number of orders in list: " + rejectedOrder.getCount());
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t[1] Refunded First Order\n\t\t\t\t[2] Refunded Specific Order\n\t\t\t\t[3] Back");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");

        
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

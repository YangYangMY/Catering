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
    

    public static boolean Login(){
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

    public static void Menu(CircularQueueInterface<Order> orderQueue, SortedListInterface<Order> acceptedOrder,SortedListInterface<Order> rejectedOrderOrder O){
        Scanner input1 = new Scanner(System.in);
        int choice1 = 0;
        Screen.clear();
        do {
            try {
                choice1 = 0;
                displayAdminMenu();
                choice1 = input1.nextInt();
                if (choice1 < 1 || choice1 > 4) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-4) is allowed, please try again!\n");
                }

            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-4) is allowed, please try again!\n");
                input1.next();
                }

                switch(choice1){
                    case 1:
                        Screen.clear();
                        QueueMenu(O);
                        break;
                    case 2:
                        Screen.clear();
                        AcceptedListMenu(O);
                        break;
                    case 3:
                        Screen.clear();
                        RejectedListMenu(O);
                        break;
                    case 4:
                        Screen.clear();
                        break;
                    }

            }while(choice1 != 4);
            Screen.clear();
    }

    public static void displayAdminMenu(){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tAdmin Panel");
        System.out.println("==================================================================================================");
        System.out.println("\t\t\t\t[1] Order Evaluation\n\t\t\t\t[2] Accepted Orders\n\t\t\t\t[3] Rejected Orders\n\t\t\t\t[4] Back");
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

    public static void QueueMenu(Order O){
        int i = 0, i4 = 0;
        Scanner input1 = new Scanner(System.in);
        int choice1 = 0;
        Screen.clear();
        do {
            try {
                choice1 = 0;
                
                displayQueue(O);
                O.setCount(1);
                choice1 = input1.nextInt();
                if (choice1 < 1 || choice1 > 4) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-4) is allowed, please try again!\n");
                }

            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-4) is allowed, please try again!\n");
                input1.next();
                }

                switch(choice1){
                    case 1:
                        Screen.clear();
                        if(orderQueue.isEmpty()){
                            Font.print(Font.ANSI_RED,"Queue is Empty.");
                            break;
                        }
                        QueueAcceptConfirmation(O);
                        
                        break;
                    case 2:
                        Screen.clear();
                        if(orderQueue.isEmpty()){
                            Font.print(Font.ANSI_RED,"Queue is Empty.");
                            break;
                        }
                        QueueAcceptAllConfirmation(O);

                        
                        break;
                    case 3:
                        Screen.clear();
                        if(orderQueue.isEmpty()){
                            Font.print(Font.ANSI_RED,"Queue is Empty.");
                            break;
                        }
                        QueueRejectConfirmation(O);
                        break;
                    case 4:
                        Screen.clear();
                        if(orderQueue.isEmpty()){
                            Font.print(Font.ANSI_RED,"Queue is Empty.");
                            break;
                        }
                        QueueRejectAllConfirmation(O);
                        break;
                    }

            }while(choice1 != 5);
            Screen.clear();
    }

    public static void displayAcceptedList(Order O){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tAccepted List");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println(O.getAcceptedList());
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Total number of orders in queue: " + O.getAcceptedList().getCount());
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t[1] Complete First Order\n\t\t\t\t[2] Complete Specific Order\n\t\t\t\t[3] Back");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");

        
    }

   public static void ListCompleteConfirmationMenu(Order O){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tAccepted List");
    System.out.println("=======================================================================================================");
    System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
    System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println(O.getAcceptedList().getEntry(0));
    
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\t\t\t\tAre you sure to complete first Orders?");
    System.out.println("\t\t\t\t[1] Yes\n\t\t\t\t[2] No");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
   }

   public static void ListCompleteConfirmation(Order O){
    Scanner input = new Scanner(System.in);
    int selection = 0;

    
    do {
        try {
            selection = 0;
            
            ListCompleteConfirmationMenu(O);
            O.setCount(1);
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
                    O.getAcceptedList().delete(O.getAcceptedList().getEntry(0));
                    
                    break;
                case 2:
                    Screen.clear();
                    break;
            }
    }while(selection != 2 && selection != 1);
   }

   public static void ListCompleteSpecificConfirmationMenu(Order O, int position){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tAccepted List");
    System.out.println("=======================================================================================================");
    System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
    System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println(O.getAcceptedList().getEntry(position));
    
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\t\t\t\tAre you sure to complete this Orders?");
    System.out.println("\t\t\t\t[1] Yes\n\t\t\t\t[2] No");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
   }

   public static void ListCompleteSpecificConfirmation(Order O, int position){
    Scanner input = new Scanner(System.in);
    int selection = 0;

    
    do {
        try {
            selection = 0;
            
            ListCompleteSpecificConfirmationMenu(O, position);
            O.setCount(1);
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
                    O.getAcceptedList().delete(O.getAcceptedList().getEntry(position));
                    
                    break;
                case 2:
                    Screen.clear();
                    break;
            }
    }while(selection != 2 && selection != 1);
   }

   public static void AcceptedListGetPositionMenu(Order O){
    Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tAccepted List");
    System.out.println("=======================================================================================================");
    System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
    System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println(O.getAcceptedList());
    
    System.out.println("-------------------------------------------------------------------------------------------------------");
    System.out.println("\t\t\t\tWhich Order do you want to remove?");
    System.out.println("=======================================================================================================");
    System.out.print("\n\t\t\t       Select your Choice: ");
   }

   public static int AcceptedListGetPosition(Order O){
    int selection = 0;
    boolean check = true;
    Scanner input = new Scanner(System.in);
    
    do {
        try {
            selection = 0;
            check = true;
            AcceptedListGetPositionMenu(O);
            O.setCount(1);
            selection = input.nextInt();
            if (selection < 1 || selection > O.getAcceptedList().getCount()) {
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

    public static void AcceptedListMenu(Order O){
        int i = 0;
        Scanner input1 = new Scanner(System.in);
        int choice1 = 0;
        Screen.clear();
        do {
            try {
                choice1 = 0;
                
                displayAcceptedList(O);
                O.setCount(1);
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
                        if(O.getAcceptedList().isEmpty()){
                            Font.print(Font.ANSI_RED,"List is Empty.");
                            break;
                          }
                          ListCompleteConfirmation(O);
                        break;
                    case 2:
                        Screen.clear();
                        if(O.getAcceptedList().isEmpty()){
                            Font.print(Font.ANSI_RED,"List is Empty.");
                            break;
                          }
                        int position = AcceptedListGetPosition(O);
                        ListCompleteSpecificConfirmation(O, position);
                        break;
                    case 3:
                        Screen.clear();
                        break;

                    }

            }while(choice1 != 3);
            Screen.clear();
    }

    public static void ListRefundConfirmationMenu(Order O){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tRejected List");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println(O.getRejectedList().getEntry(0));
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\tAre you sure to refund first Orders?");
        System.out.println("\t\t\t\t[1] Yes\n\t\t\t\t[2] No");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");
       }
    
    public static void ListRefundConfirmation(Order O){
        Scanner input = new Scanner(System.in);
        int selection = 0;
    
        
        do {
            try {
                selection = 0;
                
                ListRefundConfirmationMenu(O);
                O.setCount(1);
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
                        O.getRejectedList().delete(O.getRejectedList().getEntry(0));
                        
                        break;
                    case 2:
                        Screen.clear();
                        break;
                }
        }while(selection != 2 && selection != 1);
       }
    
       public static void ListRefundSpecificConfirmationMenu(Order O, int position){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tRejected List");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println(O.getRejectedList().getEntry(position));
        
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\tAre you sure to refund this Orders?");
        System.out.println("\t\t\t\t[1] Yes\n\t\t\t\t[2] No");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");
       }
    
       public static void ListRefundSpecificConfirmation(Order O, int position){
        Scanner input = new Scanner(System.in);
        int selection = 0;
    
        
        do {
            try {
                selection = 0;
                
                ListRefundSpecificConfirmationMenu(O, position);
                O.setCount(1);
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
                        O.getRejectedList().delete(O.getRejectedList().getEntry(position));
                        
                        break;
                    case 2:
                        Screen.clear();
                        break;
                }
        }while(selection != 2 && selection != 1);
       }
    
       public static void RejectedListGetPositionMenu(Order O){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tAccepted List");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println(O.getRejectedList());
        
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\tWhich Order do you want to remove?");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");
       }
    
       public static int RejectedListGetPosition(Order O){
        int selection = 0;
        boolean check = true;
        Scanner input = new Scanner(System.in);
        
        do {
            try {
                selection = 0;
                check = true;
                RejectedListGetPositionMenu(O);
                O.setCount(1);
                selection = input.nextInt();
                if (selection < 1 || selection > O.getRejectedList().getCount()) {
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
    



    public static void RejectedListMenu(Order O){
        int i = 0;
        Scanner input1 = new Scanner(System.in);
        int choice1 = 0;
        Screen.clear();
        do {
            try {
                choice1 = 0;
                
                displayRejectedList(O);
                O.setCount(1);
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
                        if(O.getRejectedList().isEmpty()){
                            Font.print(Font.ANSI_RED,"List is Empty.");
                            break;
                          }
                        ListRefundConfirmation(O);
                        break;
                    case 2:
                        Screen.clear();
                        if(O.getRejectedList().isEmpty()){
                            Font.print(Font.ANSI_RED,"List is Empty.");
                            break;
                          }
                        int position = RejectedListGetPosition(O);
                        ListRefundSpecificConfirmation(O, position);       
                        break;
                    case 3:
                        Screen.clear();
                        break;
                    }

            }while(choice1 != 3);
            Screen.clear();
    }

    public static void displayRejectedList(Order O){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tRejected List");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println(O.getRejectedList());
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Total number of orders in queue: " + O.getRejectedList().getCount());
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

package rsf2s1g2.client;

import java.util.Scanner;

import rsf2s1g2.utility.*;
import rsf2s1g2.entity.*;

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

    public static void displayAdminMenu(){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tAdmin Panel");
        System.out.println("==================================================================================================");
        System.out.println("\t\t\t\t[1] Order Evaluation\n\t\t\t\t[2] Accepted Orders\n\t\t\t\t[3] Rejected Orders\n\t\t\t\t[4] Back");
        System.out.println("==================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");
    }  

    public static void displayQueue(Order O){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tOrder Evaluation");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for (int i = O.getOrderQueue().getFront(); i <= O.getOrderQueue().getRear(); i++){
            System.out.println(O.getOrderQueue().getEntry(i));
        } 
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t[1] Accept First Order\n\t\t\t\t[2] Accept All Orders\n\t\t\t\t[3] Reject First Order\n\t\t\t\t[4] Reject All Orders\n\t\t\t\t[5] Back");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");
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
                        
                        i = O.getOrderQueue().getFront();
                        O.AcceptOrder(O.getOrderQueue().getEntry(i));
                        break;
                    case 2:
                        Screen.clear();
                        
                        for(int i2 = O.getOrderQueue().getFront(); i2 <= O.getOrderQueue().getRear(); i2++){
                            O.AcceptOrder(O.getOrderQueue().getEntry(i2));
                            if(O.getOrderQueue().getEntry(i2) != null){
                                Font.print(Font.ANSI_RED,"Data cannot be empty.");
                            }
                        }

                        
                        break;
                    case 3:
                        Screen.clear();
                        i4= O.getOrderQueue().getFront();
                        O.RejectOrder(O.getOrderQueue().getEntry(i4));
                        break;
                    case 4:
                        Screen.clear();
                        for(int i3 = O.getOrderQueue().getFront(); i3 <= O.getOrderQueue().getRear(); i3++){
                            O.RejectOrder(O.getOrderQueue().getEntry(i3));
                            if(O.getOrderQueue().getEntry(i3) != null){
                                Font.print(Font.ANSI_RED,"Data cannot be empty.");
                            }
                        }
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
        System.out.println("\t\t\t\t[1] Complete First Order\n\t\t\t\t[2] Complete All Orders\n\t\t\t\t[3] View Details\n\t\t\t\t[4] Back");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");

        
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
                        int index1 = O.getAcceptedList().getCount() - 1;

                        O.getAcceptedList().delete(O.getAcceptedList().getEntry(index1));
                        

                        break;
                    case 2:
                        Screen.clear();
                        int index2 = 0;
                        while(O.getAcceptedList().getEntry(index2) != null){
                            
                            O.getAcceptedList().delete(O.getAcceptedList().getEntry(index2));
                            index2++;
                        }

                        

                        
                        break;
                    case 3:
                        Screen.clear();

                        break;
                    case 4:
                        Screen.clear();

                        break;
                    }

            }while(choice1 != 4);
            Screen.clear();
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
                        
                        break;
                    case 2:
                        Screen.clear();
                        

                        
                        break;
                    case 3:
                        Screen.clear();
                        
                        break;
                    case 4:
                        Screen.clear();
                        break;
                    }

            }while(choice1 != 4);
            Screen.clear();
    }

    public static void displayRejectedList(Order O){
        Font.print(Font.ANSI_PURPLE,"\t\t\t\t\tRejected List");
        System.out.println("=======================================================================================================");
        System.out.println(String.format("%-9s","No.")  + String.format("%-15s", "Order ID") + String.format("%-12s", "Date") + String.format("%-17s", "Price (RM)") + String.format("%-25s","Customer Name") + String.format("%-16s", "Phone Number") );
        System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println(O.getRejectedList());
        
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t[1] Refunded First Order\n\t\t\t\t[2] Refunded All Orders\n\t\t\t\t[3] Undo Specific Order\n\t\t\t\t[4] Back");
        System.out.println("=======================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");

        
    }


    public static void Menu(Order O){
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

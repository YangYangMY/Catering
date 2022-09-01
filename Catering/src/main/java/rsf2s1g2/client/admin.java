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
        System.out.println("No.\t\tOrder ID\tDate\t\tPrice(RM)\tCustomer Name\t\tPhone Number");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for (int i = O.getOrderQueue().getFront(); i <= O.getOrderQueue().getRear(); i++){
            System.out.println(O.getOrderQueue().getEntry(i));
        } 
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t[1] Accept First Order\n\t\t\t\t[2] Accept All Orders\n\t\t\t\t[3] Reject First Order\n\t\t\t\t[4] Reject All Orders\n\t\t\t\t[5] Back");
        System.out.println("==================================================================================================");
        System.out.print("\n\t\t\t       Select your Choice: ");
    }  

    public static void QueueMenu(Order O){
        int i = 0;
        Scanner input1 = new Scanner(System.in);
        int choice1 = 0;
        Screen.clear();
        do {
            try {
                choice1 = 0;
                
                displayQueue(O);
                O.setCount(1);
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
                        
                        if(O.getOrderQueue().getEntry(i) == null){
                            i++;
                        }
                        O.AcceptOrder(O.getOrderQueue().getEntry(i));
                        break;
                    case 2:
                        Screen.clear();
                        i
                        while(O.getOrderQueue().getEntry(i) != null){
                            O.AcceptOrder(O.getOrderQueue().getEntry(i));
                            i++;
                            if(O.getOrderQueue().getEntry(i) != null){
                                Font.print(Font.ANSI_RED,"Data cannot be empty.");
                            }
                        }

                        
                        break;
                    case 3:
                        Screen.clear();
                        
                        break;
                    case 4:
                        Screen.clear();
                        break;
                    case 5:
                        Screen.clear();
                        break;
                    }

            }while(choice1 != 5);
            Screen.clear();
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
                        ;
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

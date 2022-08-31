import java.util.Scanner;

import rsf2s1g2.utility.*;
import rsf2s1g2.adt.*;
import rsf2s1g2.client.*;
import rsf2s1g2.entity.*;

/**
 *
 * 
 */
public class Catering {


    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //test for array
        Order O = new Order();
        O.addOrder("Patrick", "2021-7-12", "0177255766", 15.12);
        O.addOrder("John", "2021-5-1", "0177255766", 3.12);
        O.addOrder("Jason", "2020-1-1", "0177255766", 20.12);
        O.addOrder("BC", "2019-4-1", "0177255766", 20.12);
        
        // O.RejectOrder(O.getOrderQueue().getEntry(0));
        // O.RejectOrder(O.getOrderQueue().getEntry(1));
        // O.RejectOrder(O.getOrderQueue().getEntry(2));
        // System.out.println(O.getRejectedList());

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
                        
                        break;
                        case 2:
                        Screen.clear();
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
        System.out.println("\t\t\t\t\tCatering System");
        System.out.println("==================================================================================================");
        System.out.println("1. Order\n2. Admin\n3. Exit");
        System.out.println("==================================================================================================");
        System.out.print("\nSelect your Choice: ");
    }  
    
     public static void displayEndScreen(){
        Font.print(Font.ANSI_YELLOW,"                                                          __ __ ");
        Font.print(Font.ANSI_YELLOW,"                _____ _           _      __ __           |  |  |");
        Font.print(Font.ANSI_YELLOW,"               |_   _| |_ ___ ___| |_   |  |  |___ _ _   |  |  |");
        Font.print(Font.ANSI_YELLOW,"                 | | |   | .'|   | '_|  |_   _| . | | |  |__|__|");
        Font.print(Font.ANSI_YELLOW,"                 |_| |_|_|__,|_|_|_,_|    |_| |___|___|  |__|__|");
     }



    //START OF ADMIN SECTION 

    public static void displayAdminMenu(){
        System.out.println("\t\t\t\t\tAdmin Panel");
        System.out.println("==================================================================================================");
        System.out.println("1. Order Evaluation\n2. Accepted Orders\n3. Rejected Orders\n4. Back");
        System.out.println("==================================================================================================");
        System.out.print("\nSelect your Choice: ");
    }  

     public static void Admin(Order O){
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
                }

            } catch (InvalidException e) {
                Screen.clear();
                System.out.println("\t\t\t\t\tAdmin");
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
            return;
        }
    

        
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
                        for (int i = O.getOrderQueue().getFront(); i <= O.getOrderQueue().getRear(); i++){
                            System.out.println(O.getOrderQueue().getEntry(i));
                        } 

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




     //END OF ADMIN SECTION


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

    

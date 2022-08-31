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
        O.addOrder("Patrick", "2021-5-1", "0177255766", 3.12);
        O.addOrder("Jason", "2020-1-1", "0177255766", 20.12);
        O.addOrder("BC", "2019-4-1", "0177255766", 20.12);
        
        O.RejectOrder(O.getOrderQueue().getEntry(0));
        O.RejectOrder(O.getOrderQueue().getEntry(1));
        O.RejectOrder(O.getOrderQueue().getEntry(2));
        O.RejectOrder(O.getOrderQueue().getEntry(3));
        System.out.println(O.getRejectedList());

        //Start Of Program
        int choice = 0;
        
        do {
            Screen.clear();
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
                        Admin();
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

     public static void displayAdminMenu(){
        System.out.println("\t\t\t\t\tCatering System");
        System.out.println("==================================================================================================");
        System.out.println("1. Order Evaluation\n2. Accepted Orders\n3. Rejected Orders\n4.Back");
        System.out.println("==================================================================================================");
        System.out.print("\nSelect your Choice: ");
    }  


     public static void Admin(){
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
                        
                        break;
                        case 2:
                        Screen.clear();
                        ;
                        break;
                    case 3:
                        Screen.clear();
                        
                        break;
                }

            }while(choice1 != 4);
     }


}

    

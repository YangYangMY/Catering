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
        
        
        //Start Of Program
        int choice = 0;
        
        do {
            try {
                choice = 0;
                displayMenu();
                choice = input.nextInt();
                if (choice < 1 || choice > 2) {
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

                        break;
                    case 3:
                        Screen.clear();
                        displayEndScreen();
                        break;
                }

            }while(choice != 3);
        

        
    }
        
     public static void displayMenu(){
        System.out.println("Catering System");
        System.out.println("1. Order\n2. Admin\n3. Exit");
        System.out.print("\nSelect your Choice: ");
    }  
    
     public static void displayEndScreen(){
        Font.print(Font.ANSI_YELLOW,"                                                          __ __ ");
        Font.print(Font.ANSI_YELLOW,"                _____ _           _      __ __           |  |  |");
        Font.print(Font.ANSI_YELLOW,"               |_   _| |_ ___ ___| |_   |  |  |___ _ _   |  |  |");
        Font.print(Font.ANSI_YELLOW,"                 | | |   | .'|   | '_|  |_   _| . | | |  |__|__|");
        Font.print(Font.ANSI_YELLOW,"                 |_| |_|_|__,|_|_|_,_|    |_| |___|___|  |__|__|");
     }




}

    

package rsf2s1g2.catering;

import java.util.Scanner;

/**
 *
 * @author Wee Yan
 */
public class Catering {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        

        int choice = 0;
        
        do {
            try {
                choice = 0;
                displayMenu();
                choice = input.nextInt();
                if (choice < 1 || choice > 2) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
                }

            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-2) is allowed, please try again!\n");
                input.next();
                }
            }while(choice != 3);
        }
        
    public static void displayMenu(){
        System.out.println("Catering System");
        System.out.println("1. Order\n2. Admin\n3. Exit");
        System.out.println("\nSelect your Choice: ");
    }
    
}
package rsf2s1g2.client;

import java.util.Scanner;

import rsf2s1g2.utility.*;

public class admin {
    

    public static void Login(){
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
}

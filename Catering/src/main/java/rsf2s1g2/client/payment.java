package rsf2s1g2.client;

import java.util.Scanner;
import rsf2s1g2.utility.*;
import rsf2s1g2.adt.*;
import rsf2s1g2.entity.*;

public class payment {

    public static Scanner input = new Scanner(System.in);

    public static void pymt(ListInterface<BookingInfo> bookinglist, ListInterface<FoodBeverage> foodselect,
            ListInterface<FoodBeverage> beverageselect, ListInterface<Facility> sizeselect,
            ListInterface<Facility> colorselect, ListInterface<Facility> occasionselect) {
        MapInterface<Integer, Payment> payments = new Map<Integer, Payment>();
        String paymentMethod = "";

        switch (displayCart(bookinglist)) {
            case 1:
                switch (getPymt()) {
                    case 1:
                        paymentMethod = "Online Bank Transfer";
                        break;

                    case 2:
                        paymentMethod = "Debit / Credit Card";
                        break;

                    case 3:
                        paymentMethod = "E-wallet";

                    case 4:
                        paymentMethod = null;
                        break;
                }

                if (paymentMethod != null) {
                    payments.add(Payment.getId(),new Payment(getTotal(foodselect, beverageselect, sizeselect, colorselect, occasionselect),paymentMethod));
                }

                System.out.println( paymentMethod + " " + getTotal(foodselect, beverageselect, sizeselect, colorselect, occasionselect));

            case 2:
                Screen.clear();
                break;
        }
    }

    public static int displayCart(ListInterface<BookingInfo> bookinglist) {
        int choice;

        Screen.clear();
        Font.print(Font.ANSI_YELLOW, "\t\t  ██████╗ █████╗ ██████╗ ████████╗");
        Font.print(Font.ANSI_YELLOW, "\t\t ██╔════╝██╔══██╗██╔══██╗╚══██╔══╝");
        Font.print(Font.ANSI_YELLOW, "\t\t ██║     ███████║██████╔╝   ██║   ");
        Font.print(Font.ANSI_YELLOW, "\t\t ██║     ██╔══██║██╔══██╗   ██║   ");
        Font.print(Font.ANSI_YELLOW, "\t\t ╚██████╗██║  ██║██║  ██║   ██║   ");
        Font.print(Font.ANSI_YELLOW, "\t\t  ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ");
        System.out.println("=============================================================================");

        bookinglist.get(1).getFoodselect();
        bookinglist.get(1).getBeverageselect();
        // bookinglist.get(1).getSizeselect();
        // bookinglist.get(1).getColorselect();
        // bookinglist.get(1).getOccasionselect();

        System.out.println("\n\t\t\t Do you want to proceed?");
        System.out.println("\t\t\t   1. Confirm");
        System.out.println("\t\t\t   2. Back to Menu");
        choice = Screen.numInputValid(1, 2, "\n\t\t\t    -> ",
                "\t\t\t     Invalid Input! Please Try Again!");

        return choice;
    }

    public static int getPymt() {
        int pymtMethod;
        String bankAccountNum, cardNum, phoneNum, pinCode;

        Screen.clear();

        Font.print(Font.ANSI_YELLOW, "\t ██████╗  █████╗ ██╗   ██╗███╗   ███╗███████╗███╗   ██╗████████╗");
        Font.print(Font.ANSI_YELLOW, "\t ██╔══██╗██╔══██╗╚██╗ ██╔╝████╗ ████║██╔════╝████╗  ██║╚══██╔══╝");
        Font.print(Font.ANSI_YELLOW, "\t ██████╔╝███████║ ╚████╔╝ ██╔████╔██║█████╗  ██╔██╗ ██║   ██║   ");
        Font.print(Font.ANSI_YELLOW, "\t ██╔═══╝ ██╔══██║  ╚██╔╝  ██║╚██╔╝██║██╔══╝  ██║╚██╗██║   ██║  ");
        Font.print(Font.ANSI_YELLOW, "\t ██║     ██║  ██║   ██║   ██║ ╚═╝ ██║███████╗██║ ╚████║   ██║  ");
        Font.print(Font.ANSI_YELLOW, "\t ╚═╝     ╚═╝  ╚═╝   ╚═╝   ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝  ");
        System.out.println("=============================================================================");
        System.out.println("\t\t\t Please Select A Payment Method");
        System.out.println("\t\t\t     1. Online Bank Transfer");
        System.out.println("\t\t\t     2. Credit / Debit Card");
        System.out.println("\t\t\t     3. E-Wallet");
        System.out.println("\t\t\t     4. Back");
        pymtMethod = Screen.numInputValid(1, 4, "\n\t\t\t     Select 1 - 4: ",
                "\t\t\t     Invalid Input! Please Try Again!");

        switch (pymtMethod) {
            case 1:
                do {

                    System.out.print("\t\t Enter your bank account number: ");
                    bankAccountNum = input.nextLine();

                    if (bankAccountNum.length() < 12 || bankAccountNum.length() > 18) {
                        System.out.println("\n\t\t Please insert correct format bank account number.\n");
                    } else {
                        getOtpNum();
                    }
                } while (bankAccountNum.length() < 12 || bankAccountNum.length() > 18);
                break;

            case 2:
                do {
                    System.out.print("\t\t Enter your card number: ");
                    cardNum = input.nextLine();

                    if (cardNum.length() != 16) {
                        System.out.println("\n\t\t Please insert 16 digits card number!\n");
                    } else {
                        getOtpNum();
                    }
                } while (cardNum.length() != 16);
                break;

            case 3:
                do {
                    System.out.print("\t\t Enter your phone number: ");
                    phoneNum = input.nextLine();

                    if (phoneNum.length() < 10 || phoneNum.length() > 11) {
                        System.out.println("\n\t\t  Please insert correct format phone number.");
                    } else {
                        System.out.println("\t Please wait a moment. A PIN code has been sent to your device.");
                        Screen.pause(3);
                        do {
                            System.out.print("\n\t\t    Please insert the PIN code: ");
                            pinCode = input.nextLine();

                            if (pinCode.length() != 5) {
                                System.out.println("\n\t\t Please insert the 5 digits PIN code!");
                            } else {
                                Screen.pause(2);
                                System.out.println("\n\t\t\t      Payment Successful!\n");
                                foodandbeverage.continueMessage();
                            }
                        } while (pinCode.length() != 5);

                    }
                } while (phoneNum.length() < 10 || phoneNum.length() > 11);
                break;

            case 4:
                Screen.clear();
                break;
        }

        return pymtMethod;
    }

    public static void getOtpNum() {
        String otpNum;

        do {
            System.out.println("\t Please wait a moment. An OTP number has been sent to your device.");
            Screen.pause(3);
            System.out.print("\n\t\t\tEnter your OTP number (6 digits): ");
            otpNum = input.nextLine();

            if (otpNum.length() != 6) {
                System.out.println("\n\t\t  Invalid Input! Please try again.");
            } else {
                Screen.pause(2);
                System.out.println("\n\t\t\t      Payment Successful!\n");
                foodandbeverage.continueMessage();
            }
        } while (otpNum.length() != 6);
    }

    public static double getTotal(ListInterface<FoodBeverage> foodselect, ListInterface<FoodBeverage> beverageselect,
            ListInterface<Facility> sizeselect, ListInterface<Facility> colorselect,
            ListInterface<Facility> occasionselect) {
        double paymentAmount = foodselect.get(1).getFoodFinaltotal() + beverageselect.get(1).getBeverageFinaltotal();

        return paymentAmount;
    }
}

package rsf2s1g2.client;

import java.util.Scanner;
import rsf2s1g2.utility.*;
import rsf2s1g2.adt.*;
import rsf2s1g2.entity.*;
import rsf2s1g2.entity.Order;

public class payment {

    public static Scanner input = new Scanner(System.in);

    public static void pymt(MapInterface<String, Customer> customers, MapInterface<Integer, Payment> payments, ListInterface<BookingInfo> bookinglist, CircularQueueInterface<Order> orderQueue) {
       
        String paymentMethod = "";

        switch (displayCart(bookinglist)) {
            case 1:
                Screen.clear();
                String[] temp = customer.addDetails(customers);
                switch (getPymt(bookinglist)) {
                    case 1:
                        paymentMethod = "Online Bank Transfer";
                        //payments.add(Payment.getId(),new Payment(getTotal(foodselect, beverageselect, sizeselect, colorselect, occasionselect),paymentMethod));
                        break;

                    case 2:
                        paymentMethod = "Debit / Credit Card";
                        //payments.add(Payment.getId(),new Payment(getTotal(foodselect, beverageselect, sizeselect, colorselect, occasionselect),paymentMethod));
                        break;

                    case 3:
                        paymentMethod = "E-wallet";
                       // payments.add(Payment.getId(),new Payment(getTotal(foodselect, beverageselect, sizeselect, colorselect, occasionselect),paymentMethod));
                }
                int paymentID = Payment.getId();
                payments.add(Payment.getId(),new Payment(bookinglist.get(1).getTotalPrice(),paymentMethod));
                Order item1 = new Order(temp[0], temp[1], paymentID, bookinglist, customers, payments);
                orderQueue.enqueue(item1);
                //testing

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
        bookinglist.get(1).getSizeselect();
        bookinglist.get(1).getColorselect();
        bookinglist.get(1).getOccasionselect();
        //System.out.println(bookinglist.get(1).getTotalPrice());

        System.out.println("\n\t\t\t Do you want to proceed?");
        System.out.println("\t\t\t   1. Confirm");
        System.out.println("\t\t\t   2. Back to Menu");
        choice = Screen.numInputValid(1, 2, "\n\t\t\t    -> ",
                "\t\t\t     Invalid Input! Please Try Again!");

        return choice;
    }

    public static int getPymt(ListInterface<BookingInfo> bookinglist) {
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
        pymtMethod = Screen.numInputValid(1, 3, "\n\t\t\t     Select 1 - 3: ",
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
                            System.out.print("\n\t\t    Please insert the PIN code (5 digits): ");
                            pinCode = input.nextLine();

                            if (pinCode.length() != 5) {
                                System.out.println("\n\t\t Please insert the 5 digits PIN code!");
                            } else {
                                System.out.println("\n\t\t\t  The payment is processing...");
                                Screen.pause(2);
                                System.out.println("\n\t\t\t      Payment Successful!\n");
                                foodandbeverage.continueMessage();
                            }
                        } while (pinCode.length() != 5);

                    }
                } while (phoneNum.length() < 10 || phoneNum.length() > 11);
                break;
        }

        return pymtMethod;
    }

    public static void getOtpNum() {
        String otpNum;

        do {
            System.out.println("\t Please wait a moment. An OTP number has been sent to your device.");
            Screen.pause(3);
            System.out.print("\n\t\t    Enter your OTP number (6 digits): ");
            otpNum = input.nextLine();

            if (otpNum.length() != 6) {
                System.out.println("\n\t\t  Invalid Input! Please try again.");
            } else {
                System.out.println("\n\t\t\t  The payment is processing...");
                Screen.pause(2);
                System.out.println("\n\t\t\t      Payment Successful!\n");
                foodandbeverage.continueMessage();
            }
        } while (otpNum.length() != 6);
    }

    public static void generateReceipt(){
        Screen.clear();

        Font.print(Font.ANSI_YELLOW, "\t ██████╗ ███████╗ ██████╗███████╗██╗██████╗ ████████╗");
        Font.print(Font.ANSI_YELLOW, "\t ██╔══██╗██╔════╝██╔════╝██╔════╝██║██╔══██╗╚══██╔══╝");
        Font.print(Font.ANSI_YELLOW, "\t ██████╔╝█████╗  ██║     █████╗  ██║██████╔╝   ██║   ");
        Font.print(Font.ANSI_YELLOW, "\t ██╔══██╗██╔══╝  ██║     ██╔══╝  ██║██╔═══╝    ██║   ");
        Font.print(Font.ANSI_YELLOW, "\t ██║  ██║███████╗╚██████╗███████╗██║██║        ██║   ");
        Font.print(Font.ANSI_YELLOW, "\t ╚═╝  ╚═╝╚══════╝ ╚═════╝╚══════╝╚═╝╚═╝        ╚═╝   ");
        System.out.println("=============================================================================");
        
    }

    public static void displayPayment(MapInterface<Integer, Payment> payments){

        System.out.println("===================================================================================");
        System.out.println("\tID \t\tPAYMENT METHOD  \tTOTAL(RM)");
        System.out.println("===================================================================================");
        System.out.println(payments.toString());
        System.out.println("===================================================================================");

    }
}

package rsf2s1g2.client;

import java.util.Scanner;

import rsf2s1g2.adt.MapInterface;
import rsf2s1g2.entity.Customer;
import rsf2s1g2.utility.Font;

public class customer {

    private static Scanner input = new Scanner(System.in);

    public static String[] addDetails(MapInterface<String, Customer> customers) {
        String custName, custPhoneNum, custAddr;

        Font.print(Font.ANSI_YELLOW, "\t   ██████╗██╗  ██╗███████╗ ██████╗██╗  ██╗ ██████╗ ██╗   ██╗████████╗");
        Font.print(Font.ANSI_YELLOW, "\t  ██╔════╝██║  ██║██╔════╝██╔════╝██║ ██╔╝██╔═══██╗██║   ██║╚══██╔══╝");
        Font.print(Font.ANSI_YELLOW, "\t  ██║     ███████║█████╗  ██║     █████╔╝ ██║   ██║██║   ██║   ██║   ");
        Font.print(Font.ANSI_YELLOW, "\t  ██║     ██╔══██║██╔══╝  ██║     ██╔═██╗ ██║   ██║██║   ██║   ██║   ");
        Font.print(Font.ANSI_YELLOW, "\t   ██████╗██║  ██║███████╗╚██████╗██║  ██╗╚██████╔╝╚██████╔╝   ██║   ");
        Font.print(Font.ANSI_YELLOW, "\t   ╚═════╝╚═╝  ╚═╝╚══════╝ ╚═════╝╚═╝  ╚═╝ ╚═════╝  ╚═════╝    ╚═╝   ");
        System.out.println("  =========================================================================================");

        String custIcNo = validateIcNo();

        if (!customers.contains(custIcNo)) {
            System.out.print("     Name         : ");
            custName = input.nextLine();
            System.out.print("     Phone Number : ");
            custPhoneNum = input.nextLine();
            System.out.print("     Address      : ");
            custAddr = input.nextLine();
            customers.add(custIcNo, new Customer(custIcNo, custName, custPhoneNum, custAddr));
        } else {
            System.out.println("\nThank you for purchasing again! Please insert your catering date.");
            custName = customers.getValue(custIcNo).getName();
            custPhoneNum = customers.getValue(custIcNo).getPhoneNum();
            custAddr = customers.getValue(custIcNo).getAddress();
        }

        System.out.print("     Catering Date: ");
        String date = input.nextLine();

        String[] temp = new String[2];
        temp[0] = date;
        temp[1] = custIcNo;
        return temp;

    }

    public static String validateIcNo() {
        String custIcNo = "";
        boolean isValid = true;

        do {
            try {
                System.out.print("     IC Number    : ");
                custIcNo = input.nextLine();
                if (custIcNo.length() < 12 || custIcNo.length() > 12) {
                    System.out.println("     \nPlease insert correct format IC Number.");
                    System.out.println("   << 12 Integers With No Dash >>\n");
                    isValid = false;
                } else {
                    isValid = true;
                }
            } catch (Exception e) {
                System.out.println("     \nPlease insert correct format IC Number.");
                System.out.println("   << 12 Integers With No Dash >>\n");
                input.nextLine();
            }
        } while (!isValid);

        return custIcNo;
    }

}

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

        if (customers.contains(custIcNo)) {
            System.out.println("\n\tThank you for purchasing again! Please insert your catering date.");
            System.out.println("\t\t     Name         : " + customers.getValue(custIcNo).getName());
            System.out.println("\t\t     Phone Number : " + customers.getValue(custIcNo).getPhoneNum());
            System.out.println("\t\t     Address      : " + customers.getValue(custIcNo).getAddress());
            custName = customers.getValue(custIcNo).getName();
            custPhoneNum = customers.getValue(custIcNo).getPhoneNum();
            custAddr = customers.getValue(custIcNo).getAddress();
        } else {
            System.out.print("\t\t     Name         : ");
            custName = input.nextLine();
            System.out.print("\t\t     Phone Number : ");
            custPhoneNum = input.nextLine();
            System.out.print("\t\t     Address      : ");
            custAddr = input.nextLine();
            customers.add(custIcNo, new Customer(custIcNo, custName, custPhoneNum, custAddr));
        }

        System.out.print("\t\t     Catering Date: ");
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
                System.out.print("\t\t     IC Number    : ");
                custIcNo = input.nextLine();
                if (custIcNo.length() < 12 || custIcNo.length() > 12) {
                    System.out.println("     \n\t\tPlease insert correct format IC Number.");
                    System.out.println("   \t\t<< 12 Integers With No Dash >>\n");
                    isValid = false;
                } else {
                    isValid = true;
                }
            } catch (Exception e) {
                System.out.println("     \n\t\tPlease insert correct format IC Number.");
                System.out.println("   \t\t<< 12 Integers With No Dash >>\n");
                input.nextLine();
            }
        } while (!isValid);

        return custIcNo;
    }

}

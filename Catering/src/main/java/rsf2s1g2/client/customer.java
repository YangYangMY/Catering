package rsf2s1g2.client;
import java.util.Scanner;

import rsf2s1g2.adt.Map;
import rsf2s1g2.adt.MapInterface;
import rsf2s1g2.entity.Customer;
import rsf2s1g2.utility.Font;
import rsf2s1g2.utility.Screen;

public class customer {
    
    private static Scanner input = new Scanner(System.in);

    public static String[] addDetails(MapInterface<String, Customer> customers){
       
        Font.print(Font.ANSI_YELLOW, "\t   ██████╗██╗  ██╗███████╗ ██████╗██╗  ██╗ ██████╗ ██╗   ██╗████████╗");
        Font.print(Font.ANSI_YELLOW, "\t  ██╔════╝██║  ██║██╔════╝██╔════╝██║ ██╔╝██╔═══██╗██║   ██║╚══██╔══╝");
        Font.print(Font.ANSI_YELLOW, "\t  ██║     ███████║█████╗  ██║     █████╔╝ ██║   ██║██║   ██║   ██║   ");
        Font.print(Font.ANSI_YELLOW, "\t  ██║     ██╔══██║██╔══╝  ██║     ██╔═██╗ ██║   ██║██║   ██║   ██║   ");
        Font.print(Font.ANSI_YELLOW, "\t   ██████╗██║  ██║███████╗╚██████╗██║  ██╗╚██████╔╝╚██████╔╝   ██║   ");
        Font.print(Font.ANSI_YELLOW, "\t   ╚═════╝╚═╝  ╚═╝╚══════╝ ╚═════╝╚═╝  ╚═╝ ╚═════╝  ╚═════╝    ╚═╝   ");
        System.out.println("  =========================================================================================");
        
        System.out.print("     Name         : ");
        String custName = input.nextLine();
        String custIcNo = validateIcNo();
        System.out.print("     Phone Number : ");
        String custPhoneNum = input.nextLine();
        System.out.print("     Address      : ");
        String custAddr = input.nextLine();
        System.out.print("     Catering Date: ");
        String date = input.nextLine();

        customers.add(custIcNo, new Customer(custIcNo, custName, custPhoneNum, custAddr));

        String[] temp = new String[2];
        temp[0] = date;
        temp[1] = custIcNo;
        return temp;
        
    }

    public static String validateIcNo(){
        String custIcNo = "";
        boolean isValid = true;

        do{
            try{
                System.out.print("     IC Number    : ");
                custIcNo = input.nextLine();
                if(custIcNo.length() < 12 || custIcNo.length() > 12){
                    System.out.println("     \nPlease insert correct format IC Number.");
                    System.out.println("   << 12 Integers With No Dash >>\n");
                    isValid = false;
                }else{
                    isValid = true;
                }
            }catch(Exception e){
                    System.out.println("     \nPlease insert correct format IC Number.");
                    System.out.println("   << 12 Integers With No Dash >>\n");
                    input.nextLine();
            }
        }while(!isValid);

        return custIcNo;
    }

    public static void displayCustomer(MapInterface<String, Customer> customers){

        System.out.println("===================================================================================");
        System.out.println("\tIC NO. \t\tNAME  \tPHONE NO.  \tADDRESS");
        System.out.println("===================================================================================");
        System.out.println(customers.toString());
        System.out.println("===================================================================================");

    }
}

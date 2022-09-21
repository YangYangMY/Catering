package rsf2s1g2.client;
import java.util.Scanner;

import rsf2s1g2.adt.Map;
import rsf2s1g2.adt.MapInterface;
import rsf2s1g2.entity.Customer;
import rsf2s1g2.utility.Font;
import rsf2s1g2.utility.Screen;

public class customer {
    
    private static Scanner input = new Scanner(System.in);

    public static void addDetails(){
        MapInterface<String, Customer> cust = new Map<String, Customer>();

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

        cust.add(custIcNo, new Customer(custIcNo, custName, custPhoneNum, custAddr));
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
}

package rsf2s1g2.entity;

import rsf2s1g2.utility.*;

public class Accessories {
    private String accName;
    private int accNum;
    private boolean printStringOne = false;
    private static int num = 0;

    public Accessories(String accName) {
        this.accName = accName;
        printStringOne = true;
    }

    public Accessories(String accName, int accNum) {
        this.accName = accName;
        this.accNum = accNum;
    }

    public String getAccName() {
        return accName;
    }

    public int getAccNum() {
        return accNum;
    }

    public static void resetNum(){
        num = 0;
    }

    public static void displayAccesorries(){
        System.out.println("\t\t\t1. Add Accessories\n\t\t\t2. Clear Cart\n\t\t\t3. Exit");
        System.out.println("====================================================================");
    }

    @Override
    public String toString() {
        num += 1;
        if(printStringOne){
            return num + ".\t" + accName;
        } else {
            return num + ". " + accName + "\t" + accNum;
        }
    }
}

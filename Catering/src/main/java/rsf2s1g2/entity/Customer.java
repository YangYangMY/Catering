package rsf2s1g2.entity;


public class Customer{
    private String name;
    private String address;
    private String phoneNum;
    private String icNo;

    public Customer(){}

    public Customer(String custIcNo, String custName, String custPhoneNum, String custAddress){
        this.icNo = custIcNo;
        this.name = custName;
        this.phoneNum = custPhoneNum;
        this.address = custAddress;
    }

    //Getter and Setter
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    @Override
    public String toString() {
        String output = "";
        System.out.println("===================================================================================");
        System.out.println("\tIC NO. \t\tNAME  \tPHONE NO.  \tADDRESS");
        System.out.println("===================================================================================");
        System.out.println(icNo + "\t\t" + name + "\t" + phoneNum + "\t" + address);
        System.out.println("===================================================================================");
        return output;
    }
}

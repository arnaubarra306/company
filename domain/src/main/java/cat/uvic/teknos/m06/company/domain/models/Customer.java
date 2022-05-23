package cat.uvic.teknos.m06.company.domain.models;

public class Customer {

    private  String name;
    private  String adress;
    private int CustomerCode;


    public Integer getCustomerCode() {return CustomerCode;}

    public int setCustomerCode() { this.CustomerCode = CustomerCode;
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { name = name;}

    public void addS(Customer cust) {
    }



}

package cat.uvic.teknos.m06.company.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;

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

package cat.uvic.teknos.m06.company.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private  String name;
    private  String adress;
    private int CustomerCode;

    public Integer getId() {return id;}

    public Integer getCustomerCode() {return CustomerCode;}

    public int setCustomerCode(int i) { this.CustomerCode = CustomerCode;
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { name = name;}

    public void addS(Customer cust) {
    }


    public int setId(int i) {this.id = id;
        return 0;
    }
}

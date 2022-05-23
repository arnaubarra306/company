package cat.uvic.teknos.m06.company.domain.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer {
    private static final int Cust = 0;
    private int code;
    private  String name;
    private  String adress;
    private  String city;
    private int phone;


    public Integer getCode() {return code;}

    public int setCode() { this.code = code;
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String surname) { name = name;}

    public void addS(Customer cust) {
    }



    public class DATE {
        public static void main(String[] args) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime DATE = LocalDateTime.now();
        }
    }

}



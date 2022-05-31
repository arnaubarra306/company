package cat.uvic.teknos.m06.company.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private  String description;
    private int id;


    public Integer getId() {return id;}

    public int setId(int anInt) { this.id = id;
        return 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { description = description;}

    public void addS(Product product) {
    }



}

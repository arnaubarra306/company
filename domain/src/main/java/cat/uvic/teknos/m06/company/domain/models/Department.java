package cat.uvic.teknos.m06.company.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private  String name;
    private  String Location;
    private int id;


    public Integer getId() {return id;}

    public void setId(Integer deptNo) { this.id = deptNo;}

    public String getName() {
        return name;
    }

    public void setName(String name) { name = name;}

    public void addS(Department dept) {
    }
}

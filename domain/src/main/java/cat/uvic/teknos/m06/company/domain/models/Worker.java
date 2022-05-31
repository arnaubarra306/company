package cat.uvic.teknos.m06.company.domain.models;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private static final int worker = 0;
    private int compNO;
    private  String surname;
    private  String dept;
    private  String boss;
    private int salary;
    private int comission;
    private int deptNo;
    private int id;


    public Integer getId() {return id;}

    public int setId(int anInt) { this.id = id;
        return 0;
    }

    public Integer getSalary() {return salary;}

    public void setSalary(Integer salary) { this.salary = salary;}

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) { surname = surname;}

    public void addS(Worker worker) {
    }


    public class DATE {
        public static void main(String[] args) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime DATE = LocalDateTime.now();
        }
    }

}



package cat.uvic.teknos.m06.company.domain.models;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Worker {
    private static final int Worker = 0;
    private int compNO;
    private  String surname;
    private  String dept;
    private  String boss;
    private int salary;
    private int comission;
    private int deptNo;


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



package cat.uvic.teknos.m06.company.domain.models;

public class Department {

    private  String name;
    private  String Location;
    private int deptNo;


    public Integer getDeptNo() {return deptNo;}

    public void setDeptNo(Integer deptNo) { this.deptNo = deptNo;}

    public String getName() {
        return name;
    }

    public void setName(String name) { name = name;}

    public void addS(Department cust) {
    }
}

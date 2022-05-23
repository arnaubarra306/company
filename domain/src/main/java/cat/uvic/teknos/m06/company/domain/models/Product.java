package cat.uvic.teknos.m06.company.domain.models;

public class Product {

    private  String description;
    private int ProductNum;


    public Integer getProductNum() {return ProductNum;}

    public int setProductNum(int anInt) { this.ProductNum = ProductNum;
        return 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { description = description;}

    public void addS(Product product) {
    }



}

package day08.Task12345;
import java.util.Date;

public class Product 
{
    private long id;
    private String prodName;
    private String prodDesc;
    private String prodCategory;
    private float price;
    private Date createdDate;

    // Constructors
    public Product() { 
    }


    public Product(long id, String prodName, String prodDesc, String prodCategory, float price, Date createdDate) {
        this.id = id;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodCategory = prodCategory;
        this.price = price;
        this.createdDate = createdDate;
    }


    // Getters Setters

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getProdName() {
        return prodName;
    }


    public void setProdName(String prodName) {
        this.prodName = prodName;
    }


    public String getProdDesc() {
        return prodDesc;
    }


    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }


    public String getProdCategory() {
        return prodCategory;
    }


    public void setProdCategory(String prodCategory) {
        this.prodCategory = prodCategory;
    }


    public Float getPrice() {
        return price;
    }


    public void setPrice(Float price) {
        this.price = price;
    }


    public Date getCreatedDate() {
        return createdDate;
    }


    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    // Methods
    @Override
    public String toString() {
        return "Product [id=" + id + ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", prodCategory="
                + prodCategory + ", price=" + price + ", createdDate=" + createdDate + "]";
    }
    
    

    
    
    
}

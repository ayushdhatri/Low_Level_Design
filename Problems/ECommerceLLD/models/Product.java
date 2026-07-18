package Low_Level_Design.Problems.ECommerceLLD.models;


// you can also have builder pattern implemented
public class Product {
    private String name;
    private double price;
    private Brand brand;
    private Category category;

    public Product(String name,double price, Brand brand, Category category){
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.category = category;
    }
    // getter and setters 
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPrice(double price){
        this.price = price;
    }
    
    public double getPrice(){
        return this.price;
    }

    public Category getCategory(){
        return this.category;
    }

    public Brand getBrand(){
        return this.brand;
    }
    

}
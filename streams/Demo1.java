package Low_Level_Design.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Product {
    private String name;
    private double price;
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }
   
}

public class Demo1 {
    public static void main(String[] args) {
        Product[] products = {
            new Product("Product 1", 10.0),
            new Product("Product 2", 20.0)
        };

        ArrayList<Product> productList = new ArrayList<>(Arrays.asList(products));// converted array to list

        // normally going to data store and asking for the data one by one by index 
        for(int i = 0;i<productList.size();i++){
            System.out.println(productList.get(i) + " - " + productList.get(i).getName());
        }

        productList.stream().forEach((product) -> System.out.println(product.getName()));
        
        productList.stream().forEach((product)-> System.out.println(product.getName()));

        productList.stream().filter(product -> {
            double price = product.getPrice();
            return price < 250;
        }).forEach((product)->{
            System.out.println(product.getName());
        });

        productList.stream().map(product ->{
            return product.getPrice() + 10;
        }).collect(Collectors.toList());

        
        productList.stream().map(product ->{
            return product.getPrice() + 10;
        }).findFirst();
        
    }
}

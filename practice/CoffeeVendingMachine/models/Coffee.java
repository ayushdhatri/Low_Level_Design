package Low_Level_Design.practice.CoffeeVendingMachine.models;

public abstract class Coffee {

    private String coffeeName = "UNKNOWN";
    private double coffeePrice;
    private Recipe recipie;

    public Coffee(String coffeeName, double coffeePrice, Recipe recipie){
        this.coffeeName = coffeeName;
        this.coffeePrice = coffeePrice;
        this.recipie = recipie;
    }

    public String getCoffeeName(){
        return this.coffeeName;
    }

    public double getCoffeePrice(){
        return this.coffeePrice;
    }

    public Recipe getRecipie(){
        return this.recipie;
    }


    
} 


package Low_Level_Design.practice.CoffeeVendingMachine.models;

import Low_Level_Design.practice.CoffeeVendingMachine.enums.CoffeeType;

public abstract class Coffee {

    private CoffeeType coffeeName;
    private double coffeePrice;
    private Recipe recipie;

    public Coffee(CoffeeType coffeeName, double coffeePrice, Recipe recipie){
        this.coffeeName = coffeeName;
        this.coffeePrice = coffeePrice;
        this.recipie = recipie;
    }

    public CoffeeType getCoffeeType() {
        return this.coffeeName;
    }

    public double getPrice() {
        return this.coffeePrice;
    }

    public Recipe getRecipe() {
        return this.recipie;
    }
} 


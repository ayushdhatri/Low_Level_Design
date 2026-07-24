package Low_Level_Design.practice.CoffeeVendingMachine.decorator;

import Low_Level_Design.practice.CoffeeVendingMachine.enums.CoffeeType;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Coffee;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Recipe;

public class CoffeeDecorator extends Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee){
        super(coffee.getCoffeeType(), coffee.getPrice(), coffee.getRecipe());
        this.decoratedCoffee = coffee;
    }
    @Override
    public CoffeeType getCoffeeType() {
        return decoratedCoffee.getCoffeeType();
    }

    @Override
    public double getPrice() {
        return decoratedCoffee.getPrice();
    }

    @Override
    public Recipe getRecipe() {
        return decoratedCoffee.getRecipe();
    }
        

    
}

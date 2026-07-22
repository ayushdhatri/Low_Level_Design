package Low_Level_Design.practice.CoffeeVendingMachine.decorator;

import Low_Level_Design.practice.CoffeeVendingMachine.enums.Ingredient;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Coffee;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Recipe;

/**
 * CaramelSyrupDecorator
 */
public class CaramelSyrupDecorator extends CoffeeDecorator {
    private final double CARAMEL_SYRUP_PRICE = 50;
    private final int quantity = 10;

    public CaramelSyrupDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public double getPrice() {
        return this.decoratedCoffee.getPrice() + CARAMEL_SYRUP_PRICE;
    }

    @Override
    public Recipe getRecipe() {
        Recipe combinedRecipe = new Recipe();
        this.decoratedCoffee.getRecipe().getAllIngredients().forEach((ingredient, quantity)->{
            combinedRecipe.addIngredients(ingredient, quantity);
        });

        combinedRecipe.addIngredients(Ingredient.CARAMEL_SYRUP, this.quantity);
        return combinedRecipe;
    }
  


    
} 
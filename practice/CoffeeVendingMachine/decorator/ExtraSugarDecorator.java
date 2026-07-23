package Low_Level_Design.practice.CoffeeVendingMachine.decorator;

import Low_Level_Design.practice.CoffeeVendingMachine.enums.CoffeeType;
import Low_Level_Design.practice.CoffeeVendingMachine.enums.Ingredient;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Coffee;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Recipe;

/**
 * ExtraSugarDecorator
 */
public class ExtraSugarDecorator extends CoffeeDecorator {
    private final double SUGAR_PRICE = 10.0;
    private final int SUGAR_QUANTITY = 10;// GRAMS
    
    public ExtraSugarDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public double getPrice() {
        return decoratedCoffee.getPrice() + SUGAR_PRICE;
    }

    @Override
    public Recipe getRecipe() {
       Recipe combinedRecipe = new Recipe();
       decoratedCoffee.getRecipe().getAllIngredients().forEach((ingredient, quantity) ->{
        combinedRecipe.addIngredients(ingredient, quantity);
       });
       combinedRecipe.addIngredients(Ingredient.SUGAR, SUGAR_QUANTITY);
       return combinedRecipe;
    }

    
}

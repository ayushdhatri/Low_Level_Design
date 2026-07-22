package Low_Level_Design.practice.CoffeeVendingMachine.factory;

import Low_Level_Design.practice.CoffeeVendingMachine.enums.CoffeeType;
import Low_Level_Design.practice.CoffeeVendingMachine.enums.Ingredient;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Cappuccino;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Coffee;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Espresso;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Latte;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Recipe;

public class CoffeeFactory {
    public static Coffee createCoffee(CoffeeType coffeeType){
        switch (coffeeType) {
            case CoffeeType.CAPPUCCINO:
                Recipe cappuccinoRecipe = new Recipe()
                        .addIngredients(Ingredient.WATER, 50)
                        .addIngredients(Ingredient.COFFEE_BEANS, 15)
                        .addIngredients(Ingredient.MILK, 150)
                        .addIngredients(Ingredient.SUGAR, 10);
                
                return new Cappuccino(cappuccinoRecipe);
                
            case CoffeeType.ESPRESSO:
                Recipe espressoRecipe = new Recipe()
                        .addIngredients(Ingredient.WATER, 30)
                        .addIngredients(Ingredient.COFFEE_BEANS, 18);
                
                return new Espresso(espressoRecipe);
                

            case CoffeeType.LATTE:
                Recipe latteRecipe = new Recipe()
                        .addIngredients(Ingredient.WATER, 50)
                        .addIngredients(Ingredient.COFFEE_BEANS, 15)
                        .addIngredients(Ingredient.MILK, 200)
                        .addIngredients(Ingredient.SUGAR, 10);
                
                return new Latte(latteRecipe);
               
        
            default:
                throw new IllegalArgumentException("Unsupported coffee type" + coffeeType);
        }


    }
    
}

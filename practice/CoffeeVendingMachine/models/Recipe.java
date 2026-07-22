package Low_Level_Design.practice.CoffeeVendingMachine.models;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe{
    private final Map<Ingredient, Integer> ingredients;
    public Recipe(){
        this.ingredients = new HashMap<>();
    }

    public Recipe addIngredients(Ingredient ingredient, int quantity){
        if(quantity > 0){
            ingredients.put(ingredient, this.ingredients.getOrDefault(ingredient,0) + quantity);
        }
        return this;// new Recipie().addIngredients("Coffee", 20).addIngredients()..... we can chain them
    } 

    public int getQuantity(Ingredient ingredient){
        return this.ingredients.getOrDefault(ingredient,0);
    }

    public Map<Ingredient, Integer> getAllIngredients(){
        return Collections.unmodifiableMap(ingredients);
    }


}
package Low_Level_Design.practice.CoffeeVendingMachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.practice.CoffeeVendingMachine.enums.Ingredient;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Recipe;

public class Inventory {
    public static final Inventory INSTANCE = new Inventory();
    private final Map<Ingredient, Integer> stock = new ConcurrentHashMap<>();

    private Inventory(){

    }

    public static Inventory getInstance(){
        return INSTANCE;
    }

    public void addStock(Ingredient ingredient, int quantity){
        stock.put(ingredient, stock.getOrDefault(ingredient, 0) + quantity);
    }

    public boolean hasIngredients(Recipe recipe){
        for(Map.Entry<Ingredient, Integer> entry : recipe.getAllIngredients().entrySet()){
            Ingredient ingredient = entry.getKey();
            int requiredQuantity = entry.getValue();
            if(stock.getOrDefault(ingredient, 0) < requiredQuantity){
                return false;
            }
        
        }
        return true;
    }
    public synchronized void deductIngredients(Recipe recipe){
        if(!hasIngredients(recipe)){
            System.out.println("Not enough ingreients to make coffee");
            return;
        }
        // we will start deducting
        for(Map.Entry<Ingredient, Integer> entry : recipe.getAllIngredients().entrySet()){
            Ingredient ingredient = entry.getKey();
            int quantity = entry.getValue();
            stock.put(ingredient,stock.getOrDefault(ingredient, 0) - quantity);
        }

    }

    public void printInventory(){
        System.out.println("--- Current Inventory ---");
        for(Map.Entry<Ingredient, Integer> entry : stock.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("-------------------------");
    }


    
    
}

package Low_Level_Design.practice.CoffeeVendingMachine.models;

import Low_Level_Design.practice.CoffeeVendingMachine.enums.CoffeeType;

public class Latte extends Coffee {
    public Latte(Recipe recipe){
        super(CoffeeType.LATTE, 380.0, recipe);
    }
    
}

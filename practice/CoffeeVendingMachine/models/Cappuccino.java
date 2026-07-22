package Low_Level_Design.practice.CoffeeVendingMachine.models;

import Low_Level_Design.practice.CoffeeVendingMachine.enums.CoffeeType;

public class Cappuccino extends Coffee{

    public Cappuccino(Recipe recipe){
        super(CoffeeType.CAPPUCCINO, 250.0,recipe);
    }

   

    
}

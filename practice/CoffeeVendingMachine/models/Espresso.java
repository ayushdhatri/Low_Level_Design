 package Low_Level_Design.practice.CoffeeVendingMachine.models;

import Low_Level_Design.practice.CoffeeVendingMachine.enums.CoffeeType;

public class Espresso extends Coffee {

    public Espresso(Recipe recipe){
        super(CoffeeType.ESPRESSO, 299.0, recipe);
    }
}
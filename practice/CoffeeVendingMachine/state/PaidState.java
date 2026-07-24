package Low_Level_Design.practice.CoffeeVendingMachine.state;

import Low_Level_Design.practice.CoffeeVendingMachine.CoffeeVendingMachine;
import Low_Level_Design.practice.CoffeeVendingMachine.Inventory;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Coffee;

public class PaidState implements VendingMachineState {

    @Override
    public void selectCoffee(CoffeeVendingMachine coffeeVendingMachine, Coffee coffee) {
        System.out.println("Coffee is already selected. Pay or cancel");
    }

    @Override
    public void insertMoney(CoffeeVendingMachine coffeeVendingMachine, double amount) {
        System.out.println("Money is already inserted. Pay or cancel");
    
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine machine) {
        Inventory inventory = Inventory.getInstance();
        Coffee coffeeToDispense = machine.getCoffee();
        if(!inventory.hasIngredients(coffeeToDispense.getRecipe())){
            System.out.println("Sorry, out of ingredients for " + machine.getCoffee().getCoffeeType());
            machine.setState(new OutOfIngredientsState());
            machine.getState().cancel(machine);
            return;
        }
        inventory.deductIngredients(coffeeToDispense.getRecipe());
        double change = machine.getMoneyInserted() - coffeeToDispense.getPrice();
        if(change > 0){
            System.out.println("Returning change: " + change);
        }

        machine.reset();
        machine.setState(new ReadyState());

        
    }

    @Override
    public void cancel(CoffeeVendingMachine coffeeVendingMachine) {
        
    }
    
}

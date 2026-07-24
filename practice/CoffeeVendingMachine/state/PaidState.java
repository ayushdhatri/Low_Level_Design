package Low_Level_Design.practice.CoffeeVendingMachine.state;

import Low_Level_Design.practice.CoffeeVendingMachine.CoffeeVendingMachine;
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
        
    }

    @Override
    public void cancel(CoffeeVendingMachine coffeeVendingMachine) {
        
    }
    
}

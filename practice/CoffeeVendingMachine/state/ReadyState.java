package Low_Level_Design.practice.CoffeeVendingMachine.state;

import Low_Level_Design.practice.CoffeeVendingMachine.CoffeeVendingMachine;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Coffee;

public class ReadyState implements VendingMachineState {

    @Override
    public void selectCoffee(CoffeeVendingMachine coffeeVendingMachine, Coffee coffee) {
       coffeeVendingMachine.setCoffee(coffee);
       coffeeVendingMachine.setState(new SelectingState());
       System.out.println(coffee.getCoffeeType() + " selected price: " + coffee.getPrice());
    }

    @Override
    public void insertMoney(CoffeeVendingMachine coffeeVendingMachine,double amount) {
        // It is not possible to insert money without selecting coffee
        System.out.println("Please Select Coffee First");
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine machine) {
        System.out.println("Please select and pay first");
    }

    @Override
    public void cancel(CoffeeVendingMachine coffeeVendingMachine) {
        System.out.println("Nothing to Cancel");
    
    }

}

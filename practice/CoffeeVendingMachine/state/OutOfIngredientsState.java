package Low_Level_Design.practice.CoffeeVendingMachine.state;

import Low_Level_Design.practice.CoffeeVendingMachine.CoffeeVendingMachine;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Coffee;

public class OutOfIngredientsState implements VendingMachineState {

    @Override
    public void selectCoffee(CoffeeVendingMachine coffeeVendingMachine, Coffee coffee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectCoffee'");
    }

    @Override
    public void insertMoney(CoffeeVendingMachine coffeeVendingMachine, double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertMoney'");
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine machine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispenseCoffee'");
    }

    @Override
    public void cancel(CoffeeVendingMachine coffeeVendingMachine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancel'");
    }

    
}

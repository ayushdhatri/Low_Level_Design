package Low_Level_Design.practice.CoffeeVendingMachine.state;

import Low_Level_Design.practice.CoffeeVendingMachine.CoffeeVendingMachine;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Coffee;

public interface VendingMachineState {
    void selectCoffee(CoffeeVendingMachine coffeeVendingMachine, Coffee coffee);
    void insertMoney(CoffeeVendingMachine coffeeVendingMachine, double amount);
    void dispenseCoffee(CoffeeVendingMachine machine);
    void cancel(CoffeeVendingMachine coffeeVendingMachine);
}

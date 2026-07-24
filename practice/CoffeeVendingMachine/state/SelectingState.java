package Low_Level_Design.practice.CoffeeVendingMachine.state;

import Low_Level_Design.practice.CoffeeVendingMachine.CoffeeVendingMachine;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Coffee;

public class SelectingState implements VendingMachineState {

    @Override
    public void selectCoffee(CoffeeVendingMachine coffeeVendingMachine, Coffee coffee) {
        System.out.println("Coffee is already selected, Please pay or cancel");
    }


    @Override
    public void insertMoney(CoffeeVendingMachine coffeeVendingMachine, double amount){
        coffeeVendingMachine.setMoneyInserted(amount);
        System.out.println("Inserted " + amount + ". Total: " + coffeeVendingMachine.getMoneyInserted());
        if(coffeeVendingMachine.getMoneyInserted() >= coffeeVendingMachine.getCoffee().getPrice()){
            coffeeVendingMachine.setState(new PaidState());
        }
        
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine machine) {
        
    }

    @Override
    public void cancel(CoffeeVendingMachine coffeeVendingMachine) {
       
    }

}

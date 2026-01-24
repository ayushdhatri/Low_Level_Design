package Low_Level_Design.Problems.VendingMachine.state;

import Low_Level_Design.Problems.VendingMachine.VendingMachine;
import Low_Level_Design.Problems.VendingMachine.enums.Coin;

public class IdleState extends VendingMachineState{
    public IdleState(VendingMachine vendingMachine){
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please Select an item before inserting money");
    }

    @Override
    public void selectItem(String code) {
        if(!vendingMachine.getInventory().isAvailable(code)){
            System.out.println("Item is not available");
            return ;
        }
        vendingMachine.setSelectedItemCode(code);
        vendingMachine.setState(new ItemSelectedState(vendingMachine));
        System.out.println("Item Selected : " + code);
    }

    @Override
    public void dispense() {
           System.out.println("No item selected.");
    }

    @Override
    public void refund() {
        System.out.println("No money to refund.");

    }

}
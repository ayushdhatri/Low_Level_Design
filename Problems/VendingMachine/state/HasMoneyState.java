package Low_Level_Design.Problems.VendingMachine.state;

import Low_Level_Design.Problems.VendingMachine.VendingMachine;
import Low_Level_Design.Problems.VendingMachine.enums.Coin;

public class HasMoneyState extends VendingMachineState{

    public HasMoneyState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Already received full amount.");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void dispense() {
          vendingMachine.setState(new DispensingState(vendingMachine));
          vendingMachine.dispenseItem();
    }

    @Override
    public void refund() {
        vendingMachine.refundBalance();
        vendingMachine.reset();
        vendingMachine.setState(new IdleState(vendingMachine));
    }
    
}
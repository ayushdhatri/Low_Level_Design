package Low_Level_Design.Problems.VendingMachine.state;

import Low_Level_Design.Problems.VendingMachine.VendingMachine;
import Low_Level_Design.Problems.VendingMachine.enums.Coin;

public abstract class VendingMachineState{
    VendingMachine vendingMachine;

    public VendingMachineState(VendingMachine machine){
        this.vendingMachine = machine;
    }

    public abstract void insertCoin(Coin coin);
    public abstract void selectItem(String code);
    public abstract void dispense();
    public abstract void refund();

}
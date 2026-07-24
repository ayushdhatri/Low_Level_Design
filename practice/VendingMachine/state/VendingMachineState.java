package Low_Level_Design.practice.VendingMachine.state;


import Low_Level_Design.practice.VendingMachine.VendingMachine;
import Low_Level_Design.practice.VendingMachine.entity.Item;

public abstract class VendingMachineState {
    VendingMachine vendingMachine;
    public VendingMachineState(VendingMachine machine){
        this.vendingMachine = machine;
    }
    public abstract void insertCoin(Item item);
    public abstract void selectItem(Item item);
    public abstract void dispense();
    public abstract void refund();
    
    
}
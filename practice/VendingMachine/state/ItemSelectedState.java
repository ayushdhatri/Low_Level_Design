package Low_Level_Design.practice.VendingMachine.state;


import Low_Level_Design.practice.VendingMachine.VendingMachine;
import Low_Level_Design.practice.VendingMachine.entity.Item;

public class ItemSelectedState extends VendingMachineState {

    public ItemSelectedState(VendingMachine machine){
        super(machine); 
    }

    @Override
    public void insertCoin(Item item) {
       
    }

    @Override
    public void selectItem(Item item) {
        System.out.println("Iteam already selected");
    }

    @Override
    public void dispense() {
       System.out.println("Please insert sufficinet money");
    }

    @Override
    public void refund() {
        this.vendingMachine.reset();
        this.vendingMachine.setState(new IdleState(vendingMachine));
    }
    
}

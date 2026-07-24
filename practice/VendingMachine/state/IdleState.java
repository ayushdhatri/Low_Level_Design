package Low_Level_Design.practice.VendingMachine.state;

import Low_Level_Design.practice.VendingMachine.VendingMachine;
import Low_Level_Design.practice.VendingMachine.entity.Item;

/**
 * IdleState
 */
public class IdleState extends VendingMachineState {

    public IdleState(VendingMachine machine){
        super(machine);
    }

    @Override
    public void insertCoin(Item item) {
        System.out.println("Please select item before paying");
    }

    @Override
    public void selectItem(String code) {
        // here we will select item
        // once user selects the item, we recieve as parameter
        // then we ask the inventory here if we have the availalbe stocks
        // once approved we moved to insert coind state
        
    }

    @Override
    public void dispense() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispense'");
    }

    @Override
    public void refund() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refund'");
    }

    
}
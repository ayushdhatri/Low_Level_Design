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
    public void insertCoin(Money money) {
        System.out.println("Please select item before paying");
    }

    @Override
    public void selectItem(Item item) {
        // here we will select item
        this.vendingMachine.setSelectedItem(item.getCode());
        // once user selects the item, we recieve as parameter
        // then we ask the inventory here if we have the availalbe stocks
        if(!this.vendingMachine.getInventory().hasItem(item)){
            // we need to move to idle state again we cannot move to out of order just because of one product
            System.out.println("Item is not avaialble");
            return;
        }
        // once approved we moved to insert coind state
        this.vendingMachine.setState(new ItemSelectedState(vendingMachine));
        
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
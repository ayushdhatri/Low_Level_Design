package Low_Level_Design.practice.VendingMachine.state;

import Low_Level_Design.practice.VendingMachine.VendingMachine;
import Low_Level_Design.practice.VendingMachine.Money.Money;
import Low_Level_Design.practice.VendingMachine.entity.Item;

public class HasMoneyState extends VendingMachineState {

    public HasMoneyState(VendingMachine machine){
        super(machine);
    }

    @Override
    public void insertCoin(Money money) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertCoin'");
    }

    @Override
    public void selectItem(Item item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectItem'");
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

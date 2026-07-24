package Low_Level_Design.practice.VendingMachine.state;


import Low_Level_Design.practice.VendingMachine.VendingMachine;

public class ItemSelectedState extends VendingMachineState {

    public ItemSelectedState(VendingMachine machine){
        super(machine); 
    }

    @Override
    public void insertCoin(Low_Level_Design.practice.VendingMachine.entity.Item item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertCoin'");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Iteam already selected");
    }

    @Override
    public void dispense() {
       System.out.println("Please insert sufficinet money");
    }

    @Override
    public void refund() {
        machine.reset();
        machine.setState(new IdleState(vendingMachine));
    }
    
}

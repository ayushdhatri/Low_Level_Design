package Low_Level_Design.Problems.VendingMachine.state;

import Low_Level_Design.Problems.VendingMachine.VendingMachine;
import Low_Level_Design.Problems.VendingMachine.entity.Item;
import Low_Level_Design.Problems.VendingMachine.enums.Coin;

public class DispensingState extends VendingMachineState {

    public DispensingState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void dispense() {
        Item item = vendingMachine.getSelectedItem();

        vendingMachine.getInventory().reduceStock(vendingMachine.getSelectedItem().getCode());
        int price = item.getPrice();

        System.out.println("Dispensed: " + item.getName());

        int change = vendingMachine.getBalance() - price;
        if (change > 0) {
            System.out.println("Returning change: " + change);
        }

        vendingMachine.reset();
        vendingMachine.setState(new IdleState(vendingMachine));
    }

    @Override public void insertCoin(Coin coin) { System.out.println("Dispensing in progress."); }
    @Override public void selectItem(String code) { System.out.println("Dispensing in progress."); }
    @Override public void refund() { System.out.println("Cannot refund now."); }
}

package Low_Level_Design.Problems.VendingMachine.state;

import Low_Level_Design.Problems.VendingMachine.VendingMachine;
import Low_Level_Design.Problems.VendingMachine.enums.Coin;

public class ItemSelectedState extends VendingMachineState{
    public ItemSelectedState(VendingMachine machine){
        super(machine);
    }

     @Override
    public void insertCoin(Coin coin) {
        // Here item is selcted next step is to insert coins
        vendingMachine.addBalance(coin.getValue());
        System.out.println("Coin Inserted" + coin.getValue());
        int price = vendingMachine.getSelectedItem().getPrice();
        if(vendingMachine.getBalance() >= price){
            System.out.println("Sufficient Money recieved");
            vendingMachine.setState(new HasMoneyState(vendingMachine));
        }

      
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void dispense() {
      System.out.println("Please insert sufficient money.");
    }

    @Override
    public void refund() {
        vendingMachine.reset();
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}
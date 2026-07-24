package Low_Level_Design.practice.VendingMachine;

import Low_Level_Design.practice.VendingMachine.state.IdleState;
import Low_Level_Design.practice.VendingMachine.state.VendingMachineState;

public class VendingMachine {
    private static final VendingMachine INSTANCE = new VendingMachine();
    private Inventory inventory;
    public CashInventory cashInventory;
    private VendingMachineState state;
    private int balance ;
    private String selectedItem;
    private int moneyInserted;


    private VendingMachine(){
        this.balance = 0;
        this.state = new IdleState(this);
        this.selectedItem = null;
        this.inventory = new Inventory();
        this.moneyInserted = 0;
    }
    public VendingMachine getInstance(){
        return INSTANCE;
    }

    public int getBalance(){
        return balance;
    }

    public void addBalance(int amount){
        this.balance+=amount;
    }

    public String getSelectedItem(){
        return this.selectedItem;
    }

    public void setSelectedItem(String code){
        this.selectedItem = code;
    }

    public void setState(VendingMachineState state){
        this.state = state;
    }

    public VendingMachineState getState(){
        return this.state;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public void setMoneyInserted(int amount){
        this.moneyInserted = amount;
    }

    public int getMoneyInserted(){
        return this.moneyInserted;
    }

    
    
}

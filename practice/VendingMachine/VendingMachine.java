package Low_Level_Design.practice.VendingMachine;

import java.util.ArrayList;
import java.util.List;

import Low_Level_Design.practice.VendingMachine.Money.Money;
import Low_Level_Design.practice.VendingMachine.state.IdleState;
import Low_Level_Design.practice.VendingMachine.state.VendingMachineState;

public class VendingMachine {
    private static final VendingMachine INSTANCE = new VendingMachine();
    private Inventory inventory;
    public CashInventory cashInventory;
    private VendingMachineState state;
    private int balance ;
    private String selectedItem;
    private List<Money> moneyInserted;
    private int totalMoneyInserted;


    private VendingMachine(){
        this.balance = 0;
        this.state = new IdleState(this);
        this.selectedItem = null;
        this.inventory = new Inventory();
        this.moneyInserted = new ArrayList<>();
        this.totalMoneyInserted = 0;
    }
    public VendingMachine getInstance(){
        return INSTANCE;
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

    // Money dispense related functinality

    public void setMoneyInserted(Money insertedMoney){
        this.totalMoneyInserted += insertedMoney.getValue();
    }

    public List<Money> getMoneyInserted(){
        return this.moneyInserted;
    }

    public int getTotalMoneyInserted(){
        return this.totalMoneyInserted;
    }

    public void resetCashSession(){
        this.totalMoneyInserted = 0;
        this.moneyInserted.clear();
    }

    public List<Money> refundInsertedCase(){
        List<Money> refund = new ArrayList<>(moneyInserted);
        resetCashSession();
        return refund;
    }

     public int getBalance(){
        return balance;
    }

    public void addBalance(int amount){
        this.balance+=amount;
    }


    
    
}

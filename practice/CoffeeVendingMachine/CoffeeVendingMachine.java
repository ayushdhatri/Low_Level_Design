package Low_Level_Design.practice.CoffeeVendingMachine;


import Low_Level_Design.practice.CoffeeVendingMachine.models.Coffee;
import Low_Level_Design.practice.CoffeeVendingMachine.state.ReadyState;
import Low_Level_Design.practice.CoffeeVendingMachine.state.VendingMachineState;

public class CoffeeVendingMachine {
    private VendingMachineState state;
    private Coffee coffee;
    private double moneyInserted;

    public CoffeeVendingMachine(){
        
    }
    public Coffee getCoffee(){
        return this.coffee;
    }

    public void setCoffee(Coffee coffee){
        this.coffee = coffee;
    }

    public void setState(VendingMachineState state){
        this.state = state;
    }

    public void setMoneyInserted(double moneyInserted){
        this.moneyInserted = moneyInserted;
    }

    public double getMoneyInserted(){
        return this.moneyInserted;
    }

    public void reset(){
        
    }




    



}

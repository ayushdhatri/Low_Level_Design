package Low_Level_Design.practice.CoffeeVendingMachine;


import java.util.List;

import Low_Level_Design.practice.CoffeeVendingMachine.decorator.CaramelSyrupDecorator;
import Low_Level_Design.practice.CoffeeVendingMachine.decorator.CoffeeDecorator;
import Low_Level_Design.practice.CoffeeVendingMachine.decorator.ExtraSugarDecorator;
import Low_Level_Design.practice.CoffeeVendingMachine.enums.CoffeeType;
import Low_Level_Design.practice.CoffeeVendingMachine.enums.ToppingType;
import Low_Level_Design.practice.CoffeeVendingMachine.factory.CoffeeFactory;
import Low_Level_Design.practice.CoffeeVendingMachine.models.Coffee;
import Low_Level_Design.practice.CoffeeVendingMachine.state.ReadyState;
import Low_Level_Design.practice.CoffeeVendingMachine.state.VendingMachineState;

public class CoffeeVendingMachine {
    private static final CoffeeVendingMachine INSTANCE = new CoffeeVendingMachine();
    private VendingMachineState state;
    private Coffee coffee;
    private double moneyInserted;

    public CoffeeVendingMachine getInstance(){
        return INSTANCE;
    }

    private CoffeeVendingMachine(){
        this.state = new ReadyState();
        this.moneyInserted = 0;
        this.coffee = null;
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

    public VendingMachineState getState(){
        return this.state;
    }

    public void setMoneyInserted(double moneyInserted){
        this.moneyInserted = moneyInserted;
    }

    public double getMoneyInserted(){
        return this.moneyInserted;
    }

    public void reset(){
        this.coffee = null;
        this.moneyInserted = 0;
    }

    public void selectCoffee(CoffeeType type, List<ToppingType> toppings){
        // first lets create the base coffee
        Coffee coffee = CoffeeFactory.createCoffee(type);
        for(ToppingType toppioType : toppings){
            switch (toppioType) {
                case EXTRA_SUGAR:
                    coffee = new ExtraSugarDecorator(coffee);
                    break;
                case CARAMEL_SYRUP:
                    coffee = new CaramelSyrupDecorator(coffee);
                default:
                    break;
            }
        }
        this.state.selectCoffee(INSTANCE, coffee);
    }





    



}

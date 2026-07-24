package Low_Level_Design.practice.VendingMachine.Money;

import Low_Level_Design.practice.VendingMachine.enums.MoneyType;

public class Money {
    private final int value;
    private final MoneyType type;

    public Money(int value, MoneyType type){
        this.value = value;
        this.type = type;
    }
    
    public int getValue(){
        return this.value;
    }

    public MoneyType getType(){
        return this.type;
    }
}

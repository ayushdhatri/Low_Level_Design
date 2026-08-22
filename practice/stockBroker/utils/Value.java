package Low_Level_Design.practice.stockBroker.utils;

public class Value {
    private final Currency currency;
    private final double amount;
    public Value(Currency currency, double amount){
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency(){
        return this.currency;
    }
    public double getAmount(){
        return this.amount;
    }
    
}

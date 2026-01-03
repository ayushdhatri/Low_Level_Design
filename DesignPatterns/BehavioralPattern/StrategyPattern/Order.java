package Low_Level_Design.DesignPatterns.BehavioralPattern.StrategyPattern;
import java.util.*;

public class Order {
    private final int id;
    private final double amount;
    private final List<String> items;

    public Order(int id, double amount, List<String> items){
        this.id = id;
        this.amount = amount;
        this.items = items; 

    }

    public int getId(){
        return id;
    }
    public double getAmount(){
        return this.amount;
    }
    public List<String> getItems(){
        return this.items;
    }

}
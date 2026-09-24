package Low_Level_Design.practice.Splitwise.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import Low_Level_Design.practice.Splitwise.service.strategy.SplitStrategy;


// here we need to add builder pattern

public class Expense {
    private final String Id;
    private final String desc;
    private final double amount;
    private final User paidBy;
    private final List<Split> splits;
    private final LocalDateTime timestamp;

    public String getId(){
        return this.Id;
    }

    public String getDesc(){
        return this.desc;
    }

    public double getAmount(){
        return this.amount;
    }

    public User getPaidBy(){
        return this.paidBy;
    }

    public List<Split> getSplits(){
        return this.splits;
    }

    public LocalDateTime getTimeStamp(){
        return this.timestamp;
    }

    private Expense(ExpenseBuilder expenseBuilder){
        this.Id = expenseBuilder.Id;
        this.amount = expenseBuilder.amount;
        this.paidBy = expenseBuilder.paidBy;
        this.desc = expenseBuilder.desc;
        this.splits = expenseBuilder.splitStrategy.split(amount, expenseBuilder.participants, expenseBuilder.splitValues);
        timestamp = LocalDateTime.now();
    }


    public static class ExpenseBuilder{
        private String Id;
        private String desc;
        private double amount;
        private User paidBy;
        private List<User> participants;
        private SplitStrategy splitStrategy;
        private List<Double> splitValues;

        public ExpenseBuilder setId(String id){
            this.Id = id;
            return this;
        }
        public ExpenseBuilder setDesc(String desc){
            this.desc = desc;
            return this;
        }
        public ExpenseBuilder setAmount(double amount) { this.amount = amount; return this; }
        public ExpenseBuilder setPaidBy(User paidBy) { this.paidBy = paidBy; return this; }
        public ExpenseBuilder setParticipants(List<User> participants) { this.participants = participants; return this; }
        public ExpenseBuilder setSplitStrategy(SplitStrategy splitStrategy) { this.splitStrategy = splitStrategy; return this; }
        public ExpenseBuilder setSplitValues(List<Double> splitValues){ this.splitValues = splitValues; return this;}
        
        public Expense build(){
            if(splitStrategy == null){
                throw new IllegalStateException("Split strategy is required.");
            }
            return new Expense(this);

        }
    }








}

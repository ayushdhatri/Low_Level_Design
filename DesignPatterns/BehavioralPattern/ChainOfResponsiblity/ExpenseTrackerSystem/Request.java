package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.ExpenseTrackerSystem;



public class Request{
    private String message;
    private int Id;
    private double amount;
    public Request(String message, int id, double amount){
        this.message = message;
        this.Id = id;
        this.amount = amount;
    }
    public double getAmount(){
        return this.amount;
    }
    public String getRequestMessage(){
        return this.message;
    }

    
    
}
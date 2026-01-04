package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.ExpenseTrackerSystem;

import  Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.ExpenseTrackerSystem.Request;


abstract class Approver{
    protected Approver nextHandler;
    
    public void setNextHandler(Approver nextHandler){
        this.nextHandler = nextHandler;
    }
    public abstract void handleApprove(Request request);
}
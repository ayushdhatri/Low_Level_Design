package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.ExpenseTrackerSystem;


import  Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.ExpenseTrackerSystem.Request;
public class CEO extends Approver{

    @Override
    public void handleApprove(Request request) {
        double amount = request.getAmount();
        if(amount <= 50000000.00){
            System.out.println("CEO has handled the request");
        }
        else{
            System.out.println("Since the amount is not in the range of manager so passing to next handler");
            if(nextHandler != null){
                nextHandler.handleApprove(request);
            }
            else{
                System.out.println("There is no handler associated with this request");
            }
        }
        
    
    }
    
}   
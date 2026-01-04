package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.ExpenseTrackerSystem;


public class Demo{
    public static void main(String[] args){

        Approver ceo = new CEO();
        Approver Director  = new Director();
        Approver SrManager = new SrManager();
        Approver manager = new Manager();

        // let set the handler
        manager.setNextHandler(SrManager);
        SrManager.setNextHandler(Director);
        Director.setNextHandler(ceo);

        // lets createa a new request
        Request newRequest = new Request("For visual studio code", 1, 80000.00);
        manager.handleApprove(newRequest);
        
    }
}
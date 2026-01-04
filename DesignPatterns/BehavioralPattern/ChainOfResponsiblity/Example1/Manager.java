package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.Example1;



public class Manager extends SupportHandler{

    @Override
    public void handleRequest(String issue, int severity){
        System.out.println("None of the supoport system has provided the support");
        System.out.println("Please go throug the request and resolve it");
    }

    
    
}
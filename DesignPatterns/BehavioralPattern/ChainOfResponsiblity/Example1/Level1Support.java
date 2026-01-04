package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.Example1;




public class Level1Support extends SupportHandler{


    @Override
    public void handleRequest(String issue, int severity) {
       if(severity == 1){
        System.out.println("This request is handled by level 1!!");
        System.out.println(" -> Issue resolved by Level 1");
       }
       else{
            System.out.println("Level 1 handler cannot support it....");
            if(nextHandler != null){
                System.out.println("Passing this request to next Handler!");
                nextHandler.handleRequest(issue, severity);
            }
            else{
                System.out.println("-> No more handler available");
            }

       }
    }

}
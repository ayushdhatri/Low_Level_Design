package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.Example1;



public class ChainOfResponsiblity{
    public static void main(String[] args){
        SupportHandler Level1Support = new Level1Support();
        SupportHandler Level2Support = new Level2Support();
        SupportHandler Level3Support = new Level3Support();

        // Create a manager
        SupportHandler manager = new Manager();

        // lets set the next handler
        Level1Support.setNextHandler(Level2Support);
        Level2Support.setNextHandler(Level3Support);
        Level3Support.setNextHandler(manager);

        // Lets create a ticket

        Level1Support.handleRequest("I want access to visual studio code", 4);
        
    }
}
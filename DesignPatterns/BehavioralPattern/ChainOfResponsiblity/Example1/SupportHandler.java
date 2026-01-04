package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.Example1;



abstract class SupportHandler{
    protected SupportHandler nextHandler;
    public void setNextHandler(SupportHandler nextHandler){
        this.nextHandler = nextHandler;
    }
    public abstract void handleRequest(String issue, int severity);
}
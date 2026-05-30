package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers;

import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.DTO.Request;

public class FinishingHandler implements RequestHandler {

    @Override
    public void handle(Request request) {
       System.out.println("DEAD END");
    }
    
}

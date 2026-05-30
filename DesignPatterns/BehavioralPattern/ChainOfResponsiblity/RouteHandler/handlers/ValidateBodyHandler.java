package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers;

import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.DTO.Request;

public class ValidateBodyHandler implements RequestHandler {
    
    private final RequestHandler nextHandler;
    
    public ValidateBodyHandler(RequestHandler nexRequestHandler){
        this.nextHandler = nexRequestHandler;
    }
    
    @Override
    public void handle(Request request) {
        System.out.println("Validate Body Handler is handling");

        this.nextHandler.handle(request);
    }
    
}

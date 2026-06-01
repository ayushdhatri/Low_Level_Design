package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers;

import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.DTO.Request;

public class AuthenticationHandlers implements RequestHandler {
    private final RequestHandler nextHandler;
    public AuthenticationHandlers(RequestHandler nexRequestHandler){
        this.nextHandler = nexRequestHandler;
    }
    
    @Override
    public void handle(Request request) {
        System.out.println("Authentication Handler is handling");

        this.nextHandler.handle(request);
        System.out.println("We can perform anything of our choice");
    }
    
}


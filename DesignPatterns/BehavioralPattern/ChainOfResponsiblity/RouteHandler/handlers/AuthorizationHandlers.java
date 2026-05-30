package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers;

import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.DTO.Request;

public class AuthorizationHandlers implements RequestHandler {

    
    private final RequestHandler nextHandler;
    public AuthorizationHandlers(RequestHandler nexRequestHandler){
        this.nextHandler = nexRequestHandler;
    }
    @Override
    public void handle(Request request) {
        System.out.println("Authorization Handler is handling");

        this.nextHandler.handle(request);
    }
}

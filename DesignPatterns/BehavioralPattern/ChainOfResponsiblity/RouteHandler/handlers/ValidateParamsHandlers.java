package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers;

import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.DTO.Request;

public class ValidateParamsHandlers implements RequestHandler{

    private final RequestHandler nextHandler;
    public ValidateParamsHandlers(RequestHandler nexRequestHandler){
        this.nextHandler = nexRequestHandler;
    }
    @Override
    public void handle(Request request) {
        System.out.println("Validate Params Handler is handling");
        this.nextHandler.handle(request);// so this is going to call the next handler
    }
}

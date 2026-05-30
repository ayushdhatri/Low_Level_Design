package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.controllers;

import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.DTO.Request;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.factory.RequestHandlerFactory;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers.AuthenticationHandlers;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers.AuthorizationHandlers;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers.FinishingHandler;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers.RequestHandler;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers.ValidateBodyHandler;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers.ValidateParamsHandlers;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.schema.Todo;

public class TodoController {
    /* 
    private AuthenticationHandlers authenticationHandlers;
    private AuthorizationHandlers authorizationHandlers;
    private ValidateBodyHandler validateBodyHandler;

    we are not going to do this way because it directly violates DI princple
    as controller class directly depends on concrete class 
    DI principle says that two concrete class should not depends on each other 
    instead they should depend upon abstraction
    */

    
    private Todo createTodo(Request request){
        // execute initial hnalder
        RequestHandler handler = RequestHandlerFactory.getHandlersForCreateTood();
        handler.handle(request);
        // return a new todo
        return new Todo();

    }
}

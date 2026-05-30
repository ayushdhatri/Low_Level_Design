package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.factory;

import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers.AuthenticationHandlers;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers.AuthorizationHandlers;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers.FinishingHandler;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers.RequestHandler;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers.ValidateBodyHandler;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.RouteHandler.handlers.ValidateParamsHandlers;

public class RequestHandlerFactory {
    public static RequestHandler getHandlersForCreateTood(){
           RequestHandler handler = new ValidateParamsHandlers(
            new ValidateBodyHandler(
                new AuthenticationHandlers(
                    new AuthorizationHandlers(new FinishingHandler())
                )
            ));

            return handler;
    }
}

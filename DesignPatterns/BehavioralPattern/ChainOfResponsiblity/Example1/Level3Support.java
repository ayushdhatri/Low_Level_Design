package Low_Level_Design.DesignPatterns.BehavioralPattern.ChainOfResponsiblity.Example1;

import java.util.*;


public class Level3Support extends SupportHandler{
    @Override
    public void handleRequest(String issue, int severity){
        if(severity == 3){
            System.out.println("Request is handled by Level3Support");
            System.out.println("Level2 Support has resolved the issue");
        }
        else{
            System.out.println("This request is passig to next handler");
            if(nextHandler == null){
                System.out.println("There is no handler avaialble for this request");
                return;
            }
            else{
                nextHandler.handleRequest(issue, severity);
            }

        }
    }
}
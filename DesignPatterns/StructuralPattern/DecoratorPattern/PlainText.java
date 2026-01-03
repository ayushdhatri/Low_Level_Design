package Low_Level_Design.DesignPatterns.StructuralPattern.DecoratorPattern;


import java.util.*;

public class PlainText implements Text{
    private String content;

    public PlainText(String txt){
        this.content = txt;

    }
    @Override
    public String getContent() {
        return this.content;
    }
    
    
}
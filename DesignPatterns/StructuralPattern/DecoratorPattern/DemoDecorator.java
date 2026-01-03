package Low_Level_Design.DesignPatterns.StructuralPattern.DecoratorPattern;


import java.util.*;

public class DemoDecorator {
    public static void main(String[] args){
       
        Text txt = new BoldDecorator(new PlainText("Hey Ayush"));
        System.out.println(txt.getContent());
    }
}
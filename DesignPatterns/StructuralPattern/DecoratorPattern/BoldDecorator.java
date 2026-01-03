package Low_Level_Design.DesignPatterns.StructuralPattern.DecoratorPattern;


import java.util.*;

public class BoldDecorator extends TextDecorator {

    protected BoldDecorator(Text txt) {
        super(txt);  
    }

    @Override
    public String getContent(){
        return "<b>" + wrapperText.getContent() + "</b>";
    }
    
}
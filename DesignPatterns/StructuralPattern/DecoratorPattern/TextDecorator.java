package Low_Level_Design.DesignPatterns.StructuralPattern.DecoratorPattern;


import java.util.*;

public abstract class TextDecorator implements Text {
    protected Text wrapperText;

    protected TextDecorator(Text txt){
        this.wrapperText = txt;
    }
    @Override
    public String getContent(){
        return wrapperText.getContent();
    }
}
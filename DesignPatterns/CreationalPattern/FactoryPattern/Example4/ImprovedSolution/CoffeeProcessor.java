package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example4.ImprovedSolution;

import Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example4.ImprovedSolution.*;


public class CoffeeProcessor {
    public Coffee prepareCoffee(String whichCoffee){
        Coffee coffee = new CoffeeFactory().getCoffee(whichCoffee);
        return coffee;
       
    }
    
}

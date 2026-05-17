package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example4.ImprovedSolution;

import Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example4.ImprovedSolution.*;


public class CoffeeProcessor {
    public Coffee prepareCoffee(String orderType, String theme){
       IngrediantCreatorFactory icf = null;
       if(theme.equals("Vegan")){
            icf = new VeganIngredientCreatorFactory();
       }
       Coffee coffee = null;
       if (orderType.equals("Latte")) {
            // We just create it directly now!
            coffee = new Latte(icf); 
        } 
        return coffee;
       
       
    }
    
}

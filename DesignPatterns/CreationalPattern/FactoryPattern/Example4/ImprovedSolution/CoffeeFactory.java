package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example4.ImprovedSolution;

public class CoffeeFactory {
    public Coffee getCoffee(String whichCoffee){
        Coffee coffee = null;
        if(whichCoffee.equals("Espresso")){
            coffee =  new Espresso();
       

        }
        else if(whichCoffee.equals("Latte")){
            coffee =  new Latte();
        

        }
        else if(whichCoffee.equals("Cappacino")){
            coffee =  new Cappacino();
            
            
        }
        return coffee;
    }
    
}

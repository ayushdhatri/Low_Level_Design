package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example4.Problematic;

/*
- This code is violating ocp principle.
- It is violating Depdency Inversion principle
 */
public class CoffeeProcessor {
    public Coffee prepareCoffee(String whichCoffee){
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

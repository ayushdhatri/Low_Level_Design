// package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example4.ImprovedSolution;

// public class CoffeeFactory {
//     public Coffee getCoffee(String whichCoffee, String whichMilk, String whichSugar, String whichCoffeeType){
//         Coffee coffee = null;
//         if(whichCoffee.equals("Espresso")){
//             coffee =  new Espresso();
       

//         }
//         else if(whichCoffee.equals("Latte")){
//             LatteCreatorFactory latteCreator = new LatteCreatorFactory(whichMilk, whichSugar);
//             coffee = new Latte(latteCreator);

//         }
//         else if(whichCoffee.equals("Cappacino")){
//             coffee =  new Cappacino();
            
            
//         }
//         return coffee;
//     }
    
// }

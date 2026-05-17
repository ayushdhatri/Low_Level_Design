package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example4.ImprovedSolution;

public class VeganIngredientCreatorFactory implements IngrediantCreatorFactory {

    @Override
    public Milk getMilk() {
        return new CowMilk();
    }

    @Override
    public Sugar getSugar() {
       return new BrownSugar();
    }
    
}

package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example4.ImprovedSolution;

public abstract class Coffee {
    Milk milk;
    Sugar sugar;
    

    IngrediantCreatorFactory icf;

    abstract void boil();

    abstract void freeze();

    abstract void brew();
    
} 

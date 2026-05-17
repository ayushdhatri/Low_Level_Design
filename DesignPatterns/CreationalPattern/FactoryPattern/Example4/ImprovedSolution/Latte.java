package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example4.ImprovedSolution;

public class Latte extends Coffee{
    

    Latte(IngrediantCreatorFactory lcf){
        this.icf = lcf;
    }

    @Override
    public void boil() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'boil'");
    }

    @Override
    public void freeze() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'freeze'");
    }

    @Override
    public void brew() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'brew'");
    }
    
    
}

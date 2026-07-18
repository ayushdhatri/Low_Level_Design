package Low_Level_Design.Problems.ECommerceLLD.services.filterService.strategies;

public class LessThanStrategy implements PriceComparisionStrategy {

    @Override
    public boolean compare(double productPrice, double filterPrice) {
       return productPrice < filterPrice;
    }
    
    
}

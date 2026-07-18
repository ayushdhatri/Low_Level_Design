package Low_Level_Design.Problems.ECommerceLLD.services.filterService.strategies;

public class GreaterThanStrategy implements PriceComparisionStrategy{

    @Override
    public boolean compare(double productPrice, double filterPrice) {
        return productPrice > filterPrice;
    }
    
    
}

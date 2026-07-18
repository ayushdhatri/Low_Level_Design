
 package Low_Level_Design.Problems.ECommerceLLD.services.filterService.strategies;

public interface PriceComparisionStrategy {
    boolean compare(double productPrice, double filterPrice);
}
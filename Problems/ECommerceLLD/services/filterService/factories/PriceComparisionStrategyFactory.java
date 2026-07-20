package Low_Level_Design.Problems.ECommerceLLD.services.filterService.factories;

import Low_Level_Design.Problems.ECommerceLLD.services.filterService.strategies.GreaterThanStrategy;
import Low_Level_Design.Problems.ECommerceLLD.services.filterService.strategies.LessThanStrategy;
import Low_Level_Design.Problems.ECommerceLLD.services.filterService.strategies.PriceComparisionStrategy;

public class PriceComparisionStrategyFactory {
    public static PriceComparisionStrategy create(String compaString){
        if(compaString.equals("greater")){
            return new GreaterThanStrategy();
        }
        else if(compaString.equals(compaString)){
            return new LessThanStrategy();
        }
        return null;
    }
    
}

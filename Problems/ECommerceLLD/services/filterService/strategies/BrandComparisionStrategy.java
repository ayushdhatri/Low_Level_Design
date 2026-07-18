package Low_Level_Design.Problems.ECommerceLLD.services.filterService.strategies;

import Low_Level_Design.Problems.ECommerceLLD.models.Brand;

public interface BrandComparisionStrategy {
    boolean compare(Brand brand, Brand compareBrand);
}

    

   

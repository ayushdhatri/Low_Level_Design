package Low_Level_Design.Problems.ECommerceLLD.services.filterService.strategies;

import Low_Level_Design.Problems.ECommerceLLD.models.Brand;

public class EqualToBrandStrategy implements BrandComparisionStrategy{

    @Override
    public boolean compare(Brand brand, Brand compareBrand) {
        return brand.getName().equalsIgnoreCase(compareBrand.getName());

        
    }
}


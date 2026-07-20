package Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.filters.strategies.BrandFilterStrategy;

import Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.models.Brand;

public class EqualBrandFilterStrategy implements BrandFilterStrategy {
    @Override
    public boolean compare(Brand brand, Brand brandToCompare) {
        return brand.getName().equalsIgnoreCase(brandToCompare.getName());
    }
    
}

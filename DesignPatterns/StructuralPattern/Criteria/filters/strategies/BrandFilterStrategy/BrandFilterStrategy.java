package Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.filters.strategies.BrandFilterStrategy;

import Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.models.Brand;

public interface BrandFilterStrategy {
    boolean compare(Brand brand, Brand brandToCompare);
}

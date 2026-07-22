package Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.filters;

import java.util.List;

import Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.filters.strategies.BrandFilterStrategy.BrandFilterStrategy;
import Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.models.Brand;
import Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.models.Product;

public class BrandFilterCriteria implements Criteria {
    private Brand brand;
    private BrandFilterStrategy brandFilterStrategy;
    // here we assign a fix brand to this class and it will be compared with rest of the products
    public BrandFilterCriteria(Brand brand, BrandFilterStrategy brandFilterStrategy){
        this.brand = brand;
        this.brandFilterStrategy = brandFilterStrategy;
    }

    @Override
    public List<Product> satisfy(List<Product> products) {
        return products.stream().filter(product -> brandFilterStrategy.compare(brand, product.getBrand())).toList();
    }

    
    
}

package Low_Level_Design.Problems.ECommerceLLD.services.filterService;

import java.util.List;

import Low_Level_Design.Problems.ECommerceLLD.models.Brand;
import Low_Level_Design.Problems.ECommerceLLD.models.Product;
import Low_Level_Design.Problems.ECommerceLLD.services.filterService.strategies.BrandComparisionStrategy;

public class BrandFilterCriteria implements Criteria {
    private final Brand brand;
    private final BrandComparisionStrategy brandComparisionStrategy;
    public BrandFilterCriteria(Brand brand, BrandComparisionStrategy brandComparisionStrategy){
        this.brand = brand;
        this.brandComparisionStrategy = brandComparisionStrategy;
    }


    @Override
    public List<Product> satisfy(List<Product> products) {
        return products.stream().filter(product-> brandComparisionStrategy.compare(product.getBrand(), this.brand)).toList();
    }
    
    
}

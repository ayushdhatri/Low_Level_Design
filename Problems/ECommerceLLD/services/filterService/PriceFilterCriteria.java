package Low_Level_Design.Problems.ECommerceLLD.services.filterService;

import java.util.List;

import Low_Level_Design.Problems.ECommerceLLD.models.Product;
import Low_Level_Design.Problems.ECommerceLLD.services.filterService.strategies.PriceComparisionStrategy;

public class PriceFilterCriteria implements Criteria{

    private final double price;
    private final PriceComparisionStrategy priceComparisionStrategy;

    public PriceFilterCriteria(double price, PriceComparisionStrategy priceComparisionStrategy){
        this.price = price;
        this.priceComparisionStrategy = priceComparisionStrategy;
    }

    @Override
    public List<Product> satisfy(List<Product> products) {
        return products.stream()
        .filter(product -> priceComparisionStrategy.compare(product.getPrice(), this.price)).toList();
        
        
    }
    
}

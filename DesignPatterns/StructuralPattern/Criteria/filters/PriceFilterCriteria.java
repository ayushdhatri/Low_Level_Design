package Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.filters;

import java.util.List;

import Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.filters.strategies.PriceFilterStrategy.PriceFilterStrategy;
import Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.models.Product;

public class PriceFilterCriteria implements Criteria {
    private final double price;
    private final PriceFilterStrategy priceFilterStrategy;

    public PriceFilterCriteria(double price, PriceFilterStrategy priceFilterStrategy){
        this.price = price;
        this.priceFilterStrategy = priceFilterStrategy;
    }

    @Override
    public List<Product> satisfy(List<Product> products) {
       return products.stream().filter(product -> priceFilterStrategy.compare(price, product.getPrice())).toList();
    }
}

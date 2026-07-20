package Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.filters;

import java.util.Arrays;
import java.util.List;

import Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.models.Product;

public class AndFilterCriteria implements Criteria {
    private final List<Criteria> criterias;
    public AndFilterCriteria(List<Criteria> criterias){
        this.criterias= criterias;
    }
    @Override
    public List<Product> satisfy(List<Product> products) {
        return products.stream().filter(product -> criterias.stream().allMatch(criteria -> !criteria.satisfy(List.of(product)).isEmpty())).toList();
    }
    
    
}

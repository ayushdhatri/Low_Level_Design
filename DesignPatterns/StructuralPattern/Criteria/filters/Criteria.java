package Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.filters;

import java.util.List;

import Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.models.Product;

public interface Criteria {
    List<Product> satisfy(List<Product> products);
}

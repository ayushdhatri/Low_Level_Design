package Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.filters.strategies.PriceFilterStrategy;

public interface PriceFilterStrategy {
    boolean compare(double price, double priceToCompare);
    
} 

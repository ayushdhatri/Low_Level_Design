package Low_Level_Design.DesignPatterns.StructuralPattern.Criteria.filters.strategies.PriceFilterStrategy;

public class LessThanPriceStrategy implements PriceFilterStrategy {
    @Override
    public boolean compare(double price, double priceToCompare) {
        return priceToCompare < price;
    }
    }

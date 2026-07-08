package Low_Level_Design.practice.parkinglot.models.pricing;

public class ConstantPricingStrategy implements PricingStrategy {
    private final int price;

    public ConstantPricingStrategy(int price){
        this.price = price;
    }

    @Override
    public int calculatePrice() {
       return price;
    }

    @Override
    public PricingStrategyType getPricingStrategyType() {
        return PricingStrategyType.CONSTANT;
    }
    
    
}

package Low_Level_Design.practice.parkinglot.models.pricing;

public class ConstantPricingStrategy implements PricingStategy {
    private final int price;

    public ConstantPricingStrategy(int price){
        this.price = price;
    }

    @Override
    public int calculatePrice() {
       return price;
    }
    
    
}

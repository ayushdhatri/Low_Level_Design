package Low_Level_Design.practice.parkinglot.models.pricing;

public class HourlyPricingStrategy implements PricingStategy{
    private final int pricePerHour;
    private int numberOfHours;

    public HourlyPricingStrategy(int pricePerHour){
        this.pricePerHour = pricePerHour;
    }

    @Override
    public int calculatePrice() {
        return pricePerHour * this.numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours){
        this.numberOfHours = numberOfHours;
    }
    
    
    
}

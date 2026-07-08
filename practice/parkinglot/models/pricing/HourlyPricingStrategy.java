package Low_Level_Design.practice.parkinglot.models.pricing;

public class HourlyPricingStrategy implements PricingStrategy{
    private final int pricePerHour;
    private long numberOfHours;

    public HourlyPricingStrategy(int pricePerHour, long numberOfHoursss){
        this.pricePerHour = pricePerHour;
        this.numberOfHours = numberOfHours;
    }

    @Override
    public int calculatePrice() {
        return (int) ((int)pricePerHour * this.numberOfHours);
    }

    public void setNumberOfHours(long numberOfHours){
        this.numberOfHours = numberOfHours;
    }

    @Override
    public PricingStrategyType getPricingStrategyType() {
       return PricingStrategyType.HOURLY;
    }

}

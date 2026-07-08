package Low_Level_Design.practice.parkinglot.services;

import java.util.List;

import Low_Level_Design.practice.parkinglot.config.serverConfig;
import Low_Level_Design.practice.parkinglot.helper.TimeHelper;
import Low_Level_Design.practice.parkinglot.models.pricing.HourlyPricingStrategy;
import Low_Level_Design.practice.parkinglot.models.pricing.PricingStrategy;
import Low_Level_Design.practice.parkinglot.models.pricing.PricingStrategyType;
import Low_Level_Design.practice.parkinglot.models.tickets.Ticket;

public class PricingService {

    public static long calculateParkingCharge(List<PricingStrategy> pricingStrategies, Ticket ticket){
         for(PricingStrategy pricingStrategy : pricingStrategies){
            if(pricingStrategy.getPricingStrategyType().equals(PricingStrategyType.HOURLY)){
                pricingStrategy = new HourlyPricingStrategy(serverConfig.PRICE_PER_HOUR,TimeHelper.converMilliSecondsToHour(existTime.get() - entryTime));
                
            }
        }
        Integer price = pricingStrategies.stream().map(ps -> ps.calculatePrice())
        .reduce(0,(a, b)-> a + b);
        System.out.println("price calculate is : " + price);
        if(ticket.getPaymentStrategy().isPresent()){
            ticket.getPaymentStrategy().get().pay(price);
        }
        else{
            System.out.println("No payment method is choosed");
        }


    }
    
}

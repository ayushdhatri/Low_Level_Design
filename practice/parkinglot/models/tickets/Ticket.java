package Low_Level_Design.practice.parkinglot.models.tickets;

import java.util.List;
import java.util.Optional;

import Low_Level_Design.practice.parkinglot.config.serverConfig;
import Low_Level_Design.practice.parkinglot.helper.TimeHelper;
import Low_Level_Design.practice.parkinglot.models.mobility.Vehicle;
import Low_Level_Design.practice.parkinglot.models.parking.ParkingSlot;
import Low_Level_Design.practice.parkinglot.models.payments.PaymentStrategy;
import Low_Level_Design.practice.parkinglot.models.pricing.HourlyPricingStrategy;
import Low_Level_Design.practice.parkinglot.models.pricing.PricingStrategy;
import Low_Level_Design.practice.parkinglot.models.pricing.PricingStrategyType;
import Low_Level_Design.practice.parkinglot.services.PricingService;

public class Ticket {
    private final Integer entryTime;
    private Optional<Integer> existTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private List<PricingStrategy> pricingStrategies;
    private Optional<PaymentStrategy> paymentStrategy;
    private final PricingService pricingService;

    public Ticket(Integer entryTime, Vehicle vehicle, ParkingSlot parkingSlot, List<PricingStrategy> pricingStrategies){
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.pricingStrategies = pricingStrategies;
        this.pricingService = new PricingService();
    }
    
    public void setExitTime(Integer exitTime){
        this.existTime = Optional.of(exitTime);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = Optional.of(paymentStrategy);
    }

    public Optional<PaymentStrategy> getPaymentStrategy(){
        return this.paymentStrategy;
    }
    
    public void calculateAndPay(){
        PricingService.calculateParkingCharge(pricingStrategies, this);

    }






    
}

package Low_Level_Design.practice.parkinglot.models.tickets;

import java.util.List;
import java.util.Optional;

import Low_Level_Design.practice.parkinglot.models.mobility.Vehicle;
import Low_Level_Design.practice.parkinglot.models.parking.ParkingSlot;
import Low_Level_Design.practice.parkinglot.models.payments.PaymentStrategy;
import Low_Level_Design.practice.parkinglot.models.pricing.PricingStrategy;

public class Ticket {
    private Integer entryTime;
    private Optional<Integer> existTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private List<PricingStrategy> pricingStrategies;
    private Optional<PaymentStrategy> paymentStrategy;

    public Ticket(Integer entryTime, Vehicle vehicle, ParkingSlot parkingSlot, List<PricingStrategy> pricingStrategies){
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.pricingStrategies = pricingStrategies;
    }
    
    public void setExitTime(Integer exitTime){
        this.existTime = Optional.of(exitTime);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = Optional.of(paymentStrategy);
    }
    
    public void calculateAndPay(){
        Integer price = pricingStrategies.stream().map(pricingStrategies -> pricingStrategies.calculatePrice())
        .reduce(0,(a, b)-> a + b);
        System.out.println("price calculate is : " + price);

        paymentStrategy.get().pay(price);
    }




    
}

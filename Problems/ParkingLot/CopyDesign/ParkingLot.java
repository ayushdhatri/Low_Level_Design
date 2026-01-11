package Low_Level_Design.Problems.ParkingLot.CopyDesign;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.Problems.ParkingLot.CopyDesign.entities.ParkingTicket;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.entities.ParkingFloor;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.entities.ParkingSpot;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.PaymentMethods.CreditCardPayment;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.PaymentMethods.PaymentStratergy;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.PaymentMethods.UpiPayment;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.fee.FeeStrategy;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.fee.FlatFeeStrategy;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.parking.BestFitStrategy;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.parking.ParkingStrategy;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.vehicle.Vehicle;

public class ParkingLot{
    private static ParkingLot instance;
    private final List<ParkingFloor> floors = new ArrayList<>();
    private final Map<String, ParkingTicket> activeTickets;
    private FeeStrategy feeStrategy;
    private ParkingStrategy parkingStrategy;
    private PaymentStratergy paymentStratergy;

    private ParkingLot(){
        this.feeStrategy = new FlatFeeStrategy();
        this.parkingStrategy = new BestFitStrategy();
        this.activeTickets = new ConcurrentHashMap<>();
    }

    public static synchronized ParkingLot getInstance(){
        if(instance == null){
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }
    public void setFeeStrategy (FeeStrategy feeStrategy){
        this.feeStrategy = feeStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy){
        this.parkingStrategy = parkingStrategy;
    }

    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle){
        Optional<ParkingSpot> availableSpot = parkingStrategy.findSpot(floors, vehicle);

        if(availableSpot.isPresent()){
            ParkingSpot spot = availableSpot.get();
            spot.parkVehicle(vehicle);
            ParkingTicket ticket = new ParkingTicket(vehicle, spot);
            activeTickets.put(vehicle.getLicenseNumber(), ticket);
            System.out.printf("%s parked at %s. Ticket: %s\n", vehicle.getLicenseNumber(), spot.getSpotId(), ticket.getTicketId());
            return Optional.of(ticket);

        }
        System.out.println("No available spot for " + vehicle.getLicenseNumber());
        return Optional.empty();

    }

    public Optional<Double> unparkVehicle(String licenseNumber){
        ParkingTicket ticket = activeTickets.remove(licenseNumber);
        if(ticket == null){
            System.out.println("Ticket not found");
            return Optional.empty();
        }

        ticket.setExitTimestamp();
        ticket.getSpot().unparkVehicle();

        Double parkingFee  =  feeStrategy.calculateFee(ticket);
        paymentStratergy = new UpiPayment("123123");
        paymentStratergy.pay(parkingFee);
        return Optional.of(parkingFee);
    }
    
}
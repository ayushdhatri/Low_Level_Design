package Low_Level_Design.practice.parkinglot1.models.ticket;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import Low_Level_Design.practice.parkinglot1.models.mobility.Vehicle;
import Low_Level_Design.practice.parkinglot1.models.parking.ParkingSpot;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final Long  entryTime;
    private  Optional<Long> exitTime;


    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot){
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        entryTime = new Date().getTime();
        this.exitTime = Optional.empty();
    }

    public String getTicketId(){
        return this.ticketId;
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public Optional<Long> getExitTime(){
        return this.exitTime;
    }

    
}

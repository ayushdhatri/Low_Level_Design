package Low_Level_Design.practice.AirlineManagementSystem.models;

import Low_Level_Design.practice.AirlineManagementSystem.enums.FlightSeatStatus;
import Low_Level_Design.practice.AirlineManagementSystem.enums.Seat;

public class FlightSeat {
    private final String flightSeatId;
    private final Seat seat;
    private FlightSeatStatus status;
    public double price;

    public FlightSeat(String flightSeatId, Seat seat){
        this.flightSeatId = flightSeatId;
        this.seat = seat;
        this.status = FlightSeatStatus.AVAILABLE;
        this.price = seat.getSeatType().getPrice();
    } 

    public void updatePrice(double price){
        this.price = price;
    }

    public String getFlightSeatId(){
        return this.flightSeatId;
    }
    public FlightSeatStatus getFlightSeatStatus(){
        return this.status;
    }

    public void setFlightSeatStatus(FlightSeatStatus newStatus){
        this.status = newStatus;
    }




    
}

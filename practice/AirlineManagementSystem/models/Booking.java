package Low_Level_Design.practice.AirlineManagementSystem.models;

import java.util.List;

// ideall we should implment builder pattern for constructing this object
public class Booking {
    private final String bookingId;
    private final String pnr;
    private final User user;
    private final List<FlightSeat> seats;
    private final String flightId;
    public final double totalAmount;

    public Booking(String bookingId, User user, List<FlightSeat> seats, String flightId, double totalAmount){
        this.bookingId = bookingId;
        this.pnr = bookingId + "_" + user.getUserId();
        this.user = user;
        this.seats = seats;
        this.flightId = flightId;
        this.totalAmount = totalAmount;
    }

    public String getBookingId(){
        return this.bookingId;
    }
    public User getUser(){return this.user;}
    public List<FlightSeat> getBookedSeats(){return this.seats;}
    public String getFlightId(){
        return this.flightId;
    }
    public double getTotalAmount(){
        return this.totalAmount;
    }
    public String getPnr(){
        return this.pnr;
    }
}

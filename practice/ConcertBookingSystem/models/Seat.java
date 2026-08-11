package Low_Level_Design.practice.ConcertBookingSystem.models;

import Low_Level_Design.practice.ConcertBookingSystem.enums.SeatStatusType;
import Low_Level_Design.practice.ConcertBookingSystem.enums.SeatType;

public class Seat {
    private String seatId;
    private final SeatType type;
    private double price;
    private SeatStatusType status;

    public Seat(String seatId, SeatType type, double price){
        this.seatId = seatId;
        this.type = type;
        this.price = price;
        this.status = SeatStatusType.AVAILABLE;
    }

    public String getSeatId(){
        return this.seatId;
    }

    public SeatType getSeatType(){
        return this.type;
    }

    public double getSeatPrice(){
        return this.price;
    }
    // we can provide this extra function to set the price, because it might be the case that at last momemnt due to more 
    // bookings we have to increase the price per seat
    public void setPrice(double price){
        this.price = price;
    }

    public SeatStatusType getSeatStatusType(){
        return this.status;
    }

    public void setSeatStatusType(SeatStatusType status){
        this.status = status;
    }
    
}

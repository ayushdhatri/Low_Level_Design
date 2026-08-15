package Low_Level_Design.practice.MovieBooking.models.Theater;

import Low_Level_Design.practice.MovieBooking.enums.SeatType;

public class Seat {
    private final String seatId;
    private final SeatType type;

    public Seat(String seatId, SeatType seatType){
        this.seatId = seatId;
        this.type = seatType;
    }

    public String getSeatId(){
        return this.seatId;
    }
    
    public SeatType getSeatType(){
        return this.type;
    }

    public double getPrice(){
        return this.type.getTicketPrice();
    }
}

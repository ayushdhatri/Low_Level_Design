package Low_Level_Design.practice.AirlineManagementSystem.enums;

public class Seat {
    private final String seatId;
    private final SeatType seatType;
    public Seat(String seatId, SeatType type){
        this.seatId = seatId;
        this.seatType = type;
    }

    public String getSeatId(){
        return this.seatId;
    }

    public SeatType getSeatType(){
        return this.seatType;
    }
    

    
}

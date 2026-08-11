package Low_Level_Design.practice.ConcertBookingSystem.exception;

public class SeatNotAvailable extends RuntimeException {
    public SeatNotAvailable(String message){
        super(message);
    }
}

package Low_Level_Design.practice.AirlineManagementSystem.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Hold {
    private final String holdId;
    private User user;
    private final List<FlightSeat> requestSeats;
    private LocalDateTime expiresAt;
    public Object flightInsId;

    public Hold(String holdId, User user, List<FlightSeat> seats, int ttl){
        this.holdId = holdId;
        this.user = user;
        this.requestSeats = seats;
        this.expiresAt = LocalDateTime.now().plusSeconds(ttl);
    }

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expiresAt);
    }

    public String getHoldId(){
        return this.holdId;
    }

    public User getUser(){
        return this.user;
    }

    public List<FlightSeat> getRequestedSeats(){
        return this.requestSeats;
    }

    public double getTotal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotal'");
    }
    
}

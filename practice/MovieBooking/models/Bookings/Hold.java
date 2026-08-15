package Low_Level_Design.practice.MovieBooking.models.Bookings;

import java.time.LocalDateTime;
import java.util.List;

import Low_Level_Design.practice.MovieBooking.models.Theater.ShowSeat;
import Low_Level_Design.practice.MovieBooking.models.Users.User;

public class Hold {
    private String holdId;
    private String showId;
    private final User user;
    private List<ShowSeat> heldSeats;
    private final LocalDateTime expiresAt;

    public Hold(String holdId, User user ,String showId, List<ShowSeat> heldSeats, int ttlSeconds){
        this.holdId = holdId;
        this.user = user;
        this.showId = showId;
        this.heldSeats = heldSeats;
        this.expiresAt = LocalDateTime.now().plusSeconds(ttlSeconds);
    }

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expiresAt);
    }

    public double calculateTotal(){
        return heldSeats.stream().mapToDouble(ShowSeat::getPrice).sum();
    }

    public String getHoldId() { return holdId; }
    public User getUser() { return user; }
    public String getShowId() { return showId; }
    public List<ShowSeat> getHeldSeats() { return heldSeats; }
    
}

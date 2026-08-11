package Low_Level_Design.practice.ConcertBookingSystem.state;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import Low_Level_Design.practice.ConcertBookingSystem.models.Seat;
import Low_Level_Design.practice.ConcertBookingSystem.models.User;

public class Hold {
    private String holdId;
    private final User user;
    private final String concertId;
    private final List<Seat> heldSeats;
    private final LocalDateTime expiresAt;
    
    public Hold(String holdId, User user, String concertId, List<Seat> heldSeats, int ttlSeconds) {
        this.holdId = holdId;
        this.user = user;
        this.concertId = concertId;
        this.heldSeats = heldSeats;
        this.expiresAt = LocalDateTime.now().plusSeconds(ttlSeconds);
    }

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expiresAt);
    }

    public String getHoldId() { return holdId; }
    public User getUser() { return user; }
    public String getConcertId() { return concertId; }
    public List<Seat> getHeldSeats() { return heldSeats; }

    public double calculateTotal() {
        return heldSeats.stream().mapToDouble(seat -> seat.getSeatPrice()).sum();
    }

    
}

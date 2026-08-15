package Low_Level_Design.practice.ConcertBookingSystem.models;

import java.time.LocalDateTime;
import java.util.List;

public class Concert {
    private final String concertId;
    private final String name;
    private final String venue;
    private final String artist;
    private final LocalDateTime time;
    private final List<Seat> concertSeats;

    public Concert(String concertId, String name, String venue, String artist, LocalDateTime time,List<Seat> concertSeats){
        this.concertId = concertId;
        this.name = name;
        this.venue = venue;
        this.artist = artist;
        this.time = time;
        this.concertSeats = concertSeats;
    }
    public String getConcertId() { return concertId; }
    public String getName() { return name; }
    public String getVenue() { return venue; }
    public String getArtist() { return artist; }
    public LocalDateTime getTime() { return time; }
    public List<Seat> getConcertSeats() { return concertSeats; }


    
}


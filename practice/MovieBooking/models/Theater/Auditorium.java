package Low_Level_Design.practice.MovieBooking.models.Theater;


import java.util.Set;

public class Auditorium {
    private final String audiId;
    private final String audiName;
    private final Set<Seat> seats;

    public Auditorium(String audiId, String audiName, Set<Seat> seats){
        this.audiId = audiId;
        this.audiName = audiName;
        this.seats = seats;
    }

    public void addSeat(Seat seat){
        this.seats.add(seat);
    }

    public String getAudiId(){
        return this.audiId;
    }

    public String getAudiName(){
        return this.audiName;
    }

    public Set<Seat> getSeats(){
        return this.seats;
    }

}


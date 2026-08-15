package Low_Level_Design.practice.MovieBooking.models.Theater;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Show {
    private final String showId;
    private LocalDateTime showTiming;
    private final Auditorium auditorium;
    private final Movie movie;
    private final Map<String, ShowSeat> showSeatMap = new ConcurrentHashMap<>();

    public Show(String showId, LocalDateTime showTiming, Auditorium auditorium, Movie movie){
        this.showId = showId;
        this.showTiming = showTiming;
        this.auditorium = auditorium;
        this.movie = movie;

        // A clever trick while creatint show you pass me the auditorium details, from which 
        // I will fetch all the seats and initialize my show seat;

        for(Seat physicalSeat : auditorium.getSeats()){
            ShowSeat showSeat = new ShowSeat(showId + "_" + physicalSeat.getSeatId(),
            physicalSeat,
            physicalSeat.getPrice());

            showSeatMap.put(physicalSeat.getSeatId(), showSeat);
        }
    }

    public String getShowId() { return showId; }
    public LocalDateTime getShowTiming() { return showTiming; }
    public Auditorium getAuditorium() { return auditorium; }
    public Movie getMovie() { return movie; }
    public Map<String, ShowSeat> getShowSeatMap() { return showSeatMap; }
}

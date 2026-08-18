package Low_Level_Design.practice.AirlineManagementSystem.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.practice.AirlineManagementSystem.enums.Seat;

public class FlightInstance{
    public final String flightInsId, source, dest;
    public final LocalDate date;
    public final Map<String, FlightSeat> seatMap = new ConcurrentHashMap<>();    
    
    public FlightInstance(String id, String src, String dest, LocalDate date, List<Seat> seats){
        this.flightInsId = id;
        this.source = src;
        this.dest = dest;
        this.date = date;
        for(Seat seat : seats){
            seatMap.put(seat.getSeatId(), new FlightSeat(id + "_" + seat.getSeatId(), seat));
        }
    }


}
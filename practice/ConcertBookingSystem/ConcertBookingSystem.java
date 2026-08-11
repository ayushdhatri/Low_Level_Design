package Low_Level_Design.practice.ConcertBookingSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import Low_Level_Design.SOLID.OpenCloseResponsiblity.ImprovedCode.SmsNotification;
import Low_Level_Design.practice.ConcertBookingSystem.enums.SeatStatusType;
import Low_Level_Design.practice.ConcertBookingSystem.exception.SeatNotAvailable;
import Low_Level_Design.practice.ConcertBookingSystem.models.Booking;
import Low_Level_Design.practice.ConcertBookingSystem.models.Concert;
import Low_Level_Design.practice.ConcertBookingSystem.models.Seat;
import Low_Level_Design.practice.ConcertBookingSystem.models.User;
import Low_Level_Design.practice.ConcertBookingSystem.observer.EmailNotificationObserver;
import Low_Level_Design.practice.ConcertBookingSystem.observer.EventNotifier;
import Low_Level_Design.practice.ConcertBookingSystem.observer.SMSNotificationObserver;
import Low_Level_Design.practice.ConcertBookingSystem.state.Hold;

public class ConcertBookingSystem {
    private final Map<String, Concert> concerts = new ConcurrentHashMap<>();
    private final Map<String, Booking> bookings = new ConcurrentHashMap<>();
    private final Map<String, Hold> activeHolds = new ConcurrentHashMap<>();

    private final Map<String, ReentrantLock> concertLocks = new ConcurrentHashMap<>();
    private final PaymentProcessor paymentProcessor = new PaymentProcessor();
    private final EventNotifier notifier = new EventNotifier();

    public ConcertBookingSystem(){
        notifier.subscribe(new EmailNotificationObserver());
        notifier.subscribe(new SMSNotificationObserver());
    }

    public void addConcert(Concert concert){
        concerts.put(concert.getConcertId(), concert);
        concertLocks.put(concert.getConcertId(), new ReentrantLock());
    }

    public List<Concert> searchConcert(String artist, String venue, LocalDate date){
        List<Concert> results = new ArrayList<>();
        for(Concert concert : concerts.values()){
            if(concert.getArtist().equalsIgnoreCase(artist) &&
            concert.getVenue().equalsIgnoreCase(venue) &&
            concert.getTime().toLocalDate().equals(date)){
                results.add(concert);
            }
        }
        return results;
    }

    public Hold createHold(User user, String concertId, List<String> seatIds, int ttlSeconds){

        Concert concert = concerts.get(concertId);
        if(concert == null){
            throw new IllegalArgumentException("Concert not found.");
        }

        ReentrantLock lock = concertLocks.get(concertId);
        lock.lock();
        try{
            List<Seat> seatToHold = new ArrayList<>();
            // validate availability
            List<Seat> concertSeats = concert.getConcertSeats();
            for(Seat seat :concertSeats){
                if(seatIds.contains(seat.getSeatId())){
                    if(seat.getSeatStatusType() != SeatStatusType.AVAILABLE){
                        throw new SeatNotAvailable("Seat with id " + seat.getSeatId() + " is not available for booking");
                    }
                }
                seatToHold.add(seat);
            }

            if(seatToHold.size() != seatIds.size()){
                throw new IllegalArgumentException("One or more request seat is not avaialbe");
            }

            for(Seat seat : seatToHold){
                seat.setSeatStatusType(SeatStatusType.HELD);
            }

            String holdId = "Hold_" + UUID.randomUUID().toString().substring(0, 8);
            Hold hold = new Hold(holdId, user, concertId, seatToHold, ttlSeconds);
            activeHolds.put(holdId, hold);
            System.out.println("[System] Created Hold: " + holdId + " for " + seatToHold.size() + " seat(s). TTL: " + ttlSeconds + "s");

            return hold;
        }
        finally{
            lock.unlock();
        }
    }



    
    
}

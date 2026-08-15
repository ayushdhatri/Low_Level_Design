package Low_Level_Design.practice.MovieBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import Low_Level_Design.practice.MovieBooking.enums.ShowSeatStatus;
import Low_Level_Design.practice.MovieBooking.models.Bookings.Booking;
import Low_Level_Design.practice.MovieBooking.models.Bookings.Hold;
import Low_Level_Design.practice.MovieBooking.models.Theater.Show;
import Low_Level_Design.practice.MovieBooking.models.Theater.ShowSeat;
import Low_Level_Design.practice.MovieBooking.models.Users.User;
import Low_Level_Design.practice.MovieBooking.observer.EmailNotification;
import Low_Level_Design.practice.MovieBooking.observer.EventNotifier;
import Low_Level_Design.practice.MovieBooking.observer.SMSNotification;
import Low_Level_Design.practice.MovieBooking.strategy.paymentStrategy.PaymentProcessor;
import Low_Level_Design.practice.MovieBooking.strategy.paymentStrategy.PaymentStrategy;

/**
 * MovieBookingSystem
 */
public class MovieBookingSystem {
    private final TheatreManager theatreManager = new TheatreManager();
    private final Map<String, Show> shows = new ConcurrentHashMap<>();
    private final Map<String, Booking> bookings = new ConcurrentHashMap<>();
    private final Map<String, Hold> activeHolds = new ConcurrentHashMap<>();
    
    private final Map<String, ReentrantLock> showLocks = new ConcurrentHashMap<>();

    private final PaymentProcessor paymentProcessor = new PaymentProcessor();
    private final EventNotifier notifier = new EventNotifier();

    public MovieBookingSystem(){
        notifier.subscribe(new EmailNotification());
        notifier.subscribe(new SMSNotification());
    }

    public TheatreManager getTheatreManager() { return theatreManager; }

    public void addShow(Show show){
        shows.put(show.getShowId(), show);
        showLocks.put(show.getShowId(), new ReentrantLock());
    }

    public Hold createHold(User user, String showId, List<String> seatIds, int ttlSeconds){
        Show show = shows.get(showId);
        if(show == null){
            throw new IllegalArgumentException("Show not found : ");
        }
        ReentrantLock lock = showLocks.get(showId);
        lock.lock();
        try{
            List<ShowSeat> seatsToHold = new ArrayList<>();
            // 1. Validate seat availability using O(1) Map lookup
            for (String seatId : seatIds) {
                ShowSeat showSeat = show.getShowSeatMap().get(seatId);
                if (showSeat == null) {
                    throw new IllegalArgumentException("Seat " + seatId + " does not exist for this show.");
                }
                if (showSeat.getShowSeatStatus() != ShowSeatStatus.AVAILABLE) {
                    throw new IllegalStateException("Seat " + seatId + " is no longer available.");
                }
                seatsToHold.add(showSeat);
            }

            // 2. Flip status to HELD
            for (ShowSeat showSeat : seatsToHold) {
                showSeat.setShowSeatStatus(ShowSeatStatus.HELD);
            }

            // 3. Create Hold record
            String holdId = "HOLD_" + UUID.randomUUID().toString().substring(0, 8);
            Hold hold = new Hold(holdId, user, showId, seatsToHold, ttlSeconds);
            activeHolds.put(holdId, hold);

            System.out.println("[System] Created Hold: " + holdId + " for " + seatsToHold.size() + " seat(s). TTL: " + ttlSeconds + "s");
            return hold;

        }
        finally{
            lock.unlock();
        }
        
    }

    public Booking confirmBooking(String holdId, PaymentStrategy strategy){
        Hold hold = activeHolds.get(holdId);
        if (hold == null || hold.isExpired()) {
            if (hold != null) cancelHold(holdId);
            throw new IllegalStateException("Hold has expired or is invalid.");
        }
        double totalAmount = hold.calculateTotal();
        boolean paymentSuccess = paymentProcessor.processPayment(strategy, totalAmount);

        if (!paymentSuccess) {
            cancelHold(holdId);
            throw new RuntimeException("Payment Failed. Reservation released.");
        }

        ReentrantLock lock = showLocks.get(hold.getShowId());
        lock.lock();

        try{
            // Re-validate hold hasn't been removed/cancelled concurrently
            if (!activeHolds.containsKey(holdId)) {
                throw new IllegalStateException("Hold was cancelled during payment processing.");
            }

            // Transition seats HELD -> BOOKED
            for (ShowSeat showSeat : hold.getHeldSeats()) {
                showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            }

            String bookingId = "BK_" + UUID.randomUUID().toString().substring(0, 8);
            Booking booking = new Booking(bookingId, hold.getUser(), hold.getShowId(), hold.getHeldSeats(), totalAmount);

            bookings.put(bookingId, booking);
            hold.getUser().addBooking(booking);
            activeHolds.remove(holdId);

            System.out.println("[System] Booking Confirmed! ID: " + bookingId);
            notifier.update(booking);

            return booking;
        }
        finally{
            lock.unlock();
        }

    }

    void cancelHold(String holdId){

    }
}
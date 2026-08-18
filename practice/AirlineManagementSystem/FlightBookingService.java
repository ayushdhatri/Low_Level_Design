package Low_Level_Design.practice.AirlineManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import Low_Level_Design.practice.AirlineManagementSystem.enums.FlightSeatStatus;
import Low_Level_Design.practice.AirlineManagementSystem.enums.Seat;
import Low_Level_Design.practice.AirlineManagementSystem.models.Booking;
import Low_Level_Design.practice.AirlineManagementSystem.models.FlightInstance;
import Low_Level_Design.practice.AirlineManagementSystem.models.FlightSeat;
import Low_Level_Design.practice.AirlineManagementSystem.models.Hold;
import Low_Level_Design.practice.AirlineManagementSystem.models.User;
import Low_Level_Design.practice.AirlineManagementSystem.strategy.PaymentStrategy;

public class FlightBookingService {
    private final Map<String, FlightInstance> flightInstances = new ConcurrentHashMap<>();
    private final Map<String, Hold> activeHolds = new ConcurrentHashMap<>();// we are going to map holdId with hold Object with expiration
    private final Map<String, Booking> bookings = new ConcurrentHashMap<>(); // we are going to map booking id with booking object
    
    private final Map<String, ReentrantLock> lockPerFlightInstance = new ConcurrentHashMap<>();// we map flightIntanceid with locks

    public void addInstance(FlightInstance instance){
        this.flightInstances.put(instance.getFlightInsId(), instance);
        this.lockPerFlightInstance.put(instance.getFlightInsId(), new ReentrantLock());
    }

    public Hold createHold(User user,String flightInsId, List<String> seatIds){
        // mostly we have to change the flight seat status to hold and 
        // create hold and return to user
        FlightInstance inst = flightInstances.get(flightInsId);
        if(inst == null){
            // we should do exceptino handling to handle this issue
            return null;
        }
        ReentrantLock lock = lockPerFlightInstance.get(flightInsId);
        lock.lock();
        try{
            List<FlightSeat> seatsToHold = new ArrayList<>();
            for(String sId : seatIds){
                FlightSeat seat = inst.seatMap.get(sId);
                if(seat == null || seat.getFlightSeatStatus() != FlightSeatStatus.AVAILABLE){
                    throw new IllegalStateException("Seat " + sId + " unavaialble");
                }
                seatsToHold.add(seat);
            }
            for(FlightSeat seat : seatsToHold){
                seat.setFlightSeatStatus(FlightSeatStatus.HOLD);
            }
            Hold hold  = new Hold("Hold_" + UUID.randomUUID().toString().substring(0,8), user, seatsToHold, 300);
            activeHolds.put(hold.getHoldId(), hold);
            return hold;

        }
        finally{
            lock.unlock();
        }
    }
    
   public Booking confirmBooking(String holdId, PaymentStrategy payment) {
        Hold hold = activeHolds.get(holdId);
        if (hold == null) throw new IllegalStateException("Invalid/Expired hold.");

        double total = hold.getTotal();
        if (!payment.pay(total)) throw new RuntimeException("Payment failed.");

        ReentrantLock lock = lockPerFlightInstance.get(hold.flightInsId);
        lock.lock();
        try {
            for (FlightSeat seat : hold.getRequestedSeats()) seat.setFlightSeatStatus(FlightSeatStatus.BOOKED);

            Booking booking = null;
            activeHolds.remove(holdId);
            System.out.println("[SUCCESS] Booking confirmed! PNR: "  + " for " + hold.getUser().getName());
            return booking;
        } finally {
            lock.unlock();
        }
    }



    
}
